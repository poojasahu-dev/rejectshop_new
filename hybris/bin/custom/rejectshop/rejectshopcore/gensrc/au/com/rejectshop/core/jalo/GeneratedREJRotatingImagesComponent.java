/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jun 15, 2020 12:43:10 PM                    ---
 * ----------------------------------------------------------------
 */
package au.com.rejectshop.core.jalo;

import au.com.rejectshop.core.constants.RejectshopCoreConstants;
import au.com.rejectshop.core.jalo.REJimpleResponsiveBannerComponent;
import de.hybris.platform.cms2lib.components.RotatingImagesComponent;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.util.Utilities;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Generated class for type {@link au.com.rejectshop.core.jalo.REJRotatingImagesComponent REJRotatingImagesComponent}.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedREJRotatingImagesComponent extends RotatingImagesComponent
{
	/** Qualifier of the <code>REJRotatingImagesComponent.responsiveBanners</code> attribute **/
	public static final String RESPONSIVEBANNERS = "responsiveBanners";
	/** Relation ordering override parameter constants for REJRotatingImagesComponentToResponsiveBanners from ((rejectshopcore))*/
	protected static String REJROTATINGIMAGESCOMPONENTTORESPONSIVEBANNERS_SRC_ORDERED = "relation.REJRotatingImagesComponentToResponsiveBanners.source.ordered";
	protected static String REJROTATINGIMAGESCOMPONENTTORESPONSIVEBANNERS_TGT_ORDERED = "relation.REJRotatingImagesComponentToResponsiveBanners.target.ordered";
	/** Relation disable markmodifed parameter constants for REJRotatingImagesComponentToResponsiveBanners from ((rejectshopcore))*/
	protected static String REJROTATINGIMAGESCOMPONENTTORESPONSIVEBANNERS_MARKMODIFIED = "relation.REJRotatingImagesComponentToResponsiveBanners.markmodified";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>(RotatingImagesComponent.DEFAULT_INITIAL_ATTRIBUTES);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>REJRotatingImagesComponent.responsiveBanners</code> attribute.
	 * @return the responsiveBanners
	 */
	public List<REJimpleResponsiveBannerComponent> getResponsiveBanners(final SessionContext ctx)
	{
		final List<REJimpleResponsiveBannerComponent> items = getLinkedItems( 
			ctx,
			true,
			RejectshopCoreConstants.Relations.REJROTATINGIMAGESCOMPONENTTORESPONSIVEBANNERS,
			"REJSimpleResponsiveBannerComponent",
			null,
			Utilities.getRelationOrderingOverride(REJROTATINGIMAGESCOMPONENTTORESPONSIVEBANNERS_SRC_ORDERED, true),
			false
		);
		return items;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>REJRotatingImagesComponent.responsiveBanners</code> attribute.
	 * @return the responsiveBanners
	 */
	public List<REJimpleResponsiveBannerComponent> getResponsiveBanners()
	{
		return getResponsiveBanners( getSession().getSessionContext() );
	}
	
	public long getResponsiveBannersCount(final SessionContext ctx)
	{
		return getLinkedItemsCount(
			ctx,
			true,
			RejectshopCoreConstants.Relations.REJROTATINGIMAGESCOMPONENTTORESPONSIVEBANNERS,
			"REJSimpleResponsiveBannerComponent",
			null
		);
	}
	
	public long getResponsiveBannersCount()
	{
		return getResponsiveBannersCount( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>REJRotatingImagesComponent.responsiveBanners</code> attribute. 
	 * @param value the responsiveBanners
	 */
	public void setResponsiveBanners(final SessionContext ctx, final List<REJimpleResponsiveBannerComponent> value)
	{
		setLinkedItems( 
			ctx,
			true,
			RejectshopCoreConstants.Relations.REJROTATINGIMAGESCOMPONENTTORESPONSIVEBANNERS,
			null,
			value,
			Utilities.getRelationOrderingOverride(REJROTATINGIMAGESCOMPONENTTORESPONSIVEBANNERS_SRC_ORDERED, true),
			false,
			Utilities.getMarkModifiedOverride(REJROTATINGIMAGESCOMPONENTTORESPONSIVEBANNERS_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>REJRotatingImagesComponent.responsiveBanners</code> attribute. 
	 * @param value the responsiveBanners
	 */
	public void setResponsiveBanners(final List<REJimpleResponsiveBannerComponent> value)
	{
		setResponsiveBanners( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to responsiveBanners. 
	 * @param value the item to add to responsiveBanners
	 */
	public void addToResponsiveBanners(final SessionContext ctx, final REJimpleResponsiveBannerComponent value)
	{
		addLinkedItems( 
			ctx,
			true,
			RejectshopCoreConstants.Relations.REJROTATINGIMAGESCOMPONENTTORESPONSIVEBANNERS,
			null,
			Collections.singletonList(value),
			Utilities.getRelationOrderingOverride(REJROTATINGIMAGESCOMPONENTTORESPONSIVEBANNERS_SRC_ORDERED, true),
			false,
			Utilities.getMarkModifiedOverride(REJROTATINGIMAGESCOMPONENTTORESPONSIVEBANNERS_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to responsiveBanners. 
	 * @param value the item to add to responsiveBanners
	 */
	public void addToResponsiveBanners(final REJimpleResponsiveBannerComponent value)
	{
		addToResponsiveBanners( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from responsiveBanners. 
	 * @param value the item to remove from responsiveBanners
	 */
	public void removeFromResponsiveBanners(final SessionContext ctx, final REJimpleResponsiveBannerComponent value)
	{
		removeLinkedItems( 
			ctx,
			true,
			RejectshopCoreConstants.Relations.REJROTATINGIMAGESCOMPONENTTORESPONSIVEBANNERS,
			null,
			Collections.singletonList(value),
			Utilities.getRelationOrderingOverride(REJROTATINGIMAGESCOMPONENTTORESPONSIVEBANNERS_SRC_ORDERED, true),
			false,
			Utilities.getMarkModifiedOverride(REJROTATINGIMAGESCOMPONENTTORESPONSIVEBANNERS_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from responsiveBanners. 
	 * @param value the item to remove from responsiveBanners
	 */
	public void removeFromResponsiveBanners(final REJimpleResponsiveBannerComponent value)
	{
		removeFromResponsiveBanners( getSession().getSessionContext(), value );
	}
	
}
