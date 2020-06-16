/**
 *
 */
package com.paypal.hybris.transaction.strategy.impl;

import de.hybris.platform.core.model.c2l.CurrencyModel;
import de.hybris.platform.core.model.order.CartModel;
import de.hybris.platform.order.CartService;
import de.hybris.platform.payment.enums.PaymentTransactionType;
import de.hybris.platform.payment.model.PaymentTransactionEntryModel;
import de.hybris.platform.servicelayer.i18n.CommonI18NService;
import de.hybris.platform.servicelayer.model.ModelService;

import java.math.BigDecimal;
import java.util.Date;

import com.paypal.hybris.constants.PaypalConstants;


public abstract class PayPalAbstractCreateTransactionStrategy
{
	private ModelService modelService;
	private CommonI18NService commonI18NService;
	private CartService cartService;

	public CartModel getCart()
	{
		return cartService.getSessionCart();
	}

	public PaymentTransactionEntryModel createTransactionEntry(final PaymentTransactionType type, final String status,
			final String statusDetails, final String requestId, final CartModel cartModel, final String currencyIsoCode,
			final double amount, final Date timeStamp)
	{
		final PaymentTransactionEntryModel paymentTransactionEntry = modelService.create(PaymentTransactionEntryModel.class);

		paymentTransactionEntry.setRequestId(requestId);
		paymentTransactionEntry.setType(type);
		paymentTransactionEntry.setTransactionStatus(status);
		paymentTransactionEntry.setTransactionStatusDetails(statusDetails);

		final String code = PaypalConstants.PAYMENT_PROVIDER_NAME + "_cart_" + cartModel.getCode() + "_stamp_"
				+ System.currentTimeMillis();
		paymentTransactionEntry.setCode(code);

		final CurrencyModel currency = getCurrencyForIsoCode(currencyIsoCode);
		paymentTransactionEntry.setCurrency(currency);

		final BigDecimal transactionAmount = BigDecimal.valueOf(amount);
		paymentTransactionEntry.setAmount(transactionAmount);

		paymentTransactionEntry.setTime(timeStamp);

		return paymentTransactionEntry;
	}

	private CurrencyModel getCurrencyForIsoCode(final String currencyIsoCode)
	{
		final CurrencyModel currencyModel = commonI18NService.getCurrency(currencyIsoCode);
		return currencyModel;
	}

	/**
	 * @return the modelService
	 */
	public ModelService getModelService()
	{
		return modelService;
	}

	/**
	 * @param modelService
	 *           the modelService to set
	 */
	public void setModelService(final ModelService modelService)
	{
		this.modelService = modelService;
	}

	/**
	 * @return the commonI18NService
	 */
	public CommonI18NService getCommonI18NService()
	{
		return commonI18NService;
	}

	/**
	 * @param commonI18NService
	 *           the commonI18NService to set
	 */
	public void setCommonI18NService(final CommonI18NService commonI18NService)
	{
		this.commonI18NService = commonI18NService;
	}

	/**
	 * @return the cartService
	 */
	public CartService getCartService()
	{
		return cartService;
	}

	/**
	 * @param cartService
	 *           the cartService to set
	 */
	public void setCartService(final CartService cartService)
	{
		this.cartService = cartService;
	}


}
