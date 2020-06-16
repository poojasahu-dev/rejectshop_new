/**
 *
 */
package au.com.rejectshop.storefront.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;


/**
 * @author venkatapavani.t
 *
 */
public class SendAFriendForm
{

	/** The email. */
	private String email;

	/** The RecipientEmail. */
	private String RecipientEmail;

	/** The content. */
	/*private String message;*/

	/** The name. */
	private String name;


	/** Cart value */

	private String productName;
	/** Product Url */

	private String productUrl;

	private String productCode;

	private String productImageUrl;
	private String productPrice;
	private String yourName;
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

	public String getYourName()
	{
		return yourName;
	}

	public void setYourName(final String yourName)
	{
		this.yourName = yourName;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name
	 *           the name to set
	 */
	public void setName(final String name)
	{
		this.name = name;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	@NotNull(message = "{profile.email.invalid}")
	@Size(min = 1, max = 255, message = "{profile.email.invalid}")
	@Email(message = "{hs.email.invalid}")
	public String getEmail()
	{
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email
	 *           the email to set
	 */
	public void setEmail(final String email)
	{
		this.email = email;
	}


	/**
	 * @return the recipientEmail
	 */
	@NotNull(message = "{profile.email.invalid}")
	@Size(min = 1, max = 255, message = "{profile.email.invalid}")
	@Email(message = "{hs.email.invalid}")
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
	 * @return the message
	 */
	/*public String getMessage()
	{
		return message;
	}
*/
	/**
	 * @param message
	 *           the message to set
	 */
	/*public void setMessage(final String message)
	{
		this.message = message;
	}
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
