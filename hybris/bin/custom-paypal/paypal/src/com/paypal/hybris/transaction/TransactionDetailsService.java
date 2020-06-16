package com.paypal.hybris.transaction;

import com.paypal.hybris.data.GetTransactionDetailsResultData;


public interface TransactionDetailsService
{
	GetTransactionDetailsResultData getTransactionDetails(String transactionId);
}
