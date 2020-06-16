/**
 *
 */
package au.com.rejectshop.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.breadcrumb.ResourceBreadcrumbBuilder;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.commercefacades.product.ProductFacade;
import de.hybris.platform.commercefacades.product.ProductOption;
import de.hybris.platform.commercefacades.product.data.ImageData;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.commerceservices.url.UrlResolver;
import de.hybris.platform.servicelayer.event.EventService;
import de.hybris.platform.servicelayer.model.ModelService;
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

import au.com.rejectshop.facades.process.email.sendmail.SendAFriendMailFacade;
import au.com.rejectshop.facades.product.data.EmailProductData;
import au.com.rejectshop.facades.reminder.SendReminderFacade;
import au.com.rejectshop.storefront.forms.SendReminderForm;
import au.com.rejectshop.storefront.util.BrontoTokenManager;


/**
 * @author saisravan.k
 *
 */
//Disable sendReminder controller
@Controller
@RequestMapping(value = "/sendReminder")
public class SendReminderController
{
	@Resource(name = "simpleBreadcrumbBuilder")
	private ResourceBreadcrumbBuilder resourceBreadcrumbBuilder;
	@Resource
	private BaseStoreService baseStoreService;

	/** The event service. */
	@Resource
	private EventService eventService;
	/** The base site service. */
	@Resource
	private BaseSiteService baseSiteService;

	@Resource
	private ModelService modelService;

	@Resource
	private SendReminderFacade sendReminderFacade;

	@Resource
	private SendAFriendMailFacade sendAFriendMailFacade;


	@Resource
	private ProductFacade productFacade;

	@Resource(name = "productDataUrlResolver")
	private UrlResolver<ProductData> productDataUrlResolver;

	public static final String REDIRECT_PREFIX = "redirect:";


	private static final Logger LOG = Logger.getLogger(SendReminderController.class);

	@SuppressWarnings("boxing")
	@RequestMapping(value = "/email", method = RequestMethod.POST)
	public String getSendReminderEmail(final Model model,
			@ModelAttribute("sendReminderForm") final SendReminderForm sendReminderForm, final RedirectAttributes redirectModel,
			final HttpServletRequest request)
	{
		ProductData productData = null;
		final String brontoToken = BrontoTokenManager.getTokenForSession(request.getSession());
		try
		{
			final List<ProductOption> extraOptions = Arrays.asList(ProductOption.DESCRIPTION, ProductOption.URL,
					ProductOption.IMAGES, ProductOption.PRICE, ProductOption.BASIC);

			productData = productFacade.getProductForCodeAndOptions(sendReminderForm.getProductCode(), extraOptions);
			if (brontoToken != null && sendReminderForm.getBrontoToken() != null
					&& brontoToken.equals(sendReminderForm.getBrontoToken()))
			{
				LOG.info(sendReminderForm.getBrontoToken() + " " + " Is a valid Token");
				BrontoTokenManager.removeTokenForSession(request.getSession());

				if ( productData==null || productData.getCode()==null || productData.getCode().equalsIgnoreCase("")) {
					LOG.error(sendReminderForm.getBrontoToken() + " " + " Is not a valid Token");
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
				emailProductData.setFromName(Config.getParameter("bronto.email.fromname"));
				emailProductData.setToEmail(sendReminderForm.getEmail());
				emailProductData.setProductName(productData.getName());
				emailProductData.setProductCode(productData.getCode());
				emailProductData.setProductUrl(hostName + productData.getUrl());
				emailProductData.setProductImageUrl(hostName + imageUrl);
				emailProductData.setProductPrice(productData.getPrice().getFormattedValue().substring(1));
				emailProductData.setProductDescription(productData.getDescription());
				emailProductData.setProductName(productData.getName());
				emailProductData.setReminderTime(sendReminderForm.getTime());
				emailProductData.setReminderDate(sendReminderForm.getDayofReminder());


				sendAFriendMailFacade.sendEmailRemainder(emailProductData);
				redirectModel.addFlashAttribute("redirectionMsg", "Success");
				GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.CONF_MESSAGES_HOLDER, "sendreminder.confirmation.title");
				return REDIRECT_PREFIX + productDataUrlResolver.resolve(productData);
			}
			else
			{
				LOG.error(sendReminderForm.getBrontoToken() + " " + " Is not a valid Token");
				model.addAttribute("breadcrumbs", resourceBreadcrumbBuilder.getBreadcrumbs("text.send.email.failure"));
				model.addAttribute("redirectionMsg", "Failure");
				GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.CONF_MESSAGES_HOLDER, "sendreminder.error.title");
				return REDIRECT_PREFIX + productDataUrlResolver.resolve(productData);
			}
		}
		catch (final Exception e)
		{
			LOG.error("error in Saving Model", e);
			model.addAttribute("breadcrumbs", resourceBreadcrumbBuilder.getBreadcrumbs("text.send.email.failure"));
			redirectModel.addFlashAttribute("redirectionMsg", "Failure");
			GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.ERROR_MESSAGES_HOLDER, "sendreminder.error.title");
			return REDIRECT_PREFIX + productDataUrlResolver.resolve(productData);
		}
	}

	public void setValuesToJob(final SendReminderForm sendReminderForm)
	{
		getSendReminderFacade().setEmail(sendReminderForm.getEmail());
		getSendReminderFacade().setDayofReminder(sendReminderForm.getDayofReminder());
		getSendReminderFacade().setProductCode(sendReminderForm.getProductCode());
		getSendReminderFacade().setTime(sendReminderForm.getTime());
		getSendReminderFacade().setName(sendReminderForm.getName());
		getSendReminderFacade().setProductName(sendReminderForm.getProductName());
		getSendReminderFacade().setProductUrl(sendReminderForm.getProductUrl());
		getSendReminderFacade().setProductImageUrl(sendReminderForm.getProductImageUrl());
		getSendReminderFacade().setProductName(sendReminderForm.getProductPrice());
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
	 * @return the sendReminderFacade
	 */
	public SendReminderFacade getSendReminderFacade()
	{
		return sendReminderFacade;
	}



	/**
	 * @param sendReminderFacade
	 *           the sendReminderFacade to set
	 */
	public void setSendReminderFacade(final SendReminderFacade sendReminderFacade)
	{
		this.sendReminderFacade = sendReminderFacade;
	}
}
