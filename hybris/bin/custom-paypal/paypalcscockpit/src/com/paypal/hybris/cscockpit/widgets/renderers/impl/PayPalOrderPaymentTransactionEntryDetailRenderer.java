/**
 *
 */
package com.paypal.hybris.cscockpit.widgets.renderers.impl;

import de.hybris.platform.cockpit.model.meta.TypedObject;
import de.hybris.platform.cscockpit.widgets.renderers.details.impl.OrderPaymentTransactionEntryDetailRenderer;
import de.hybris.platform.payment.model.PaymentTransactionEntryModel;
import de.hybris.platform.payment.model.PaymentTransactionModel;


public class PayPalOrderPaymentTransactionEntryDetailRenderer extends OrderPaymentTransactionEntryDetailRenderer
{

	@Override
	protected TypedObject getPaymentInfo(final TypedObject transactionEntry)
	{
		if (transactionEntry != null && transactionEntry.getObject() != null)
		{
			final PaymentTransactionModel paymentTransactionModel = ((PaymentTransactionEntryModel) transactionEntry.getObject())
					.getPaymentTransaction();
			if ((paymentTransactionModel != null) && (paymentTransactionModel.getInfo() != null))
			{
				return getCockpitTypeService().wrapItem(paymentTransactionModel.getInfo());
			}
		}

		return null;
	}
}
