package com.paypal.hybris.integration.service;

import com.paypal.hybris.data.DoAuthorizationRequestData;
import com.paypal.hybris.data.DoAuthorizationResultData;
import com.paypal.hybris.data.DoCaptureRequestData;
import com.paypal.hybris.data.DoCaptureResultData;
import com.paypal.hybris.data.DoExpressCheckoutPaymentRequestData;
import com.paypal.hybris.data.DoExpressCheckoutPaymentResultData;
import com.paypal.hybris.data.DoReferenceTransactionRequestData;
import com.paypal.hybris.data.DoReferenceTransactionResultData;
import com.paypal.hybris.data.GetExpressCheckoutDetailsRequestData;
import com.paypal.hybris.data.GetExpressCheckoutDetailsResultData;
import com.paypal.hybris.data.GetTransactionDetailsRequestData;
import com.paypal.hybris.data.GetTransactionDetailsResultData;
import com.paypal.hybris.data.RefundTransactionRequestData;
import com.paypal.hybris.data.RefundTransactionResultData;
import com.paypal.hybris.data.SetExpressCheckoutRequestData;
import com.paypal.hybris.data.SetExpressCheckoutResultData;

import urn.ebay.api.PayPalAPI.DoCaptureRequestType;
import urn.ebay.api.PayPalAPI.DoCaptureResponseType;
import urn.ebay.api.PayPalAPI.DoReauthorizationRequestType;
import urn.ebay.api.PayPalAPI.DoReauthorizationResponseType;
import urn.ebay.api.PayPalAPI.DoVoidRequestType;
import urn.ebay.api.PayPalAPI.DoVoidResponseType;
import urn.ebay.api.PayPalAPI.RefundTransactionRequestType;
import urn.ebay.api.PayPalAPI.TransactionSearchRequestType;
import urn.ebay.api.PayPalAPI.TransactionSearchResponseType;


public interface PaypalPaymentIntegrationService
{

	SetExpressCheckoutResultData setExpressCheckout(SetExpressCheckoutRequestData request);

	GetExpressCheckoutDetailsResultData getExpressCheckoutDetails(GetExpressCheckoutDetailsRequestData request);

	DoExpressCheckoutPaymentResultData doExpressCheckoutPayment(DoExpressCheckoutPaymentRequestData request);

	DoAuthorizationResultData doAuthorization(DoAuthorizationRequestData request);

	DoCaptureResultData doCapture(DoCaptureRequestData request);

	DoCaptureResponseType doCapture(DoCaptureRequestType request);

	TransactionSearchResponseType transactionSearch(TransactionSearchRequestType request);

	DoReferenceTransactionResultData doReferenceTransaction(DoReferenceTransactionRequestData request);

	RefundTransactionResultData refundTransaction(RefundTransactionRequestData request);

	DoReauthorizationResponseType doReauthorization(DoReauthorizationRequestType request);

	GetTransactionDetailsResultData getTransactionDetails(GetTransactionDetailsRequestData request);

	DoVoidResponseType doVoid(DoVoidRequestType request);

	public RefundTransactionResultData doPartialRefund(RefundTransactionRequestType request);
}