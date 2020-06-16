package com.paypal.hybris.replenishment.service;

import de.hybris.platform.payment.commands.request.CaptureRequest;
import de.hybris.platform.payment.commands.result.CaptureResult;


public interface PayPalReplenishmentService
{
	CaptureResult proceedReplenishmentPlaceOrder(final CaptureRequest captureRequest);
}
