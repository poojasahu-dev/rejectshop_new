/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jun 15, 2020 12:43:10 PM                    ---
 * ----------------------------------------------------------------
 */
package com.paypal.hybris.jalo;

import com.paypal.hybris.constants.PaypalConstants;
import de.hybris.platform.jalo.GenericItem;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.order.AbstractOrderEntry;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type {@link de.hybris.platform.jalo.GenericItem PaypalPartialRefundEntry}.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedPaypalPartialRefundEntry extends GenericItem
{
	/** Qualifier of the <code>PaypalPartialRefundEntry.orderEntry</code> attribute **/
	public static final String ORDERENTRY = "orderEntry";
	/** Qualifier of the <code>PaypalPartialRefundEntry.percentRefuntValue</code> attribute **/
	public static final String PERCENTREFUNTVALUE = "percentRefuntValue";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>();
		tmp.put(ORDERENTRY, AttributeMode.INITIAL);
		tmp.put(PERCENTREFUNTVALUE, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PaypalPartialRefundEntry.orderEntry</code> attribute.
	 * @return the orderEntry
	 */
	public AbstractOrderEntry getOrderEntry(final SessionContext ctx)
	{
		return (AbstractOrderEntry)getProperty( ctx, ORDERENTRY);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PaypalPartialRefundEntry.orderEntry</code> attribute.
	 * @return the orderEntry
	 */
	public AbstractOrderEntry getOrderEntry()
	{
		return getOrderEntry( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PaypalPartialRefundEntry.orderEntry</code> attribute. 
	 * @param value the orderEntry
	 */
	public void setOrderEntry(final SessionContext ctx, final AbstractOrderEntry value)
	{
		setProperty(ctx, ORDERENTRY,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PaypalPartialRefundEntry.orderEntry</code> attribute. 
	 * @param value the orderEntry
	 */
	public void setOrderEntry(final AbstractOrderEntry value)
	{
		setOrderEntry( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PaypalPartialRefundEntry.percentRefuntValue</code> attribute.
	 * @return the percentRefuntValue
	 */
	public Double getPercentRefuntValue(final SessionContext ctx)
	{
		return (Double)getProperty( ctx, PERCENTREFUNTVALUE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PaypalPartialRefundEntry.percentRefuntValue</code> attribute.
	 * @return the percentRefuntValue
	 */
	public Double getPercentRefuntValue()
	{
		return getPercentRefuntValue( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PaypalPartialRefundEntry.percentRefuntValue</code> attribute. 
	 * @return the percentRefuntValue
	 */
	public double getPercentRefuntValueAsPrimitive(final SessionContext ctx)
	{
		Double value = getPercentRefuntValue( ctx );
		return value != null ? value.doubleValue() : 0.0d;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PaypalPartialRefundEntry.percentRefuntValue</code> attribute. 
	 * @return the percentRefuntValue
	 */
	public double getPercentRefuntValueAsPrimitive()
	{
		return getPercentRefuntValueAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PaypalPartialRefundEntry.percentRefuntValue</code> attribute. 
	 * @param value the percentRefuntValue
	 */
	public void setPercentRefuntValue(final SessionContext ctx, final Double value)
	{
		setProperty(ctx, PERCENTREFUNTVALUE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PaypalPartialRefundEntry.percentRefuntValue</code> attribute. 
	 * @param value the percentRefuntValue
	 */
	public void setPercentRefuntValue(final Double value)
	{
		setPercentRefuntValue( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PaypalPartialRefundEntry.percentRefuntValue</code> attribute. 
	 * @param value the percentRefuntValue
	 */
	public void setPercentRefuntValue(final SessionContext ctx, final double value)
	{
		setPercentRefuntValue( ctx,Double.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PaypalPartialRefundEntry.percentRefuntValue</code> attribute. 
	 * @param value the percentRefuntValue
	 */
	public void setPercentRefuntValue(final double value)
	{
		setPercentRefuntValue( getSession().getSessionContext(), value );
	}
	
}
