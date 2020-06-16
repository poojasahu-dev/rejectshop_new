/**
 *
 */
package au.com.rejectshop.facades.process.email.context;

import de.hybris.platform.acceleratorservices.model.cms2.pages.EmailPageModel;
import de.hybris.platform.acceleratorservices.process.email.context.AbstractEmailContext;
import de.hybris.platform.basecommerce.model.site.BaseSiteModel;
import de.hybris.platform.core.model.c2l.LanguageModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.processengine.model.BusinessProcessModel;

import au.com.rejectshop.core.model.process.SendReminderProcessModel;


/**
 * @author venkatapavani.t
 *
 */
public class SendReminderEmailContext extends AbstractEmailContext
{
	public static final String MESSAGE = "message";
	public static final String EMAIL = "email";
	public static final String DAY_OF_Reminder = "dayOfReminder";
	public static final String TIME = "time";
	public static final String PRODUCT_URL = "productUrl";
	public static final String PRODUCT_NAME = "productName";
	public static final String PRODUCT_CODE = "productCode";
	public static final String PRODUCT_IMAGEURL = "productImageUrl";
	public static final String PRODUCT_PRICE = "productPrice";

	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.platform.acceleratorservices.process.email.context.AbstractEmailContext#getSite(de.hybris.platform.
	 * processengine.model.BusinessProcessModel)
	 */
	@Override
	protected BaseSiteModel getSite(final BusinessProcessModel businessProcessModel)
	{
		return ((SendReminderProcessModel) businessProcessModel).getSite();
	}

	@Override
	public void init(final BusinessProcessModel businessProcessModel, final EmailPageModel emailPageModel)
	{
		super.init(businessProcessModel, emailPageModel);
		if (businessProcessModel instanceof SendReminderProcessModel)
		{

			put(EMAIL, ((SendReminderProcessModel) businessProcessModel).getEmail());
			put(DAY_OF_Reminder, ((SendReminderProcessModel) businessProcessModel).getDayofReminder());
			put(TIME, ((SendReminderProcessModel) businessProcessModel).getTime());
			put(PRODUCT_URL, ((SendReminderProcessModel) businessProcessModel).getProductUrl());
			put(PRODUCT_NAME, ((SendReminderProcessModel) businessProcessModel).getProductName());
			put(PRODUCT_CODE, ((SendReminderProcessModel) businessProcessModel).getProductCode());
			put(PRODUCT_IMAGEURL, ((SendReminderProcessModel) businessProcessModel).getProductImageUrl());
			put(PRODUCT_PRICE, ((SendReminderProcessModel) businessProcessModel).getProductPrice());
			put(DISPLAY_NAME, ((SendReminderProcessModel) businessProcessModel).getName());

		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * de.hybris.platform.acceleratorservices.process.email.context.AbstractEmailContext#getCustomer(de.hybris.platform
	 * .processengine.model.BusinessProcessModel)
	 */
	@Override
	protected CustomerModel getCustomer(final BusinessProcessModel businessProcessModel)
	{
		// YTODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * de.hybris.platform.acceleratorservices.process.email.context.AbstractEmailContext#getEmailLanguage(de.hybris.platform
	 * .processengine.model.BusinessProcessModel)
	 */
	@Override
	protected LanguageModel getEmailLanguage(final BusinessProcessModel businessProcessModel)
	{
		// YTODO Auto-generated method stub
		return null;
	}

}
