package com.paypal.hybris.cscockpit.widgets.controllers.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import org.apache.log4j.Logger;

import com.paypal.hybris.constants.PaypalcscockpitConstants;
import com.paypal.hybris.cscockpit.widgets.controllers.PayPalPartialRefundController;
import com.paypal.hybris.data.RefundTransactionResultData;
import com.paypal.hybris.refund.PayPalPartialRefundService;
import com.paypal.hybris.validation.utils.PayPalDummyAmountUtils;

import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.cscockpit.exceptions.ResourceMessage;
import de.hybris.platform.cscockpit.exceptions.ValidationException;
import de.hybris.platform.cscockpit.widgets.controllers.OrderManagementActionsWidgetController;
import de.hybris.platform.cscockpit.widgets.controllers.impl.DefaultReturnsController;
import de.hybris.platform.payment.dto.TransactionStatus;
import de.hybris.platform.payment.enums.PaymentTransactionType;
import de.hybris.platform.payment.model.PaymentTransactionEntryModel;
import de.hybris.platform.payment.model.PaymentTransactionModel;
import de.hybris.platform.servicelayer.util.ServicesUtil;
import urn.ebay.apis.CoreComponentTypes.BasicAmountType;
import urn.ebay.apis.eBLBaseComponents.CurrencyCodeType;
import urn.ebay.apis.eBLBaseComponents.RefundType;


public class PayPalPartialRefundControllerImpl extends DefaultReturnsController implements PayPalPartialRefundController
{
    private static final Logger LOG = Logger.getLogger(PayPalPartialRefundControllerImpl.class);

	private PayPalPartialRefundService payPalPartialRefundService;
	private OrderManagementActionsWidgetController csOrderManagementActionsWidgetController;
	private static final String VALIDATION_ON_AVAILABLE_SUM = "Partial refund requst is failed. Amount is bigger than order entries sum. For now you can refund: %s";

	@Override
	public void dispatchEvent(final String context, final Object source, final Map<String, Object> data)
	{
		csOrderManagementActionsWidgetController.dispatchEvent(null, source, data);
	}

	@Override
	public RefundTransactionResultData createPartialRefundRequest(final String transactionId, final String refundAmount)
	{
	    LOG.info("createPartialRefundRequest, refundAmount: " + refundAmount);

		final OrderModel order = getOrder();
		final BigDecimal amount = new BigDecimal(refundAmount);

		final RefundType refundType = getRefundType(transactionId, amount, order);
		final BasicAmountType basicAmount = new BasicAmountType(CurrencyCodeType.fromValue(order.getCurrency().getIsocode()),
				refundAmount);


		final RefundTransactionResultData doPartialRefund = payPalPartialRefundService.doPartialRefund(order, transactionId, basicAmount, refundType);
		if (doPartialRefund.getErrors() == null || doPartialRefund.getErrors().isEmpty())
		{
//			payPalPartialRefundService.recalculateEntries(order, amount);
		}

		return doPartialRefund;

	}

	@Override
	public PaymentTransactionEntryModel getPaymentTransaction()
	{

		for (final PaymentTransactionModel paymentTransactionModel : getOrder().getPaymentTransactions())
		{
			for (final PaymentTransactionEntryModel paymentTransactionEntryModel : paymentTransactionModel.getEntries())
			{
				if ((PaymentTransactionType.CAPTURE.equals(paymentTransactionEntryModel.getType()) ||
                        PaymentTransactionType.SALE.equals(paymentTransactionEntryModel.getType()))
						&& TransactionStatus.ACCEPTED.toString().equals(paymentTransactionEntryModel.getTransactionStatus()))
				{
					return paymentTransactionEntryModel;
				}
			}
		}
		return null;

	}

	@Override
	public boolean validatePartialRefundRequest(final String transactionId, final String refundAmount) throws ValidationException {

		final OrderModel order = getOrder();
		final Double orderSubtotal = order.getSubtotal();
		final BigDecimal orderSubtotalWithDelivery = BigDecimal.valueOf(orderSubtotal + order.getDeliveryCost()).setScale(2, RoundingMode.HALF_UP);

		final PaymentTransactionEntryModel paymentTransactionEntryModel = getCapturedPaymentTransactionEntryByTransactionId(
				transactionId, order);

		final BigDecimal amount = PayPalDummyAmountUtils.validateAmount(refundAmount);

		if (paymentTransactionEntryModel != null) {
			if (amount.compareTo(paymentTransactionEntryModel.getAmount()) > 0) {
				throwValidateException(
						PaypalcscockpitConstants.AMOUNT_MORE_THAN_AUTH + paymentTransactionEntryModel.getAmount().doubleValue());
			}
			if (new Double(orderSubtotalWithDelivery.doubleValue()).compareTo(Double.valueOf(refundAmount)) < 0) {
				throw new IllegalArgumentException(String.format(VALIDATION_ON_AVAILABLE_SUM, orderSubtotalWithDelivery));
			}
		}
		else {
			throwValidateException(PaypalcscockpitConstants.INVALID_TRANSACTION);
		}

		return true;
	}

	@Override
	public boolean validateTransactionId(final String transactionId) throws ValidationException {
        final OrderModel order = getOrder();

        if (!payPalPartialRefundService.isValidTransactionId(order, transactionId)) {
            throwValidateException(PaypalcscockpitConstants.INVALID_TRANSACTION);
        }

        return true;
    }

	private RefundType getRefundType(final String transactionId, final BigDecimal amount, final OrderModel order)
	{
		RefundType refundType = null;

		final PaymentTransactionEntryModel paymentTransactionEntryModel = getCapturedPaymentTransactionEntryByTransactionId(transactionId, order);

		if (amount.compareTo(paymentTransactionEntryModel.getAmount()) < 0)
		{
			refundType = RefundType.PARTIAL;
		}

		return refundType;
	}

	private PaymentTransactionEntryModel getCapturedPaymentTransactionEntryByTransactionId(final String transactionId,
			final OrderModel order)
	{
		PaymentTransactionEntryModel capturedPaymentTransactionEntryModel = null;

		for (final PaymentTransactionModel paymentTransactionModel : order.getPaymentTransactions())
		{
			for (final PaymentTransactionEntryModel paymentTransactionEntryModel : paymentTransactionModel.getEntries())
			{
				if ((paymentTransactionEntryModel.getType() == PaymentTransactionType.CAPTURE ||
                        paymentTransactionEntryModel.getType() == PaymentTransactionType.SALE)
						&& transactionId.equals(paymentTransactionEntryModel.getRequestId()))
				{
					capturedPaymentTransactionEntryModel = paymentTransactionEntryModel;
				}
			}
		}

		return capturedPaymentTransactionEntryModel;
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

	public PayPalPartialRefundService getPayPalPartialRefundService()
	{
		return payPalPartialRefundService;
	}

	public void setPayPalPartialRefundService(final PayPalPartialRefundService payPalPartialRefundService)
	{
		this.payPalPartialRefundService = payPalPartialRefundService;
	}

	@Override
	public OrderManagementActionsWidgetController getOrderManagementActionsWidgetController()
	{
		return csOrderManagementActionsWidgetController;
	}

	@Override
	public void setOrderManagementActionsWidgetController(
			final OrderManagementActionsWidgetController csOrderManagementActionsWidgetController)
	{
		this.csOrderManagementActionsWidgetController = csOrderManagementActionsWidgetController;
	}

}
