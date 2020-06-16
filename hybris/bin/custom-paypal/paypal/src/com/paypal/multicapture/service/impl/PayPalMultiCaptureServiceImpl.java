package com.paypal.multicapture.service.impl;

import com.paypal.hybris.data.PaymentStatus;
import de.hybris.platform.core.enums.OrderStatus;
import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.orderprocessing.model.OrderProcessModel;
import de.hybris.platform.payment.dto.TransactionStatus;
import de.hybris.platform.payment.dto.TransactionStatusDetails;
import de.hybris.platform.payment.enums.PaymentTransactionType;
import de.hybris.platform.payment.model.PaymentTransactionEntryModel;
import de.hybris.platform.payment.model.PaymentTransactionModel;
import de.hybris.platform.processengine.BusinessProcessEvent;
import de.hybris.platform.processengine.BusinessProcessService;
import de.hybris.platform.processengine.model.ProcessTaskModel;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.i18n.CommonI18NService;
import de.hybris.platform.servicelayer.model.ModelService;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;

import org.apache.log4j.Logger;

import com.paypal.hybris.commands.strategy.CaptureStrategy;
import com.paypal.hybris.constants.PaypalConstants;
import com.paypal.hybris.data.DoCaptureRequestData;
import com.paypal.hybris.data.DoCaptureResultData;
import com.paypal.hybris.order.process.OrderCompleteProcessService;
import com.paypal.hybris.payment.service.PayPalPaymentService;
import com.paypal.multicapture.service.PayPalMultiCaptureService;

import urn.ebay.apis.eBLBaseComponents.AckCodeType;
import urn.ebay.apis.eBLBaseComponents.CompleteCodeType;


public class PayPalMultiCaptureServiceImpl implements PayPalMultiCaptureService {
    private static final Logger LOG = Logger.getLogger(PayPalMultiCaptureServiceImpl.class);

	private static final String CHOICE_ORDER_CAPTURED_FULLY = "ORDER_CAPTURED_FULLY";

	private PayPalPaymentService payPalPaymentService;
	private ModelService modelService;
	private ConfigurationService configurationService;
	private OrderCompleteProcessService orderCompleteProcessService;
	private CommonI18NService commonI18NService;
	private CaptureStrategy captureStrategy;
	private BusinessProcessService businessProcessService;

	@Override
	public DoCaptureResultData doMultiCapture(final OrderModel order, final String captureAmount, final String transactionId,
			final String completeType)
	{
		final boolean isCompleteType = isCompleteType(completeType);
		final Locale locale = getCommonI18NService().getLocaleForLanguage(order.getLanguage());

		final DoCaptureRequestData request = new DoCaptureRequestData();
		request.setAmount(Double.valueOf(captureAmount).doubleValue());
		request.setAuthorizationId(transactionId);
		request.setComplete(Boolean.valueOf(isCompleteType));
		request.setCurrencyIsoCode(order.getCurrency().getIsocode());

		request.setLocale(locale);

		final DoCaptureResultData resultData = payPalPaymentService.doCapture(request);

		return resultData;
	}

	@Override
	public void createMultiCaptureTransaction(final OrderModel order, final DoCaptureResultData resultData)
	{
		if (order.getPaymentTransactions().size() > 0)
		{
			final PaymentTransactionModel paymentTransactionModel = order.getPaymentTransactions().get(0);
			final PaymentTransactionEntryModel entry = getModelService().create(PaymentTransactionEntryModel.class);
			final String code = PaypalConstants.PAYMENT_PROVIDER_NAME + "_partial_capture_stamp_" + System.currentTimeMillis();
			entry.setCode(code);
			entry.setCurrency(order.getCurrency());
			entry.setTime(resultData.getDateTime().getTime());
			entry.setAmount(new BigDecimal(resultData.getAmount()));
			entry.setPaymentTransaction(paymentTransactionModel);
			entry.setType(PaymentTransactionType.CAPTURE);
			entry.setRequestId(resultData.getTransactionId());
			if (resultData.getErrors() == null || resultData.getErrors().isEmpty())
			{
				entry.setTransactionStatus(TransactionStatus.ACCEPTED.toString());
				entry.setTransactionStatusDetails(TransactionStatusDetails.SUCCESFULL.toString());
			}
			else
			{
				entry.setTransactionStatus(TransactionStatus.ERROR.toString());
				entry.setTransactionStatusDetails(TransactionStatusDetails.INVALID_REQUEST.toString());
			}
			getModelService().saveAll(entry, paymentTransactionModel, order);
			getModelService().refresh(order);
		}

		if (AckCodeType.SUCCESS.name().equalsIgnoreCase(resultData.getAck())) {
		    completeOrderIfNeeded(order);
		}
	}

	private void completeOrderIfNeeded(final OrderModel order)
	{
		BigDecimal capturedAmount = BigDecimal.ZERO;
		for (final PaymentTransactionModel paymentTransaction : order.getPaymentTransactions())
		{
			for (final PaymentTransactionEntryModel entry : paymentTransaction.getEntries())
			{
				if (PaymentTransactionType.CAPTURE.equals(entry.getType())
						&& TransactionStatus.ACCEPTED.name().equals(entry.getTransactionStatus()))
				{
					capturedAmount = capturedAmount.add(entry.getAmount());
				}
			}
		}

        final BigDecimal roundedCapturedAmount = capturedAmount.setScale(2, RoundingMode.HALF_UP);
        LOG.info("roundedCapturedAmount: " + roundedCapturedAmount);

		if (OrderStatus.PAYMENT_NOT_CAPTURED.equals(order.getStatus()) &&
				roundedCapturedAmount.compareTo(BigDecimal.valueOf(order.getTotalPrice())) >= 0)
		{
			order.setStatus(OrderStatus.PAYMENT_CAPTURED);
			modelService.save(order);

            for (OrderProcessModel opm : order.getOrderProcess()) {
                for (ProcessTaskModel ptm : opm.getCurrentTasks()) {
                    if (PaypalConstants.ORDER_PROCESS_ACTION_WAITFORTAKEPAYMENT.equals(ptm.getAction())) {
                        String eventName = ptm.getProcess().getCode() + PaypalConstants.EVENT_CONTINUE_ORDER_WITH_CHOICE;

                        LOG.error("To continue hybris order-process, issuing event: " + eventName + "." + CHOICE_ORDER_CAPTURED_FULLY);
                        final BusinessProcessEvent event = BusinessProcessEvent.builder(eventName).withChoice(CHOICE_ORDER_CAPTURED_FULLY).build();
                        businessProcessService.triggerEvent(event);
                    }
                }
            }
		} else {
		    LOG.info("Not yet Captured 100-115% of Order Total");
		}
	}


	private boolean isCompleteType(final String completeType)
	{
		return CompleteCodeType.COMPLETE.toString().equals(completeType);
	}

	@Override
	public boolean isValidTransactionId(final OrderModel order, final String transactionId) {

        boolean result = false;

        for (final PaymentTransactionModel paymentTransactionModel : order.getPaymentTransactions())
        {
            for (final PaymentTransactionEntryModel paymentTransactionEntryModel : paymentTransactionModel.getEntries()) {

                if ((
                        (paymentTransactionEntryModel.getType() == PaymentTransactionType.AUTHORIZATION
                          &&
                         TransactionStatus.ACCEPTED.name().equals(paymentTransactionEntryModel.getTransactionStatus()))
                        ||
                        (paymentTransactionEntryModel.getType() == PaymentTransactionType.ORDER
                          &&
                         PaymentStatus.PENDING.name().equals(paymentTransactionEntryModel.getTransactionStatus()))
                     )
                     &&
                     paymentTransactionEntryModel.getRequestId().equals(transactionId))
                {
                    result = true;
                }
            }
        }

        return result;
	}

	/**
	 * @return the payPalPaymentService
	 */
	public PayPalPaymentService getPayPalPaymentService()
	{
		return payPalPaymentService;
	}

	/**
	 * @param payPalPaymentService
	 *           the payPalPaymentService to set
	 */
	public void setPayPalPaymentService(final PayPalPaymentService payPalPaymentService)
	{
		this.payPalPaymentService = payPalPaymentService;
	}

	/**
	 * @return the modelService
	 */
	public ModelService getModelService()
	{
		return modelService;
	}

	/**
	 * @param modelService
	 *           the modelService to set
	 */
	public void setModelService(final ModelService modelService)
	{
		this.modelService = modelService;
	}

	/**
	 * @return the configurationService
	 */
	public ConfigurationService getConfigurationService()
	{
		return configurationService;
	}

	/**
	 * @param configurationService
	 *           the configurationService to set
	 */
	public void setConfigurationService(final ConfigurationService configurationService)
	{
		this.configurationService = configurationService;
	}

	/**
	 * @return the commonI18NService
	 */
	public CommonI18NService getCommonI18NService()
	{
		return commonI18NService;
	}

	/**
	 * @param commonI18NService
	 *           the commonI18NService to set
	 */
	public void setCommonI18NService(final CommonI18NService commonI18NService)
	{
		this.commonI18NService = commonI18NService;
	}

	/**
	 * @return the orderCompleteProcessService
	 */
	public OrderCompleteProcessService getOrderCompleteProcessService()
	{
		return orderCompleteProcessService;
	}

	/**
	 * @param orderCompleteProcessService
	 *           the orderCompleteProcessService to set
	 */
	public void setOrderCompleteProcessService(final OrderCompleteProcessService orderCompleteProcessService)
	{
		this.orderCompleteProcessService = orderCompleteProcessService;
	}

	/**
	 * @param orderSubtotal
	 *
	 */
	public boolean isCaptureAllowed(final Double orderSubtotal)
	{
		return captureStrategy.allowCapture(BigDecimal.valueOf(orderSubtotal));

	}

	/**
	 * @return the captureStrategy
	 */
	public CaptureStrategy getCaptureStrategy()
	{
		return captureStrategy;
	}

	/**
	 * @param captureStrategy
	 *           the captureStrategy to set
	 */
	public void setCaptureStrategy(final CaptureStrategy captureStrategy)
	{
		this.captureStrategy = captureStrategy;
	}

	public BusinessProcessService getBusinessProcessService() {
		return businessProcessService;
	}

	public void setBusinessProcessService(BusinessProcessService businessProcessService) {
		this.businessProcessService = businessProcessService;
	}
}
