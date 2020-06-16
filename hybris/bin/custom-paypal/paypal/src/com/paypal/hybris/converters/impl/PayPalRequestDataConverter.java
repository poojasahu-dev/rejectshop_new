package com.paypal.hybris.converters.impl;

import de.hybris.platform.converters.impl.AbstractPopulatingConverter;

import java.util.Locale;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.paypal.hybris.constants.PaypalConstants;
import com.paypal.hybris.data.AbstractRequestData;

import urn.ebay.apis.eBLBaseComponents.AbstractRequestType;


public class PayPalRequestDataConverter extends AbstractPopulatingConverter<AbstractRequestData, AbstractRequestType>
{
    private static final Logger LOG = Logger.getLogger(PayPalRequestDataConverter.class);

	/**
	 * Populate the target instance from the source instance. Calls a list of injected populators to populate the
	 * instance.
	 *
	 * @param requestData
	 *           the source item
	 * @param request
	 */
	@Override
	public void populate(final AbstractRequestData requestData, final AbstractRequestType request)
	{
		LOG.info("populate requestData: " + requestData);

		final String apiVersion = requestData.getVersion();
		if (StringUtils.isBlank(apiVersion))
		{
			request.setVersion(PaypalConstants.SOAP_API_VERSION);
		}
		else
		{
			request.setVersion(apiVersion);
		}

		final Locale userLocale = requestData.getLocale();
		if (userLocale != null)
		{
			request.setErrorLanguage(userLocale.getLanguage());
		}

		super.populate(requestData, request);
	}
}
