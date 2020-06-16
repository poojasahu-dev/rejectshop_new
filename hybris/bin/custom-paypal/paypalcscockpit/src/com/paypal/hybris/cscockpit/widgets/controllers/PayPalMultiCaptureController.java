/**
 *
 */
package com.paypal.hybris.cscockpit.widgets.controllers;

import de.hybris.platform.cockpit.widgets.controllers.WidgetController;
import de.hybris.platform.cscockpit.exceptions.ValidationException;

import com.paypal.hybris.data.DoCaptureResultData;


/**
 *
 */
public interface PayPalMultiCaptureController extends WidgetController
{

	boolean validateMultiCaptureRequest(String transactionId, String captureAmount, String completeType)
			throws ValidationException;

	public DoCaptureResultData createMultiCaptureRequest(String captureAmount, String transactionId, String completeType);

	public String getAuthorizationTransactionId();

}
