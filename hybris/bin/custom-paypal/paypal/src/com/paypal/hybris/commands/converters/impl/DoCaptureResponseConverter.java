package com.paypal.hybris.commands.converters.impl;

import de.hybris.platform.converters.impl.AbstractConverter;
import de.hybris.platform.payment.commands.result.CaptureResult;
import de.hybris.platform.payment.dto.TransactionStatus;
import de.hybris.platform.payment.dto.TransactionStatusDetails;

import java.math.BigDecimal;
import java.util.Currency;

import org.apache.commons.lang.math.NumberUtils;

import com.ebay.utils.PaypalStringUtils;
import com.paypal.hybris.constants.PaypalConstants;
import com.paypal.hybris.data.PaymentStatus;

import urn.ebay.api.PayPalAPI.DoCaptureResponseType;
import urn.ebay.apis.eBLBaseComponents.DoCaptureResponseDetailsType;
import urn.ebay.apis.eBLBaseComponents.PaymentInfoType;


public class DoCaptureResponseConverter extends AbstractConverter<DoCaptureResponseType, CaptureResult>
{
	/**
	 * Override this method to populate the target from the source
	 *
	 * @param doCaptureResponse
	 *           the source instance
	 * @param captureResult
	 *           the target instance to fill
	 * @see #setTargetClass(Class)
	 */
	@Override
	public void populate(final DoCaptureResponseType doCaptureResponse, final CaptureResult captureResult)
	{
		final DoCaptureResponseDetailsType details = doCaptureResponse.getDoCaptureResponseDetails();
		final PaymentInfoType paymentInfo = details.getPaymentInfo();

		final PaymentStatus paymentStatus = PaymentStatus.valueOf(paymentInfo.getPaymentStatus().getValue().toUpperCase());
		if (PaypalConstants.STATUS_SUCCESS.equals(doCaptureResponse.getAck().getValue()))
		{
			if (PaymentStatus.COMPLETED == paymentStatus)
			{
				captureResult.setTransactionStatus(TransactionStatus.ACCEPTED);
				captureResult.setTransactionStatusDetails(TransactionStatusDetails.SUCCESFULL);
			}
			else if (PaymentStatus.DENIED == paymentStatus)
			{
				captureResult.setTransactionStatus(TransactionStatus.REJECTED);
				captureResult.setTransactionStatusDetails(TransactionStatusDetails.UNKNOWN_CODE);
			}
			else
			{
				captureResult.setTransactionStatus(TransactionStatus.REVIEW);
				captureResult.setTransactionStatusDetails(TransactionStatusDetails.UNKNOWN_CODE);
			}

			captureResult.setTotalAmount(BigDecimal.valueOf(NumberUtils.toDouble(paymentInfo.getGrossAmount().getValue())));
			captureResult.setCurrency(Currency.getInstance(paymentInfo.getGrossAmount().getCurrencyID().getValue()));
		}
		else
		{
			captureResult.setTransactionStatus(TransactionStatus.ERROR);
			captureResult.setTransactionStatusDetails(TransactionStatusDetails.UNKNOWN_CODE);
		}

		captureResult.setRequestTime(PaypalStringUtils.getDateFromResponse(doCaptureResponse.getTimestamp()));
		captureResult.setRequestId(paymentInfo.getTransactionID());
		captureResult.setRequestToken(details.getAuthorizationID());
	}
}
