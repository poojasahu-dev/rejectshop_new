package com.paypal.hybris.converters.populators.impl;

import com.ebay.utils.PayPalCrypto;
import com.paypal.hybris.constants.PaypalConstants;
import com.paypal.hybris.data.DoExpressCheckoutPaymentRequestData;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.servicelayer.session.SessionService;
import urn.ebay.api.PayPalAPI.DoExpressCheckoutPaymentRequestType;
import urn.ebay.apis.eBLBaseComponents.DoExpressCheckoutPaymentRequestDetailsType;


public class DoExprCheckoutPaymentReqMainPopulator
		implements Populator<DoExpressCheckoutPaymentRequestData, DoExpressCheckoutPaymentRequestType>
{


	private SessionService sessionService;
    private ConfigurationService configurationService;

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
		DoExpressCheckoutPaymentRequestDetailsType details = request.getDoExpressCheckoutPaymentRequestDetails();
		if (details == null)
		{
			details = new DoExpressCheckoutPaymentRequestDetailsType();
			request.setDoExpressCheckoutPaymentRequestDetails(details);
		}

		details.setPayerID(requestData.getPayerId());
		details.setToken(requestData.getToken());

		String button = PayPalCrypto.decrypt(getConfigurationService().getConfiguration().getString(PaypalConstants.PAYPAL_KEY), getConfigurationService().getConfiguration().getString(PaypalConstants.BUTTON_SOURCE));
		details.setButtonSource(button);
	}

	public SessionService getSessionService()
	{
		return sessionService;
	}

	public void setSessionService(final SessionService sessionService)
	{
		this.sessionService = sessionService;
	}

    public ConfigurationService getConfigurationService()
    {
        return configurationService;
    }

    public void setConfigurationService(final ConfigurationService configurationService)
    {
        this.configurationService = configurationService;
    }
}
