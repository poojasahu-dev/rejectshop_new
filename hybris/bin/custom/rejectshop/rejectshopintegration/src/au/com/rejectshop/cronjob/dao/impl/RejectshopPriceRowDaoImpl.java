/**
 * 
 */
package au.com.rejectshop.cronjob.dao.impl;

import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.util.Assert;

import au.com.rejectshop.cronjob.dao.RejectshopPriceRowDao;

/**
 * @author suryanarayana.d
 *
 */
public class RejectshopPriceRowDaoImpl implements RejectshopPriceRowDao
{
	
	private FlexibleSearchService flexibleSearchService;

	/*
	 * (non-Javadoc)
	 *
	 * @see au.com.rejectshop.core.suggestion.dao.ProductPriceImportDao#findProductForCode(java.lang.String)
	 */
	@Override
	public ProductModel findProductForCode(final String code, final CatalogVersionModel catalogversion)
	{
		// YTODO Auto-generated method stub

		Assert.notNull(code, "Product Code cannot be null");
		final Map<String, Object> params = new HashMap<String, Object>();

		params.put("code", code);
		params.put("catalogVersion", catalogversion);
		final StringBuilder queryString = new StringBuilder("SELECT {").append(ProductModel.PK).append("} FROM {")
				.append(ProductModel._TYPECODE);
		queryString.append("} WHERE {").append(ProductModel.CODE).append("} =?code AND {").append(ProductModel.CATALOGVERSION)
				.append("}=?catalogVersion");
		final List<ProductModel> products = flexibleSearchService.<ProductModel> search(queryString.toString(), params).getResult();
		return (CollectionUtils.isNotEmpty(products)) ? products.get(0) : null;
	}


	/**
	 * @return the flexibleSearchService
	 */
	public FlexibleSearchService getFlexibleSearchService()
	{
		return flexibleSearchService;
	}

	/**
	 * @param flexibleSearchService
	 *           the flexibleSearchService to set
	 */
	public void setFlexibleSearchService(final FlexibleSearchService flexibleSearchService)
	{
		this.flexibleSearchService = flexibleSearchService;
	}
}
