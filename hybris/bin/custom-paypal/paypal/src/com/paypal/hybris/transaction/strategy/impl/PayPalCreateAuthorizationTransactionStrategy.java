/**
 *
 */
package com.paypal.hybris.transaction.strategy.impl;

import de.hybris.platform.core.model.order.CartModel;
import de.hybris.platform.payment.dto.TransactionStatus;
import de.hybris.platform.payment.dto.TransactionStatusDetails;
import de.hybris.platform.payment.enums.PaymentTransactionType;
import de.hybris.platform.payment.model.PaymentTransactionEntryModel;

import java.util.Date;
import java.util.List;

import com.paypal.hybris.data.PaymentInfoData;
import com.paypal.hybris.data.PaymentStatus;
import com.paypal.hybris.data.PendingReason;
import com.paypal.hybris.transaction.strategy.PayPalCreateTransactionStrategy;


public class PayPalCreateAuthorizationTransactionStrategy extends PayPalAbstractCreateTransactionStrategy
		implements PayPalCreateTransactionStrategy
{


	@Override
	public void createPaymentTransaction(final PaymentInfoData paymentInfoData,
			final List<PaymentTransactionEntryModel> paymentTransactionEntries) throws Exception
	{
		final CartModel cartModel = getCart();

		final String transactionId = paymentInfoData.getTransactionId();
		final String currencyIsoCode = paymentInfoData.getCurrencyIsoCode();
		final double amount = paymentInfoData.getGrossAmount();
		final Date paymentDate = paymentInfoData.getPaymentDate().getTime();

		PaymentTransactionEntryModel authTransactionEntry = null;
		if (PaymentStatus.PENDING == paymentInfoData.getPaymentStatus()
				&& PendingReason.AUTHORIZATION != paymentInfoData.getPendingReason())
		{
			authTransactionEntry = createTransactionEntry(PaymentTransactionType.AUTHORIZATION, PaymentStatus.PENDING.name(),
					paymentInfoData.getPendingReason().name(), transactionId, cartModel, currencyIsoCode, amount, paymentDate);
		}
		else
		{
			authTransactionEntry = createTransactionEntry(PaymentTransactionType.AUTHORIZATION, TransactionStatus.ACCEPTED.name(),
					TransactionStatusDetails.SUCCESFULL.name(), transactionId, cartModel, currencyIsoCode, amount, paymentDate);
		}
		paymentTransactionEntries.add(authTransactionEntry);
	}

}
