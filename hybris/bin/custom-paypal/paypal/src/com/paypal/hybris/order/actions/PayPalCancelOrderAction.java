package com.paypal.hybris.order.actions;

import de.hybris.platform.core.enums.OrderStatus;
import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.orderprocessing.model.OrderProcessModel;
import de.hybris.platform.processengine.action.AbstractSimpleDecisionAction;

import org.apache.log4j.Logger;

public class PayPalCancelOrderAction extends AbstractSimpleDecisionAction<OrderProcessModel> {
    private static final Logger LOG = Logger.getLogger(PayPalCancelOrderAction.class);


    @Override
    public Transition executeAction(OrderProcessModel process) {
        LOG.error("process.code: " + process.getCode());

        final OrderModel order = process.getOrder();

        setOrderStatus(order, OrderStatus.CANCELLED);

        return Transition.OK;
    }

}
