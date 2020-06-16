/**
 * 
 */
package au.com.rejectshop.cronjob.dao.impl;

import static de.hybris.platform.servicelayer.util.ServicesUtil.validateParameterNotNull;

import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.internal.dao.DefaultGenericDao;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.SearchResult;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;

import au.com.rejectshop.cronjob.dao.RejectshopProductDao;


/**
 * The Class RejectshopProductDaoImpl.
 */
public class RejectshopProductDaoImpl extends DefaultGenericDao<ProductModel> implements RejectshopProductDao
{
	
	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger(RejectshopProductDaoImpl.class);

	/**
	 * Instantiates a new rejectshop product dao impl.
	 *
	 * @param typecode the typecode
	 */
	public RejectshopProductDaoImpl(final String typecode)
	{
		super(typecode);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * au.com.pillowtalk.core.dao.cronjob.PillowtalkProductDao#findProductsByActualCode(de.hybris.platform.catalog.model
	 * .CatalogVersionModel, java.lang.String)
	 */
	@Override
	public ProductModel findProductsByActualCode(final CatalogVersionModel catalogVersion, final String code)
	{
		LOG.debug("Searching Products with ActualProduct Code::");

		validateParameterNotNull(catalogVersion, "CatalogVersion must not be null!");
		validateParameterNotNull(code, "Product code must not be null!");

		final FlexibleSearchQuery query = new FlexibleSearchQuery( //
				"SELECT {" + ProductModel.PK + "} " //
						+ "FROM {" + ProductModel._TYPECODE + "} " //
						+ "WHERE {" + ProductModel.CODE + "}=?code " //
						+ "AND {" + ProductModel.CATALOGVERSION + "}=?catalogVersion");
		query.addQueryParameter(ProductModel.CODE, code);
		query.addQueryParameter(ProductModel.CATALOGVERSION, catalogVersion);
		final SearchResult<ProductModel> result = getFlexibleSearchService().search(query);
		final List<ProductModel> products = result.getResult();

		return CollectionUtils.isNotEmpty(products) ? products.get(0) : null;
	}
	
	

}
