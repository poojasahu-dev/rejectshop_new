package com.paypal.hybris.cscockpit.widgets.controllers;

import org.zkoss.zul.Textbox;

import de.hybris.platform.cockpit.model.meta.TypedObject;
import de.hybris.platform.cockpit.widgets.controllers.WidgetController;


public interface PayPalAuthorizationController extends WidgetController
{
	TypedObject getOrder();

	/**
	 * @param container
	 * @return
	 */
	TypedObject createOrderAuthorizationRequest(Textbox container);
}
