package com.paypal.hybris.converters.populators.impl;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

import com.paypal.hybris.data.SetExpressCheckoutResultData;

import urn.ebay.api.PayPalAPI.SetExpressCheckoutResponseType;


public class SetExprCheckoutResultDataPopulator implements Populator<SetExpressCheckoutResponseType, SetExpressCheckoutResultData>
{
	/**
	 * Populate the target instance with values from the source instance.
	 *
	 * @param response
	 *           the source object
	 * @param resultData
	 *           the target to fill
	 * @throws de.hybris.platform.servicelayer.dto.converter.ConversionException
	 *            if an error occurs
	 */
	@Override
	public void populate(final SetExpressCheckoutResponseType response, final SetExpressCheckoutResultData resultData)
			throws ConversionException
	{
		resultData.setToken(response.getToken());
	}
}
