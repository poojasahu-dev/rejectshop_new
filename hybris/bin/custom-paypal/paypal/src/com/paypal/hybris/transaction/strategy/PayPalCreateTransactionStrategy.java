/**
 *
 */
package com.paypal.hybris.transaction.strategy;

import de.hybris.platform.payment.model.PaymentTransactionEntryModel;

import java.util.List;

import com.paypal.hybris.data.PaymentInfoData;


public interface PayPalCreateTransactionStrategy
{
	void createPaymentTransaction(PaymentInfoData paymentInfoData,
			final List<PaymentTransactionEntryModel> paymentTransactionEntries) throws Exception;
}
