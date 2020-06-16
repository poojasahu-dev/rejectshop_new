/**
 *
 */
package com.paypal.hybris.transaction.strategy.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import com.paypal.hybris.constants.PaypalConstants;
import com.paypal.hybris.data.AbstractResultData;
import com.paypal.hybris.data.DoAuthorizationRequestData;
import com.paypal.hybris.data.DoAuthorizationResultData;
import com.paypal.hybris.data.DoExpressCheckoutPaymentResultData;
import com.paypal.hybris.data.PaymentInfoData;
import com.paypal.hybris.data.PaymentStatus;
import com.paypal.hybris.data.PendingReason;
import com.paypal.hybris.data.ResultErrorData;
import com.paypal.hybris.integration.service.PaypalPaymentIntegrationService;
import com.paypal.hybris.transaction.strategy.PayPalCreateTransactionStrategy;

import de.hybris.platform.acceleratorservices.uiexperience.UiExperienceService;
import de.hybris.platform.commerceservices.enums.UiExperienceLevel;
import de.hybris.platform.core.model.order.CartModel;
import de.hybris.platform.payment.dto.TransactionStatus;
import de.hybris.platform.payment.dto.TransactionStatusDetails;
import de.hybris.platform.payment.enums.PaymentTransactionType;
import de.hybris.platform.payment.model.PaymentTransactionEntryModel;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.session.SessionService;


public class PayPalCreateOrderTransactionStrategy extends PayPalAbstractCreateTransactionStrategy
		implements PayPalCreateTransactionStrategy
{

	private static final Logger LOG = Logger.getLogger(PayPalCreateOrderTransactionStrategy.class);

	private PaypalPaymentIntegrationService paypalPaymentIntegrationService;
	private SessionService sessionService;
	private UiExperienceService uiExperienceService;
	private ConfigurationService configurationService;


	@Override
	public void createPaymentTransaction(final PaymentInfoData paymentInfoData,
			final List<PaymentTransactionEntryModel> paymentTransactionEntries) throws Exception
	{
		final CartModel cartModel = getCart();

		String transactionId = paymentInfoData.getTransactionId();
		final String currencyIsoCode = paymentInfoData.getCurrencyIsoCode();
		final double amount = paymentInfoData.getGrossAmount();
		final Date paymentDate = paymentInfoData.getPaymentDate().getTime();


		PaymentTransactionEntryModel orderTransactionEntry = null;


		if (PaymentStatus.PENDING == paymentInfoData.getPaymentStatus()
				&& PendingReason.AUTHORIZATION != paymentInfoData.getPendingReason())
		{
			orderTransactionEntry = createTransactionEntry(PaymentTransactionType.ORDER, PaymentStatus.PENDING.name(),
					paymentInfoData.getPendingReason().name(), transactionId, cartModel, currencyIsoCode, amount, paymentDate);
		}
		else
		{
			orderTransactionEntry = createTransactionEntry(PaymentTransactionType.ORDER, TransactionStatus.ACCEPTED.name(),
					TransactionStatusDetails.SUCCESFULL.name(), transactionId, cartModel, currencyIsoCode, amount, paymentDate);
		}
		paymentTransactionEntries.add(orderTransactionEntry);

		final DoAuthorizationRequestData authorizationRequest = prepareAuthorizationRequest(paymentInfoData);

	}

	private DoAuthorizationRequestData prepareAuthorizationRequest(final PaymentInfoData paymentInfoData)
	{

		final DoAuthorizationRequestData doAuthReqData = new DoAuthorizationRequestData();
		doAuthReqData.setTransactionId(paymentInfoData.getTransactionId());
		doAuthReqData.setAmount(paymentInfoData.getGrossAmount());
		doAuthReqData.setCurrencyIsoCode(paymentInfoData.getCurrencyIsoCode());

		return doAuthReqData;

	}

	private void handleErrors(final AbstractResultData responseData, final String transactionId)
	{
		final List<ResultErrorData> errorDataList = responseData.getErrors();
		if (CollectionUtils.isNotEmpty(errorDataList))
		{
			final Iterator<ResultErrorData> errorIterator = errorDataList.iterator();
			while (errorIterator.hasNext())
			{
				final ResultErrorData errorData = errorIterator.next();

				final String errorCode = errorData.getErrorCode();
				LOG.error("Error code: " + errorCode + ", short message: " + errorData.getShortMessage() + ", long message: " + errorData.getLongMessage());

				String redirectUrl = StringUtils.EMPTY;
				if (PaypalConstants.ERROR_CODE_10486.equals(errorCode))
				{
					final UiExperienceLevel uiExperienceLevel = uiExperienceService.getUiExperienceLevel();
					final String envProfile = getConfigurationService().getConfiguration().getString(PaypalConstants.PAYPAL_ENV_PROFILE);

					if (responseData instanceof DoExpressCheckoutPaymentResultData)
					{
					    redirectUrl = getConfigurationService().getConfiguration().getString(PaypalConstants.PP_PREFIX + envProfile + PaypalConstants.REDIRECT_URL + uiExperienceLevel.getCode());
					}
					else if (responseData instanceof DoAuthorizationResultData)
					{
					    redirectUrl = getConfigurationService().getConfiguration().getString(PaypalConstants.PP_PREFIX + envProfile + PaypalConstants.REDIRECT_URL_REPEAT_ORDER + uiExperienceLevel.getCode());
					}

					if (StringUtils.isNotEmpty(redirectUrl))
					{
					    redirectUrl += transactionId;
						getSessionService().setAttribute(PaypalConstants.PAY_PAL_REPEAT_REDIRECT_URL, redirectUrl);
					}
					LOG.info("redirectUrl: " + redirectUrl);
				}
			}
		}
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

	/**
	 * @return the sessionService
	 */
	public SessionService getSessionService()
	{
		return sessionService;
	}

	/**
	 * @param sessionService
	 *           the sessionService to set
	 */
	public void setSessionService(final SessionService sessionService)
	{
		this.sessionService = sessionService;
	}

	/**
	 * @return the uiExperienceService
	 */
	public UiExperienceService getUiExperienceService()
	{
		return uiExperienceService;
	}

	/**
	 * @param uiExperienceService
	 *           the uiExperienceService to set
	 */
	public void setUiExperienceService(final UiExperienceService uiExperienceService)
	{
		this.uiExperienceService = uiExperienceService;
	}

	/**
	 * @return the configurationService
	 */
	public ConfigurationService getConfigurationService()
	{
		return configurationService;
	}

	/**
	 * @param configurationService
	 *           the configurationService to set
	 */
	public void setConfigurationService(final ConfigurationService configurationService)
	{
		this.configurationService = configurationService;
	}

}
