/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jun 15, 2020 12:43:10 PM                    ---
 * ----------------------------------------------------------------
 */
package au.com.rejectshop.core.jalo;

import au.com.rejectshop.core.constants.RejectshopCoreConstants;
import de.hybris.platform.cms2.jalo.contents.components.SimpleCMSComponent;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.util.Utilities;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Generated class for type {@link au.com.rejectshop.core.jalo.RejectCMSComponent RejectCMSComponent}.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedRejectCMSComponent extends SimpleCMSComponent
{
	/** Qualifier of the <code>RejectCMSComponent.title</code> attribute **/
	public static final String TITLE = "title";
	/** Qualifier of the <code>RejectCMSComponent.cmsComponents</code> attribute **/
	public static final String CMSCOMPONENTS = "cmsComponents";
	/** Relation ordering override parameter constants for ComponentsForRejCMSComponent from ((rejectshopcore))*/
	protected static String COMPONENTSFORREJCMSCOMPONENT_SRC_ORDERED = "relation.ComponentsForRejCMSComponent.source.ordered";
	protected static String COMPONENTSFORREJCMSCOMPONENT_TGT_ORDERED = "relation.ComponentsForRejCMSComponent.target.ordered";
	/** Relation disable markmodifed parameter constants for ComponentsForRejCMSComponent from ((rejectshopcore))*/
	protected static String COMPONENTSFORREJCMSCOMPONENT_MARKMODIFIED = "relation.ComponentsForRejCMSComponent.markmodified";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>(SimpleCMSComponent.DEFAULT_INITIAL_ATTRIBUTES);
		tmp.put(TITLE, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>RejectCMSComponent.cmsComponents</code> attribute.
	 * @return the cmsComponents
	 */
	public List<SimpleCMSComponent> getCmsComponents(final SessionContext ctx)
	{
		final List<SimpleCMSComponent> items = getLinkedItems( 
			ctx,
			true,
			RejectshopCoreConstants.Relations.COMPONENTSFORREJCMSCOMPONENT,
			"SimpleCMSComponent",
			null,
			Utilities.getRelationOrderingOverride(COMPONENTSFORREJCMSCOMPONENT_SRC_ORDERED, true),
			false
		);
		return items;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>RejectCMSComponent.cmsComponents</code> attribute.
	 * @return the cmsComponents
	 */
	public List<SimpleCMSComponent> getCmsComponents()
	{
		return getCmsComponents( getSession().getSessionContext() );
	}
	
	public long getCmsComponentsCount(final SessionContext ctx)
	{
		return getLinkedItemsCount(
			ctx,
			true,
			RejectshopCoreConstants.Relations.COMPONENTSFORREJCMSCOMPONENT,
			"SimpleCMSComponent",
			null
		);
	}
	
	public long getCmsComponentsCount()
	{
		return getCmsComponentsCount( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>RejectCMSComponent.cmsComponents</code> attribute. 
	 * @param value the cmsComponents
	 */
	public void setCmsComponents(final SessionContext ctx, final List<SimpleCMSComponent> value)
	{
		setLinkedItems( 
			ctx,
			true,
			RejectshopCoreConstants.Relations.COMPONENTSFORREJCMSCOMPONENT,
			null,
			value,
			Utilities.getRelationOrderingOverride(COMPONENTSFORREJCMSCOMPONENT_SRC_ORDERED, true),
			false,
			Utilities.getMarkModifiedOverride(COMPONENTSFORREJCMSCOMPONENT_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>RejectCMSComponent.cmsComponents</code> attribute. 
	 * @param value the cmsComponents
	 */
	public void setCmsComponents(final List<SimpleCMSComponent> value)
	{
		setCmsComponents( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to cmsComponents. 
	 * @param value the item to add to cmsComponents
	 */
	public void addToCmsComponents(final SessionContext ctx, final SimpleCMSComponent value)
	{
		addLinkedItems( 
			ctx,
			true,
			RejectshopCoreConstants.Relations.COMPONENTSFORREJCMSCOMPONENT,
			null,
			Collections.singletonList(value),
			Utilities.getRelationOrderingOverride(COMPONENTSFORREJCMSCOMPONENT_SRC_ORDERED, true),
			false,
			Utilities.getMarkModifiedOverride(COMPONENTSFORREJCMSCOMPONENT_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to cmsComponents. 
	 * @param value the item to add to cmsComponents
	 */
	public void addToCmsComponents(final SimpleCMSComponent value)
	{
		addToCmsComponents( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from cmsComponents. 
	 * @param value the item to remove from cmsComponents
	 */
	public void removeFromCmsComponents(final SessionContext ctx, final SimpleCMSComponent value)
	{
		removeLinkedItems( 
			ctx,
			true,
			RejectshopCoreConstants.Relations.COMPONENTSFORREJCMSCOMPONENT,
			null,
			Collections.singletonList(value),
			Utilities.getRelationOrderingOverride(COMPONENTSFORREJCMSCOMPONENT_SRC_ORDERED, true),
			false,
			Utilities.getMarkModifiedOverride(COMPONENTSFORREJCMSCOMPONENT_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from cmsComponents. 
	 * @param value the item to remove from cmsComponents
	 */
	public void removeFromCmsComponents(final SimpleCMSComponent value)
	{
		removeFromCmsComponents( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>RejectCMSComponent.title</code> attribute.
	 * @return the title
	 */
	public String getTitle(final SessionContext ctx)
	{
		return (String)getProperty( ctx, TITLE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>RejectCMSComponent.title</code> attribute.
	 * @return the title
	 */
	public String getTitle()
	{
		return getTitle( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>RejectCMSComponent.title</code> attribute. 
	 * @param value the title
	 */
	public void setTitle(final SessionContext ctx, final String value)
	{
		setProperty(ctx, TITLE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>RejectCMSComponent.title</code> attribute. 
	 * @param value the title
	 */
	public void setTitle(final String value)
	{
		setTitle( getSession().getSessionContext(), value );
	}
	
}
