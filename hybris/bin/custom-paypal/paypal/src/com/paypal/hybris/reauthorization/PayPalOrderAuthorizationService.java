package com.paypal.hybris.reauthorization;

import de.hybris.platform.core.model.order.OrderModel;


public interface PayPalOrderAuthorizationService
{

	boolean isAuthorizationPossible(OrderModel orderModel);

	OrderModel authorize(OrderModel orderModel, String amount) throws Exception;

}
