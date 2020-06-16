/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jun 15, 2020 12:43:10 PM                    ---
 * ----------------------------------------------------------------
 */
package au.com.rejectshop.core.jalo;

import au.com.rejectshop.core.components.AddThisComponent;
import au.com.rejectshop.core.constants.RejectshopCoreConstants;
import au.com.rejectshop.core.jalo.ApparelProduct;
import au.com.rejectshop.core.jalo.ApparelSizeVariantProduct;
import au.com.rejectshop.core.jalo.ApparelStyleVariantProduct;
import au.com.rejectshop.core.jalo.CMSComponentContainer;
import au.com.rejectshop.core.jalo.ElectronicsColorVariantProduct;
import au.com.rejectshop.core.jalo.REJECTHorizontalBanner;
import au.com.rejectshop.core.jalo.REJRotatingImagesComponent;
import au.com.rejectshop.core.jalo.REJimpleResponsiveBannerComponent;
import au.com.rejectshop.core.jalo.RejectCMSComponent;
import au.com.rejectshop.core.jalo.RejectSizeVariantProduct;
import au.com.rejectshop.core.jalo.RejectStyleVariantProduct;
import au.com.rejectshop.core.jalo.ReportMedia;
import au.com.rejectshop.core.jalo.SecondaryNavigationComponent;
import au.com.rejectshop.core.jalo.SendEmailReminder;
import au.com.rejectshop.core.jalo.TRSStockInventory;
import au.com.rejectshop.core.jalo.components.AccordionItemCMSComponent;
import au.com.rejectshop.core.jalo.components.BecomeVIPComponent;
import au.com.rejectshop.core.jalo.components.CMSAccordionListComponent;
import au.com.rejectshop.core.jalo.components.CMSAnnouncementComponent;
import au.com.rejectshop.core.jalo.components.CMSLeftNavigationMenuComponent;
import au.com.rejectshop.core.jalo.components.CMSMediaParagraphComponent;
import au.com.rejectshop.core.jalo.components.CMSReportListComponent;
import au.com.rejectshop.core.jalo.components.CMSTitleParagraphComponent;
import au.com.rejectshop.core.jalo.components.CheckGiftCardBalanceComponent;
import au.com.rejectshop.core.jalo.components.CustomerFeedbackCMSComponent;
import au.com.rejectshop.core.jalo.components.FeaturedProductsComponent;
import au.com.rejectshop.core.jalo.components.FollowUsComponent;
import au.com.rejectshop.core.jalo.components.GiftCardsCMSComponent;
import au.com.rejectshop.core.jalo.components.GiftVouchersCMSComponent;
import au.com.rejectshop.core.jalo.components.ModuleCMSComponent;
import au.com.rejectshop.core.jalo.components.OnlineCatalogueViewComponent;
import au.com.rejectshop.core.jalo.components.ProductBannerCMSComponent;
import au.com.rejectshop.core.jalo.components.ReportMediasCMSComponent;
import au.com.rejectshop.core.jalo.components.StoreLocatorComponent;
import au.com.rejectshop.core.jalo.components.TRSCategoryCarouselComponent;
import au.com.rejectshop.core.jalo.components.TRSDynamicCategoryCarouselComponent;
import au.com.rejectshop.core.jalo.components.TRSTableTreeCategoryCarouselComponent;
import au.com.rejectshop.core.jalo.process.SendAFriendEmailProcess;
import au.com.rejectshop.core.jalo.process.SendReminderProcess;
import de.hybris.platform.category.jalo.Category;
import de.hybris.platform.cms2.jalo.contents.CMSItem;
import de.hybris.platform.cms2.jalo.contents.components.AbstractCMSComponent;
import de.hybris.platform.cms2.jalo.contents.components.CMSLinkComponent;
import de.hybris.platform.cms2.jalo.contents.components.SimpleCMSComponent;
import de.hybris.platform.cms2.jalo.navigation.CMSNavigationNode;
import de.hybris.platform.cms2lib.components.BannerComponent;
import de.hybris.platform.europe1.jalo.PDTRow;
import de.hybris.platform.europe1.jalo.PriceRow;
import de.hybris.platform.jalo.GenericItem;
import de.hybris.platform.jalo.Item;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.JaloBusinessException;
import de.hybris.platform.jalo.JaloInvalidParameterException;
import de.hybris.platform.jalo.JaloSystemException;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.c2l.C2LManager;
import de.hybris.platform.jalo.c2l.Language;
import de.hybris.platform.jalo.enumeration.EnumerationValue;
import de.hybris.platform.jalo.extension.Extension;
import de.hybris.platform.jalo.link.Link;
import de.hybris.platform.jalo.product.Product;
import de.hybris.platform.jalo.type.ComposedType;
import de.hybris.platform.jalo.type.JaloGenericCreationException;
import de.hybris.platform.jalo.user.Address;
import de.hybris.platform.storelocator.jalo.PointOfService;
import de.hybris.platform.util.Utilities;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Generated class for type <code>RejectshopCoreManager</code>.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedRejectshopCoreManager extends Extension
{
	/** Relation ordering override parameter constants for CMSComponentsForNavNodes from ((rejectshopcore))*/
	protected static String CMSCOMPONENTSFORNAVNODES_SRC_ORDERED = "relation.CMSComponentsForNavNodes.source.ordered";
	protected static String CMSCOMPONENTSFORNAVNODES_TGT_ORDERED = "relation.CMSComponentsForNavNodes.target.ordered";
	/** Relation disable markmodifed parameter constants for CMSComponentsForNavNodes from ((rejectshopcore))*/
	protected static String CMSCOMPONENTSFORNAVNODES_MARKMODIFIED = "relation.CMSComponentsForNavNodes.markmodified";
	/** Relation ordering override parameter constants for ComponentsForRejCMSComponent from ((rejectshopcore))*/
	protected static String COMPONENTSFORREJCMSCOMPONENT_SRC_ORDERED = "relation.ComponentsForRejCMSComponent.source.ordered";
	protected static String COMPONENTSFORREJCMSCOMPONENT_TGT_ORDERED = "relation.ComponentsForRejCMSComponent.target.ordered";
	/** Relation disable markmodifed parameter constants for ComponentsForRejCMSComponent from ((rejectshopcore))*/
	protected static String COMPONENTSFORREJCMSCOMPONENT_MARKMODIFIED = "relation.ComponentsForRejCMSComponent.markmodified";
	/** Relation ordering override parameter constants for ComponentsForSecondaryNavigationComponent from ((rejectshopcore))*/
	protected static String COMPONENTSFORSECONDARYNAVIGATIONCOMPONENT_SRC_ORDERED = "relation.ComponentsForSecondaryNavigationComponent.source.ordered";
	protected static String COMPONENTSFORSECONDARYNAVIGATIONCOMPONENT_TGT_ORDERED = "relation.ComponentsForSecondaryNavigationComponent.target.ordered";
	/** Relation disable markmodifed parameter constants for ComponentsForSecondaryNavigationComponent from ((rejectshopcore))*/
	protected static String COMPONENTSFORSECONDARYNAVIGATIONCOMPONENT_MARKMODIFIED = "relation.ComponentsForSecondaryNavigationComponent.markmodified";
	protected static final Map<String, Map<String, AttributeMode>> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, Map<String, AttributeMode>> ttmp = new HashMap();
		Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>();
		tmp.put("priority", AttributeMode.INITIAL);
		tmp.put("categoryBanner", AttributeMode.INITIAL);
		ttmp.put("de.hybris.platform.category.jalo.Category", Collections.unmodifiableMap(tmp));
		tmp = new HashMap<String, AttributeMode>();
		tmp.put("activeProduct", AttributeMode.INITIAL);
		tmp.put("allowProductSale", AttributeMode.INITIAL);
		tmp.put("erpDescription", AttributeMode.INITIAL);
		tmp.put("innerPackSize", AttributeMode.INITIAL);
		tmp.put("replenType", AttributeMode.INITIAL);
		tmp.put("procurementRule", AttributeMode.INITIAL);
		tmp.put("metaDescription", AttributeMode.INITIAL);
		tmp.put("articleClass", AttributeMode.INITIAL);
		tmp.put("customerOffer", AttributeMode.INITIAL);
		tmp.put("brand", AttributeMode.INITIAL);
		tmp.put("articleStrategy", AttributeMode.INITIAL);
		tmp.put("pageTitle", AttributeMode.INITIAL);
		tmp.put("productIndicator", AttributeMode.INITIAL);
		tmp.put("categoryFilter", AttributeMode.INITIAL);
		ttmp.put("de.hybris.platform.jalo.product.Product", Collections.unmodifiableMap(tmp));
		tmp = new HashMap<String, AttributeMode>();
		tmp.put("style", AttributeMode.INITIAL);
		tmp.put("frontendTemplateName", AttributeMode.INITIAL);
		tmp.put("renderer", AttributeMode.INITIAL);
		ttmp.put("de.hybris.platform.cms2.jalo.contents.components.AbstractCMSComponent", Collections.unmodifiableMap(tmp));
		tmp = new HashMap<String, AttributeMode>();
		tmp.put("closed", AttributeMode.INITIAL);
		tmp.put("isActive", AttributeMode.INITIAL);
		tmp.put("startDate", AttributeMode.INITIAL);
		tmp.put("endDate", AttributeMode.INITIAL);
		tmp.put("region", AttributeMode.INITIAL);
		ttmp.put("de.hybris.platform.storelocator.jalo.PointOfService", Collections.unmodifiableMap(tmp));
		tmp = new HashMap<String, AttributeMode>();
		tmp.put("state", AttributeMode.INITIAL);
		tmp.put("storeline1", AttributeMode.INITIAL);
		tmp.put("storeline2", AttributeMode.INITIAL);
		tmp.put("saveInAddressBook", AttributeMode.INITIAL);
		ttmp.put("de.hybris.platform.jalo.user.Address", Collections.unmodifiableMap(tmp));
		tmp = new HashMap<String, AttributeMode>();
		tmp.put("priceRuleID", AttributeMode.INITIAL);
		ttmp.put("de.hybris.platform.europe1.jalo.PriceRow", Collections.unmodifiableMap(tmp));
		DEFAULT_INITIAL_ATTRIBUTES = ttmp;
	}
	@Override
	public Map<String, AttributeMode> getDefaultAttributeModes(final Class<? extends Item> itemClass)
	{
		Map<String, AttributeMode> ret = new HashMap<>();
		final Map<String, AttributeMode> attr = DEFAULT_INITIAL_ATTRIBUTES.get(itemClass.getName());
		if (attr != null)
		{
			ret.putAll(attr);
		}
		return ret;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.activeProduct</code> attribute.
	 * @return the activeProduct
	 */
	public Boolean isActiveProduct(final SessionContext ctx, final Product item)
	{
		return (Boolean)item.getProperty( ctx, RejectshopCoreConstants.Attributes.Product.ACTIVEPRODUCT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.activeProduct</code> attribute.
	 * @return the activeProduct
	 */
	public Boolean isActiveProduct(final Product item)
	{
		return isActiveProduct( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.activeProduct</code> attribute. 
	 * @return the activeProduct
	 */
	public boolean isActiveProductAsPrimitive(final SessionContext ctx, final Product item)
	{
		Boolean value = isActiveProduct( ctx,item );
		return value != null ? value.booleanValue() : false;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.activeProduct</code> attribute. 
	 * @return the activeProduct
	 */
	public boolean isActiveProductAsPrimitive(final Product item)
	{
		return isActiveProductAsPrimitive( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.activeProduct</code> attribute. 
	 * @param value the activeProduct
	 */
	public void setActiveProduct(final SessionContext ctx, final Product item, final Boolean value)
	{
		item.setProperty(ctx, RejectshopCoreConstants.Attributes.Product.ACTIVEPRODUCT,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.activeProduct</code> attribute. 
	 * @param value the activeProduct
	 */
	public void setActiveProduct(final Product item, final Boolean value)
	{
		setActiveProduct( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.activeProduct</code> attribute. 
	 * @param value the activeProduct
	 */
	public void setActiveProduct(final SessionContext ctx, final Product item, final boolean value)
	{
		setActiveProduct( ctx, item, Boolean.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.activeProduct</code> attribute. 
	 * @param value the activeProduct
	 */
	public void setActiveProduct(final Product item, final boolean value)
	{
		setActiveProduct( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.allowProductSale</code> attribute.
	 * @return the allowProductSale
	 */
	public Boolean isAllowProductSale(final SessionContext ctx, final Product item)
	{
		return (Boolean)item.getProperty( ctx, RejectshopCoreConstants.Attributes.Product.ALLOWPRODUCTSALE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.allowProductSale</code> attribute.
	 * @return the allowProductSale
	 */
	public Boolean isAllowProductSale(final Product item)
	{
		return isAllowProductSale( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.allowProductSale</code> attribute. 
	 * @return the allowProductSale
	 */
	public boolean isAllowProductSaleAsPrimitive(final SessionContext ctx, final Product item)
	{
		Boolean value = isAllowProductSale( ctx,item );
		return value != null ? value.booleanValue() : false;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.allowProductSale</code> attribute. 
	 * @return the allowProductSale
	 */
	public boolean isAllowProductSaleAsPrimitive(final Product item)
	{
		return isAllowProductSaleAsPrimitive( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.allowProductSale</code> attribute. 
	 * @param value the allowProductSale
	 */
	public void setAllowProductSale(final SessionContext ctx, final Product item, final Boolean value)
	{
		item.setProperty(ctx, RejectshopCoreConstants.Attributes.Product.ALLOWPRODUCTSALE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.allowProductSale</code> attribute. 
	 * @param value the allowProductSale
	 */
	public void setAllowProductSale(final Product item, final Boolean value)
	{
		setAllowProductSale( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.allowProductSale</code> attribute. 
	 * @param value the allowProductSale
	 */
	public void setAllowProductSale(final SessionContext ctx, final Product item, final boolean value)
	{
		setAllowProductSale( ctx, item, Boolean.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.allowProductSale</code> attribute. 
	 * @param value the allowProductSale
	 */
	public void setAllowProductSale(final Product item, final boolean value)
	{
		setAllowProductSale( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.articleClass</code> attribute.
	 * @return the articleClass - Article Class
	 */
	public String getArticleClass(final SessionContext ctx, final Product item)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedProduct.getArticleClass requires a session language", 0 );
		}
		return (String)item.getLocalizedProperty( ctx, RejectshopCoreConstants.Attributes.Product.ARTICLECLASS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.articleClass</code> attribute.
	 * @return the articleClass - Article Class
	 */
	public String getArticleClass(final Product item)
	{
		return getArticleClass( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.articleClass</code> attribute. 
	 * @return the localized articleClass - Article Class
	 */
	public Map<Language,String> getAllArticleClass(final SessionContext ctx, final Product item)
	{
		return (Map<Language,String>)item.getAllLocalizedProperties(ctx,RejectshopCoreConstants.Attributes.Product.ARTICLECLASS,C2LManager.getInstance().getAllLanguages());
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.articleClass</code> attribute. 
	 * @return the localized articleClass - Article Class
	 */
	public Map<Language,String> getAllArticleClass(final Product item)
	{
		return getAllArticleClass( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.articleClass</code> attribute. 
	 * @param value the articleClass - Article Class
	 */
	public void setArticleClass(final SessionContext ctx, final Product item, final String value)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedProduct.setArticleClass requires a session language", 0 );
		}
		item.setLocalizedProperty(ctx, RejectshopCoreConstants.Attributes.Product.ARTICLECLASS,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.articleClass</code> attribute. 
	 * @param value the articleClass - Article Class
	 */
	public void setArticleClass(final Product item, final String value)
	{
		setArticleClass( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.articleClass</code> attribute. 
	 * @param value the articleClass - Article Class
	 */
	public void setAllArticleClass(final SessionContext ctx, final Product item, final Map<Language,String> value)
	{
		item.setAllLocalizedProperties(ctx,RejectshopCoreConstants.Attributes.Product.ARTICLECLASS,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.articleClass</code> attribute. 
	 * @param value the articleClass - Article Class
	 */
	public void setAllArticleClass(final Product item, final Map<Language,String> value)
	{
		setAllArticleClass( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.articleStrategy</code> attribute.
	 * @return the articleStrategy - Article Strategy
	 */
	public String getArticleStrategy(final SessionContext ctx, final Product item)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedProduct.getArticleStrategy requires a session language", 0 );
		}
		return (String)item.getLocalizedProperty( ctx, RejectshopCoreConstants.Attributes.Product.ARTICLESTRATEGY);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.articleStrategy</code> attribute.
	 * @return the articleStrategy - Article Strategy
	 */
	public String getArticleStrategy(final Product item)
	{
		return getArticleStrategy( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.articleStrategy</code> attribute. 
	 * @return the localized articleStrategy - Article Strategy
	 */
	public Map<Language,String> getAllArticleStrategy(final SessionContext ctx, final Product item)
	{
		return (Map<Language,String>)item.getAllLocalizedProperties(ctx,RejectshopCoreConstants.Attributes.Product.ARTICLESTRATEGY,C2LManager.getInstance().getAllLanguages());
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.articleStrategy</code> attribute. 
	 * @return the localized articleStrategy - Article Strategy
	 */
	public Map<Language,String> getAllArticleStrategy(final Product item)
	{
		return getAllArticleStrategy( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.articleStrategy</code> attribute. 
	 * @param value the articleStrategy - Article Strategy
	 */
	public void setArticleStrategy(final SessionContext ctx, final Product item, final String value)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedProduct.setArticleStrategy requires a session language", 0 );
		}
		item.setLocalizedProperty(ctx, RejectshopCoreConstants.Attributes.Product.ARTICLESTRATEGY,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.articleStrategy</code> attribute. 
	 * @param value the articleStrategy - Article Strategy
	 */
	public void setArticleStrategy(final Product item, final String value)
	{
		setArticleStrategy( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.articleStrategy</code> attribute. 
	 * @param value the articleStrategy - Article Strategy
	 */
	public void setAllArticleStrategy(final SessionContext ctx, final Product item, final Map<Language,String> value)
	{
		item.setAllLocalizedProperties(ctx,RejectshopCoreConstants.Attributes.Product.ARTICLESTRATEGY,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.articleStrategy</code> attribute. 
	 * @param value the articleStrategy - Article Strategy
	 */
	public void setAllArticleStrategy(final Product item, final Map<Language,String> value)
	{
		setAllArticleStrategy( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.brand</code> attribute.
	 * @return the brand - Brand
	 */
	public String getBrand(final SessionContext ctx, final Product item)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedProduct.getBrand requires a session language", 0 );
		}
		return (String)item.getLocalizedProperty( ctx, RejectshopCoreConstants.Attributes.Product.BRAND);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.brand</code> attribute.
	 * @return the brand - Brand
	 */
	public String getBrand(final Product item)
	{
		return getBrand( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.brand</code> attribute. 
	 * @return the localized brand - Brand
	 */
	public Map<Language,String> getAllBrand(final SessionContext ctx, final Product item)
	{
		return (Map<Language,String>)item.getAllLocalizedProperties(ctx,RejectshopCoreConstants.Attributes.Product.BRAND,C2LManager.getInstance().getAllLanguages());
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.brand</code> attribute. 
	 * @return the localized brand - Brand
	 */
	public Map<Language,String> getAllBrand(final Product item)
	{
		return getAllBrand( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.brand</code> attribute. 
	 * @param value the brand - Brand
	 */
	public void setBrand(final SessionContext ctx, final Product item, final String value)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedProduct.setBrand requires a session language", 0 );
		}
		item.setLocalizedProperty(ctx, RejectshopCoreConstants.Attributes.Product.BRAND,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.brand</code> attribute. 
	 * @param value the brand - Brand
	 */
	public void setBrand(final Product item, final String value)
	{
		setBrand( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.brand</code> attribute. 
	 * @param value the brand - Brand
	 */
	public void setAllBrand(final SessionContext ctx, final Product item, final Map<Language,String> value)
	{
		item.setAllLocalizedProperties(ctx,RejectshopCoreConstants.Attributes.Product.BRAND,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.brand</code> attribute. 
	 * @param value the brand - Brand
	 */
	public void setAllBrand(final Product item, final Map<Language,String> value)
	{
		setAllBrand( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Category.categoryBanner</code> attribute.
	 * @return the categoryBanner - Banner for Category
	 */
	public BannerComponent getCategoryBanner(final SessionContext ctx, final Category item)
	{
		return (BannerComponent)item.getProperty( ctx, RejectshopCoreConstants.Attributes.Category.CATEGORYBANNER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Category.categoryBanner</code> attribute.
	 * @return the categoryBanner - Banner for Category
	 */
	public BannerComponent getCategoryBanner(final Category item)
	{
		return getCategoryBanner( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Category.categoryBanner</code> attribute. 
	 * @param value the categoryBanner - Banner for Category
	 */
	public void setCategoryBanner(final SessionContext ctx, final Category item, final BannerComponent value)
	{
		item.setProperty(ctx, RejectshopCoreConstants.Attributes.Category.CATEGORYBANNER,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Category.categoryBanner</code> attribute. 
	 * @param value the categoryBanner - Banner for Category
	 */
	public void setCategoryBanner(final Category item, final BannerComponent value)
	{
		setCategoryBanner( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.categoryFilter</code> attribute.
	 * @return the categoryFilter - Category Filter
	 */
	public List<EnumerationValue> getCategoryFilter(final SessionContext ctx, final Product item)
	{
		List<EnumerationValue> coll = (List<EnumerationValue>)item.getProperty( ctx, RejectshopCoreConstants.Attributes.Product.CATEGORYFILTER);
		return coll != null ? coll : Collections.EMPTY_LIST;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.categoryFilter</code> attribute.
	 * @return the categoryFilter - Category Filter
	 */
	public List<EnumerationValue> getCategoryFilter(final Product item)
	{
		return getCategoryFilter( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.categoryFilter</code> attribute. 
	 * @param value the categoryFilter - Category Filter
	 */
	public void setCategoryFilter(final SessionContext ctx, final Product item, final List<EnumerationValue> value)
	{
		item.setProperty(ctx, RejectshopCoreConstants.Attributes.Product.CATEGORYFILTER,value == null || !value.isEmpty() ? value : null );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.categoryFilter</code> attribute. 
	 * @param value the categoryFilter - Category Filter
	 */
	public void setCategoryFilter(final Product item, final List<EnumerationValue> value)
	{
		setCategoryFilter( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PointOfService.closed</code> attribute.
	 * @return the closed
	 */
	public Boolean isClosed(final SessionContext ctx, final PointOfService item)
	{
		return (Boolean)item.getProperty( ctx, RejectshopCoreConstants.Attributes.PointOfService.CLOSED);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PointOfService.closed</code> attribute.
	 * @return the closed
	 */
	public Boolean isClosed(final PointOfService item)
	{
		return isClosed( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PointOfService.closed</code> attribute. 
	 * @return the closed
	 */
	public boolean isClosedAsPrimitive(final SessionContext ctx, final PointOfService item)
	{
		Boolean value = isClosed( ctx,item );
		return value != null ? value.booleanValue() : false;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PointOfService.closed</code> attribute. 
	 * @return the closed
	 */
	public boolean isClosedAsPrimitive(final PointOfService item)
	{
		return isClosedAsPrimitive( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PointOfService.closed</code> attribute. 
	 * @param value the closed
	 */
	public void setClosed(final SessionContext ctx, final PointOfService item, final Boolean value)
	{
		item.setProperty(ctx, RejectshopCoreConstants.Attributes.PointOfService.CLOSED,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PointOfService.closed</code> attribute. 
	 * @param value the closed
	 */
	public void setClosed(final PointOfService item, final Boolean value)
	{
		setClosed( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PointOfService.closed</code> attribute. 
	 * @param value the closed
	 */
	public void setClosed(final SessionContext ctx, final PointOfService item, final boolean value)
	{
		setClosed( ctx, item, Boolean.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PointOfService.closed</code> attribute. 
	 * @param value the closed
	 */
	public void setClosed(final PointOfService item, final boolean value)
	{
		setClosed( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSNavigationNode.components</code> attribute.
	 * @return the components
	 */
	public List<SimpleCMSComponent> getComponents(final SessionContext ctx, final CMSNavigationNode item)
	{
		final List<SimpleCMSComponent> items = item.getLinkedItems( 
			ctx,
			false,
			RejectshopCoreConstants.Relations.CMSCOMPONENTSFORNAVNODES,
			"SimpleCMSComponent",
			null,
			Utilities.getRelationOrderingOverride(CMSCOMPONENTSFORNAVNODES_SRC_ORDERED, true),
			Utilities.getRelationOrderingOverride(CMSCOMPONENTSFORNAVNODES_TGT_ORDERED, true)
		);
		return items;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSNavigationNode.components</code> attribute.
	 * @return the components
	 */
	public List<SimpleCMSComponent> getComponents(final CMSNavigationNode item)
	{
		return getComponents( getSession().getSessionContext(), item );
	}
	
	public long getComponentsCount(final SessionContext ctx, final CMSNavigationNode item)
	{
		return item.getLinkedItemsCount(
			ctx,
			false,
			RejectshopCoreConstants.Relations.CMSCOMPONENTSFORNAVNODES,
			"SimpleCMSComponent",
			null
		);
	}
	
	public long getComponentsCount(final CMSNavigationNode item)
	{
		return getComponentsCount( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CMSNavigationNode.components</code> attribute. 
	 * @param value the components
	 */
	public void setComponents(final SessionContext ctx, final CMSNavigationNode item, final List<SimpleCMSComponent> value)
	{
		item.setLinkedItems( 
			ctx,
			false,
			RejectshopCoreConstants.Relations.CMSCOMPONENTSFORNAVNODES,
			null,
			value,
			Utilities.getRelationOrderingOverride(CMSCOMPONENTSFORNAVNODES_SRC_ORDERED, true),
			Utilities.getRelationOrderingOverride(CMSCOMPONENTSFORNAVNODES_TGT_ORDERED, true),
			Utilities.getMarkModifiedOverride(CMSCOMPONENTSFORNAVNODES_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CMSNavigationNode.components</code> attribute. 
	 * @param value the components
	 */
	public void setComponents(final CMSNavigationNode item, final List<SimpleCMSComponent> value)
	{
		setComponents( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to components. 
	 * @param value the item to add to components
	 */
	public void addToComponents(final SessionContext ctx, final CMSNavigationNode item, final SimpleCMSComponent value)
	{
		item.addLinkedItems( 
			ctx,
			false,
			RejectshopCoreConstants.Relations.CMSCOMPONENTSFORNAVNODES,
			null,
			Collections.singletonList(value),
			Utilities.getRelationOrderingOverride(CMSCOMPONENTSFORNAVNODES_SRC_ORDERED, true),
			Utilities.getRelationOrderingOverride(CMSCOMPONENTSFORNAVNODES_TGT_ORDERED, true),
			Utilities.getMarkModifiedOverride(CMSCOMPONENTSFORNAVNODES_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to components. 
	 * @param value the item to add to components
	 */
	public void addToComponents(final CMSNavigationNode item, final SimpleCMSComponent value)
	{
		addToComponents( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from components. 
	 * @param value the item to remove from components
	 */
	public void removeFromComponents(final SessionContext ctx, final CMSNavigationNode item, final SimpleCMSComponent value)
	{
		item.removeLinkedItems( 
			ctx,
			false,
			RejectshopCoreConstants.Relations.CMSCOMPONENTSFORNAVNODES,
			null,
			Collections.singletonList(value),
			Utilities.getRelationOrderingOverride(CMSCOMPONENTSFORNAVNODES_SRC_ORDERED, true),
			Utilities.getRelationOrderingOverride(CMSCOMPONENTSFORNAVNODES_TGT_ORDERED, true),
			Utilities.getMarkModifiedOverride(CMSCOMPONENTSFORNAVNODES_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from components. 
	 * @param value the item to remove from components
	 */
	public void removeFromComponents(final CMSNavigationNode item, final SimpleCMSComponent value)
	{
		removeFromComponents( getSession().getSessionContext(), item, value );
	}
	
	public AccordionItemCMSComponent createAccordionItemCMSComponent(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( RejectshopCoreConstants.TC.ACCORDIONITEMCMSCOMPONENT );
			return (AccordionItemCMSComponent)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating AccordionItemCMSComponent : "+e.getMessage(), 0 );
		}
	}
	
	public AccordionItemCMSComponent createAccordionItemCMSComponent(final Map attributeValues)
	{
		return createAccordionItemCMSComponent( getSession().getSessionContext(), attributeValues );
	}
	
	public AddThisComponent createAddThisComponent(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( RejectshopCoreConstants.TC.ADDTHISCOMPONENT );
			return (AddThisComponent)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating AddThisComponent : "+e.getMessage(), 0 );
		}
	}
	
	public AddThisComponent createAddThisComponent(final Map attributeValues)
	{
		return createAddThisComponent( getSession().getSessionContext(), attributeValues );
	}
	
	public ApparelProduct createApparelProduct(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( RejectshopCoreConstants.TC.APPARELPRODUCT );
			return (ApparelProduct)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating ApparelProduct : "+e.getMessage(), 0 );
		}
	}
	
	public ApparelProduct createApparelProduct(final Map attributeValues)
	{
		return createApparelProduct( getSession().getSessionContext(), attributeValues );
	}
	
	public ApparelSizeVariantProduct createApparelSizeVariantProduct(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( RejectshopCoreConstants.TC.APPARELSIZEVARIANTPRODUCT );
			return (ApparelSizeVariantProduct)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating ApparelSizeVariantProduct : "+e.getMessage(), 0 );
		}
	}
	
	public ApparelSizeVariantProduct createApparelSizeVariantProduct(final Map attributeValues)
	{
		return createApparelSizeVariantProduct( getSession().getSessionContext(), attributeValues );
	}
	
	public ApparelStyleVariantProduct createApparelStyleVariantProduct(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( RejectshopCoreConstants.TC.APPARELSTYLEVARIANTPRODUCT );
			return (ApparelStyleVariantProduct)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating ApparelStyleVariantProduct : "+e.getMessage(), 0 );
		}
	}
	
	public ApparelStyleVariantProduct createApparelStyleVariantProduct(final Map attributeValues)
	{
		return createApparelStyleVariantProduct( getSession().getSessionContext(), attributeValues );
	}
	
	public BecomeVIPComponent createBecomeVIPComponent(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( RejectshopCoreConstants.TC.BECOMEVIPCOMPONENT );
			return (BecomeVIPComponent)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating BecomeVIPComponent : "+e.getMessage(), 0 );
		}
	}
	
	public BecomeVIPComponent createBecomeVIPComponent(final Map attributeValues)
	{
		return createBecomeVIPComponent( getSession().getSessionContext(), attributeValues );
	}
	
	public CheckGiftCardBalanceComponent createCheckGiftCardBalanceComponent(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( RejectshopCoreConstants.TC.CHECKGIFTCARDBALANCECOMPONENT );
			return (CheckGiftCardBalanceComponent)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating CheckGiftCardBalanceComponent : "+e.getMessage(), 0 );
		}
	}
	
	public CheckGiftCardBalanceComponent createCheckGiftCardBalanceComponent(final Map attributeValues)
	{
		return createCheckGiftCardBalanceComponent( getSession().getSessionContext(), attributeValues );
	}
	
	public CMSAccordionListComponent createCMSAccordionListComponent(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( RejectshopCoreConstants.TC.CMSACCORDIONLISTCOMPONENT );
			return (CMSAccordionListComponent)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating CMSAccordionListComponent : "+e.getMessage(), 0 );
		}
	}
	
	public CMSAccordionListComponent createCMSAccordionListComponent(final Map attributeValues)
	{
		return createCMSAccordionListComponent( getSession().getSessionContext(), attributeValues );
	}
	
	public CMSAnnouncementComponent createCMSAnnouncementComponent(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( RejectshopCoreConstants.TC.CMSANNOUNCEMENTCOMPONENT );
			return (CMSAnnouncementComponent)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating CMSAnnouncementComponent : "+e.getMessage(), 0 );
		}
	}
	
	public CMSAnnouncementComponent createCMSAnnouncementComponent(final Map attributeValues)
	{
		return createCMSAnnouncementComponent( getSession().getSessionContext(), attributeValues );
	}
	
	public CMSComponentContainer createCMSComponentContainer(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( RejectshopCoreConstants.TC.CMSCOMPONENTCONTAINER );
			return (CMSComponentContainer)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating CMSComponentContainer : "+e.getMessage(), 0 );
		}
	}
	
	public CMSComponentContainer createCMSComponentContainer(final Map attributeValues)
	{
		return createCMSComponentContainer( getSession().getSessionContext(), attributeValues );
	}
	
	public CMSLeftNavigationMenuComponent createCMSLeftNavigationMenuComponent(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( RejectshopCoreConstants.TC.CMSLEFTNAVIGATIONMENUCOMPONENT );
			return (CMSLeftNavigationMenuComponent)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating CMSLeftNavigationMenuComponent : "+e.getMessage(), 0 );
		}
	}
	
	public CMSLeftNavigationMenuComponent createCMSLeftNavigationMenuComponent(final Map attributeValues)
	{
		return createCMSLeftNavigationMenuComponent( getSession().getSessionContext(), attributeValues );
	}
	
	public CMSMediaParagraphComponent createCMSMediaParagraphComponent(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( RejectshopCoreConstants.TC.CMSMEDIAPARAGRAPHCOMPONENT );
			return (CMSMediaParagraphComponent)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating CMSMediaParagraphComponent : "+e.getMessage(), 0 );
		}
	}
	
	public CMSMediaParagraphComponent createCMSMediaParagraphComponent(final Map attributeValues)
	{
		return createCMSMediaParagraphComponent( getSession().getSessionContext(), attributeValues );
	}
	
	public CMSReportListComponent createCMSReportListComponent(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( RejectshopCoreConstants.TC.CMSREPORTLISTCOMPONENT );
			return (CMSReportListComponent)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating CMSReportListComponent : "+e.getMessage(), 0 );
		}
	}
	
	public CMSReportListComponent createCMSReportListComponent(final Map attributeValues)
	{
		return createCMSReportListComponent( getSession().getSessionContext(), attributeValues );
	}
	
	public CMSTitleParagraphComponent createCMSTitleParagraphComponent(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( RejectshopCoreConstants.TC.CMSTITLEPARAGRAPHCOMPONENT );
			return (CMSTitleParagraphComponent)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating CMSTitleParagraphComponent : "+e.getMessage(), 0 );
		}
	}
	
	public CMSTitleParagraphComponent createCMSTitleParagraphComponent(final Map attributeValues)
	{
		return createCMSTitleParagraphComponent( getSession().getSessionContext(), attributeValues );
	}
	
	public CustomerFeedbackCMSComponent createCustomerFeedbackCMSComponent(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( RejectshopCoreConstants.TC.CUSTOMERFEEDBACKCMSCOMPONENT );
			return (CustomerFeedbackCMSComponent)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating CustomerFeedbackCMSComponent : "+e.getMessage(), 0 );
		}
	}
	
	public CustomerFeedbackCMSComponent createCustomerFeedbackCMSComponent(final Map attributeValues)
	{
		return createCustomerFeedbackCMSComponent( getSession().getSessionContext(), attributeValues );
	}
	
	public ElectronicsColorVariantProduct createElectronicsColorVariantProduct(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( RejectshopCoreConstants.TC.ELECTRONICSCOLORVARIANTPRODUCT );
			return (ElectronicsColorVariantProduct)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating ElectronicsColorVariantProduct : "+e.getMessage(), 0 );
		}
	}
	
	public ElectronicsColorVariantProduct createElectronicsColorVariantProduct(final Map attributeValues)
	{
		return createElectronicsColorVariantProduct( getSession().getSessionContext(), attributeValues );
	}
	
	public FeaturedProductsComponent createFeaturedProductsComponent(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( RejectshopCoreConstants.TC.FEATUREDPRODUCTSCOMPONENT );
			return (FeaturedProductsComponent)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating FeaturedProductsComponent : "+e.getMessage(), 0 );
		}
	}
	
	public FeaturedProductsComponent createFeaturedProductsComponent(final Map attributeValues)
	{
		return createFeaturedProductsComponent( getSession().getSessionContext(), attributeValues );
	}
	
	public FollowUsComponent createFollowUsComponent(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( RejectshopCoreConstants.TC.FOLLOWUSCOMPONENT );
			return (FollowUsComponent)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating FollowUsComponent : "+e.getMessage(), 0 );
		}
	}
	
	public FollowUsComponent createFollowUsComponent(final Map attributeValues)
	{
		return createFollowUsComponent( getSession().getSessionContext(), attributeValues );
	}
	
	public GiftCardsCMSComponent createGiftCardsCMSComponent(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( RejectshopCoreConstants.TC.GIFTCARDSCMSCOMPONENT );
			return (GiftCardsCMSComponent)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating GiftCardsCMSComponent : "+e.getMessage(), 0 );
		}
	}
	
	public GiftCardsCMSComponent createGiftCardsCMSComponent(final Map attributeValues)
	{
		return createGiftCardsCMSComponent( getSession().getSessionContext(), attributeValues );
	}
	
	public GiftVouchersCMSComponent createGiftVouchersCMSComponent(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( RejectshopCoreConstants.TC.GIFTVOUCHERSCMSCOMPONENT );
			return (GiftVouchersCMSComponent)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating GiftVouchersCMSComponent : "+e.getMessage(), 0 );
		}
	}
	
	public GiftVouchersCMSComponent createGiftVouchersCMSComponent(final Map attributeValues)
	{
		return createGiftVouchersCMSComponent( getSession().getSessionContext(), attributeValues );
	}
	
	public ModuleCMSComponent createModuleCMSComponent(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( RejectshopCoreConstants.TC.MODULECMSCOMPONENT );
			return (ModuleCMSComponent)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating ModuleCMSComponent : "+e.getMessage(), 0 );
		}
	}
	
	public ModuleCMSComponent createModuleCMSComponent(final Map attributeValues)
	{
		return createModuleCMSComponent( getSession().getSessionContext(), attributeValues );
	}
	
	public OnlineCatalogueViewComponent createOnlineCatalogueViewComponent(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( RejectshopCoreConstants.TC.ONLINECATALOGUEVIEWCOMPONENT );
			return (OnlineCatalogueViewComponent)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating OnlineCatalogueViewComponent : "+e.getMessage(), 0 );
		}
	}
	
	public OnlineCatalogueViewComponent createOnlineCatalogueViewComponent(final Map attributeValues)
	{
		return createOnlineCatalogueViewComponent( getSession().getSessionContext(), attributeValues );
	}
	
	public ProductBannerCMSComponent createProductBannerCMSComponent(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( RejectshopCoreConstants.TC.PRODUCTBANNERCMSCOMPONENT );
			return (ProductBannerCMSComponent)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating ProductBannerCMSComponent : "+e.getMessage(), 0 );
		}
	}
	
	public ProductBannerCMSComponent createProductBannerCMSComponent(final Map attributeValues)
	{
		return createProductBannerCMSComponent( getSession().getSessionContext(), attributeValues );
	}
	
	public RejectCMSComponent createRejectCMSComponent(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( RejectshopCoreConstants.TC.REJECTCMSCOMPONENT );
			return (RejectCMSComponent)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating RejectCMSComponent : "+e.getMessage(), 0 );
		}
	}
	
	public RejectCMSComponent createRejectCMSComponent(final Map attributeValues)
	{
		return createRejectCMSComponent( getSession().getSessionContext(), attributeValues );
	}
	
	public REJECTHorizontalBanner createREJECTHorizontalBanner(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( RejectshopCoreConstants.TC.REJECTHORIZONTALBANNER );
			return (REJECTHorizontalBanner)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating REJECTHorizontalBanner : "+e.getMessage(), 0 );
		}
	}
	
	public REJECTHorizontalBanner createREJECTHorizontalBanner(final Map attributeValues)
	{
		return createREJECTHorizontalBanner( getSession().getSessionContext(), attributeValues );
	}
	
	public RejectSizeVariantProduct createRejectSizeVariantProduct(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( RejectshopCoreConstants.TC.REJECTSIZEVARIANTPRODUCT );
			return (RejectSizeVariantProduct)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating RejectSizeVariantProduct : "+e.getMessage(), 0 );
		}
	}
	
	public RejectSizeVariantProduct createRejectSizeVariantProduct(final Map attributeValues)
	{
		return createRejectSizeVariantProduct( getSession().getSessionContext(), attributeValues );
	}
	
	public RejectStyleVariantProduct createRejectStyleVariantProduct(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( RejectshopCoreConstants.TC.REJECTSTYLEVARIANTPRODUCT );
			return (RejectStyleVariantProduct)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating RejectStyleVariantProduct : "+e.getMessage(), 0 );
		}
	}
	
	public RejectStyleVariantProduct createRejectStyleVariantProduct(final Map attributeValues)
	{
		return createRejectStyleVariantProduct( getSession().getSessionContext(), attributeValues );
	}
	
	public REJRotatingImagesComponent createREJRotatingImagesComponent(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( RejectshopCoreConstants.TC.REJROTATINGIMAGESCOMPONENT );
			return (REJRotatingImagesComponent)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating REJRotatingImagesComponent : "+e.getMessage(), 0 );
		}
	}
	
	public REJRotatingImagesComponent createREJRotatingImagesComponent(final Map attributeValues)
	{
		return createREJRotatingImagesComponent( getSession().getSessionContext(), attributeValues );
	}
	
	public REJimpleResponsiveBannerComponent createREJSimpleResponsiveBannerComponent(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( RejectshopCoreConstants.TC.REJSIMPLERESPONSIVEBANNERCOMPONENT );
			return (REJimpleResponsiveBannerComponent)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating REJSimpleResponsiveBannerComponent : "+e.getMessage(), 0 );
		}
	}
	
	public REJimpleResponsiveBannerComponent createREJSimpleResponsiveBannerComponent(final Map attributeValues)
	{
		return createREJSimpleResponsiveBannerComponent( getSession().getSessionContext(), attributeValues );
	}
	
	public ReportMedia createReportMedia(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( RejectshopCoreConstants.TC.REPORTMEDIA );
			return (ReportMedia)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating ReportMedia : "+e.getMessage(), 0 );
		}
	}
	
	public ReportMedia createReportMedia(final Map attributeValues)
	{
		return createReportMedia( getSession().getSessionContext(), attributeValues );
	}
	
	public ReportMediasCMSComponent createReportMediasCMSComponent(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( RejectshopCoreConstants.TC.REPORTMEDIASCMSCOMPONENT );
			return (ReportMediasCMSComponent)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating ReportMediasCMSComponent : "+e.getMessage(), 0 );
		}
	}
	
	public ReportMediasCMSComponent createReportMediasCMSComponent(final Map attributeValues)
	{
		return createReportMediasCMSComponent( getSession().getSessionContext(), attributeValues );
	}
	
	public SecondaryNavigationComponent createSecondaryNavigationComponent(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( RejectshopCoreConstants.TC.SECONDARYNAVIGATIONCOMPONENT );
			return (SecondaryNavigationComponent)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating SecondaryNavigationComponent : "+e.getMessage(), 0 );
		}
	}
	
	public SecondaryNavigationComponent createSecondaryNavigationComponent(final Map attributeValues)
	{
		return createSecondaryNavigationComponent( getSession().getSessionContext(), attributeValues );
	}
	
	public SendAFriendEmailProcess createSendAFriendEmailProcess(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( RejectshopCoreConstants.TC.SENDAFRIENDEMAILPROCESS );
			return (SendAFriendEmailProcess)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating SendAFriendEmailProcess : "+e.getMessage(), 0 );
		}
	}
	
	public SendAFriendEmailProcess createSendAFriendEmailProcess(final Map attributeValues)
	{
		return createSendAFriendEmailProcess( getSession().getSessionContext(), attributeValues );
	}
	
	public SendEmailReminder createSendEmailReminder(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( RejectshopCoreConstants.TC.SENDEMAILREMINDER );
			return (SendEmailReminder)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating SendEmailReminder : "+e.getMessage(), 0 );
		}
	}
	
	public SendEmailReminder createSendEmailReminder(final Map attributeValues)
	{
		return createSendEmailReminder( getSession().getSessionContext(), attributeValues );
	}
	
	public SendReminderProcess createSendReminderProcess(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( RejectshopCoreConstants.TC.SENDREMINDERPROCESS );
			return (SendReminderProcess)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating SendReminderProcess : "+e.getMessage(), 0 );
		}
	}
	
	public SendReminderProcess createSendReminderProcess(final Map attributeValues)
	{
		return createSendReminderProcess( getSession().getSessionContext(), attributeValues );
	}
	
	public StoreLocatorComponent createStoreLocatorComponent(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( RejectshopCoreConstants.TC.STORELOCATORCOMPONENT );
			return (StoreLocatorComponent)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating StoreLocatorComponent : "+e.getMessage(), 0 );
		}
	}
	
	public StoreLocatorComponent createStoreLocatorComponent(final Map attributeValues)
	{
		return createStoreLocatorComponent( getSession().getSessionContext(), attributeValues );
	}
	
	public TRSCategoryCarouselComponent createTRSCategoryCarouselComponent(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( RejectshopCoreConstants.TC.TRSCATEGORYCAROUSELCOMPONENT );
			return (TRSCategoryCarouselComponent)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating TRSCategoryCarouselComponent : "+e.getMessage(), 0 );
		}
	}
	
	public TRSCategoryCarouselComponent createTRSCategoryCarouselComponent(final Map attributeValues)
	{
		return createTRSCategoryCarouselComponent( getSession().getSessionContext(), attributeValues );
	}
	
	public TRSDynamicCategoryCarouselComponent createTRSDynamicCategoryCarouselComponent(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( RejectshopCoreConstants.TC.TRSDYNAMICCATEGORYCAROUSELCOMPONENT );
			return (TRSDynamicCategoryCarouselComponent)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating TRSDynamicCategoryCarouselComponent : "+e.getMessage(), 0 );
		}
	}
	
	public TRSDynamicCategoryCarouselComponent createTRSDynamicCategoryCarouselComponent(final Map attributeValues)
	{
		return createTRSDynamicCategoryCarouselComponent( getSession().getSessionContext(), attributeValues );
	}
	
	public TRSStockInventory createTRSStockInventory(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( RejectshopCoreConstants.TC.TRSSTOCKINVENTORY );
			return (TRSStockInventory)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating TRSStockInventory : "+e.getMessage(), 0 );
		}
	}
	
	public TRSStockInventory createTRSStockInventory(final Map attributeValues)
	{
		return createTRSStockInventory( getSession().getSessionContext(), attributeValues );
	}
	
	public TRSTableTreeCategoryCarouselComponent createTRSTableTreeCategoryCarouselComponent(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( RejectshopCoreConstants.TC.TRSTABLETREECATEGORYCAROUSELCOMPONENT );
			return (TRSTableTreeCategoryCarouselComponent)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating TRSTableTreeCategoryCarouselComponent : "+e.getMessage(), 0 );
		}
	}
	
	public TRSTableTreeCategoryCarouselComponent createTRSTableTreeCategoryCarouselComponent(final Map attributeValues)
	{
		return createTRSTableTreeCategoryCarouselComponent( getSession().getSessionContext(), attributeValues );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.customerOffer</code> attribute.
	 * @return the customerOffer - Customer Offer
	 */
	public String getCustomerOffer(final SessionContext ctx, final Product item)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedProduct.getCustomerOffer requires a session language", 0 );
		}
		return (String)item.getLocalizedProperty( ctx, RejectshopCoreConstants.Attributes.Product.CUSTOMEROFFER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.customerOffer</code> attribute.
	 * @return the customerOffer - Customer Offer
	 */
	public String getCustomerOffer(final Product item)
	{
		return getCustomerOffer( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.customerOffer</code> attribute. 
	 * @return the localized customerOffer - Customer Offer
	 */
	public Map<Language,String> getAllCustomerOffer(final SessionContext ctx, final Product item)
	{
		return (Map<Language,String>)item.getAllLocalizedProperties(ctx,RejectshopCoreConstants.Attributes.Product.CUSTOMEROFFER,C2LManager.getInstance().getAllLanguages());
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.customerOffer</code> attribute. 
	 * @return the localized customerOffer - Customer Offer
	 */
	public Map<Language,String> getAllCustomerOffer(final Product item)
	{
		return getAllCustomerOffer( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.customerOffer</code> attribute. 
	 * @param value the customerOffer - Customer Offer
	 */
	public void setCustomerOffer(final SessionContext ctx, final Product item, final String value)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedProduct.setCustomerOffer requires a session language", 0 );
		}
		item.setLocalizedProperty(ctx, RejectshopCoreConstants.Attributes.Product.CUSTOMEROFFER,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.customerOffer</code> attribute. 
	 * @param value the customerOffer - Customer Offer
	 */
	public void setCustomerOffer(final Product item, final String value)
	{
		setCustomerOffer( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.customerOffer</code> attribute. 
	 * @param value the customerOffer - Customer Offer
	 */
	public void setAllCustomerOffer(final SessionContext ctx, final Product item, final Map<Language,String> value)
	{
		item.setAllLocalizedProperties(ctx,RejectshopCoreConstants.Attributes.Product.CUSTOMEROFFER,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.customerOffer</code> attribute. 
	 * @param value the customerOffer - Customer Offer
	 */
	public void setAllCustomerOffer(final Product item, final Map<Language,String> value)
	{
		setAllCustomerOffer( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PointOfService.endDate</code> attribute.
	 * @return the endDate - End Time
	 */
	public Date getEndDate(final SessionContext ctx, final PointOfService item)
	{
		return (Date)item.getProperty( ctx, RejectshopCoreConstants.Attributes.PointOfService.ENDDATE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PointOfService.endDate</code> attribute.
	 * @return the endDate - End Time
	 */
	public Date getEndDate(final PointOfService item)
	{
		return getEndDate( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PointOfService.endDate</code> attribute. 
	 * @param value the endDate - End Time
	 */
	public void setEndDate(final SessionContext ctx, final PointOfService item, final Date value)
	{
		item.setProperty(ctx, RejectshopCoreConstants.Attributes.PointOfService.ENDDATE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PointOfService.endDate</code> attribute. 
	 * @param value the endDate - End Time
	 */
	public void setEndDate(final PointOfService item, final Date value)
	{
		setEndDate( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.erpDescription</code> attribute.
	 * @return the erpDescription - Localized title of the component to be displayed.
	 */
	public String getErpDescription(final SessionContext ctx, final Product item)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedProduct.getErpDescription requires a session language", 0 );
		}
		return (String)item.getLocalizedProperty( ctx, RejectshopCoreConstants.Attributes.Product.ERPDESCRIPTION);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.erpDescription</code> attribute.
	 * @return the erpDescription - Localized title of the component to be displayed.
	 */
	public String getErpDescription(final Product item)
	{
		return getErpDescription( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.erpDescription</code> attribute. 
	 * @return the localized erpDescription - Localized title of the component to be displayed.
	 */
	public Map<Language,String> getAllErpDescription(final SessionContext ctx, final Product item)
	{
		return (Map<Language,String>)item.getAllLocalizedProperties(ctx,RejectshopCoreConstants.Attributes.Product.ERPDESCRIPTION,C2LManager.getInstance().getAllLanguages());
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.erpDescription</code> attribute. 
	 * @return the localized erpDescription - Localized title of the component to be displayed.
	 */
	public Map<Language,String> getAllErpDescription(final Product item)
	{
		return getAllErpDescription( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.erpDescription</code> attribute. 
	 * @param value the erpDescription - Localized title of the component to be displayed.
	 */
	public void setErpDescription(final SessionContext ctx, final Product item, final String value)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedProduct.setErpDescription requires a session language", 0 );
		}
		item.setLocalizedProperty(ctx, RejectshopCoreConstants.Attributes.Product.ERPDESCRIPTION,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.erpDescription</code> attribute. 
	 * @param value the erpDescription - Localized title of the component to be displayed.
	 */
	public void setErpDescription(final Product item, final String value)
	{
		setErpDescription( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.erpDescription</code> attribute. 
	 * @param value the erpDescription - Localized title of the component to be displayed.
	 */
	public void setAllErpDescription(final SessionContext ctx, final Product item, final Map<Language,String> value)
	{
		item.setAllLocalizedProperties(ctx,RejectshopCoreConstants.Attributes.Product.ERPDESCRIPTION,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.erpDescription</code> attribute. 
	 * @param value the erpDescription - Localized title of the component to be displayed.
	 */
	public void setAllErpDescription(final Product item, final Map<Language,String> value)
	{
		setAllErpDescription( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AbstractCMSComponent.frontendTemplateName</code> attribute.
	 * @return the frontendTemplateName
	 */
	public String getFrontendTemplateName(final SessionContext ctx, final AbstractCMSComponent item)
	{
		return (String)item.getProperty( ctx, RejectshopCoreConstants.Attributes.AbstractCMSComponent.FRONTENDTEMPLATENAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AbstractCMSComponent.frontendTemplateName</code> attribute.
	 * @return the frontendTemplateName
	 */
	public String getFrontendTemplateName(final AbstractCMSComponent item)
	{
		return getFrontendTemplateName( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>AbstractCMSComponent.frontendTemplateName</code> attribute. 
	 * @param value the frontendTemplateName
	 */
	public void setFrontendTemplateName(final SessionContext ctx, final AbstractCMSComponent item, final String value)
	{
		item.setProperty(ctx, RejectshopCoreConstants.Attributes.AbstractCMSComponent.FRONTENDTEMPLATENAME,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>AbstractCMSComponent.frontendTemplateName</code> attribute. 
	 * @param value the frontendTemplateName
	 */
	public void setFrontendTemplateName(final AbstractCMSComponent item, final String value)
	{
		setFrontendTemplateName( getSession().getSessionContext(), item, value );
	}
	
	@Override
	public String getName()
	{
		return RejectshopCoreConstants.EXTENSIONNAME;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.innerPackSize</code> attribute.
	 * @return the innerPackSize - Localized title of the component to be displayed.
	 */
	public Integer getInnerPackSize(final SessionContext ctx, final Product item)
	{
		return (Integer)item.getProperty( ctx, RejectshopCoreConstants.Attributes.Product.INNERPACKSIZE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.innerPackSize</code> attribute.
	 * @return the innerPackSize - Localized title of the component to be displayed.
	 */
	public Integer getInnerPackSize(final Product item)
	{
		return getInnerPackSize( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.innerPackSize</code> attribute. 
	 * @return the innerPackSize - Localized title of the component to be displayed.
	 */
	public int getInnerPackSizeAsPrimitive(final SessionContext ctx, final Product item)
	{
		Integer value = getInnerPackSize( ctx,item );
		return value != null ? value.intValue() : 0;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.innerPackSize</code> attribute. 
	 * @return the innerPackSize - Localized title of the component to be displayed.
	 */
	public int getInnerPackSizeAsPrimitive(final Product item)
	{
		return getInnerPackSizeAsPrimitive( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.innerPackSize</code> attribute. 
	 * @param value the innerPackSize - Localized title of the component to be displayed.
	 */
	public void setInnerPackSize(final SessionContext ctx, final Product item, final Integer value)
	{
		item.setProperty(ctx, RejectshopCoreConstants.Attributes.Product.INNERPACKSIZE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.innerPackSize</code> attribute. 
	 * @param value the innerPackSize - Localized title of the component to be displayed.
	 */
	public void setInnerPackSize(final Product item, final Integer value)
	{
		setInnerPackSize( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.innerPackSize</code> attribute. 
	 * @param value the innerPackSize - Localized title of the component to be displayed.
	 */
	public void setInnerPackSize(final SessionContext ctx, final Product item, final int value)
	{
		setInnerPackSize( ctx, item, Integer.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.innerPackSize</code> attribute. 
	 * @param value the innerPackSize - Localized title of the component to be displayed.
	 */
	public void setInnerPackSize(final Product item, final int value)
	{
		setInnerPackSize( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PointOfService.isActive</code> attribute.
	 * @return the isActive
	 */
	public Boolean isIsActive(final SessionContext ctx, final PointOfService item)
	{
		return (Boolean)item.getProperty( ctx, RejectshopCoreConstants.Attributes.PointOfService.ISACTIVE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PointOfService.isActive</code> attribute.
	 * @return the isActive
	 */
	public Boolean isIsActive(final PointOfService item)
	{
		return isIsActive( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PointOfService.isActive</code> attribute. 
	 * @return the isActive
	 */
	public boolean isIsActiveAsPrimitive(final SessionContext ctx, final PointOfService item)
	{
		Boolean value = isIsActive( ctx,item );
		return value != null ? value.booleanValue() : false;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PointOfService.isActive</code> attribute. 
	 * @return the isActive
	 */
	public boolean isIsActiveAsPrimitive(final PointOfService item)
	{
		return isIsActiveAsPrimitive( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PointOfService.isActive</code> attribute. 
	 * @param value the isActive
	 */
	public void setIsActive(final SessionContext ctx, final PointOfService item, final Boolean value)
	{
		item.setProperty(ctx, RejectshopCoreConstants.Attributes.PointOfService.ISACTIVE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PointOfService.isActive</code> attribute. 
	 * @param value the isActive
	 */
	public void setIsActive(final PointOfService item, final Boolean value)
	{
		setIsActive( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PointOfService.isActive</code> attribute. 
	 * @param value the isActive
	 */
	public void setIsActive(final SessionContext ctx, final PointOfService item, final boolean value)
	{
		setIsActive( ctx, item, Boolean.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PointOfService.isActive</code> attribute. 
	 * @param value the isActive
	 */
	public void setIsActive(final PointOfService item, final boolean value)
	{
		setIsActive( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.metaDescription</code> attribute.
	 * @return the metaDescription - MetaKey Description
	 */
	public String getMetaDescription(final SessionContext ctx, final Product item)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedProduct.getMetaDescription requires a session language", 0 );
		}
		return (String)item.getLocalizedProperty( ctx, RejectshopCoreConstants.Attributes.Product.METADESCRIPTION);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.metaDescription</code> attribute.
	 * @return the metaDescription - MetaKey Description
	 */
	public String getMetaDescription(final Product item)
	{
		return getMetaDescription( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.metaDescription</code> attribute. 
	 * @return the localized metaDescription - MetaKey Description
	 */
	public Map<Language,String> getAllMetaDescription(final SessionContext ctx, final Product item)
	{
		return (Map<Language,String>)item.getAllLocalizedProperties(ctx,RejectshopCoreConstants.Attributes.Product.METADESCRIPTION,C2LManager.getInstance().getAllLanguages());
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.metaDescription</code> attribute. 
	 * @return the localized metaDescription - MetaKey Description
	 */
	public Map<Language,String> getAllMetaDescription(final Product item)
	{
		return getAllMetaDescription( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.metaDescription</code> attribute. 
	 * @param value the metaDescription - MetaKey Description
	 */
	public void setMetaDescription(final SessionContext ctx, final Product item, final String value)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedProduct.setMetaDescription requires a session language", 0 );
		}
		item.setLocalizedProperty(ctx, RejectshopCoreConstants.Attributes.Product.METADESCRIPTION,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.metaDescription</code> attribute. 
	 * @param value the metaDescription - MetaKey Description
	 */
	public void setMetaDescription(final Product item, final String value)
	{
		setMetaDescription( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.metaDescription</code> attribute. 
	 * @param value the metaDescription - MetaKey Description
	 */
	public void setAllMetaDescription(final SessionContext ctx, final Product item, final Map<Language,String> value)
	{
		item.setAllLocalizedProperties(ctx,RejectshopCoreConstants.Attributes.Product.METADESCRIPTION,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.metaDescription</code> attribute. 
	 * @param value the metaDescription - MetaKey Description
	 */
	public void setAllMetaDescription(final Product item, final Map<Language,String> value)
	{
		setAllMetaDescription( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSLinkComponent.navigationGroupsComponent</code> attribute.
	 * @return the navigationGroupsComponent
	 */
	public Collection<SecondaryNavigationComponent> getNavigationGroupsComponent(final SessionContext ctx, final CMSLinkComponent item)
	{
		final List<SecondaryNavigationComponent> items = item.getLinkedItems( 
			ctx,
			false,
			RejectshopCoreConstants.Relations.COMPONENTSFORSECONDARYNAVIGATIONCOMPONENT,
			"SecondaryNavigationComponent",
			null,
			Utilities.getRelationOrderingOverride(COMPONENTSFORSECONDARYNAVIGATIONCOMPONENT_SRC_ORDERED, true),
			false
		);
		return items;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSLinkComponent.navigationGroupsComponent</code> attribute.
	 * @return the navigationGroupsComponent
	 */
	public Collection<SecondaryNavigationComponent> getNavigationGroupsComponent(final CMSLinkComponent item)
	{
		return getNavigationGroupsComponent( getSession().getSessionContext(), item );
	}
	
	public long getNavigationGroupsComponentCount(final SessionContext ctx, final CMSLinkComponent item)
	{
		return item.getLinkedItemsCount(
			ctx,
			false,
			RejectshopCoreConstants.Relations.COMPONENTSFORSECONDARYNAVIGATIONCOMPONENT,
			"SecondaryNavigationComponent",
			null
		);
	}
	
	public long getNavigationGroupsComponentCount(final CMSLinkComponent item)
	{
		return getNavigationGroupsComponentCount( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CMSLinkComponent.navigationGroupsComponent</code> attribute. 
	 * @param value the navigationGroupsComponent
	 */
	public void setNavigationGroupsComponent(final SessionContext ctx, final CMSLinkComponent item, final Collection<SecondaryNavigationComponent> value)
	{
		item.setLinkedItems( 
			ctx,
			false,
			RejectshopCoreConstants.Relations.COMPONENTSFORSECONDARYNAVIGATIONCOMPONENT,
			null,
			value,
			Utilities.getRelationOrderingOverride(COMPONENTSFORSECONDARYNAVIGATIONCOMPONENT_SRC_ORDERED, true),
			false,
			Utilities.getMarkModifiedOverride(COMPONENTSFORSECONDARYNAVIGATIONCOMPONENT_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CMSLinkComponent.navigationGroupsComponent</code> attribute. 
	 * @param value the navigationGroupsComponent
	 */
	public void setNavigationGroupsComponent(final CMSLinkComponent item, final Collection<SecondaryNavigationComponent> value)
	{
		setNavigationGroupsComponent( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to navigationGroupsComponent. 
	 * @param value the item to add to navigationGroupsComponent
	 */
	public void addToNavigationGroupsComponent(final SessionContext ctx, final CMSLinkComponent item, final SecondaryNavigationComponent value)
	{
		item.addLinkedItems( 
			ctx,
			false,
			RejectshopCoreConstants.Relations.COMPONENTSFORSECONDARYNAVIGATIONCOMPONENT,
			null,
			Collections.singletonList(value),
			Utilities.getRelationOrderingOverride(COMPONENTSFORSECONDARYNAVIGATIONCOMPONENT_SRC_ORDERED, true),
			false,
			Utilities.getMarkModifiedOverride(COMPONENTSFORSECONDARYNAVIGATIONCOMPONENT_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to navigationGroupsComponent. 
	 * @param value the item to add to navigationGroupsComponent
	 */
	public void addToNavigationGroupsComponent(final CMSLinkComponent item, final SecondaryNavigationComponent value)
	{
		addToNavigationGroupsComponent( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from navigationGroupsComponent. 
	 * @param value the item to remove from navigationGroupsComponent
	 */
	public void removeFromNavigationGroupsComponent(final SessionContext ctx, final CMSLinkComponent item, final SecondaryNavigationComponent value)
	{
		item.removeLinkedItems( 
			ctx,
			false,
			RejectshopCoreConstants.Relations.COMPONENTSFORSECONDARYNAVIGATIONCOMPONENT,
			null,
			Collections.singletonList(value),
			Utilities.getRelationOrderingOverride(COMPONENTSFORSECONDARYNAVIGATIONCOMPONENT_SRC_ORDERED, true),
			false,
			Utilities.getMarkModifiedOverride(COMPONENTSFORSECONDARYNAVIGATIONCOMPONENT_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from navigationGroupsComponent. 
	 * @param value the item to remove from navigationGroupsComponent
	 */
	public void removeFromNavigationGroupsComponent(final CMSLinkComponent item, final SecondaryNavigationComponent value)
	{
		removeFromNavigationGroupsComponent( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SimpleCMSComponent.nNavigationNodes</code> attribute.
	 * @return the nNavigationNodes
	 */
	public List<CMSNavigationNode> getNNavigationNodes(final SessionContext ctx, final SimpleCMSComponent item)
	{
		final List<CMSNavigationNode> items = item.getLinkedItems( 
			ctx,
			true,
			RejectshopCoreConstants.Relations.CMSCOMPONENTSFORNAVNODES,
			"CMSNavigationNode",
			null,
			Utilities.getRelationOrderingOverride(CMSCOMPONENTSFORNAVNODES_SRC_ORDERED, true),
			Utilities.getRelationOrderingOverride(CMSCOMPONENTSFORNAVNODES_TGT_ORDERED, true)
		);
		return items;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SimpleCMSComponent.nNavigationNodes</code> attribute.
	 * @return the nNavigationNodes
	 */
	public List<CMSNavigationNode> getNNavigationNodes(final SimpleCMSComponent item)
	{
		return getNNavigationNodes( getSession().getSessionContext(), item );
	}
	
	public long getNNavigationNodesCount(final SessionContext ctx, final SimpleCMSComponent item)
	{
		return item.getLinkedItemsCount(
			ctx,
			true,
			RejectshopCoreConstants.Relations.CMSCOMPONENTSFORNAVNODES,
			"CMSNavigationNode",
			null
		);
	}
	
	public long getNNavigationNodesCount(final SimpleCMSComponent item)
	{
		return getNNavigationNodesCount( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SimpleCMSComponent.nNavigationNodes</code> attribute. 
	 * @param value the nNavigationNodes
	 */
	public void setNNavigationNodes(final SessionContext ctx, final SimpleCMSComponent item, final List<CMSNavigationNode> value)
	{
		item.setLinkedItems( 
			ctx,
			true,
			RejectshopCoreConstants.Relations.CMSCOMPONENTSFORNAVNODES,
			null,
			value,
			Utilities.getRelationOrderingOverride(CMSCOMPONENTSFORNAVNODES_SRC_ORDERED, true),
			Utilities.getRelationOrderingOverride(CMSCOMPONENTSFORNAVNODES_TGT_ORDERED, true),
			Utilities.getMarkModifiedOverride(CMSCOMPONENTSFORNAVNODES_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SimpleCMSComponent.nNavigationNodes</code> attribute. 
	 * @param value the nNavigationNodes
	 */
	public void setNNavigationNodes(final SimpleCMSComponent item, final List<CMSNavigationNode> value)
	{
		setNNavigationNodes( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to nNavigationNodes. 
	 * @param value the item to add to nNavigationNodes
	 */
	public void addToNNavigationNodes(final SessionContext ctx, final SimpleCMSComponent item, final CMSNavigationNode value)
	{
		item.addLinkedItems( 
			ctx,
			true,
			RejectshopCoreConstants.Relations.CMSCOMPONENTSFORNAVNODES,
			null,
			Collections.singletonList(value),
			Utilities.getRelationOrderingOverride(CMSCOMPONENTSFORNAVNODES_SRC_ORDERED, true),
			Utilities.getRelationOrderingOverride(CMSCOMPONENTSFORNAVNODES_TGT_ORDERED, true),
			Utilities.getMarkModifiedOverride(CMSCOMPONENTSFORNAVNODES_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to nNavigationNodes. 
	 * @param value the item to add to nNavigationNodes
	 */
	public void addToNNavigationNodes(final SimpleCMSComponent item, final CMSNavigationNode value)
	{
		addToNNavigationNodes( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from nNavigationNodes. 
	 * @param value the item to remove from nNavigationNodes
	 */
	public void removeFromNNavigationNodes(final SessionContext ctx, final SimpleCMSComponent item, final CMSNavigationNode value)
	{
		item.removeLinkedItems( 
			ctx,
			true,
			RejectshopCoreConstants.Relations.CMSCOMPONENTSFORNAVNODES,
			null,
			Collections.singletonList(value),
			Utilities.getRelationOrderingOverride(CMSCOMPONENTSFORNAVNODES_SRC_ORDERED, true),
			Utilities.getRelationOrderingOverride(CMSCOMPONENTSFORNAVNODES_TGT_ORDERED, true),
			Utilities.getMarkModifiedOverride(CMSCOMPONENTSFORNAVNODES_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from nNavigationNodes. 
	 * @param value the item to remove from nNavigationNodes
	 */
	public void removeFromNNavigationNodes(final SimpleCMSComponent item, final CMSNavigationNode value)
	{
		removeFromNNavigationNodes( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.pageTitle</code> attribute.
	 * @return the pageTitle - Product Level PageTitle
	 */
	public String getPageTitle(final SessionContext ctx, final Product item)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedProduct.getPageTitle requires a session language", 0 );
		}
		return (String)item.getLocalizedProperty( ctx, RejectshopCoreConstants.Attributes.Product.PAGETITLE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.pageTitle</code> attribute.
	 * @return the pageTitle - Product Level PageTitle
	 */
	public String getPageTitle(final Product item)
	{
		return getPageTitle( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.pageTitle</code> attribute. 
	 * @return the localized pageTitle - Product Level PageTitle
	 */
	public Map<Language,String> getAllPageTitle(final SessionContext ctx, final Product item)
	{
		return (Map<Language,String>)item.getAllLocalizedProperties(ctx,RejectshopCoreConstants.Attributes.Product.PAGETITLE,C2LManager.getInstance().getAllLanguages());
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.pageTitle</code> attribute. 
	 * @return the localized pageTitle - Product Level PageTitle
	 */
	public Map<Language,String> getAllPageTitle(final Product item)
	{
		return getAllPageTitle( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.pageTitle</code> attribute. 
	 * @param value the pageTitle - Product Level PageTitle
	 */
	public void setPageTitle(final SessionContext ctx, final Product item, final String value)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedProduct.setPageTitle requires a session language", 0 );
		}
		item.setLocalizedProperty(ctx, RejectshopCoreConstants.Attributes.Product.PAGETITLE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.pageTitle</code> attribute. 
	 * @param value the pageTitle - Product Level PageTitle
	 */
	public void setPageTitle(final Product item, final String value)
	{
		setPageTitle( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.pageTitle</code> attribute. 
	 * @param value the pageTitle - Product Level PageTitle
	 */
	public void setAllPageTitle(final SessionContext ctx, final Product item, final Map<Language,String> value)
	{
		item.setAllLocalizedProperties(ctx,RejectshopCoreConstants.Attributes.Product.PAGETITLE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.pageTitle</code> attribute. 
	 * @param value the pageTitle - Product Level PageTitle
	 */
	public void setAllPageTitle(final Product item, final Map<Language,String> value)
	{
		setAllPageTitle( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PriceRow.priceRuleID</code> attribute.
	 * @return the priceRuleID
	 */
	public String getPriceRuleID(final SessionContext ctx, final PriceRow item)
	{
		return (String)item.getProperty( ctx, RejectshopCoreConstants.Attributes.PriceRow.PRICERULEID);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PriceRow.priceRuleID</code> attribute.
	 * @return the priceRuleID
	 */
	public String getPriceRuleID(final PriceRow item)
	{
		return getPriceRuleID( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PriceRow.priceRuleID</code> attribute. 
	 * @param value the priceRuleID
	 */
	public void setPriceRuleID(final SessionContext ctx, final PriceRow item, final String value)
	{
		item.setProperty(ctx, RejectshopCoreConstants.Attributes.PriceRow.PRICERULEID,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PriceRow.priceRuleID</code> attribute. 
	 * @param value the priceRuleID
	 */
	public void setPriceRuleID(final PriceRow item, final String value)
	{
		setPriceRuleID( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Category.priority</code> attribute.
	 * @return the priority - Priority for Category
	 */
	public Integer getPriority(final SessionContext ctx, final Category item)
	{
		return (Integer)item.getProperty( ctx, RejectshopCoreConstants.Attributes.Category.PRIORITY);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Category.priority</code> attribute.
	 * @return the priority - Priority for Category
	 */
	public Integer getPriority(final Category item)
	{
		return getPriority( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Category.priority</code> attribute. 
	 * @return the priority - Priority for Category
	 */
	public int getPriorityAsPrimitive(final SessionContext ctx, final Category item)
	{
		Integer value = getPriority( ctx,item );
		return value != null ? value.intValue() : 0;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Category.priority</code> attribute. 
	 * @return the priority - Priority for Category
	 */
	public int getPriorityAsPrimitive(final Category item)
	{
		return getPriorityAsPrimitive( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Category.priority</code> attribute. 
	 * @param value the priority - Priority for Category
	 */
	public void setPriority(final SessionContext ctx, final Category item, final Integer value)
	{
		item.setProperty(ctx, RejectshopCoreConstants.Attributes.Category.PRIORITY,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Category.priority</code> attribute. 
	 * @param value the priority - Priority for Category
	 */
	public void setPriority(final Category item, final Integer value)
	{
		setPriority( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Category.priority</code> attribute. 
	 * @param value the priority - Priority for Category
	 */
	public void setPriority(final SessionContext ctx, final Category item, final int value)
	{
		setPriority( ctx, item, Integer.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Category.priority</code> attribute. 
	 * @param value the priority - Priority for Category
	 */
	public void setPriority(final Category item, final int value)
	{
		setPriority( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.procurementRule</code> attribute.
	 * @return the procurementRule - Localized title of the component to be displayed.
	 */
	public String getProcurementRule(final SessionContext ctx, final Product item)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedProduct.getProcurementRule requires a session language", 0 );
		}
		return (String)item.getLocalizedProperty( ctx, RejectshopCoreConstants.Attributes.Product.PROCUREMENTRULE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.procurementRule</code> attribute.
	 * @return the procurementRule - Localized title of the component to be displayed.
	 */
	public String getProcurementRule(final Product item)
	{
		return getProcurementRule( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.procurementRule</code> attribute. 
	 * @return the localized procurementRule - Localized title of the component to be displayed.
	 */
	public Map<Language,String> getAllProcurementRule(final SessionContext ctx, final Product item)
	{
		return (Map<Language,String>)item.getAllLocalizedProperties(ctx,RejectshopCoreConstants.Attributes.Product.PROCUREMENTRULE,C2LManager.getInstance().getAllLanguages());
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.procurementRule</code> attribute. 
	 * @return the localized procurementRule - Localized title of the component to be displayed.
	 */
	public Map<Language,String> getAllProcurementRule(final Product item)
	{
		return getAllProcurementRule( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.procurementRule</code> attribute. 
	 * @param value the procurementRule - Localized title of the component to be displayed.
	 */
	public void setProcurementRule(final SessionContext ctx, final Product item, final String value)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedProduct.setProcurementRule requires a session language", 0 );
		}
		item.setLocalizedProperty(ctx, RejectshopCoreConstants.Attributes.Product.PROCUREMENTRULE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.procurementRule</code> attribute. 
	 * @param value the procurementRule - Localized title of the component to be displayed.
	 */
	public void setProcurementRule(final Product item, final String value)
	{
		setProcurementRule( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.procurementRule</code> attribute. 
	 * @param value the procurementRule - Localized title of the component to be displayed.
	 */
	public void setAllProcurementRule(final SessionContext ctx, final Product item, final Map<Language,String> value)
	{
		item.setAllLocalizedProperties(ctx,RejectshopCoreConstants.Attributes.Product.PROCUREMENTRULE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.procurementRule</code> attribute. 
	 * @param value the procurementRule - Localized title of the component to be displayed.
	 */
	public void setAllProcurementRule(final Product item, final Map<Language,String> value)
	{
		setAllProcurementRule( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.productIndicator</code> attribute.
	 * @return the productIndicator - Product productIndicator
	 */
	public EnumerationValue getProductIndicator(final SessionContext ctx, final Product item)
	{
		return (EnumerationValue)item.getProperty( ctx, RejectshopCoreConstants.Attributes.Product.PRODUCTINDICATOR);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.productIndicator</code> attribute.
	 * @return the productIndicator - Product productIndicator
	 */
	public EnumerationValue getProductIndicator(final Product item)
	{
		return getProductIndicator( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.productIndicator</code> attribute. 
	 * @param value the productIndicator - Product productIndicator
	 */
	public void setProductIndicator(final SessionContext ctx, final Product item, final EnumerationValue value)
	{
		item.setProperty(ctx, RejectshopCoreConstants.Attributes.Product.PRODUCTINDICATOR,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.productIndicator</code> attribute. 
	 * @param value the productIndicator - Product productIndicator
	 */
	public void setProductIndicator(final Product item, final EnumerationValue value)
	{
		setProductIndicator( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PointOfService.region</code> attribute.
	 * @return the region - Localized title of the component to be displayed.
	 */
	public String getRegion(final SessionContext ctx, final PointOfService item)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedPointOfService.getRegion requires a session language", 0 );
		}
		return (String)item.getLocalizedProperty( ctx, RejectshopCoreConstants.Attributes.PointOfService.REGION);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PointOfService.region</code> attribute.
	 * @return the region - Localized title of the component to be displayed.
	 */
	public String getRegion(final PointOfService item)
	{
		return getRegion( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PointOfService.region</code> attribute. 
	 * @return the localized region - Localized title of the component to be displayed.
	 */
	public Map<Language,String> getAllRegion(final SessionContext ctx, final PointOfService item)
	{
		return (Map<Language,String>)item.getAllLocalizedProperties(ctx,RejectshopCoreConstants.Attributes.PointOfService.REGION,C2LManager.getInstance().getAllLanguages());
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PointOfService.region</code> attribute. 
	 * @return the localized region - Localized title of the component to be displayed.
	 */
	public Map<Language,String> getAllRegion(final PointOfService item)
	{
		return getAllRegion( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PointOfService.region</code> attribute. 
	 * @param value the region - Localized title of the component to be displayed.
	 */
	public void setRegion(final SessionContext ctx, final PointOfService item, final String value)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedPointOfService.setRegion requires a session language", 0 );
		}
		item.setLocalizedProperty(ctx, RejectshopCoreConstants.Attributes.PointOfService.REGION,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PointOfService.region</code> attribute. 
	 * @param value the region - Localized title of the component to be displayed.
	 */
	public void setRegion(final PointOfService item, final String value)
	{
		setRegion( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PointOfService.region</code> attribute. 
	 * @param value the region - Localized title of the component to be displayed.
	 */
	public void setAllRegion(final SessionContext ctx, final PointOfService item, final Map<Language,String> value)
	{
		item.setAllLocalizedProperties(ctx,RejectshopCoreConstants.Attributes.PointOfService.REGION,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PointOfService.region</code> attribute. 
	 * @param value the region - Localized title of the component to be displayed.
	 */
	public void setAllRegion(final PointOfService item, final Map<Language,String> value)
	{
		setAllRegion( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SimpleCMSComponent.RejectCMSComponent</code> attribute.
	 * @return the RejectCMSComponent
	 */
	public Collection<RejectCMSComponent> getRejectCMSComponent(final SessionContext ctx, final SimpleCMSComponent item)
	{
		final List<RejectCMSComponent> items = item.getLinkedItems( 
			ctx,
			false,
			RejectshopCoreConstants.Relations.COMPONENTSFORREJCMSCOMPONENT,
			"RejectCMSComponent",
			null,
			Utilities.getRelationOrderingOverride(COMPONENTSFORREJCMSCOMPONENT_SRC_ORDERED, true),
			false
		);
		return items;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SimpleCMSComponent.RejectCMSComponent</code> attribute.
	 * @return the RejectCMSComponent
	 */
	public Collection<RejectCMSComponent> getRejectCMSComponent(final SimpleCMSComponent item)
	{
		return getRejectCMSComponent( getSession().getSessionContext(), item );
	}
	
	public long getRejectCMSComponentCount(final SessionContext ctx, final SimpleCMSComponent item)
	{
		return item.getLinkedItemsCount(
			ctx,
			false,
			RejectshopCoreConstants.Relations.COMPONENTSFORREJCMSCOMPONENT,
			"RejectCMSComponent",
			null
		);
	}
	
	public long getRejectCMSComponentCount(final SimpleCMSComponent item)
	{
		return getRejectCMSComponentCount( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SimpleCMSComponent.RejectCMSComponent</code> attribute. 
	 * @param value the RejectCMSComponent
	 */
	public void setRejectCMSComponent(final SessionContext ctx, final SimpleCMSComponent item, final Collection<RejectCMSComponent> value)
	{
		item.setLinkedItems( 
			ctx,
			false,
			RejectshopCoreConstants.Relations.COMPONENTSFORREJCMSCOMPONENT,
			null,
			value,
			Utilities.getRelationOrderingOverride(COMPONENTSFORREJCMSCOMPONENT_SRC_ORDERED, true),
			false,
			Utilities.getMarkModifiedOverride(COMPONENTSFORREJCMSCOMPONENT_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SimpleCMSComponent.RejectCMSComponent</code> attribute. 
	 * @param value the RejectCMSComponent
	 */
	public void setRejectCMSComponent(final SimpleCMSComponent item, final Collection<RejectCMSComponent> value)
	{
		setRejectCMSComponent( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to RejectCMSComponent. 
	 * @param value the item to add to RejectCMSComponent
	 */
	public void addToRejectCMSComponent(final SessionContext ctx, final SimpleCMSComponent item, final RejectCMSComponent value)
	{
		item.addLinkedItems( 
			ctx,
			false,
			RejectshopCoreConstants.Relations.COMPONENTSFORREJCMSCOMPONENT,
			null,
			Collections.singletonList(value),
			Utilities.getRelationOrderingOverride(COMPONENTSFORREJCMSCOMPONENT_SRC_ORDERED, true),
			false,
			Utilities.getMarkModifiedOverride(COMPONENTSFORREJCMSCOMPONENT_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to RejectCMSComponent. 
	 * @param value the item to add to RejectCMSComponent
	 */
	public void addToRejectCMSComponent(final SimpleCMSComponent item, final RejectCMSComponent value)
	{
		addToRejectCMSComponent( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from RejectCMSComponent. 
	 * @param value the item to remove from RejectCMSComponent
	 */
	public void removeFromRejectCMSComponent(final SessionContext ctx, final SimpleCMSComponent item, final RejectCMSComponent value)
	{
		item.removeLinkedItems( 
			ctx,
			false,
			RejectshopCoreConstants.Relations.COMPONENTSFORREJCMSCOMPONENT,
			null,
			Collections.singletonList(value),
			Utilities.getRelationOrderingOverride(COMPONENTSFORREJCMSCOMPONENT_SRC_ORDERED, true),
			false,
			Utilities.getMarkModifiedOverride(COMPONENTSFORREJCMSCOMPONENT_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from RejectCMSComponent. 
	 * @param value the item to remove from RejectCMSComponent
	 */
	public void removeFromRejectCMSComponent(final SimpleCMSComponent item, final RejectCMSComponent value)
	{
		removeFromRejectCMSComponent( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AbstractCMSComponent.renderer</code> attribute.
	 * @return the renderer
	 */
	public SimpleCMSComponent getRenderer(final SessionContext ctx, final AbstractCMSComponent item)
	{
		return (SimpleCMSComponent)item.getProperty( ctx, RejectshopCoreConstants.Attributes.AbstractCMSComponent.RENDERER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AbstractCMSComponent.renderer</code> attribute.
	 * @return the renderer
	 */
	public SimpleCMSComponent getRenderer(final AbstractCMSComponent item)
	{
		return getRenderer( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>AbstractCMSComponent.renderer</code> attribute. 
	 * @param value the renderer
	 */
	public void setRenderer(final SessionContext ctx, final AbstractCMSComponent item, final SimpleCMSComponent value)
	{
		item.setProperty(ctx, RejectshopCoreConstants.Attributes.AbstractCMSComponent.RENDERER,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>AbstractCMSComponent.renderer</code> attribute. 
	 * @param value the renderer
	 */
	public void setRenderer(final AbstractCMSComponent item, final SimpleCMSComponent value)
	{
		setRenderer( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.replenType</code> attribute.
	 * @return the replenType - Localized title of the component to be displayed.
	 */
	public String getReplenType(final SessionContext ctx, final Product item)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedProduct.getReplenType requires a session language", 0 );
		}
		return (String)item.getLocalizedProperty( ctx, RejectshopCoreConstants.Attributes.Product.REPLENTYPE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.replenType</code> attribute.
	 * @return the replenType - Localized title of the component to be displayed.
	 */
	public String getReplenType(final Product item)
	{
		return getReplenType( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.replenType</code> attribute. 
	 * @return the localized replenType - Localized title of the component to be displayed.
	 */
	public Map<Language,String> getAllReplenType(final SessionContext ctx, final Product item)
	{
		return (Map<Language,String>)item.getAllLocalizedProperties(ctx,RejectshopCoreConstants.Attributes.Product.REPLENTYPE,C2LManager.getInstance().getAllLanguages());
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.replenType</code> attribute. 
	 * @return the localized replenType - Localized title of the component to be displayed.
	 */
	public Map<Language,String> getAllReplenType(final Product item)
	{
		return getAllReplenType( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.replenType</code> attribute. 
	 * @param value the replenType - Localized title of the component to be displayed.
	 */
	public void setReplenType(final SessionContext ctx, final Product item, final String value)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedProduct.setReplenType requires a session language", 0 );
		}
		item.setLocalizedProperty(ctx, RejectshopCoreConstants.Attributes.Product.REPLENTYPE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.replenType</code> attribute. 
	 * @param value the replenType - Localized title of the component to be displayed.
	 */
	public void setReplenType(final Product item, final String value)
	{
		setReplenType( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.replenType</code> attribute. 
	 * @param value the replenType - Localized title of the component to be displayed.
	 */
	public void setAllReplenType(final SessionContext ctx, final Product item, final Map<Language,String> value)
	{
		item.setAllLocalizedProperties(ctx,RejectshopCoreConstants.Attributes.Product.REPLENTYPE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.replenType</code> attribute. 
	 * @param value the replenType - Localized title of the component to be displayed.
	 */
	public void setAllReplenType(final Product item, final Map<Language,String> value)
	{
		setAllReplenType( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Address.saveInAddressBook</code> attribute.
	 * @return the saveInAddressBook
	 */
	public Boolean isSaveInAddressBook(final SessionContext ctx, final Address item)
	{
		return (Boolean)item.getProperty( ctx, RejectshopCoreConstants.Attributes.Address.SAVEINADDRESSBOOK);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Address.saveInAddressBook</code> attribute.
	 * @return the saveInAddressBook
	 */
	public Boolean isSaveInAddressBook(final Address item)
	{
		return isSaveInAddressBook( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Address.saveInAddressBook</code> attribute. 
	 * @return the saveInAddressBook
	 */
	public boolean isSaveInAddressBookAsPrimitive(final SessionContext ctx, final Address item)
	{
		Boolean value = isSaveInAddressBook( ctx,item );
		return value != null ? value.booleanValue() : false;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Address.saveInAddressBook</code> attribute. 
	 * @return the saveInAddressBook
	 */
	public boolean isSaveInAddressBookAsPrimitive(final Address item)
	{
		return isSaveInAddressBookAsPrimitive( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Address.saveInAddressBook</code> attribute. 
	 * @param value the saveInAddressBook
	 */
	public void setSaveInAddressBook(final SessionContext ctx, final Address item, final Boolean value)
	{
		item.setProperty(ctx, RejectshopCoreConstants.Attributes.Address.SAVEINADDRESSBOOK,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Address.saveInAddressBook</code> attribute. 
	 * @param value the saveInAddressBook
	 */
	public void setSaveInAddressBook(final Address item, final Boolean value)
	{
		setSaveInAddressBook( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Address.saveInAddressBook</code> attribute. 
	 * @param value the saveInAddressBook
	 */
	public void setSaveInAddressBook(final SessionContext ctx, final Address item, final boolean value)
	{
		setSaveInAddressBook( ctx, item, Boolean.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Address.saveInAddressBook</code> attribute. 
	 * @param value the saveInAddressBook
	 */
	public void setSaveInAddressBook(final Address item, final boolean value)
	{
		setSaveInAddressBook( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PointOfService.startDate</code> attribute.
	 * @return the startDate - Start Time.
	 */
	public Date getStartDate(final SessionContext ctx, final PointOfService item)
	{
		return (Date)item.getProperty( ctx, RejectshopCoreConstants.Attributes.PointOfService.STARTDATE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PointOfService.startDate</code> attribute.
	 * @return the startDate - Start Time.
	 */
	public Date getStartDate(final PointOfService item)
	{
		return getStartDate( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PointOfService.startDate</code> attribute. 
	 * @param value the startDate - Start Time.
	 */
	public void setStartDate(final SessionContext ctx, final PointOfService item, final Date value)
	{
		item.setProperty(ctx, RejectshopCoreConstants.Attributes.PointOfService.STARTDATE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PointOfService.startDate</code> attribute. 
	 * @param value the startDate - Start Time.
	 */
	public void setStartDate(final PointOfService item, final Date value)
	{
		setStartDate( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Address.state</code> attribute.
	 * @return the state - state in Address
	 */
	public String getState(final SessionContext ctx, final Address item)
	{
		return (String)item.getProperty( ctx, RejectshopCoreConstants.Attributes.Address.STATE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Address.state</code> attribute.
	 * @return the state - state in Address
	 */
	public String getState(final Address item)
	{
		return getState( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Address.state</code> attribute. 
	 * @param value the state - state in Address
	 */
	public void setState(final SessionContext ctx, final Address item, final String value)
	{
		item.setProperty(ctx, RejectshopCoreConstants.Attributes.Address.STATE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Address.state</code> attribute. 
	 * @param value the state - state in Address
	 */
	public void setState(final Address item, final String value)
	{
		setState( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Address.storeline1</code> attribute.
	 * @return the storeline1 - address line 1 for Store location
	 */
	public String getStoreline1(final SessionContext ctx, final Address item)
	{
		return (String)item.getProperty( ctx, RejectshopCoreConstants.Attributes.Address.STORELINE1);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Address.storeline1</code> attribute.
	 * @return the storeline1 - address line 1 for Store location
	 */
	public String getStoreline1(final Address item)
	{
		return getStoreline1( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Address.storeline1</code> attribute. 
	 * @param value the storeline1 - address line 1 for Store location
	 */
	public void setStoreline1(final SessionContext ctx, final Address item, final String value)
	{
		item.setProperty(ctx, RejectshopCoreConstants.Attributes.Address.STORELINE1,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Address.storeline1</code> attribute. 
	 * @param value the storeline1 - address line 1 for Store location
	 */
	public void setStoreline1(final Address item, final String value)
	{
		setStoreline1( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Address.storeline2</code> attribute.
	 * @return the storeline2 - address line 2 for Store location
	 */
	public String getStoreline2(final SessionContext ctx, final Address item)
	{
		return (String)item.getProperty( ctx, RejectshopCoreConstants.Attributes.Address.STORELINE2);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Address.storeline2</code> attribute.
	 * @return the storeline2 - address line 2 for Store location
	 */
	public String getStoreline2(final Address item)
	{
		return getStoreline2( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Address.storeline2</code> attribute. 
	 * @param value the storeline2 - address line 2 for Store location
	 */
	public void setStoreline2(final SessionContext ctx, final Address item, final String value)
	{
		item.setProperty(ctx, RejectshopCoreConstants.Attributes.Address.STORELINE2,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Address.storeline2</code> attribute. 
	 * @param value the storeline2 - address line 2 for Store location
	 */
	public void setStoreline2(final Address item, final String value)
	{
		setStoreline2( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AbstractCMSComponent.style</code> attribute.
	 * @return the style
	 */
	public String getStyle(final SessionContext ctx, final AbstractCMSComponent item)
	{
		return (String)item.getProperty( ctx, RejectshopCoreConstants.Attributes.AbstractCMSComponent.STYLE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AbstractCMSComponent.style</code> attribute.
	 * @return the style
	 */
	public String getStyle(final AbstractCMSComponent item)
	{
		return getStyle( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>AbstractCMSComponent.style</code> attribute. 
	 * @param value the style
	 */
	public void setStyle(final SessionContext ctx, final AbstractCMSComponent item, final String value)
	{
		item.setProperty(ctx, RejectshopCoreConstants.Attributes.AbstractCMSComponent.STYLE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>AbstractCMSComponent.style</code> attribute. 
	 * @param value the style
	 */
	public void setStyle(final AbstractCMSComponent item, final String value)
	{
		setStyle( getSession().getSessionContext(), item, value );
	}
	
}
