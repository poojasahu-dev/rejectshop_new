package com.paypal.hybris.transaction.impl;

import com.paypal.hybris.data.GetTransactionDetailsRequestData;
import com.paypal.hybris.data.GetTransactionDetailsResultData;
import com.paypal.hybris.integration.service.PaypalPaymentIntegrationService;
import com.paypal.hybris.transaction.TransactionDetailsService;


public class DefaultTransactionDetailsService implements TransactionDetailsService
{
	private PaypalPaymentIntegrationService paypalPaymentIntegrationService;

	@Override
	public GetTransactionDetailsResultData getTransactionDetails(final String transactionId)
	{
		final GetTransactionDetailsRequestData requestData = new GetTransactionDetailsRequestData();
		requestData.setTransactionId(transactionId);

		return getPaypalPaymentIntegrationService().getTransactionDetails(requestData);
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
