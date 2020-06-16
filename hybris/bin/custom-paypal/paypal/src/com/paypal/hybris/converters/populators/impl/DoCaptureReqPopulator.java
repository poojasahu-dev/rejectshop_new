package com.paypal.hybris.converters.populators.impl;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.StringUtils;

import com.ebay.utils.PaypalStringUtils;
import com.paypal.hybris.data.DoCaptureRequestData;

import urn.ebay.api.PayPalAPI.DoCaptureRequestType;
import urn.ebay.apis.CoreComponentTypes.BasicAmountType;
import urn.ebay.apis.eBLBaseComponents.CompleteCodeType;
import urn.ebay.apis.eBLBaseComponents.CurrencyCodeType;


public class DoCaptureReqPopulator implements Populator<DoCaptureRequestData, DoCaptureRequestType>
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
	public void populate(final DoCaptureRequestData requestData, final DoCaptureRequestType request) throws ConversionException
	{
		request.setAuthorizationID(requestData.getAuthorizationId());
		if (StringUtils.isBlank(requestData.getCurrencyIsoCode()))
		{
			throw new ConversionException("Missing required currency iso code value");
		}
		final CurrencyCodeType currencyCode = CurrencyCodeType.fromValue(requestData.getCurrencyIsoCode());
		final BasicAmountType amount = createBasicAmountType(requestData.getAmount(), currencyCode);
		request.setAmount(amount);

		if (requestData.getComplete() != null && BooleanUtils.isTrue(requestData.getComplete()))
		{
			request.setCompleteType(CompleteCodeType.COMPLETE);
		}
		else
		{
			request.setCompleteType(CompleteCodeType.NOTCOMPLETE);
		}
	}

	protected BasicAmountType createBasicAmountType(final double amount, final CurrencyCodeType currencyCode)
	{
		final BasicAmountType basicAmount = new BasicAmountType();
		basicAmount.setValue(PaypalStringUtils.formatNumber(amount));
		basicAmount.setCurrencyID(currencyCode);
		return basicAmount;
	}
}
