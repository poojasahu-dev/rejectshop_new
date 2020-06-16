/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jun 15, 2020 12:43:10 PM                    ---
 * ----------------------------------------------------------------
 */
package au.com.rejectshop.core.jalo;

import au.com.rejectshop.core.constants.RejectshopCoreConstants;
import au.com.rejectshop.core.jalo.RejectCMSComponent;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type {@link au.com.rejectshop.core.jalo.CMSComponentContainer CMSComponentContainer}.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedCMSComponentContainer extends RejectCMSComponent
{
	/** Qualifier of the <code>CMSComponentContainer.layout</code> attribute **/
	public static final String LAYOUT = "layout";
	/** Qualifier of the <code>CMSComponentContainer.external</code> attribute **/
	public static final String EXTERNAL = "external";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>(RejectCMSComponent.DEFAULT_INITIAL_ATTRIBUTES);
		tmp.put(LAYOUT, AttributeMode.INITIAL);
		tmp.put(EXTERNAL, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSComponentContainer.external</code> attribute.
	 * @return the external
	 */
	public Boolean isExternal(final SessionContext ctx)
	{
		return (Boolean)getProperty( ctx, EXTERNAL);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSComponentContainer.external</code> attribute.
	 * @return the external
	 */
	public Boolean isExternal()
	{
		return isExternal( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSComponentContainer.external</code> attribute. 
	 * @return the external
	 */
	public boolean isExternalAsPrimitive(final SessionContext ctx)
	{
		Boolean value = isExternal( ctx );
		return value != null ? value.booleanValue() : false;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSComponentContainer.external</code> attribute. 
	 * @return the external
	 */
	public boolean isExternalAsPrimitive()
	{
		return isExternalAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CMSComponentContainer.external</code> attribute. 
	 * @param value the external
	 */
	public void setExternal(final SessionContext ctx, final Boolean value)
	{
		setProperty(ctx, EXTERNAL,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CMSComponentContainer.external</code> attribute. 
	 * @param value the external
	 */
	public void setExternal(final Boolean value)
	{
		setExternal( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CMSComponentContainer.external</code> attribute. 
	 * @param value the external
	 */
	public void setExternal(final SessionContext ctx, final boolean value)
	{
		setExternal( ctx,Boolean.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CMSComponentContainer.external</code> attribute. 
	 * @param value the external
	 */
	public void setExternal(final boolean value)
	{
		setExternal( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSComponentContainer.layout</code> attribute.
	 * @return the layout
	 */
	public String getLayout(final SessionContext ctx)
	{
		return (String)getProperty( ctx, LAYOUT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSComponentContainer.layout</code> attribute.
	 * @return the layout
	 */
	public String getLayout()
	{
		return getLayout( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CMSComponentContainer.layout</code> attribute. 
	 * @param value the layout
	 */
	public void setLayout(final SessionContext ctx, final String value)
	{
		setProperty(ctx, LAYOUT,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CMSComponentContainer.layout</code> attribute. 
	 * @param value the layout
	 */
	public void setLayout(final String value)
	{
		setLayout( getSession().getSessionContext(), value );
	}
	
}
