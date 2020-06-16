package com.paypal.hybris.facade;

import de.hybris.platform.commercefacades.order.CheckoutFacade;
import de.hybris.platform.commercefacades.order.data.CCPaymentInfoData;


public interface PayPalCheckoutFacade extends CheckoutFacade
{

	CCPaymentInfoData getPaymentDetails();
}
