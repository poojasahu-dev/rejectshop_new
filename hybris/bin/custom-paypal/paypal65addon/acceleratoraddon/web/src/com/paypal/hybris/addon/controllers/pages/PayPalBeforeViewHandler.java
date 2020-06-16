package com.paypal.hybris.addon.controllers.pages;

import com.paypal.hybris.addon.model.PayPalECButtonComponentModel;
import de.hybris.platform.addonsupport.interceptors.BeforeViewHandlerAdaptee;
import de.hybris.platform.cms2.servicelayer.services.CMSComponentService;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.session.SessionService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.ui.ModelMap;

import com.paypal.hybris.addon.constants.Paypal65addonConstants;
import com.paypal.hybris.addon.controllers.Paypal65addonControllerConstants;
import com.paypal.hybris.addon.controllers.utils.PayPalUserHelper;
import com.paypal.hybris.constants.PaypalConstants;


public class PayPalBeforeViewHandler implements BeforeViewHandlerAdaptee
{
	private static final String B2C_CHECKOUT_CONFIRMATION_PAGE = "pages/checkout/checkoutConfirmationPage";
	private static final String B2C_ADD_TO_CART_POPUP_PAGE = "fragments/cart/addToCartPopup";
	private static final String B2C_SILENT_ORDER_POST_PAGE = "pages/checkout/multi/silentOrderPostPage";
	private static final String B2C_CHECKOUT_SUMMARY_PAGE = "pages/checkout/multi/checkoutSummaryPage";
	private static final String CART_PAGE = "pages/cart/cartPage";
	private static final String B2C_CHECKOUT_DELIVERY_ADDRESS_PAGE = "pages/checkout/multi/addEditDeliveryAddressPage";

	private SessionService sessionService;
	private CMSComponentService cmsComponentService;
	private ConfigurationService configurationService;
	private PayPalUserHelper payPalUserHelper;

	@Override
	public String beforeView(final HttpServletRequest request, final HttpServletResponse response, final ModelMap model,
			final String viewName) throws Exception
	{
		if (B2C_SILENT_ORDER_POST_PAGE.equals(viewName))
		{
			return Paypal65addonControllerConstants.Views.Pages.MultiStepCheckout.SilentOrderPostPage;
		}
		else if (B2C_CHECKOUT_SUMMARY_PAGE.equals(viewName))
		{
			final String repeatRedirectUrl = getSessionService().getAttribute((Paypal65addonConstants.PAY_PAL_REPEAT_REDIRECT_URL));
			if (StringUtils.isNotBlank(repeatRedirectUrl))
			{
				getSessionService().removeAttribute(Paypal65addonConstants.PAY_PAL_REPEAT_REDIRECT_URL);
				return "redirect:" + repeatRedirectUrl;
			}
			else
			{
				return Paypal65addonControllerConstants.Views.Pages.MultiStepCheckout.CheckoutSummaryPage;
			}
		}
		else if (B2C_CHECKOUT_CONFIRMATION_PAGE.equals(viewName))
		{
			return Paypal65addonControllerConstants.Views.Pages.Checkout.CheckoutConfirmationPage;
		}
		else if (B2C_ADD_TO_CART_POPUP_PAGE.equals(viewName))
		{
			final PayPalECButtonComponentModel component = (PayPalECButtonComponentModel) cmsComponentService
					.getSimpleCMSComponent("PayPalECMiniButtonComponent");

			model.addAttribute("payPalECButtonComponent", component);
			return Paypal65addonControllerConstants.Views.Fragments.Cart.AddToCartPopup;
		}
		else if (isCheckoutPage(viewName) || isPayPalCheckoutRedirect(viewName, request))
		{
			if (StringUtils.contains(viewName, B2C_CHECKOUT_DELIVERY_ADDRESS_PAGE)
					&& getSessionService().getAttribute("paypal.general.error.shippingAddress") != null)
			{
				if (getSessionService().getAttribute("in.context.checkout") == null)
				{
					model.addAttribute("accErrorMsgs", getSessionService().getAttribute("paypal.general.error.shippingAddress"));
					getSessionService().removeAttribute("paypal.general.error.shippingAddress");
				}
				else
				{
					getSessionService().removeAttribute("in.context.checkout");
				}
			}
			final String payPalHopUrl = getSessionService().getAttribute(Paypal65addonControllerConstants.PAY_PAL_HOP_URL_ATTR);
			if (StringUtils.isNotBlank(payPalHopUrl))
			{
				getSessionService().removeAttribute(Paypal65addonControllerConstants.PAY_PAL_HOP_URL_ATTR);
				return "redirect:" + payPalHopUrl;
			}
		}

		if (!StringUtils.contains(viewName, Paypal65addonControllerConstants.Views.Pages.Checkout.CheckoutLoginPage)
				&& !StringUtils.contains(viewName, CART_PAGE))
		{
			getSessionService().removeAttribute(Paypal65addonControllerConstants.PAY_PAL_HOP_URL_ATTR);

		}
		return viewName;
	}

	private boolean isCheckoutPage(final String viewName)
	{
		return !Paypal65addonControllerConstants.Views.Pages.Checkout.CheckoutLoginPage.equals(viewName)
				&& StringUtils.contains(viewName, Paypal65addonControllerConstants.CHECKOUT_PAGE_VIEW_NAME_FRAGMENT);
	}

	private boolean isPayPalCheckoutRedirect(final String viewName, final HttpServletRequest request)
	{
		return StringUtils.contains(viewName, CART_PAGE) && payPalUserHelper.isHardLogin(request, true);
	}



	public SessionService getSessionService()
	{
		return sessionService;
	}

	public void setSessionService(final SessionService sessionService)
	{
		this.sessionService = sessionService;
	}

	public CMSComponentService getCmsComponentService()
	{
		return cmsComponentService;
	}

	public void setCmsComponentService(final CMSComponentService cmsComponentService)
	{
		this.cmsComponentService = cmsComponentService;
	}

	public PayPalUserHelper getPayPalUserHelper()
	{
		return payPalUserHelper;
	}

	public void setPayPalUserHelper(final PayPalUserHelper payPalUserHelper)
	{
		this.payPalUserHelper = payPalUserHelper;
	}

	public ConfigurationService getConfigurationService()
	{
		return configurationService;
	}

	public void setConfigurationService(final ConfigurationService configurationService)
	{
		this.configurationService = configurationService;
	}
}
