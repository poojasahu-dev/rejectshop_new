/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jun 15, 2020 12:43:10 PM                    ---
 * ----------------------------------------------------------------
 */
package au.com.rejectshop.core.jalo;

import au.com.rejectshop.core.constants.RejectshopCoreConstants;
import de.hybris.platform.jalo.GenericItem;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type {@link de.hybris.platform.jalo.GenericItem SendEmailReminder}.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedSendEmailReminder extends GenericItem
{
	/** Qualifier of the <code>SendEmailReminder.reminderEmail</code> attribute **/
	public static final String REMINDEREMAIL = "reminderEmail";
	/** Qualifier of the <code>SendEmailReminder.productCode</code> attribute **/
	public static final String PRODUCTCODE = "productCode";
	/** Qualifier of the <code>SendEmailReminder.productImageUrl</code> attribute **/
	public static final String PRODUCTIMAGEURL = "productImageUrl";
	/** Qualifier of the <code>SendEmailReminder.productPrice</code> attribute **/
	public static final String PRODUCTPRICE = "productPrice";
	/** Qualifier of the <code>SendEmailReminder.reminderDate</code> attribute **/
	public static final String REMINDERDATE = "reminderDate";
	/** Qualifier of the <code>SendEmailReminder.reminderTime</code> attribute **/
	public static final String REMINDERTIME = "reminderTime";
	/** Qualifier of the <code>SendEmailReminder.productUrl</code> attribute **/
	public static final String PRODUCTURL = "productUrl";
	/** Qualifier of the <code>SendEmailReminder.sentStatus</code> attribute **/
	public static final String SENTSTATUS = "sentStatus";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>();
		tmp.put(REMINDEREMAIL, AttributeMode.INITIAL);
		tmp.put(PRODUCTCODE, AttributeMode.INITIAL);
		tmp.put(PRODUCTIMAGEURL, AttributeMode.INITIAL);
		tmp.put(PRODUCTPRICE, AttributeMode.INITIAL);
		tmp.put(REMINDERDATE, AttributeMode.INITIAL);
		tmp.put(REMINDERTIME, AttributeMode.INITIAL);
		tmp.put(PRODUCTURL, AttributeMode.INITIAL);
		tmp.put(SENTSTATUS, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SendEmailReminder.productCode</code> attribute.
	 * @return the productCode
	 */
	public String getProductCode(final SessionContext ctx)
	{
		return (String)getProperty( ctx, PRODUCTCODE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SendEmailReminder.productCode</code> attribute.
	 * @return the productCode
	 */
	public String getProductCode()
	{
		return getProductCode( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SendEmailReminder.productCode</code> attribute. 
	 * @param value the productCode
	 */
	public void setProductCode(final SessionContext ctx, final String value)
	{
		setProperty(ctx, PRODUCTCODE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SendEmailReminder.productCode</code> attribute. 
	 * @param value the productCode
	 */
	public void setProductCode(final String value)
	{
		setProductCode( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SendEmailReminder.productImageUrl</code> attribute.
	 * @return the productImageUrl
	 */
	public String getProductImageUrl(final SessionContext ctx)
	{
		return (String)getProperty( ctx, PRODUCTIMAGEURL);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SendEmailReminder.productImageUrl</code> attribute.
	 * @return the productImageUrl
	 */
	public String getProductImageUrl()
	{
		return getProductImageUrl( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SendEmailReminder.productImageUrl</code> attribute. 
	 * @param value the productImageUrl
	 */
	public void setProductImageUrl(final SessionContext ctx, final String value)
	{
		setProperty(ctx, PRODUCTIMAGEURL,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SendEmailReminder.productImageUrl</code> attribute. 
	 * @param value the productImageUrl
	 */
	public void setProductImageUrl(final String value)
	{
		setProductImageUrl( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SendEmailReminder.productPrice</code> attribute.
	 * @return the productPrice
	 */
	public String getProductPrice(final SessionContext ctx)
	{
		return (String)getProperty( ctx, PRODUCTPRICE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SendEmailReminder.productPrice</code> attribute.
	 * @return the productPrice
	 */
	public String getProductPrice()
	{
		return getProductPrice( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SendEmailReminder.productPrice</code> attribute. 
	 * @param value the productPrice
	 */
	public void setProductPrice(final SessionContext ctx, final String value)
	{
		setProperty(ctx, PRODUCTPRICE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SendEmailReminder.productPrice</code> attribute. 
	 * @param value the productPrice
	 */
	public void setProductPrice(final String value)
	{
		setProductPrice( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SendEmailReminder.productUrl</code> attribute.
	 * @return the productUrl
	 */
	public String getProductUrl(final SessionContext ctx)
	{
		return (String)getProperty( ctx, PRODUCTURL);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SendEmailReminder.productUrl</code> attribute.
	 * @return the productUrl
	 */
	public String getProductUrl()
	{
		return getProductUrl( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SendEmailReminder.productUrl</code> attribute. 
	 * @param value the productUrl
	 */
	public void setProductUrl(final SessionContext ctx, final String value)
	{
		setProperty(ctx, PRODUCTURL,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SendEmailReminder.productUrl</code> attribute. 
	 * @param value the productUrl
	 */
	public void setProductUrl(final String value)
	{
		setProductUrl( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SendEmailReminder.reminderDate</code> attribute.
	 * @return the reminderDate
	 */
	public String getReminderDate(final SessionContext ctx)
	{
		return (String)getProperty( ctx, REMINDERDATE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SendEmailReminder.reminderDate</code> attribute.
	 * @return the reminderDate
	 */
	public String getReminderDate()
	{
		return getReminderDate( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SendEmailReminder.reminderDate</code> attribute. 
	 * @param value the reminderDate
	 */
	public void setReminderDate(final SessionContext ctx, final String value)
	{
		setProperty(ctx, REMINDERDATE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SendEmailReminder.reminderDate</code> attribute. 
	 * @param value the reminderDate
	 */
	public void setReminderDate(final String value)
	{
		setReminderDate( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SendEmailReminder.reminderEmail</code> attribute.
	 * @return the reminderEmail
	 */
	public String getReminderEmail(final SessionContext ctx)
	{
		return (String)getProperty( ctx, REMINDEREMAIL);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SendEmailReminder.reminderEmail</code> attribute.
	 * @return the reminderEmail
	 */
	public String getReminderEmail()
	{
		return getReminderEmail( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SendEmailReminder.reminderEmail</code> attribute. 
	 * @param value the reminderEmail
	 */
	public void setReminderEmail(final SessionContext ctx, final String value)
	{
		setProperty(ctx, REMINDEREMAIL,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SendEmailReminder.reminderEmail</code> attribute. 
	 * @param value the reminderEmail
	 */
	public void setReminderEmail(final String value)
	{
		setReminderEmail( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SendEmailReminder.reminderTime</code> attribute.
	 * @return the reminderTime
	 */
	public String getReminderTime(final SessionContext ctx)
	{
		return (String)getProperty( ctx, REMINDERTIME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SendEmailReminder.reminderTime</code> attribute.
	 * @return the reminderTime
	 */
	public String getReminderTime()
	{
		return getReminderTime( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SendEmailReminder.reminderTime</code> attribute. 
	 * @param value the reminderTime
	 */
	public void setReminderTime(final SessionContext ctx, final String value)
	{
		setProperty(ctx, REMINDERTIME,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SendEmailReminder.reminderTime</code> attribute. 
	 * @param value the reminderTime
	 */
	public void setReminderTime(final String value)
	{
		setReminderTime( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SendEmailReminder.sentStatus</code> attribute.
	 * @return the sentStatus
	 */
	public Boolean isSentStatus(final SessionContext ctx)
	{
		return (Boolean)getProperty( ctx, SENTSTATUS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SendEmailReminder.sentStatus</code> attribute.
	 * @return the sentStatus
	 */
	public Boolean isSentStatus()
	{
		return isSentStatus( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SendEmailReminder.sentStatus</code> attribute. 
	 * @return the sentStatus
	 */
	public boolean isSentStatusAsPrimitive(final SessionContext ctx)
	{
		Boolean value = isSentStatus( ctx );
		return value != null ? value.booleanValue() : false;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SendEmailReminder.sentStatus</code> attribute. 
	 * @return the sentStatus
	 */
	public boolean isSentStatusAsPrimitive()
	{
		return isSentStatusAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SendEmailReminder.sentStatus</code> attribute. 
	 * @param value the sentStatus
	 */
	public void setSentStatus(final SessionContext ctx, final Boolean value)
	{
		setProperty(ctx, SENTSTATUS,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SendEmailReminder.sentStatus</code> attribute. 
	 * @param value the sentStatus
	 */
	public void setSentStatus(final Boolean value)
	{
		setSentStatus( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SendEmailReminder.sentStatus</code> attribute. 
	 * @param value the sentStatus
	 */
	public void setSentStatus(final SessionContext ctx, final boolean value)
	{
		setSentStatus( ctx,Boolean.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SendEmailReminder.sentStatus</code> attribute. 
	 * @param value the sentStatus
	 */
	public void setSentStatus(final boolean value)
	{
		setSentStatus( getSession().getSessionContext(), value );
	}
	
}
