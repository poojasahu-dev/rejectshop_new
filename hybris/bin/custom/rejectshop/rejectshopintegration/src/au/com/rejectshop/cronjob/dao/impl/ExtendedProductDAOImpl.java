/**
 * 
 */
package au.com.rejectshop.cronjob.dao.impl;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.category.model.CategoryModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;
import de.hybris.platform.storelocator.model.PointOfServiceModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;

import au.com.rejectshop.cronjob.dao.ExtendedProductDAO;


/**
 * @author shaiknajeer.b
 * 
 */
public class ExtendedProductDAOImpl implements ExtendedProductDAO
{
   private FlexibleSearchService flexibleSearchService;
   
	@org.springframework.beans.factory.annotation.Required
	public void setFlexibleSearchService(FlexibleSearchService flexibleSearchService)
	{
		this.flexibleSearchService = flexibleSearchService;
	}


	/**
	 * @return the flexibleSearchService
	 */
	public FlexibleSearchService getFlexibleSearchService()
	{
		return flexibleSearchService;
	}

	@Override
	public ProductModel getProduct(String code, CatalogVersionModel catalogVersion)
	{
		final FlexibleSearchQuery query = new FlexibleSearchQuery( 
				"SELECT {" + ProductModel.PK + "} " 
						+ "FROM {" + ProductModel._TYPECODE + "} " 
						+ "WHERE {" + ProductModel.CODE + "}=?code " 
						+ "AND {" + ProductModel.CATALOGVERSION + "}=?catalogVersion");
		query.addQueryParameter(ProductModel.CODE, code);
		query.addQueryParameter(ProductModel.CATALOGVERSION, catalogVersion);
		final SearchResult<ProductModel> result = getFlexibleSearchService().search(query);
		final List<ProductModel> products = result.getResult();
		return CollectionUtils.isNotEmpty(products) ? products.get(0) : null;
	}
	

	@Override
	public PointOfServiceModel getAddressForPos(PointOfServiceModel pointOfServiceModel, CatalogVersionModel catalogVersion)
	{
		
		String name=pointOfServiceModel.getName();
		final StringBuilder query = new StringBuilder("SELECT {pos." + PointOfServiceModel.PK + "} ");
		query.append("FROM {" + PointOfServiceModel._TYPECODE + " AS pos} ");
		query.append("WHERE {pos." + PointOfServiceModel.NAME + "} = ?" + PointOfServiceModel.NAME);
		//query.append(" AND {pos." + PointOfServiceModel.CATALOGVERSION + "} = (?" + PointOfServiceModel.CATALOGVERSION + ")");

		final Map<String, Object> params = new HashMap<String, Object>(2);
		//params.put(PointOfServiceModel.CATALOGVERSION, catalogVersion);
		params.put(PointOfServiceModel.NAME, name);
		final List<PointOfServiceModel> pointOfServices = flexibleSearchService.<PointOfServiceModel> search(query.toString(), params).getResult();
		return CollectionUtils.isNotEmpty(pointOfServices) ? pointOfServices.get(0) : null;
	}

	@Override
	public PointOfServiceModel createOrUpdatePOS(PointOfServiceModel pointOfServiceModel, CatalogVersionModel catalogVersion)
	{
		String name=pointOfServiceModel.getName();
		final StringBuilder query = new StringBuilder("SELECT {pos." + PointOfServiceModel.PK + "} ");
		query.append("FROM {" + PointOfServiceModel._TYPECODE + " AS pos} ");
		query.append("WHERE {pos." + PointOfServiceModel.NAME + "} = ?" + PointOfServiceModel.NAME);
		//query.append(" AND {pos." + PointOfServiceModel.CATALOGVERSION + "} = (?" + PointOfServiceModel.CATALOGVERSION + ")");

		final Map<String, Object> params = new HashMap<String, Object>(2);
		//params.put(PointOfServiceModel.CATALOGVERSION, catalogVersion);
		params.put(PointOfServiceModel.NAME, name);
		final List<PointOfServiceModel> pointOfServices = flexibleSearchService.<PointOfServiceModel> search(query.toString(), params).getResult();
		return CollectionUtils.isNotEmpty(pointOfServices) ? pointOfServices.get(0) : null;
	}
	
	@Override
	public CategoryModel createOrUpdateCategory(String code, CatalogVersionModel catalogVersion)
	{
	
		return null;
	}	



}
