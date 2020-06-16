/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jun 15, 2020 12:43:10 PM                    ---
 * ----------------------------------------------------------------
 */
package au.com.rejectshop.core.jalo;

import au.com.rejectshop.core.constants.RejectshopCoreConstants;
import au.com.rejectshop.core.jalo.REJRotatingImagesComponent;
import de.hybris.platform.acceleratorcms.jalo.components.SimpleResponsiveBannerComponent;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.util.Utilities;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Generated class for type {@link au.com.rejectshop.core.jalo.REJimpleResponsiveBannerComponent REJSimpleResponsiveBannerComponent}.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedREJimpleResponsiveBannerComponent extends SimpleResponsiveBannerComponent
{
	/** Qualifier of the <code>REJSimpleResponsiveBannerComponent.startTime</code> attribute **/
	public static final String STARTTIME = "startTime";
	/** Qualifier of the <code>REJSimpleResponsiveBannerComponent.endTime</code> attribute **/
	public static final String ENDTIME = "endTime";
	/** Qualifier of the <code>REJSimpleResponsiveBannerComponent.order</code> attribute **/
	public static final String ORDER = "order";
	/** Qualifier of the <code>REJSimpleResponsiveBannerComponent.rotatingComponent</code> attribute **/
	public static final String ROTATINGCOMPONENT = "rotatingComponent";
	/** Relation ordering override parameter constants for REJRotatingImagesComponentToResponsiveBanners from ((rejectshopcore))*/
	protected static String REJROTATINGIMAGESCOMPONENTTORESPONSIVEBANNERS_SRC_ORDERED = "relation.REJRotatingImagesComponentToResponsiveBanners.source.ordered";
	protected static String REJROTATINGIMAGESCOMPONENTTORESPONSIVEBANNERS_TGT_ORDERED = "relation.REJRotatingImagesComponentToResponsiveBanners.target.ordered";
	/** Relation disable markmodifed parameter constants for REJRotatingImagesComponentToResponsiveBanners from ((rejectshopcore))*/
	protected static String REJROTATINGIMAGESCOMPONENTTORESPONSIVEBANNERS_MARKMODIFIED = "relation.REJRotatingImagesComponentToResponsiveBanners.markmodified";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>(SimpleResponsiveBannerComponent.DEFAULT_INITIAL_ATTRIBUTES);
		tmp.put(STARTTIME, AttributeMode.INITIAL);
		tmp.put(ENDTIME, AttributeMode.INITIAL);
		tmp.put(ORDER, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>REJSimpleResponsiveBannerComponent.endTime</code> attribute.
	 * @return the endTime - End Time
	 */
	public Date getEndTime(final SessionContext ctx)
	{
		return (Date)getProperty( ctx, ENDTIME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>REJSimpleResponsiveBannerComponent.endTime</code> attribute.
	 * @return the endTime - End Time
	 */
	public Date getEndTime()
	{
		return getEndTime( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>REJSimpleResponsiveBannerComponent.endTime</code> attribute. 
	 * @param value the endTime - End Time
	 */
	public void setEndTime(final SessionContext ctx, final Date value)
	{
		setProperty(ctx, ENDTIME,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>REJSimpleResponsiveBannerComponent.endTime</code> attribute. 
	 * @param value the endTime - End Time
	 */
	public void setEndTime(final Date value)
	{
		setEndTime( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>REJSimpleResponsiveBannerComponent.order</code> attribute.
	 * @return the order - Order Value
	 */
	public Integer getOrder(final SessionContext ctx)
	{
		return (Integer)getProperty( ctx, ORDER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>REJSimpleResponsiveBannerComponent.order</code> attribute.
	 * @return the order - Order Value
	 */
	public Integer getOrder()
	{
		return getOrder( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>REJSimpleResponsiveBannerComponent.order</code> attribute. 
	 * @return the order - Order Value
	 */
	public int getOrderAsPrimitive(final SessionContext ctx)
	{
		Integer value = getOrder( ctx );
		return value != null ? value.intValue() : 0;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>REJSimpleResponsiveBannerComponent.order</code> attribute. 
	 * @return the order - Order Value
	 */
	public int getOrderAsPrimitive()
	{
		return getOrderAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>REJSimpleResponsiveBannerComponent.order</code> attribute. 
	 * @param value the order - Order Value
	 */
	public void setOrder(final SessionContext ctx, final Integer value)
	{
		setProperty(ctx, ORDER,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>REJSimpleResponsiveBannerComponent.order</code> attribute. 
	 * @param value the order - Order Value
	 */
	public void setOrder(final Integer value)
	{
		setOrder( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>REJSimpleResponsiveBannerComponent.order</code> attribute. 
	 * @param value the order - Order Value
	 */
	public void setOrder(final SessionContext ctx, final int value)
	{
		setOrder( ctx,Integer.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>REJSimpleResponsiveBannerComponent.order</code> attribute. 
	 * @param value the order - Order Value
	 */
	public void setOrder(final int value)
	{
		setOrder( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>REJSimpleResponsiveBannerComponent.rotatingComponent</code> attribute.
	 * @return the rotatingComponent
	 */
	public Collection<REJRotatingImagesComponent> getRotatingComponent(final SessionContext ctx)
	{
		final List<REJRotatingImagesComponent> items = getLinkedItems( 
			ctx,
			false,
			RejectshopCoreConstants.Relations.REJROTATINGIMAGESCOMPONENTTORESPONSIVEBANNERS,
			"REJRotatingImagesComponent",
			null,
			Utilities.getRelationOrderingOverride(REJROTATINGIMAGESCOMPONENTTORESPONSIVEBANNERS_SRC_ORDERED, true),
			false
		);
		return items;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>REJSimpleResponsiveBannerComponent.rotatingComponent</code> attribute.
	 * @return the rotatingComponent
	 */
	public Collection<REJRotatingImagesComponent> getRotatingComponent()
	{
		return getRotatingComponent( getSession().getSessionContext() );
	}
	
	public long getRotatingComponentCount(final SessionContext ctx)
	{
		return getLinkedItemsCount(
			ctx,
			false,
			RejectshopCoreConstants.Relations.REJROTATINGIMAGESCOMPONENTTORESPONSIVEBANNERS,
			"REJRotatingImagesComponent",
			null
		);
	}
	
	public long getRotatingComponentCount()
	{
		return getRotatingComponentCount( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>REJSimpleResponsiveBannerComponent.rotatingComponent</code> attribute. 
	 * @param value the rotatingComponent
	 */
	public void setRotatingComponent(final SessionContext ctx, final Collection<REJRotatingImagesComponent> value)
	{
		setLinkedItems( 
			ctx,
			false,
			RejectshopCoreConstants.Relations.REJROTATINGIMAGESCOMPONENTTORESPONSIVEBANNERS,
			null,
			value,
			Utilities.getRelationOrderingOverride(REJROTATINGIMAGESCOMPONENTTORESPONSIVEBANNERS_SRC_ORDERED, true),
			false,
			Utilities.getMarkModifiedOverride(REJROTATINGIMAGESCOMPONENTTORESPONSIVEBANNERS_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>REJSimpleResponsiveBannerComponent.rotatingComponent</code> attribute. 
	 * @param value the rotatingComponent
	 */
	public void setRotatingComponent(final Collection<REJRotatingImagesComponent> value)
	{
		setRotatingComponent( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to rotatingComponent. 
	 * @param value the item to add to rotatingComponent
	 */
	public void addToRotatingComponent(final SessionContext ctx, final REJRotatingImagesComponent value)
	{
		addLinkedItems( 
			ctx,
			false,
			RejectshopCoreConstants.Relations.REJROTATINGIMAGESCOMPONENTTORESPONSIVEBANNERS,
			null,
			Collections.singletonList(value),
			Utilities.getRelationOrderingOverride(REJROTATINGIMAGESCOMPONENTTORESPONSIVEBANNERS_SRC_ORDERED, true),
			false,
			Utilities.getMarkModifiedOverride(REJROTATINGIMAGESCOMPONENTTORESPONSIVEBANNERS_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to rotatingComponent. 
	 * @param value the item to add to rotatingComponent
	 */
	public void addToRotatingComponent(final REJRotatingImagesComponent value)
	{
		addToRotatingComponent( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from rotatingComponent. 
	 * @param value the item to remove from rotatingComponent
	 */
	public void removeFromRotatingComponent(final SessionContext ctx, final REJRotatingImagesComponent value)
	{
		removeLinkedItems( 
			ctx,
			false,
			RejectshopCoreConstants.Relations.REJROTATINGIMAGESCOMPONENTTORESPONSIVEBANNERS,
			null,
			Collections.singletonList(value),
			Utilities.getRelationOrderingOverride(REJROTATINGIMAGESCOMPONENTTORESPONSIVEBANNERS_SRC_ORDERED, true),
			false,
			Utilities.getMarkModifiedOverride(REJROTATINGIMAGESCOMPONENTTORESPONSIVEBANNERS_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from rotatingComponent. 
	 * @param value the item to remove from rotatingComponent
	 */
	public void removeFromRotatingComponent(final REJRotatingImagesComponent value)
	{
		removeFromRotatingComponent( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>REJSimpleResponsiveBannerComponent.startTime</code> attribute.
	 * @return the startTime - Start Time.
	 */
	public Date getStartTime(final SessionContext ctx)
	{
		return (Date)getProperty( ctx, STARTTIME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>REJSimpleResponsiveBannerComponent.startTime</code> attribute.
	 * @return the startTime - Start Time.
	 */
	public Date getStartTime()
	{
		return getStartTime( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>REJSimpleResponsiveBannerComponent.startTime</code> attribute. 
	 * @param value the startTime - Start Time.
	 */
	public void setStartTime(final SessionContext ctx, final Date value)
	{
		setProperty(ctx, STARTTIME,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>REJSimpleResponsiveBannerComponent.startTime</code> attribute. 
	 * @param value the startTime - Start Time.
	 */
	public void setStartTime(final Date value)
	{
		setStartTime( getSession().getSessionContext(), value );
	}
	
}
