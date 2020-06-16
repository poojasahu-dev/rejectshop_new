/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jun 15, 2020 12:43:10 PM                    ---
 * ----------------------------------------------------------------
 */
package au.com.rejectshop.core.jalo.process;

import au.com.rejectshop.core.constants.RejectshopCoreConstants;
import de.hybris.platform.commerceservices.jalo.process.StoreFrontCustomerProcess;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type {@link au.com.rejectshop.core.jalo.process.SendAFriendEmailProcess SendAFriendEmailProcess}.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedSendAFriendEmailProcess extends StoreFrontCustomerProcess
{
	/** Qualifier of the <code>SendAFriendEmailProcess.email</code> attribute **/
	public static final String EMAIL = "email";
	/** Qualifier of the <code>SendAFriendEmailProcess.RecipientEmail</code> attribute **/
	public static final String RECIPIENTEMAIL = "RecipientEmail";
	/** Qualifier of the <code>SendAFriendEmailProcess.message</code> attribute **/
	public static final String MESSAGE = "message";
	/** Qualifier of the <code>SendAFriendEmailProcess.name</code> attribute **/
	public static final String NAME = "name";
	/** Qualifier of the <code>SendAFriendEmailProcess.productUrl</code> attribute **/
	public static final String PRODUCTURL = "productUrl";
	/** Qualifier of the <code>SendAFriendEmailProcess.productName</code> attribute **/
	public static final String PRODUCTNAME = "productName";
	/** Qualifier of the <code>SendAFriendEmailProcess.productCode</code> attribute **/
	public static final String PRODUCTCODE = "productCode";
	/** Qualifier of the <code>SendAFriendEmailProcess.productImageUrl</code> attribute **/
	public static final String PRODUCTIMAGEURL = "productImageUrl";
	/** Qualifier of the <code>SendAFriendEmailProcess.productPrice</code> attribute **/
	public static final String PRODUCTPRICE = "productPrice";
	/** Qualifier of the <code>SendAFriendEmailProcess.yourName</code> attribute **/
	public static final String YOURNAME = "yourName";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>(StoreFrontCustomerProcess.DEFAULT_INITIAL_ATTRIBUTES);
		tmp.put(EMAIL, AttributeMode.INITIAL);
		tmp.put(RECIPIENTEMAIL, AttributeMode.INITIAL);
		tmp.put(MESSAGE, AttributeMode.INITIAL);
		tmp.put(NAME, AttributeMode.INITIAL);
		tmp.put(PRODUCTURL, AttributeMode.INITIAL);
		tmp.put(PRODUCTNAME, AttributeMode.INITIAL);
		tmp.put(PRODUCTCODE, AttributeMode.INITIAL);
		tmp.put(PRODUCTIMAGEURL, AttributeMode.INITIAL);
		tmp.put(PRODUCTPRICE, AttributeMode.INITIAL);
		tmp.put(YOURNAME, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SendAFriendEmailProcess.email</code> attribute.
	 * @return the email
	 */
	public String getEmail(final SessionContext ctx)
	{
		return (String)getProperty( ctx, EMAIL);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SendAFriendEmailProcess.email</code> attribute.
	 * @return the email
	 */
	public String getEmail()
	{
		return getEmail( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SendAFriendEmailProcess.email</code> attribute. 
	 * @param value the email
	 */
	public void setEmail(final SessionContext ctx, final String value)
	{
		setProperty(ctx, EMAIL,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SendAFriendEmailProcess.email</code> attribute. 
	 * @param value the email
	 */
	public void setEmail(final String value)
	{
		setEmail( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SendAFriendEmailProcess.message</code> attribute.
	 * @return the message
	 */
	public String getMessage(final SessionContext ctx)
	{
		return (String)getProperty( ctx, MESSAGE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SendAFriendEmailProcess.message</code> attribute.
	 * @return the message
	 */
	public String getMessage()
	{
		return getMessage( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SendAFriendEmailProcess.message</code> attribute. 
	 * @param value the message
	 */
	public void setMessage(final SessionContext ctx, final String value)
	{
		setProperty(ctx, MESSAGE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SendAFriendEmailProcess.message</code> attribute. 
	 * @param value the message
	 */
	public void setMessage(final String value)
	{
		setMessage( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SendAFriendEmailProcess.name</code> attribute.
	 * @return the name
	 */
	public String getName(final SessionContext ctx)
	{
		return (String)getProperty( ctx, NAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SendAFriendEmailProcess.name</code> attribute.
	 * @return the name
	 */
	public String getName()
	{
		return getName( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SendAFriendEmailProcess.name</code> attribute. 
	 * @param value the name
	 */
	public void setName(final SessionContext ctx, final String value)
	{
		setProperty(ctx, NAME,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SendAFriendEmailProcess.name</code> attribute. 
	 * @param value the name
	 */
	public void setName(final String value)
	{
		setName( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SendAFriendEmailProcess.productCode</code> attribute.
	 * @return the productCode
	 */
	public String getProductCode(final SessionContext ctx)
	{
		return (String)getProperty( ctx, PRODUCTCODE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SendAFriendEmailProcess.productCode</code> attribute.
	 * @return the productCode
	 */
	public String getProductCode()
	{
		return getProductCode( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SendAFriendEmailProcess.productCode</code> attribute. 
	 * @param value the productCode
	 */
	public void setProductCode(final SessionContext ctx, final String value)
	{
		setProperty(ctx, PRODUCTCODE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SendAFriendEmailProcess.productCode</code> attribute. 
	 * @param value the productCode
	 */
	public void setProductCode(final String value)
	{
		setProductCode( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SendAFriendEmailProcess.productImageUrl</code> attribute.
	 * @return the productImageUrl
	 */
	public String getProductImageUrl(final SessionContext ctx)
	{
		return (String)getProperty( ctx, PRODUCTIMAGEURL);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SendAFriendEmailProcess.productImageUrl</code> attribute.
	 * @return the productImageUrl
	 */
	public String getProductImageUrl()
	{
		return getProductImageUrl( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SendAFriendEmailProcess.productImageUrl</code> attribute. 
	 * @param value the productImageUrl
	 */
	public void setProductImageUrl(final SessionContext ctx, final String value)
	{
		setProperty(ctx, PRODUCTIMAGEURL,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SendAFriendEmailProcess.productImageUrl</code> attribute. 
	 * @param value the productImageUrl
	 */
	public void setProductImageUrl(final String value)
	{
		setProductImageUrl( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SendAFriendEmailProcess.productName</code> attribute.
	 * @return the productName
	 */
	public String getProductName(final SessionContext ctx)
	{
		return (String)getProperty( ctx, PRODUCTNAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SendAFriendEmailProcess.productName</code> attribute.
	 * @return the productName
	 */
	public String getProductName()
	{
		return getProductName( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SendAFriendEmailProcess.productName</code> attribute. 
	 * @param value the productName
	 */
	public void setProductName(final SessionContext ctx, final String value)
	{
		setProperty(ctx, PRODUCTNAME,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SendAFriendEmailProcess.productName</code> attribute. 
	 * @param value the productName
	 */
	public void setProductName(final String value)
	{
		setProductName( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SendAFriendEmailProcess.productPrice</code> attribute.
	 * @return the productPrice
	 */
	public String getProductPrice(final SessionContext ctx)
	{
		return (String)getProperty( ctx, PRODUCTPRICE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SendAFriendEmailProcess.productPrice</code> attribute.
	 * @return the productPrice
	 */
	public String getProductPrice()
	{
		return getProductPrice( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SendAFriendEmailProcess.productPrice</code> attribute. 
	 * @param value the productPrice
	 */
	public void setProductPrice(final SessionContext ctx, final String value)
	{
		setProperty(ctx, PRODUCTPRICE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SendAFriendEmailProcess.productPrice</code> attribute. 
	 * @param value the productPrice
	 */
	public void setProductPrice(final String value)
	{
		setProductPrice( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SendAFriendEmailProcess.productUrl</code> attribute.
	 * @return the productUrl
	 */
	public String getProductUrl(final SessionContext ctx)
	{
		return (String)getProperty( ctx, PRODUCTURL);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SendAFriendEmailProcess.productUrl</code> attribute.
	 * @return the productUrl
	 */
	public String getProductUrl()
	{
		return getProductUrl( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SendAFriendEmailProcess.productUrl</code> attribute. 
	 * @param value the productUrl
	 */
	public void setProductUrl(final SessionContext ctx, final String value)
	{
		setProperty(ctx, PRODUCTURL,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SendAFriendEmailProcess.productUrl</code> attribute. 
	 * @param value the productUrl
	 */
	public void setProductUrl(final String value)
	{
		setProductUrl( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SendAFriendEmailProcess.RecipientEmail</code> attribute.
	 * @return the RecipientEmail
	 */
	public String getRecipientEmail(final SessionContext ctx)
	{
		return (String)getProperty( ctx, RECIPIENTEMAIL);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SendAFriendEmailProcess.RecipientEmail</code> attribute.
	 * @return the RecipientEmail
	 */
	public String getRecipientEmail()
	{
		return getRecipientEmail( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SendAFriendEmailProcess.RecipientEmail</code> attribute. 
	 * @param value the RecipientEmail
	 */
	public void setRecipientEmail(final SessionContext ctx, final String value)
	{
		setProperty(ctx, RECIPIENTEMAIL,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SendAFriendEmailProcess.RecipientEmail</code> attribute. 
	 * @param value the RecipientEmail
	 */
	public void setRecipientEmail(final String value)
	{
		setRecipientEmail( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SendAFriendEmailProcess.yourName</code> attribute.
	 * @return the yourName
	 */
	public String getYourName(final SessionContext ctx)
	{
		return (String)getProperty( ctx, YOURNAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SendAFriendEmailProcess.yourName</code> attribute.
	 * @return the yourName
	 */
	public String getYourName()
	{
		return getYourName( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SendAFriendEmailProcess.yourName</code> attribute. 
	 * @param value the yourName
	 */
	public void setYourName(final SessionContext ctx, final String value)
	{
		setProperty(ctx, YOURNAME,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SendAFriendEmailProcess.yourName</code> attribute. 
	 * @param value the yourName
	 */
	public void setYourName(final String value)
	{
		setYourName( getSession().getSessionContext(), value );
	}
	
}
