package com.paypal.hybris.refund;

import de.hybris.platform.core.model.order.OrderModel;

import java.math.BigDecimal;

import com.paypal.hybris.data.RefundTransactionResultData;

import urn.ebay.apis.CoreComponentTypes.BasicAmountType;
import urn.ebay.apis.eBLBaseComponents.RefundType;


public interface PayPalPartialRefundService
{
    boolean isValidTransactionId(final OrderModel order, final String transactionId);

	public RefundTransactionResultData doPartialRefund(OrderModel order, String transactionId, BasicAmountType amount,
			RefundType refundType);

	public void recalculateEntries(OrderModel order, BigDecimal amount);

}
