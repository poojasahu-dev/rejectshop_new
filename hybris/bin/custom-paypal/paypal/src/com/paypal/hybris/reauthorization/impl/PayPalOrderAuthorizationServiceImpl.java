package com.paypal.hybris.reauthorization.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import com.paypal.hybris.constants.PaypalConstants;
import com.paypal.hybris.data.DoAuthorizationRequestData;
import com.paypal.hybris.data.DoAuthorizationResultData;
import com.paypal.hybris.data.PaymentStatus;
import com.paypal.hybris.data.PendingReason;
import com.paypal.hybris.integration.service.PaypalPaymentIntegrationService;
import com.paypal.hybris.reauthorization.PayPalOrderAuthorizationService;

import de.hybris.platform.core.model.c2l.CurrencyModel;
import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.payment.dto.TransactionStatus;
import de.hybris.platform.payment.dto.TransactionStatusDetails;
import de.hybris.platform.payment.enums.PaymentTransactionType;
import de.hybris.platform.payment.model.PaymentTransactionEntryModel;
import de.hybris.platform.payment.model.PaymentTransactionModel;
import de.hybris.platform.servicelayer.model.ModelService;


public class PayPalOrderAuthorizationServiceImpl implements PayPalOrderAuthorizationService {

    private static final Logger LOG = Logger.getLogger(PayPalOrderAuthorizationServiceImpl.class);

    private PaypalPaymentIntegrationService paypalPaymentIntegrationService;
    private ModelService modelService;
    private PaymentTransactionEntryModel authTransactionEntry;

    @Override
    public boolean isAuthorizationPossible(OrderModel orderModel) {
        return false;
    }

    @Override
    public OrderModel authorize(OrderModel orderModel, String amount) {

        final DoAuthorizationRequestData authorizationRequest = new DoAuthorizationRequestData();
        final List<PaymentTransactionEntryModel> paymentTransactionEntries = new ArrayList<>();

        for (PaymentTransactionModel paymentTransactionModel : orderModel.getPaymentTransactions()) {
            for (PaymentTransactionEntryModel paymentTransactionEntryModel : paymentTransactionModel.getEntries()) {
                PaymentTransactionType.ORDER.equals(paymentTransactionEntryModel.getType());
                authorizationRequest.setTransactionId(paymentTransactionEntryModel.getPaymentTransaction().getRequestId());
            }
        }

        authorizationRequest.setAmount(Double.parseDouble(amount));
        authorizationRequest.setCurrencyIsoCode(orderModel.getCurrency().getIsocode());

        final DoAuthorizationResultData doAuthResData = paypalPaymentIntegrationService.doAuthorization(authorizationRequest);

        final Date authDate = doAuthResData.getDateTime().getTime();
        final String authCurrencyIsoCode = doAuthResData.getCurrencyIsoCode();
        final double authAmount = doAuthResData.getAmount();
        final String authorizationId = doAuthResData.getTransactionId();


        if (PaypalConstants.STATUS_SUCCESS.equals(doAuthResData.getAck()) && PaymentStatus.PENDING == doAuthResData.getPaymentStatus()
                && PendingReason.AUTHORIZATION == doAuthResData.getPendingReason()) {
            authTransactionEntry = createTransactionEntry(PaymentTransactionType.AUTHORIZATION,
                    TransactionStatus.ACCEPTED.name(), TransactionStatusDetails.SUCCESFULL.name(), authorizationId, orderModel,
                    authCurrencyIsoCode, authAmount, authDate);
            paymentTransactionEntries.add(authTransactionEntry);

        }
        else if (PaypalConstants.STATUS_SUCCESS.equals(doAuthResData.getAck())
                && PaymentStatus.PENDING == doAuthResData.getPaymentStatus()
                && PendingReason.AUTHORIZATION != doAuthResData.getPendingReason()) {
            authTransactionEntry = createTransactionEntry(PaymentTransactionType.AUTHORIZATION,
                    PaymentStatus.PENDING.name(), doAuthResData.getPendingReason().name(), authorizationId, orderModel,
                    authCurrencyIsoCode, authAmount, authDate);
            paymentTransactionEntries.add(authTransactionEntry);
        }
        else {
            LOG.error("DoAuthorization failed");
            authTransactionEntry = createTransactionEntry(
                    PaymentTransactionType.AUTHORIZATION, TransactionStatus.ERROR.name(), TransactionStatusDetails.UNKNOWN_CODE.name(),
                    authorizationId, orderModel, orderModel.getCode(), Double.parseDouble(amount), authDate);
            paymentTransactionEntries.add(authTransactionEntry);

        }
        for (final PaymentTransactionModel paymentTransactionModel : orderModel.getPaymentTransactions()) {
            if (PaypalConstants.PAYMENT_PROVIDER_NAME.equals(paymentTransactionModel.getPaymentProvider())) {
                final List<PaymentTransactionEntryModel> entries = new ArrayList<>(paymentTransactionModel.getEntries());
                getModelService().save(authTransactionEntry);
                entries.add(authTransactionEntry);
                getModelService().saveAll(entries);
                paymentTransactionModel.setEntries(entries);
                getModelService().save(paymentTransactionModel);
            }
        }
        getModelService().saveAll(authTransactionEntry, orderModel);
        return orderModel;
    }

    private PaymentTransactionEntryModel createTransactionEntry(final PaymentTransactionType type, final String status,
            final String statusDetails, final String requestId, final OrderModel orderModel, final String currencyIsoCode,
            final double amount, final Date timeStamp) {
        final PaymentTransactionEntryModel paymentTransactionEntry = modelService.create(PaymentTransactionEntryModel.class);

        paymentTransactionEntry.setRequestId(requestId);
        paymentTransactionEntry.setType(type);
        paymentTransactionEntry.setTransactionStatus(status);
        paymentTransactionEntry.setTransactionStatusDetails(statusDetails);

        final String code = PaypalConstants.PAYMENT_PROVIDER_NAME + "_cart_" + orderModel.getCode() + "_stamp_"
                + System.currentTimeMillis();
        paymentTransactionEntry.setCode(code);

        final CurrencyModel currency = orderModel.getCurrency();
        paymentTransactionEntry.setCurrency(currency);

        final BigDecimal transactionAmount = BigDecimal.valueOf(amount);
        paymentTransactionEntry.setAmount(transactionAmount);

        paymentTransactionEntry.setTime(timeStamp);

        return paymentTransactionEntry;
    }


    public PaypalPaymentIntegrationService getPaypalPaymentIntegrationService() {
        return paypalPaymentIntegrationService;
    }

    public void setPaypalPaymentIntegrationService(PaypalPaymentIntegrationService paypalPaymentIntegrationService) {
        this.paypalPaymentIntegrationService = paypalPaymentIntegrationService;
    }

    public ModelService getModelService() {
        return modelService;
    }

    public void setModelService(ModelService modelService) {
        this.modelService = modelService;
    }

}
