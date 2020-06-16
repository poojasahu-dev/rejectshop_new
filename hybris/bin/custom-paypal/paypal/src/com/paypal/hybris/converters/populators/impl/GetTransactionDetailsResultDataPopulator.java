package com.paypal.hybris.converters.populators.impl;

import java.util.Calendar;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.log4j.Logger;
import com.ebay.utils.PaypalStringUtils;
import com.paypal.hybris.constants.PaypalConstants;
import com.paypal.hybris.data.GetTransactionDetailsResultData;
import com.paypal.hybris.data.PayerName;
import com.paypal.hybris.data.PayerStatus;
import com.paypal.hybris.data.PaymentCode;
import com.paypal.hybris.data.PaymentStatus;
import com.paypal.hybris.data.PendingReason;
import com.paypal.hybris.data.TransactionType;

import de.hybris.platform.commercefacades.user.data.AddressData;
import de.hybris.platform.commercefacades.user.data.CountryData;
import de.hybris.platform.commercefacades.user.data.RegionData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import urn.ebay.api.PayPalAPI.GetTransactionDetailsResponseType;
import urn.ebay.apis.CoreComponentTypes.BasicAmountType;
import urn.ebay.apis.eBLBaseComponents.AddressType;
import urn.ebay.apis.eBLBaseComponents.CountryCodeType;
import urn.ebay.apis.eBLBaseComponents.PayPalUserStatusCodeType;
import urn.ebay.apis.eBLBaseComponents.PayerInfoType;
import urn.ebay.apis.eBLBaseComponents.PaymentCodeType;
import urn.ebay.apis.eBLBaseComponents.PaymentInfoType;
import urn.ebay.apis.eBLBaseComponents.PaymentStatusCodeType;
import urn.ebay.apis.eBLBaseComponents.PaymentTransactionCodeType;
import urn.ebay.apis.eBLBaseComponents.PaymentTransactionType;
import urn.ebay.apis.eBLBaseComponents.PendingStatusCodeType;
import urn.ebay.apis.eBLBaseComponents.PersonNameType;
import urn.ebay.apis.eBLBaseComponents.ReceiverInfoType;


public class GetTransactionDetailsResultDataPopulator
		implements Populator<GetTransactionDetailsResponseType, GetTransactionDetailsResultData>
{
	/**
	 * Populate the target instance with values from the source instance.
	 *
	 * @param response
	 *           the source object
	 * @param resultData
	 *           the target to fill
	 * @throws ConversionException
	 *            if an error occurs
	 */

	private static final Logger LOG = Logger.getLogger(GetTransactionDetailsResultDataPopulator.class);

	@Override
	public void populate(final GetTransactionDetailsResponseType response, final GetTransactionDetailsResultData resultData)
			throws ConversionException
	{
		final PaymentTransactionType transactionDetails = response.getPaymentTransactionDetails();
		if (transactionDetails != null)
		{
			resultData.setTPLReferenceID(transactionDetails.getTPLReferenceID());

			final ReceiverInfoType receiverInfo = transactionDetails.getReceiverInfo();
			populateReceiverInfo(resultData, receiverInfo);

			final PayerInfoType payerInfo = transactionDetails.getPayerInfo();
			populatePayerInfo(resultData, payerInfo);

			final PaymentInfoType paymentInfo = transactionDetails.getPaymentInfo();
			populatePaymentInfo(resultData, paymentInfo);

		}
	}

	private void populatePaymentInfo(final GetTransactionDetailsResultData resultData, final PaymentInfoType paymentInfo)
	{
		if (paymentInfo != null)
		{
			resultData.setTransactionId(paymentInfo.getTransactionID());
			resultData.setParentTransactionId(paymentInfo.getParentTransactionID());
			resultData.setReceiptId(paymentInfo.getReceiptID());
			resultData.setStoreId(paymentInfo.getStoreID());
			resultData.setSubject(paymentInfo.getSubject());
			resultData.setCurrencyCode(StringUtils.EMPTY);

			final PaymentTransactionCodeType transactionType = paymentInfo.getTransactionType();
			if (transactionType != null)
			{
				resultData.setTransactionType(TransactionType.valueOf(transactionType.name()));
			}
			final PaymentCodeType paymentType = paymentInfo.getPaymentType();
			if (paymentType != null)
			{
				resultData.setPaymentType(PaymentCode.valueOf(paymentType.getValue().toUpperCase()));
			}
			final Calendar paymentDate = PaypalStringUtils.getCalendarFromResponse(paymentInfo.getPaymentDate());
			if (paymentDate != null)
			{
				resultData.setPaymentData(paymentDate);
			}
			final PaymentStatusCodeType paymentStatus = paymentInfo.getPaymentStatus();
			if (paymentStatus != null) {
				LOG.info("Payment status from response: " + paymentStatus.getValue());
				resultData.setPaymentStatus(PaymentStatus.valueOf(paymentStatus.getValue().replace("-", "_").toUpperCase()));
			}
			final PendingStatusCodeType pendingReason = paymentInfo.getPendingReason();
			if (pendingReason != null)
			{
				resultData.setPendingReason(PendingReason.valueOf(pendingReason.name()));
			}

			final BasicAmountType grossAmount = paymentInfo.getGrossAmount();
			if (grossAmount != null)
			{
				resultData.setGrossAmount(NumberUtils.toDouble(grossAmount.getValue(), PaypalConstants.DEFAULT_AMOUNT_VALUE));
				resultData.setCurrencyCode(grossAmount.getCurrencyID().getValue());
			}
			final BasicAmountType feeAmount = paymentInfo.getFeeAmount();
			if (feeAmount != null)
			{
				resultData.setFeeAmount(NumberUtils.toDouble(feeAmount.getValue(), PaypalConstants.DEFAULT_AMOUNT_VALUE));
			}
			final BasicAmountType taxAmount = paymentInfo.getTaxAmount();
			if (taxAmount != null)
			{
				resultData.setTaxAmount(NumberUtils.toDouble(taxAmount.getValue(), PaypalConstants.DEFAULT_AMOUNT_VALUE));
			}

		}
	}

	private void populateReceiverInfo(final GetTransactionDetailsResultData resultData, final ReceiverInfoType receiverInfo)
	{
		if (receiverInfo != null)
		{
			resultData.setReceiverEmail(receiverInfo.getReceiver());
			resultData.setReceiverId(receiverInfo.getReceiverID());
		}
	}

	private void populatePayerInfo(final GetTransactionDetailsResultData resultData, final PayerInfoType payerInfo)
	{
		if (payerInfo != null)
		{
			resultData.setPayerEmail(payerInfo.getPayer());
			resultData.setPayerId(payerInfo.getPayerID());
			final PersonNameType payerName = payerInfo.getPayerName();
			if (payerName != null)
			{
				resultData.setPayerName(createPayerNameData(payerName));
			}

			final CountryCodeType payerCountry = payerInfo.getPayerCountry();
			if (payerCountry != null)
			{
				resultData.setPayerCountryIso(payerCountry.getValue());
			}

			final PayPalUserStatusCodeType payerStatus = payerInfo.getPayerStatus();
			if (payerStatus != null)
			{
				resultData.setPayerStatus(PayerStatus.valueOf(payerStatus.getValue().toUpperCase()));
			}

			final AddressType payerAddress = payerInfo.getAddress();
			if (payerAddress != null)
			{
				resultData.setPayerAddress(createAddressData(payerInfo, payerAddress));
			}
		}
	}

	private AddressData createAddressData(final PayerInfoType payerInfo, final AddressType address)
	{
		final AddressData addressData = new AddressData();

		final PersonNameType payerName = payerInfo.getPayerName();
		if (payerName != null)
		{
			addressData.setFirstName(payerName.getFirstName());
			addressData.setLastName(payerName.getLastName());
		}
		addressData.setId(address.getAddressID());
		addressData.setLine1(address.getStreet1());
		addressData.setLine2(address.getStreet2());
		addressData.setTown(address.getCityName());

		final String stateOrProvince = address.getStateOrProvince();
		final CountryCodeType country = address.getCountry();
		if (StringUtils.isNotBlank(stateOrProvince) && country != null)
		{
			final RegionData regionData = new RegionData();
			regionData.setIsocode(country.getValue() + "-" + stateOrProvince);
			addressData.setRegion(regionData);
		}
		if (country != null)
		{
			final CountryData countryData = new CountryData();
			countryData.setName(address.getCountryName());
			countryData.setIsocode(address.getCountry().getValue());
			addressData.setCountry(countryData);
		}

		return addressData;
	}

	private PayerName createPayerNameData(final PersonNameType payerName)
	{
		final PayerName payerNameData = new PayerName();
		payerNameData.setFirstName(payerName.getFirstName());
		payerNameData.setLastName(payerName.getLastName());
		payerNameData.setMiddleName(payerName.getMiddleName());
		payerNameData.setSalutation(payerName.getSalutation());
		payerNameData.setSuffix(payerName.getSuffix());

		return payerNameData;
	}
}
