package com.paypal.hybris.addon.controllers.pages;

import com.paypal.hybris.addon.controllers.Paypal60addonControllerConstants;
import com.paypal.hybris.addon.controllers.utils.ControllerUtils;
import com.paypal.hybris.addon.controllers.utils.PayPalUserHelper;
import com.paypal.hybris.addon.model.TokenResponse;
import com.paypal.hybris.constants.PaypalConstants;
import com.paypal.hybris.data.AbstractResultData;
import com.paypal.hybris.data.SetExpressCheckoutRequestData;
import com.paypal.hybris.data.SetExpressCheckoutResultData;
import com.paypal.hybris.facade.PayPalPaymentFacade;
import de.hybris.platform.acceleratorservices.uiexperience.UiExperienceService;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractCheckoutController;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.commercefacades.order.CheckoutFacade;
import de.hybris.platform.commercefacades.user.UserFacade;
import de.hybris.platform.commercefacades.user.data.AddressData;
import de.hybris.platform.commerceservices.enums.UiExperienceLevel;
import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.session.SessionService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.CookieGenerator;

import javax.annotation.Resource;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@RestController
public class PayPalJSController extends AbstractCheckoutController {

    @Resource(name = "payPalPaymentFacade")
    private PayPalPaymentFacade paypalFacade;
    @Resource
    private UiExperienceService uiExperienceService;
    @Resource(name = "userFacade")
    private UserFacade userFacade;
    @Resource
    private ConfigurationService configurationService;
    @Resource(name = "checkoutFacade")
    private CheckoutFacade checkoutFacade;
    @Resource(name = "guidCookieGenerator")
    private CookieGenerator cookieGenerator;
    @Resource(name = "payPalUserHelper")
    private PayPalUserHelper payPalUserHelper;
    @Resource(name = "sessionService")
    private SessionService sessionService;

    private static final Logger LOG = Logger.getLogger(PayPalJSController.class.getName());

    public static final String PAYPAL_SHIPPING_ERROR_PATTERN = "107\\d{2}";

    @RequestMapping(value = "/paypal/ec/payment")
    public TokenResponse paymentEC(final Model model) {
        getSessionService().setAttribute(PaypalConstants.IS_PAYPAL_CREDIT, Boolean.FALSE);
        getSessionService().setAttribute(PaypalConstants.PAYPAL_FLOW, PaypalConstants.SIMPLE_FLOW);

        if (redirectToLoginPage(model)) {
            TokenResponse tokenResponse = new TokenResponse();
            tokenResponse.setRedirectUrl("/login/checkout");

            return tokenResponse;
        }

        removeDeliveryAddressFromCart();

        if (!configurationService.getConfiguration().getBoolean(PaypalConstants.PAYPAL_GUEST_REDIRECT)) {
            return prepareExpressCheckoutForJS(model, "/paypal/checkout/hop/response/?shortcut=true", "/cart",
                    PaypalConstants.CREDIT_CARD, getSolutionType(), true);
        } else {
            return prepareExpressCheckoutForJS(model, "/paypal/checkout/hop/response/?shortcut=false", "/cart",
                    PaypalConstants.CREDIT_CARD, getSolutionType(), true);
        }
    }

    public TokenResponse prepareExpressCheckoutForJS(final Model model, final String returnUrl, final String cancelUrl,
                                                     final String fundingSource, final String solutionType, final boolean isInContextCheckoutAvailable) {

        if (checkoutFacade.getCheckoutCart() == null || CollectionUtils.isEmpty(checkoutFacade.getCheckoutCart().getEntries())) {
            LOG.info("checkoutFacade: " + checkoutFacade);
            LOG.error("Checkout Cart: " + checkoutFacade.getCheckoutCart());
            LOG.error("Checkout Cart Entries: " + checkoutFacade.getCheckoutCart().getEntries());
            return null;
        }
        final Configuration configuration = configurationService.getConfiguration();
        final Locale userLocale = JaloSession.getCurrentSession().getSessionContext().getLocale();
        final SetExpressCheckoutRequestData requestData = new SetExpressCheckoutRequestData();
        requestData.setPaymentAction(configuration.getString(PaypalConstants.PAYMENT_ACTION));

        final UiExperienceLevel uiExperienceLevel = uiExperienceService.getUiExperienceLevel();
        requestData.setLocale(userLocale);
        requestData.setUiExperienceLevel(uiExperienceLevel);
        if (PaypalConstants.BML.equals(fundingSource) && !easyPaymentsSelected()) {
            requestData.setFundingSource(fundingSource);
        }
        if (easyPaymentsSelected()) {
            requestData.setFundingSource(PaypalConstants.FINANCE);
        }
        requestData.setSolutionType(solutionType);
        requestData.setCancelUrl(paypalFacade.getFullResponseUrl(cancelUrl, true));
        requestData.setReturnUrl(paypalFacade.getFullResponseUrl(returnUrl, true));
        requestData.setSessionCart(checkoutFacade.getCheckoutCart());

        final SetExpressCheckoutResultData resultData = paypalFacade.preparePaypalPayment(requestData);

        TokenResponse tokenResponse = new TokenResponse();

        if (!PaypalConstants.STATUS_SUCCESS.equalsIgnoreCase(resultData.getAck())) {
            tokenResponse.setResponseStatus("error");
            handleErrors(resultData);
            final List<String> errorCodes = ControllerUtils.getErrorCodeList(resultData);

            if (hasShippingError(errorCodes)) {
                String payPalErrorMessage = getPayPalErrorMessage();
                GlobalMessages.addMessage(model, "accErrorMsgs", "paypal.general.error.shippingAddress", new String[]{payPalErrorMessage});
                getSessionService().getCurrentSession().setAttribute("paypal.general.error.shippingAddress",
                        model.asMap().get("accErrorMsgs"));
                tokenResponse.setRedirectUrl("checkout/multi/delivery-address/add");

                return tokenResponse;
            }

            tokenResponse.setRedirectUrl("paypal/hop/error" + "/?decision=" + resultData.getAck() + "&reasonCodes="
                    + StringUtils.join(errorCodes, ','));

            return tokenResponse;

        }
        tokenResponse.setResponseStatus("success");
        tokenResponse.setToken(resultData.getToken());

        return tokenResponse;

    }

    /**
     * Calculates is user should be redirected to login page. He will see login page in case paypal guest redirect option
     * is set to false and he isn't hard login to site or is anonymous. Otherwise user will go to login page only if he
     * has account and is not hard login.
     *
     * @param model model with parameter
     * @return true if redirect is needed, false otherwise
     */
    private boolean redirectToLoginPage(final Model model) {
        boolean redirectToLoginPage;
        final boolean isGuestUserRedirect = configurationService.getConfiguration().getBoolean(PaypalConstants.PAYPAL_GUEST_REDIRECT);
        if (!isGuestUserRedirect) {
            redirectToLoginPage = !userFacade.isAnonymousUser() && !payPalUserHelper.isHardLogin(model);
        } else {
            redirectToLoginPage = !payPalUserHelper.isHardLogin(model);
        }

        return redirectToLoginPage;
    }

    private boolean easyPaymentsSelected() {
        return false;
    }

    private void removeDeliveryAddressFromCart() {
        final AddressData previousSelectedAddress = getCheckoutFacade().getCheckoutCart().getDeliveryAddress();
        if (previousSelectedAddress != null && !previousSelectedAddress.isVisibleInAddressBook()) { // temporary address should be removed
            getUserFacade().removeAddress(previousSelectedAddress);
        }
        getCheckoutFacade().removeDeliveryAddress();
    }

    private String getSolutionType() {
        return configurationService.getConfiguration().getString(PaypalConstants.SOLUTION_TYPE);
    }

    protected SessionService getSessionService() {
        return sessionService;
    }

    protected UserFacade getUserFacade() {
        return userFacade;
    }

    private void handleErrors(final AbstractResultData resultData) {
        final Map<String, String> errorCodeToMsgMap = ControllerUtils.getErrorsCodeToMessageMap(resultData);
        getSessionService().setAttribute(Paypal60addonControllerConstants.PAY_PAL_ERRORS_DETAILS, errorCodeToMsgMap);
        for (final String code : errorCodeToMsgMap.keySet()) {
            LOG.error(code);
            LOG.error(errorCodeToMsgMap.get(code));
        }
    }


    private boolean hasShippingError(final List<String> errorCodes) {
        for (final String errCode : errorCodes) {
            if (errCode.matches(PAYPAL_SHIPPING_ERROR_PATTERN)) {
                return true;
            }
        }

        return false;
    }

    private String getPayPalErrorMessage() {
        Map<String, String> payPalErrors = (Map<String, String>) getSessionService().getAttribute(Paypal60addonControllerConstants.PAY_PAL_ERRORS_DETAILS);
        return StringUtils.join(payPalErrors.values(), ", ");
    }

}
