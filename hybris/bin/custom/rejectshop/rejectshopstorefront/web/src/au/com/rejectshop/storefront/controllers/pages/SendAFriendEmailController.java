/**
 *
 */
package au.com.rejectshop.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.breadcrumb.ResourceBreadcrumbBuilder;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.commercefacades.product.ProductFacade;
import de.hybris.platform.commercefacades.product.ProductOption;
import de.hybris.platform.commercefacades.product.data.ImageData;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.commerceservices.url.UrlResolver;
import de.hybris.platform.servicelayer.event.EventService;
import de.hybris.platform.site.BaseSiteService;
import de.hybris.platform.store.services.BaseStoreService;
import de.hybris.platform.util.Config;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import au.com.rejectshop.core.event.SendAFriendEmailEvent;
import au.com.rejectshop.facades.process.email.sendmail.SendAFriendMailFacade;
import au.com.rejectshop.facades.product.data.EmailProductData;
import au.com.rejectshop.storefront.forms.SendAFriendForm;
import au.com.rejectshop.storefront.forms.validation.SendAFriendFormValidator;
import au.com.rejectshop.storefront.util.BrontoTokenManager;


/**
 * @author venkatapavani.t
 *
 */
//TODO disable sendeamil controller
@Controller
public class SendAFriendEmailController
{

	@Resource(name = "sendAFriendFormValidator")
	private SendAFriendFormValidator sendAFriendFormValidator;

	@Resource(name = "simpleBreadcrumbBuilder")
	private ResourceBreadcrumbBuilder resourceBreadcrumbBuilder;

	@Resource
	private BaseStoreService baseStoreService;
	/** The base site service. */
	@Resource
	private BaseSiteService baseSiteService;
	/** The event service. */
	@Resource
	private EventService eventService;
	@Resource
	private ProductFacade productFacade;
	@Resource
	private SendAFriendMailFacade sendAFriendMailFacade;
	@Resource(name = "productDataUrlResolver")
	private UrlResolver<ProductData> productDataUrlResolver;

	public static final String REDIRECT_PREFIX = "redirect:";

	private static final Logger LOG = Logger.getLogger(SendAFriendEmailController.class);

	/**
	 *
	 * @param model
	 * @param sendAFriendForm
	 * @param redirectModel
	 * @return
	 * @throws CMSItemNotFoundException
	 */
	@RequestMapping(value = "/sendemail", method = RequestMethod.POST)
	public String getSendEmail(final Model model, @ModelAttribute("sendAFriendForm") final SendAFriendForm sendAFriendForm,
			final RedirectAttributes redirectModel, final HttpServletRequest request)
	{
		ProductData productData = null;
		final String brontoToken = BrontoTokenManager.getTokenForSession(request.getSession());

		try
		{
			final List<ProductOption> extraOptions = Arrays.asList(ProductOption.DESCRIPTION, ProductOption.URL,
					ProductOption.IMAGES, ProductOption.PRICE, ProductOption.BASIC);

			productData = productFacade.getProductForCodeAndOptions(sendAFriendForm.getProductCode(), extraOptions);

			if (brontoToken != null && sendAFriendForm.getBrontoToken() != null
					&& brontoToken.equals(sendAFriendForm.getBrontoToken()))
			{
				LOG.info(sendAFriendForm.getBrontoToken() + " " + " Is a valid Token");
				BrontoTokenManager.removeTokenForSession(request.getSession());

				if ( productData==null || productData.getCode()==null || productData.getCode().equalsIgnoreCase("")) {
					model.addAttribute("breadcrumbs", resourceBreadcrumbBuilder.getBreadcrumbs("text.send.email.failure"));
					model.addAttribute("redirectionMsg", "Failure");
					GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.CONF_MESSAGES_HOLDER, "sendreminder.error.title");
					return REDIRECT_PREFIX + productDataUrlResolver.resolve(productData);
				}

				final String hostName = Config.getParameter("rejectshop.website.host");
				String imageUrl = StringUtils.EMPTY;
				for (final ImageData image : productData.getImages())
				{
					if ("product".equalsIgnoreCase(image.getFormat()))
					{
						imageUrl = image.getUrl();
						break;
					}
				}
				model.addAttribute("breadcrumbs", resourceBreadcrumbBuilder.getBreadcrumbs("text.send.email.success"));

				final EmailProductData emailProductData = new EmailProductData();
				emailProductData.setToEmail(sendAFriendForm.getRecipientEmail());
				emailProductData.setToName(sendAFriendForm.getName());
				//emailProductData.setMessage(sendAFriendForm.getMessage());
				emailProductData.setFromEmail(sendAFriendForm.getEmail());
				emailProductData.setFromName(sendAFriendForm.getYourName());
				emailProductData.setProductCode(productData.getCode());
				emailProductData.setProductUrl(hostName + productData.getUrl());
				emailProductData.setProductImageUrl(hostName + imageUrl);

				emailProductData.setProductPrice(productData.getPrice().getFormattedValue().substring(1));
				emailProductData.setProductDescription(productData.getDescription());
				emailProductData.setProductName(productData.getName());

				sendAFriendMailFacade.sendMailFriend(emailProductData);

				model.addAttribute("redirectionMsg", "Success");
				GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.CONF_MESSAGES_HOLDER, "sendemail.confirmation.title");

				return REDIRECT_PREFIX + productDataUrlResolver.resolve(productData);
			}
			else
			{
				LOG.error(sendAFriendForm.getBrontoToken() + " " + " Is not a valid Token");
				model.addAttribute("breadcrumbs", resourceBreadcrumbBuilder.getBreadcrumbs("text.send.email.failure"));
				model.addAttribute("redirectionMsg", "Failure");
				GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.CONF_MESSAGES_HOLDER, "sendreminder.error.title");
				return REDIRECT_PREFIX + productDataUrlResolver.resolve(productData);
			}
		}
		catch (final Exception e)
		{
			LOG.error("error in sending email", e);
			model.addAttribute("breadcrumbs", resourceBreadcrumbBuilder.getBreadcrumbs("text.send.email.failure"));
			model.addAttribute("redirectionMsg", "Failure");
			GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.CONF_MESSAGES_HOLDER, "sendreminder.error.title");
			return REDIRECT_PREFIX + productDataUrlResolver.resolve(productData);
		}


	}

	/**
	 *
	 * @param email
	 * @param message
	 * @param name
	 * @param RecipientEmail
	 * @param productUrl
	 * @param productName
	 * @param productCode
	 * @param productImageUrl
	 * @param productPrice
	 * @param yourName
	 */
	private void sendAFriendEmailEvent(final String email, final String message, final String name, final String RecipientEmail,
			final String productUrl, final String productName, final String productCode, final String productImageUrl,
			final String productPrice, final String yourName)
	{

		final SendAFriendEmailEvent event = new SendAFriendEmailEvent();
		event.setBaseStore(baseStoreService.getCurrentBaseStore());
		event.setSite(baseSiteService.getCurrentBaseSite());
		event.setRecipientEmail(RecipientEmail);
		event.setEmail(email);
		event.setName(name);
		//event.setMessage(message);
		event.setProductUrl(productUrl);
		event.setProductName(productName);
		event.setProductCode(productCode);
		event.setProductImageUrl(productImageUrl);
		event.setProductPrice(productPrice);
		event.setYourName(yourName);

		eventService.publishEvent(event);
	}



	/**
	 * @return the baseStoreService
	 */

	public BaseStoreService getBaseStoreService()
	{
		return baseStoreService;
	}


	/**
	 * @param baseStoreService
	 *           the baseStoreService to set
	 */

	public void setBaseStoreService(final BaseStoreService baseStoreService)
	{
		this.baseStoreService = baseStoreService;
	}


	/**
	 * @return the baseSiteService
	 */

	public BaseSiteService getBaseSiteService()
	{
		return baseSiteService;
	}


	/**
	 * @param baseSiteService
	 *           the baseSiteService to set
	 */

	public void setBaseSiteService(final BaseSiteService baseSiteService)
	{
		this.baseSiteService = baseSiteService;
	}


	/**
	 * @return the eventService
	 */

	public EventService getEventService()
	{
		return eventService;
	}


	/**
	 * @param eventService
	 *           the eventService to set
	 */

	public void setEventService(final EventService eventService)
	{
		this.eventService = eventService;
	}


	/**
	 * @return the sendAFriendFormValidator
	 */

	public SendAFriendFormValidator getSendAFriendFormValidator()
	{
		return sendAFriendFormValidator;
	}



	/**
	 * @param sendAFriendFormValidator
	 *           the sendAFriendFormValidator to set
	 */
	public void setSendAFriendFormValidator(final SendAFriendFormValidator sendAFriendFormValidator)
	{
		this.sendAFriendFormValidator = sendAFriendFormValidator;
	}

}
