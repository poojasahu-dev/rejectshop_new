package com.paypal.hybris.addon.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.constants.WebConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.acceleratorstorefrontcommons.security.GUIDCookieStrategy;
import de.hybris.platform.commercefacades.order.CheckoutFacade;
import de.hybris.platform.commercefacades.user.UserFacade;
import de.hybris.platform.commercefacades.user.data.AddressData;
import de.hybris.platform.commercefacades.user.data.CountryData;
import de.hybris.platform.commercefacades.user.data.RegionData;
import de.hybris.platform.commerceservices.customer.DuplicateUidException;
import de.hybris.platform.core.model.c2l.CountryModel;
import de.hybris.platform.core.model.c2l.RegionModel;
import de.hybris.platform.core.model.order.payment.PaymentInfoModel;
import de.hybris.platform.order.CartService;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;
import de.hybris.platform.servicelayer.i18n.CommonI18NService;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.paypal.hybris.addon.controllers.Paypal60addonControllerConstants;
import com.paypal.hybris.addon.controllers.utils.ControllerUtils;
import com.paypal.hybris.constants.PaypalConstants;
import com.paypal.hybris.data.AbstractResultData;
import com.paypal.hybris.data.GetExpressCheckoutDetailsResultData;
import com.paypal.hybris.facade.PayPalPaymentFacade;


@Controller
@RequestMapping(value = "/paypal/checkout/hop")
public class PayPalHopPaymentResponseController extends AbstractPageController
{
	@Resource(name = "payPalPaymentFacade")
	private PayPalPaymentFacade paypalFacade;

	@Resource(name = "checkoutFacade")
	private CheckoutFacade checkoutFacade;

	@Resource(name = "userFacade")
	private UserFacade userFacade;

	@Resource(name = "guidCookieStrategy")
	private GUIDCookieStrategy guidCookieStrategy;

	@Resource
	private CartService cartService;

	@Resource(name = "commonI18NService")
	private CommonI18NService commonI18NService;

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * de.hybris.platform.storefront.controllers.pages.checkout.steps.HopPaymentResponseController#doHandleHopResponse
	 * (javax.servlet.http.HttpServletRequest)
	 */
	@RequestMapping(value = "/response")
	public String doHandleHopResponse(final HttpServletRequest request, final HttpServletResponse response)
	{
		final GetExpressCheckoutDetailsResultData resultData = paypalFacade.getExpressCheckoutDetails();

		if (PaypalConstants.STATUS_SUCCESS.equalsIgnoreCase(resultData.getAck()))
		{
			//check if user go to paypal through shortcut and user is anonymous
			if (isPayPalExpressCheckoutShortcut(request) && userFacade.isAnonymousUser())
			{
				try
				{
					//create guest session
					final PaymentInfoModel paymentInfo = cartService.getSessionCart().getPaymentInfo();

					if (PaypalConstants.ANONYMOUS_USER_UID.equals(getSessionCartUserUid()))
					{
						getCustomerFacade().createGuestUserForAnonymousCheckout(resultData.getPayer(),
								getMessageSource().getMessage("text.guest.customer", null, getI18nService().getCurrentLocale()));
					}
					else if (!resultData.getPayer().equalsIgnoreCase(StringUtils.substringAfter(getSessionCartUserUid(), "|")))
					{
						getCustomerFacade().createGuestUserForAnonymousCheckout(resultData.getPayer(),
								getMessageSource().getMessage("text.guest.customer", null, getI18nService().getCurrentLocale()));
						getSessionService().setAttribute(WebConstants.ANONYMOUS_CHECKOUT_GUID,
								StringUtils.substringBefore(getSessionCartUserUid(), "|"));
					}
					guidCookieStrategy.setCookie(request, response);
					getSessionService().setAttribute(WebConstants.ANONYMOUS_CHECKOUT, Boolean.TRUE);
					cartService.getSessionCart().setPaymentInfo(paymentInfo);
					cartService.saveOrder(cartService.getSessionCart());
				}

				catch (final DuplicateUidException e)
				{
					LOG.warn("guest registration failed: " + e);
				}
			}

			if (checkoutFacade.getCheckoutCart().getDeliveryAddress() == null)
			{
				final AddressData addressData = new AddressData();
				addressData.setTitle(resultData.getAddressName());
				addressData.setShippingAddress(true);
				addressData.setFirstName(resultData.getPayerFirstName());
				addressData.setLastName(resultData.getPayerLastName());
				addressData.setLine1(resultData.getLine1());
				addressData.setLine2(resultData.getLine2());
				addressData.setPostalCode(resultData.getPostalCode());
				addressData.setTown(resultData.getTown());
				addressData.setVisibleInAddressBook(false);
				addressData.setDefaultAddress(false);

				if (StringUtils.isNotBlank(resultData.getCountryIsoCode()))
				{
					final CountryData countryData = new CountryData();
					countryData.setIsocode(resultData.getCountryIsoCode());
					addressData.setCountry(countryData);
				}

				if (StringUtils.isNotBlank(resultData.getStateOrProvince()) && StringUtils.isNotBlank(resultData.getCountryIsoCode()))
				{
					final RegionData regionData = new RegionData();
					final CountryModel countryModel = commonI18NService.getCountry(resultData.getCountryIsoCode());
					final String isocode = resultData.getCountryIsoCode().concat("-").concat(resultData.getStateOrProvince());
					try
					{
						final RegionModel regionModel = commonI18NService.getRegion(countryModel, isocode);

						regionData.setIsocode(regionModel.getIsocode());
						addressData.setRegion(regionData);
					}
					catch (final UnknownIdentifierException e)
					{
						LOG.warn("No region with the code " + isocode + " found.");
					}
				}

				userFacade.addAddress(addressData);

				checkoutFacade.setDeliveryAddress(addressData);

				// choose cheapest delivery mode by default
				checkoutFacade.setCheapestDeliveryModeForCheckout();
			}
			LOG.info("PayPal payer ID: " + resultData.getPayerId());

			return REDIRECT_PREFIX + "/checkout/multi/summary/view";
		}
		else
		{
			handleErrors(resultData);
			final List<String> errorCodes = ControllerUtils.getErrorCodeList(resultData);
			return REDIRECT_PREFIX + "/paypal/hop/error" + "/?decision=" + resultData.getAck() + "&reasonCodes="
					+ StringUtils.join(errorCodes, ',');
		}
	}

	private boolean isPayPalExpressCheckoutShortcut(final HttpServletRequest request)
	{
		return BooleanUtils
				.toBoolean(request.getParameter(Paypal60addonControllerConstants.PAY_PAL_EXPRESS_CHECKOUT_SHORTCUT_PARAM));
	}

	private void handleErrors(final AbstractResultData resultData)
	{
		final Map<String, String> errorCodeToMsgMap = ControllerUtils.getErrorsCodeToMessageMap(resultData);
		getSessionService().setAttribute(Paypal60addonControllerConstants.PAY_PAL_ERRORS_DETAILS, errorCodeToMsgMap);
		for (final String code : errorCodeToMsgMap.keySet())
		{
			LOG.error(code);
			LOG.error(errorCodeToMsgMap.get(code));
		}
	}

	private String getSessionCartUserUid()
	{
		return cartService.getSessionCart().getUser().getUid();
	}
}