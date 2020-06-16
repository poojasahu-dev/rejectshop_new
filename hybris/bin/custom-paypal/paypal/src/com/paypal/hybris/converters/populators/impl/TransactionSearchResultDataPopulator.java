package com.paypal.hybris.converters.populators.impl;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.ebay.utils.PaypalStringUtils;
import com.paypal.hybris.data.PaymentTransaction;
import com.paypal.hybris.data.TransactionSearchResultData;

import urn.ebay.api.PayPalAPI.TransactionSearchResponseType;
import urn.ebay.apis.eBLBaseComponents.PaymentTransactionSearchResultType;


public class TransactionSearchResultDataPopulator implements Populator<TransactionSearchResponseType, TransactionSearchResultData>
{
	/**
	 * Populate the target instance with values from the source instance.
	 *
	 * @param response
	 *           the source object
	 * @param resultData
	 *           the target to fill
	 * @throws de.hybris.platform.servicelayer.dto.converter.ConversionException
	 *            if an error occurs
	 */
	@Override
	public void populate(final TransactionSearchResponseType response, final TransactionSearchResultData resultData)
			throws ConversionException
	{
		final List<PaymentTransactionSearchResultType> paymentTransactionList = response.getPaymentTransactions();
		final List<PaymentTransaction> paymentTransactionDataList = new ArrayList<>();
		resultData.setTransactionList(paymentTransactionDataList);

		if (CollectionUtils.isNotEmpty(paymentTransactionList))
		{
			for (final PaymentTransactionSearchResultType transaction : paymentTransactionList)
			{
				final PaymentTransaction transactionData = new PaymentTransaction();
				transactionData.setTransactionId(transaction.getTransactionID());
				transactionData.setPayerEmail(transaction.getPayer());
				transactionData.setTimestamp(PaypalStringUtils.getCalendarFromResponse(transaction.getTimestamp()));
				transactionData.setTimezone(transaction.getTimezone());
				transactionData.setType(transaction.getType());
				paymentTransactionDataList.add(transactionData);
			}
		}
	}
}
