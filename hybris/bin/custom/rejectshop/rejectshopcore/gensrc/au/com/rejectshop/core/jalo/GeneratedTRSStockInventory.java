/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jun 15, 2020 12:43:10 PM                    ---
 * ----------------------------------------------------------------
 */
package au.com.rejectshop.core.jalo;

import au.com.rejectshop.core.constants.RejectshopCoreConstants;
import de.hybris.platform.jalo.GenericItem;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.product.Product;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type {@link au.com.rejectshop.core.jalo.TRSStockInventory TRSStockInventory}.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedTRSStockInventory extends GenericItem
{
	/** Qualifier of the <code>TRSStockInventory.code</code> attribute **/
	public static final String CODE = "code";
	/** Qualifier of the <code>TRSStockInventory.locationCode</code> attribute **/
	public static final String LOCATIONCODE = "locationCode";
	/** Qualifier of the <code>TRSStockInventory.product</code> attribute **/
	public static final String PRODUCT = "product";
	/** Qualifier of the <code>TRSStockInventory.sohUnit</code> attribute **/
	public static final String SOHUNIT = "sohUnit";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>();
		tmp.put(CODE, AttributeMode.INITIAL);
		tmp.put(LOCATIONCODE, AttributeMode.INITIAL);
		tmp.put(PRODUCT, AttributeMode.INITIAL);
		tmp.put(SOHUNIT, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>TRSStockInventory.code</code> attribute.
	 * @return the code
	 */
	public String getCode(final SessionContext ctx)
	{
		return (String)getProperty( ctx, CODE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>TRSStockInventory.code</code> attribute.
	 * @return the code
	 */
	public String getCode()
	{
		return getCode( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>TRSStockInventory.code</code> attribute. 
	 * @param value the code
	 */
	public void setCode(final SessionContext ctx, final String value)
	{
		setProperty(ctx, CODE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>TRSStockInventory.code</code> attribute. 
	 * @param value the code
	 */
	public void setCode(final String value)
	{
		setCode( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>TRSStockInventory.locationCode</code> attribute.
	 * @return the locationCode
	 */
	public Integer getLocationCode(final SessionContext ctx)
	{
		return (Integer)getProperty( ctx, LOCATIONCODE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>TRSStockInventory.locationCode</code> attribute.
	 * @return the locationCode
	 */
	public Integer getLocationCode()
	{
		return getLocationCode( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>TRSStockInventory.locationCode</code> attribute. 
	 * @return the locationCode
	 */
	public int getLocationCodeAsPrimitive(final SessionContext ctx)
	{
		Integer value = getLocationCode( ctx );
		return value != null ? value.intValue() : 0;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>TRSStockInventory.locationCode</code> attribute. 
	 * @return the locationCode
	 */
	public int getLocationCodeAsPrimitive()
	{
		return getLocationCodeAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>TRSStockInventory.locationCode</code> attribute. 
	 * @param value the locationCode
	 */
	public void setLocationCode(final SessionContext ctx, final Integer value)
	{
		setProperty(ctx, LOCATIONCODE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>TRSStockInventory.locationCode</code> attribute. 
	 * @param value the locationCode
	 */
	public void setLocationCode(final Integer value)
	{
		setLocationCode( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>TRSStockInventory.locationCode</code> attribute. 
	 * @param value the locationCode
	 */
	public void setLocationCode(final SessionContext ctx, final int value)
	{
		setLocationCode( ctx,Integer.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>TRSStockInventory.locationCode</code> attribute. 
	 * @param value the locationCode
	 */
	public void setLocationCode(final int value)
	{
		setLocationCode( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>TRSStockInventory.product</code> attribute.
	 * @return the product
	 */
	public Product getProduct(final SessionContext ctx)
	{
		return (Product)getProperty( ctx, PRODUCT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>TRSStockInventory.product</code> attribute.
	 * @return the product
	 */
	public Product getProduct()
	{
		return getProduct( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>TRSStockInventory.product</code> attribute. 
	 * @param value the product
	 */
	public void setProduct(final SessionContext ctx, final Product value)
	{
		setProperty(ctx, PRODUCT,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>TRSStockInventory.product</code> attribute. 
	 * @param value the product
	 */
	public void setProduct(final Product value)
	{
		setProduct( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>TRSStockInventory.sohUnit</code> attribute.
	 * @return the sohUnit
	 */
	public Integer getSohUnit(final SessionContext ctx)
	{
		return (Integer)getProperty( ctx, SOHUNIT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>TRSStockInventory.sohUnit</code> attribute.
	 * @return the sohUnit
	 */
	public Integer getSohUnit()
	{
		return getSohUnit( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>TRSStockInventory.sohUnit</code> attribute. 
	 * @return the sohUnit
	 */
	public int getSohUnitAsPrimitive(final SessionContext ctx)
	{
		Integer value = getSohUnit( ctx );
		return value != null ? value.intValue() : 0;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>TRSStockInventory.sohUnit</code> attribute. 
	 * @return the sohUnit
	 */
	public int getSohUnitAsPrimitive()
	{
		return getSohUnitAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>TRSStockInventory.sohUnit</code> attribute. 
	 * @param value the sohUnit
	 */
	public void setSohUnit(final SessionContext ctx, final Integer value)
	{
		setProperty(ctx, SOHUNIT,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>TRSStockInventory.sohUnit</code> attribute. 
	 * @param value the sohUnit
	 */
	public void setSohUnit(final Integer value)
	{
		setSohUnit( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>TRSStockInventory.sohUnit</code> attribute. 
	 * @param value the sohUnit
	 */
	public void setSohUnit(final SessionContext ctx, final int value)
	{
		setSohUnit( ctx,Integer.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>TRSStockInventory.sohUnit</code> attribute. 
	 * @param value the sohUnit
	 */
	public void setSohUnit(final int value)
	{
		setSohUnit( getSession().getSessionContext(), value );
	}
	
}
