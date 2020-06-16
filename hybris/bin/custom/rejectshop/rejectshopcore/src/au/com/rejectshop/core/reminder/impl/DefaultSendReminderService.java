/**
 *
 */
package au.com.rejectshop.core.reminder.impl;

import de.hybris.platform.core.model.product.ProductModel;

import java.util.List;

import au.com.rejectshop.core.model.SendEmailReminderModel;
import au.com.rejectshop.core.reminder.SendReminderService;
import au.com.rejectshop.core.reminder.dao.SendReminderDao;


/**
 * @author saisravan.k
 *
 */
public class DefaultSendReminderService implements SendReminderService
{

	private SendReminderDao sendReminderDao;

	/*
	 * (non-Javadoc)
	 *
	 * @see au.com.rejectshop.core.reminder.SendReminderService#findTheListByDate(java.lang.String)
	 */
	public List<SendEmailReminderModel> findTheListByDateandTime(final String date, final String time)
	{
		return getSendReminderDao().findTheListByDateandTime(date, time);

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see au.com.rejectshop.core.reminder.SendReminderService#findTheListByFlag(boolean)
	 */
	public List<SendEmailReminderModel> findTheListByFlag(final boolean status)
	{
		return getSendReminderDao().findTheListByFlag(status);
	}

	public ProductModel findProductsByCode(final String productCode)
	{
		return getSendReminderDao().findProductsByCode(productCode);
	}

	/**
	 * @return the sendReminderDao
	 */
	public SendReminderDao getSendReminderDao()
	{
		return sendReminderDao;
	}

	/**
	 * @param sendReminderDao
	 *           the sendReminderDao to set
	 */
	public void setSendReminderDao(final SendReminderDao sendReminderDao)
	{
		this.sendReminderDao = sendReminderDao;
	}

}
