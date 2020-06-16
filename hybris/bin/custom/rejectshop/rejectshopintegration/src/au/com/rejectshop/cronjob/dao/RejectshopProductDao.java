/**
 * 
 */
package au.com.rejectshop.cronjob.dao;

import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.core.model.product.ProductModel;

/**
 * The Interface RejectshopProductDao.
 */
public interface RejectshopProductDao
{
	
	/**
	 * Find products by actual code.
	 *
	 * @param catalogVersion the catalog version
	 * @param code the code
	 * @return the product model
	 */
	ProductModel findProductsByActualCode(final CatalogVersionModel catalogVersion, final String code);
}
