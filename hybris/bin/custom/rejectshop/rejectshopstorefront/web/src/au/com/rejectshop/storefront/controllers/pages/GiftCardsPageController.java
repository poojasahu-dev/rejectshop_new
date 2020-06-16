/**
 * 
 */
package au.com.rejectshop.storefront.controllers.pages;

import de.hybris.platform.acceleratorservices.controllers.page.PageType;
import de.hybris.platform.acceleratorstorefrontcommons.breadcrumb.ResourceBreadcrumbBuilder;
import de.hybris.platform.acceleratorstorefrontcommons.constants.WebConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.cms2.model.pages.ContentPageModel;
import de.hybris.platform.servicelayer.config.ConfigurationService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import au.com.rejectshop.storefront.controllers.ControllerConstants;
import au.com.rejectshop.storefront.forms.TermsAndConditionsForm;


/**
 * @author venkatapavani.t
 * 
 */
@Controller
@Scope("tenant")
@RequestMapping(value = "/**/giftcards")
public class GiftCardsPageController extends AbstractPageController
{

	private static final String GIFT_CARDS_CMS_PAGE_LABEL = "giftCardsPage";
	private static final String GIFT_CARDS_PAGE_BREADCRUMB_ID = "breadcrumb.giftcards";
	private static final String GIFT_CARDS_TNC_CMS_PAGE_LABEL = "giftCardsTermsAndConditionsPopup";
	private static final String GIFT_VOUCHERS_TNC_CMS_PAGE_LABEL = "giftVouchersTermsAndConditionsPopup";


	private static final String GOOGLE_API_KEY_ID = "googleApiKey";
	private static final String GOOGLE_CLIENT_ID = "googleClientId";
	private static final String GOOGLE_API_VERSION = "googleApiVersion";


	@Resource(name = "simpleBreadcrumbBuilder")
	private ResourceBreadcrumbBuilder resourceBreadcrumbBuilder;
	@Resource(name = "configurationService")
	private ConfigurationService configurationService;

	@ModelAttribute("googleApiVersion")
	public String getGoogleApiVersion()
	{
		return configurationService.getConfiguration().getString(GOOGLE_API_VERSION);
	}

	@ModelAttribute("googleApiKey")
	public String getGoogleApiKey(final HttpServletRequest request)
	{
		final String googleApiKey = getHostConfigService().getProperty(GOOGLE_API_KEY_ID, request.getServerName());
		if (StringUtils.isEmpty(googleApiKey))
		{
			LOG.warn("No Google API key found for server: " + request.getServerName());
		}
		return googleApiKey;
	}

	@ModelAttribute("googleClientId")
	public String getGoogleClientId(final HttpServletRequest request)
	{
		final String googleClientId = getHostConfigService().getProperty(GOOGLE_CLIENT_ID, request.getServerName());
		if (StringUtils.isEmpty(googleClientId))
		{
			LOG.warn("No Google Client Id found for server: " + request.getServerName());
		}
		return googleClientId;
	}


	@RequestMapping(method = RequestMethod.GET)
	public String giftCards(final Model model) throws CMSItemNotFoundException
	{
		final ContentPageModel page = getContentPageForLabelOrId(GIFT_CARDS_CMS_PAGE_LABEL);
		storeCmsPageInModel(model, page);
		model.addAttribute(WebConstants.BREADCRUMBS_KEY, resourceBreadcrumbBuilder.getBreadcrumbs(GIFT_CARDS_PAGE_BREADCRUMB_ID));
		model.addAttribute("pageType", PageType.GIFTCARDPAGE.name());
		return getViewForPage(model);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/giftCardsTermsAndConditions")
	public String showGiftCardsTermsAndConditions(final Model model) throws CMSItemNotFoundException
	{
		final ContentPageModel page = getContentPageForLabelOrId(GIFT_CARDS_TNC_CMS_PAGE_LABEL);
		storeCmsPageInModel(model, page);
		model.addAttribute("allowAccept", Boolean.TRUE);
		model.addAttribute(new TermsAndConditionsForm());
		return getViewForPage(model);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/giftVouchersTermsAndConditions")
	public String showGiftVouchersTermsAndConditions(final Model model) throws CMSItemNotFoundException
	{
		final ContentPageModel page = getContentPageForLabelOrId(GIFT_VOUCHERS_TNC_CMS_PAGE_LABEL);
		storeCmsPageInModel(model, page);
		model.addAttribute("allowAccept", Boolean.FALSE);
		return getViewForPage(model);
	}

	/**
	 * @param model
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/acceptGiftCardsTermsAndConditions")
	public String acceptGiftCardsTermsAndConditions(final Model model, @RequestParam(value = "termsCheck") final String termsCheck)
			throws CMSItemNotFoundException
	{
		if (Boolean.TRUE.toString().equalsIgnoreCase(termsCheck))
		{
			return ControllerConstants.Views.Pages.GiftCards.CheckGiftCardBalancePage;
		}
		return null;
	}


}
