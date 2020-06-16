package com.paypal.hybris.cscockpit.widgets.controllers;

import de.hybris.platform.cockpit.widgets.controllers.WidgetController;

import urn.ebay.api.PayPalAPI.DoVoidResponseType;

public interface PayPalVoidController extends WidgetController {
    String getAuthorizationTransactionId();
    DoVoidResponseType doVoid(String transactionId, String note);
}
