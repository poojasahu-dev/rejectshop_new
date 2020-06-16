package com.paypal.hybris.order.process;

import de.hybris.platform.core.model.order.OrderModel;

public interface OrderCompleteProcessService {

    public void startOrderCompletionProcess(OrderModel order);

}
