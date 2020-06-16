/**
 * 
 */
package au.com.rejectshop.convertors;

import de.hybris.platform.commercefacades.product.data.CategoryData;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import de.hybris.platform.util.Config;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import au.com.rejecshop.xml.product.beans.BrandOwnerType;
import au.com.rejecshop.xml.product.beans.DatesType;
import au.com.rejecshop.xml.product.beans.InfoFieldsType;
import au.com.rejecshop.xml.product.beans.ItemCommonData.MerchandiseHierarchy;
import au.com.rejecshop.xml.product.beans.ItemMaintenance;
import au.com.rejecshop.xml.product.beans.ItemMaintenance.Item;
import au.com.rejecshop.xml.product.beans.ItemPriceType;
import au.com.rejecshop.xml.product.beans.MultiLineCommonType;
import au.com.rejecshop.xml.product.beans.SupplierInformationType;
import au.com.rejectshop.data.PriceBean;
import au.com.rejectshop.data.ProductBean;
import net.sourceforge.pmd.util.StringUtil;



/**
 * The Class ProductConverter.
 */
public class ProductConverter implements Converter<File, List<ProductBean>>
{
	
	/** The Constant PRODUCT_ACTIVE. */
	private static final String PRODUCT_ACTIVE = "trs:Active";
	/** The Constant DELIMITER_COMMA. */
	private static final String DELIMITER_COMMA = ",";

	private static final String PRODUCTSTATUS =Config.getString("product.status","");
	
	/** The Constant CATEGORY_DEPARTMENT. */
	private static final String CATEGORY_DEPARTMENT = "Department";
	
	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger(ProductConverter.class);
	
	/** The Constant product categories Article class*/
	private static final String ACLASSPRODUCTS = Config.getString("category.article.classA", "");
	private static final String BCLASSPRODUCTS = Config.getString("category.article.classB", "");
	
	/** The Constant product categories s-brand*/
	private static final String BRAND = Config.getString("category.brand", "");
	/** The Constant product categories article class*/
	private static final String ARTICLECLASSA = Config.getString("product.article.classA", "");
	private static final String ARTICLECLASSB = Config.getString("product.article.classB", "");
	
	
	/* (non-Javadoc)
	 * @see de.hybris.platform.servicelayer.dto.converter.Converter#convert(java.lang.Object)
	 */
	@Override
	public List<ProductBean> convert(File file) throws ConversionException
	{
		final List<ProductBean> productdataList = new ArrayList<ProductBean>();
		return convert(file, productdataList);
	}

	/* (non-Javadoc)
	 * @see de.hybris.platform.servicelayer.dto.converter.Converter#convert(java.lang.Object, java.lang.Object)
	 */
	@Override
	public List<ProductBean> convert(File path, List<ProductBean> productdataList) throws ConversionException
	{

		try
		{
			final JAXBContext jaxbContext = JAXBContext.newInstance(ItemMaintenance.class);
			final Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			final ItemMaintenance itemMaintenance = (ItemMaintenance) jaxbUnmarshaller.unmarshal(path);
			final List<ItemMaintenance.Item> items = itemMaintenance.getItem();

			if (CollectionUtils.isNotEmpty(items))
			{
				for (final ItemMaintenance.Item item : items)
				{
					ProductBean productBean = new ProductBean();
				
					Collection<CategoryData> listCategoryData=new ArrayList<CategoryData>();
					//Prodcut Code
					if (item.getItemID().getValue() != null)
					{
						productBean.setCode(item.getItemID().getValue());
					}
					// Set Product Name
					productBean.setName(item.getName());

					//update product Status
					productBean.setActive(validateProductStatus(item.getStatusCode(),item.getStatusCode()));
					/*if (StringUtils.equalsIgnoreCase(item.getStatusCode(), PRODUCT_ACTIVE))
					{
						productBean.setActive(true);
					}
					else
					{
						productBean.setActive(false);
					}*/
					
					// Set Allow Sales flag
					productBean.setAllowSales(item.isAllowSalesFlag());

			      //Set Category		
					final List<MerchandiseHierarchy> merchandiseHierarchies = item.getMerchandiseHierarchy();
				
					if (CollectionUtils.isNotEmpty(merchandiseHierarchies))
					{
						for (final MerchandiseHierarchy merchandiseHierarchy : merchandiseHierarchies)
						{
							String categoryName = merchandiseHierarchy.getLevel();
							CategoryData mhCategoryData=new CategoryData();
							if (StringUtils.equalsIgnoreCase(categoryName, CATEGORY_DEPARTMENT))
							{
								//productBean.setCategoryName(merchandiseHierarchy.getValue());
								productBean.setCategoryCode(merchandiseHierarchy.getID());
								productBean.setCategoryDescription(merchandiseHierarchy.getValue());
								mhCategoryData.setCode(merchandiseHierarchy.getID());
								if(merchandiseHierarchy.getID()!=null){
								listCategoryData.add(mhCategoryData);
								}
								break;
							}
							
						} 
					}
					// Set Pack size
					if(item.getInnerPackSize() != null) {
					productBean.setInnerPackSize(item.getInnerPackSize().intValueExact());
					}
					

					// Set Retail Price dates
					List<DatesType> dates = item.getDates();
					
					   if (CollectionUtils.isNotEmpty(dates))
						{
					   	int dateIndex = 0;
					   	int priceIndex = 0;
					   	final List<PriceBean> priceBeanList = new ArrayList<PriceBean>();
							for (DatesType retailPriceDate : dates)
							{
								PriceBean priceBean=new PriceBean();
								if (priceIndex == dateIndex) {
   								final XMLGregorianCalendar effectivedate = retailPriceDate.getEffectiveDate();
   								final XMLGregorianCalendar expireDate = retailPriceDate.getExpirationDate();
   								if(effectivedate != null && effectivedate.toGregorianCalendar() != null) {
   									productBean.setStartDate(effectivedate.toGregorianCalendar().getTime());
   									priceBean.setStartDate(effectivedate.toGregorianCalendar().getTime());
   									
   								}
   								if(expireDate != null && expireDate.toGregorianCalendar() != null) {
   									productBean.setEndDate(expireDate.toGregorianCalendar().getTime());
   									priceBean.setEndDate(expireDate.toGregorianCalendar().getTime());
   								}
   								setPriceWithDate(item,productBean,priceBean,dateIndex,priceBeanList);
   								dateIndex++;
   								priceIndex++;
								}
							}
						
					}
					// Set Replen Type from Comments Tag
					MultiLineCommonType multiLineCommonType = item.getComments();
					if(item.getComments() != null && multiLineCommonType.getLine1() != null)
					{
						productBean.setReplenType(multiLineCommonType.getLine1().getValue());
					}
			      
					productBean.setImportFileName(path.getName());
					
					// Set Procurement
					InfoFieldsType infoType = item.getInfoFields();
					if(infoType != null) {
						productBean.setProcurementType(infoType.getProcurementRule());
						productBean.setCustomerOffer(infoType.getCustomerOffer());
						productBean.setArticleClass(infoType.getArticleClass());
						productBean.setArticleStrategy(infoType.getArticleStrategy());
						
					}
					//set category article class
					if(infoType.getArticleClass().contains(ARTICLECLASSA) && infoType.getArticleClass()!=null){
						CategoryData categoryDataACA=new CategoryData();
						categoryDataACA.setCode(ACLASSPRODUCTS);
						listCategoryData.add(categoryDataACA);
					}
					
					
					if(infoType.getArticleClass().contains(ARTICLECLASSB)&& infoType.getArticleClass()!=null){
						CategoryData categoryDataACB=new CategoryData();
						categoryDataACB.setCode(BCLASSPRODUCTS);
						listCategoryData.add(categoryDataACB);
					}
				
					//set Brand
					BrandOwnerType brandOwnerType=item.getBrandOwner();
					if(brandOwnerType!=null){
						productBean.setBrand(brandOwnerType.getName());
					}
					//set category brand
					if(StringUtil.isNotEmpty(brandOwnerType.getName())&& brandOwnerType.getName()!=null){
						CategoryData categoryDataBrand=new CategoryData();
						categoryDataBrand.setCode(BRAND);
						listCategoryData.add(categoryDataBrand);
					}
					productBean.setCategories(listCategoryData);
					productdataList.add(productBean);
					
				}
			}
		}
		catch (Exception exception)
		{
			LOG.error("[ Error Occured while Processing XML file " + exception + "]");
		}
		return productdataList;
	}

	private boolean validateProductStatus(String productModelStatus,String stockCode){
		boolean isProductActive = true;
		String[] productStatus = null;
		if (productModelStatus==null || productModelStatus.equalsIgnoreCase("")){
			isProductActive=false;
			return isProductActive ;
		}
		if (StringUtils.isNotBlank(PRODUCTSTATUS))
		{
			productStatus = StringUtils.split(PRODUCTSTATUS, DELIMITER_COMMA);
		}
		if (ArrayUtils.isNotEmpty(productStatus) && CollectionUtils.isNotEmpty(Arrays.asList(productStatus)))
		{
			for (String customerOffer : Arrays.asList(productStatus))
			{

				if (StringUtils.equalsIgnoreCase(customerOffer, productModelStatus))
				{
					isProductActive = false;
				}
			}
		}
		LOG.info("Product Status "+productModelStatus +" Stock Code "+stockCode+" - flag "+isProductActive);
		LOG.info("Status form config : "+PRODUCTSTATUS);
		return isProductActive;
	}
	//Set Retail Price
		private void setPriceWithDate(Item item, ProductBean productBean, PriceBean priceBean, int dateIndex,List<PriceBean> priceBeanList)
		{
			final List<ItemPriceType> prices = item.getItemPrice();
			
			if (CollectionUtils.isNotEmpty(prices))
							   
	   
												
			{
				int priceIndex = 0;
				for (final ItemPriceType itemPriceType : prices)
																										   
	   
																
				{
					if (priceIndex == dateIndex) {
	   				if (itemPriceType.getValue() != null)
	   				{
	   					priceBean.setPrice(itemPriceType.getValue().doubleValue());
	   				}
	   				if (itemPriceType.getQuantity() != null)
	   				{
	   					priceBean.setUnit(itemPriceType.getQuantity().intValue());
	   				}
	   				if (itemPriceType.getQuantity() != null)
	   				{
	   					priceBeanList.add(priceBean);
	   				}
					}
					priceIndex++;
				}
				productBean.setPrice(priceBeanList);
			}
}
}