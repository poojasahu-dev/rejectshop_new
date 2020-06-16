/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jun 15, 2020 12:43:10 PM                    ---
 * ----------------------------------------------------------------
 */
package au.com.rejectshop.core.jalo.components;

import au.com.rejectshop.core.constants.RejectshopCoreConstants;
import de.hybris.platform.cms2lib.components.ProductCarouselComponent;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type {@link au.com.rejectshop.core.jalo.components.TRSCategoryCarouselComponent TRSCategoryCarouselComponent}.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedTRSCategoryCarouselComponent extends ProductCarouselComponent
{
	/** Qualifier of the <code>TRSCategoryCarouselComponent.maxLimit</code> attribute **/
	public static final String MAXLIMIT = "maxLimit";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>(ProductCarouselComponent.DEFAULT_INITIAL_ATTRIBUTES);
		tmp.put(MAXLIMIT, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>TRSCategoryCarouselComponent.maxLimit</code> attribute.
	 * @return the maxLimit - for maximum no of products in carousel
	 */
	public Integer getMaxLimit(final SessionContext ctx)
	{
		return (Integer)getProperty( ctx, MAXLIMIT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>TRSCategoryCarouselComponent.maxLimit</code> attribute.
	 * @return the maxLimit - for maximum no of products in carousel
	 */
	public Integer getMaxLimit()
	{
		return getMaxLimit( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>TRSCategoryCarouselComponent.maxLimit</code> attribute. 
	 * @return the maxLimit - for maximum no of products in carousel
	 */
	public int getMaxLimitAsPrimitive(final SessionContext ctx)
	{
		Integer value = getMaxLimit( ctx );
		return value != null ? value.intValue() : 0;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>TRSCategoryCarouselComponent.maxLimit</code> attribute. 
	 * @return the maxLimit - for maximum no of products in carousel
	 */
	public int getMaxLimitAsPrimitive()
	{
		return getMaxLimitAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>TRSCategoryCarouselComponent.maxLimit</code> attribute. 
	 * @param value the maxLimit - for maximum no of products in carousel
	 */
	public void setMaxLimit(final SessionContext ctx, final Integer value)
	{
		setProperty(ctx, MAXLIMIT,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>TRSCategoryCarouselComponent.maxLimit</code> attribute. 
	 * @param value the maxLimit - for maximum no of products in carousel
	 */
	public void setMaxLimit(final Integer value)
	{
		setMaxLimit( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>TRSCategoryCarouselComponent.maxLimit</code> attribute. 
	 * @param value the maxLimit - for maximum no of products in carousel
	 */
	public void setMaxLimit(final SessionContext ctx, final int value)
	{
		setMaxLimit( ctx,Integer.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>TRSCategoryCarouselComponent.maxLimit</code> attribute. 
	 * @param value the maxLimit - for maximum no of products in carousel
	 */
	public void setMaxLimit(final int value)
	{
		setMaxLimit( getSession().getSessionContext(), value );
	}
	
}
