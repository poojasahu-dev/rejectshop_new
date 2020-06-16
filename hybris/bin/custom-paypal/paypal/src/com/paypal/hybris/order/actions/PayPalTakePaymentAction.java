
package com.paypal.hybris.order.actions;

import com.paypal.hybris.enums.PaymentActionType;
import com.paypal.hybris.model.PaypalPaymentInfoModel;
import de.hybris.platform.core.enums.OrderStatus;
import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.core.model.order.payment.CreditCardPaymentInfoModel;
import de.hybris.platform.orderprocessing.model.OrderProcessModel;
import de.hybris.platform.payment.PaymentService;
import de.hybris.platform.payment.dto.TransactionStatus;
import de.hybris.platform.payment.model.PaymentTransactionEntryModel;
import de.hybris.platform.payment.model.PaymentTransactionModel;
import de.hybris.platform.processengine.action.AbstractAction;
import de.hybris.platform.payment.enums.PaymentTransactionType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.Set;


public class PayPalTakePaymentAction extends AbstractAction<OrderProcessModel>
{
	private static final Logger LOG = Logger.getLogger(PayPalTakePaymentAction.class);

	private PaymentService paymentService;

    @Override
    public String execute(OrderProcessModel orderProcessModel)
    {
        return executeAction(orderProcessModel).toString();
    }

    public enum Transition
    {
        OK, NOK, WAIT_FOR_TAKE_PAYMENT;

        public static Set<String> getStringValues()
        {
            final Set<String> res = new HashSet<String>();
            for (final PayPalTakePaymentAction.Transition transitions : PayPalTakePaymentAction.Transition.values()) {
                res.add(transitions.toString());
            }
            return res;
        }
    }

    @Override
    public Set<String> getTransitions()
    {
        return PayPalTakePaymentAction.Transition.getStringValues();
    }

	public Transition executeAction(final OrderProcessModel process)
	{
		final OrderModel order = process.getOrder();

		if (isCaptureRequired(order))
		{
			for (final PaymentTransactionModel txn : order.getPaymentTransactions())
			{
				final PaymentTransactionEntryModel txnEntry = getPaymentService().capture(txn);

				if (TransactionStatus.ACCEPTED.name().equals(txnEntry.getTransactionStatus()))
				{
					if (LOG.isDebugEnabled())
					{
						LOG.debug("The payment transaction has been captured. Order: " + order.getCode() + ". Txn: " + txn.getCode());
					}
					setOrderStatus(order, OrderStatus.PAYMENT_CAPTURED);
                    return Transition.OK;
				}
				else
				{
					LOG.error("The payment transaction capture has failed. Order: " + order.getCode() + ", txn: " + txn.getCode() + ", txn.status: " + txnEntry.getTransactionStatus());
					setOrderStatus(order, OrderStatus.PAYMENT_NOT_CAPTURED);
					return Transition.NOK;
				}
			}
		}
		else if (isOrderCaptured(order))
        {
            return Transition.OK;
        }
        setOrderStatus(order, OrderStatus.PAYMENT_NOT_CAPTURED);
        LOG.info("Go to next action by Transition: " + Transition.WAIT_FOR_TAKE_PAYMENT);
		return Transition.WAIT_FOR_TAKE_PAYMENT;
	}

    private final boolean isCaptureRequired(final OrderModel order) {
        if (order.getPaymentInfo() instanceof PaypalPaymentInfoModel) {
            PaypalPaymentInfoModel paymentInfo = (PaypalPaymentInfoModel) order.getPaymentInfo();
            return paymentInfo.getIsReplenishment();
        }
        return true;
    }

    private boolean isOrderCaptured(OrderModel order)
    {
        BigDecimal capturedAmount = BigDecimal.ZERO;
        for (final PaymentTransactionModel paymentTransaction : order.getPaymentTransactions())
        {
            for (final PaymentTransactionEntryModel entry : paymentTransaction.getEntries())
            {
                if (PaymentTransactionType.CAPTURE.equals(entry.getType())
                        && TransactionStatus.ACCEPTED.toString().equals(entry.getTransactionStatus()))
                {
                    capturedAmount = capturedAmount.add(entry.getAmount());
                } else if (PaymentTransactionType.SALE.equals(entry.getType())
						&& TransactionStatus.ACCEPTED.toString().equals(entry.getTransactionStatus()))
				{
					return entry.getAmount().setScale(2, RoundingMode.HALF_UP).compareTo(BigDecimal.valueOf(order.getTotalPrice())) >= 0;
				}
            }
        }
        return capturedAmount.setScale(2, RoundingMode.HALF_UP).compareTo(BigDecimal.valueOf(order.getTotalPrice())) >= 0;
    }


	protected PaymentService getPaymentService()
	{
		return paymentService;
	}

	@Required
	public void setPaymentService(final PaymentService paymentService)
	{
		this.paymentService = paymentService;
	}
}
