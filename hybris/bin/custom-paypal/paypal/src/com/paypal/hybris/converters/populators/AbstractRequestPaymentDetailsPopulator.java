package com.paypal.hybris.converters.populators;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import com.ebay.utils.PayPalCrypto;
import com.paypal.hybris.constants.PaypalConstants;
import com.paypal.hybris.data.AbstractRequestData;

import de.hybris.platform.commercefacades.order.data.AbstractOrderData;
import de.hybris.platform.commercefacades.order.data.DeliveryOrderEntryGroupData;
import de.hybris.platform.commercefacades.order.data.OrderEntryData;
import de.hybris.platform.commercefacades.order.data.OrderEntryGroupData;
import de.hybris.platform.commercefacades.order.data.PickupOrderEntryGroupData;
import de.hybris.platform.commercefacades.product.PriceDataFactory;
import de.hybris.platform.commercefacades.product.data.PriceData;
import de.hybris.platform.commercefacades.product.data.PriceDataType;
import de.hybris.platform.commercefacades.storelocator.data.PointOfServiceData;
import de.hybris.platform.commercefacades.user.data.AddressData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.session.SessionService;
import urn.ebay.apis.CoreComponentTypes.BasicAmountType;
import urn.ebay.apis.eBLBaseComponents.AddressType;
import urn.ebay.apis.eBLBaseComponents.CountryCodeType;
import urn.ebay.apis.eBLBaseComponents.CurrencyCodeType;
import urn.ebay.apis.eBLBaseComponents.PaymentActionCodeType;
import urn.ebay.apis.eBLBaseComponents.PaymentDetailsItemType;
import urn.ebay.apis.eBLBaseComponents.PaymentDetailsType;
import urn.ebay.apis.eBLBaseComponents.SellerDetailsType;


public abstract class AbstractRequestPaymentDetailsPopulator<SOURCE, TARGET> implements Populator<SOURCE, TARGET>
{

	private static final Logger LOG = Logger.getLogger(AbstractRequestPaymentDetailsPopulator.class);

	private ConfigurationService configurationService;
	private PriceDataFactory priceDataFactory;
	private SessionService sessionService;

	protected List<PaymentDetailsType> createPaymentDetailsList(final AbstractRequestData requestData,
			final AbstractOrderData cart)
	{
		// support only one currency type for all cart prices
		final List<PaymentDetailsType> detailsList = new ArrayList<>();
		final AddressData deliveryAddress = cart.getDeliveryAddress();
		final List<OrderEntryGroupData> orderEntryGroupDataList = new ArrayList<>();
		final List<DeliveryOrderEntryGroupData> deliveryGroups = cart.getDeliveryOrderGroups();
		for (final DeliveryOrderEntryGroupData deliveryGroup : deliveryGroups)
		{
			deliveryGroup.setDeliveryAddress(deliveryAddress);
			//final PaymentDetailsType paymentDetails = createPaymentDetails(cart, deliveryGroup, detailsList.size());
			//detailsList.add(paymentDetails);
		}
		orderEntryGroupDataList.addAll(deliveryGroups);

		final List<PickupOrderEntryGroupData> pickupGroups = cart.getPickupOrderGroups();
//		for (final PickupOrderEntryGroupData pickupGroup : pickupGroups)
//		{
//			final PaymentDetailsType paymentDetails = createPaymentDetails(cart, pickupGroup, detailsList.size());
//			detailsList.add(paymentDetails);
//		}
		orderEntryGroupDataList.addAll(pickupGroups);
		for (final OrderEntryGroupData orderEntryGroupData : orderEntryGroupDataList)
		{
			final PaymentDetailsType paymentDetails = createPaymentDetails(cart, orderEntryGroupData, detailsList.size());
			detailsList.add(paymentDetails);
		}
		changeRequestStructure(detailsList);

		if (BigDecimal.ZERO.compareTo(cart.getOrderDiscounts().getValue()) < 0)
		{
			assignOrderDiscountToPaymentDetails(detailsList, cart);
		}

		return detailsList;
	}

	protected void assignOrderDiscountToPaymentDetails(final List<PaymentDetailsType> detailsList, final AbstractOrderData cart)
	{
		for (final PaymentDetailsType paymentDetails : detailsList)
		{
			BigDecimal orderTotal = BigDecimal.valueOf(
					Double.valueOf(paymentDetails.getOrderTotal().getValue().replaceAll(PaypalConstants.THOUSAND_SEPARATOR, "")));
			BigDecimal itemTotal = BigDecimal.valueOf(
					Double.valueOf(paymentDetails.getItemTotal().getValue().replaceAll(PaypalConstants.THOUSAND_SEPARATOR, "")));
			if (orderTotal.compareTo(cart.getOrderDiscounts().getValue()) > 0)
			{
				orderTotal = orderTotal.subtract(cart.getOrderDiscounts().getValue().setScale(2, RoundingMode.HALF_UP));
				itemTotal = itemTotal.subtract(cart.getOrderDiscounts().getValue().setScale(2, RoundingMode.HALF_UP));
				paymentDetails.getOrderTotal().setValue(orderTotal.toString());
				paymentDetails.getItemTotal().setValue(itemTotal.toString());
				paymentDetails.getPaymentDetailsItem().add(createOrderDiscountPaymentItem(cart));
				break;
			}
		}
	}

	protected PaymentDetailsItemType createOrderDiscountPaymentItem(final AbstractOrderData cart)
	{

		final PaymentDetailsItemType detailsItem = new PaymentDetailsItemType();
		final BigDecimal discountValue = cart.getOrderDiscounts().getValue().setScale(2, RoundingMode.HALF_UP).negate();
		detailsItem.setName(PaypalConstants.ORDER_DISCOUNT);
		detailsItem.setQuantity(Integer.valueOf(1));
		detailsItem.setDescription(PaypalConstants.ORDER_DISCOUNT);

		final BasicAmountType basicAmount = new BasicAmountType();
		basicAmount.setValue(discountValue.toString());

		final String currencyIsoCode = cart.getOrderDiscounts().getCurrencyIso();
		final CurrencyCodeType currencyCode = CurrencyCodeType.valueOf(currencyIsoCode);

		basicAmount.setCurrencyID(currencyCode);

		detailsItem.setAmount(basicAmount);
		return detailsItem;
	}

	protected PaymentDetailsType createPaymentDetails(final AbstractOrderData cart, final OrderEntryGroupData entryGroup,
			final int groupNumber)
	{
		final PaymentDetailsType paymentDetails = new PaymentDetailsType();
		paymentDetails.setInvoiceID("hybris-" + System.currentTimeMillis() + "-" + groupNumber);
		paymentDetails.setSellerDetails(createSellerDetails());

		String button = PayPalCrypto.decrypt(getConfigurationService().getConfiguration().getString(PaypalConstants.PAYPAL_KEY), getConfigurationService().getConfiguration().getString(PaypalConstants.BUTTON_SOURCE));
		paymentDetails.setButtonSource(button);

		final String currencyIsoCode = entryGroup.getTotalPriceWithTax().getCurrencyIso();
		final CurrencyCodeType currencyCode = CurrencyCodeType.valueOf(currencyIsoCode);

		paymentDetails.setPaymentRequestID(cart.getCode() + PaypalConstants.PAYMENT_REQUEST_ID_SEPARATOR + groupNumber);

		for (final OrderEntryData entry : entryGroup.getEntries())
		{
			final PaymentDetailsItemType detailsItem = createPaymentDetailsItem(entry, currencyCode);
			paymentDetails.getPaymentDetailsItem().add(detailsItem);
			if (getSavingsForEntry(entry) != null && getSavingsForEntry(entry).getValue().compareTo(BigDecimal.ZERO) > 0)
			{
				final PaymentDetailsItemType savingItem = createSavingDetailsItem(entry, currencyCode);
				paymentDetails.getPaymentDetailsItem().add(savingItem);
			}
		}

		// in case of gross amount items total price already includes taxes
		final PriceData detailsItemsTotalPriceData = getPriceDataFactory().create(PriceDataType.BUY,
				entryGroup.getTotalPrice().getValue(), currencyIsoCode);

		PriceData detailsDeliveryTotalData;
		if (entryGroup instanceof DeliveryOrderEntryGroupData && cart.getDeliveryCost() != null)
		{
			detailsDeliveryTotalData = cart.getDeliveryCost();
		}
		else
		{
			detailsDeliveryTotalData = getPriceDataFactory().create(PriceDataType.BUY, BigDecimal.valueOf(0), currencyIsoCode);
		}

		final AddressType address = createAddressForGroup(entryGroup);
		if (address != null)
		{
			if(CollectionUtils.isEmpty(cart.getPickupOrderGroups())){
				paymentDetails.setShipToAddress(address);
			}
		}

		//setting known params
		PriceData detailsTaxTotalData = getPriceDataFactory().create(PriceDataType.BUY, BigDecimal.valueOf(0), currencyIsoCode);
		// in case of net pricing separately calculate taxes otherwise taxes were already included in items total
		if (cart.isNet())
		{
			detailsTaxTotalData = entryGroup.getTotalTax();
		}

		final BasicAmountType itemTotal = createBasicAmountType(detailsItemsTotalPriceData, currencyCode);
		final BasicAmountType shippingTotal = createBasicAmountType(detailsDeliveryTotalData, currencyCode);
		final BasicAmountType taxTotal = createBasicAmountType(detailsTaxTotalData, currencyCode);

		final double totalPrice = detailsItemsTotalPriceData.getValue().doubleValue()
				+ detailsDeliveryTotalData.getValue().doubleValue() + detailsTaxTotalData.getValue().doubleValue();
		final PriceData detailsOrderTotalData = getPriceDataFactory().create(PriceDataType.BUY, BigDecimal.valueOf(totalPrice),
				currencyIsoCode);
		final BasicAmountType orderTotal = createBasicAmountType(detailsOrderTotalData, currencyCode);

		paymentDetails.setItemTotal(itemTotal);
		paymentDetails.setShippingTotal(shippingTotal);
		paymentDetails.setTaxTotal(taxTotal);
		paymentDetails.setOrderTotal(orderTotal);

		return paymentDetails;
	}

	private PaymentDetailsItemType createSavingDetailsItem(final OrderEntryData entry, final CurrencyCodeType currencyCode)
	{
		//getting item info from entry
		final String name = entry.getProduct().getName() + " " + PaypalConstants.DISCOUNT;
		final PriceData unitPrice = getSavingsForEntry(entry);

		final BasicAmountType amount = createBasicAmountType(unitPrice, currencyCode);
		amount.setValue("-" + amount.getValue());

		final PaymentDetailsItemType detailsItem = new PaymentDetailsItemType();
		detailsItem.setName(name);
		detailsItem.setQuantity(Integer.valueOf(1));
		detailsItem.setAmount(amount);

		return detailsItem;
	}

	private PriceData getSavingsForEntry(final OrderEntryData entry)
	{
		final PriceData total = entry.getTotalPrice();
		if (total != null)
		{
			final BigDecimal quantity = BigDecimal.valueOf(entry.getQuantity());
			final BigDecimal regularTotalPrice = entry.getBasePrice().getValue().multiply(quantity);
			final BigDecimal savingsValue = regularTotalPrice.subtract(total.getValue());

			return getPriceDataFactory().create(total.getPriceType(), savingsValue, total.getCurrencyIso());
		}
		return total;
	}

	private PaymentDetailsItemType createPaymentDetailsItem(final OrderEntryData entry, final CurrencyCodeType currencyCode)
	{
		//getting item info from entry
		final String name = entry.getProduct().getName();
		final Long quantity = entry.getQuantity();
		final String description = entry.getProduct().getDescription();
		final PriceData unitPrice = entry.getBasePrice();

		final BasicAmountType amount = createBasicAmountType(unitPrice, currencyCode);

		final PaymentDetailsItemType detailsItem = new PaymentDetailsItemType();
		detailsItem.setName(name);
		detailsItem.setQuantity(Integer.valueOf(quantity.intValue()));
		detailsItem.setDescription(description);
		detailsItem.setAmount(amount);

		return detailsItem;
	}

	protected BasicAmountType createBasicAmountType(final PriceData priceData, final CurrencyCodeType currencyCode)
	{
		final BasicAmountType basicAmount = new BasicAmountType();

		final String currencyFormat = Pattern.matches(PaypalConstants.PAYPAL_CURRENCY_INTEGER, currencyCode.getValue())
				? PaypalConstants.PAYPAL_AMOUNT_FORMAT_INTEGER : PaypalConstants.PAYPAL_AMOUNT_FORMAT_DECIMAL;
		final DecimalFormat decimalFormat = new DecimalFormat(currencyFormat);
		decimalFormat.getDecimalFormatSymbols().setDecimalSeparator('.');

		basicAmount.setValue(decimalFormat.format(priceData.getValue().doubleValue()));

		basicAmount.setCurrencyID(currencyCode);
		return basicAmount;
	}

	private AddressType createAddressForGroup(final OrderEntryGroupData entryGroup)
	{
	    LOG.info("entryGroup: " + entryGroup);

		AddressData addressData = null;
		String addressName = StringUtils.EMPTY;
		if (entryGroup instanceof DeliveryOrderEntryGroupData)
		{
			final DeliveryOrderEntryGroupData deliveryEntryGroup = (DeliveryOrderEntryGroupData) entryGroup;
			addressData = deliveryEntryGroup.getDeliveryAddress();

			if (addressData != null)
			{
				final String addressTitle = addressData.getTitle();
				final StringBuilder addressNameBuilder = new StringBuilder();
				if (addressTitle != null)
				{
					addressNameBuilder.append(addressTitle).append(PaypalConstants.ADDRESS_NAME_SEPARATOR);
				}
				addressNameBuilder.append(addressData.getFirstName()).append(PaypalConstants.ADDRESS_NAME_SEPARATOR);
				addressNameBuilder.append(addressData.getLastName());

				addressName = addressNameBuilder.toString();
			}
		}
		else if (entryGroup instanceof PickupOrderEntryGroupData)
		{
			final PickupOrderEntryGroupData pickupEntryGroup = (PickupOrderEntryGroupData) entryGroup;
			final PointOfServiceData pointOfService = pickupEntryGroup.getDeliveryPointOfService();
			addressData = pointOfService.getAddress();

			final StringBuilder addressNameBuilder = new StringBuilder();
			addressNameBuilder.append(PaypalConstants.S2S_ADDRESS_NAME_PREFIX).append(PaypalConstants.ADDRESS_NAME_SEPARATOR);
			addressNameBuilder.append(pointOfService.getName());
			addressName = addressNameBuilder.toString();
		}
		LOG.info("addressName: '" + addressName + "'");

		AddressType address = null;
		if (addressData != null)
		{
			address = new AddressType();
			address.setName(addressName);
			address.setStreet1(addressData.getLine1());
			address.setStreet2(addressData.getLine2());
			address.setCityName(addressData.getTown());
			address.setPostalCode(addressData.getPostalCode());
			if (addressData.getRegion() != null)
			{
				address.setStateOrProvince(addressData.getRegion().getIsocodeShort());
			}
			if (addressData.getCountry() != null)
			{
				address.setCountry(CountryCodeType.fromValue(addressData.getCountry().getIsocode()));
			}
		}

		return address;
	}

	private SellerDetailsType createSellerDetails()
	{
		final SellerDetailsType sellerDetails = new SellerDetailsType();
		sellerDetails
				.setPayPalAccountID(getConfigurationService().getConfiguration().getString(PaypalConstants.PAYPAL_SELLER_EMAIL));
		return sellerDetails;
	}

	protected void setPaymentActionForAllPaymentDetails(final String configuredPaymentAction,
			final List<PaymentDetailsType> paymentDetailsList)
	{
		String paymentAction = configuredPaymentAction;

		// in case of multiple shipping ignore config and set Order payment type
		LOG.info("setPaymentActionForAllPaymentDetails, paymentDetailsList.size: " + paymentDetailsList.size() + ", paymentAction: " + paymentAction);
		if (paymentDetailsList.size() > 1)
		{
			paymentAction = PaypalConstants.ORDER_PAYMENT_ACTION_NAME;
		}
		else if (StringUtils.isBlank(configuredPaymentAction))
		{
			paymentAction = getDefaultpaymentAction();
		}
		LOG.info("paymentAction: " + paymentAction);

		// set calculated payment action for all payment details
		for (final PaymentDetailsType paymentDetails : paymentDetailsList)
		{
			PaymentActionCodeType paymentActionCode = null;
			try
			{
				paymentAction = StringUtils.capitalise(paymentAction);
				paymentActionCode = PaymentActionCodeType.fromValue(paymentAction);
			}
			catch (final IllegalArgumentException e)
			{
				LOG.error("Can't find appropriate action payment action... Using default. Message: " + e.getMessage(), e);
				paymentActionCode = PaymentActionCodeType.fromValue(getDefaultpaymentAction());
			}

			LOG.info("set paymentAction: " + paymentAction);
			paymentDetails.setPaymentAction(paymentActionCode);
		}
	}

	private String getDefaultpaymentAction()
	{
		return PaypalConstants.DEFAULT_PAYMENT_ACTION_NAME;
	}

	public ConfigurationService getConfigurationService()
	{
		return configurationService;
	}

	public void setConfigurationService(final ConfigurationService configurationService)
	{
		this.configurationService = configurationService;
	}

	public PriceDataFactory getPriceDataFactory()
	{
		return priceDataFactory;
	}

	public void setPriceDataFactory(final PriceDataFactory priceDataFactory)
	{
		this.priceDataFactory = priceDataFactory;
	}

	public SessionService getSessionService()
	{
		return sessionService;
	}

	public void setSessionService(final SessionService sessionService)
	{
		this.sessionService = sessionService;
	}

	private void changeRequestStructure(List<PaymentDetailsType> detailsList) {
		final PaymentDetailsType paymentDetailsTypeForReq = new PaymentDetailsType();
		final BasicAmountType basicAmountTypeOrderTotal = new BasicAmountType();
		final BasicAmountType basicAmountTypeItemTotal = new BasicAmountType();
		final BasicAmountType basicAmountTypeShippingTotal = new BasicAmountType();
		final BasicAmountType basicAmountTypeTaxTotal = new BasicAmountType();

		BigDecimal orderTotalValue = new BigDecimal(0d);
		BigDecimal itemTotalValue = new BigDecimal(0d);
		BigDecimal shippingTotalValue = new BigDecimal(0d);
		BigDecimal taxTotalValue = new BigDecimal(0d);
		List<PaymentDetailsItemType> itemTypes = new ArrayList<PaymentDetailsItemType>();
		for (PaymentDetailsType paymentDetailsType : detailsList) {

			orderTotalValue = orderTotalValue.add(new BigDecimal(paymentDetailsType.getOrderTotal().getValue()));
			itemTotalValue = itemTotalValue.add(new BigDecimal(paymentDetailsType.getItemTotal().getValue()));
			shippingTotalValue = shippingTotalValue.add(new BigDecimal(paymentDetailsType.getShippingTotal().getValue()));
			taxTotalValue = taxTotalValue.add(new BigDecimal(paymentDetailsType.getTaxTotal().getValue()));

			itemTypes.addAll(paymentDetailsType.getPaymentDetailsItem());
			basicAmountTypeOrderTotal.setCurrencyID(paymentDetailsType.getOrderTotal().getCurrencyID());
			basicAmountTypeItemTotal.setCurrencyID(paymentDetailsType.getItemTotal().getCurrencyID());
			basicAmountTypeShippingTotal.setCurrencyID(paymentDetailsType.getShippingTotal().getCurrencyID());
			basicAmountTypeTaxTotal.setCurrencyID(paymentDetailsType.getTaxTotal().getCurrencyID());
			paymentDetailsTypeForReq.setInvoiceID(paymentDetailsType.getInvoiceID());
			paymentDetailsTypeForReq.setButtonSource(paymentDetailsType.getButtonSource());
			paymentDetailsTypeForReq.setSellerDetails(paymentDetailsType.getSellerDetails());
			paymentDetailsTypeForReq.setPaymentAction(paymentDetailsType.getPaymentAction());
			paymentDetailsTypeForReq.setPaymentRequestID(paymentDetailsType.getPaymentRequestID());
			if (paymentDetailsType.getShipToAddress() != null) {
				paymentDetailsTypeForReq.setShipToAddress(paymentDetailsType.getShipToAddress());
			}
		}
		basicAmountTypeOrderTotal.setValue(String.valueOf(orderTotalValue));
		basicAmountTypeItemTotal.setValue(String.valueOf(itemTotalValue));
		basicAmountTypeShippingTotal.setValue(String.valueOf(shippingTotalValue));
		basicAmountTypeTaxTotal.setValue(String.valueOf(taxTotalValue));

		paymentDetailsTypeForReq.setPaymentDetailsItem(itemTypes);
		paymentDetailsTypeForReq.setOrderTotal(basicAmountTypeOrderTotal);
		paymentDetailsTypeForReq.setItemTotal(basicAmountTypeItemTotal);
		paymentDetailsTypeForReq.setShippingTotal(basicAmountTypeShippingTotal);
		paymentDetailsTypeForReq.setTaxTotal(basicAmountTypeTaxTotal);
		detailsList.clear();
		detailsList.add(paymentDetailsTypeForReq);
	}

}
