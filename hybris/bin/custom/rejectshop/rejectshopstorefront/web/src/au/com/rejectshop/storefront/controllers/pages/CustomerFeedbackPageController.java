/**
 *
 */
package au.com.rejectshop.storefront.controllers.pages;

import de.hybris.platform.acceleratorservices.config.SiteConfigService;
import de.hybris.platform.acceleratorservices.controllers.page.PageType;
import de.hybris.platform.acceleratorstorefrontcommons.breadcrumb.impl.ContentPageBreadcrumbBuilder;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractSearchPageController;
import de.hybris.platform.acceleratorstorefrontcommons.util.XSSFilterUtil;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.cms2.model.pages.ContentPageModel;
import de.hybris.platform.commercefacades.storefinder.StoreFinderFacade;
import de.hybris.platform.commercefacades.storelocator.data.PointOfServiceData;
import de.hybris.platform.commerceservices.storefinder.data.StoreFinderSearchPageData;
import de.hybris.platform.servicelayer.i18n.L10NService;
import de.hybris.platform.util.Config;
import de.hybris.platform.util.mail.MailUtils;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import au.com.rejectshop.core.constants.RejectshopCoreConstants;
import au.com.rejectshop.storefront.constants.WebConstants;
import au.com.rejectshop.storefront.forms.CustomerFeedbackForm;
import au.com.rejectshop.storefront.forms.validation.CustomerFeedbackFormValidator;


/**
 * @author venkatapavani.t
 * 
 */
@Controller
@Scope("tenant")
@RequestMapping(value = "/**/customerfeedback")
public class CustomerFeedbackPageController extends AbstractSearchPageController
{
	private static final String CUSTOMER_FEEDBACK_PAGE_LABEL = "/contactus/customerfeedback";
	private static final String CUSTOMER_FEEDBACK_THANKYOU_PAGE_LABEL = "/contactus/customerfeedback/thankyou";

	private static final String CUSTOMER_FEEDBACK_EMAIL_BODY_KEY = "mail.customer.feedback.body";
	private static final String CUSTOMER_FEEDBACK_EMAIL_SUBJECT_KEY = "mail.customer.feedback.subject";
	private static final String DEFAULT_LOCATION = "australia";
	public static final int MAX_STORE_LIMIT = 10000;

	protected static final Logger LOG = Logger.getLogger(CustomerFeedbackPageController.class);

	private static Collection<String> feedbackTypes = null;
	private static Collection<String> feedbackSubTypes = null;
	private static Collection<String> titles = null;

	public static final String  STAFF_COURTESY="Store Customer Service";
	public static final String  STORE_EXPERIENCE="Store Experience";



	@Resource(name = "storeFinderFacade")
	private StoreFinderFacade storeFinderFacade;

	@Resource(name = "contentPageBreadcrumbBuilder")
	private ContentPageBreadcrumbBuilder contentPageBreadcrumbBuilder;

	@Resource(name = "customerFeedbackFormValidator")
	private CustomerFeedbackFormValidator customerFeedbackFormValidator;

	@Resource(name = "l10nService")
	private L10NService l10nService;

	@Resource(name = "siteConfigService")
	private SiteConfigService siteConfigService;

	/**
	 * @return the customerFeedbackFormValidator
	 */
	public CustomerFeedbackFormValidator getCustomerFeedbackFormValidator()
	{
		return customerFeedbackFormValidator;
	}

	/**
	 * @param customerFeedbackFormValidator
	 *           the customerFeedbackFormValidator to set
	 */
	public void setCustomerFeedbackFormValidator(final CustomerFeedbackFormValidator customerFeedbackFormValidator)
	{
		this.customerFeedbackFormValidator = customerFeedbackFormValidator;
	}

	@ModelAttribute(value = "feedbackTypes")
	public Collection<String> getFeedbackTypes()
	{
		//FIXME this shouldnt be hardcoded like this
		if (feedbackTypes == null)
		{
			feedbackTypes = new ArrayList<String>();
			feedbackTypes.add("Bulk Orders");
			feedbackTypes.add("Employment");
			feedbackTypes.add("Product Availability");
			feedbackTypes.add("Product Quality");
			feedbackTypes.add(STAFF_COURTESY);
			feedbackTypes.add(STORE_EXPERIENCE);
			feedbackTypes.add("Savvy Shopper subscription");
			feedbackTypes.add("Website / Social Media");
			feedbackTypes.add("Other");
		}
		return feedbackTypes;
	}

	@ModelAttribute(value = "feedbackSubTypes")
	public Collection<String> getFeedbackSubTypes()
	{
		//FIXME this shouldnt be hardcoded like this
		if (feedbackSubTypes == null)
		{
			feedbackSubTypes = new ArrayList<String>();
			feedbackSubTypes.add("Compliment");
			feedbackSubTypes.add("Complaint");

		}
		return feedbackSubTypes;
	}

	@ModelAttribute(value = "storesAvailable")
	public Collection<String> getStoresAvailable()
	{
		final List<String> storesAvailable = (List<String>) getStoresAvailableForLocation(DEFAULT_LOCATION);
		Collections.sort(storesAvailable);

		return storesAvailable;
	}

	@ModelAttribute(value = "titles")
	public Collection<String> getTitles()
	{

		//FIXME This shouldn't be hardcoded like this.
		if (titles == null)
		{
			titles = new ArrayList<String>();
			titles.add("Mr");
			titles.add("Mrs");
			titles.add("Miss");
			titles.add("Ms");
		}
		return titles;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String addCustomerFeedbackForm(final Model model) throws CMSItemNotFoundException
	{
		final ContentPageModel page = getContentPageForLabelOrId(CUSTOMER_FEEDBACK_PAGE_LABEL);
		storeCmsPageInModel(model, page);
		model.addAttribute("customerFeedbackForm", new CustomerFeedbackForm());
		model.addAttribute(WebConstants.BREADCRUMBS_KEY, contentPageBreadcrumbBuilder.getBreadcrumbs(page));
		model.addAttribute(WebConstants.PAGE_LABEL, page.getLabel());
		model.addAttribute("pageType",PageType.CUSTOMERFEEDBACKVIEW.name());
		return getViewForPage(model);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/addcustomerfeedback")
	public String processCustomerFeedback(final Model model, @ModelAttribute final CustomerFeedbackForm customerFeedbackForm,
			final BindingResult bindingResult) throws CMSItemNotFoundException
	{
		ContentPageModel page = null;
		getCustomerFeedbackFormValidator().validate(customerFeedbackForm, bindingResult);
		if (bindingResult.hasErrors())
		{
			page = getContentPageForLabelOrId(CUSTOMER_FEEDBACK_PAGE_LABEL);
			storeCmsPageInModel(model, page);
			model.addAttribute("customerFeedbackForm", customerFeedbackForm);
			model.addAttribute(WebConstants.BREADCRUMBS_KEY, contentPageBreadcrumbBuilder.getBreadcrumbs(page));
			model.addAttribute(WebConstants.PAGE_LABEL, page.getLabel());
			model.addAttribute("pageType",PageType.CUSTOMERFEEDBACKVIEW.name());
			return getViewForPage(model);
		}
		// Send Customer feedback email
		try
		{
			sendCustomerFeedbackEmail(customerFeedbackForm);
		}
		catch (final EmailException e)
		{
			if (LOG.isDebugEnabled())
			{
				LOG.debug("Error in sending customer feedback email : " + e.getMessage(), e);
			}
		}
		return REDIRECT_PREFIX + CUSTOMER_FEEDBACK_THANKYOU_PAGE_LABEL;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/thankyou")
	public String getThankyouPage(final Model model) throws CMSItemNotFoundException
	{
		final ContentPageModel page = getContentPageForLabelOrId(CUSTOMER_FEEDBACK_THANKYOU_PAGE_LABEL);
		storeCmsPageInModel(model, page);
		model.addAttribute(WebConstants.BREADCRUMBS_KEY, contentPageBreadcrumbBuilder.getBreadcrumbs(page));
		model.addAttribute(WebConstants.PAGE_LABEL, page.getLabel());
		model.addAttribute(WebConstants.BREADCRUMBS_ADDITIONAL_LINK_KEY, "breadcrumb.customerfeedback.thankyou");
		model.addAttribute("pageType", PageType.CUSTOMERFEEDBACKSUBMIT.name());
		return getViewForPage(model);
	}

	protected Collection<String> getStoresAvailableForLocation(final String locationQuery)
	{
		final Collection<String> storesNames = new ArrayList<String>();
		final String sanitizedSearchQuery = XSSFilterUtil.filter(locationQuery);
		if (StringUtils.isNotBlank(sanitizedSearchQuery))
		{
			final StoreFinderSearchPageData<PointOfServiceData> searchResult = storeFinderFacade.locationSearch(
					sanitizedSearchQuery, createPageableData(0, MAX_PAGE_LIMIT, null, ShowMode.All));


			if (searchResult != null && searchResult.getResults() != null)
			{
				for (final PointOfServiceData pointOfService : searchResult.getResults())
				{
					storesNames.add(pointOfService.getDescription());
				}
			}
		}
		return storesNames;
	}

	protected void sendCustomerFeedbackEmail(final CustomerFeedbackForm form) throws EmailException
	{
		final String sendTo = Config.getString("customerfeedback.email.sendto", StringUtils.EMPTY);
		final String host = Config.getString(RejectshopCoreConstants.SMTP_HOST, StringUtils.EMPTY);
		final int port = Config.getInt(RejectshopCoreConstants.SMTP_PORT, 25);
		final String user = Config.getString(RejectshopCoreConstants.SMTP_USER, StringUtils.EMPTY);
		final String password = Config.getString(RejectshopCoreConstants.SMTP_PASSWORD, StringUtils.EMPTY);
		//String sendFrom = Config.getString(RejectshopCoreConstants.SMTP_FROM, StringUtils.EMPTY);


		final HtmlEmail htmlEmail = (HtmlEmail) MailUtils.getPreConfiguredEmail();

		if (form != null)
		{
			/*
			 * final String subject = l10nService.getLocalizedString(CUSTOMER_FEEDBACK_EMAIL_SUBJECT_KEY, new Object[] {
			 * form.getFeedbackType() });
			 */
			final String[] fullNameArray =
			{ form.getTitleCode(), " ", form.getFirstName(), " ", form.getSurName() };
			final String fullName = StringUtils.join(fullNameArray).trim();
			final List replyToList = Collections.singletonList(createInternetAddress(form.getEmailAddress(), fullName));
			/*
			 * final String body = l10nService.getLocalizedString( CUSTOMER_FEEDBACK_EMAIL_BODY_KEY, new Object[] {
			 * fullName, form.getEmailAddress(), form.getPhoneNumber(), form.getStoreVisited(), form.getDateVisited(),
			 * form.getFeedbackType(), form.getMessage() });
			 */
			final String subject = form.getFeedbackType();
			final String toEmail = form.getEmailAddress();
			final String phoneNo = form.getPhoneNumber();
			final String storeVisited = form.getStoreVisited();
			final String dateVisited = form.getDayofReminder();
			final String feedBack = form.getFeedbackType();
			final String feedbackType=form.getFeedbackSubType();
			final String msg = form.getMessage();

			final StringBuilder msgBuilder = new StringBuilder();
			msgBuilder.append("<html>");
			msgBuilder.append("<p>").append("Name           : ").append(fullName).append("<br />");
			msgBuilder.append("Email                        : ").append(toEmail).append("<br />");
			msgBuilder.append("Phone No                     : ").append(phoneNo).append("<br />");
			msgBuilder.append("Store Visited                 : ").append(storeVisited).append("<br />");
			msgBuilder.append("Date Visited                  : ").append(dateVisited).append("<br />");
			msgBuilder.append("Feedback About                     : ").append(feedBack).append("<br />");
			if (!feedbackType.equalsIgnoreCase("")){
				msgBuilder.append("Feedback Type                 : ").append(feedbackType).append("<br />");
			}
			msgBuilder.append("Message                      : ").append(msg).append("<br />");
			msgBuilder.append("</p></html>");

			htmlEmail.setHostName(host);
			htmlEmail.setSmtpPort(port);
			htmlEmail.setAuthentication(user, password);
			//htmlEmail.addTo(getCustomerFeedbackMailTo());
			htmlEmail.addTo(sendTo);
			htmlEmail.setSubject(subject);
			htmlEmail.setHtmlMsg(msgBuilder.toString());
			htmlEmail.setFrom(form.getEmailAddress(), fullName);
			htmlEmail.setReplyTo(replyToList);
			htmlEmail.send();
		}
	}

	protected String getCustomerFeedbackMailTo()
	{
		return siteConfigService.getString("customerfeedback.email.mailto", WebConstants.CUSTOMER_FEEDBACK_MAIL_TO);
	}

	/*
	 * Create Internet Address using given email address and display name
	 */
	protected InternetAddress createInternetAddress(final String emailAddress, final String displayName) throws EmailException
	{
		try
		{
			final InternetAddress address = new InternetAddress(emailAddress);
			address.setPersonal(StringUtils.isNotBlank(displayName) ? displayName : emailAddress);
			address.validate();
			return address;
		}
		catch (final AddressException e)
		{
			throw new EmailException(e);
		}
		catch (final UnsupportedEncodingException e)
		{
			throw new EmailException(e);
		}
	}

	@ModelAttribute(value = "storesAvailableForCustomerFeedback")
	public Collection<String> getStoresAvailableForCustomerFeedback()
	{
		final List<String> storesAvailable = (List<String>) getStoresAvailableForLocationFeedbackForm(DEFAULT_LOCATION);
		Collections.sort(storesAvailable);

		return storesAvailable;
	}

	protected Collection<String> getStoresAvailableForLocationFeedbackForm(final String locationQuery)
	{

		final Collection<String> storesNamesforCustomerFeedback = new ArrayList<String>();
		final String sanitizedSearchQuery = XSSFilterUtil.filter(locationQuery);
		if (StringUtils.isNotBlank(sanitizedSearchQuery))
		{

			final StoreFinderSearchPageData<PointOfServiceData> posTotal = storeFinderFacade
					.getAllPointOfServices(createPageableData(0, MAX_STORE_LIMIT, null, null));


			if (posTotal != null && posTotal.getResults() != null)
			{
				for (final PointOfServiceData pointOfService : posTotal.getResults())
				{
					storesNamesforCustomerFeedback.add(pointOfService.getDisplayName());
				}
			}

		}
		return storesNamesforCustomerFeedback;
	}
}
