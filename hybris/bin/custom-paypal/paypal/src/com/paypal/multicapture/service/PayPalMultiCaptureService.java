/**
 *
 */
package com.paypal.multicapture.service;

import de.hybris.platform.core.model.order.OrderModel;

import com.paypal.hybris.data.DoCaptureResultData;


/**
 *
 */
public interface PayPalMultiCaptureService
{
	public DoCaptureResultData doMultiCapture(OrderModel order, final String captureAmount, final String transactionId,
			final String completeType);

	public void createMultiCaptureTransaction(OrderModel order, DoCaptureResultData resultData);

	public boolean isCaptureAllowed(Double subtotal);

	public boolean isValidTransactionId(final OrderModel order, final String transactionId);
}
