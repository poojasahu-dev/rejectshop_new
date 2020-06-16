/**
 *
 */
package au.com.rejectshop.facades.cronjob;

import de.hybris.platform.catalog.CatalogVersionService;
import de.hybris.platform.commercefacades.product.ProductFacade;
import de.hybris.platform.commercefacades.product.ProductOption;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.cronjob.model.CronJobModel;
import de.hybris.platform.product.ProductService;
import de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable;
import de.hybris.platform.servicelayer.cronjob.PerformResult;
import de.hybris.platform.servicelayer.event.EventService;
import de.hybris.platform.servicelayer.session.SessionService;
import de.hybris.platform.site.BaseSiteService;
import de.hybris.platform.store.services.BaseStoreService;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import au.com.rejectshop.core.event.SendReminderEmailEvent;
import au.com.rejectshop.core.model.SendEmailReminderModel;
import au.com.rejectshop.facades.reminder.SendReminderFacade;


/**
 * @author saisravan.k
 * 
 */
public class SendReminderEmailJobPerformable extends AbstractJobPerformable<CronJobModel>
{

	@Resource
	private BaseStoreService baseStoreService;

	@Resource
	private BaseSiteService baseSiteService;

	@Resource
	private EventService eventService;

	@Resource
	private SendReminderFacade sendReminderFacade;

	@Resource
	private ProductFacade productFacade;

	@Resource
	private ProductService productService;

	@Resource
	private SessionService sessionService;

	@Resource
	private CatalogVersionService catalogVersionService;

	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger(SendReminderEmailJobPerformable.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable#perform(de.hybris.platform.cronjob.model.CronJobModel
	 * )
	 */
	@Override
	public PerformResult perform(final CronJobModel cronJob)
	{
		try
		{
			sendDifferentEmails();
			return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
		}
		catch (final Exception exception)
		{

			LOG.error(exception.getMessage(), exception);
			return new PerformResult(CronJobResult.FAILURE, CronJobStatus.ABORTED);

		}

	}

	public void sendReminderEmail(final String email, final String name, final String productUrl, final String productName,
			final String productCode, final String productImageUrl, final String productPrice)
	{

		final SendReminderEmailEvent event = new SendReminderEmailEvent();
		event.setBaseStore(baseStoreService.getBaseStoreForUid("rejectshop"));
		event.setSite(baseSiteService.getBaseSiteForUID("rejectshop"));
		event.setEmail(email);
		event.setName(name);
		event.setDayofReminder(getSendReminderFacade().getDayofReminder());
		event.setTime(getSendReminderFacade().getTime());
		event.setProductUrl(productUrl);
		event.setProductName(productName);
		event.setProductCode(productCode);
		event.setProductImageUrl(productImageUrl);
		event.setProductPrice(productPrice);
		eventService.publishEvent(event);
	}

	public List<SendEmailReminderModel> reminderResults()
	{
		return getSendReminderFacade().findTheListByDateandTime();
	}

	@SuppressWarnings("deprecation")
	public void sendDifferentEmails()
	{
		/* catalogVersion.get */

		final List<SendEmailReminderModel> pkModelValues = reminderResults();
		for (final SendEmailReminderModel pkModelValue : pkModelValues)
		{
			final String email = pkModelValue.getReminderEmail();
			final String productCode = pkModelValue.getProductCode();
			final String productUrl = pkModelValue.getProductUrl();
			final String productImageUrl = pkModelValue.getProductImageUrl();
			final String productPrice = pkModelValue.getProductPrice();
			final ProductModel productModel = getSendReminderFacade().findProductsByCode(productCode);
			/* final ProductModel productModel = productService.getProductForCode(productCode); */
			final List<ProductOption> extraOptions = Arrays.asList(ProductOption.BASIC, ProductOption.URL, ProductOption.KEYWORDS);
			final ProductData productData = productFacade.getProductForOptions(productModel, extraOptions);
			/* final String productUrl = productData.getUrl(); */
			final String productName = productData.getName();
			if (null != getSendReminderFacade().getName())
			{
				sendReminderEmail(email, getSendReminderFacade().getName(), productUrl, productName, productCode, productImageUrl,
						productPrice);
			}
			else
			{
				sendReminderEmail(email, "AnonymousUser", productUrl, productName, productCode, productImageUrl, productPrice);
			}

		}
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
	 * @return the sessionService
	 */
	public SessionService getSessionService()
	{
		return sessionService;
	}

	/**
	 * @param sessionService
	 *           the sessionService to set
	 */
	@Override
	public void setSessionService(final SessionService sessionService)
	{
		this.sessionService = sessionService;
	}


}
