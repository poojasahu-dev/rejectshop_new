/**
 * 
 */
package au.com.rejectshop.cronjob.dao;

import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.core.model.product.ProductModel;

import java.util.List;

/**
 * @author suryanarayana.d
 *
 */
public interface RejectShopCatalogDao
{
	List<ProductModel> findProductsByActualCode(final CatalogVersionModel catalogVersion, final String code);
	
	List<ProductModel> findCategoryByActualCode(final CatalogVersionModel catalogVersion, final String code);
}
