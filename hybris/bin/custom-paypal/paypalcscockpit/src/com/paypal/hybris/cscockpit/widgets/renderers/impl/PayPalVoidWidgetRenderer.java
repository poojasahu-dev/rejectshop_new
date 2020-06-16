package com.paypal.hybris.cscockpit.widgets.renderers.impl;

import com.ebay.utils.PaypalStringUtils;
import com.paypal.hybris.cscockpit.widgets.controllers.impl.PayPalVoidControllerImpl;
import de.hybris.platform.cockpit.widgets.Widget;
import de.hybris.platform.cscockpit.utils.LabelUtils;
import de.hybris.platform.cscockpit.widgets.renderers.impl.AbstractCreateWidgetRenderer;
import de.hybris.platform.cscockpit.widgets.renderers.utils.PopupWidgetHelper;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.api.HtmlBasedComponent;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Button;
import org.zkoss.zul.Div;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import urn.ebay.api.PayPalAPI.DoVoidResponseType;
import urn.ebay.apis.eBLBaseComponents.AckCodeType;

import static com.paypal.hybris.cscockpit.widgets.renderers.constants.PayPalPartialRefundWidgetRendererConstants.FAILURE;
import static com.paypal.hybris.cscockpit.widgets.renderers.constants.PayPalPartialRefundWidgetRendererConstants.FAILURE_MESSAGE;
import static com.paypal.hybris.cscockpit.widgets.renderers.constants.PayPalPartialRefundWidgetRendererConstants.MSGBOX_ERROR;
import static com.paypal.hybris.cscockpit.widgets.renderers.constants.PayPalPartialRefundWidgetRendererConstants.MSGBOX_INFORMATION;
import static com.paypal.hybris.cscockpit.widgets.renderers.constants.PayPalPartialRefundWidgetRendererConstants.ON_CLICK;
import static com.paypal.hybris.cscockpit.widgets.renderers.constants.PayPalPartialRefundWidgetRendererConstants.ON_OK;
import static com.paypal.hybris.cscockpit.widgets.renderers.constants.PayPalPartialRefundWidgetRendererConstants.SEPARATOR;
import static com.paypal.hybris.cscockpit.widgets.renderers.constants.PayPalPartialRefundWidgetRendererConstants.SUCCESS;

public class PayPalVoidWidgetRenderer extends AbstractCreateWidgetRenderer {

    private static final Logger LOG = Logger.getLogger(PayPalVoidWidgetRenderer.class);

    private PopupWidgetHelper popupWidgetHelper;

    @Override
    protected HtmlBasedComponent createContentInternal(final Widget widget, final HtmlBasedComponent rootContainer) {
        final Div container = new Div();
        final Listbox voidTable = createVoidTable(container);
        final Textbox authorizationTransactionTextBox = createTableRow(widget, voidTable, "authorizationTransaction");
        final Textbox noteTextBox = createTableRow(widget, voidTable, "note");

        createVoidButton(widget, container, authorizationTransactionTextBox, noteTextBox);

        return container;
    }

    private void handleAttemptVoidEvent(final Event event, final Widget widget, final Textbox authorizationTransactionId,
                                        final Textbox noteTextbox) throws InterruptedException {
        if (ON_OK.equals(event.getName())) {
            try {
                final PayPalVoidControllerImpl payPalVoidController = (PayPalVoidControllerImpl) widget.getWidgetController();

                final String transactionId = authorizationTransactionId.getText();
                final String note = noteTextbox.getText();

                final DoVoidResponseType response = payPalVoidController.doVoid(transactionId, note);

                if (response.getAck() == AckCodeType.SUCCESS) {
                    Messagebox.show(LabelUtils.getLabel(widget, SUCCESS),
                            LabelUtils.getLabel(widget, "voidTitle", new Object[0]), Messagebox.OK, MSGBOX_INFORMATION);
                } else {
                    final String errorsMessage = StringUtils.join(PaypalStringUtils.getErrorMessagesList(response.getErrors()), "; ");
                    LOG.error("Error during doVoid web service call: " + errorsMessage);
                    Messagebox.show(LabelUtils.getLabel(widget, FAILURE_MESSAGE, errorsMessage),
                            LabelUtils.getLabel(widget, FAILURE), 1, MSGBOX_ERROR);
                }
            } catch (final Exception e) {
                LOG.error("Void is failed, message: " + e.getMessage(), e);
                final String message = e.getMessage() != null ? e.getMessage() : "Error during void";
                Messagebox.show(
                        message + ((e.getCause() == null) ? StringUtils.EMPTY
                                : new StringBuilder(SEPARATOR).append(e.getCause().getMessage()).toString()),
                        LabelUtils.getLabel(widget, FAILURE, new Object[0]), Messagebox.OK, MSGBOX_ERROR);
            }
        }
    }

    private Listbox createVoidTable(final HtmlBasedComponent container) {
        final Listbox VoidTable = new Listbox();
        VoidTable.setParent(container);
        VoidTable.setVflex(false);
        VoidTable.setFixedLayout(true);

        return VoidTable;
    }

    private Textbox createTableRow(final Widget widget, final Listbox table, final String componentName) {
        final Listcell textBoxCell = createItem(widget, table, componentName);

        final Textbox textBox = new Textbox();
        textBox.setWidth("182px");
        textBox.setParent(textBoxCell);
        return textBox;
    }

    private Listcell createItem(final Widget widget, final Listbox table, final String componentName) {
        final Listitem row = new Listitem();
        row.setParent(table);

        final Listcell cell = createCell(row);
        final Listcell textBoxCell = createCell(row);

        final Label label = new Label(LabelUtils.getLabel(widget, componentName, new Object[0]));
        label.setParent(cell);
        return textBoxCell;
    }

    private Listcell createCell(final Component parent) {
        final Listcell cell = new Listcell();
        cell.setParent(parent);
        return cell;
    }

    private void createVoidButton(final Widget widget, final HtmlBasedComponent container, final Textbox authorizationTransactionTextBox, final Textbox noteTextBox) {
        final Div voidButtonBox = new Div();
        voidButtonBox.setParent(container);

        final Button voidButton = new Button(LabelUtils.getLabel(widget, "voidButton", new Object[0]));
        voidButton.setParent(voidButtonBox);
        voidButton.addEventListener(ON_CLICK, this.createConfirmBeforeCompletingRequestEventListener(widget,
                this.createVoidnEventListener(widget, authorizationTransactionTextBox, noteTextBox)));
    }

    private EventListener createVoidnEventListener(final Widget widget, final Textbox authorizationTransactionId, final Textbox noteTextbox) {
        return new VoidEventListener(widget, authorizationTransactionId, noteTextbox);
    }

    protected class VoidEventListener implements EventListener {
        private final Widget widget;
        private final Textbox authorizationTransactionId;
        private final Textbox noteTextbox;

        public VoidEventListener(final Widget widget, final Textbox authorizationTransactionId, final Textbox noteTextbox) {
            this.widget = widget;
            this.authorizationTransactionId = authorizationTransactionId;
            this.noteTextbox = noteTextbox;
        }

        @Override
        public void onEvent(final Event event) throws Exception {
            handleAttemptVoidEvent(event, widget, authorizationTransactionId, noteTextbox);
            widget.getWidgetController().dispatchEvent(null, widget, null);
        }
    }

    public PopupWidgetHelper getPopupWidgetHelper() {
        return this.popupWidgetHelper;
    }

    @Required
    public void setPopupWidgetHelper(final PopupWidgetHelper popupWidgetHelper) {
        this.popupWidgetHelper = popupWidgetHelper;
    }
}
