/**
 *
 */
package au.com.rejectshop.core.reminder.dao;

import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.internal.dao.Dao;

import java.util.List;

import au.com.rejectshop.core.model.SendEmailReminderModel;


/**
 * @author saisravan.k
 *
 */
public interface SendReminderDao extends Dao
{
	List<SendEmailReminderModel> findTheListByDateandTime(String date, String time);


	List<SendEmailReminderModel> findTheListByFlag(boolean status);

	ProductModel findProductsByCode(final String productCode);
}
