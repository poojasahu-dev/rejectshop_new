package com.paypal.hybris.cscockpit.widgets.controllers;

import com.paypal.hybris.data.GetTransactionDetailsResultData;


public interface PayPalOrderController
{
	public GetTransactionDetailsResultData getTransactionDetails(String transactionId);
}
