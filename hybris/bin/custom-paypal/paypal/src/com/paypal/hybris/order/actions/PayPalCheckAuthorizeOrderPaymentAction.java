package com.paypal.hybris.order.actions;

import de.hybris.platform.core.enums.OrderStatus;
import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.core.model.order.payment.InvoicePaymentInfoModel;
import de.hybris.platform.orderprocessing.model.OrderProcessModel;
import de.hybris.platform.payment.dto.TransactionStatus;
import de.hybris.platform.payment.enums.PaymentTransactionType;
import de.hybris.platform.payment.model.PaymentTransactionEntryModel;
import de.hybris.platform.payment.model.PaymentTransactionModel;
import de.hybris.platform.processengine.action.AbstractSimpleDecisionAction;

public class PayPalCheckAuthorizeOrderPaymentAction extends AbstractSimpleDecisionAction<OrderProcessModel> {
    @Override
    public Transition executeAction(final OrderProcessModel process) {
        final OrderModel order = process.getOrder();

        if (order != null) {
            if (order.getPaymentInfo() instanceof InvoicePaymentInfoModel) {
                return Transition.OK;
            } else {
                return assignStatusForOrder(order);
            }
        }
        return Transition.NOK;
    }

    /**
     * Sets the status for given order in case on of its {@link PaymentTransactionEntryModel} matches proper
     * {@link PaymentTransactionType} and {@link TransactionStatus}.
     *
     * @param order {@link OrderModel}
     * @return {@link Transition}
     */
    protected Transition assignStatusForOrder(final OrderModel order) {
        for (final PaymentTransactionModel transaction : order.getPaymentTransactions()) {
            for (final PaymentTransactionEntryModel entry : transaction.getEntries()) {
                if (entry.getType().equals(PaymentTransactionType.AUTHORIZATION)
                        && TransactionStatus.ACCEPTED.name().equals(entry.getTransactionStatus())) {
                    order.setStatus(OrderStatus.PAYMENT_AUTHORIZED);
                    modelService.save(order);
                    return Transition.OK;
                } else if (entry.getType().equals(PaymentTransactionType.ORDER)) {
                    return Transition.OK;
                }
            }
        }
        return Transition.NOK;
    }
}