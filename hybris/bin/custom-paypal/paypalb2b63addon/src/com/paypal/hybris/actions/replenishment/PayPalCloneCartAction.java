package com.paypal.hybris.actions.replenishment;

import de.hybris.platform.b2bacceleratoraddon.actions.replenishment.CloneCartAction;
import de.hybris.platform.b2bacceleratorservices.model.process.ReplenishmentProcessModel;
import de.hybris.platform.core.model.order.CartModel;
import de.hybris.platform.orderscheduling.model.CartToOrderCronJobModel;

import com.paypal.hybris.addon.constants.Paypalb2b63addonConstants;


public class PayPalCloneCartAction extends CloneCartAction
{
	@Override
	public void executeAction(final ReplenishmentProcessModel process) throws Exception
	{
		final CartToOrderCronJobModel cartToOrderCronJob = process.getCartToOrderCronJob();
		final CartModel cronJobCart = cartToOrderCronJob.getCart();
		processParameterHelper.setProcessParameter(process, Paypalb2b63addonConstants.ORIGINAL_CART, cronJobCart);

		super.executeAction(process);
	}

}
