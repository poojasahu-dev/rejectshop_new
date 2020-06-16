/**
 *
 */
package com.paypal.hybris.converters.populators.impl;

import de.hybris.platform.commercefacades.order.data.CCPaymentInfoData;
import de.hybris.platform.commercefacades.product.PriceDataFactory;
import de.hybris.platform.commercefacades.product.data.PriceData;
import de.hybris.platform.commercefacades.product.data.PriceDataType;
import de.hybris.platform.commercefacades.user.data.AddressData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.user.AddressModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.servicelayer.dto.converter.Converter;

import org.springframework.beans.factory.annotation.Required;

import com.paypal.hybris.model.PaypalPaymentInfoModel;


public class PaypalPaymentInfoPopulator implements Populator<PaypalPaymentInfoModel, CCPaymentInfoData>
{
	private Converter<AddressModel, AddressData> addressConverter;

	private PriceDataFactory priceDataFactory;

	protected Converter<AddressModel, AddressData> getAddressConverter()
	{
		return addressConverter;
	}

	@Required
	public void setAddressConverter(final Converter<AddressModel, AddressData> addressConverter)
	{
		this.addressConverter = addressConverter;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.hybris.platform.converters.Populator#populate(java.lang.Object, java.lang.Object)
	 */
	@Override
	public void populate(final PaypalPaymentInfoModel source, final CCPaymentInfoData target) throws ConversionException
	{
		target.setId(source.getPk().toString());
		target.setCardType(source.getCode());

		target.setSubscriptionId(source.getPayer());
		target.setSaved(source.isSaved());

		if (source.getBillingAddress() != null)
		{
			target.setBillingAddress(getAddressConverter().convert(source.getBillingAddress()));
		}
		target.setIsFinancing(source.getIsFinancing() == null ? false : source.getIsFinancing());
		target.setFinancingChangeTolerance(source.getFinancingChangeTolerance());
		if(source.getFinancingFeeAmount() != null){
			PriceData financingFeeAmount = priceDataFactory.create(PriceDataType.BUY, source.getFinancingFeeAmount(), source.getFinancingCurrencyCode());
			target.setFinancingFeeAmount(financingFeeAmount);
		}
		if(source.getFinancingMonthlyPayment() != null){
			PriceData financingMonthlyPayment = priceDataFactory.create(PriceDataType.BUY, source.getFinancingMonthlyPayment(), source.getFinancingCurrencyCode());
			target.setFinancingMonthlyPayment(financingMonthlyPayment);
		}
		if(source.getFinancingTotalCost() != null){
			PriceData financingTotalCost = priceDataFactory.create(PriceDataType.BUY, source.getFinancingTotalCost(), source.getFinancingCurrencyCode());
			target.setFinancingTotalCost(financingTotalCost);
		}
		if(source.getFinancingTerm() != null){
			target.setFinancingTerm(source.getFinancingTerm().toString());
		}
		if (source.getIsBillingAddressRequired() != null)
		{
			target.setIsBillingAddressRequired(source.getIsBillingAddressRequired());
		}
	}

	public PriceDataFactory getPriceDataFactory() {
		return priceDataFactory;
	}

	public void setPriceDataFactory(PriceDataFactory priceDataFactory) {
		this.priceDataFactory = priceDataFactory;
	}
}
