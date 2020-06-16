/**
 *
 */
package com.paypal.hybris.cscockpit.widgets.renderers.impl;

import com.paypal.hybris.enums.PaymentActionType;
import org.zkoss.zk.ui.api.HtmlBasedComponent;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zul.Div;
import com.paypal.hybris.cscockpit.widgets.controllers.PayPalOrderManagementActionsWidgetController;

import de.hybris.platform.cockpit.widgets.Widget;
import de.hybris.platform.cockpit.widgets.models.impl.DefaultItemWidgetModel;
import de.hybris.platform.cscockpit.utils.LabelUtils;
import de.hybris.platform.cscockpit.widgets.controllers.OrderManagementActionsWidgetController;
import de.hybris.platform.cscockpit.widgets.renderers.impl.OrderManagementActionsWidgetRenderer;


public class PayPalOrderManagementActionsWidgetRenderer extends OrderManagementActionsWidgetRenderer
{

	@Override
	protected HtmlBasedComponent createContentInternal(
			final Widget<DefaultItemWidgetModel, OrderManagementActionsWidgetController> widget,
			final HtmlBasedComponent rootContainer)
	{

		if (widget.getWidgetController() instanceof PayPalOrderManagementActionsWidgetController)
		{
			final Div component = new Div();
			component.setSclass("orderManagementActionsWidget");
			PaymentActionType actionType = ((PayPalOrderManagementActionsWidgetController) widget.getWidgetController()).getPayPalActionType();

			if (PaymentActionType.ORDER.equals(actionType)){
				createButtonsForOrderAction(widget, component);
				return component;

			} else  if (PaymentActionType.AUTHORIZATION.equals(actionType)){
				createButtonsForAuthorizationAction(widget, component);
				return component;

			} else  if (PaymentActionType.SALE.equals(actionType)){
				createButtonsForSaleAction(widget, component);
				return component;
			}
		}

        return super.createContentInternal(widget, rootContainer);

	}

	@Override
	protected void handleButtonClickEvent(final Widget<DefaultItemWidgetModel, OrderManagementActionsWidgetController> widget,
			final Event event, final Div container, final String springWidgetName, final String popupCode, final String cssClass,
			final String popupTitleLabelName)
	{
		if ("csMultipleCaptureWidget".equals(cssClass) || "csPartialRefundWidget".equals(cssClass) || "csAuthorizeCreateWidget".equals(cssClass))
		{
			getPopupWidgetHelper().createPopupWidget(container, springWidgetName, popupCode, cssClass,
					LabelUtils.getLabel(widget, popupTitleLabelName, new Object[0]), 400);
		}
		else
		{
			super.handleButtonClickEvent(widget, event, container, springWidgetName, popupCode, cssClass, popupTitleLabelName);
		}

	}

	private void createButtonsForOrderAction(Widget<DefaultItemWidgetModel, OrderManagementActionsWidgetController> widget, Div component) {

		createButton(widget, component, "authorize", "csAuthorizeRequestCreateWidgetConfig",
				"csAuthorizeRequestCreateWidget-Popup", "csAuthorizeCreateWidget", "popup.authorizeRequestCreate",
				!((PayPalOrderManagementActionsWidgetController) widget.getWidgetController()).isAuthorizationPossible());

		createButton(widget, component, "void", "csVoidRequestCreateWidgetConfig",
				"csVoidRequestCreateWidget-Popup", "csVoidCreateWidget", "popup.voidRequestCreate",
				!((PayPalOrderManagementActionsWidgetController) widget.getWidgetController()).isVoidPossible());

		createButton(widget, component, "reauthorizeOrder", "csReauthorizeRequestCreateWidgetConfig",
				"csReauthorizeRequestCreateWidget-Popup", "csReauthorizeRequestCreateWidget", "popup.reauthorizeRequestCreate",
				!((PayPalOrderManagementActionsWidgetController) widget.getWidgetController()).isReauthorizationPossible());

		createButton(widget, component, "multipleCapture", "csMultipleCaptureWidgetConfig", "csMultipleCaptureWidget-Popup",
				"csMultipleCaptureWidget", "popup.multipleCapture",
				!((PayPalOrderManagementActionsWidgetController) widget.getWidgetController()).isMultiCapturingPossible());

		createButton(widget, component, "partialRefund", "csPartialRefundWidgetConfig", "csPartialRefundWidget-Popup",
				"csPartialRefundWidget", "popup.partialRefund",
				!((PayPalOrderManagementActionsWidgetController) widget.getWidgetController()).isPartialRefundPossible());
	}

	private void createButtonsForAuthorizationAction(Widget<DefaultItemWidgetModel, OrderManagementActionsWidgetController> widget, Div component) {

		createButton(widget, component, "void", "csVoidRequestCreateWidgetConfig",
				"csVoidRequestCreateWidget-Popup", "csVoidCreateWidget", "popup.voidRequestCreate",
				!((PayPalOrderManagementActionsWidgetController) widget.getWidgetController()).isVoidPossible());


		createButton(widget, component, "reauthorizeOrder", "csReauthorizeRequestCreateWidgetConfig",
				"csReauthorizeRequestCreateWidget-Popup", "csReauthorizeRequestCreateWidget", "popup.reauthorizeRequestCreate",
				!((PayPalOrderManagementActionsWidgetController) widget.getWidgetController()).isReauthorizationPossible());

		createButton(widget, component, "multipleCapture", "csMultipleCaptureWidgetConfig", "csMultipleCaptureWidget-Popup",
				"csMultipleCaptureWidget", "popup.multipleCapture",
				!((PayPalOrderManagementActionsWidgetController) widget.getWidgetController()).isMultiCapturingPossible());

		createButton(widget, component, "partialRefund", "csPartialRefundWidgetConfig", "csPartialRefundWidget-Popup",
				"csPartialRefundWidget", "popup.partialRefund",
				!((PayPalOrderManagementActionsWidgetController) widget.getWidgetController()).isPartialRefundPossible());
	}

	private void createButtonsForSaleAction(Widget<DefaultItemWidgetModel, OrderManagementActionsWidgetController> widget, Div component) {

		createButton(widget, component, "partialRefund", "csPartialRefundWidgetConfig", "csPartialRefundWidget-Popup",
				"csPartialRefundWidget", "popup.partialRefund",
				!((PayPalOrderManagementActionsWidgetController) widget.getWidgetController()).isPartialRefundPossible());
	}
}
