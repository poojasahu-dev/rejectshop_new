package com.paypal.hybris.commands.converters.impl;

import de.hybris.platform.payment.commands.request.CaptureRequest;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.servicelayer.dto.converter.Converter;

import org.apache.commons.lang.StringUtils;

import com.ebay.utils.PaypalStringUtils;
import com.paypal.hybris.constants.PaypalConstants;

import urn.ebay.api.PayPalAPI.DoCaptureRequestType;
import urn.ebay.apis.CoreComponentTypes.BasicAmountType;
import urn.ebay.apis.eBLBaseComponents.CompleteCodeType;
import urn.ebay.apis.eBLBaseComponents.CurrencyCodeType;


public class CaptureRequestConverter implements Converter<CaptureRequest, DoCaptureRequestType>
{

	/**
	 * Convert data from source object to target
	 *
	 * @param captureRequest
	 *           the source instance
	 * @return converted item
	 */
	@Override
	public DoCaptureRequestType convert(final CaptureRequest captureRequest) throws ConversionException
	{
		final DoCaptureRequestType doCaptureRequestType = new DoCaptureRequestType();
		return convert(captureRequest, doCaptureRequestType);
	}

	/**
	 * Convert data from source object to target. Deprecated user
	 * {@link this.convert(de.hybris.platform.payment.commands.request.CaptureRequest)}
	 * 
	 * @param captureRequest
	 *           source object
	 * @param doCaptureRequestPrototype
	 *           prototype object
	 * @return conv
	 * @throws ConversionException
	 */
	@Override
	@Deprecated
	public DoCaptureRequestType convert(final CaptureRequest captureRequest, final DoCaptureRequestType doCaptureRequestPrototype)
			throws ConversionException
	{
		doCaptureRequestPrototype.setVersion(PaypalConstants.SOAP_API_VERSION);

		doCaptureRequestPrototype.setAuthorizationID(captureRequest.getRequestId());
		if (StringUtils.isBlank(captureRequest.getCurrency().getCurrencyCode()))
		{
			throw new ConversionException("Missing required currency iso code value");
		}
		final CurrencyCodeType currencyCode = CurrencyCodeType.fromValue(captureRequest.getCurrency().getCurrencyCode());
		final BasicAmountType amount = createBasicAmountType(captureRequest.getTotalAmount().doubleValue(), currencyCode);
		doCaptureRequestPrototype.setAmount(amount);

		// capture all amount at once
		doCaptureRequestPrototype.setCompleteType(CompleteCodeType.COMPLETE);
		return doCaptureRequestPrototype;
	}

	protected BasicAmountType createBasicAmountType(final double amount, final CurrencyCodeType currencyCode)
	{
		final BasicAmountType basicAmount = new BasicAmountType();
		basicAmount.setValue(PaypalStringUtils.formatNumber(amount));
		basicAmount.setCurrencyID(currencyCode);
		return basicAmount;
	}
}
