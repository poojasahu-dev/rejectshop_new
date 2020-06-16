package com.paypal.hybris.converters.populators.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.ebay.utils.PayPalCrypto;
import com.paypal.hybris.constants.PaypalConstants;
import com.paypal.hybris.converters.populators.AbstractRequestPaymentDetailsPopulator;
import com.paypal.hybris.data.DoReferenceTransactionRequestData;

import de.hybris.platform.commercefacades.order.data.AbstractOrderData;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import urn.ebay.api.PayPalAPI.DoReferenceTransactionRequestType;
import urn.ebay.apis.eBLBaseComponents.DoReferenceTransactionRequestDetailsType;
import urn.ebay.apis.eBLBaseComponents.PaymentActionCodeType;
import urn.ebay.apis.eBLBaseComponents.PaymentDetailsType;


public class DoRefTransactionReqPopulator
		extends AbstractRequestPaymentDetailsPopulator<DoReferenceTransactionRequestData, DoReferenceTransactionRequestType>
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
	public void populate(final DoReferenceTransactionRequestData requestData, final DoReferenceTransactionRequestType request)
			throws ConversionException
	{
		final DoReferenceTransactionRequestDetailsType requestDetails = new DoReferenceTransactionRequestDetailsType();

		AbstractOrderData orderData = requestData.getOrderData();

		if (orderData == null)
		{
			orderData = requestData.getCartData();
		}

		requestDetails.setReferenceID(requestData.getReferenceId());
		requestDetails.setPaymentAction(PaymentActionCodeType.SALE);

		final List<PaymentDetailsType> paymentDetailsList = createPaymentDetailsList(requestData, orderData);
		if (CollectionUtils.isNotEmpty(paymentDetailsList) && paymentDetailsList.size() != 1)
		{
			throw new ConversionException("Can't make doReferenceTransaction call on order with multiple shipping.");
		}

		final PaymentDetailsType paymentDetails = paymentDetailsList.get(0);

		String button = PayPalCrypto.decrypt(getConfigurationService().getConfiguration().getString(PaypalConstants.PAYPAL_KEY), getConfigurationService().getConfiguration().getString(PaypalConstants.BUTTON_SOURCE));
		paymentDetails.setButtonSource(button);

		requestDetails.setPaymentDetails(paymentDetails);

		request.setDoReferenceTransactionRequestDetails(requestDetails);
	}
}
