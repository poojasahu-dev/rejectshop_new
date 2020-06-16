/**
 *
 */
package com.paypal.hybris.facade.populator;


import de.hybris.platform.b2bacceleratorfacades.order.populators.B2BCartPopulator;
import de.hybris.platform.commercefacades.order.data.AbstractOrderData;
import de.hybris.platform.commercefacades.order.data.CCPaymentInfoData;
import de.hybris.platform.core.model.order.AbstractOrderModel;
import de.hybris.platform.core.model.order.payment.CreditCardPaymentInfoModel;
import de.hybris.platform.core.model.order.payment.PaymentInfoModel;
import de.hybris.platform.servicelayer.dto.converter.Converter;

import com.paypal.hybris.model.PaypalPaymentInfoModel;


public class PayPalB2BCartPopulator extends B2BCartPopulator
{
	private Converter<PaypalPaymentInfoModel, CCPaymentInfoData> defaultPaypalPaymentInfoConverter;

	@Override
	protected void addPaymentInformation(final AbstractOrderModel source, final AbstractOrderData prototype)
	{
		final PaymentInfoModel paymentInfo = source.getPaymentInfo();
		if (paymentInfo instanceof CreditCardPaymentInfoModel)
		{
			final CCPaymentInfoData paymentInfoData = (CCPaymentInfoData) getCreditCardPaymentInfoConverter()
					.convert((CreditCardPaymentInfoModel) paymentInfo);
			prototype.setPaymentInfo(paymentInfoData);
		}
		if (paymentInfo instanceof PaypalPaymentInfoModel)
		{
			final CCPaymentInfoData paymentInfoData = getDefaultPaypalPaymentInfoConverter()
					.convert((PaypalPaymentInfoModel) paymentInfo);
			prototype.setPaymentInfo(paymentInfoData);
		}
	}

	/**
	 * @return the defaultPaypalPaymentInfoConverter
	 */
	public Converter<PaypalPaymentInfoModel, CCPaymentInfoData> getDefaultPaypalPaymentInfoConverter()
	{
		return defaultPaypalPaymentInfoConverter;
	}

	/**
	 * @param defaultPaypalPaymentInfoConverter
	 *           the defaultPaypalPaymentInfoConverter to set
	 */
	public void setDefaultPaypalPaymentInfoConverter(
			final Converter<PaypalPaymentInfoModel, CCPaymentInfoData> defaultPaypalPaymentInfoConverter)
	{
		this.defaultPaypalPaymentInfoConverter = defaultPaypalPaymentInfoConverter;
	}

}
