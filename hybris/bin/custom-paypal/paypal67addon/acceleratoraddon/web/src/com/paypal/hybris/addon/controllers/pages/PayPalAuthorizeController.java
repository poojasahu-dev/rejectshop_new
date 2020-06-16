package com.paypal.hybris.addon.controllers.pages;

import com.paypal.hybris.addon.controllers.Paypal67addonControllerConstants;
import com.paypal.hybris.addon.controllers.utils.ControllerUtils;
import com.paypal.hybris.constants.PaypalConstants;
import com.paypal.hybris.data.AbstractResultData;
import com.paypal.hybris.data.GetExpressCheckoutDetailsResultData;
import com.paypal.hybris.facade.PayPalPaymentFacade;
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
import de.hybris.platform.core.model.order.delivery.DeliveryModeModel;
import de.hybris.platform.core.model.order.payment.PaymentInfoModel;
import de.hybris.platform.order.CartService;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;
import de.hybris.platform.servicelayer.i18n.CommonI18NService;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/paypal/checkout/payment/authorize")
public class PayPalAuthorizeController extends AbstractPageController
{

	private static final Logger LOG = Logger.getLogger(PayPalAuthorizeController.class);

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
	public Map<String, String> doHandleHopResponse(final HttpServletRequest request, final HttpServletResponse response)
	{
		final GetExpressCheckoutDetailsResultData resultData = paypalFacade.getExpressCheckoutDetails();

		LOG.info("request paymentToken: " + request.getParameter("paymentToken") + ", resultData.getPayerId: " + resultData.getPayerId());
		LOG.info("address: " + resultData.getDeliveryAddress().getFormattedAddress());

		Map redirectUrl =  new HashMap();

		if (PaypalConstants.STATUS_SUCCESS.equalsIgnoreCase(resultData.getAck()))
		{
			//check if user go to paypal through shortcut and user is anonymous
			if (PaypalConstants.ANONYMOUS_USER_UID.equals(getSessionCartUserUid()))
			{
				try
				{
					//create guest session
					final PaymentInfoModel paymentInfo = cartService.getSessionCart().getPaymentInfo();
					final DeliveryModeModel deliveryMode = cartService.getSessionCart().getDeliveryMode();
					getCustomerFacade().createGuestUserForAnonymousCheckout(resultData.getPayer(),
                            getMessageSource().getMessage("text.guest.customer", null, getI18nService().getCurrentLocale()));
					guidCookieStrategy.setCookie(request, response);
					getSessionService().setAttribute(WebConstants.ANONYMOUS_CHECKOUT, Boolean.TRUE);
					cartService.getSessionCart().setPaymentInfo(paymentInfo);
					cartService.getSessionCart().setDeliveryMode(deliveryMode);
					cartService.saveOrder(cartService.getSessionCart());
				}
				catch (final DuplicateUidException e) {
					LOG.fatal("guest registration failed: " + e, e);
				}
			}

				final AddressData addressData = new AddressData();
				addressData.setShippingAddress(true);
				addressData.setFirstName(resultData.getPayerFirstName());
				addressData.setLastName(resultData.getPayerLastName());
				addressData.setVisibleInAddressBook(false);
				addressData.setDefaultAddress(false);
				addressData.setTitle(resultData.getDeliveryAddress().getTitle());
				addressData.setLine1(resultData.getDeliveryAddress().getLine1());
				addressData.setLine2(resultData.getDeliveryAddress().getLine2());
				addressData.setPostalCode(resultData.getDeliveryAddress().getPostalCode());
				addressData.setTown(resultData.getDeliveryAddress().getTown());

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

				if (isSimpleFlow() &&  cartService.getSessionCart().getDeliveryMode() == null){
					checkoutFacade.setCheapestDeliveryModeForCheckout();
					LOG.info("Set default cheapest delivery mode for PayPal simple flow");
				}
				if (cartService.getSessionCart().getDeliveryMode() == null){
					checkoutFacade.setDeliveryAddress(null);
				}

			LOG.info("PayPal payer ID: " + resultData.getPayerId());

			redirectUrl.put("redirectUrl", "checkout/multi/summary/view");
			return redirectUrl;
		}
		else
		{
			handleErrors(resultData);
			final List<String> errorCodes = ControllerUtils.getErrorCodeList(resultData);
			redirectUrl.put("redirectUrl", "paypal/hop/error" + "/?decision=" + resultData.getAck() + "&reasonCodes="
					+ StringUtils.join(errorCodes, ','));
			return redirectUrl;
		}
	}

	private boolean isSimpleFlow() {
		return getSessionService().getAttribute(PaypalConstants.PAYPAL_FLOW).equals(PaypalConstants.SIMPLE_FLOW);
	}

	private void handleErrors(final AbstractResultData resultData) {
		final Map<String, String> errorCodeToMsgMap = ControllerUtils.getErrorsCodeToMessageMap(resultData);
		getSessionService().setAttribute(Paypal67addonControllerConstants.PAY_PAL_ERRORS_DETAILS, errorCodeToMsgMap);
		for (final String code : errorCodeToMsgMap.keySet()) {
			LOG.error("Error found, code: " + code + ", short/long message: " + errorCodeToMsgMap.get(code));
		}
	}

	private String getSessionCartUserUid()
	{
		return cartService.getSessionCart().getUser().getUid();
	}
}