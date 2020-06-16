package com.paypal.hybris.cscockpit.widgets.controllers.impl;

import com.paypal.hybris.cscockpit.widgets.services.PayPalOrderManagementActionsWidgetService;
import com.paypal.hybris.enums.PaymentActionType;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import com.paypal.hybris.cscockpit.widgets.controllers.PayPalOrderManagementActionsWidgetController;
import com.paypal.hybris.model.PaypalPaymentInfoModel;

import de.hybris.platform.cockpit.model.meta.TypedObject;
import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.cscockpit.widgets.controllers.impl.DefaultOrderManagementActionsWidgetController;

public class PayPalOrderManagementActionsWidgetControllerImpl extends DefaultOrderManagementActionsWidgetController
		implements PayPalOrderManagementActionsWidgetController
{

	private static final Logger LOG = Logger.getLogger(PayPalOrderManagementActionsWidgetControllerImpl.class);

	private PayPalOrderManagementActionsWidgetService payPalOrderManagementActionsWidgetService;

	@Override
	public boolean isReauthorizationPossible()
	{
		final OrderModel order = getOrderIfExist();
		return payPalOrderManagementActionsWidgetService.isReauthorizationPossible(order);
	}

	@Override
	public boolean isMultiCapturingPossible()
	{
		final OrderModel order = getOrderIfExist();
		return payPalOrderManagementActionsWidgetService.isMultiCapturingPossible(order);
	}


	@Override
	public boolean isPartialRefundPossible() {
		final OrderModel order = getOrderIfExist();
		return payPalOrderManagementActionsWidgetService.isPartialRefundPossible(order);
	}

	@Override
	public boolean isVoidPossible() {
		final OrderModel order = getOrderIfExist();
		return payPalOrderManagementActionsWidgetService.isVoidPossible(order);
	}

    @Override
    public PaymentActionType getPayPalActionType() {
        final OrderModel order = getOrderIfExist();
        if (order != null && order.getPaymentInfo() instanceof PaypalPaymentInfoModel) {
            return ((PaypalPaymentInfoModel) order.getPaymentInfo()).getPaymentAction();
        }
        return null;
    }

	private OrderModel getOrderIfExist()
	{
		OrderModel order = null;

		final TypedObject orderType = getOrder();
		if ((orderType != null) && (orderType.getObject() instanceof OrderModel)
				&& (StringUtils.isBlank(((OrderModel) orderType.getObject()).getVersionID())))
		{
			order = (OrderModel) orderType.getObject();
		}

		return order;
	}

    @Override
    public boolean isAuthorizationPossible() {
        final OrderModel order = getOrderIfExist();
        return payPalOrderManagementActionsWidgetService.isAuthorizationPossible(order);
    }

	public PayPalOrderManagementActionsWidgetService getPayPalOrderManagementActionsWidgetService() {
		return payPalOrderManagementActionsWidgetService;
	}

	public void setPayPalOrderManagementActionsWidgetService(PayPalOrderManagementActionsWidgetService payPalOrderManagementActionsWidgetService) {
		this.payPalOrderManagementActionsWidgetService = payPalOrderManagementActionsWidgetService;
	}
}
