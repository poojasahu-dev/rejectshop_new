/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jun 15, 2020 12:43:10 PM                    ---
 * ----------------------------------------------------------------
 */
package au.com.rejectshop.core.jalo.components;

import au.com.rejectshop.core.constants.RejectshopCoreConstants;
import au.com.rejectshop.core.jalo.components.ProductBannerCMSComponent;
import de.hybris.platform.cms2.jalo.contents.components.SimpleCMSComponent;
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
 * Generated class for type {@link au.com.rejectshop.core.jalo.components.FeaturedProductsComponent FeaturedProductsComponent}.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedFeaturedProductsComponent extends SimpleCMSComponent
{
	/** Qualifier of the <code>FeaturedProductsComponent.title</code> attribute **/
	public static final String TITLE = "title";
	/** Qualifier of the <code>FeaturedProductsComponent.featuredProducts</code> attribute **/
	public static final String FEATUREDPRODUCTS = "featuredProducts";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>(SimpleCMSComponent.DEFAULT_INITIAL_ATTRIBUTES);
		tmp.put(TITLE, AttributeMode.INITIAL);
		tmp.put(FEATUREDPRODUCTS, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>FeaturedProductsComponent.featuredProducts</code> attribute.
	 * @return the featuredProducts - List of products to be rendered in this component.
	 */
	public List<ProductBannerCMSComponent> getFeaturedProducts(final SessionContext ctx)
	{
		List<ProductBannerCMSComponent> coll = (List<ProductBannerCMSComponent>)getProperty( ctx, FEATUREDPRODUCTS);
		return coll != null ? coll : Collections.EMPTY_LIST;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>FeaturedProductsComponent.featuredProducts</code> attribute.
	 * @return the featuredProducts - List of products to be rendered in this component.
	 */
	public List<ProductBannerCMSComponent> getFeaturedProducts()
	{
		return getFeaturedProducts( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>FeaturedProductsComponent.featuredProducts</code> attribute. 
	 * @param value the featuredProducts - List of products to be rendered in this component.
	 */
	public void setFeaturedProducts(final SessionContext ctx, final List<ProductBannerCMSComponent> value)
	{
		setProperty(ctx, FEATUREDPRODUCTS,value == null || !value.isEmpty() ? value : null );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>FeaturedProductsComponent.featuredProducts</code> attribute. 
	 * @param value the featuredProducts - List of products to be rendered in this component.
	 */
	public void setFeaturedProducts(final List<ProductBannerCMSComponent> value)
	{
		setFeaturedProducts( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>FeaturedProductsComponent.title</code> attribute.
	 * @return the title - Localized title of the component to be displayed.
	 */
	public String getTitle(final SessionContext ctx)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedFeaturedProductsComponent.getTitle requires a session language", 0 );
		}
		return (String)getLocalizedProperty( ctx, TITLE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>FeaturedProductsComponent.title</code> attribute.
	 * @return the title - Localized title of the component to be displayed.
	 */
	public String getTitle()
	{
		return getTitle( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>FeaturedProductsComponent.title</code> attribute. 
	 * @return the localized title - Localized title of the component to be displayed.
	 */
	public Map<Language,String> getAllTitle(final SessionContext ctx)
	{
		return (Map<Language,String>)getAllLocalizedProperties(ctx,TITLE,C2LManager.getInstance().getAllLanguages());
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>FeaturedProductsComponent.title</code> attribute. 
	 * @return the localized title - Localized title of the component to be displayed.
	 */
	public Map<Language,String> getAllTitle()
	{
		return getAllTitle( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>FeaturedProductsComponent.title</code> attribute. 
	 * @param value the title - Localized title of the component to be displayed.
	 */
	public void setTitle(final SessionContext ctx, final String value)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedFeaturedProductsComponent.setTitle requires a session language", 0 );
		}
		setLocalizedProperty(ctx, TITLE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>FeaturedProductsComponent.title</code> attribute. 
	 * @param value the title - Localized title of the component to be displayed.
	 */
	public void setTitle(final String value)
	{
		setTitle( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>FeaturedProductsComponent.title</code> attribute. 
	 * @param value the title - Localized title of the component to be displayed.
	 */
	public void setAllTitle(final SessionContext ctx, final Map<Language,String> value)
	{
		setAllLocalizedProperties(ctx,TITLE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>FeaturedProductsComponent.title</code> attribute. 
	 * @param value the title - Localized title of the component to be displayed.
	 */
	public void setAllTitle(final Map<Language,String> value)
	{
		setAllTitle( getSession().getSessionContext(), value );
	}
	
}
