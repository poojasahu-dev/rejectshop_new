/**
 *
 */
package com.paypal.hybris.refund;

import de.hybris.platform.basecommerce.enums.ReturnStatus;
import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.payment.enums.PaymentTransactionType;
import de.hybris.platform.payment.model.PaymentTransactionEntryModel;
import de.hybris.platform.payment.model.PaymentTransactionModel;
import de.hybris.platform.refund.impl.DefaultRefundService;
import de.hybris.platform.returns.model.RefundEntryModel;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;

import com.paypal.hybris.constants.PaypalConstants;
import com.paypal.hybris.data.RefundTransactionRequestData;
import com.paypal.hybris.data.RefundTransactionResultData;
import com.paypal.hybris.integration.service.PaypalPaymentIntegrationService;
import com.paypal.hybris.model.PaypalPaymentInfoModel;


public class PayPalRefundService extends DefaultRefundService
{
	private static final Logger LOG = Logger.getLogger(PayPalRefundService.class);

	private PaypalPaymentIntegrationService paypalPaymentIntegrationService;

	@Override
	public void apply(final List<RefundEntryModel> refunds, final OrderModel order)
	{
		super.apply(refunds, order);
		refundAllPayPalPayments(refunds, order);
	}

	private void refundAllPayPalPayments(final List<RefundEntryModel> refunds, final OrderModel order)
	{
		LOG.debug("Perform paypal refunds");
		if (order.getPaymentInfo() instanceof PaypalPaymentInfoModel)
		{
			final List<PaymentTransactionModel> paymentTransactionList = order.getPaymentTransactions();

			boolean isAllSuccess = true;
			// cancel all created capture transaction in order
			for (final PaymentTransactionModel paymentTransaction : paymentTransactionList)
			{
				final List<PaymentTransactionEntryModel> paymentTransactionEntryList = paymentTransaction.getEntries();
				if (CollectionUtils.isNotEmpty(paymentTransactionEntryList))
				{
					for (final PaymentTransactionEntryModel paymentTransactionEntry : paymentTransactionEntryList)
					{
						if (PaymentTransactionType.CAPTURE.equals(paymentTransactionEntry.getType())
								&& PaypalConstants.STATUS_ACCEPTED.equals(paymentTransactionEntry.getTransactionStatus()))
						{
							isAllSuccess &= makeRefundServiceCall(paymentTransactionEntry);
						}
					}
				}
			}
			if (isAllSuccess && CollectionUtils.isNotEmpty(refunds))
			{
				for (final RefundEntryModel refund : refunds)
				{
					refund.setStatus(ReturnStatus.RECEIVED);
					getModelService().save(refund);
				}
			}
		}
	}

	private boolean makeRefundServiceCall(final PaymentTransactionEntryModel paymentTransactionEntry)
	{
		final RefundTransactionRequestData requestData = new RefundTransactionRequestData();
		requestData.setTransactionId(paymentTransactionEntry.getRequestId());

		final RefundTransactionResultData resultData = paypalPaymentIntegrationService.refundTransaction(requestData);

		return PaypalConstants.STATUS_SUCCESS.equals(resultData.getAck());
	}

	/**
	 * @return the paypalPaymentIntegrationService
	 */
	public PaypalPaymentIntegrationService getPaypalPaymentIntegrationService()
	{
		return paypalPaymentIntegrationService;
	}

	/**
	 * @param paypalPaymentIntegrationService
	 *           the paypalPaymentIntegrationService to set
	 */
	public void setPaypalPaymentIntegrationService(final PaypalPaymentIntegrationService paypalPaymentIntegrationService)
	{
		this.paypalPaymentIntegrationService = paypalPaymentIntegrationService;
	}


}
