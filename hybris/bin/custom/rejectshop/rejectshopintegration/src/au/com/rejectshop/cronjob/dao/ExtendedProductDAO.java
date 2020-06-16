/**
 * 
 */
package au.com.rejectshop.cronjob.dao;

import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.category.model.CategoryModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.storelocator.model.PointOfServiceModel;

/**
 * @author shaiknajeer.b
 *
 */
public interface ExtendedProductDAO
{
	ProductModel getProduct(String pCode, CatalogVersionModel catalogVersion);
	CategoryModel createOrUpdateCategory(String code, CatalogVersionModel catalogVersion);
	PointOfServiceModel getAddressForPos(PointOfServiceModel pointOfServiceModel,CatalogVersionModel catalogVersion);
	public PointOfServiceModel createOrUpdatePOS(PointOfServiceModel pointOfServiceModel, CatalogVersionModel catalogVersion);


}
