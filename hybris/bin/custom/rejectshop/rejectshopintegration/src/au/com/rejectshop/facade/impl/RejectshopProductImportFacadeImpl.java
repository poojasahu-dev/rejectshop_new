/**
 * 
 */
package au.com.rejectshop.facade.impl;

import de.hybris.platform.basecommerce.enums.InStockStatus;
import de.hybris.platform.catalog.CatalogVersionService;
import de.hybris.platform.catalog.enums.ArticleApprovalStatus;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.category.CategoryService;
import de.hybris.platform.category.model.CategoryModel;
import de.hybris.platform.commercefacades.product.data.CategoryData;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.core.model.product.UnitModel;
import de.hybris.platform.europe1.model.PriceRowModel;
import de.hybris.platform.ordersplitting.WarehouseService;
import de.hybris.platform.ordersplitting.model.StockLevelModel;
import de.hybris.platform.ordersplitting.model.WarehouseModel;
import de.hybris.platform.product.ProductService;
import de.hybris.platform.product.UnitService;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.servicelayer.exceptions.ModelSavingException;
import de.hybris.platform.servicelayer.i18n.CommonI18NService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.stock.impl.StockLevelDao;
import de.hybris.platform.store.services.BaseStoreService;
import de.hybris.platform.util.Config;

import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;

import au.com.rejectshop.convertors.PointOfServiceConverter;
import au.com.rejectshop.convertors.PriceConverter;
import au.com.rejectshop.convertors.ProductConverter;
import au.com.rejectshop.core.util.RejectStringUtils;
import au.com.rejectshop.cronjob.service.ExtendedProductService;
import au.com.rejectshop.cronjob.service.RejectshopProductImportService;
import au.com.rejectshop.data.ErrorBean;
import au.com.rejectshop.data.PriceBean;
import au.com.rejectshop.data.ProductBean;
import au.com.rejectshop.data.SkipBean;
import au.com.rejectshop.facade.RejectshopProductImportFacade;
import au.com.rejectshop.util.EmailUtils;
import au.com.rejectshop.util.FileIOUtilities;


/**
 * The Class RejectshopProductImportFacadeImpl.
 */
public class RejectshopProductImportFacadeImpl implements RejectshopProductImportFacade
{

	/** The Constant DELIMITER_COMMA. */
	private static final String DELIMITER_COMMA = ",";

	/** The Constant ZERO. */
	private static final double ZERO = 0.0;

	/** The Constant Procurement_Rule. */
	private static final String Procurement_Rule = Config.getString("procurement.rule", "");

	private static final String Replenishment_Type = Config.getString("replenishment.type", "");

	/** The Constant Replenishment_Type. */
	private static final String Prodcut_skuid_empty = Config.getString("product.skuid.empty", "");

	/** The Constant Pricerow_empty. */
	private static final String Pricerow_empty = Config.getString("price.row.empty", "");

	/** The Constant Price_Value_Zero. */
	private static final String Price_Value_Zero = Config.getString("price.value.zero", "");

	/** The Constant Price_Value_Negative. */
	private static final String Price_Value_Negative = Config.getString("price.value.negative", "");

	/** The Constant Price_StartDate_Empty. */
	private static final String Price_StartDate_Empty = Config.getString("price.startdate.empty", "");

	/** The Constant Price_EndDate_Empty. */
	private static final String Price_EndDate_Empty = Config.getString("price.enddate.empty", "");

	/** The Constant Skipped_Records_Message. */
	private static final String Skipped_Records_Message = Config.getString("skippedrecords.message", "");

	/** The Constant DEFAULT_WAREHOUSE_NAME. */
	private static final String DEFAULT_WAREHOUSE_NAME = "default";

	/** The Constant REJECTSHOP_PRODUCT_CATALOG. */
	private static final String REJECTSHOP_PRODUCT_CATALOG = "rejectshopProductCatalog";

	/** The Constant STAGED. */
	private static final String STAGED = "Staged";

	/** The Constant TRS. */
	private static final String TRS = "TRS";

	/** The Constant AUD. */
	private static final String AUD = "AUD";

	/** The Constant PIECES. */
	private static final String PIECES = "pieces";
	/** The Constant customer offer types */
	private static final String CustomerOffer_Type = Config.getString("customer.offers", "");

	/*Const Article Class*/
	private static final String ACLASSPRODUCTS = Config.getString("category.article.classA", "");


	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger(RejectshopProductImportFacadeImpl.class);


	/** The rejectshop product import service. */
	private RejectshopProductImportService rejectshopProductImportService;

	/** The extended product converter. */
	private ProductConverter extendedProductConverter;

	/** The model service. */
	private ModelService modelService;

	/** The catalog version service. */
	private CatalogVersionService catalogVersionService;

	/** The common I 18 N service. */
	private CommonI18NService commonI18NService;

	/** The extended product service. */
	private ExtendedProductService extendedProductService;

	/** The unit service. */
	private UnitService unitService;

	/** The category service. */
	private CategoryService categoryService;

	/** The extended price converter. */
	private PriceConverter extendedPriceConverter;

	/** The product service. */
	private ProductService productService;

	/** The extended customer converter. */
	private PointOfServiceConverter extendedCustomerConverter;

	/** The base store service. */
	private BaseStoreService baseStoreService;

	/** The warehouse service. */
	private WarehouseService warehouseService;

	/** The stock level dao. */
	private StockLevelDao stockLevelDao;


	/** The error count. */
	private int errorCount;

	/** The success count. */
	private int successCount;


	/** The error direc. */
	private String errorDirec = null;

	/** The skip count. */
	private int skipCount;

	/** The error products. */
	List<ErrorBean> errorProducts = new ArrayList<ErrorBean>();

	/** The skip counts. */
	List<SkipBean> skipCounts = new ArrayList<SkipBean>();


	/*
	 * (non-Javadoc)
	 * 
	 * @see au.com.rejectshop.facade.RejectshopProductImportFacade#processImportPriceRows(java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public void processImportPriceRows(String inputDir, String processDir, String errorDir)
	{
		errorDirec = errorDir;
		skipCounts = new ArrayList<SkipBean>();
		errorProducts = new ArrayList<ErrorBean>();
		List<File> processFiles = FileIOUtilities.processImportProdcuts(inputDir, processDir, errorDir);

		if (CollectionUtils.isNotEmpty(processFiles))
		{

			for (File file : processFiles)
			{
				try
				{
					List<ProductBean> productDataList = extendedPriceConverter.convert(file);
					populatePriceRowModel(productDataList, errorProducts);
				}
				catch (ConversionException conversionException)
				{
					LOG.error("Price Rows Populator exception" + conversionException);
					errorCount++;
				}
			}

			try
			{
				EmailUtils.sendPriceNotification(errorProducts, skipCounts, errorDirec, successCount, errorCount, skipCount);
				resetCounters();
			}
			catch (Exception e)
			{
				LOG.error("Unable to send notification ", e);
			}

		}
		else
		{
			LOG.warn("No Files To Process::");
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see au.com.rejectshop.facade.RejectshopProductImportFacade#processImportProdcuts(java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public void processImportProdcuts(String inputDir, String processDir, String errorDir)
	{
		errorDirec = errorDir;
		List<ErrorBean> errorProducts = new ArrayList<ErrorBean>();
		List<File> processFiles = FileIOUtilities.processImportProdcuts(inputDir, processDir, errorDir);
		if (CollectionUtils.isNotEmpty(processFiles))
		{
			for (File file : processFiles)
			{
				try
				{
					List<ProductBean> products = extendedProductConverter.convert(file);
					//Populating Product Model
					List<ProductModel> productModels = populateProductModel(products, errorProducts);
					if (productModels != null)
					{
						modelService.saveAll(productModels);
						LOG.debug("Products are Processed Successfully " + productModels.toString());
					}

				}
				catch (ConversionException conversionException)
				{
					LOG.error("Populator Conversion Exception " + conversionException);
					ErrorBean error = new ErrorBean();
					error.setFileName(file.getName());
					errorProducts.add(error);
					errorCount++;
					LOG.error(conversionException);
				}
				catch (ModelSavingException modelSavingException)
				{
					LOG.error("Product Model Exception " + modelSavingException);
					errorCount++;
				}
			}

			try
			{
				EmailUtils.sendProductNotification(errorProducts, skipCounts, errorDirec, successCount, errorCount, skipCount);
				resetCounters();
			}
			catch (Exception e)
			{
				LOG.error("Unable to send notificaiton ", e);
			}

		}
		else
		{
			LOG.warn("No Files To Process::");
		}

	}

	/**
	 * Reset counters.
	 */
	private void resetCounters()
	{
		successCount = 0;
		errorCount = 0;
		skipCount = 0;
		skipCounts = new ArrayList<SkipBean>();
		errorProducts = new ArrayList<ErrorBean>();


	}


	/**
	 * Populate product model.
	 *
	 * @param productDataList
	 *           the product data list
	 * @param errorProducts
	 *           the error products
	 * @return the list
	 */
	private List<ProductModel> populateProductModel(List<ProductBean> productDataList, List<ErrorBean> errorProducts)
	{
		List<ProductModel> productModelList = new ArrayList<ProductModel>();
		if (CollectionUtils.isNotEmpty(productDataList))
		{
			for (ProductBean productData : productDataList)
			{
				if (validateProductData(productData, errorProducts))
				{
					Collection<PriceRowModel> priceRowModels = new ArrayList<PriceRowModel>();
					List<CategoryModel> categoryModel = null;
				//	PriceRowModel priceRowModel = null;
					CatalogVersionModel catalogVersion = catalogVersionService.getCatalogVersion(REJECTSHOP_PRODUCT_CATALOG, STAGED);
					ProductModel productModel = extendedProductService.getProduct(productData.getCode(), catalogVersion);
					if (productModel == null)
					{
						// Create or get Category
						categoryModel = createOrGetCategory(productData, catalogVersion);
						// Create Product
						productModel = createProduct(productData, catalogVersion, categoryModel);

						// Create Price row
						priceRowModels = createPriceRow(productData, catalogVersion, productModel);
						if (priceRowModels != null)
						{
								productModel.setEurope1Prices(priceRowModels);
						}



						// Create stock to enable addtocart
						Set<StockLevelModel> stock = getStockLevels(productModel);
						productModel.setStockLevels(stock);
						updateProductApprovalStatus(productModel);
						productModelList.add(productModel);
						successCount++;

					}
					else if (validateProductUpdateRules(productModel, productData))
					{
						//Updating Product
						categoryModel = createOrGetCategory(productData, catalogVersion);

						productModel = updateProduct(productModel, productData, catalogVersion, categoryModel);
						priceRowModels = retailPriceUpdate(productModel, productData);
						//priceRowModels = createPriceRow(productData, catalogVersion, productModel);
						if (CollectionUtils.isNotEmpty(priceRowModels)
								&& !productModel.getApprovalStatus().equals(ArticleApprovalStatus.APPROVED))
						{
							updateProductApprovalStatus(productModel);
						}
						productModelList.add(productModel);
						successCount++;
					}
					else
					{
						skipCount++;
						SkipBean skipBean = new SkipBean();
						skipBean.setFileName(productData.getImportFileName());
						skipBean.setStoreId(productData.getCode());
						skipBean.setMessage(Skipped_Records_Message);
						skipCounts.add(skipBean);
					}
				}
			}
		}
		return productModelList;
	}

	/**
	 * Retail price update.
	 *
	 * @param productModel
	 *           the product model
	 * @param productData
	 *           the product data
	 * @return the collection
	 */
	private Collection<PriceRowModel> retailPriceUpdate(ProductModel productModel, ProductBean productData)
	{
		Collection<PriceRowModel> prices = productModel.getEurope1Prices();
		ArrayList<PriceRowModel> newPriceList = new ArrayList();
		if (CollectionUtils.isNotEmpty(prices))
		{
			for (PriceRowModel price : prices)
			{
					List<PriceBean> priceBeans=	productData.getPrice();
					for (PriceBean priceBean : priceBeans)
					{

						// if price is same and start date in past verify end date and update end date
						// if price is different and start date in past update price and end date
						// if price is different and start date in future create a new price row and update existing price rows end date
						// if price is same start date in future ignore record
						LOG.info("New price start date " + priceBean.getStartDate());
						LOG.info("New price end date " + priceBean.getEndDate());
						LOG.info("New price value" + priceBean.getPrice());
						LOG.info("Current price start date "+price.getStartTime());
						LOG.info("Current price end date "+price.getEndTime());
						LOG.info("Current price value: "+price.getPrice());

						if(price.getPrice().equals(Double.valueOf(priceBean.getPrice()))
								&& (priceBean.getStartDate().before(DateUtils.getDateOnlyFromDate(new Date()))|| priceBean.getStartDate().equals(DateUtils.getDateOnlyFromDate(new Date())) )
								&& !priceBean.getEndDate().equals(price.getEndTime())){
							LOG.info("Update end time --- current "+price.getEndTime()+"---new price"+priceBean.getEndDate());
								price.setEndTime(priceBean.getEndDate());
								modelService.save(price);

						} else 	if(!price.getPrice().equals(Double.valueOf(priceBean.getPrice()))
								&& (priceBean.getStartDate().before(DateUtils.getDateOnlyFromDate(new Date()))|| priceBean.getStartDate().equals(DateUtils.getDateOnlyFromDate(new Date())) )
								&& priceBean.getPrice() > ZERO
							){
							LOG.info("Update end time --- current "+price.getEndTime()+"---new price"+priceBean.getEndDate());
							LOG.info("Update Price--- current "+price.getPrice()+"---new price"+priceBean.getPrice());

							price.setEndTime(priceBean.getEndDate());
							price.setPrice(Double.valueOf(priceBean.getPrice()));
							modelService.save(price);
						}

						else if (priceBean.getStartDate() != null && (priceBean.getStartDate().after(DateUtils.getDateOnlyFromDate(DateUtils.getDateFromLocalDate(LocalDate.now()))))
								&& !price.getPrice().equals(Double.valueOf(priceBean.getPrice()))
								&& priceBean.getPrice() > ZERO)
						{
							LOG.info("Create new price row");
						/*LOG.info("New price start date " + priceBean.getStartDate());
						LOG.info("New price end date " + priceBean.getEndDate());
						LOG.info("New price value" + priceBean.getPrice());
						price.setPrice(Double.valueOf(priceBean.getPrice()));
						price.setStartTime(priceBean.getStartDate());
						price.setEndTime(priceBean.getEndDate());
						modelService.save(price);*/
						PriceRowModel priceRow = modelService.create(PriceRowModel.class);
						// Get UnitModel from Hybris
						final UnitModel unitModel = unitService.getUnitForCode(PIECES);
						priceRow.setUnit(unitModel);
						priceRow.setPrice(Double.valueOf(priceBean.getPrice()));
						priceRow.setCurrency(getCommonI18NService().getCurrency(RejectStringUtils.trimDoubleQuotes(AUD)));
						priceRow.setProduct(productModel);
						priceRow.setStartTime(priceBean.getStartDate());
						priceRow.setEndTime(priceBean.getEndDate());
							LOG.info("list contains price row"+newPriceList.contains(priceRow));
							int [] flag = {0};
							newPriceList.forEach( priceRowModel -> {
								if(priceRowModel.getPrice().equals(priceRow.getPrice())
										&& priceRowModel.getStartTime().equals(priceRow.getStartTime())
										&&priceRowModel.getEndTime().equals(priceRow.getEndTime())){
									flag[0]=1;
								}
							});
							if (flag[0]==0) {
								LOG.info("create and save to list---");
								modelService.save(priceRow);
								newPriceList.add(priceRow);
							}

					}
/*
					price.setPrice(Double.valueOf(productData.getPrice().get(0).getPrice()));
					price.setStartTime(productData.getStartDate());
					price.setEndTime(productData.getEndDate());
					modelService.save(price);*/
					//break;
				}
			}
		}
		return prices;
	}

	/**
	 * Validate product update rules.
	 *
	 * @param productModel
	 *           the product model
	 * @param productData
	 *           the product data
	 * @return true, if successful
	 */
	private boolean validateProductUpdateRules(ProductModel productModel, ProductBean productData)
	{
		boolean isValid = false;
		// checking product name
		if (!StringUtils.equals(productModel.getName(), productData.getName()))
		{
			isValid = true;
		}
		// checking product ERPDescription
		if (!StringUtils.equals(productModel.getErpDescription(), productData.getName()))
		{
			isValid = true;
		}
		// checking product Active flag
		if (productModel.getActiveProduct().booleanValue() != productData.isActive())
		{
			isValid = true;
		}
		// checking product Active flag
		if (productModel.getAllowProductSale().booleanValue() != productData.isAllowSales())
		{
			isValid = true;
		}
		// checking product Replenishment type
		if (!StringUtils.equals(productModel.getReplenType(), productData.getReplenType()))
		{
			isValid = true;
		}
		// checking product Procurement rule
		if (!StringUtils.equals(productModel.getProcurementRule(), productData.getProcurementType()))
		{
			isValid = true;
		}
		// Checking Category 
		if (CollectionUtils.isNotEmpty(productModel.getSupercategories()))
		{
			for (CategoryModel category : productModel.getSupercategories())
			{

				if (!StringUtils.equals(category.getCode(), productData.getCategoryCode()))
				{
					isValid = true;
				}

				if (!StringUtils.equals(category.getName(), productData.getCategoryName()))
				{
					isValid = true;
				}

				if (!StringUtils.equals(category.getDescription(), productData.getCategoryDescription()))
				{
					isValid = true;
				}
			}
		}
		//checking  the customer Offer
		if (!StringUtils.equals(productModel.getCustomerOffer(), productData.getCustomerOffer()))
		{
			isValid = true;
		}
		//checking  the article class
		if (!StringUtils.equals(productModel.getArticleClass(), productData.getArticleClass()))
		{
			isValid = true;
		}
		//checking  the brand 
		if (!StringUtils.equals(productModel.getBrand(), productData.getBrand()))
		{
			isValid = true;
		}
		//checking  the article Strategy
		if (!StringUtils.equals(productModel.getArticleStrategy(), productData.getArticleStrategy()))
		{
			isValid = true;
		}
		/**
		 * Fetching PriceRows from product and Validating with Retail Price To find the Retail Price from pricesmodel, we
		 * are checking whether price start date is before the current date
		 */
		isValid = isRetailPriceUpdate(productModel, productData, isValid);

		return isValid;
	}

	/**
	 * Checks if is retail price update.
	 *
	 * @param productModel
	 *           the product model
	 * @param productData
	 *           the product data
	 * @param isValid
	 *           the is valid
	 * @return true, if is retail price update
	 */
	private boolean isRetailPriceUpdate(ProductModel productModel, ProductBean productData, boolean isValidation)
	{
		Collection<PriceRowModel> prices = productModel.getEurope1Prices();
		if (CollectionUtils.isNotEmpty(prices))
		{

			for (PriceRowModel price : prices)
			{
				if (price.getStartTime() != null && price.getStartTime().before(DateUtils.getDateOnlyFromDate(new Date()))
						&& CollectionUtils.isNotEmpty(productData.getPrice())
						&& !price.getPrice().equals(Double.valueOf(productData.getPrice().get(0).getPrice()))
						&& productData.getPrice().get(0).getPrice() > ZERO)
				{

					isValidation = true;

				}
			}
		}
		return isValidation;
	}

	/**
	 * Update product.
	 *
	 * @param productModel
	 *           the product model
	 * @param productData
	 *           the product data
	 * @param catalogVersion
	 *           the catalog version
	 * @param categoryModel
	 *           the category model
	 * @return the product model
	 */
	private ProductModel updateProduct(ProductModel productModel, ProductBean productData, CatalogVersionModel catalogVersion,
			List<CategoryModel> categoryModel)
	{
		productModel.setErpDescription(productData.getName());
		Collection<CategoryModel> categories = new ArrayList<CategoryModel>();
		Collection<CategoryModel> categories1 = new ArrayList<CategoryModel>();
		//categories.addAll(categoryModel);

		LOG.info("Does product already has category ---" + categoryModel.size() + "---assigned---"
				+ productModel.getSupercategories().contains(categoryModel));
		boolean removeAClassCategory=true;
		//add new category to existing product, do not remove existing categories

		productModel.getSupercategories().forEach(categoryModel1 -> {
				categories1.add(categoryModel1);
		});

		for (CategoryModel model:categoryModel ) {
			LOG.info("model"+model.getCode());
			//verify if article is aclass product or not
			if(model.getCode().equalsIgnoreCase(ACLASSPRODUCTS)){
				removeAClassCategory=false;

			}
			if (!productModel.getSupercategories().contains(model)) {
				LOG.info("Add into model "+model.getCode());
				categories1.add(model);
			}
		}
		productModel.setSupercategories(categories1);

		LOG.info("article class"+removeAClassCategory);


		//if not a class product remove from a class category
		if (removeAClassCategory ){
			//does product has a class category
			final int [] containsaclass ={0};
			productModel.getSupercategories().forEach(categoryModel1 -> {
				if (categoryModel1.getCode().equalsIgnoreCase(ACLASSPRODUCTS)){
					LOG.info("Product is in Aclass category");
					containsaclass[0]=1;
				}
			});
			if (containsaclass[0] ==1) {
				LOG.info("remove product from a class category");
				productModel.getSupercategories().forEach(categoryModel1 -> {
					if (!categoryModel1.getCode().equalsIgnoreCase(ACLASSPRODUCTS)) {
						categories.add(categoryModel1);
					}
				});

				productModel.setSupercategories(categories);
				LOG.info("Remove aclass category ");
			}
		}

		for (CategoryModel model:productModel.getSupercategories()
			 ) {
			LOG.info(model.getCode()+"--- new categories");
		}

		productModel.setInnerPackSize(Integer.valueOf(productData.getInnerPackSize()));
		productModel.setAllowProductSale(Boolean.valueOf(productData.isAllowSales()));
		productModel.setProcurementRule(productData.getProcurementType());
		productModel.setActiveProduct(Boolean.valueOf(productData.isActive()));
		productModel.setAllowProductSale(Boolean.valueOf(productData.isAllowSales()));
		productModel.setReplenType(productData.getReplenType());
		productModel.setCustomerOffer(productData.getCustomerOffer());
		productModel.setBrand(productData.getBrand());
		productModel.setArticleClass(productData.getArticleClass());
		productModel.setArticleStrategy(productData.getArticleStrategy());
		return productModel;
	}

	/**
	 * Validate price data.
	 *
	 * @param productData
	 *           the product data
	 * @param errors
	 *           the errors
	 * @return true, if successful
	 */
	private boolean validatePriceData(ProductBean productData, List<ErrorBean> errors)
	{
		boolean isValid = true;
		if (StringUtils.isEmpty(productData.getCode()) || StringUtils.isBlank(productData.getCode())
				|| CollectionUtils.isEmpty(productData.getPrice()) || productData.getPrice().get(0).getPrice() <= ZERO
				|| productData.getPrice().get(0).getStartDate() == null || productData.getPrice().get(0).getEndDate() == null)
		{
			ErrorBean error = new ErrorBean();
			error.setFileName(productData.getImportFileName());
			error.setStoreId(productData.getCode());
			error.setField("Site ID");
			error.setMessage(getPricetValidationMessage(productData));
			errors.add(error);
			isValid = false;
			errorCount++;
		}
		return isValid;
	}

	/**
	 * Gets the pricet validation message.
	 *
	 * @param productData
	 *           the product data
	 * @return the pricet validation message
	 */
	private String getPricetValidationMessage(ProductBean productData)
	{

		if (StringUtils.isBlank(productData.getCode()))
		{
			return Prodcut_skuid_empty;
		}
		if (CollectionUtils.isEmpty(productData.getPrice()))
		{
			return Pricerow_empty;
		}
		/*
		 * if(productData.getPrice().get(0).getPrice() == ZERO){ return Price_Value_Zero; }
		 */

		BigDecimal productPrice = BigDecimal.valueOf(productData.getPrice().get(0).getPrice()).setScale(2, RoundingMode.CEILING);
		if (productPrice.equals(BigDecimal.valueOf(ZERO).setScale(2, RoundingMode.CEILING)))
		{
			return Price_Value_Zero;
		}

		if (productData.getPrice().get(0).getPrice() < ZERO)
		{
			return Price_Value_Negative;
		}
		if (productData.getPrice().get(0).getStartDate() == null)
		{
			return Price_StartDate_Empty;
		}
		if (productData.getPrice().get(0).getEndDate() == null)
		{
			return Price_EndDate_Empty;
		}
		return errorDirec;

	}

	/**
	 * Validate product data.
	 *
	 * @param productData
	 *           the product data
	 * @param errors
	 *           the errors
	 * @return true, if successful
	 */
	private boolean validateProductData(ProductBean productData, List<ErrorBean> errors)
	{
		boolean isValid = true;
		if (StringUtils.isEmpty(productData.getCode()) || StringUtils.isBlank(productData.getCode())
				|| CollectionUtils.isEmpty(productData.getPrice()) || productData.getPrice().get(0).getPrice() <= ZERO
				|| productData.getStartDate() == null || productData.getEndDate() == null
				|| !productData.getEndDate().after(DateUtils.getDateOnlyFromDate(new Date())))
		{
			ErrorBean error = new ErrorBean();
			error.setFileName(productData.getImportFileName());
			error.setStoreId(productData.getCode());
			error.setField("Site ID");
			error.setMessage(getProductValidationMessage(productData));
			errors.add(error);
			isValid = false;
			errorCount++;
		}
		return isValid;
	}

	/**
	 * Gets the validation message.
	 *
	 * @param productData
	 *           the product data
	 * @return the validation message
	 */
	private String getProductValidationMessage(ProductBean productData)
	{

		if (StringUtils.isBlank(productData.getCode()))
		{
			return Prodcut_skuid_empty;
		}
		if (CollectionUtils.isEmpty(productData.getPrice()))
		{
			return Pricerow_empty;
		}
		BigDecimal productPrice = BigDecimal.valueOf(productData.getPrice().get(0).getPrice()).setScale(2, RoundingMode.CEILING);
		if (productPrice.equals(BigDecimal.valueOf(ZERO).setScale(2, RoundingMode.CEILING)))
		{
			return Price_Value_Zero;
		}
		if (productData.getPrice().get(0).getPrice() < ZERO)
		{
			return Price_Value_Negative;
		}
		if (productData.getStartDate() == null)
		{
			return Price_StartDate_Empty;
		}
		if (productData.getEndDate() == null)
		{
			return Price_EndDate_Empty;
		}
		return errorDirec;

	}

	/**
	 * Creates the price row.
	 *
	 * @param productData
	 *           the product data
	 * @param catalogVersion
	 *           the catalog version
	 * @param productModel
	 *           the product model
	 * @return the price row model
	 */
	private List<PriceRowModel> createPriceRow(ProductBean productData, CatalogVersionModel catalogVersion, ProductModel productModel)
	{
		List<PriceRowModel> priceRows=new ArrayList<PriceRowModel>();
		PriceRowModel priceRow = null;
		List<PriceBean> priceBeans = productData.getPrice();
		if (CollectionUtils.isNotEmpty(priceBeans))
		{
			for (PriceBean priceBean : priceBeans)
			{
				double prices = priceBean.getPrice();
				if (prices > ZERO)
				{
					priceRow = modelService.create(PriceRowModel.class);
					// Get UnitModel from Hybris
					final UnitModel unitModel = unitService.getUnitForCode(PIECES);
					priceRow.setUnit(unitModel);
					priceRow.setPrice(Double.valueOf(prices));
					priceRow.setCurrency(getCommonI18NService().getCurrency(RejectStringUtils.trimDoubleQuotes(AUD)));
					priceRow.setCatalogVersion(catalogVersion);
					priceRow.setProduct(productModel);
					priceRow.setStartTime(priceBean.getStartDate());
					priceRow.setEndTime(priceBean.getEndDate());
					priceRows.add(priceRow);
					modelService.save(priceRow);
					
				}
				
				else
				{
					LOG.info("Price Row is skipped.. price is lessthan Zero" + productData.getCode());
				}
			}
		}
		return priceRows;
	}

	/**
	 * Creates the product.
	 *
	 * @param productData
	 *           the product data
	 * @param catalogVersion
	 *           the catalog version
	 * @param categoryModel
	 *           the category model
	 * @return prodcutModel
	 */
	private ProductModel createProduct(ProductBean productData, CatalogVersionModel catalogVersion, List<CategoryModel> categoryModel)
	{
		List<CategoryModel> categories = new ArrayList<CategoryModel>();
		ProductModel productModel;
		productModel = modelService.create(ProductModel.class);
		productModel.setApprovalStatus(ArticleApprovalStatus.CHECK);
		productModel.setCode(productData.getCode());
		productModel.setActiveProduct(Boolean.valueOf(productData.isActive()));
		productModel.setName(productData.getName());
		productModel.setDescription(productData.getName());
		productModel.setErpDescription(productData.getName());
		productModel.setCatalogVersion(catalogVersion);
		categories.addAll(categoryModel);
		productModel.setSupercategories(categories);

		productModel.setInnerPackSize(Integer.valueOf(productData.getInnerPackSize()));
		productModel.setAllowProductSale(Boolean.valueOf(productData.isAllowSales()));
		productModel.setReplenType(productData.getReplenType());
		productModel.setProcurementRule(productData.getProcurementType());
		productModel.setCustomerOffer(productData.getCustomerOffer());
		productModel.setArticleClass(productData.getArticleClass());
		productModel.setBrand(productData.getBrand());
		productModel.setArticleStrategy(productData.getArticleStrategy());
		return productModel;
	}

	/**
	 * Update product approval status. Status to be unapproved when it not basic change Status should be check when its
	 * basic we cant change approved as need to verify image at product level
	 *
	 * @param productModel
	 *           the product model
	 */
	private void updateProductApprovalStatus(ProductModel productModel)
	{
		if (CollectionUtils.isNotEmpty(productModel.getEurope1Prices()) &&  productModel.getActiveProduct().booleanValue()
				&& productModel.getAllowProductSale().booleanValue() && isValidCustomerOfferRule(productModel)
				&& productModel.getCustomerOffer().contains(CustomerOffer_Type.split(DELIMITER_COMMA)[0]))
		{
			productModel.setApprovalStatus(ArticleApprovalStatus.CHECK);

		}
		else
		{
			productModel.setApprovalStatus(ArticleApprovalStatus.UNAPPROVED);
		}

	}

	private boolean isValidReplenishment(ProductModel productModel)
	{

		boolean isReplenishment = false;
		String[] replenishments = null;

		String replenType = StringUtils.EMPTY;

		if (StringUtils.isNotBlank(productModel.getReplenType()))
		{
			replenType = StringUtils.substringAfter(productModel.getReplenType(), ":");
		}

		if (StringUtils.isNotBlank(Replenishment_Type))
		{
			replenishments = StringUtils.split(Replenishment_Type, DELIMITER_COMMA);
		}
		if (ArrayUtils.isNotEmpty(replenishments) && CollectionUtils.isNotEmpty(Arrays.asList(replenishments)))
		{
			for (String replenishment : Arrays.asList(replenishments))
			{

				if (StringUtils.equalsIgnoreCase(replenishment, replenType))
				{
					isReplenishment = true;
				}

			}
		}
		return isReplenishment;

	}

	/**
	 * Checks if is valid procurement rule.
	 *
	 * @param productModel
	 *           the product model
	 * @return true, if is valid procurement rule
	 */
	private boolean isValidProcurementRule(ProductModel productModel)
	{

		boolean isProcurementRule = false;
		String[] procurements = null;

		if (StringUtils.isNotBlank(Procurement_Rule))
		{
			procurements = StringUtils.split(Procurement_Rule, DELIMITER_COMMA);
		}
		if (ArrayUtils.isNotEmpty(procurements) && CollectionUtils.isNotEmpty(Arrays.asList(procurements)))
		{
			for (String procurement : Arrays.asList(procurements))
			{

				if (StringUtils.equalsIgnoreCase(procurement, productModel.getProcurementRule()))
				{
					isProcurementRule = true;
				}
			}
		}
		return isProcurementRule;

	}

	/**
	 * validate Customer Offers
	 * 
	 * @param productModel
	 * @return true, if is valid customer Offer
	 */
	private boolean isValidCustomerOfferRule(ProductModel productModel)
	{

		boolean isValidCustomerOfferRule = false;
		String[] customerOffers = null;

		if (StringUtils.isNotBlank(CustomerOffer_Type))
		{
			customerOffers = StringUtils.split(CustomerOffer_Type, DELIMITER_COMMA);
		}
		if (ArrayUtils.isNotEmpty(customerOffers) && CollectionUtils.isNotEmpty(Arrays.asList(customerOffers)))
		{
			for (String customerOffer : Arrays.asList(customerOffers))
			{

				if (StringUtils.equalsIgnoreCase(customerOffer, productModel.getCustomerOffer()))
				{
					isValidCustomerOfferRule = true;
				}
			}
		}
		return isValidCustomerOfferRule;

	}

	/**
	 * Creates the stock level.
	 *
	 * @param product
	 *           the product
	 * @return the stock level model
	 */
	private Set<StockLevelModel> getStockLevels(ProductModel product)
	{
		Set stock = new HashSet<StockLevelModel>();
		WarehouseModel warehouse = warehouseService.getWarehouseForCode(DEFAULT_WAREHOUSE_NAME);
		StockLevelModel stockLevel = stockLevelDao.findStockLevel(product.getCode(), warehouse);

		if (stockLevel != null)
		{
			stock.add(stockLevel);
		}
		else
		{
			//create the new stock level
			stockLevel = modelService.create(StockLevelModel.class);
			stockLevel.setInStockStatus(InStockStatus.FORCEINSTOCK);
			stockLevel.setProductCode(product.getCode());
			stockLevel.setWarehouse(warehouse);
			stock.add(stockLevel);
		}
		return stock;
	}

	/**
	 * Creates the or get category.
	 *
	 * @param productData
	 *           the product data
	 * @param catalogVersion
	 *           the catalog version
	 * @return the category model
	 */
	private List<CategoryModel> createOrGetCategory(ProductBean productData, CatalogVersionModel catalogVersion)
	{
		CategoryModel categoryModel = null;
		Collection<CategoryModel> categoryModels = new ArrayList<CategoryModel>();
		// Get Category from Hybris Database
		try
		{
			
			for (CategoryData categoryData : productData.getCategories())
			{
				categoryModel = categoryService.getCategoryForCode(catalogVersion, categoryData.getCode());
				List<CategoryModel> rootCategories = new ArrayList<CategoryModel>();
				if (categoryModel == null)
				{
					/**
					 * Creating Category associating to Default Super Category
					 */
					categoryModel = modelService.create(CategoryModel.class);
					categoryModel.setCode(categoryData.getCode());
					categoryModel.setDescription(categoryData.getDescription());
					categoryModel.setName(categoryData.getName());
					categoryModel.setCatalogVersion(catalogVersion);
					// Get Super Category From Hybris
					CategoryModel rootCategory = categoryService.getCategoryForCode(catalogVersion, TRS);
					rootCategories.add(rootCategory);
					categoryModel.setSupercategories(rootCategories);
				}
				// Updating category
				else
				{
					//categoryModel.setDescription(productData.getCategoryDescription());
				//	categoryModel.setName(categoryData.getName());
				//	categoryModel.setCode(categoryData.getCode());
				

				}
				categoryModels.add(categoryModel);
			}
			
		}
		catch (Exception exception)
		{
			LOG.error(" Category is not available in Hybris :: " + exception.getMessage() + " Category Code.."
					+ productData.getCategoryCode(), exception);
		}
		

		return (List<CategoryModel>) categoryModels;
	}

	/**
	 * Populate price row model.
	 *
	 * @param productDataList
	 *           the product data list
	 * @param errorProducts
	 *           the error products
	 */
	private void populatePriceRowModel(List<ProductBean> productDataList, List<ErrorBean> errorProducts)
	{
		if (CollectionUtils.isNotEmpty(productDataList))
		{
			for (ProductBean productData : productDataList)
			{

				if (validatePriceData(productData, errorProducts))
				{
					try
					{
						List<PriceBean> priceBeanList = productData.getPrice();
						for (PriceBean priceBean : priceBeanList)
						{
							CatalogVersionModel catalogVersion = catalogVersionService.getCatalogVersion(REJECTSHOP_PRODUCT_CATALOG,
									STAGED);
							try
							{
								ProductModel productModel = extendedProductService.getProduct(productData.getCode(), catalogVersion);
								if (productModel != null)
								{
									try
									{
										Collection<PriceRowModel> priceRowModels = productModel.getEurope1Prices();
										if (CollectionUtils.isNotEmpty(priceRowModels) && priceRowModels.size() > 1)
										{
											for (PriceRowModel priceRowModel : priceRowModels)
											{
												if (isValidateFuturePrice(priceRowModel, priceBean))
												{
													updateFuturePrice(priceRowModel, priceBean);
													break;
												}
												else
												{
													skipCount++;
													SkipBean skipBean = new SkipBean();
													skipBean.setFileName(productData.getImportFileName());
													skipBean.setStoreId(productData.getCode());
													skipBean.setMessage(Skipped_Records_Message);
													skipCounts.add(skipBean);
													LOG.info("Price value is same and skipped record to save in Hybris ");

												}
											}
										}
										else
										{
											createFeaturePriceRow(priceBean, catalogVersion, productModel);
											successCount++;
											LOG.info(" [ Price Rows Created Successfully ] " + productData.getCode());
										}

									}
									catch (Exception exception)
									{
										LOG.error("Price Row Persist Exception" + exception);
										errorCount++;
									}
								}
								else
								{
									LOG.info("Prodcut is not found in Hybris " + productData.getCode());
									ErrorBean error = new ErrorBean();
									error.setFileName(productData.getImportFileName());
									error.setStoreId(productData.getCode());
									error.setField("Site ID");
									error.setMessage("Product is not exist in Hybris database");
									errorProducts.add(error);
									errorCount++;
								}

							}
							catch (Exception exception)
							{
								LOG.error("Price Row Processing Exceptions" + exception.getMessage(), exception);
								errorCount++;
							}

						}
					}
					catch (Exception exception)
					{
						LOG.error(" [ Error while creating Price Rows ] " + exception.getMessage(), exception);
						errorCount++;
					}
				}
				else
				{
					LOG.info("File processings has skipped .." + productData.getImportFileName());
				}
			}
		}

	}

	/**
	 * Creates the feature price row.
	 *
	 * @param priceBean
	 *           the price bean
	 * @param catalogVersion
	 *           the catalog version
	 * @param productModel
	 *           the product model
	 */
	private void createFeaturePriceRow(PriceBean priceBean, CatalogVersionModel catalogVersion, ProductModel productModel)
	{
		if (priceBean.getPrice() > 0)
		{
			final PriceRowModel priceRow = modelService.create(PriceRowModel.class);
			final UnitModel unitModel = unitService.getUnitForCode(PIECES);
			priceRow.setStartTime(priceBean.getStartDate());
			priceRow.setEndTime(priceBean.getEndDate());
			priceRow.setPrice(Double.valueOf(priceBean.getPrice()));
			priceRow.setUnit(unitModel);
			priceRow.setCurrency(getCommonI18NService().getCurrency(RejectStringUtils.trimDoubleQuotes(AUD)));
			priceRow.setCatalogVersion(catalogVersion);
			priceRow.setProduct(productModel);

			priceRow.setPriceRuleID(priceBean.getPriceRuleID());

			modelService.save(priceRow);
		}

		else
		{
			LOG.info("Price Value is Zero and record has been skipped to persist in Hybris");
		}
	}

	/**
	 * Update future price.
	 *
	 * @param price
	 *           the price
	 * @param priceBean
	 *           the price bean
	 */
	private void updateFuturePrice(PriceRowModel price, PriceBean priceBean)
	{
		if (price.getStartTime() != null && price.getStartTime().after(DateUtils.getDateOnlyFromDate(new Date()))
				&& !price.getPrice().equals(Double.valueOf(priceBean.getPrice())))
		{
			price.setPrice(Double.valueOf(priceBean.getPrice()));

			price.setPriceRuleID(priceBean.getPriceRuleID());

			modelService.save(price);

		}
	}

	/**
	 * Checks if is validate future price.
	 *
	 * @param price
	 *           the price
	 * @param priceBean
	 *           the price bean
	 * @return true, if is validate future price
	 */
	private boolean isValidateFuturePrice(PriceRowModel price, PriceBean priceBean)
	{
		boolean isValid = false;
		if (price != null && price.getStartTime() != null && price.getStartTime().after(DateUtils.getDateOnlyFromDate(new Date()))
				&& !price.getPrice().equals(Double.valueOf(priceBean.getPrice())))
		{
			isValid = true;
		}
		return isValid;
	}

	/**
	 * Sets the catalog version service.
	 *
	 * @param catalogVersionService
	 *           the new catalog version service
	 */
	@Required
	public void setCatalogVersionService(CatalogVersionService catalogVersionService)
	{
		this.catalogVersionService = catalogVersionService;
	}


	/**
	 * Sets the model service.
	 *
	 * @param modelService
	 *           the new model service
	 */
	@Required
	public void setModelService(ModelService modelService)
	{
		this.modelService = modelService;
	}

	/**
	 * Gets the common I 18 N service.
	 *
	 * @return the commonI18NService
	 */
	public CommonI18NService getCommonI18NService()
	{
		return commonI18NService;
	}

	/**
	 * Sets the common I 18 N service.
	 *
	 * @param commonI18NService
	 *           the new common I 18 N service
	 */
	@Required
	public void setCommonI18NService(CommonI18NService commonI18NService)
	{
		this.commonI18NService = commonI18NService;
	}

	/**
	 * Gets the extended product service.
	 *
	 * @return the extended product service
	 */
	public ExtendedProductService getExtendedProductService()
	{
		return extendedProductService;
	}

	/**
	 * Sets the extended product service.
	 *
	 * @param extendedProductService
	 *           the new extended product service
	 */
	@Required
	public void setExtendedProductService(ExtendedProductService extendedProductService)
	{
		this.extendedProductService = extendedProductService;
	}

	/**
	 * Gets the unit service.
	 *
	 * @return the unitService
	 */
	public UnitService getUnitService()
	{
		return unitService;
	}

	/**
	 * Sets the unit service.
	 *
	 * @param unitService
	 *           the new unit service
	 */
	public void setUnitService(UnitService unitService)
	{
		this.unitService = unitService;
	}


	/**
	 * Gets the category service.
	 *
	 * @return the categoryService
	 */
	public CategoryService getCategoryService()
	{
		return categoryService;
	}

	/**
	 * Sets the category service.
	 *
	 * @param categoryService
	 *           the new category service
	 */
	@Required
	public void setCategoryService(CategoryService categoryService)
	{
		this.categoryService = categoryService;
	}

	/**
	 * Gets the extended customer converter.
	 *
	 * @return the extendedCustomerConverter
	 */
	public PointOfServiceConverter getExtendedCustomerConverter()
	{
		return extendedCustomerConverter;
	}

	/**
	 * Sets the extended customer converter.
	 *
	 * @param extendedCustomerConverter
	 *           the new extended customer converter
	 */
	@Required
	public void setExtendedCustomerConverter(PointOfServiceConverter extendedCustomerConverter)
	{
		this.extendedCustomerConverter = extendedCustomerConverter;
	}

	/**
	 * Gets the base store service.
	 *
	 * @return the baseStoreService
	 */
	public BaseStoreService getBaseStoreService()
	{
		return baseStoreService;
	}

	/**
	 * Sets the base store service.
	 *
	 * @param baseStoreService
	 *           the new base store service
	 */
	public void setBaseStoreService(BaseStoreService baseStoreService)
	{
		this.baseStoreService = baseStoreService;
	}

	/**
	 * Gets the rejectshop product import service.
	 *
	 * @return the rejectshopProductImportService
	 */
	public RejectshopProductImportService getRejectshopProductImportService()
	{
		return rejectshopProductImportService;
	}


	/**
	 * Sets the rejectshop product import service.
	 *
	 * @param rejectshopProductImportService
	 *           the new rejectshop product import service
	 */
	public void setRejectshopProductImportService(RejectshopProductImportService rejectshopProductImportService)
	{
		this.rejectshopProductImportService = rejectshopProductImportService;
	}

	/**
	 * Gets the extended product converter.
	 *
	 * @return the extendedProductConverter
	 */
	public ProductConverter getExtendedProductConverter()
	{
		return extendedProductConverter;
	}

	/**
	 * Sets the extended product converter.
	 *
	 * @param extendedProductConverter
	 *           the new extended product converter
	 */
	public void setExtendedProductConverter(ProductConverter extendedProductConverter)
	{
		this.extendedProductConverter = extendedProductConverter;
	}


	/**
	 * Gets the extended price converter.
	 *
	 * @return the extendedPriceConverter
	 */
	public PriceConverter getExtendedPriceConverter()
	{
		return extendedPriceConverter;
	}


	/**
	 * Sets the extended price converter.
	 *
	 * @param extendedPriceConverter
	 *           the new extended price converter
	 */
	public void setExtendedPriceConverter(PriceConverter extendedPriceConverter)
	{
		this.extendedPriceConverter = extendedPriceConverter;
	}

	/**
	 * Gets the product service.
	 *
	 * @return the productService
	 */
	public ProductService getProductService()
	{
		return productService;
	}


	/**
	 * Gets the warehouse service.
	 *
	 * @return the warehouseService
	 */
	public WarehouseService getWarehouseService()
	{
		return warehouseService;
	}

	/**
	 * Sets the warehouse service.
	 *
	 * @param warehouseService
	 *           the warehouseService to set
	 */
	public void setWarehouseService(WarehouseService warehouseService)
	{
		this.warehouseService = warehouseService;
	}

	/**
	 * Sets the product service.
	 *
	 * @param productService
	 *           the new product service
	 */
	@Required
	public void setProductService(ProductService productService)
	{
		this.productService = productService;
	}

	/**
	 * Gets the error count.
	 *
	 * @return the errorCount
	 */
	public int getErrorCount()
	{
		return errorCount;
	}

	/**
	 * Sets the error count.
	 *
	 * @param errorCount
	 *           the errorCount to set
	 */
	public void setErrorCount(int errorCount)
	{
		this.errorCount = errorCount;
	}


	/**
	 * Gets the success count.
	 *
	 * @return the successCount
	 */
	public int getSuccessCount()
	{
		return successCount;
	}


	/**
	 * Sets the success count.
	 *
	 * @param successCount
	 *           the successCount to set
	 */
	public void setSuccessCount(int successCount)
	{
		this.successCount = successCount;
	}


	/**
	 * @return the stockLevelDao
	 */
	public StockLevelDao getStockLevelDao()
	{
		return stockLevelDao;
	}

	/**
	 * @param stockLevelDao
	 *           the stockLevelDao to set
	 */
	public void setStockLevelDao(StockLevelDao stockLevelDao)
	{
		this.stockLevelDao = stockLevelDao;
	}


}
