package com.paypal.hybris.cscockpit.widgets.renderers.impl;

import java.math.BigDecimal;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;
import org.zkoss.zk.ui.api.HtmlBasedComponent;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Button;
import org.zkoss.zul.Div;
import org.zkoss.zul.Label;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import com.paypal.hybris.cscockpit.widgets.controllers.PayPalAuthorizationController;
import com.paypal.hybris.cscockpit.widgets.renderers.constants.PayPalPartialRefundWidgetRendererConstants;

import de.hybris.platform.cockpit.model.meta.TypedObject;
import de.hybris.platform.cockpit.widgets.Widget;
import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.cscockpit.utils.LabelUtils;
import de.hybris.platform.cscockpit.widgets.renderers.impl.AbstractCreateWidgetRenderer;
import de.hybris.platform.cscockpit.widgets.renderers.utils.PopupWidgetHelper;
import de.hybris.platform.payment.dto.TransactionStatus;
import de.hybris.platform.payment.enums.PaymentTransactionType;
import de.hybris.platform.payment.model.PaymentTransactionEntryModel;
import de.hybris.platform.payment.model.PaymentTransactionModel;


public class AuthorizeRequestCreateWidgetRenderer extends AbstractCreateWidgetRenderer {

    private static final Logger LOG = Logger.getLogger(AuthorizeRequestCreateWidgetRenderer.class);

    private PopupWidgetHelper popupWidgetHelper;

    protected PopupWidgetHelper getPopupWidgetHelper() {
        return this.popupWidgetHelper;
    }

    @Required
    public void setPopupWidgetHelper(final PopupWidgetHelper popupWidgetHelper) {
        this.popupWidgetHelper = popupWidgetHelper;
    }

    @Override
    public HtmlBasedComponent createCaption(final Widget widget) {
        return null;
    }

    @Override
    protected HtmlBasedComponent createContentInternal(final Widget widget, final HtmlBasedComponent rootContainer) {
        final Div container = new Div();
        container.setSclass("authorizeOrderWidget");

        final Div orderAuthorizeRequestBox = new Div();
        orderAuthorizeRequestBox.setParent(container);

        final Label fieldLabel = new Label(LabelUtils.getLabel(widget, "authorizeAmount", new Object[0]));
        final Textbox fieldTextBox = new Textbox("0.0");

        if (widget.getWidgetController() instanceof PayPalAuthorizationController) {
            final TypedObject order = ((PayPalAuthorizationController) widget.getWidgetController()).getOrder();
            if (order != null && order.getObject() instanceof OrderModel) {
                final OrderModel orderModel = (OrderModel) order.getObject();
                fieldTextBox.setValue(orderModel.getTotalPrice().toString());
            }
        }
        orderAuthorizeRequestBox.appendChild(fieldLabel);
        orderAuthorizeRequestBox.appendChild(fieldTextBox);

        final Div authorizationOrderButtonBox = new Div();
        authorizationOrderButtonBox.setParent(container);
        authorizationOrderButtonBox.setSclass("authorizationOrderButtonBox");
        final Button attemptAuthorizationButton = new Button(LabelUtils.getLabel(widget, "AuthorizeOrderButton", new Object[0]));
        attemptAuthorizationButton.setParent(authorizationOrderButtonBox);
        attemptAuthorizationButton.addEventListener(
                PayPalPartialRefundWidgetRendererConstants.ON_CLICK,
                this.createConfirmBeforeCompletingRequestEventListener(widget,
                        this.createAttemptAuthorizationEventListener(widget, fieldTextBox)));
        return container;
    }

    private EventListener createAttemptAuthorizationEventListener(final Widget widget, final Textbox valueContainer) {
        return new AttemptAuthorizationEventListener(widget, valueContainer);
    }

    protected void handleAttemptAuthorizationEvent(final Widget widget, final Event event, final Textbox valueContainer)
            throws InterruptedException {
        if ("onOK".equals(event.getName())) {
            try {
                final BigDecimal amount = new BigDecimal(valueContainer.getText().replace(",", ""));
                if (amount.compareTo(BigDecimal.valueOf(10000)) == 1) {
                    LOG.error("Authorization amount can't be greater than 10000");
                    Messagebox.show(LabelUtils.getLabel(widget, "amountError", new Object[0]),
                            LabelUtils.getLabel(widget, "errorCreatingRequest", new Object[0]), 1, "z-msgbox z-msgbox-error");
                }
                else {
                    final TypedObject typedObject = ((PayPalAuthorizationController) widget.getWidgetController())
                            .createOrderAuthorizationRequest(valueContainer);

                    if (isLastTransactionSuccessful(typedObject)) {
                        final OrderModel orderModel = (OrderModel) typedObject.getObject();
                        Messagebox.show(LabelUtils.getLabel(widget, "success", new Object[]
                                        { orderModel.getCode() }), LabelUtils.getLabel(widget, "AuthorizationTitle", new Object[0]), 1,
                                "z-msgbox z-msgbox-information");
                    }
                    else {
                        Messagebox.show(LabelUtils.getLabel(widget, "failure", new Object[0]),
                                LabelUtils.getLabel(widget, "errorCreatingRequest", new Object[0]), 1, "z-msgbox z-msgbox-error");
                    }
                }
            }
            catch (final InterruptedException e) {
                LOG.error("Exception, message: " + e.getMessage(), e);
            }
        }

    }

    protected class AttemptAuthorizationEventListener implements EventListener {
        private final Widget widget;
        private final Textbox valueContainer;

        public AttemptAuthorizationEventListener(final Widget widget, final Textbox valueContainer) {
            this.widget = widget;
            this.valueContainer = valueContainer;
        }

        @Override
        public void onEvent(final Event event) throws Exception {
            handleAttemptAuthorizationEvent(widget, event, valueContainer);
            widget.getWidgetController().dispatchEvent(null, widget, null);
        }
    }

    private boolean isLastTransactionSuccessful(final TypedObject typedObject) {
        final boolean isLastTransactionSuccessful = false;
        if (typedObject != null) {
            final OrderModel orderModel = (OrderModel) typedObject.getObject();
            final List<PaymentTransactionModel> paymentTransactionModels = orderModel.getPaymentTransactions();

            final PaymentTransactionModel lastTransactionModel = getLastTransactionModel(paymentTransactionModels);
            final PaymentTransactionEntryModel lastTransactionEntry = getLastTransactionEntry(lastTransactionModel);
            if (lastTransactionEntry != null) {
                if (PaymentTransactionType.AUTHORIZATION.equals(lastTransactionEntry.getType())
                        && TransactionStatus.ERROR.name().equalsIgnoreCase(lastTransactionEntry.getTransactionStatus())) {
                    return isLastTransactionSuccessful;
                }
            }
            return true;
        }
        return isLastTransactionSuccessful;
    }

    private PaymentTransactionModel getLastTransactionModel(final List<PaymentTransactionModel> paymentTransactionModels) {
        PaymentTransactionModel lastTransactionModel = null;
        if (paymentTransactionModels != null && !paymentTransactionModels.isEmpty()) {
            lastTransactionModel = paymentTransactionModels.get(paymentTransactionModels.size() - 1);
        }
        return lastTransactionModel;
    }

    private PaymentTransactionEntryModel getLastTransactionEntry(final PaymentTransactionModel lastPaymentTransactionModel) {
        PaymentTransactionEntryModel lastTransactionEntryModel = null;
        if (lastPaymentTransactionModel != null && !lastPaymentTransactionModel.getEntries().isEmpty()) {
            lastTransactionEntryModel = lastPaymentTransactionModel.getEntries()
                    .get(lastPaymentTransactionModel.getEntries().size() - 1);
        }
        return lastTransactionEntryModel;
    }

}
