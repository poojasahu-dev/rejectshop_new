/**
 *
 */
package au.com.rejectshop.storefront.forms;

/**
 * @author saisravan.k
 *
 */
public class SendReminderForm
{
	/** The email. */
	private String email;

	/** The dayofReminder. */
	private String dayofReminder;

	/** The time. */
	private String time;

	/** The name. */
	private String name;

	private String brontoToken;

	/**
	 * @return the brontoToken
	 */
	public String getBrontoToken()
	{
		return brontoToken;
	}

	/**
	 * @param brontoToken
	 *           the brontoToken to set
	 */
	public void setBrontoToken(final String brontoToken)
	{
		this.brontoToken = brontoToken;
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

	private String productName;
	/** Product Url */

	private String productUrl;

	private String productCode;
	private String productImageUrl;
	private String productPrice;

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
	 * @return the dayofReminder
	 */
	public String getDayofReminder()
	{
		return dayofReminder;
	}

	/**
	 * @param dayofReminder
	 *           the dayofReminder to set
	 */
	public void setDayofReminder(final String dayofReminder)
	{
		this.dayofReminder = dayofReminder;
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
