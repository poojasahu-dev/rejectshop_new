package com.paypal.hybris.cscockpit.widgets.controllers;

import de.hybris.platform.cockpit.widgets.controllers.WidgetController;
import de.hybris.platform.cscockpit.exceptions.ValidationException;
import de.hybris.platform.payment.model.PaymentTransactionEntryModel;

import com.paypal.hybris.data.RefundTransactionResultData;


public interface PayPalPartialRefundController extends WidgetController
{
    public boolean validateTransactionId(final String transactionId) throws ValidationException;

	public RefundTransactionResultData createPartialRefundRequest(String transactionId, String refundAmount);

	public boolean validatePartialRefundRequest(String transactionId, String refundAmount) throws ValidationException;

	public PaymentTransactionEntryModel getPaymentTransaction();
}
