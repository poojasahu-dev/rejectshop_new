/**
 * 
 */
package au.com.rejectshop.cronjob.dao;

import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.core.model.product.ProductModel;

/**
 * @author suryanarayana.d
 *
 */
public interface RejectshopPriceRowDao
{
	ProductModel findProductForCode(String code, CatalogVersionModel catalogVesion);
	
}
