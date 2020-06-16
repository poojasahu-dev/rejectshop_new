package com.paypal.hybris.commands.impl;

import de.hybris.platform.payment.commands.CaptureCommand;
import de.hybris.platform.payment.commands.request.CaptureRequest;
import de.hybris.platform.payment.commands.result.CaptureResult;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.dto.converter.Converter;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;

import com.paypal.hybris.commands.strategy.CaptureStrategy;
import com.paypal.hybris.constants.PaypalConstants;
import com.paypal.hybris.integration.service.PaypalPaymentIntegrationService;
import com.paypal.hybris.replenishment.service.PayPalReplenishmentService;

import urn.ebay.api.PayPalAPI.DoCaptureRequestType;
import urn.ebay.api.PayPalAPI.DoCaptureResponseType;


public class CaptureCommandImpl implements CaptureCommand {
    private final static Logger LOG = Logger.getLogger(CaptureCommandImpl.class);

	private PaypalPaymentIntegrationService paypalPaymentIntegrationService;
	private PayPalReplenishmentService payPalReplenishmentService;
	private Converter<CaptureRequest, DoCaptureRequestType> captureRequestConverter;
	private Converter<DoCaptureResponseType, CaptureResult> doCaptureResponseConverter;
	private CaptureStrategy captureStrategy;
	private ConfigurationService configurationService;

	@Override
	public CaptureResult perform(final CaptureRequest captureRequest)
	{
		CaptureResult captureResult = null;

		if (PaypalConstants.PAY_PAL_REPLENISHMENT_CAPTURE.equals(captureRequest.getRequestToken()))
		{
			captureResult = payPalReplenishmentService.proceedReplenishmentPlaceOrder(captureRequest);
		}
		else
		{
			captureResult = proceedSimplePlaceOrder(captureRequest);
		}

		return captureResult;
	}

	private CaptureResult proceedSimplePlaceOrder(final CaptureRequest captureRequest)
	{

		CaptureResult captureResult = null;

		if (captureStrategy.allowCapture(captureRequest.getTotalAmount()))
		{
			// convert to web service request
			final DoCaptureRequestType request = captureRequestConverter.convert(captureRequest);

			// call web service capture method
			DoCaptureResponseType response = null;
			if (request != null)
			{
				response = paypalPaymentIntegrationService.doCapture(request);
			}

			// convert from web service response to result data
			if (response != null)
			{
				captureResult = doCaptureResponseConverter.convert(response);
			}
		}

		return captureResult;
	}


	/**
	 * @param paypalPaymentIntegrationService
	 *           the paypalPaymentIntegrationService to set
	 */
	public void setPaypalPaymentIntegrationService(final PaypalPaymentIntegrationService paypalPaymentIntegrationService)
	{
		this.paypalPaymentIntegrationService = paypalPaymentIntegrationService;
	}


	@Required
	public void setCaptureRequestConverter(final Converter<CaptureRequest, DoCaptureRequestType> captureRequestConverter)
	{
		this.captureRequestConverter = captureRequestConverter;
	}

	@Required
	public void setDoCaptureResponseConverter(final Converter<DoCaptureResponseType, CaptureResult> doCaptureResponseConverter)
	{
		this.doCaptureResponseConverter = doCaptureResponseConverter;
	}

	/**
	 * @param captureStrategy
	 *           the captureStrategy to set
	 */
	@Required
	public void setCaptureStrategy(final CaptureStrategy captureStrategy)
	{
		this.captureStrategy = captureStrategy;
	}

	/**
	 * @return the configurationService
	 */
	public ConfigurationService getConfigurationService()
	{
		return configurationService;
	}

	/**
	 * @param configurationService
	 *           the configurationService to set
	 */
	public void setConfigurationService(final ConfigurationService configurationService)
	{
		this.configurationService = configurationService;
	}


	/**
	 * @return the paypalPaymentIntegrationService
	 */
	public PaypalPaymentIntegrationService getPaypalPaymentIntegrationService()
	{
		return paypalPaymentIntegrationService;
	}

	/**
	 * @return the captureRequestConverter
	 */
	public Converter<CaptureRequest, DoCaptureRequestType> getCaptureRequestConverter()
	{
		return captureRequestConverter;
	}

	/**
	 * @return the doCaptureResponseConverter
	 */
	public Converter<DoCaptureResponseType, CaptureResult> getDoCaptureResponseConverter()
	{
		return doCaptureResponseConverter;
	}

	/**
	 * @return the captureStrategy
	 */
	public CaptureStrategy getCaptureStrategy()
	{
		return captureStrategy;
	}

	/**
	 * @return the payPalReplenishmentService
	 */
	public PayPalReplenishmentService getPayPalReplenishmentService()
	{
		return payPalReplenishmentService;
	}

	/**
	 * @param payPalReplenishmentService
	 *           the payPalReplenishmentService to set
	 */
	public void setPayPalReplenishmentService(final PayPalReplenishmentService payPalReplenishmentService)
	{
		this.payPalReplenishmentService = payPalReplenishmentService;
	}

}
