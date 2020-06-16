/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jun 15, 2020 12:43:10 PM                    ---
 * ----------------------------------------------------------------
 */
package au.com.rejectshop.core.jalo.components;

import au.com.rejectshop.core.constants.RejectshopCoreConstants;
import de.hybris.platform.cms2lib.components.BannerComponent;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.JaloInvalidParameterException;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.c2l.C2LManager;
import de.hybris.platform.jalo.c2l.Language;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type {@link au.com.rejectshop.core.jalo.components.ProductBannerCMSComponent ProductBannerCMSComponent}.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedProductBannerCMSComponent extends BannerComponent
{
	/** Qualifier of the <code>ProductBannerCMSComponent.productName</code> attribute **/
	public static final String PRODUCTNAME = "productName";
	/** Qualifier of the <code>ProductBannerCMSComponent.productDesc</code> attribute **/
	public static final String PRODUCTDESC = "productDesc";
	/** Qualifier of the <code>ProductBannerCMSComponent.price</code> attribute **/
	public static final String PRICE = "price";
	/** Qualifier of the <code>ProductBannerCMSComponent.unit</code> attribute **/
	public static final String UNIT = "unit";
	/** Qualifier of the <code>ProductBannerCMSComponent.amountSaved</code> attribute **/
	public static final String AMOUNTSAVED = "amountSaved";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>(BannerComponent.DEFAULT_INITIAL_ATTRIBUTES);
		tmp.put(PRODUCTNAME, AttributeMode.INITIAL);
		tmp.put(PRODUCTDESC, AttributeMode.INITIAL);
		tmp.put(PRICE, AttributeMode.INITIAL);
		tmp.put(UNIT, AttributeMode.INITIAL);
		tmp.put(AMOUNTSAVED, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ProductBannerCMSComponent.amountSaved</code> attribute.
	 * @return the amountSaved - Amount saved on the product, if any.
	 */
	public String getAmountSaved(final SessionContext ctx)
	{
		return (String)getProperty( ctx, AMOUNTSAVED);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ProductBannerCMSComponent.amountSaved</code> attribute.
	 * @return the amountSaved - Amount saved on the product, if any.
	 */
	public String getAmountSaved()
	{
		return getAmountSaved( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ProductBannerCMSComponent.amountSaved</code> attribute. 
	 * @param value the amountSaved - Amount saved on the product, if any.
	 */
	public void setAmountSaved(final SessionContext ctx, final String value)
	{
		setProperty(ctx, AMOUNTSAVED,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ProductBannerCMSComponent.amountSaved</code> attribute. 
	 * @param value the amountSaved - Amount saved on the product, if any.
	 */
	public void setAmountSaved(final String value)
	{
		setAmountSaved( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ProductBannerCMSComponent.price</code> attribute.
	 * @return the price - Price of the product.
	 */
	public String getPrice(final SessionContext ctx)
	{
		return (String)getProperty( ctx, PRICE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ProductBannerCMSComponent.price</code> attribute.
	 * @return the price - Price of the product.
	 */
	public String getPrice()
	{
		return getPrice( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ProductBannerCMSComponent.price</code> attribute. 
	 * @param value the price - Price of the product.
	 */
	public void setPrice(final SessionContext ctx, final String value)
	{
		setProperty(ctx, PRICE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ProductBannerCMSComponent.price</code> attribute. 
	 * @param value the price - Price of the product.
	 */
	public void setPrice(final String value)
	{
		setPrice( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ProductBannerCMSComponent.productDesc</code> attribute.
	 * @return the productDesc - Localized name of the product to be displayed in the component.
	 */
	public String getProductDesc(final SessionContext ctx)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedProductBannerCMSComponent.getProductDesc requires a session language", 0 );
		}
		return (String)getLocalizedProperty( ctx, PRODUCTDESC);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ProductBannerCMSComponent.productDesc</code> attribute.
	 * @return the productDesc - Localized name of the product to be displayed in the component.
	 */
	public String getProductDesc()
	{
		return getProductDesc( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ProductBannerCMSComponent.productDesc</code> attribute. 
	 * @return the localized productDesc - Localized name of the product to be displayed in the component.
	 */
	public Map<Language,String> getAllProductDesc(final SessionContext ctx)
	{
		return (Map<Language,String>)getAllLocalizedProperties(ctx,PRODUCTDESC,C2LManager.getInstance().getAllLanguages());
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ProductBannerCMSComponent.productDesc</code> attribute. 
	 * @return the localized productDesc - Localized name of the product to be displayed in the component.
	 */
	public Map<Language,String> getAllProductDesc()
	{
		return getAllProductDesc( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ProductBannerCMSComponent.productDesc</code> attribute. 
	 * @param value the productDesc - Localized name of the product to be displayed in the component.
	 */
	public void setProductDesc(final SessionContext ctx, final String value)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedProductBannerCMSComponent.setProductDesc requires a session language", 0 );
		}
		setLocalizedProperty(ctx, PRODUCTDESC,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ProductBannerCMSComponent.productDesc</code> attribute. 
	 * @param value the productDesc - Localized name of the product to be displayed in the component.
	 */
	public void setProductDesc(final String value)
	{
		setProductDesc( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ProductBannerCMSComponent.productDesc</code> attribute. 
	 * @param value the productDesc - Localized name of the product to be displayed in the component.
	 */
	public void setAllProductDesc(final SessionContext ctx, final Map<Language,String> value)
	{
		setAllLocalizedProperties(ctx,PRODUCTDESC,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ProductBannerCMSComponent.productDesc</code> attribute. 
	 * @param value the productDesc - Localized name of the product to be displayed in the component.
	 */
	public void setAllProductDesc(final Map<Language,String> value)
	{
		setAllProductDesc( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ProductBannerCMSComponent.productName</code> attribute.
	 * @return the productName - Localized name of the product to be displayed in the component.
	 */
	public String getProductName(final SessionContext ctx)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedProductBannerCMSComponent.getProductName requires a session language", 0 );
		}
		return (String)getLocalizedProperty( ctx, PRODUCTNAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ProductBannerCMSComponent.productName</code> attribute.
	 * @return the productName - Localized name of the product to be displayed in the component.
	 */
	public String getProductName()
	{
		return getProductName( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ProductBannerCMSComponent.productName</code> attribute. 
	 * @return the localized productName - Localized name of the product to be displayed in the component.
	 */
	public Map<Language,String> getAllProductName(final SessionContext ctx)
	{
		return (Map<Language,String>)getAllLocalizedProperties(ctx,PRODUCTNAME,C2LManager.getInstance().getAllLanguages());
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ProductBannerCMSComponent.productName</code> attribute. 
	 * @return the localized productName - Localized name of the product to be displayed in the component.
	 */
	public Map<Language,String> getAllProductName()
	{
		return getAllProductName( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ProductBannerCMSComponent.productName</code> attribute. 
	 * @param value the productName - Localized name of the product to be displayed in the component.
	 */
	public void setProductName(final SessionContext ctx, final String value)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedProductBannerCMSComponent.setProductName requires a session language", 0 );
		}
		setLocalizedProperty(ctx, PRODUCTNAME,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ProductBannerCMSComponent.productName</code> attribute. 
	 * @param value the productName - Localized name of the product to be displayed in the component.
	 */
	public void setProductName(final String value)
	{
		setProductName( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ProductBannerCMSComponent.productName</code> attribute. 
	 * @param value the productName - Localized name of the product to be displayed in the component.
	 */
	public void setAllProductName(final SessionContext ctx, final Map<Language,String> value)
	{
		setAllLocalizedProperties(ctx,PRODUCTNAME,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ProductBannerCMSComponent.productName</code> attribute. 
	 * @param value the productName - Localized name of the product to be displayed in the component.
	 */
	public void setAllProductName(final Map<Language,String> value)
	{
		setAllProductName( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ProductBannerCMSComponent.unit</code> attribute.
	 * @return the unit - Unit of the product.
	 */
	public String getUnit(final SessionContext ctx)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedProductBannerCMSComponent.getUnit requires a session language", 0 );
		}
		return (String)getLocalizedProperty( ctx, UNIT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ProductBannerCMSComponent.unit</code> attribute.
	 * @return the unit - Unit of the product.
	 */
	public String getUnit()
	{
		return getUnit( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ProductBannerCMSComponent.unit</code> attribute. 
	 * @return the localized unit - Unit of the product.
	 */
	public Map<Language,String> getAllUnit(final SessionContext ctx)
	{
		return (Map<Language,String>)getAllLocalizedProperties(ctx,UNIT,C2LManager.getInstance().getAllLanguages());
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ProductBannerCMSComponent.unit</code> attribute. 
	 * @return the localized unit - Unit of the product.
	 */
	public Map<Language,String> getAllUnit()
	{
		return getAllUnit( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ProductBannerCMSComponent.unit</code> attribute. 
	 * @param value the unit - Unit of the product.
	 */
	public void setUnit(final SessionContext ctx, final String value)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedProductBannerCMSComponent.setUnit requires a session language", 0 );
		}
		setLocalizedProperty(ctx, UNIT,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ProductBannerCMSComponent.unit</code> attribute. 
	 * @param value the unit - Unit of the product.
	 */
	public void setUnit(final String value)
	{
		setUnit( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ProductBannerCMSComponent.unit</code> attribute. 
	 * @param value the unit - Unit of the product.
	 */
	public void setAllUnit(final SessionContext ctx, final Map<Language,String> value)
	{
		setAllLocalizedProperties(ctx,UNIT,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ProductBannerCMSComponent.unit</code> attribute. 
	 * @param value the unit - Unit of the product.
	 */
	public void setAllUnit(final Map<Language,String> value)
	{
		setAllUnit( getSession().getSessionContext(), value );
	}
	
}
