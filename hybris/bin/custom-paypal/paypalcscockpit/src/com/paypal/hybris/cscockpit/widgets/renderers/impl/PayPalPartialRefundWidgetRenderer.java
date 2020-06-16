package com.paypal.hybris.cscockpit.widgets.renderers.impl;

import static com.paypal.hybris.cscockpit.widgets.renderers.constants.PayPalPartialRefundWidgetRendererConstants.AMOUNT;
import static com.paypal.hybris.cscockpit.widgets.renderers.constants.PayPalPartialRefundWidgetRendererConstants.CAPTURE_TRANSACTION;
import static com.paypal.hybris.cscockpit.widgets.renderers.constants.PayPalPartialRefundWidgetRendererConstants.FAILURE;
import static com.paypal.hybris.cscockpit.widgets.renderers.constants.PayPalPartialRefundWidgetRendererConstants.FAILURE_MESSAGE;
import static com.paypal.hybris.cscockpit.widgets.renderers.constants.PayPalPartialRefundWidgetRendererConstants.MSGBOX_ERROR;
import static com.paypal.hybris.cscockpit.widgets.renderers.constants.PayPalPartialRefundWidgetRendererConstants.MSGBOX_INFORMATION;
import static com.paypal.hybris.cscockpit.widgets.renderers.constants.PayPalPartialRefundWidgetRendererConstants.ON_CLICK;
import static com.paypal.hybris.cscockpit.widgets.renderers.constants.PayPalPartialRefundWidgetRendererConstants.ON_OK;
import static com.paypal.hybris.cscockpit.widgets.renderers.constants.PayPalPartialRefundWidgetRendererConstants.PARTIAL_REFUND_BUTTON;
import static com.paypal.hybris.cscockpit.widgets.renderers.constants.PayPalPartialRefundWidgetRendererConstants.PARTIAL_REFUND_TITLE;
import static com.paypal.hybris.cscockpit.widgets.renderers.constants.PayPalPartialRefundWidgetRendererConstants.SEPARATOR;
import static com.paypal.hybris.cscockpit.widgets.renderers.constants.PayPalPartialRefundWidgetRendererConstants.SUCCESS;
import static com.paypal.hybris.cscockpit.widgets.renderers.constants.PayPalPartialRefundWidgetRendererConstants.VALIDATION_FAILED;

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
import com.paypal.hybris.cscockpit.widgets.controllers.PayPalPartialRefundController;
import com.paypal.hybris.data.RefundTransactionResultData;

import de.hybris.platform.cockpit.widgets.Widget;
import de.hybris.platform.cscockpit.exceptions.ValidationException;
import de.hybris.platform.cscockpit.utils.LabelUtils;
import de.hybris.platform.cscockpit.widgets.renderers.impl.AbstractCreateWidgetRenderer;
import de.hybris.platform.cscockpit.widgets.renderers.utils.PopupWidgetHelper;
import de.hybris.platform.payment.model.PaymentTransactionEntryModel;



public class PayPalPartialRefundWidgetRenderer extends AbstractCreateWidgetRenderer
{
	private static final Logger LOG = Logger.getLogger(PayPalPartialRefundWidgetRenderer.class);

	private PopupWidgetHelper popupWidgetHelper;

	@Override
	protected HtmlBasedComponent createContentInternal(final Widget widget, final HtmlBasedComponent rootContainer)
	{
		final PaymentTransactionEntryModel transaction = getTransaction(widget);
		String transactionId = StringUtils.EMPTY;
		if (transaction != null)
		{
			transactionId = transaction.getRequestId();
		}

		final Div container = new Div();
		final Listbox partialRefundTable = createPartialRefundTable(container);
		final Textbox captureTransactionTextBox = createTableRow(widget, partialRefundTable, CAPTURE_TRANSACTION);
		if (StringUtils.isNotEmpty(transactionId))
		{
			captureTransactionTextBox.setText(transactionId);
		}
		final Textbox amountTextBox = createTableRow(widget, partialRefundTable, AMOUNT);

		createPartialRefundButton(widget, container, captureTransactionTextBox, amountTextBox);

		return container;
	}

	public void handleAttemptPartialRefundEvent(final Event event, final Widget widget, final Textbox captureTransactionId,
			final Textbox amount) throws InterruptedException
	{
		if (ON_OK.equals(event.getName()))
		{
			try
			{
				final PayPalPartialRefundController payPalPartialRefundController = (PayPalPartialRefundController) widget.getWidgetController();
				final String refundAmount = amount.getText();
				final String transactionId = captureTransactionId.getText();

				payPalPartialRefundController.validateTransactionId(transactionId);

				{
					final RefundTransactionResultData response = payPalPartialRefundController.createPartialRefundRequest(transactionId, refundAmount);
					if (response.getErrors() == null || response.getErrors().isEmpty())
					{
						Messagebox.show(LabelUtils.getLabel(widget, SUCCESS),
								LabelUtils.getLabel(widget, PARTIAL_REFUND_TITLE, new Object[0]), 1, MSGBOX_INFORMATION);
					}
					else
					{
						Messagebox.show(LabelUtils.getLabel(widget, FAILURE_MESSAGE, response.getErrors().get(0).getLongMessage()),
								LabelUtils.getLabel(widget, FAILURE), 1, MSGBOX_ERROR);
					}
				}

			}
			catch (final Exception e)
			{
			    LOG.error("PartialRefund is failed, message: " + e.getMessage(), e);
				Messagebox.show(
						e.getMessage() + ((e.getCause() == null) ? StringUtils.EMPTY
								: new StringBuilder(SEPARATOR).append(e.getCause().getMessage()).toString()),
						LabelUtils.getLabel(widget, FAILURE, new Object[0]), 1, MSGBOX_ERROR);
				LOG.error("Partial refund request is failed", e);
			}
		}
	}

	public class PartialRefundEventListener implements EventListener
	{

		private final Widget widget;
		private final Textbox captureTransactionId;
		private final Textbox amount;

		public PartialRefundEventListener(final Widget widget, final Textbox captureTransactionId, final Textbox amount)
		{
			this.widget = widget;
			this.amount = amount;
			this.captureTransactionId = captureTransactionId;
		}

		@Override
		public void onEvent(final Event event) throws Exception
		{
			handleAttemptPartialRefundEvent(event, widget, captureTransactionId, amount);
			widget.getWidgetController().dispatchEvent(null, widget, null);
		}
	}

	private PaymentTransactionEntryModel getTransaction(final Widget widget)
	{
		final PayPalPartialRefundController payPalPartialRefundController = (PayPalPartialRefundController) widget
				.getWidgetController();

		return payPalPartialRefundController.getPaymentTransaction();
	}

	private Listbox createPartialRefundTable(final HtmlBasedComponent container)
	{
		final Listbox partialRefundTable = new Listbox();
		partialRefundTable.setParent(container);
		partialRefundTable.setVflex(false);
		partialRefundTable.setFixedLayout(true);

		return partialRefundTable;
	}

	private Textbox createTableRow(final Widget widget, final Listbox table, final String componentName)
	{
		final Listitem row = new Listitem();
		row.setParent(table);

		final Listcell labelCell = createCell(row);
		final Listcell textBoxCell = createCell(row);

		final Label label = new Label(LabelUtils.getLabel(widget, componentName, new Object[0]));
		label.setParent(labelCell);

		final Textbox textBox = new Textbox();
		textBox.setParent(textBoxCell);
		textBox.setWidth("182px");
		return textBox;
	}

	private Listcell createCell(final Component parent)
	{
		final Listcell cell = new Listcell();
		cell.setParent(parent);
		return cell;
	}

	private void createPartialRefundButton(final Widget widget, final HtmlBasedComponent container,
			final Textbox captureTransactionTextBox, final Textbox amountTextBox)
	{
		final Div partialRefundButtonBox = new Div();
		partialRefundButtonBox.setParent(container);

		final Button partialRefundButton = new Button(LabelUtils.getLabel(widget, PARTIAL_REFUND_BUTTON, new Object[0]));
		partialRefundButton.setParent(partialRefundButtonBox);
		partialRefundButton.addEventListener(ON_CLICK, this.createConfirmBeforeCompletingRequestEventListener(widget,
				this.createPartialRefundnEventListener(widget, captureTransactionTextBox, amountTextBox)));
	}

	private EventListener createPartialRefundnEventListener(final Widget widget, final Textbox captureTransactionId,
			final Textbox amount)
	{
		return new PartialRefundEventListener(widget, captureTransactionId, amount);
	}

	@Required
	public void setPopupWidgetHelper(final PopupWidgetHelper popupWidgetHelper)
	{
		this.popupWidgetHelper = popupWidgetHelper;
	}

	protected PopupWidgetHelper getPopupWidgetHelper()
	{
		return this.popupWidgetHelper;
	}
}
