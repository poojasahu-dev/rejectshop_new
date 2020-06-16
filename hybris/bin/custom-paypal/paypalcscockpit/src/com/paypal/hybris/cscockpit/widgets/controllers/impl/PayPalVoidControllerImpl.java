package com.paypal.hybris.cscockpit.widgets.controllers.impl;

import com.paypal.hybris.constants.PaypalConstants;
import com.paypal.hybris.cscockpit.widgets.controllers.PayPalVoidController;
import com.paypal.hybris.payment.service.PayPalPaymentService;

import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.cscockpit.widgets.controllers.OrderManagementActionsWidgetController;
import de.hybris.platform.cscockpit.widgets.controllers.impl.AbstractCsWidgetController;
import de.hybris.platform.payment.enums.PaymentTransactionType;
import de.hybris.platform.payment.model.PaymentTransactionEntryModel;
import de.hybris.platform.payment.model.PaymentTransactionModel;
import de.hybris.platform.servicelayer.util.ServicesUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import urn.ebay.api.PayPalAPI.DoVoidRequestType;
import urn.ebay.api.PayPalAPI.DoVoidResponseType;

import java.util.Map;

public class PayPalVoidControllerImpl extends AbstractCsWidgetController implements PayPalVoidController {
    private static final Logger LOG = Logger.getLogger(PayPalVoidControllerImpl.class);

    private static final String TRANSACTION_SUCCESFULL = "SUCCESFULL";

    private OrderManagementActionsWidgetController orderManagementActionsWidgetController;
    private PayPalPaymentService payPalPaymentService;


    private OrderModel getOrder() {
        final OrderModel order = (OrderModel) orderManagementActionsWidgetController.getOrder().getObject();
        ServicesUtil.validateParameterNotNull(order, "Current order can't be null");
        return order;
    }

    @Override
    public String getAuthorizationTransactionId() {
        String resultId = StringUtils.EMPTY;
        for (final PaymentTransactionModel paymentTransactionModel : getOrder().getPaymentTransactions()) {
            for (final PaymentTransactionEntryModel paymentTransactionEntryModel : paymentTransactionModel.getEntries()) {
                if (PaymentTransactionType.AUTHORIZATION.equals(paymentTransactionEntryModel.getType()) &&
                        TRANSACTION_SUCCESFULL.equalsIgnoreCase(paymentTransactionEntryModel.getTransactionStatusDetails())) {
                    resultId = paymentTransactionEntryModel.getRequestId();
                }
            }
        }
        return resultId;
    }

    @Override
    public DoVoidResponseType doVoid(final String transactionId, final String note) {
        final DoVoidRequestType request = new DoVoidRequestType();

        request.setAuthorizationID(transactionId);
        request.setNote(note);
        request.setVersion(PaypalConstants.SOAP_API_VERSION);

        return payPalPaymentService.doVoid(request, getOrder());
    }

    @Override
    public void dispatchEvent(final String context, final Object source, final Map<String, Object> data) {
        orderManagementActionsWidgetController.dispatchEvent(context, source, data);
    }

    public OrderManagementActionsWidgetController getOrderManagementActionsWidgetController() {
        return orderManagementActionsWidgetController;
    }

    public void setOrderManagementActionsWidgetController(OrderManagementActionsWidgetController orderManagementActionsWidgetController) {
        this.orderManagementActionsWidgetController = orderManagementActionsWidgetController;
    }

    public PayPalPaymentService getPayPalPaymentService() {
        return payPalPaymentService;
    }

    public void setPayPalPaymentService(PayPalPaymentService payPalPaymentService) {
        this.payPalPaymentService = payPalPaymentService;
    }
}
