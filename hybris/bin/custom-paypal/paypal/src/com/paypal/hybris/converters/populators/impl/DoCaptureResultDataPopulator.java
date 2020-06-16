package com.paypal.hybris.converters.populators.impl;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

import org.apache.commons.lang.math.NumberUtils;

import com.ebay.utils.PaypalStringUtils;
import com.paypal.hybris.data.DoCaptureResultData;
import com.paypal.hybris.data.PaymentStatus;
import com.paypal.hybris.data.PendingReason;

import urn.ebay.api.PayPalAPI.DoCaptureResponseType;
import urn.ebay.apis.CoreComponentTypes.BasicAmountType;
import urn.ebay.apis.eBLBaseComponents.DoCaptureResponseDetailsType;
import urn.ebay.apis.eBLBaseComponents.PaymentInfoType;


public class DoCaptureResultDataPopulator implements Populator<DoCaptureResponseType, DoCaptureResultData>
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
	public void populate(final DoCaptureResponseType response, final DoCaptureResultData resultData) throws ConversionException
	{
		final DoCaptureResponseDetailsType details = response.getDoCaptureResponseDetails();
		resultData.setAuthorizationId(details.getAuthorizationID());

		final PaymentInfoType paymentInfo = details.getPaymentInfo();
		final PaymentStatus paymentStatus = PaymentStatus.valueOf(paymentInfo.getPaymentStatus().getValue().toUpperCase());
		resultData.setPaymentStatus(paymentStatus);
		if (PaymentStatus.PENDING == paymentStatus)
		{
			final PendingReason pendingReason = PendingReason.valueOf(paymentInfo.getPendingReason().name());
			resultData.setPendingReason(pendingReason);
		}
		resultData.setTransactionId(paymentInfo.getTransactionID());
		resultData.setParentTransactionId(paymentInfo.getParentTransactionID());
		resultData.setReceiptId(paymentInfo.getReceiptID());

		final BasicAmountType grossAmount = paymentInfo.getGrossAmount();
		if (grossAmount != null)
		{
			resultData.setAmount(NumberUtils.toDouble(paymentInfo.getGrossAmount().getValue()));
			resultData.setCurrencyIsoCode(paymentInfo.getGrossAmount().getCurrencyID().getValue());
		}
		if (paymentInfo.getPaymentDate() != null)
		{
			resultData.setPaymentDate(PaypalStringUtils.getCalendarFromResponse(paymentInfo.getPaymentDate()));
		}

	}
}
