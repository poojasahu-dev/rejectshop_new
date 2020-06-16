package com.paypal.hybris.refund.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import com.paypal.hybris.constants.PaypalConstants;
import com.paypal.hybris.data.PaymentStatus;
import com.paypal.hybris.data.RefundTransactionResultData;
import com.paypal.hybris.model.PaypalPartialRefundEntryModel;
import com.paypal.hybris.payment.service.PayPalPaymentService;
import com.paypal.hybris.refund.PayPalPartialRefundService;

import de.hybris.platform.core.model.order.AbstractOrderEntryModel;
import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.order.OrderService;
import de.hybris.platform.payment.dto.TransactionStatus;
import de.hybris.platform.payment.dto.TransactionStatusDetails;
import de.hybris.platform.payment.enums.PaymentTransactionType;
import de.hybris.platform.payment.model.PaymentTransactionEntryModel;
import de.hybris.platform.payment.model.PaymentTransactionModel;
import de.hybris.platform.servicelayer.model.ModelService;
import urn.ebay.api.PayPalAPI.RefundTransactionRequestType;
import urn.ebay.apis.CoreComponentTypes.BasicAmountType;
import urn.ebay.apis.eBLBaseComponents.RefundType;


public class PayPalPartialRefundServiceImpl implements PayPalPartialRefundService {
	private static final Logger LOG = Logger.getLogger(PayPalPartialRefundServiceImpl.class);

	private PayPalPaymentService payPalPaymentService;
	private OrderService orderService;
	private ModelService modelService;


    @Override
    public boolean isValidTransactionId(final OrderModel order, final String transactionId) {
        boolean result = false;
		PaymentTransactionType transactionType;
        for (final PaymentTransactionModel paymentTransactionModel : order.getPaymentTransactions()) {
            for (final PaymentTransactionEntryModel paymentTransactionEntryModel : paymentTransactionModel.getEntries()) {
                transactionType = paymentTransactionEntryModel.getType();
                if ((transactionType == PaymentTransactionType.CAPTURE || transactionType == PaymentTransactionType.SALE)
                        && TransactionStatus.ACCEPTED.name().equals(paymentTransactionEntryModel.getTransactionStatus())
                        && paymentTransactionEntryModel.getRequestId().equals(transactionId)) {
                    result = true;
                    break;
                }
            }
        }

        return result;
    }

	@Override
	public RefundTransactionResultData doPartialRefund(final OrderModel order, final String transactionId,
			final BasicAmountType amount, final RefundType refundType)
	{
	    LOG.info("doPartialRefund, amount: " + amount.getValue() + ", currencyId: " + amount.getCurrencyID().getValue() + ", refundType: " + refundType);

		final RefundTransactionRequestType refundRequest = new RefundTransactionRequestType();
		refundRequest.setAmount(amount);
		refundRequest.setTransactionID(transactionId);
		refundRequest.setRefundType(refundType);

		final RefundTransactionResultData refundResultData = payPalPaymentService.doPartialRefund(refundRequest);

		createRefundTransaction(order, refundResultData, amount);

		return refundResultData;
	}

	@Override
	public void recalculateEntries(final OrderModel order, final BigDecimal amount)
	{
		final List<AbstractOrderEntryModel> entries = order.getEntries();
		final List<PaypalPartialRefundEntryModel> partialsRefunds = new ArrayList<PaypalPartialRefundEntryModel>();
		final BigDecimal sumValue = BigDecimal.valueOf(order.getSubtotal());
		BigDecimal sumSubstractValue = BigDecimal.ZERO;

			for (final AbstractOrderEntryModel orderEntry : entries)
			{
				final PaypalPartialRefundEntryModel paypalPartialRefundEntry = new PaypalPartialRefundEntryModel();
				paypalPartialRefundEntry.setOrderEntry(orderEntry);
				final BigDecimal percentRefuntValue = BigDecimal.valueOf(orderEntry.getTotalPrice())
						.divide(BigDecimal.valueOf(order.getSubtotal()), 2, RoundingMode.HALF_UP);

				paypalPartialRefundEntry.setPercentRefuntValue(Double.valueOf(percentRefuntValue.doubleValue()));
				getModelService().save(paypalPartialRefundEntry);

				partialsRefunds.add(paypalPartialRefundEntry);
			}

			for (final PaypalPartialRefundEntryModel paypalPartialRefundEntry : partialsRefunds)
			{
				final BigDecimal substractValue = amount
						.multiply(BigDecimal.valueOf(paypalPartialRefundEntry.getPercentRefuntValue()));
				sumSubstractValue = sumSubstractValue.add(substractValue);
				if (sumSubstractValue.compareTo(sumValue) < 0)
				{
					BigDecimal totalPrice = BigDecimal.valueOf(paypalPartialRefundEntry.getOrderEntry().getTotalPrice());
					totalPrice = totalPrice.subtract(substractValue);
					if (totalPrice.compareTo(BigDecimal.ZERO) < 0)
					{
						totalPrice = BigDecimal.ZERO;
					}
					paypalPartialRefundEntry.getOrderEntry().setTotalPrice(Double.valueOf(totalPrice.doubleValue()));
					getModelService().save(paypalPartialRefundEntry);
				}
				else
				{
					paypalPartialRefundEntry.getOrderEntry().setTotalPrice(BigDecimal.ZERO.doubleValue());
					getModelService().save(paypalPartialRefundEntry);
				}
			}

			order.setCalculated(Boolean.FALSE);
			getModelService().save(order);
			getOrderService().calculateOrder(order);
	}

	private void createRefundTransaction(final OrderModel order, final RefundTransactionResultData refundResultData, final BasicAmountType amount)
	{
		if (order.getPaymentTransactions().size() > 0)
		{
			final PaymentTransactionModel paymentTransactionModel = order.getPaymentTransactions().get(0);
			final PaymentTransactionEntryModel entry = getModelService().create(PaymentTransactionEntryModel.class);
			final String code = PaypalConstants.PAYMENT_PROVIDER_NAME + "_partial_refund_stamp_" + System.currentTimeMillis();
			entry.setCode(code);
			entry.setCurrency(order.getCurrency());
			entry.setTime(refundResultData.getDateTime().getTime());
			entry.setAmount(new BigDecimal(refundResultData.getGrossRefundAmount()));
			entry.setPaymentTransaction(paymentTransactionModel);
			entry.setType(PaymentTransactionType.PARTIAL_REFUND);
			entry.setRequestId(refundResultData.getRefundTransactionId());
			if (refundResultData.getErrors() == null || refundResultData.getErrors().isEmpty())
			{
				entry.setTransactionStatus(TransactionStatus.ACCEPTED.name());
				entry.setTransactionStatusDetails(TransactionStatusDetails.SUCCESFULL.name());
			}
			else
			{
				entry.setTransactionStatus(TransactionStatus.ERROR.name());
				entry.setTransactionStatusDetails(TransactionStatusDetails.INVALID_REQUEST.name());
				entry.setAmount(new BigDecimal(amount.getValue()));
			}
			getModelService().saveAll(entry, paymentTransactionModel, order);
			getModelService().refresh(order);
		}
	}

	public PayPalPaymentService getPayPalPaymentService()
	{
		return payPalPaymentService;
	}

	public void setPayPalPaymentService(final PayPalPaymentService payPalPaymentService)
	{
		this.payPalPaymentService = payPalPaymentService;
	}

	/**
	 * @return the orderService
	 */
	public OrderService getOrderService()
	{
		return orderService;
	}

	/**
	 * @param orderService
	 *           the orderService to set
	 */
	public void setOrderService(final OrderService orderService)
	{
		this.orderService = orderService;
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
}
