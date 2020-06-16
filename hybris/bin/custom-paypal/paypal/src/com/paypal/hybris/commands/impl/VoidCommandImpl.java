/**
 *
 */
package com.paypal.hybris.commands.impl;

import de.hybris.platform.payment.commands.VoidCommand;
import de.hybris.platform.payment.commands.request.VoidRequest;
import de.hybris.platform.payment.commands.result.VoidResult;
import de.hybris.platform.servicelayer.dto.converter.Converter;

import com.paypal.hybris.integration.service.PaypalPaymentIntegrationService;

import urn.ebay.api.PayPalAPI.DoVoidReq;
import urn.ebay.api.PayPalAPI.DoVoidRequestType;
import urn.ebay.api.PayPalAPI.DoVoidResponseType;


public class VoidCommandImpl implements VoidCommand
{
	private PaypalPaymentIntegrationService paypalPaymentIntegrationService;
	private Converter<VoidRequest, DoVoidRequestType> voidRequestConverter;
	private Converter<DoVoidResponseType, VoidResult> doVoidResponseConverter;


	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.platform.payment.commands.Command#perform(java.lang.Object)
	 */
	@Override
	public VoidResult perform(final VoidRequest voidRequest)
	{
		VoidResult voidRes = null;
		DoVoidResponseType voidResp = null;
		final DoVoidRequestType voidRequestType = voidRequestConverter.convert(voidRequest);

		if (voidRequestType != null)
		{
			final DoVoidReq req = new DoVoidReq();
			req.setDoVoidRequest(voidRequestType);
			voidResp = paypalPaymentIntegrationService.doVoid(voidRequestType);
		}

		if (voidResp != null)
		{
			voidRes = doVoidResponseConverter.convert(voidResp);
		}

		return voidRes;
	}


	/**
	 * @return the paypalPaymentIntegrationService
	 */
	public PaypalPaymentIntegrationService getPaypalPaymentIntegrationService()
	{
		return paypalPaymentIntegrationService;
	}


	/**
	 * @param paypalPaymentIntegrationService
	 *           the paypalPaymentIntegrationService to set
	 */
	public void setPaypalPaymentIntegrationService(final PaypalPaymentIntegrationService paypalPaymentIntegrationService)
	{
		this.paypalPaymentIntegrationService = paypalPaymentIntegrationService;
	}


	/**
	 * @return the voidRequestConverter
	 */
	public Converter<VoidRequest, DoVoidRequestType> getVoidRequestConverter()
	{
		return voidRequestConverter;
	}


	/**
	 * @param voidRequestConverter
	 *           the voidRequestConverter to set
	 */
	public void setVoidRequestConverter(final Converter<VoidRequest, DoVoidRequestType> voidRequestConverter)
	{
		this.voidRequestConverter = voidRequestConverter;
	}


	/**
	 * @return the doVoidResponseConverter
	 */
	public Converter<DoVoidResponseType, VoidResult> getDoVoidResponseConverter()
	{
		return doVoidResponseConverter;
	}


	/**
	 * @param doVoidResponseConverter
	 *           the doVoidResponseConverter to set
	 */
	public void setDoVoidResponseConverter(final Converter<DoVoidResponseType, VoidResult> doVoidResponseConverter)
	{
		this.doVoidResponseConverter = doVoidResponseConverter;
	}



}
