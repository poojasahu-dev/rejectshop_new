/**
 *
 */
package com.paypal.hybris.facade;

import de.hybris.platform.acceleratorfacades.flow.impl.DefaultCheckoutFlowFacade;
import de.hybris.platform.commercefacades.order.data.CCPaymentInfoData;
import de.hybris.platform.core.model.order.CartModel;
import de.hybris.platform.core.model.order.payment.CreditCardPaymentInfoModel;
import de.hybris.platform.core.model.order.payment.PaymentInfoModel;
import de.hybris.platform.servicelayer.dto.converter.Converter;

import com.paypal.hybris.model.PaypalPaymentInfoModel;


public class PayPalCheckoutFlowFacade extends DefaultCheckoutFlowFacade
{

	private Converter<PaypalPaymentInfoModel, CCPaymentInfoData> paypalPaymentInfoConverter;

	@Override
	protected CCPaymentInfoData getPaymentDetails()
	{
		final CartModel cart = getCart();
		if (cart != null)
		{
			final PaymentInfoModel paymentInfo = cart.getPaymentInfo();
			if (paymentInfo instanceof PaypalPaymentInfoModel)
			{
				return getPaypalPaymentInfoConverter().convert((PaypalPaymentInfoModel) paymentInfo);
			}
			else if (paymentInfo instanceof CreditCardPaymentInfoModel)
			{
				return super.getPaymentDetails();
			}
		}

		return null;
	}


	/**
	 * @return the paypalPaymentInfoConverter
	 */
	public Converter<PaypalPaymentInfoModel, CCPaymentInfoData> getPaypalPaymentInfoConverter()
	{
		return paypalPaymentInfoConverter;
	}



	/**
	 * @param paypalPaymentInfoConverter
	 *           the paypalPaymentInfoConverter to set
	 */
	public void setPaypalPaymentInfoConverter(
			final Converter<PaypalPaymentInfoModel, CCPaymentInfoData> paypalPaymentInfoConverter)
	{
		this.paypalPaymentInfoConverter = paypalPaymentInfoConverter;
	}

}
