/**
 *
 */
package com.paypal.hybris.commands.converters.impl;

import de.hybris.platform.payment.commands.request.VoidRequest;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.servicelayer.dto.converter.Converter;

import com.paypal.hybris.constants.PaypalConstants;

import urn.ebay.api.PayPalAPI.DoVoidRequestType;


public class VoidRequestConverter implements Converter<VoidRequest, DoVoidRequestType>
{

	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.platform.servicelayer.dto.converter.Converter#convert(java.lang.Object)
	 */
	@Override
	public DoVoidRequestType convert(final VoidRequest voidRequest) throws ConversionException
	{
		final DoVoidRequestType doVoidRequest = new DoVoidRequestType();
		return convert(voidRequest, doVoidRequest);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.platform.servicelayer.dto.converter.Converter#convert(java.lang.Object, java.lang.Object)
	 */
	@Override
	public DoVoidRequestType convert(final VoidRequest voidRequest, final DoVoidRequestType doVoidRequest)
			throws ConversionException
	{
		doVoidRequest.setAuthorizationID(voidRequest.getRequestId());
		doVoidRequest.setVersion(PaypalConstants.SOAP_API_VERSION);
		return doVoidRequest;
	}

}
