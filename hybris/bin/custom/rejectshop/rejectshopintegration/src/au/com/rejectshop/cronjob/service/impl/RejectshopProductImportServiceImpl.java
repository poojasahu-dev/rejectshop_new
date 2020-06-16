/**
 * 
 */
package au.com.rejectshop.cronjob.service.impl;

import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.type.TypeService;
import de.hybris.platform.variants.model.VariantProductModel;
import de.hybris.platform.variants.model.VariantTypeModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;

import au.com.rejectshop.core.model.RejectSizeVariantProductModel;
import au.com.rejectshop.cronjob.dao.RejectshopProductDao;
import au.com.rejectshop.cronjob.service.RejectshopProductImportService;

/**
 * @author suryanarayana.d
 *
 */
public class RejectshopProductImportServiceImpl implements RejectshopProductImportService
{
	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger(RejectshopProductImportServiceImpl.class);
	
	public static final String VARIANT_TYPE = "RejectSizeVariantProduct".intern();
	
	/** The product dao. */
	private RejectshopProductDao rejectshopProductDao;

	/** The model service. */
	private ModelService modelService;
	
	/** The type service. */
	private TypeService typeService;
	
	
	/* (non-Javadoc)
	 * @see au.com.rejectshop.cronjob.service.RejectshopProductImportService#getProductVariantsForProduct(org.apache.commons.csv.CSVRecord)
	 */
	@Override
	public Collection<VariantProductModel> getProductVariantsForProduct(ProductData productData, CatalogVersionModel catalogVersion)
	{
		
		ProductModel product = rejectshopProductDao.findProductsByActualCode(catalogVersion, productData.getCode());
		Collection<VariantProductModel> variants = new ArrayList<VariantProductModel>();	
		
		if(product != null)
		{
		if(product.getVariants() == null)
		{
			final RejectSizeVariantProductModel variant = modelService.create(RejectSizeVariantProductModel.class);
			variant.setCode("12345");
			variant.setSize("20");
			variant.setBaseProduct(product);
			variants.add(variant);
			modelService.saveAll(variants);
		}
		else
		{
			for(final VariantProductModel vproduct : product.getVariants())
			{
				final RejectSizeVariantProductModel updateVariantProduct = (RejectSizeVariantProductModel) vproduct;
				updateVariantProduct.setCode(productData.getCode());
				updateVariantProduct.setSize("20");
				updateVariantProduct.setBaseProduct(product);
				variants.add(updateVariantProduct);
				modelService.saveAll(variants);
			}			
		}
		}
		return variants;
	}

	/* (non-Javadoc)
	 * @see au.com.rejectshop.cronjob.service.RejectshopProductImportService#createOrUpdateProduct(de.hybris.platform.core.model.product.ProductModel, de.hybris.platform.catalog.model.CatalogVersionModel)
	 */
	@Override
	public void createOrUpdateProduct(ProductModel productModel, CatalogVersionModel catalogVersion)
	{
		ProductModel product = rejectshopProductDao.findProductsByActualCode(catalogVersion, productModel.getCode());
		if(product == null)
		{
			modelService.save(productModel);
		}
		else
		{
			product.setCode(productModel.getCode());
			product.setDescription(productModel.getDescription());
			product.setCatalogVersion(productModel.getCatalogVersion());
			product.setSupercategories(productModel.getSupercategories());
			product.setVariants(productModel.getVariants());
			modelService.save(product);
		}
		
	}

	public VariantTypeModel createVariantType(final String variantTypeCode)
	{
		return (VariantTypeModel) typeService.getComposedTypeForCode(variantTypeCode);
	}

	/**
	 * @return the modelService
	 */
	public ModelService getModelService()
	{
		return modelService;
	}

	/**
	 * @param modelService the modelService to set
	 */
	public void setModelService(ModelService modelService)
	{
		this.modelService = modelService;
	}

	/**
	 * @return the rejectshopProductDao
	 */
	public RejectshopProductDao getRejectshopProductDao()
	{
		return rejectshopProductDao;
	}

	/**
	 * @param rejectshopProductDao the rejectshopProductDao to set
	 */
	public void setRejectshopProductDao(RejectshopProductDao rejectshopProductDao)
	{
		this.rejectshopProductDao = rejectshopProductDao;
	}

	/**
	 * @return the typeService
	 */
	public TypeService getTypeService()
	{
		return typeService;
	}

	/**
	 * @param typeService the typeService to set
	 */
	public void setTypeService(TypeService typeService)
	{
		this.typeService = typeService;
	}

	/* (non-Javadoc)
	 * @see au.com.rejectshop.cronjob.service.RejectshopProductImportService#getProductForActualCode(de.hybris.platform.catalog.model.CatalogVersionModel, java.lang.String)
	 */
	@Override
	public List<ProductModel> getProductForActualCode(CatalogVersionModel catalogVersion, String removeHyphenfromProductCode)
	{
		// YTODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see au.com.rejectshop.cronjob.service.RejectshopProductImportService#importProducts(java.util.List)
	 */
	@Override
	public void importProducts(List<ProductModel> productsModel)
	{
		// YTODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see au.com.rejectshop.cronjob.service.RejectshopProductImportService#createProduct(de.hybris.platform.core.model.product.ProductModel)
	 */
	@Override
	public void createProduct(ProductModel productModel,CatalogVersionModel catalogVersion)
	{
	   ProductModel product = rejectshopProductDao.findProductsByActualCode(catalogVersion,productModel.getCode());
		modelService.save(product);
	}

	
	

}
