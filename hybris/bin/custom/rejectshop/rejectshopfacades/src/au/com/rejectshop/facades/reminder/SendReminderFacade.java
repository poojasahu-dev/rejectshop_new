/**
 *
 */
package au.com.rejectshop.facades.reminder;

import de.hybris.platform.core.model.product.ProductModel;

import java.util.List;

import au.com.rejectshop.core.model.SendEmailReminderModel;


/**
 * @author saisravan.k
 *
 */
public interface SendReminderFacade
{

	/** The email. */
	public String getEmail();


	/**
	 * @param email
	 *           the email to set
	 */
	public void setEmail(final String email);


	/**
	 * @return the dayofReminder
	 */
	public String getDayofReminder();


	/**
	 * @param dayofReminder
	 *           the dayofReminder to set
	 */
	public void setDayofReminder(final String dayofReminder);

	/**
	 * @return the time
	 */
	public String getTime();


	/**
	 * @param time
	 *           the time to set
	 */
	public void setTime(final String time);


	/**
	 * @return the name
	 */
	public String getName();


	/**
	 * @param name
	 *           the name to set
	 */
	public void setName(final String name);


	/**
	 * @return the productUrl
	 */
	public String getProductUrl();


	/**
	 * @param productUrl
	 *           the productUrl to set
	 */
	public void setProductUrl(final String productUrl);


	/**
	 * @return the productName
	 */
	public String getProductName();


	/**
	 * @param productName
	 *           the productName to set
	 */
	public void setProductName(final String productName);


	/**
	 * @return the productCode
	 */
	public String getProductCode();

	/**
	 * @return the productImageUrl
	 */
	public String getProductImageUrl();

	/**
	 * @param productImageUrl
	 *           the productImageUrl to set
	 */
	public void setProductImageUrl(final String productImageUrl);

	/**
	 * @return the productPrice
	 */
	public String getProductPrice();

	/**
	 * @param productPrice
	 *           the productPrice to set
	 */
	public void setProductPrice(final String productPrice);

	/**
	 * @param productCode
	 *           the productCode to set
	 */
	public void setProductCode(final String productCode);


	List<SendEmailReminderModel> findTheListByDateandTime();


	List<SendEmailReminderModel> findTheListByFlag(boolean status);

	ProductModel findProductsByCode(final String productCode);
}
