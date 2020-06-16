package com.paypal.hybris.converters.populators.impl;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

import org.apache.commons.lang.StringUtils;

import com.ebay.utils.PaypalStringUtils;
import com.paypal.hybris.data.TransactionSearchRequestData;

import urn.ebay.api.PayPalAPI.TransactionSearchRequestType;


public class TransactionSearchReqPopulator implements Populator<TransactionSearchRequestData, TransactionSearchRequestType>
{
	/**
	 * Populate the target instance with values from the source instance.
	 *
	 * @param requestData
	 *           the source object
	 * @param request
	 *           the target to fill
	 * @throws de.hybris.platform.servicelayer.dto.converter.ConversionException
	 *            if an error occurs
	 */
	@Override
	public void populate(final TransactionSearchRequestData requestData, final TransactionSearchRequestType request)
			throws ConversionException
	{
		if (requestData.getStartDate() == null)
		{
			throw new ConversionException("Start date is required attribute and can't be null");
		}
		request.setStartDate(PaypalStringUtils.getStringFromCalendar(requestData.getStartDate()));
		if (requestData.getEndDate() != null)
		{
			request.setEndDate(PaypalStringUtils.getStringFromCalendar(requestData.getEndDate()));
		}

		final String payerEmail = requestData.getPayerEmail();
		if (StringUtils.isNotBlank(payerEmail))
		{
			request.setPayer(requestData.getPayerEmail());
		}

		final String transactionId = requestData.getTransactionId();
		if (StringUtils.isNotBlank(transactionId))
		{
			request.setTransactionID(transactionId);
		}
	}
}
