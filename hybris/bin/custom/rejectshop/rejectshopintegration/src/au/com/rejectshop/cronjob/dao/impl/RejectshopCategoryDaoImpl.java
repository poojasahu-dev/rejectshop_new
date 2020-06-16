/**
 * 
 */
package au.com.rejectshop.cronjob.dao.impl;

import static de.hybris.platform.servicelayer.util.ServicesUtil.validateParameterNotNull;

import de.hybris.platform.catalog.CatalogVersionService;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.category.CategoryService;
import de.hybris.platform.category.model.CategoryModel;
import de.hybris.platform.servicelayer.internal.dao.DefaultGenericDao;
import de.hybris.platform.servicelayer.model.ModelService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;

import au.com.rejectshop.cronjob.dao.RejectshopCategoryDao;

/**
 * @author suryanarayana.d
 *
 */
public class RejectshopCategoryDaoImpl extends DefaultGenericDao<CategoryModel> implements RejectshopCategoryDao
{	
	private static final Logger LOG = Logger.getLogger(RejectshopCategoryDaoImpl.class);
	
	private ModelService modelService;
	private CatalogVersionService catalogVersionService;
	private CategoryService categoryService;
	private String catalogId;
	private String catalogVersionName;

	/**
	 * @param typecode
	 */
	public RejectshopCategoryDaoImpl(String typecode)
	{
		super(typecode);
		// YTODO Auto-generated constructor stub
	}
	//

	/* (non-Javadoc)
	 * @see au.com.rejectshop.cronjob.dao.RejectshopCategoryDao#findCategoriesByCode(de.hybris.platform.catalog.model.CatalogVersionModel, java.lang.String)
	 */
	@Override
	public Collection<CategoryModel> findCategoriesByCode(CatalogVersionModel catalogVersion, String code)
	{
		LOG.debug("Searching Products with ActualProduct Code::");

		validateParameterNotNull(catalogVersion, "CatalogVersion must not be null!");
		validateParameterNotNull(code, "Product code must not be null!");

		final Map parameters = new HashMap();
		parameters.put(CategoryModel.CODE, code);
		parameters.put(CategoryModel.CATALOGVERSION, catalogVersion);

		return find(parameters);
	}

	/* (non-Javadoc)
	 * @see au.com.rejectshop.cronjob.dao.RejectshopCategoryDao#getSuperCategories(java.lang.String)
	 */
	@Override
	public List<CategoryModel> getSuperCategories(String categoryCodes)
	{
		CategoryModel categoryModel;
		Collection<CategoryModel> superCategories = new ArrayList<CategoryModel>();		
		CatalogVersionModel catalogVersion = catalogVersionService.getCatalogVersion(catalogId, catalogVersionName);
		final String[] list = categoryCodes.split(",");

		for(final String categoryCode : list)
		{						
			if(CollectionUtils.isEmpty(categoryService.getCategoriesForCode(categoryCode)))
			{
				createCategoryByCode(catalogVersion,categoryCode);
			}
			
			categoryModel = categoryService.getCategoryForCode(catalogVersion,categoryCode);
			
			superCategories.add(categoryModel);
		}	
		return (List<CategoryModel>) superCategories;
	}

	/* (non-Javadoc)
	 * @see au.com.rejectshop.cronjob.dao.RejectshopCategoryDao#createCategoryByCode(de.hybris.platform.catalog.model.CatalogVersionModel, java.lang.String)
	 */

	private void createCategoryByCode(CatalogVersionModel catalogVersion, String categoryCode)
	{
		final CategoryModel categoryModel = modelService.create(CategoryModel.class);
		categoryModel.setCode(categoryCode);
		categoryModel.setCatalogVersion(catalogVersion);
		modelService.save(categoryModel);
		
	}

	/**
	 * @return the modelService
	 */
	public ModelService getModelService()
	{
		return modelService;
	}

	/**
	 * @return the catalogVersionService
	 */
	public CatalogVersionService getCatalogVersionService()
	{
		return catalogVersionService;
	}

	/**
	 * @return the categoryService
	 */
	public CategoryService getCategoryService()
	{
		return categoryService;
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
	 * @param modelService the modelService to set
	 */
	public void setModelService(ModelService modelService)
	{
		this.modelService = modelService;
	}

	/**
	 * @param catalogVersionService the catalogVersionService to set
	 */
	public void setCatalogVersionService(CatalogVersionService catalogVersionService)
	{
		this.catalogVersionService = catalogVersionService;
	}

	/**
	 * @param categoryService the categoryService to set
	 */
	public void setCategoryService(CategoryService categoryService)
	{
		this.categoryService = categoryService;
	}

	/**
	 * @param catalogId the catalogId to set
	 */
	public void setCatalogId(String catalogId)
	{
		this.catalogId = catalogId;
	}

	/**
	 * @param catalogVersionName the catalogVersionName to set
	 */
	public void setCatalogVersionName(String catalogVersionName)
	{
		this.catalogVersionName = catalogVersionName;
	}
}
