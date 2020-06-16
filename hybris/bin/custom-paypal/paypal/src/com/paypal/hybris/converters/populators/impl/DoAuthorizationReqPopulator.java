package com.paypal.hybris.converters.populators.impl;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

import org.apache.commons.lang.StringUtils;

import com.ebay.utils.PaypalStringUtils;
import com.paypal.hybris.data.DoAuthorizationRequestData;

import urn.ebay.api.PayPalAPI.DoAuthorizationRequestType;
import urn.ebay.apis.CoreComponentTypes.BasicAmountType;
import urn.ebay.apis.eBLBaseComponents.CurrencyCodeType;


public class DoAuthorizationReqPopulator implements Populator<DoAuthorizationRequestData, DoAuthorizationRequestType>
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
	public void populate(final DoAuthorizationRequestData requestData, final DoAuthorizationRequestType request)
			throws ConversionException
	{
		request.setTransactionID(requestData.getTransactionId());

		if (StringUtils.isBlank(requestData.getCurrencyIsoCode()))
		{
			throw new ConversionException("Missing required currency iso code value");
		}
		final CurrencyCodeType currencyCode = CurrencyCodeType.fromValue(requestData.getCurrencyIsoCode());
		final BasicAmountType amount = createBasicAmountType(requestData.getAmount(), currencyCode);
		request.setAmount(amount);
	}

	private BasicAmountType createBasicAmountType(final double amount, final CurrencyCodeType currencyCode)
	{
		final BasicAmountType basicAmount = new BasicAmountType();
		basicAmount.setValue(PaypalStringUtils.formatNumber(amount));
		basicAmount.setCurrencyID(currencyCode);
		return basicAmount;
	}
}
