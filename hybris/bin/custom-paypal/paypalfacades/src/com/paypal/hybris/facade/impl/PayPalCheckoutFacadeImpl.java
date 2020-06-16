package com.paypal.hybris.facade.impl;

import de.hybris.platform.acceleratorfacades.order.impl.DefaultAcceleratorCheckoutFacade;
import de.hybris.platform.acceleratorservices.uiexperience.UiExperienceService;
import de.hybris.platform.commercefacades.order.CheckoutFacade;
import de.hybris.platform.commercefacades.order.data.CCPaymentInfoData;
import de.hybris.platform.commerceservices.enums.UiExperienceLevel;
import de.hybris.platform.core.model.order.CartModel;
import de.hybris.platform.core.model.order.payment.PaymentInfoModel;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import de.hybris.platform.servicelayer.session.SessionService;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.paypal.hybris.constants.PaypalConstants;
import com.paypal.hybris.constants.PaypalfacadesConstants;
import com.paypal.hybris.data.AbstractResultData;
import com.paypal.hybris.data.DoAuthorizationResultData;
import com.paypal.hybris.data.DoExpressCheckoutPaymentRequestData;
import com.paypal.hybris.data.DoExpressCheckoutPaymentResultData;
import com.paypal.hybris.data.ResultErrorData;
import com.paypal.hybris.facade.PayPalCheckoutFacade;
import com.paypal.hybris.model.PaypalPaymentInfoModel;
import com.paypal.hybris.payment.service.PayPalPaymentService;


public class PayPalCheckoutFacadeImpl extends DefaultAcceleratorCheckoutFacade implements PayPalCheckoutFacade
{
	private static final Logger LOG = Logger.getLogger(PayPalCheckoutFacadeImpl.class);

	private CheckoutFacade checkoutFacade;

	private SessionService sessionService;

	private UiExperienceService uiExperienceService;

	private ConfigurationService configurationService;

	private Converter<PaypalPaymentInfoModel, CCPaymentInfoData> paypalPaymentInfoConverter;

	private PayPalPaymentService payPalPaymentService;

	@Override
	public boolean authorizePayment(final String securityCode)
	{

		if (checkIfCurrentUserIsTheCartUser())
		{
			final PaypalPaymentInfoModel payPalPaymentInfo = payPalPaymentService.getPayPalPaymentInfo();
			if (payPalPaymentInfo != null)
			{
				final DoExpressCheckoutPaymentRequestData prepareCheckoutRequestData = prepareCheckoutRequestData(payPalPaymentInfo);

				final DoExpressCheckoutPaymentResultData doExprCheckPaymentResData = payPalPaymentService.doExpressCheckoutPayment(prepareCheckoutRequestData);

				if (PaypalConstants.STATUS_SUCCESS.equals(doExprCheckPaymentResData.getAck()))
				{
					return payPalPaymentService.authorizePayment(doExprCheckPaymentResData);
				}
				else
				{
					LOG.error("DoExpressCheckoutPayment failed");
					handleErrors(doExprCheckPaymentResData, payPalPaymentInfo.getToken());
					return false;
				}
			}
			else
			{
				return super.authorizePayment(securityCode);
			}

		}
		LOG.error("DoExpressCheckoutFailed failed. User not match!");
		return false;
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
					LOG.info("uiExperienceLevel: " + uiExperienceLevel + ", uiExperienceLevel.code: " + uiExperienceLevel.getCode());
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
						getSessionService().setAttribute(PaypalfacadesConstants.PAY_PAL_REPEAT_REDIRECT_URL, redirectUrl);
					}
					LOG.info("redirectUrl: " + redirectUrl);
				}
			}
		}
	}

	@Override
	public CCPaymentInfoData getPaymentDetails()
	{
		final CartModel cart = getCart();
		if (cart != null)
		{
			final PaymentInfoModel paymentInfo = cart.getPaymentInfo();
			if (paymentInfo instanceof PaypalPaymentInfoModel)
			{
				return paypalPaymentInfoConverter.convert((PaypalPaymentInfoModel) paymentInfo);
			}
			else
			{
				return super.getPaymentDetails();
			}
		}

		return null;
	}

	private DoExpressCheckoutPaymentRequestData prepareCheckoutRequestData(final PaypalPaymentInfoModel paymentInfo)
	{
		final DoExpressCheckoutPaymentRequestData requestData = new DoExpressCheckoutPaymentRequestData();
		requestData.setToken(paymentInfo.getToken());
		requestData.setPayerId(paymentInfo.getPayerId());
		requestData.setPaymentAction(getConfigurationService().getConfiguration().getString(PaypalConstants.PAYMENT_ACTION));
		requestData.setSessionCart(checkoutFacade.getCheckoutCart());

		return requestData;
	}

	public CheckoutFacade getCheckoutFacade()
	{
		return checkoutFacade;
	}

	public void setCheckoutFacade(final CheckoutFacade checkoutFacade)
	{
		this.checkoutFacade = checkoutFacade;
	}

	public SessionService getSessionService()
	{
		return sessionService;
	}

	public void setSessionService(final SessionService sessionService)
	{
		this.sessionService = sessionService;
	}

	@Override
	public UiExperienceService getUiExperienceService()
	{
		return uiExperienceService;
	}

	@Override
	public void setUiExperienceService(final UiExperienceService uiExperienceService)
	{
		this.uiExperienceService = uiExperienceService;
	}

	public ConfigurationService getConfigurationService()
	{
		return configurationService;
	}

	public void setConfigurationService(final ConfigurationService configurationService)
	{
		this.configurationService = configurationService;
	}

	public Converter<PaypalPaymentInfoModel, CCPaymentInfoData> getPaypalPaymentInfoConverter()
	{
		return paypalPaymentInfoConverter;
	}

	public void setPaypalPaymentInfoConverter(
			final Converter<PaypalPaymentInfoModel, CCPaymentInfoData> paypalPaymentInfoConverter)
	{
		this.paypalPaymentInfoConverter = paypalPaymentInfoConverter;
	}

	public PayPalPaymentService getPayPalPaymentService()
	{
		return payPalPaymentService;
	}

	public void setPayPalPaymentService(final PayPalPaymentService payPalPaymentService)
	{
		this.payPalPaymentService = payPalPaymentService;
	}

}
