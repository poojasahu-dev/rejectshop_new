/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jun 15, 2020 12:43:10 PM                    ---
 * ----------------------------------------------------------------
 */
package au.com.rejectshop.core.jalo.process;

import au.com.rejectshop.core.constants.RejectshopCoreConstants;
import de.hybris.platform.commerceservices.jalo.process.StoreFrontProcess;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type {@link au.com.rejectshop.core.jalo.process.SendReminderProcess SendReminderProcess}.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedSendReminderProcess extends StoreFrontProcess
{
	/** Qualifier of the <code>SendReminderProcess.name</code> attribute **/
	public static final String NAME = "name";
	/** Qualifier of the <code>SendReminderProcess.productUrl</code> attribute **/
	public static final String PRODUCTURL = "productUrl";
	/** Qualifier of the <code>SendReminderProcess.productName</code> attribute **/
	public static final String PRODUCTNAME = "productName";
	/** Qualifier of the <code>SendReminderProcess.productCode</code> attribute **/
	public static final String PRODUCTCODE = "productCode";
	/** Qualifier of the <code>SendReminderProcess.productImageUrl</code> attribute **/
	public static final String PRODUCTIMAGEURL = "productImageUrl";
	/** Qualifier of the <code>SendReminderProcess.productPrice</code> attribute **/
	public static final String PRODUCTPRICE = "productPrice";
	/** Qualifier of the <code>SendReminderProcess.email</code> attribute **/
	public static final String EMAIL = "email";
	/** Qualifier of the <code>SendReminderProcess.time</code> attribute **/
	public static final String TIME = "time";
	/** Qualifier of the <code>SendReminderProcess.dayofReminder</code> attribute **/
	public static final String DAYOFREMINDER = "dayofReminder";
	/** Qualifier of the <code>SendReminderProcess.emailNotification</code> attribute **/
	public static final String EMAILNOTIFICATION = "emailNotification";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>(StoreFrontProcess.DEFAULT_INITIAL_ATTRIBUTES);
		tmp.put(NAME, AttributeMode.INITIAL);
		tmp.put(PRODUCTURL, AttributeMode.INITIAL);
		tmp.put(PRODUCTNAME, AttributeMode.INITIAL);
		tmp.put(PRODUCTCODE, AttributeMode.INITIAL);
		tmp.put(PRODUCTIMAGEURL, AttributeMode.INITIAL);
		tmp.put(PRODUCTPRICE, AttributeMode.INITIAL);
		tmp.put(EMAIL, AttributeMode.INITIAL);
		tmp.put(TIME, AttributeMode.INITIAL);
		tmp.put(DAYOFREMINDER, AttributeMode.INITIAL);
		tmp.put(EMAILNOTIFICATION, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SendReminderProcess.dayofReminder</code> attribute.
	 * @return the dayofReminder
	 */
	public String getDayofReminder(final SessionContext ctx)
	{
		return (String)getProperty( ctx, DAYOFREMINDER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SendReminderProcess.dayofReminder</code> attribute.
	 * @return the dayofReminder
	 */
	public String getDayofReminder()
	{
		return getDayofReminder( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SendReminderProcess.dayofReminder</code> attribute. 
	 * @param value the dayofReminder
	 */
	public void setDayofReminder(final SessionContext ctx, final String value)
	{
		setProperty(ctx, DAYOFREMINDER,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SendReminderProcess.dayofReminder</code> attribute. 
	 * @param value the dayofReminder
	 */
	public void setDayofReminder(final String value)
	{
		setDayofReminder( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SendReminderProcess.email</code> attribute.
	 * @return the email
	 */
	public String getEmail(final SessionContext ctx)
	{
		return (String)getProperty( ctx, EMAIL);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SendReminderProcess.email</code> attribute.
	 * @return the email
	 */
	public String getEmail()
	{
		return getEmail( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SendReminderProcess.email</code> attribute. 
	 * @param value the email
	 */
	public void setEmail(final SessionContext ctx, final String value)
	{
		setProperty(ctx, EMAIL,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SendReminderProcess.email</code> attribute. 
	 * @param value the email
	 */
	public void setEmail(final String value)
	{
		setEmail( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SendReminderProcess.emailNotification</code> attribute.
	 * @return the emailNotification
	 */
	public Boolean isEmailNotification(final SessionContext ctx)
	{
		return (Boolean)getProperty( ctx, EMAILNOTIFICATION);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SendReminderProcess.emailNotification</code> attribute.
	 * @return the emailNotification
	 */
	public Boolean isEmailNotification()
	{
		return isEmailNotification( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SendReminderProcess.emailNotification</code> attribute. 
	 * @return the emailNotification
	 */
	public boolean isEmailNotificationAsPrimitive(final SessionContext ctx)
	{
		Boolean value = isEmailNotification( ctx );
		return value != null ? value.booleanValue() : false;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SendReminderProcess.emailNotification</code> attribute. 
	 * @return the emailNotification
	 */
	public boolean isEmailNotificationAsPrimitive()
	{
		return isEmailNotificationAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SendReminderProcess.emailNotification</code> attribute. 
	 * @param value the emailNotification
	 */
	public void setEmailNotification(final SessionContext ctx, final Boolean value)
	{
		setProperty(ctx, EMAILNOTIFICATION,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SendReminderProcess.emailNotification</code> attribute. 
	 * @param value the emailNotification
	 */
	public void setEmailNotification(final Boolean value)
	{
		setEmailNotification( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SendReminderProcess.emailNotification</code> attribute. 
	 * @param value the emailNotification
	 */
	public void setEmailNotification(final SessionContext ctx, final boolean value)
	{
		setEmailNotification( ctx,Boolean.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SendReminderProcess.emailNotification</code> attribute. 
	 * @param value the emailNotification
	 */
	public void setEmailNotification(final boolean value)
	{
		setEmailNotification( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SendReminderProcess.name</code> attribute.
	 * @return the name
	 */
	public String getName(final SessionContext ctx)
	{
		return (String)getProperty( ctx, NAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SendReminderProcess.name</code> attribute.
	 * @return the name
	 */
	public String getName()
	{
		return getName( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SendReminderProcess.name</code> attribute. 
	 * @param value the name
	 */
	public void setName(final SessionContext ctx, final String value)
	{
		setProperty(ctx, NAME,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SendReminderProcess.name</code> attribute. 
	 * @param value the name
	 */
	public void setName(final String value)
	{
		setName( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SendReminderProcess.productCode</code> attribute.
	 * @return the productCode
	 */
	public String getProductCode(final SessionContext ctx)
	{
		return (String)getProperty( ctx, PRODUCTCODE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SendReminderProcess.productCode</code> attribute.
	 * @return the productCode
	 */
	public String getProductCode()
	{
		return getProductCode( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SendReminderProcess.productCode</code> attribute. 
	 * @param value the productCode
	 */
	public void setProductCode(final SessionContext ctx, final String value)
	{
		setProperty(ctx, PRODUCTCODE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SendReminderProcess.productCode</code> attribute. 
	 * @param value the productCode
	 */
	public void setProductCode(final String value)
	{
		setProductCode( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SendReminderProcess.productImageUrl</code> attribute.
	 * @return the productImageUrl
	 */
	public String getProductImageUrl(final SessionContext ctx)
	{
		return (String)getProperty( ctx, PRODUCTIMAGEURL);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SendReminderProcess.productImageUrl</code> attribute.
	 * @return the productImageUrl
	 */
	public String getProductImageUrl()
	{
		return getProductImageUrl( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SendReminderProcess.productImageUrl</code> attribute. 
	 * @param value the productImageUrl
	 */
	public void setProductImageUrl(final SessionContext ctx, final String value)
	{
		setProperty(ctx, PRODUCTIMAGEURL,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SendReminderProcess.productImageUrl</code> attribute. 
	 * @param value the productImageUrl
	 */
	public void setProductImageUrl(final String value)
	{
		setProductImageUrl( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SendReminderProcess.productName</code> attribute.
	 * @return the productName
	 */
	public String getProductName(final SessionContext ctx)
	{
		return (String)getProperty( ctx, PRODUCTNAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SendReminderProcess.productName</code> attribute.
	 * @return the productName
	 */
	public String getProductName()
	{
		return getProductName( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SendReminderProcess.productName</code> attribute. 
	 * @param value the productName
	 */
	public void setProductName(final SessionContext ctx, final String value)
	{
		setProperty(ctx, PRODUCTNAME,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SendReminderProcess.productName</code> attribute. 
	 * @param value the productName
	 */
	public void setProductName(final String value)
	{
		setProductName( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SendReminderProcess.productPrice</code> attribute.
	 * @return the productPrice
	 */
	public String getProductPrice(final SessionContext ctx)
	{
		return (String)getProperty( ctx, PRODUCTPRICE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SendReminderProcess.productPrice</code> attribute.
	 * @return the productPrice
	 */
	public String getProductPrice()
	{
		return getProductPrice( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SendReminderProcess.productPrice</code> attribute. 
	 * @param value the productPrice
	 */
	public void setProductPrice(final SessionContext ctx, final String value)
	{
		setProperty(ctx, PRODUCTPRICE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SendReminderProcess.productPrice</code> attribute. 
	 * @param value the productPrice
	 */
	public void setProductPrice(final String value)
	{
		setProductPrice( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SendReminderProcess.productUrl</code> attribute.
	 * @return the productUrl
	 */
	public String getProductUrl(final SessionContext ctx)
	{
		return (String)getProperty( ctx, PRODUCTURL);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SendReminderProcess.productUrl</code> attribute.
	 * @return the productUrl
	 */
	public String getProductUrl()
	{
		return getProductUrl( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SendReminderProcess.productUrl</code> attribute. 
	 * @param value the productUrl
	 */
	public void setProductUrl(final SessionContext ctx, final String value)
	{
		setProperty(ctx, PRODUCTURL,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SendReminderProcess.productUrl</code> attribute. 
	 * @param value the productUrl
	 */
	public void setProductUrl(final String value)
	{
		setProductUrl( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SendReminderProcess.time</code> attribute.
	 * @return the time
	 */
	public String getTime(final SessionContext ctx)
	{
		return (String)getProperty( ctx, TIME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SendReminderProcess.time</code> attribute.
	 * @return the time
	 */
	public String getTime()
	{
		return getTime( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SendReminderProcess.time</code> attribute. 
	 * @param value the time
	 */
	public void setTime(final SessionContext ctx, final String value)
	{
		setProperty(ctx, TIME,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SendReminderProcess.time</code> attribute. 
	 * @param value the time
	 */
	public void setTime(final String value)
	{
		setTime( getSession().getSessionContext(), value );
	}
	
}
