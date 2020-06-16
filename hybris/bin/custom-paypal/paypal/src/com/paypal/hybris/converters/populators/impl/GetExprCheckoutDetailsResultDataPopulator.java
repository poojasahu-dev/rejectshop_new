package com.paypal.hybris.converters.populators.impl;

import de.hybris.platform.commercefacades.user.data.AddressData;
import de.hybris.platform.commercefacades.user.data.CountryData;
import de.hybris.platform.commercefacades.user.data.RegionData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.c2l.CountryModel;
import de.hybris.platform.core.model.c2l.RegionModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;
import de.hybris.platform.servicelayer.i18n.CommonI18NService;

import java.math.BigDecimal;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.paypal.hybris.data.GetExpressCheckoutDetailsResultData;

import urn.ebay.api.PayPalAPI.GetExpressCheckoutDetailsResponseType;
import urn.ebay.apis.eBLBaseComponents.AddressType;
import urn.ebay.apis.eBLBaseComponents.GetExpressCheckoutDetailsResponseDetailsType;
import urn.ebay.apis.eBLBaseComponents.PayerInfoType;
import urn.ebay.apis.eBLBaseComponents.PaymentInfoType;


public class GetExprCheckoutDetailsResultDataPopulator
		implements Populator<GetExpressCheckoutDetailsResponseType, GetExpressCheckoutDetailsResultData>
{
	private static final Logger LOG = Logger.getLogger(GetExprCheckoutDetailsResultDataPopulator.class);

	private CommonI18NService commonI18NService;

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
	public void populate(final GetExpressCheckoutDetailsResponseType response,
			final GetExpressCheckoutDetailsResultData resultData) throws ConversionException
	{
		final GetExpressCheckoutDetailsResponseDetailsType details = response.getGetExpressCheckoutDetailsResponseDetails();

		if (details != null)
		{
			final PayerInfoType payerInfo = details.getPayerInfo();
			if (payerInfo != null)
			{
				resultData.setPayerId(payerInfo.getPayerID());
				resultData.setPayer(payerInfo.getPayer()); // email
				resultData.setPayerFirstName(payerInfo.getPayerName().getFirstName());
				resultData.setPayerLastName(payerInfo.getPayerName().getLastName());
				final AddressType address = details.getBillingAddress();
				if (address != null)
				{
					final AddressData billingAddress = new AddressData();
					final CountryData country = new CountryData();
					country.setName(address.getCountryName());
					country.setIsocode(address.getCountry().getValue());
					billingAddress.setCountry(country);
					final RegionData region = new RegionData();
					if (StringUtils.isNotBlank(address.getStateOrProvince()))
					{
						final CountryModel countryModel = getCommonI18NService().getCountry(country.getIsocode());
						final String isocode = country.getIsocode().concat("-").concat(address.getStateOrProvince());
						try
						{
							final RegionModel regionModel = getCommonI18NService().getRegion(countryModel, isocode);

							region.setIsocode(regionModel.getIsocode());
							billingAddress.setRegion(region);
						}
						catch (final UnknownIdentifierException e)
						{
							LOG.warn("No region with the code " + isocode + " found.");
						}
					}
					billingAddress.setId(address.getAddressID());
					billingAddress.setTown(address.getCityName());
					billingAddress.setPhone(address.getPhone());
					billingAddress.setPostalCode(address.getPostalCode());
					billingAddress.setLine1(address.getStreet1());
					billingAddress.setLine2(address.getStreet2());
					billingAddress.setEmail(payerInfo.getPayer());
					billingAddress.setFirstName(payerInfo.getPayerName().getFirstName());
					billingAddress.setLastName(payerInfo.getPayerName().getLastName());
					billingAddress.setBillingAddress(true);
					billingAddress.setShippingAddress(false);
					billingAddress.setVisibleInAddressBook(false);
					resultData.setBillingAddress(billingAddress);
				}
			}

			if (CollectionUtils.isNotEmpty(details.getPaymentDetails()))
			{
				// TODO: get here delivery address and name
				LOG.info("details.getPaymentDetails.size: " + details.getPaymentDetails().size());
				final AddressType addressType = details.getPaymentDetails().get(0).getShipToAddress();
				if (addressType != null)
				{
					resultData.setAddressName(addressType.getName());
					resultData.setAddressId(addressType.getAddressID());
					resultData.setLine1(addressType.getStreet1());
					resultData.setLine2(addressType.getStreet2());
					resultData.setTown(addressType.getCityName());
					resultData.setPostalCode(addressType.getPostalCode());
					resultData.setStateOrProvince(addressType.getStateOrProvince());

					AddressData addressData = new AddressData();
					addressData.setTitle(addressType.getName());
					addressData.setId(addressType.getAddressID());
					addressData.setLine1(addressType.getStreet1());
					addressData.setLine2(addressType.getStreet2());
					addressData.setTown(addressType.getCityName());
					addressData.setPostalCode(addressType.getPostalCode());
					addressData.setFormattedAddress("Address: " + addressType.getName() + ", " +
					        addressType.getAddressID() + ", " +
					        addressType.getStreet1() + ", " +
					        addressType.getStreet2() + ", " +
					        addressType.getCityName() + ", " +
					        addressType.getPostalCode());
					resultData.setDeliveryAddress(addressData);

//					override ship to name from GetCheckoutDetails response
					resultData.setPayerFirstName(addressType.getName());
					resultData.setPayerLastName(StringUtils.EMPTY);

					if (addressType.getCountry() != null)
					{
						resultData.setCountryIsoCode(addressType.getCountry().getValue());
						CountryData countryData = new CountryData();
						countryData.setIsocode(addressType.getCountry().getValue());
						addressData.setCountry(countryData);
					}
				}
			}
			if (CollectionUtils.isNotEmpty(details.getPaymentInfo()))
			{
				final PaymentInfoType paymentInfo = details.getPaymentInfo().get(0);
				if (paymentInfo != null && Boolean.parseBoolean(paymentInfo.getIsFinancing()))
				{
					resultData.setIsFinancing(true);
					if (paymentInfo.getFinancingFeeAmount() != null)
					{
						resultData.setFinancingFeeAmount(
								BigDecimal.valueOf(Double.parseDouble(paymentInfo.getFinancingFeeAmount().getValue())));
					}
					if (paymentInfo.getFinancingMonthlyPayment() != null)
					{
						resultData.setFinancingMonthlyPayment(
								BigDecimal.valueOf(Double.parseDouble(paymentInfo.getFinancingMonthlyPayment().getValue())));
					}
					if (paymentInfo.getFinancingTerm() != null)
					{
						resultData.setFinancingTerm(Integer.parseInt(paymentInfo.getFinancingTerm()));
					}
					if (paymentInfo.getFinancingTotalCost() != null)
					{
						resultData.setFinancingTotalCost(
								BigDecimal.valueOf(Double.parseDouble(paymentInfo.getFinancingTotalCost().getValue())));
						resultData.setFinancingCurrencyCode(paymentInfo.getFinancingTotalCost().getCurrencyID().getValue());
					}
					resultData.setFinancingChangeTolerance(details.getCartChangeTolerance());

				}
				else
				{
					resultData.setIsFinancing(Boolean.FALSE);
				}
			}


		}
	}

	public CommonI18NService getCommonI18NService()
	{
		return commonI18NService;
	}

	public void setCommonI18NService(final CommonI18NService commonI18NService)
	{
		this.commonI18NService = commonI18NService;
	}
}
