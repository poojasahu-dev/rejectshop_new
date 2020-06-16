/**
 *
 */
package au.com.rejectshop.core.event;

import de.hybris.platform.basecommerce.model.site.BaseSiteModel;
import de.hybris.platform.commerceservices.event.AbstractCommerceUserEvent;


/**
 * @author saisravan.k
 *
 */
public class SendReminderEmailEvent extends AbstractCommerceUserEvent<BaseSiteModel>
{
	/** The email. */
	private String email;

	private String dayofReminder;

	private String time;
	/** The name. */
	private String name;
	/** Product Url */
	private String productUrl;
	/** Product Name */
	private String productName;

	private String productCode;
	private String productImageUrl;

	private String productPrice;

	/**
	 * @return the productUrl
	 */
	public String getProductUrl()
	{
		return productUrl;
	}

	/**
	 * @param productUrl
	 *           the productUrl to set
	 */
	public void setProductUrl(final String productUrl)
	{
		this.productUrl = productUrl;
	}

	/**
	 * @return the productName
	 */
	public String getProductName()
	{
		return productName;
	}

	/**
	 * @param productName
	 *           the productName to set
	 */
	public void setProductName(final String productName)
	{
		this.productName = productName;
	}

	/**
	 * @return the email
	 */
	public String getEmail()
	{
		return email;
	}

	/**
	 * @param email
	 *           the email to set
	 */
	public void setEmail(final String email)
	{
		this.email = email;
	}

	/**
	 * @return the productCode
	 */
	public String getProductCode()
	{
		return productCode;
	}

	/**
	 * @param productCode
	 *           the productCode to set
	 */
	public void setProductCode(final String productCode)
	{
		this.productCode = productCode;
	}

	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @param name
	 *           the name to set
	 */
	public void setName(final String name)
	{
		this.name = name;
	}

	/**
	 * @return the dayOfReminder
	 */
	public String getDayofReminder()
	{
		return dayofReminder;
	}

	/**
	 * @param dayOfReminder
	 *           the dayOfReminder to set
	 */
	public void setDayofReminder(final String dayOfReminder)
	{
		this.dayofReminder = dayOfReminder;
	}

	/**
	 * @return the time
	 */
	public String getTime()
	{
		return time;
	}

	/**
	 * @param time
	 *           the time to set
	 */
	public void setTime(final String time)
	{
		this.time = time;
	}

	/**
	 * @return the productImageUrl
	 */
	public String getProductImageUrl()
	{
		return productImageUrl;
	}

	/**
	 * @param productImageUrl
	 *           the productImageUrl to set
	 */
	public void setProductImageUrl(final String productImageUrl)
	{
		this.productImageUrl = productImageUrl;
	}

	/**
	 * @return the productPrice
	 */
	public String getProductPrice()
	{
		return productPrice;
	}

	/**
	 * @param productPrice
	 *           the productPrice to set
	 */
	public void setProductPrice(final String productPrice)
	{
		this.productPrice = productPrice;
	}

}
