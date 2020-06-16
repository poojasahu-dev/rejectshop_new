/**
 *
 */
package au.com.rejectshop.core.reminder;

import de.hybris.platform.core.model.product.ProductModel;

import java.util.List;

import au.com.rejectshop.core.model.SendEmailReminderModel;


/**
 * @author saisravan.k
 *
 */
public interface SendReminderService
{

	List<SendEmailReminderModel> findTheListByDateandTime(String date, String time);

	List<SendEmailReminderModel> findTheListByFlag(boolean status);

	ProductModel findProductsByCode(final String productCode);
}
