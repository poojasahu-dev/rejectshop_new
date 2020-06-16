package com.paypal.hybris.cscockpit.widgets.services;

import de.hybris.platform.core.model.order.OrderModel;

public interface PayPalOrderManagementActionsWidgetService {

    boolean isReauthorizationPossible(OrderModel order);

    boolean isMultiCapturingPossible(OrderModel order);

    boolean isPartialRefundPossible(OrderModel order);

    boolean isAuthorizationPossible(OrderModel order);

    boolean isVoidPossible(OrderModel order);
}
