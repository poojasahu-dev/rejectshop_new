/**
 *
 */
package com.paypal.hybris.commands.converters.impl;

import de.hybris.platform.converters.impl.AbstractConverter;
import de.hybris.platform.payment.commands.result.CaptureResult;
import de.hybris.platform.payment.dto.TransactionStatus;
import de.hybris.platform.payment.dto.TransactionStatusDetails;

import com.paypal.hybris.constants.PaypalConstants;
import com.paypal.hybris.data.DoReferenceTransactionResultData;
import com.paypal.hybris.data.PaymentStatus;


/**
 *
 */
public class ReplenishmentResponseCaptureConverter extends AbstractConverter<DoReferenceTransactionResultData, CaptureResult>
{

	@Override
	public void populate(final DoReferenceTransactionResultData resultData, final CaptureResult captureResult)
	{
		final PaymentStatus paymentStatus = resultData.getPaymentStatus();
		if (PaypalConstants.STATUS_SUCCESS.equals(resultData.getAck()))
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

			captureResult.setTotalAmount(resultData.getTotalAmount());
			captureResult.setCurrency(resultData.getCurrency());
		}
		else
		{
			captureResult.setTransactionStatus(TransactionStatus.ERROR);
			captureResult.setTransactionStatusDetails(TransactionStatusDetails.UNKNOWN_CODE);
		}

		captureResult.setRequestId(resultData.getTransactionId());
		captureResult.setRequestToken(resultData.getBillingAgreementId());
	}

}
