/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jun 15, 2020 12:43:10 PM                    ---
 * ----------------------------------------------------------------
 */
package au.com.rejectshop.core.components;

import au.com.rejectshop.core.constants.RejectshopCoreConstants;
import de.hybris.platform.cms2lib.components.BannerComponent;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type {@link au.com.rejectshop.core.components.AddThisComponent AddThisComponent}.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedAddThisComponent extends BannerComponent
{
	/** Qualifier of the <code>AddThisComponent.serviceType</code> attribute **/
	public static final String SERVICETYPE = "serviceType";
	/** Qualifier of the <code>AddThisComponent.addThisTitle</code> attribute **/
	public static final String ADDTHISTITLE = "addThisTitle";
	/** Qualifier of the <code>AddThisComponent.appendProductName</code> attribute **/
	public static final String APPENDPRODUCTNAME = "appendProductName";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>(BannerComponent.DEFAULT_INITIAL_ATTRIBUTES);
		tmp.put(SERVICETYPE, AttributeMode.INITIAL);
		tmp.put(ADDTHISTITLE, AttributeMode.INITIAL);
		tmp.put(APPENDPRODUCTNAME, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AddThisComponent.addThisTitle</code> attribute.
	 * @return the addThisTitle
	 */
	public String getAddThisTitle(final SessionContext ctx)
	{
		return (String)getProperty( ctx, ADDTHISTITLE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AddThisComponent.addThisTitle</code> attribute.
	 * @return the addThisTitle
	 */
	public String getAddThisTitle()
	{
		return getAddThisTitle( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>AddThisComponent.addThisTitle</code> attribute. 
	 * @param value the addThisTitle
	 */
	public void setAddThisTitle(final SessionContext ctx, final String value)
	{
		setProperty(ctx, ADDTHISTITLE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>AddThisComponent.addThisTitle</code> attribute. 
	 * @param value the addThisTitle
	 */
	public void setAddThisTitle(final String value)
	{
		setAddThisTitle( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AddThisComponent.appendProductName</code> attribute.
	 * @return the appendProductName
	 */
	public Boolean isAppendProductName(final SessionContext ctx)
	{
		return (Boolean)getProperty( ctx, APPENDPRODUCTNAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AddThisComponent.appendProductName</code> attribute.
	 * @return the appendProductName
	 */
	public Boolean isAppendProductName()
	{
		return isAppendProductName( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AddThisComponent.appendProductName</code> attribute. 
	 * @return the appendProductName
	 */
	public boolean isAppendProductNameAsPrimitive(final SessionContext ctx)
	{
		Boolean value = isAppendProductName( ctx );
		return value != null ? value.booleanValue() : false;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AddThisComponent.appendProductName</code> attribute. 
	 * @return the appendProductName
	 */
	public boolean isAppendProductNameAsPrimitive()
	{
		return isAppendProductNameAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>AddThisComponent.appendProductName</code> attribute. 
	 * @param value the appendProductName
	 */
	public void setAppendProductName(final SessionContext ctx, final Boolean value)
	{
		setProperty(ctx, APPENDPRODUCTNAME,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>AddThisComponent.appendProductName</code> attribute. 
	 * @param value the appendProductName
	 */
	public void setAppendProductName(final Boolean value)
	{
		setAppendProductName( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>AddThisComponent.appendProductName</code> attribute. 
	 * @param value the appendProductName
	 */
	public void setAppendProductName(final SessionContext ctx, final boolean value)
	{
		setAppendProductName( ctx,Boolean.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>AddThisComponent.appendProductName</code> attribute. 
	 * @param value the appendProductName
	 */
	public void setAppendProductName(final boolean value)
	{
		setAppendProductName( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AddThisComponent.serviceType</code> attribute.
	 * @return the serviceType
	 */
	public String getServiceType(final SessionContext ctx)
	{
		return (String)getProperty( ctx, SERVICETYPE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AddThisComponent.serviceType</code> attribute.
	 * @return the serviceType
	 */
	public String getServiceType()
	{
		return getServiceType( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>AddThisComponent.serviceType</code> attribute. 
	 * @param value the serviceType
	 */
	public void setServiceType(final SessionContext ctx, final String value)
	{
		setProperty(ctx, SERVICETYPE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>AddThisComponent.serviceType</code> attribute. 
	 * @param value the serviceType
	 */
	public void setServiceType(final String value)
	{
		setServiceType( getSession().getSessionContext(), value );
	}
	
}
