package com.paypal.hybris.converters.populators.impl;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

import com.paypal.hybris.data.GetExpressCheckoutDetailsRequestData;

import urn.ebay.api.PayPalAPI.GetExpressCheckoutDetailsRequestType;


public class GetExprCheckoutDetailsReqPopulator
		implements Populator<GetExpressCheckoutDetailsRequestData, GetExpressCheckoutDetailsRequestType>
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
	public void populate(final GetExpressCheckoutDetailsRequestData requestData,
			final GetExpressCheckoutDetailsRequestType request) throws ConversionException
	{
		request.setToken(requestData.getToken());
	}
}
