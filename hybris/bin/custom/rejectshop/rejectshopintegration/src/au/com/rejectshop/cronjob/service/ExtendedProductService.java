/**
 * 
 */
package au.com.rejectshop.cronjob.service;

import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.category.model.CategoryModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.core.model.user.AddressModel;
import de.hybris.platform.storelocator.model.PointOfServiceModel;

/**
 * @author shaiknajeer.b
 *
 */
public interface ExtendedProductService
{
	public ProductModel getProduct(String pCode, CatalogVersionModel catalogVersion);
	public CategoryModel createOrUpdateCategory(String code,CatalogVersionModel catalogVersion);
	AddressModel getAddressForPos(PointOfServiceModel pointOfServiceModel,AddressModel addressModel,CatalogVersionModel catalogVersion);
	public void createOrUpdatePOS(PointOfServiceModel pointOfServiceModel, CatalogVersionModel catalogVersion);

}
