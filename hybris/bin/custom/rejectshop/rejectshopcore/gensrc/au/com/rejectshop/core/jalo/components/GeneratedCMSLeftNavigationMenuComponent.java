/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jun 15, 2020 12:43:10 PM                    ---
 * ----------------------------------------------------------------
 */
package au.com.rejectshop.core.jalo.components;

import au.com.rejectshop.core.constants.RejectshopCoreConstants;
import de.hybris.platform.cms2.jalo.contents.components.CMSLinkComponent;
import de.hybris.platform.cms2.jalo.contents.components.SimpleCMSComponent;
import de.hybris.platform.cms2.jalo.navigation.CMSNavigationNode;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.JaloInvalidParameterException;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.c2l.C2LManager;
import de.hybris.platform.jalo.c2l.Language;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Generated class for type {@link au.com.rejectshop.core.jalo.components.CMSLeftNavigationMenuComponent CMSLeftNavigationMenuComponent}.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedCMSLeftNavigationMenuComponent extends SimpleCMSComponent
{
	/** Qualifier of the <code>CMSLeftNavigationMenuComponent.title</code> attribute **/
	public static final String TITLE = "title";
	/** Qualifier of the <code>CMSLeftNavigationMenuComponent.navigationNodes</code> attribute **/
	public static final String NAVIGATIONNODES = "navigationNodes";
	/** Qualifier of the <code>CMSLeftNavigationMenuComponent.componentLink</code> attribute **/
	public static final String COMPONENTLINK = "componentLink";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>(SimpleCMSComponent.DEFAULT_INITIAL_ATTRIBUTES);
		tmp.put(TITLE, AttributeMode.INITIAL);
		tmp.put(NAVIGATIONNODES, AttributeMode.INITIAL);
		tmp.put(COMPONENTLINK, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSLeftNavigationMenuComponent.componentLink</code> attribute.
	 * @return the componentLink - Main Link of the component. This will be used as the root component breadcrumb.
	 */
	public CMSLinkComponent getComponentLink(final SessionContext ctx)
	{
		return (CMSLinkComponent)getProperty( ctx, COMPONENTLINK);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSLeftNavigationMenuComponent.componentLink</code> attribute.
	 * @return the componentLink - Main Link of the component. This will be used as the root component breadcrumb.
	 */
	public CMSLinkComponent getComponentLink()
	{
		return getComponentLink( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CMSLeftNavigationMenuComponent.componentLink</code> attribute. 
	 * @param value the componentLink - Main Link of the component. This will be used as the root component breadcrumb.
	 */
	public void setComponentLink(final SessionContext ctx, final CMSLinkComponent value)
	{
		setProperty(ctx, COMPONENTLINK,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CMSLeftNavigationMenuComponent.componentLink</code> attribute. 
	 * @param value the componentLink - Main Link of the component. This will be used as the root component breadcrumb.
	 */
	public void setComponentLink(final CMSLinkComponent value)
	{
		setComponentLink( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSLeftNavigationMenuComponent.navigationNodes</code> attribute.
	 * @return the navigationNodes - List of navigation nodes that are rendered in this navigation menu component.
	 */
	public List<CMSNavigationNode> getNavigationNodes(final SessionContext ctx)
	{
		List<CMSNavigationNode> coll = (List<CMSNavigationNode>)getProperty( ctx, NAVIGATIONNODES);
		return coll != null ? coll : Collections.EMPTY_LIST;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSLeftNavigationMenuComponent.navigationNodes</code> attribute.
	 * @return the navigationNodes - List of navigation nodes that are rendered in this navigation menu component.
	 */
	public List<CMSNavigationNode> getNavigationNodes()
	{
		return getNavigationNodes( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CMSLeftNavigationMenuComponent.navigationNodes</code> attribute. 
	 * @param value the navigationNodes - List of navigation nodes that are rendered in this navigation menu component.
	 */
	public void setNavigationNodes(final SessionContext ctx, final List<CMSNavigationNode> value)
	{
		setProperty(ctx, NAVIGATIONNODES,value == null || !value.isEmpty() ? value : null );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CMSLeftNavigationMenuComponent.navigationNodes</code> attribute. 
	 * @param value the navigationNodes - List of navigation nodes that are rendered in this navigation menu component.
	 */
	public void setNavigationNodes(final List<CMSNavigationNode> value)
	{
		setNavigationNodes( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSLeftNavigationMenuComponent.title</code> attribute.
	 * @return the title - CMS Link Info Navigation component be displayed with title.
	 */
	public String getTitle(final SessionContext ctx)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedCMSLeftNavigationMenuComponent.getTitle requires a session language", 0 );
		}
		return (String)getLocalizedProperty( ctx, TITLE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSLeftNavigationMenuComponent.title</code> attribute.
	 * @return the title - CMS Link Info Navigation component be displayed with title.
	 */
	public String getTitle()
	{
		return getTitle( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSLeftNavigationMenuComponent.title</code> attribute. 
	 * @return the localized title - CMS Link Info Navigation component be displayed with title.
	 */
	public Map<Language,String> getAllTitle(final SessionContext ctx)
	{
		return (Map<Language,String>)getAllLocalizedProperties(ctx,TITLE,C2LManager.getInstance().getAllLanguages());
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSLeftNavigationMenuComponent.title</code> attribute. 
	 * @return the localized title - CMS Link Info Navigation component be displayed with title.
	 */
	public Map<Language,String> getAllTitle()
	{
		return getAllTitle( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CMSLeftNavigationMenuComponent.title</code> attribute. 
	 * @param value the title - CMS Link Info Navigation component be displayed with title.
	 */
	public void setTitle(final SessionContext ctx, final String value)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedCMSLeftNavigationMenuComponent.setTitle requires a session language", 0 );
		}
		setLocalizedProperty(ctx, TITLE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CMSLeftNavigationMenuComponent.title</code> attribute. 
	 * @param value the title - CMS Link Info Navigation component be displayed with title.
	 */
	public void setTitle(final String value)
	{
		setTitle( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CMSLeftNavigationMenuComponent.title</code> attribute. 
	 * @param value the title - CMS Link Info Navigation component be displayed with title.
	 */
	public void setAllTitle(final SessionContext ctx, final Map<Language,String> value)
	{
		setAllLocalizedProperties(ctx,TITLE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CMSLeftNavigationMenuComponent.title</code> attribute. 
	 * @param value the title - CMS Link Info Navigation component be displayed with title.
	 */
	public void setAllTitle(final Map<Language,String> value)
	{
		setAllTitle( getSession().getSessionContext(), value );
	}
	
}
