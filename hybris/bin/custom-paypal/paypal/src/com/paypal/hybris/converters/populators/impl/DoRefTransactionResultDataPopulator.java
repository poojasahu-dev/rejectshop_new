package com.paypal.hybris.converters.populators.impl;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

import java.math.BigDecimal;
import java.util.Currency;

import org.apache.commons.lang.math.NumberUtils;

import com.paypal.hybris.data.DoReferenceTransactionResultData;
import com.paypal.hybris.data.PaymentStatus;
import com.paypal.hybris.data.PendingReason;

import urn.ebay.api.PayPalAPI.DoReferenceTransactionResponseType;
import urn.ebay.apis.eBLBaseComponents.DoReferenceTransactionResponseDetailsType;
import urn.ebay.apis.eBLBaseComponents.PaymentInfoType;


public class DoRefTransactionResultDataPopulator
		implements Populator<DoReferenceTransactionResponseType, DoReferenceTransactionResultData>
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
	public void populate(final DoReferenceTransactionResponseType response, final DoReferenceTransactionResultData resultData)
			throws ConversionException
	{
		final DoReferenceTransactionResponseDetailsType responseDetails = response.getDoReferenceTransactionResponseDetails();
		if (responseDetails != null)
		{
			resultData.setBillingAgreementId(responseDetails.getBillingAgreementID());

			final PaymentInfoType paymentInfo = responseDetails.getPaymentInfo();
			if (paymentInfo != null)
			{
				resultData.setTransactionId(paymentInfo.getTransactionID());
				resultData.setPaymentStatus(PaymentStatus.valueOf(paymentInfo.getPaymentStatus().name()));
				resultData.setPendingReason(PendingReason.valueOf(paymentInfo.getPendingReason().name()));
				resultData.setTotalAmount(BigDecimal.valueOf(NumberUtils.toDouble(paymentInfo.getGrossAmount().getValue())));
				resultData.setCurrency(Currency.getInstance(paymentInfo.getGrossAmount().getCurrencyID().getValue()));
			}
		}
	}
}
