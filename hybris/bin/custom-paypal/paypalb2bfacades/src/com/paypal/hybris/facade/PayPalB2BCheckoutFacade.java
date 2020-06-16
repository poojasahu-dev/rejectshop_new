/**
 *
 */
package com.paypal.hybris.facade;

import de.hybris.platform.acceleratorfacades.order.AcceleratorCheckoutFacade;


public interface PayPalB2BCheckoutFacade extends AcceleratorCheckoutFacade
{
	public void setCardPaymentType();
}
