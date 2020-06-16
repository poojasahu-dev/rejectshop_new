package com.paypal.hybris.payment.service;

import com.paypal.hybris.data.DoAuthorizationRequestData;
import com.paypal.hybris.data.DoAuthorizationResultData;
import com.paypal.hybris.data.DoCaptureRequestData;
import com.paypal.hybris.data.DoCaptureResultData;
import com.paypal.hybris.data.DoExpressCheckoutPaymentRequestData;
import com.paypal.hybris.data.DoExpressCheckoutPaymentResultData;
import com.paypal.hybris.data.DoReferenceTransactionRequestData;
import com.paypal.hybris.data.DoReferenceTransactionResultData;
import com.paypal.hybris.data.GetExpressCheckoutDetailsResultData;
import com.paypal.hybris.data.GetTransactionDetailsRequestData;
import com.paypal.hybris.data.GetTransactionDetailsResultData;
import com.paypal.hybris.data.RefundTransactionRequestData;
import com.paypal.hybris.data.RefundTransactionResultData;
import com.paypal.hybris.data.SetExpressCheckoutRequestData;
import com.paypal.hybris.data.SetExpressCheckoutResultData;
import com.paypal.hybris.model.PaypalPaymentInfoModel;

import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.payment.model.PaymentTransactionEntryModel;

import urn.ebay.api.PayPalAPI.DoReauthorizationRequestType;
import urn.ebay.api.PayPalAPI.DoReauthorizationResponseType;
import urn.ebay.api.PayPalAPI.DoVoidRequestType;
import urn.ebay.api.PayPalAPI.DoVoidResponseType;
import urn.ebay.api.PayPalAPI.RefundTransactionRequestType;
import urn.ebay.api.PayPalAPI.TransactionSearchRequestType;
import urn.ebay.api.PayPalAPI.TransactionSearchResponseType;


public interface PayPalPaymentService
{
	SetExpressCheckoutResultData setExpressCheckout(SetExpressCheckoutRequestData request);

	GetExpressCheckoutDetailsResultData getExpressCheckoutDetails();

	DoExpressCheckoutPaymentResultData doExpressCheckoutPayment(DoExpressCheckoutPaymentRequestData request);

	DoAuthorizationResultData doAuthorization(DoAuthorizationRequestData request);

	DoCaptureResultData doCapture(DoCaptureRequestData request);

	TransactionSearchResponseType transactionSearch(TransactionSearchRequestType request);

	DoReferenceTransactionResultData doReferenceTransaction(DoReferenceTransactionRequestData request);

	RefundTransactionResultData refundTransaction(RefundTransactionRequestData request);

	DoReauthorizationResponseType doReauthorization(DoReauthorizationRequestType request);

	GetTransactionDetailsResultData getTransactionDetails(GetTransactionDetailsRequestData request);

	DoVoidResponseType doVoid(DoVoidRequestType request, final OrderModel order);

	public boolean authorizePayment(DoExpressCheckoutPaymentResultData doExprCheckPaymentResData);

	public PaypalPaymentInfoModel getPayPalPaymentInfo();

	public RefundTransactionResultData doPartialRefund(RefundTransactionRequestType request);

	PaymentTransactionEntryModel getPaymentTransactionEntryByRequestID(String requestID);
}
