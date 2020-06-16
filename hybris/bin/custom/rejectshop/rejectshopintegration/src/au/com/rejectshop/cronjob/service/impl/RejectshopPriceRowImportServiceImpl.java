/**
 * 
 */
package au.com.rejectshop.cronjob.service.impl;

import de.hybris.platform.catalog.CatalogVersionService;
import de.hybris.platform.catalog.enums.ArticleApprovalStatus;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.europe1.model.PriceRowModel;
import de.hybris.platform.servicelayer.model.ModelService;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;

import au.com.rejectshop.cronjob.dao.RejectshopPriceRowDao;
import au.com.rejectshop.cronjob.service.RejectshopPriceRowImportService;


/**
 * @author suryanarayana.d
 *
 */
public class RejectshopPriceRowImportServiceImpl implements RejectshopPriceRowImportService
{

	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger(RejectshopPriceRowImportServiceImpl.class);


	private ModelService modelService;

	private RejectshopPriceRowDao rejectshopPriceRowDao;

	/** The catalog version service. */
	private CatalogVersionService catalogVersionService;

	/** The catalog id. */
	private String catalogId;

	/** The catalog version name. */
	private String catalogVersionName;


	/*
	 * (non-Javadoc)
	 * 
	 * @see au.com.rejectshop.cronjob.service.RejectshopPriceRowImportService#importProducts(java.util.List)
	 */
	@Override
	public void importProducts(List<PriceRowModel> priceRows)
	{
		CatalogVersionModel catalogVersion = catalogVersionService.getCatalogVersion(catalogId, catalogVersionName);

		try
		{

			for (PriceRowModel priceRow : priceRows)
			{
				final ProductModel productModel = rejectshopPriceRowDao.findProductForCode(priceRow.getProductId(), catalogVersion);

				if (productModel == null)
				{
					createProduct(priceRow, catalogVersion);
					modelService.save(priceRow);

				}
				else
				{
					final Collection<PriceRowModel> productPriceRowsCollection = productModel.getEurope1Prices();

					if (CollectionUtils.isNotEmpty(productPriceRowsCollection))
					{
						//final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);


						for (final PriceRowModel assignedPriceRows : productPriceRowsCollection)
						{
							Date startDate = priceRow.getStartTime();

							if (assignedPriceRows.getStartTime() != null && assignedPriceRows.getStartTime().before(startDate)
									&& !assignedPriceRows.getStartTime().equals(startDate))
							{
								modelService.save(priceRow);
							}
						}
					}

				}

			}
		}

		catch (Exception exception)
		{

			LOG.error(exception);
		}

	}

	/**
	 * Creates the product.
	 *
	 * @param priceRow the price row
	 * @param catalogVersion the catalog version
	 */
	private void createProduct(PriceRowModel priceRow, CatalogVersionModel catalogVersion)
	{
		LOG.info("Creating Product.." + priceRow.getProductId());
		ProductModel createProduct = modelService.create(ProductModel.class);
		createProduct.setCode(priceRow.getProductId());
		createProduct.setCatalogVersion(catalogVersion);
		createProduct.setApprovalStatus(ArticleApprovalStatus.CHECK);
		modelService.saveAll(createProduct);
		LOG.info(" Prodcut Created Successfully..." + priceRow.getProductId());
	}

	/**
	 * @return the modelService
	 */
	public ModelService getModelService()
	{
		return modelService;
	}



	/**
	 * @return the rejectshopPriceRowDao
	 */
	public RejectshopPriceRowDao getRejectshopPriceRowDao()
	{
		return rejectshopPriceRowDao;
	}



	/**
	 * @return the catalogVersionService
	 */
	public CatalogVersionService getCatalogVersionService()
	{
		return catalogVersionService;
	}



	/**
	 * @return the catalogId
	 */
	public String getCatalogId()
	{
		return catalogId;
	}



	/**
	 * @return the catalogVersionName
	 */
	public String getCatalogVersionName()
	{
		return catalogVersionName;
	}





	/**
	 * @param modelService
	 *           the modelService to set
	 */
	public void setModelService(ModelService modelService)
	{
		this.modelService = modelService;
	}



	/**
	 * @param rejectshopPriceRowDao
	 *           the rejectshopPriceRowDao to set
	 */
	public void setRejectshopPriceRowDao(RejectshopPriceRowDao rejectshopPriceRowDao)
	{
		this.rejectshopPriceRowDao = rejectshopPriceRowDao;
	}



	/**
	 * @param catalogVersionService
	 *           the catalogVersionService to set
	 */
	public void setCatalogVersionService(CatalogVersionService catalogVersionService)
	{
		this.catalogVersionService = catalogVersionService;
	}



	/**
	 * @param catalogId
	 *           the catalogId to set
	 */
	public void setCatalogId(String catalogId)
	{
		this.catalogId = catalogId;
	}



	/**
	 * @param catalogVersionName
	 *           the catalogVersionName to set
	 */
	public void setCatalogVersionName(String catalogVersionName)
	{
		this.catalogVersionName = catalogVersionName;
	}


}
