/**
 *
 */
package au.com.rejectshop.core.event;

import de.hybris.platform.basecommerce.model.site.BaseSiteModel;
import de.hybris.platform.commerceservices.event.AbstractCommerceUserEvent;


/**
 * @author venkatapavani.t
 *
 */
public class SendAFriendEmailEvent extends AbstractCommerceUserEvent<BaseSiteModel>
{
	/** The email. */
	private String email;

	/** The RecipientEmail. */
	private String RecipientEmail;

	/** The message. */
	private String message;

	/** The name. */
	private String name;

	/** Product Url */
	private String productUrl;
	/** Product Name */
	private String productName;

	private String productCode;

	private String productImageUrl;

	private String productPrice;

	private String yourName;


	public String getYourName() {
		return yourName;
	}

	public void setYourName(String yourName) {
		this.yourName = yourName;
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



	/**
	 * @return the recipientEmail
	 */
	public String getRecipientEmail()
	{
		return RecipientEmail;
	}

	/**
	 * @param recipientEmail
	 *           the recipientEmail to set
	 */
	public void setRecipientEmail(final String recipientEmail)
	{
		RecipientEmail = recipientEmail;
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
	 * @return the message
	 */
	public String getMessage()
	{
		return message;
	}

	/**
	 * @param message
	 *           the message to set
	 */
	public void setMessage(final String message)
	{
		this.message = message;
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

}
