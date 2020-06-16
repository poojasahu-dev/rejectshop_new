package com.paypal.hybris.cscockpit.widgets.renderers.impl;

import static com.paypal.hybris.cscockpit.widgets.renderers.constants.PayPalPartialRefundWidgetRendererConstants.FAILURE;
import static com.paypal.hybris.cscockpit.widgets.renderers.constants.PayPalPartialRefundWidgetRendererConstants.FAILURE_MESSAGE;
import static com.paypal.hybris.cscockpit.widgets.renderers.constants.PayPalPartialRefundWidgetRendererConstants.MSGBOX_ERROR;
import static com.paypal.hybris.cscockpit.widgets.renderers.constants.PayPalPartialRefundWidgetRendererConstants.MSGBOX_INFORMATION;
import static com.paypal.hybris.cscockpit.widgets.renderers.constants.PayPalPartialRefundWidgetRendererConstants.ON_CLICK;
import static com.paypal.hybris.cscockpit.widgets.renderers.constants.PayPalPartialRefundWidgetRendererConstants.ON_OK;
import static com.paypal.hybris.cscockpit.widgets.renderers.constants.PayPalPartialRefundWidgetRendererConstants.SEPARATOR;
import static com.paypal.hybris.cscockpit.widgets.renderers.constants.PayPalPartialRefundWidgetRendererConstants.SUCCESS;

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
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Div;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

import com.paypal.hybris.cscockpit.widgets.controllers.impl.PayPalMultipleCaptureControllerImpl;
import com.paypal.hybris.data.DoCaptureResultData;

import urn.ebay.apis.eBLBaseComponents.CompleteCodeType;


public class PayPalMultipleCaptureWidgetRenderer extends AbstractCreateWidgetRenderer
{
	private static final Logger LOG = Logger.getLogger(PayPalMultipleCaptureWidgetRenderer.class);

	private PopupWidgetHelper popupWidgetHelper;

	@Override
	protected HtmlBasedComponent createContentInternal(final Widget widget, final HtmlBasedComponent rootContainer)
	{
		final PayPalMultipleCaptureControllerImpl payPalMultipleCaptureController = (PayPalMultipleCaptureControllerImpl) widget
				.getWidgetController();
		final String authorizationTransactionId = payPalMultipleCaptureController.getAuthorizationTransactionId();

		final Div container = new Div();
		final Listbox multiCaptureTable = createmultipleCaptureTable(container);
		final Textbox authorizationTransactionTextBox = createTableRow(widget, multiCaptureTable, "authorizationTransaction");
		if (StringUtils.isNotEmpty(authorizationTransactionId))
		{
			authorizationTransactionTextBox.setText(authorizationTransactionId);
		}
		final Combobox completeTypeTextBox = createCompleteTypeComboboxRow(widget, multiCaptureTable, "completeType");
		final Textbox amountTextBox = createTableRow(widget, multiCaptureTable, "amount");

		createMultiCaptureButton(widget, container, authorizationTransactionTextBox, completeTypeTextBox, amountTextBox);

		return container;
	}

	private void handleAttemptMultiCaptureEvent(final Event event, final Widget widget, final Textbox captureTransactionId,
			final Combobox captureCompleteType, final Textbox amount) throws InterruptedException
	{
		if (ON_OK.equals(event.getName()))
		{
			try
			{
				final PayPalMultipleCaptureControllerImpl payPalMultipleCaptureController = (PayPalMultipleCaptureControllerImpl) widget.getWidgetController();

				final String captureAmount = amount.getText();
				final String transactionId = captureTransactionId.getText();
				final String completeType = captureCompleteType.getText();

				if (payPalMultipleCaptureController.validateTransactionId(transactionId))
				{

					final DoCaptureResultData response = payPalMultipleCaptureController.createMultiCaptureRequest(captureAmount,
							transactionId, completeType);

					if (response.getErrors() == null || response.getErrors().isEmpty())
					{
						Messagebox.show(LabelUtils.getLabel(widget, SUCCESS),
								LabelUtils.getLabel(widget, "multipleCaptureTitle", new Object[0]), 1, MSGBOX_INFORMATION);
					}
					else
					{
						Messagebox.show(LabelUtils.getLabel(widget, FAILURE_MESSAGE, response.getErrors().get(0).getLongMessage()),
								LabelUtils.getLabel(widget, FAILURE), 1, MSGBOX_ERROR);
					}
				}

			}
//			catch (final ValidationException e)
//			{
//				Messagebox.show(
//						e.getMessage() + ((e.getCause() == null) ? StringUtils.EMPTY
//								: new StringBuilder(SEPARATOR).append(e.getCause().getMessage()).toString()),
//						LabelUtils.getLabel(widget, VALIDATION_FAILED, new Object[0]), 1, MSGBOX_ERROR);
//			}
			catch (final Exception e)
			{
			    LOG.error("Multiple capture request is failed, message: " + e.getMessage(), e);
				final String message = e.getMessage() != null ? e.getMessage() : "Error during capture";
				Messagebox.show(
						message + ((e.getCause() == null) ? StringUtils.EMPTY
								: new StringBuilder(SEPARATOR).append(e.getCause().getMessage()).toString()),
						LabelUtils.getLabel(widget, FAILURE, new Object[0]), 1, MSGBOX_ERROR);
				getPopupWidgetHelper().dismissCurrentPopup();
			}
		}
	}

	private Listbox createmultipleCaptureTable(final HtmlBasedComponent container)
	{
		final Listbox multipleCaptureTable = new Listbox();
		multipleCaptureTable.setParent(container);
		multipleCaptureTable.setVflex(false);
		multipleCaptureTable.setFixedLayout(true);

		return multipleCaptureTable;
	}

	private Textbox createTableRow(final Widget widget, final Listbox table, final String componentName)
	{
		final Listcell textBoxCell = createItem(widget, table, componentName);

		final Textbox textBox = new Textbox();
		textBox.setWidth("182px");
		textBox.setParent(textBoxCell);
		return textBox;
	}

	private Listcell createItem(final Widget widget, final Listbox table, final String componentName)
	{
		final Listitem row = new Listitem();
		row.setParent(table);

		final Listcell cell = createCell(row);
		final Listcell textBoxCell = createCell(row);

		final Label label = new Label(LabelUtils.getLabel(widget, componentName, new Object[0]));
		label.setParent(cell);
		return textBoxCell;
	}

	private Combobox createCompleteTypeComboboxRow(final Widget widget, final Listbox table, final String componentName)
	{
		final Listcell captureAmountIdTextBoxCell = createItem(widget, table, componentName);

		final Combobox comboBox = new Combobox();
		comboBox.setParent(captureAmountIdTextBoxCell);
		for (final CompleteCodeType completeCodeType : CompleteCodeType.values())
		{
			createComboItem(comboBox, completeCodeType);
		}
		comboBox.setWidth("170px");
		comboBox.setSelectedIndex(0);
		return comboBox;
	}

	private void createComboItem(final Combobox completeTypeComboBox, final CompleteCodeType completeCodeType)
	{
		final Comboitem comboItem = new Comboitem(completeCodeType.toString());
		comboItem.setParent(completeTypeComboBox);
		comboItem.setValue(completeCodeType);
	}

	private Listcell createCell(final Component parent)
	{
		final Listcell cell = new Listcell();
		cell.setParent(parent);
		return cell;
	}

	private void createMultiCaptureButton(final Widget widget, final HtmlBasedComponent container,
			final Textbox authorizationTransactionTextBox, final Combobox completeTypeTextBox, final Textbox amountTextBox)
	{
		final Div multiCaptureButtonBox = new Div();
		multiCaptureButtonBox.setParent(container);

		final Button multiCaptureButton = new Button(LabelUtils.getLabel(widget, "multipleCaptureButton", new Object[0]));
		multiCaptureButton.setParent(multiCaptureButtonBox);
		multiCaptureButton.addEventListener(ON_CLICK, this.createConfirmBeforeCompletingRequestEventListener(widget,
				this.createMultiCapturenEventListener(widget, authorizationTransactionTextBox, completeTypeTextBox, amountTextBox)));
	}

	private EventListener createMultiCapturenEventListener(final Widget widget, final Textbox captureTransactionId,
			final Combobox completeTypeTextBox, final Textbox amount)
	{
		return new MultiCaptureEventListener(widget, captureTransactionId, completeTypeTextBox, amount);
	}

	public class MultiCaptureEventListener implements EventListener
	{

		private final Widget widget;
		private final Textbox authorizationTransactionId;
		private final Combobox completeType;
		private final Textbox amount;

		public MultiCaptureEventListener(final Widget widget, final Textbox authorizationTransactionId, final Combobox completeType,
				final Textbox amount)
		{
			this.widget = widget;
			this.amount = amount;
			this.authorizationTransactionId = authorizationTransactionId;
			this.completeType = completeType;
		}

		@Override
		public void onEvent(final Event event) throws Exception
		{
			handleAttemptMultiCaptureEvent(event, widget, authorizationTransactionId, completeType, amount);
			widget.getWidgetController().dispatchEvent(null, widget, null);
		}
	}

	public PopupWidgetHelper getPopupWidgetHelper()
	{
		return this.popupWidgetHelper;
	}

	@Required
	public void setPopupWidgetHelper(final PopupWidgetHelper popupWidgetHelper)
	{
		this.popupWidgetHelper = popupWidgetHelper;
	}

}
