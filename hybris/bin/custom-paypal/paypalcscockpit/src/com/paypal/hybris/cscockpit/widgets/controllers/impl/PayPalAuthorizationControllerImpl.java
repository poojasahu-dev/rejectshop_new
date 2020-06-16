package com.paypal.hybris.cscockpit.widgets.controllers.impl;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;
import org.zkoss.zul.Textbox;
import com.paypal.hybris.cscockpit.widgets.controllers.PayPalAuthorizationController;
import com.paypal.hybris.reauthorization.PayPalOrderAuthorizationService;

import de.hybris.platform.cockpit.model.meta.TypedObject;
import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.cscockpit.widgets.controllers.OrderManagementActionsWidgetController;
import de.hybris.platform.cscockpit.widgets.controllers.impl.AbstractCsWidgetController;


public class PayPalAuthorizationControllerImpl extends AbstractCsWidgetController implements PayPalAuthorizationController {
    private static final Logger LOG = Logger.getLogger(PayPalAuthorizationControllerImpl.class);

    private OrderManagementActionsWidgetController orderManagementActionsWidgetController;
    private PayPalOrderAuthorizationService orderAuthorizationService;

    @Override
    public void dispatchEvent(final String context, final Object source, final Map<String, Object> data) {
        getOrderManagementActionsWidgetController().dispatchEvent(context, source, data);
    }

    @Override
    public TypedObject getOrder() {
        return getOrderManagementActionsWidgetController().getOrder();
    }

    @Override
    public TypedObject createOrderAuthorizationRequest(final Textbox container) {
        final TypedObject order = this.getOrder();

        if (order != null && order.getObject() instanceof OrderModel) {
            OrderModel orderModel = (OrderModel) order.getObject();
            try {
                orderModel = getOrderAuthorizationService().authorize(orderModel, container.getText());
            }
            catch (final Exception e) {
                LOG.error("Exception, message: " + e.getMessage(), e);
            }
            return getCockpitTypeService().wrapItem(orderModel);
        }
        return null;
    }

    protected OrderManagementActionsWidgetController getOrderManagementActionsWidgetController() {
        return this.orderManagementActionsWidgetController;
    }

    @Required
    public void setOrderManagementActionsWidgetController(
            final OrderManagementActionsWidgetController orderManagementActionsWidgetController) {
        this.orderManagementActionsWidgetController = orderManagementActionsWidgetController;
    }

    public PayPalOrderAuthorizationService getOrderAuthorizationService() {
        return orderAuthorizationService;
    }

    public void setOrderAuthorizationService(final PayPalOrderAuthorizationService orderAuthorizationService) {
        this.orderAuthorizationService = orderAuthorizationService;
    }

}
