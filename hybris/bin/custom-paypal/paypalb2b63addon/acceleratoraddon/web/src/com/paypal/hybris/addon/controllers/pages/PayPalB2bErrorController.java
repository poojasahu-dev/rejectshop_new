package com.paypal.hybris.addon.controllers.pages;

import com.paypal.hybris.addon.controllers.Paypalb2b63addonControllerConstants;
import de.hybris.platform.acceleratorstorefrontcommons.constants.WebConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.checkout.steps.AbstractCheckoutStepController;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.commerceservices.order.CommerceCartModificationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;

@Controller
public class PayPalB2bErrorController extends AbstractCheckoutStepController {

    @RequestMapping(value = "/paypal/hop/error", method = RequestMethod.GET)
    public String doPayPalPageError(@RequestParam(required = true) final String decision,
                                    @RequestParam(required = true) final String[] reasonCodes, final Model model,
                                    final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
    {
        final Map<String, String> errorsDetails = getSessionService()
                .getAttribute(Paypalb2b63addonControllerConstants.PAY_PAL_ERRORS_DETAILS);

        final String redirectUrl = REDIRECT_URL_CART;
        model.addAttribute("decision", decision);
        model.addAttribute("reasonCodes", reasonCodes);
        model.addAttribute("errorsDetails", errorsDetails);
        model.addAttribute("redirectUrl", redirectUrl.replace(REDIRECT_PREFIX, ""));
        model.addAttribute(WebConstants.BREADCRUMBS_KEY,
                getResourceBreadcrumbBuilder().getBreadcrumbs("checkout.multi.hostedOrderPageError.breadcrumb"));
        storeCmsPageInModel(model, getContentPageForLabelOrId(MULTI_CHECKOUT_SUMMARY_CMS_PAGE_LABEL));
        setUpMetaDataForContentPage(model, getContentPageForLabelOrId(MULTI_CHECKOUT_SUMMARY_CMS_PAGE_LABEL));

        GlobalMessages.addErrorMessage(model, "paypal.general.error.header");

        return Paypalb2b63addonControllerConstants.Views.Pages.MultiStepCheckout.PayPalHostedOrderPageErrorPage;
    }

    @RequestMapping(value = "/paypal/replenishment/error", method = RequestMethod.GET)
    public String doReplenishmentError(final RedirectAttributes redirectAttributes)
    {
        GlobalMessages.addFlashMessage(redirectAttributes, GlobalMessages.INFO_MESSAGES_HOLDER,
                "paypal.replenishment.error.checkForReplenishmen");
        return REDIRECT_URL_ADD_PAYMENT_METHOD;}

    @Override
    public String enterStep(Model model, RedirectAttributes redirectAttributes) throws CMSItemNotFoundException, CommerceCartModificationException {
        return null;
    }

    @Override
    public String back(RedirectAttributes redirectAttributes) {
        return null;
    }

    @Override
    public String next(RedirectAttributes redirectAttributes) {
        return null;
    }
}
