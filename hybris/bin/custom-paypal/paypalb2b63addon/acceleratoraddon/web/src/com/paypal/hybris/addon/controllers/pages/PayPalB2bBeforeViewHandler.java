package com.paypal.hybris.addon.controllers.pages;

import com.paypal.hybris.model.PaypalPaymentInfoModel;
import de.hybris.platform.addonsupport.interceptors.BeforeViewHandlerAdaptee;
import de.hybris.platform.cms2.servicelayer.services.CMSComponentService;
import de.hybris.platform.order.CartService;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.session.SessionService;
import com.paypal.hybris.addon.model.PayPalB2bECButtonComponentModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.ui.ModelMap;

import com.paypal.hybris.addon.constants.Paypalb2b63addonConstants;
import com.paypal.hybris.addon.controllers.Paypalb2b63addonControllerConstants;
import com.paypal.hybris.addon.controllers.utils.PayPalUserHelper;
import com.paypal.hybris.constants.PaypalConstants;


public class PayPalB2bBeforeViewHandler implements BeforeViewHandlerAdaptee
{
	private static final String ADDON_PREFIX_B2B = "addon:/b2bacceleratoraddon/";
	private static final String B2B_CHECKOUT_CONFIRMATION_PAGE = ADDON_PREFIX_B2B + "pages/checkout/checkoutConfirmationPage";
	private static final String ADD_TO_CART_POPUP_PAGE = "fragments/cart/addToCartPopup";
	private static final String B2B_SILENT_ORDER_POST_PAGE = "pages/checkout/multi/silentOrderPostPage";
	private static final String B2B_CHECKOUT_SUMMARY_PAGE = ADDON_PREFIX_B2B + "pages/checkout/multi/checkoutSummaryPage";
	private static final String B2B_CHECKOUT_DELIVERY_ADDRESS_PAGE = "pages/checkout/multi/addEditDeliveryAddressPage";

	private static final String CART_PAGE = ADDON_PREFIX_B2B + "pages/cart/cartPage";

	private SessionService sessionService;
	private CMSComponentService cmsComponentService;
	private ConfigurationService configurationService;
	private PayPalUserHelper payPalUserHelper;
	private CartService cartService;

	@Override
	public String beforeView(final HttpServletRequest request, final HttpServletResponse response, final ModelMap model,
			final String viewName) throws Exception
	{
		if (B2B_SILENT_ORDER_POST_PAGE.equals(viewName))
		{
			return Paypalb2b63addonControllerConstants.Views.Pages.MultiStepCheckout.SilentOrderPostPage;
		}
		else if (B2B_CHECKOUT_SUMMARY_PAGE.equals(viewName))
		{
			final String repeatRedirectUrl = getSessionService()
					.getAttribute((Paypalb2b63addonConstants.PAY_PAL_REPEAT_REDIRECT_URL));

			model.addAttribute("isReplenishmentAvailable", isReplenishmentAvailable());
			model.addAttribute("isPlaceOrderAvailable", isPlaceOrderAvailable());

			if (StringUtils.isNotBlank(repeatRedirectUrl))
			{
				getSessionService().removeAttribute(Paypalb2b63addonConstants.PAY_PAL_REPEAT_REDIRECT_URL);
				return "redirect:" + repeatRedirectUrl;
			}
			else
			{
				return Paypalb2b63addonControllerConstants.Views.Pages.MultiStepCheckout.CheckoutSummaryPage;
			}
		}
		else if (B2B_CHECKOUT_CONFIRMATION_PAGE.equals(viewName))
		{
			return Paypalb2b63addonControllerConstants.Views.Pages.Checkout.CheckoutConfirmationPage;
		}
		else if (ADD_TO_CART_POPUP_PAGE.equals(viewName))
		{
			final PayPalB2bECButtonComponentModel component = (PayPalB2bECButtonComponentModel) cmsComponentService
					.getSimpleCMSComponent("PayPalECMiniButtonComponent");

			model.addAttribute("PayPalB2bECButtonComponent", component);
			return Paypalb2b63addonControllerConstants.Views.Fragments.Cart.AddToCartPopup;
		}
		else if (isCheckoutPage(viewName) || isPayPalCheckoutRedirect(viewName, request))
		{
			if (StringUtils.contains(viewName, B2B_CHECKOUT_DELIVERY_ADDRESS_PAGE)
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
			final String payPalHopUrl = getSessionService().getAttribute(Paypalb2b63addonControllerConstants.PAY_PAL_HOP_URL_ATTR);
			if (StringUtils.isNotBlank(payPalHopUrl))
			{
				getSessionService().removeAttribute(Paypalb2b63addonControllerConstants.PAY_PAL_HOP_URL_ATTR);
				return "redirect:" + payPalHopUrl;
			}
		}

		if (!StringUtils.contains(viewName, Paypalb2b63addonControllerConstants.Views.Pages.Checkout.CheckoutLoginPage)
				&& !StringUtils.contains(viewName, CART_PAGE))
		{
			getSessionService().removeAttribute(Paypalb2b63addonControllerConstants.PAY_PAL_HOP_URL_ATTR);

		}
		return viewName;
	}

	private boolean isCheckoutPage(final String viewName)
	{
		boolean result;
		result = !Paypalb2b63addonControllerConstants.Views.Pages.Checkout.CheckoutLoginPage.equals(viewName)
				&& StringUtils.contains(viewName, Paypalb2b63addonControllerConstants.CHECKOUT_PAGE_VIEW_NAME_FRAGMENT);

		return result;

	}

	private boolean isPayPalCheckoutRedirect(final String viewName, final HttpServletRequest request)
	{
		return StringUtils.contains(viewName, CART_PAGE);
	}

	private boolean isReplenishmentAvailable() {
		return !(cartService.getSessionCart().getPaymentInfo() instanceof PaypalPaymentInfoModel) ||
				getSessionService().getAttribute(PaypalConstants.PAYPAL_FLOW).equals(PaypalConstants.REPLENISHMENT_FLOW);
	}

	private boolean isPlaceOrderAvailable() {
		return !(cartService.getSessionCart().getPaymentInfo() instanceof PaypalPaymentInfoModel) ||
				!getSessionService().getAttribute(PaypalConstants.PAYPAL_FLOW).equals(PaypalConstants.REPLENISHMENT_FLOW);
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

	private boolean isPayPalReplenishmentFlowRequired() {
		return cartService.getSessionCart().getPaymentInfo() instanceof PaypalPaymentInfoModel &&
				!getSessionService().getAttribute(PaypalConstants.PAYPAL_FLOW).equals(PaypalConstants.REPLENISHMENT_FLOW);
	}

	public CartService getCartService() {
		return cartService;
	}

	public void setCartService(CartService cartService) {
		this.cartService = cartService;
	}

}
