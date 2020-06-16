/**
 * 
 */
package au.com.rejectshop.cronjob.service;

import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.europe1.model.PriceRowModel;

import java.util.List;

/**
 * @author suryanarayana.d
 *
 */
public interface RejectshopPriceRowImportService
{

	/**
	 * @param priceRows
	 */
	void importProducts(List<PriceRowModel> priceRows);
}
