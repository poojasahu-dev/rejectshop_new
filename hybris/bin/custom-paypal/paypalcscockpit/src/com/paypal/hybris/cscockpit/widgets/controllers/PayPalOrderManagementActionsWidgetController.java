package com.paypal.hybris.cscockpit.widgets.controllers;

import com.paypal.hybris.enums.PaymentActionType;
import de.hybris.platform.cscockpit.widgets.controllers.OrderManagementActionsWidgetController;


public interface PayPalOrderManagementActionsWidgetController extends OrderManagementActionsWidgetController
{

	boolean isReauthorizationPossible();

	boolean isMultiCapturingPossible();

	boolean isPartialRefundPossible();

	boolean isRefundPossible();

	boolean isAuthorizationPossible();

    PaymentActionType getPayPalActionType();

	boolean isVoidPossible();
}
