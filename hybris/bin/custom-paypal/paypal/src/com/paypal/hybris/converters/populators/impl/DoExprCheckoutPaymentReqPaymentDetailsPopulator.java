package com.paypal.hybris.converters.populators.impl;

import de.hybris.platform.commercefacades.order.data.CartData;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

import java.util.List;

import com.paypal.hybris.converters.populators.AbstractRequestPaymentDetailsPopulator;
import com.paypal.hybris.data.DoExpressCheckoutPaymentRequestData;

import urn.ebay.api.PayPalAPI.DoExpressCheckoutPaymentRequestType;
import urn.ebay.apis.eBLBaseComponents.DoExpressCheckoutPaymentRequestDetailsType;
import urn.ebay.apis.eBLBaseComponents.PaymentDetailsType;


public class DoExprCheckoutPaymentReqPaymentDetailsPopulator
		extends AbstractRequestPaymentDetailsPopulator<DoExpressCheckoutPaymentRequestData, DoExpressCheckoutPaymentRequestType>
{
	/**
	 * Populate the target instance with values from the source instance.
	 *
	 * @param requestData
	 *           the source object
	 * @param request
	 *           the target to fill
	 * @throws de.hybris.platform.servicelayer.dto.converter.ConversionException
	 *            if an error occurs
	 */
	@Override
	public void populate(final DoExpressCheckoutPaymentRequestData requestData, final DoExpressCheckoutPaymentRequestType request)
			throws ConversionException
	{
		final CartData cartData = requestData.getSessionCart();
		final List<PaymentDetailsType> paymentDetails = createPaymentDetailsList(requestData, cartData);
		DoExpressCheckoutPaymentRequestDetailsType requestDetails = request.getDoExpressCheckoutPaymentRequestDetails();
		if (requestDetails == null)
		{
			requestDetails = new DoExpressCheckoutPaymentRequestDetailsType();
			request.setDoExpressCheckoutPaymentRequestDetails(requestDetails);
		}
		requestDetails.getPaymentDetails().addAll(paymentDetails);

		setPaymentActionForAllPaymentDetails(requestData.getPaymentAction(), requestDetails.getPaymentDetails());

	}

}
