/**
 *
 */
package com.paypal.hybris.facade.impl;

import de.hybris.platform.acceleratorfacades.payment.impl.DefaultPaymentFacade;
import de.hybris.platform.commercefacades.order.data.CCPaymentInfoData;
import de.hybris.platform.commercefacades.order.data.CartData;
import de.hybris.platform.core.model.c2l.LanguageModel;
import de.hybris.platform.core.model.order.CartModel;
import de.hybris.platform.order.CartService;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.i18n.CommonI18NService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.session.SessionService;

import java.util.Locale;

import org.apache.log4j.Logger;

import com.paypal.hybris.data.DoAuthorizationRequestData;
import com.paypal.hybris.data.DoAuthorizationResultData;
import com.paypal.hybris.data.DoCaptureRequestData;
import com.paypal.hybris.data.DoCaptureResultData;
import com.paypal.hybris.data.DoExpressCheckoutPaymentRequestData;
import com.paypal.hybris.data.DoExpressCheckoutPaymentResultData;
import com.paypal.hybris.data.DoReferenceTransactionRequestData;
import com.paypal.hybris.data.DoReferenceTransactionResultData;
import com.paypal.hybris.data.GetExpressCheckoutDetailsResultData;
import com.paypal.hybris.data.SetExpressCheckoutRequestData;
import com.paypal.hybris.data.SetExpressCheckoutResultData;
import com.paypal.hybris.facade.PayPalPaymentFacade;
import com.paypal.hybris.model.PaypalPaymentInfoModel;
import com.paypal.hybris.payment.service.PayPalPaymentService;


public class PayPalPaymentFacadeImpl extends DefaultPaymentFacade implements PayPalPaymentFacade
{
	private final static Logger LOG = Logger.getLogger(PayPalPaymentFacadeImpl.class);

	private PayPalPaymentService payPalPaymentService;
	private CartService cartService;
	private ModelService modelService;
	private SessionService sessionService;
	private ConfigurationService configurationService;
	private CommonI18NService commonI18NService;

	@Override
	public SetExpressCheckoutResultData preparePaypalPayment(final SetExpressCheckoutRequestData requestData)
	{
		LOG.info("calling SetExpressCheckout");

		final LanguageModel currentLanguage = commonI18NService.getCurrentLanguage();
		final Locale locale = commonI18NService.getLocaleForLanguage(currentLanguage);
		requestData.setLocale(locale);

		return payPalPaymentService.setExpressCheckout(requestData);

	}

	@Override
	public GetExpressCheckoutDetailsResultData getExpressCheckoutDetails()
	{
		LOG.info("calling GetExpressCheckoutDetails");

		return payPalPaymentService.getExpressCheckoutDetails();
	}

	/**
	 * Make call to service's doExpressCheckoutPayment method. Additionally converts from dto object to request and from
	 * response to result dto object.
	 *
	 * @param requestData
	 *           dto object with service call params
	 * @return dto object with service call results
	 */
	@Override
	public DoExpressCheckoutPaymentResultData doExpressCheckoutPayment(final DoExpressCheckoutPaymentRequestData requestData)
	{
		return payPalPaymentService.doExpressCheckoutPayment(requestData);
	}

	/**
	 * Make call to service's authorization method. Additionally converts from dto object to request and from response to
	 * result dto object.
	 *
	 * @param requestData
	 *           dto object with service call params
	 * @return dto object with service call results
	 */
	@Override
	public DoAuthorizationResultData doAuthorization(final DoAuthorizationRequestData requestData)
	{
		LOG.info("calling DoAuthorization");

		return payPalPaymentService.doAuthorization(requestData);
	}

	/**
	 * Make call to service's capture method. Additionally converts from dto object to request and from response to
	 * result dto object.
	 *
	 * @param requestData
	 *           dto object with service call params
	 * @return dto object with service call results
	 */
	@Override
	public DoCaptureResultData doCapture(final DoCaptureRequestData requestData)
	{
		LOG.info("calling DoCapture");

		return payPalPaymentService.doCapture(requestData);
	}

	@Override
	public DoReferenceTransactionResultData doReferenceTransaction(final DoReferenceTransactionRequestData requestData)
	{
		LOG.info("calling DoReferenceTransaction");

		return payPalPaymentService.doReferenceTransaction(requestData);
	}

	@Override
	public void setPaymentInfo(final CartData cartData)
	{
		CCPaymentInfoData ccPaymentInfo = cartData.getPaymentInfo();
		if (ccPaymentInfo == null)
		{
			final CartModel cartModel = cartService.getSessionCart();

			// Check if it's PayPal payment
			if (cartModel.getPaymentInfo() instanceof PaypalPaymentInfoModel)
			{
				// Create CCPaymentInfo data and set accountHolderName as a flag
				ccPaymentInfo = new CCPaymentInfoData();
				ccPaymentInfo.setAccountHolderName("PayPal");
			}
		}
		cartData.setPaymentInfo(ccPaymentInfo);
	}

	@Override
	public String getFullResponseUrl(final String responseUrl, final boolean isSecure)
	{
		return super.getFullResponseUrl(responseUrl, isSecure);
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
	 * @return the payPalPaymentService
	 */
	public PayPalPaymentService getPayPalPaymentService()
	{
		return payPalPaymentService;
	}


	/**
	 * @param payPalPaymentService
	 *           the payPalPaymentService to set
	 */
	public void setPayPalPaymentService(final PayPalPaymentService payPalPaymentService)
	{
		this.payPalPaymentService = payPalPaymentService;
	}

}
