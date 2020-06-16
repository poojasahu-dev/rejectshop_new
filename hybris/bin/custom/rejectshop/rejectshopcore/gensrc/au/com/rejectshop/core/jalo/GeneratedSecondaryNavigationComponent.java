/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jun 15, 2020 12:43:10 PM                    ---
 * ----------------------------------------------------------------
 */
package au.com.rejectshop.core.jalo;

import au.com.rejectshop.core.constants.RejectshopCoreConstants;
import de.hybris.platform.cms2.jalo.contents.components.CMSLinkComponent;
import de.hybris.platform.cms2.jalo.contents.components.SimpleCMSComponent;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.util.Utilities;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Generated class for type {@link au.com.rejectshop.core.jalo.SecondaryNavigationComponent SecondaryNavigationComponent}.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedSecondaryNavigationComponent extends SimpleCMSComponent
{
	/** Qualifier of the <code>SecondaryNavigationComponent.link</code> attribute **/
	public static final String LINK = "link";
	/** Qualifier of the <code>SecondaryNavigationComponent.title</code> attribute **/
	public static final String TITLE = "title";
	/** Qualifier of the <code>SecondaryNavigationComponent.titleName</code> attribute **/
	public static final String TITLENAME = "titleName";
	/** Qualifier of the <code>SecondaryNavigationComponent.external</code> attribute **/
	public static final String EXTERNAL = "external";
	/** Qualifier of the <code>SecondaryNavigationComponent.links</code> attribute **/
	public static final String LINKS = "links";
	/** Relation ordering override parameter constants for ComponentsForSecondaryNavigationComponent from ((rejectshopcore))*/
	protected static String COMPONENTSFORSECONDARYNAVIGATIONCOMPONENT_SRC_ORDERED = "relation.ComponentsForSecondaryNavigationComponent.source.ordered";
	protected static String COMPONENTSFORSECONDARYNAVIGATIONCOMPONENT_TGT_ORDERED = "relation.ComponentsForSecondaryNavigationComponent.target.ordered";
	/** Relation disable markmodifed parameter constants for ComponentsForSecondaryNavigationComponent from ((rejectshopcore))*/
	protected static String COMPONENTSFORSECONDARYNAVIGATIONCOMPONENT_MARKMODIFIED = "relation.ComponentsForSecondaryNavigationComponent.markmodified";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>(SimpleCMSComponent.DEFAULT_INITIAL_ATTRIBUTES);
		tmp.put(LINK, AttributeMode.INITIAL);
		tmp.put(TITLE, AttributeMode.INITIAL);
		tmp.put(TITLENAME, AttributeMode.INITIAL);
		tmp.put(EXTERNAL, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SecondaryNavigationComponent.external</code> attribute.
	 * @return the external
	 */
	public Boolean isExternal(final SessionContext ctx)
	{
		return (Boolean)getProperty( ctx, EXTERNAL);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SecondaryNavigationComponent.external</code> attribute.
	 * @return the external
	 */
	public Boolean isExternal()
	{
		return isExternal( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SecondaryNavigationComponent.external</code> attribute. 
	 * @return the external
	 */
	public boolean isExternalAsPrimitive(final SessionContext ctx)
	{
		Boolean value = isExternal( ctx );
		return value != null ? value.booleanValue() : false;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SecondaryNavigationComponent.external</code> attribute. 
	 * @return the external
	 */
	public boolean isExternalAsPrimitive()
	{
		return isExternalAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SecondaryNavigationComponent.external</code> attribute. 
	 * @param value the external
	 */
	public void setExternal(final SessionContext ctx, final Boolean value)
	{
		setProperty(ctx, EXTERNAL,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SecondaryNavigationComponent.external</code> attribute. 
	 * @param value the external
	 */
	public void setExternal(final Boolean value)
	{
		setExternal( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SecondaryNavigationComponent.external</code> attribute. 
	 * @param value the external
	 */
	public void setExternal(final SessionContext ctx, final boolean value)
	{
		setExternal( ctx,Boolean.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SecondaryNavigationComponent.external</code> attribute. 
	 * @param value the external
	 */
	public void setExternal(final boolean value)
	{
		setExternal( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SecondaryNavigationComponent.link</code> attribute.
	 * @return the link
	 */
	public CMSLinkComponent getLink(final SessionContext ctx)
	{
		return (CMSLinkComponent)getProperty( ctx, LINK);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SecondaryNavigationComponent.link</code> attribute.
	 * @return the link
	 */
	public CMSLinkComponent getLink()
	{
		return getLink( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SecondaryNavigationComponent.link</code> attribute. 
	 * @param value the link
	 */
	public void setLink(final SessionContext ctx, final CMSLinkComponent value)
	{
		setProperty(ctx, LINK,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SecondaryNavigationComponent.link</code> attribute. 
	 * @param value the link
	 */
	public void setLink(final CMSLinkComponent value)
	{
		setLink( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SecondaryNavigationComponent.links</code> attribute.
	 * @return the links
	 */
	public List<CMSLinkComponent> getLinks(final SessionContext ctx)
	{
		final List<CMSLinkComponent> items = getLinkedItems( 
			ctx,
			true,
			RejectshopCoreConstants.Relations.COMPONENTSFORSECONDARYNAVIGATIONCOMPONENT,
			"CMSLinkComponent",
			null,
			Utilities.getRelationOrderingOverride(COMPONENTSFORSECONDARYNAVIGATIONCOMPONENT_SRC_ORDERED, true),
			false
		);
		return items;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SecondaryNavigationComponent.links</code> attribute.
	 * @return the links
	 */
	public List<CMSLinkComponent> getLinks()
	{
		return getLinks( getSession().getSessionContext() );
	}
	
	public long getLinksCount(final SessionContext ctx)
	{
		return getLinkedItemsCount(
			ctx,
			true,
			RejectshopCoreConstants.Relations.COMPONENTSFORSECONDARYNAVIGATIONCOMPONENT,
			"CMSLinkComponent",
			null
		);
	}
	
	public long getLinksCount()
	{
		return getLinksCount( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SecondaryNavigationComponent.links</code> attribute. 
	 * @param value the links
	 */
	public void setLinks(final SessionContext ctx, final List<CMSLinkComponent> value)
	{
		setLinkedItems( 
			ctx,
			true,
			RejectshopCoreConstants.Relations.COMPONENTSFORSECONDARYNAVIGATIONCOMPONENT,
			null,
			value,
			Utilities.getRelationOrderingOverride(COMPONENTSFORSECONDARYNAVIGATIONCOMPONENT_SRC_ORDERED, true),
			false,
			Utilities.getMarkModifiedOverride(COMPONENTSFORSECONDARYNAVIGATIONCOMPONENT_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SecondaryNavigationComponent.links</code> attribute. 
	 * @param value the links
	 */
	public void setLinks(final List<CMSLinkComponent> value)
	{
		setLinks( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to links. 
	 * @param value the item to add to links
	 */
	public void addToLinks(final SessionContext ctx, final CMSLinkComponent value)
	{
		addLinkedItems( 
			ctx,
			true,
			RejectshopCoreConstants.Relations.COMPONENTSFORSECONDARYNAVIGATIONCOMPONENT,
			null,
			Collections.singletonList(value),
			Utilities.getRelationOrderingOverride(COMPONENTSFORSECONDARYNAVIGATIONCOMPONENT_SRC_ORDERED, true),
			false,
			Utilities.getMarkModifiedOverride(COMPONENTSFORSECONDARYNAVIGATIONCOMPONENT_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to links. 
	 * @param value the item to add to links
	 */
	public void addToLinks(final CMSLinkComponent value)
	{
		addToLinks( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from links. 
	 * @param value the item to remove from links
	 */
	public void removeFromLinks(final SessionContext ctx, final CMSLinkComponent value)
	{
		removeLinkedItems( 
			ctx,
			true,
			RejectshopCoreConstants.Relations.COMPONENTSFORSECONDARYNAVIGATIONCOMPONENT,
			null,
			Collections.singletonList(value),
			Utilities.getRelationOrderingOverride(COMPONENTSFORSECONDARYNAVIGATIONCOMPONENT_SRC_ORDERED, true),
			false,
			Utilities.getMarkModifiedOverride(COMPONENTSFORSECONDARYNAVIGATIONCOMPONENT_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from links. 
	 * @param value the item to remove from links
	 */
	public void removeFromLinks(final CMSLinkComponent value)
	{
		removeFromLinks( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SecondaryNavigationComponent.title</code> attribute.
	 * @return the title
	 */
	public String getTitle(final SessionContext ctx)
	{
		return (String)getProperty( ctx, TITLE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SecondaryNavigationComponent.title</code> attribute.
	 * @return the title
	 */
	public String getTitle()
	{
		return getTitle( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SecondaryNavigationComponent.title</code> attribute. 
	 * @param value the title
	 */
	public void setTitle(final SessionContext ctx, final String value)
	{
		setProperty(ctx, TITLE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SecondaryNavigationComponent.title</code> attribute. 
	 * @param value the title
	 */
	public void setTitle(final String value)
	{
		setTitle( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SecondaryNavigationComponent.titleName</code> attribute.
	 * @return the titleName
	 */
	public String getTitleName(final SessionContext ctx)
	{
		return (String)getProperty( ctx, TITLENAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SecondaryNavigationComponent.titleName</code> attribute.
	 * @return the titleName
	 */
	public String getTitleName()
	{
		return getTitleName( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SecondaryNavigationComponent.titleName</code> attribute. 
	 * @param value the titleName
	 */
	public void setTitleName(final SessionContext ctx, final String value)
	{
		setProperty(ctx, TITLENAME,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SecondaryNavigationComponent.titleName</code> attribute. 
	 * @param value the titleName
	 */
	public void setTitleName(final String value)
	{
		setTitleName( getSession().getSessionContext(), value );
	}
	
}
