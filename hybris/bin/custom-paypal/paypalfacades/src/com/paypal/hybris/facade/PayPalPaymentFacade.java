package com.paypal.hybris.facade;

import de.hybris.platform.acceleratorfacades.payment.PaymentFacade;
import de.hybris.platform.commercefacades.order.data.CartData;

import com.paypal.hybris.data.DoAuthorizationRequestData;
import com.paypal.hybris.data.DoAuthorizationResultData;
import com.paypal.hybris.data.DoCaptureRequestData;
import com.paypal.hybris.data.DoCaptureResultData;
import com.paypal.hybris.data.DoExpressCheckoutPaymentRequestData;
import com.paypal.hybris.data.DoExpressCheckoutPaymentResultData;
import com.paypal.hybris.data.DoReferenceTransactionRequestData;
import com.paypal.hybris.data.DoReferenceTransactionResultData;
import com.paypal.hybris.data.GetExpressCheckoutDetailsResultData;
import com.paypal.hybris.data.SetExpressCheckoutRequestData;
import com.paypal.hybris.data.SetExpressCheckoutResultData;


public interface PayPalPaymentFacade extends PaymentFacade
{

	void setPaymentInfo(CartData cartData);

	DoReferenceTransactionResultData doReferenceTransaction(DoReferenceTransactionRequestData requestData);

	DoCaptureResultData doCapture(DoCaptureRequestData requestData);

	DoAuthorizationResultData doAuthorization(DoAuthorizationRequestData requestData);

	DoExpressCheckoutPaymentResultData doExpressCheckoutPayment(DoExpressCheckoutPaymentRequestData requestData);

	GetExpressCheckoutDetailsResultData getExpressCheckoutDetails();

	SetExpressCheckoutResultData preparePaypalPayment(SetExpressCheckoutRequestData requestData);

	String getFullResponseUrl(final String responseUrl, final boolean isSecure);

}
