package com.paypal.hybris.cscockpit.widgets.services.impl;

import com.paypal.hybris.cscockpit.widgets.services.PayPalOrderManagementActionsWidgetService;
import com.paypal.hybris.data.PaymentStatus;
import com.paypal.hybris.enums.PaymentActionType;
import com.paypal.hybris.model.PaypalPaymentInfoModel;
import com.paypal.hybris.reauthorization.PayPalOrderReauthorizationService;
import com.paypal.multicapture.service.PayPalMultiCaptureService;
import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.payment.dto.TransactionStatus;
import de.hybris.platform.payment.enums.PaymentTransactionType;
import de.hybris.platform.payment.model.PaymentTransactionEntryModel;
import de.hybris.platform.payment.model.PaymentTransactionModel;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class PayPalOrderManagementActionsWidgetServiceImpl implements PayPalOrderManagementActionsWidgetService {

    private static final Logger LOG = Logger.getLogger(PayPalOrderManagementActionsWidgetServiceImpl.class);

    private static final String TRANSACTION_ACCEPTED = "ACCEPTED";

    private PayPalOrderReauthorizationService payPalOrderReauthorizationService;
    private PayPalMultiCaptureService payPalMultiCaptureService;


    @Override
    public boolean isReauthorizationPossible(final OrderModel order) {
        if (order != null && order.getPaymentInfo() instanceof PaypalPaymentInfoModel) {
            return getPayPalOrderReauthorizationService().isReauthorizationPossible(order);
        } else return false;
    }

    @Override
    public boolean isMultiCapturingPossible(final OrderModel order) {
        if (order != null && order.getPaymentInfo() instanceof PaypalPaymentInfoModel) {
            PaymentTransactionEntryModel firstEntry = order.getPaymentTransactions().get(0).getEntries().get(0);

            if (firstEntry.getType().equals(PaymentTransactionType.ORDER) && firstEntry.getTransactionStatus().equals("CANCELED")) {
                return false;
            }

            PaymentActionType actionType = ((PaypalPaymentInfoModel) order.getPaymentInfo()).getPaymentAction();
            final boolean isAuthorizationTransactionPresent = isAcceptedTransactionPresent(order, PaymentTransactionType.AUTHORIZATION);
            return (PaymentActionType.ORDER.equals(actionType) || PaymentActionType.AUTHORIZATION.equals(actionType)) &&
                    isAuthorizationTransactionPresent;
        }

        return false;
    }

    @Override
    public boolean isPartialRefundPossible(final OrderModel order) {
        if (order != null && order.getPaymentInfo() instanceof PaypalPaymentInfoModel && !isOrderAlreadyRefunded(order)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isVoidPossible(final OrderModel order) {
        if (order != null && order.getPaymentInfo() instanceof PaypalPaymentInfoModel) {
            PaymentTransactionEntryModel firstEntry = order.getPaymentTransactions().get(0).getEntries().get(0);

//            (firstEntry.getType().equals(PaymentTransactionType.ORDER) || firstEntry.getType().equals(PaymentTransactionType.AUTHORIZATION))

            if (firstEntry.getType().equals(PaymentTransactionType.ORDER) && firstEntry.getTransactionStatus().equals(PaymentStatus.PENDING.name())) {
                return true;
            }
            if (firstEntry.getType().equals(PaymentTransactionType.AUTHORIZATION) && firstEntry.getTransactionStatus().equals(TransactionStatus.ACCEPTED.name())) {
                return true;
            }

//            return isAcceptedTransactionPresent(order, PaymentTransactionType.AUTHORIZATION);
        }
        return false;
    }

    @Override
    public boolean isAuthorizationPossible(final OrderModel order) {
        if (order != null && order.getPaymentInfo() instanceof PaypalPaymentInfoModel) {
            PaymentTransactionEntryModel firstEntry = order.getPaymentTransactions().get(0).getEntries().get(0);

            if (firstEntry.getType().equals(PaymentTransactionType.ORDER) && firstEntry.getTransactionStatus().equals(PaymentStatus.PENDING.name())) {
                return true;
            }
            if (firstEntry.getType().equals(PaymentTransactionType.ORDER) && firstEntry.getTransactionStatus().equals("CANCELED")) {
                return false;
            }

            for (PaymentTransactionModel paymentTransactionModel : order.getPaymentTransactions()) {
                for (PaymentTransactionEntryModel paymentTransactionEntryModel : paymentTransactionModel.getEntries()) {
                    if (PaymentTransactionType.ORDER.equals(paymentTransactionEntryModel.getType())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean isAcceptedTransactionPresent(final OrderModel orderModel, final PaymentTransactionType transactionType) {
        boolean result = false;
        final List<PaymentTransactionModel> paymentTransactions = orderModel.getPaymentTransactions();

        for (PaymentTransactionModel transaction : paymentTransactions) {
            for (PaymentTransactionEntryModel entry : transaction.getEntries()) {
                if (transactionType.equals(entry.getType()) && TRANSACTION_ACCEPTED.equalsIgnoreCase(entry.getTransactionStatus())) {
                    result = true;
                    break;
                }
            }
        }

        return result;
    }

    private boolean isOrderAlreadyRefunded(final OrderModel order) {
        double refundedSum = 0d;
        double capturedSum = 0d;
        double saleTransactionAmount = 0d;
        for (PaymentTransactionModel paymentTransactionModel : order.getPaymentTransactions()) {
            for (PaymentTransactionEntryModel paymentTransactionEntryModel : paymentTransactionModel.getEntries()) {
                if ("ERROR".equalsIgnoreCase(paymentTransactionEntryModel.getTransactionStatus())) {
                    LOG.debug("skipped transaction: " + paymentTransactionEntryModel.getTransactionStatus() + ", amount: " + ((paymentTransactionEntryModel.getAmount() == null) ? null : paymentTransactionEntryModel.getAmount().doubleValue()));
                    continue;
                }

                if (paymentTransactionEntryModel.getType().equals(PaymentTransactionType.PARTIAL_REFUND)) {
                    refundedSum += paymentTransactionEntryModel.getAmount().doubleValue();
                } else if (paymentTransactionEntryModel.getType().equals(PaymentTransactionType.CAPTURE) ||
                        paymentTransactionEntryModel.getType().equals(PaymentTransactionType.PARTIAL_CAPTURE)) {
                    capturedSum += paymentTransactionEntryModel.getAmount().doubleValue();
                } else if (paymentTransactionEntryModel.getType().equals(PaymentTransactionType.SALE)) {
                    saleTransactionAmount = paymentTransactionEntryModel.getAmount().doubleValue();
                }
            }
        }
        if (saleTransactionAmount > 0d) {
            capturedSum = saleTransactionAmount;
        }
        BigDecimal capturedSumRounded = new BigDecimal(capturedSum);
        capturedSumRounded = capturedSumRounded.setScale(2, RoundingMode.HALF_UP);

        BigDecimal refundedSumRounded = new BigDecimal(refundedSum);
        refundedSumRounded = refundedSumRounded.setScale(2, RoundingMode.HALF_UP);
        return !(capturedSumRounded.doubleValue() > refundedSumRounded.doubleValue());
    }

    public PayPalOrderReauthorizationService getPayPalOrderReauthorizationService() {
        return payPalOrderReauthorizationService;
    }

    public void setPayPalOrderReauthorizationService(PayPalOrderReauthorizationService payPalOrderReauthorizationService) {
        this.payPalOrderReauthorizationService = payPalOrderReauthorizationService;
    }

    public PayPalMultiCaptureService getPayPalMultiCaptureService() {
        return payPalMultiCaptureService;
    }

    public void setPayPalMultiCaptureService(PayPalMultiCaptureService payPalMultiCaptureService) {
        this.payPalMultiCaptureService = payPalMultiCaptureService;
    }
}
