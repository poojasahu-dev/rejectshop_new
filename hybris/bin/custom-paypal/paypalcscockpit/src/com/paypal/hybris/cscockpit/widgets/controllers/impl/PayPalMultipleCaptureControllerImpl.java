package com.paypal.hybris.cscockpit.widgets.controllers.impl;

import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.cscockpit.exceptions.ResourceMessage;
import de.hybris.platform.cscockpit.exceptions.ValidationException;
import de.hybris.platform.cscockpit.widgets.controllers.OrderManagementActionsWidgetController;
import de.hybris.platform.cscockpit.widgets.controllers.impl.AbstractCsWidgetController;
import de.hybris.platform.payment.dto.TransactionStatus;
import de.hybris.platform.payment.enums.PaymentTransactionType;
import de.hybris.platform.payment.model.PaymentTransactionEntryModel;
import de.hybris.platform.payment.model.PaymentTransactionModel;
import de.hybris.platform.servicelayer.i18n.CommonI18NService;
import de.hybris.platform.servicelayer.util.ServicesUtil;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.paypal.hybris.constants.PaypalcscockpitConstants;
import com.paypal.hybris.cscockpit.widgets.controllers.PayPalMultiCaptureController;
import com.paypal.hybris.data.DoCaptureResultData;
import com.paypal.hybris.validation.utils.PayPalDummyAmountUtils;
import com.paypal.multicapture.service.PayPalMultiCaptureService;

import urn.ebay.apis.eBLBaseComponents.CompleteCodeType;


public class PayPalMultipleCaptureControllerImpl extends AbstractCsWidgetController implements PayPalMultiCaptureController
{
    private static final Logger LOG = Logger.getLogger(PayPalMultipleCaptureControllerImpl.class);

	private static final String TRANSACTION_SUCCESFULL = "SUCCESFULL";

	private OrderManagementActionsWidgetController csOrderManagementActionsWidgetController;
	private CommonI18NService commonI18NService;
	private PayPalMultiCaptureService payPalMultiCaptureService;


	@Override
	public void dispatchEvent(final String context, final Object source, final Map<String, Object> data)
	{
		csOrderManagementActionsWidgetController.dispatchEvent(context, source, data);
	}

	@Override
	public DoCaptureResultData createMultiCaptureRequest(final String captureAmount, final String transactionId,
			final String completeType)
	{
		final OrderModel order = getOrder();

		final DoCaptureResultData multiCaptureData = payPalMultiCaptureService.doMultiCapture(order, captureAmount, transactionId,
				completeType);

		payPalMultiCaptureService.createMultiCaptureTransaction(order, multiCaptureData);

		return multiCaptureData;
	}

	@Override
	public String getAuthorizationTransactionId()
	{
		String resultId = StringUtils.EMPTY;

		for (final PaymentTransactionModel paymentTransactionModel : getOrder().getPaymentTransactions())
		{
			for (final PaymentTransactionEntryModel paymentTransactionEntryModel : paymentTransactionModel.getEntries())
			{
				if (PaymentTransactionType.AUTHORIZATION.equals(paymentTransactionEntryModel.getType()) &&
						TRANSACTION_SUCCESFULL.equalsIgnoreCase(paymentTransactionEntryModel.getTransactionStatusDetails()))
				{
					resultId = paymentTransactionEntryModel.getRequestId();
				}
			}
		}

		return resultId;

	}


	@Override
	public boolean validateMultiCaptureRequest(final String transactionId, final String captureAmount, final String completeType)
			throws ValidationException
	{

		final BigDecimal amount = PayPalDummyAmountUtils.validateAmount(captureAmount);
		final OrderModel order = getOrder();

		final PaymentTransactionEntryModel paymentTransactionEntry = getAuthorizationPaymentTransactionEntry(transactionId, order);

		if (paymentTransactionEntry != null)
		{
			final BigDecimal totalOrderCapturedSum = getCapturedAmountSum(order);
			final BigDecimal transactionCapturedSum = getTransactionCapturedAmountSum(order, transactionId);
			final boolean isCompleteType = isCompleteType(completeType);
			final BigDecimal availableCaptureAmount = paymentTransactionEntry.getAmount().subtract(transactionCapturedSum).setScale(2,
					RoundingMode.HALF_UP);
			final BigDecimal requiredCaptureAmount = BigDecimal.valueOf(order.getTotalPrice()).subtract(totalOrderCapturedSum).setScale(2,
                    RoundingMode.HALF_UP);

			if (amount.compareTo(paymentTransactionEntry.getAmount()) > 0)
			{
				throwValidateException(PaypalcscockpitConstants.TOO_BIG_AMOUNT);
			}

			else if (availableCaptureAmount.compareTo(BigDecimal.ZERO) == 0)
			{
				throwValidateException(PaypalcscockpitConstants.ALREADY_CAPTURED);
			}

			else if (availableCaptureAmount.compareTo(amount) < 0)
			{
				throwValidateException(PaypalcscockpitConstants.TOO_BIG_AMOUNT_VALUE + availableCaptureAmount);
			}
			else if ((requiredCaptureAmount.compareTo(amount) <= 0) && !isCompleteType)
			{
				throwValidateException(PaypalcscockpitConstants.STATUS_SHOULD_BE_COMPLETE);
			}
		}
		else
		{
			throwValidateException(PaypalcscockpitConstants.INVALID_TRANSACTION);
		}

		return true;
	}

    public boolean validateTransactionId(String transactionId) throws ValidationException {
        final OrderModel order = getOrder();

        if (!payPalMultiCaptureService.isValidTransactionId(order, transactionId)){
            throwValidateException(PaypalcscockpitConstants.INVALID_TRANSACTION);
        }

        return true;
    }

    private PaymentTransactionEntryModel getAuthorizationPaymentTransactionEntry(final String transactionId,
			final OrderModel order)
	{
		PaymentTransactionEntryModel capturedPaymentTransactionEntryModel = null;

		for (final PaymentTransactionModel paymentTransactionModel : order.getPaymentTransactions())
		{
			for (final PaymentTransactionEntryModel paymentTransactionEntryModel : paymentTransactionModel.getEntries())
			{
				if (paymentTransactionEntryModel.getType() == PaymentTransactionType.AUTHORIZATION
						&& transactionId.equals(paymentTransactionEntryModel.getRequestId()))
				{
					capturedPaymentTransactionEntryModel = paymentTransactionEntryModel;
				}
			}
		}

		return capturedPaymentTransactionEntryModel;
	}

	private BigDecimal getCapturedAmountSum(final OrderModel order)
	{
		BigDecimal capturedSum = BigDecimal.ZERO;
		for (final PaymentTransactionModel paymentTransactionModel : order.getPaymentTransactions())
		{
			for (final PaymentTransactionEntryModel entry : paymentTransactionModel.getEntries())
			{
				if (PaymentTransactionType.CAPTURE.equals(entry.getType())
						&& TransactionStatus.ACCEPTED.toString().equals(entry.getTransactionStatus()))
				{
					capturedSum = capturedSum.add(entry.getAmount());
				}
			}
		}
		return capturedSum;
	}

    private BigDecimal getTransactionCapturedAmountSum(final OrderModel order, final String transactionId) {
        BigDecimal capturedSum = BigDecimal.ZERO;
        for (final PaymentTransactionModel paymentTransactionModel : order.getPaymentTransactions())
            if (paymentTransactionModel.getRequestId().equals(transactionId)) {
                {
                    for (final PaymentTransactionEntryModel entry : paymentTransactionModel.getEntries()) {
                        if (PaymentTransactionType.CAPTURE.equals(entry.getType())
                                && TransactionStatus.ACCEPTED.toString().equals(entry.getTransactionStatus())) {
                            capturedSum = capturedSum.add(entry.getAmount());
                        }
                    }
                }
            }
        return capturedSum;
    }

	private boolean isCompleteType(final String completeType)
	{
		return CompleteCodeType.COMPLETE.toString().equals(completeType);
	}

	private OrderModel getOrder()
	{
		final OrderModel order = (OrderModel) csOrderManagementActionsWidgetController.getOrder().getObject();
		ServicesUtil.validateParameterNotNull(order, "Current order can't be null");
		return order;
	}

	private void throwValidateException(final String message) throws ValidationException
	{
		final ResourceMessage errorMessage = new ResourceMessage(message);
		throw new ValidationException(new ArrayList<ResourceMessage>(Arrays.asList(errorMessage)));
	}

	public OrderManagementActionsWidgetController getOrderManagementActionsWidgetController()
	{
		return csOrderManagementActionsWidgetController;
	}

	public void setOrderManagementActionsWidgetController(
			final OrderManagementActionsWidgetController csOrderManagementActionsWidgetController)
	{
		this.csOrderManagementActionsWidgetController = csOrderManagementActionsWidgetController;
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
	 * @return the payPalMultiCaptureService
	 */
	public PayPalMultiCaptureService getPayPalMultiCaptureService()
	{
		return payPalMultiCaptureService;
	}

	/**
	 * @param payPalMultiCaptureService
	 *           the payPalMultiCaptureService to set
	 */
	public void setPayPalMultiCaptureService(final PayPalMultiCaptureService payPalMultiCaptureService)
	{
		this.payPalMultiCaptureService = payPalMultiCaptureService;
	}

}
