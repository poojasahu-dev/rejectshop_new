/**
 *
 */
package au.com.rejectshop.core.reminder.dao.impl;

import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.internal.dao.AbstractItemDao;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.SearchResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import au.com.rejectshop.core.model.SendEmailReminderModel;
import au.com.rejectshop.core.reminder.dao.SendReminderDao;


/**
 * @author saisravan.k
 *
 */
public class DefaultSendReminderDao extends AbstractItemDao implements SendReminderDao
{
	private final String FINAL_QUERY = "SELECT {pk} FROM {SendEmailReminder} WHERE {reminderDate}=(?reminderDate) AND ((?reminderTime)-1) <= {reminderTime} AND {reminderTime} <= (?reminderTime)";
	private final String STATUS_QUERY = "SELECT {pk} FROM {SendEmailReminder}";
	private final String PRODUCT_CODE_QUERY = "SELECT {pk} FROM {Product} WHERE {code}=(?code)";
	private static final String REMINDER_DATE = "reminderDate";
	private static final String REMINDER_TIME = "reminderTime";
	private static final String REMINDER_STATUS = "reminderStatus";
	private static final String PRODUCT_CODE = "code";

	/*
	 * (non-Javadoc)
	 * 
	 * @see au.com.rejectshop.core.reminder.dao.SendReminderDao#findTheListByDate(java.lang.String)
	 */
	public List<SendEmailReminderModel> findTheListByDateandTime(final String date, final String time)
	{
		final Map<String, Object> params = new HashMap<String, Object>();
		params.put(REMINDER_DATE, date);
		params.put(REMINDER_TIME, time);
		final FlexibleSearchQuery query = new FlexibleSearchQuery(FINAL_QUERY);
		query.addQueryParameters(params);
		query.setNeedTotal(true);
		final SearchResult<SendEmailReminderModel> result = getFlexibleSearchService().search(query);
		return result.getResult();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see au.com.rejectshop.core.reminder.dao.SendReminderDao#findTheListByFlag(boolean)
	 */
	@SuppressWarnings("boxing")
	public List<SendEmailReminderModel> findTheListByFlag(final boolean status)
	{
		final FlexibleSearchQuery query = new FlexibleSearchQuery(STATUS_QUERY);
		final Map<String, java.lang.Boolean> params = new HashMap<String, java.lang.Boolean>();
		params.put(REMINDER_STATUS, status);
		final SearchResult<SendEmailReminderModel> result = getFlexibleSearchService().search(query);
		return result.getResult();
	}

	public ProductModel findProductsByCode(final String productCode)
	{

		final Map<String, Object> params = new HashMap<String, Object>();
		params.put(PRODUCT_CODE, productCode);
		final FlexibleSearchQuery query = new FlexibleSearchQuery(PRODUCT_CODE_QUERY);
		query.addQueryParameters(params);
		query.setNeedTotal(true);
		final SearchResult<ProductModel> result = getFlexibleSearchService().search(query);
		if (null != result.getResult().get(0))
		{
			return result.getResult().get(0);
		}
		return null;
	}
}
