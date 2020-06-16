/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jun 15, 2020 12:43:10 PM                    ---
 * ----------------------------------------------------------------
 */
package au.com.rejectshop.core.jalo.components;

import au.com.rejectshop.core.constants.RejectshopCoreConstants;
import de.hybris.platform.cms2.jalo.contents.components.SimpleCMSComponent;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type {@link au.com.rejectshop.core.jalo.components.StoreLocatorComponent StoreLocatorComponent}.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedStoreLocatorComponent extends SimpleCMSComponent
{
	/** Qualifier of the <code>StoreLocatorComponent.isMenu</code> attribute **/
	public static final String ISMENU = "isMenu";
	/** Qualifier of the <code>StoreLocatorComponent.displayTitle</code> attribute **/
	public static final String DISPLAYTITLE = "displayTitle";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>(SimpleCMSComponent.DEFAULT_INITIAL_ATTRIBUTES);
		tmp.put(ISMENU, AttributeMode.INITIAL);
		tmp.put(DISPLAYTITLE, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>StoreLocatorComponent.displayTitle</code> attribute.
	 * @return the displayTitle
	 */
	public Boolean isDisplayTitle(final SessionContext ctx)
	{
		return (Boolean)getProperty( ctx, DISPLAYTITLE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>StoreLocatorComponent.displayTitle</code> attribute.
	 * @return the displayTitle
	 */
	public Boolean isDisplayTitle()
	{
		return isDisplayTitle( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>StoreLocatorComponent.displayTitle</code> attribute. 
	 * @return the displayTitle
	 */
	public boolean isDisplayTitleAsPrimitive(final SessionContext ctx)
	{
		Boolean value = isDisplayTitle( ctx );
		return value != null ? value.booleanValue() : false;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>StoreLocatorComponent.displayTitle</code> attribute. 
	 * @return the displayTitle
	 */
	public boolean isDisplayTitleAsPrimitive()
	{
		return isDisplayTitleAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>StoreLocatorComponent.displayTitle</code> attribute. 
	 * @param value the displayTitle
	 */
	public void setDisplayTitle(final SessionContext ctx, final Boolean value)
	{
		setProperty(ctx, DISPLAYTITLE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>StoreLocatorComponent.displayTitle</code> attribute. 
	 * @param value the displayTitle
	 */
	public void setDisplayTitle(final Boolean value)
	{
		setDisplayTitle( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>StoreLocatorComponent.displayTitle</code> attribute. 
	 * @param value the displayTitle
	 */
	public void setDisplayTitle(final SessionContext ctx, final boolean value)
	{
		setDisplayTitle( ctx,Boolean.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>StoreLocatorComponent.displayTitle</code> attribute. 
	 * @param value the displayTitle
	 */
	public void setDisplayTitle(final boolean value)
	{
		setDisplayTitle( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>StoreLocatorComponent.isMenu</code> attribute.
	 * @return the isMenu
	 */
	public Boolean isIsMenu(final SessionContext ctx)
	{
		return (Boolean)getProperty( ctx, ISMENU);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>StoreLocatorComponent.isMenu</code> attribute.
	 * @return the isMenu
	 */
	public Boolean isIsMenu()
	{
		return isIsMenu( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>StoreLocatorComponent.isMenu</code> attribute. 
	 * @return the isMenu
	 */
	public boolean isIsMenuAsPrimitive(final SessionContext ctx)
	{
		Boolean value = isIsMenu( ctx );
		return value != null ? value.booleanValue() : false;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>StoreLocatorComponent.isMenu</code> attribute. 
	 * @return the isMenu
	 */
	public boolean isIsMenuAsPrimitive()
	{
		return isIsMenuAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>StoreLocatorComponent.isMenu</code> attribute. 
	 * @param value the isMenu
	 */
	public void setIsMenu(final SessionContext ctx, final Boolean value)
	{
		setProperty(ctx, ISMENU,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>StoreLocatorComponent.isMenu</code> attribute. 
	 * @param value the isMenu
	 */
	public void setIsMenu(final Boolean value)
	{
		setIsMenu( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>StoreLocatorComponent.isMenu</code> attribute. 
	 * @param value the isMenu
	 */
	public void setIsMenu(final SessionContext ctx, final boolean value)
	{
		setIsMenu( ctx,Boolean.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>StoreLocatorComponent.isMenu</code> attribute. 
	 * @param value the isMenu
	 */
	public void setIsMenu(final boolean value)
	{
		setIsMenu( getSession().getSessionContext(), value );
	}
	
}
