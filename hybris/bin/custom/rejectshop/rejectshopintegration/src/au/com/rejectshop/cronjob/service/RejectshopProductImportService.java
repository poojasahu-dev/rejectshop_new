/**
 * 
 */
package au.com.rejectshop.cronjob.service;

import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.europe1.model.PriceRowModel;
import de.hybris.platform.variants.model.VariantProductModel;

import java.util.Collection;
import java.util.List;

import org.apache.commons.csv.CSVRecord;

import au.com.rejectshop.core.model.RejectSizeVariantProductModel;

/**
 * @author suryanarayana.d
 *
 */
public interface RejectshopProductImportService
{
	/**
	 * @param csvRecord
	 * @param catalogVersion 
	 * @return
	 */
	Collection<VariantProductModel> getProductVariantsForProduct(ProductData productData, CatalogVersionModel catalogVersion);

	/**
	 * @param productModel
	 * @param catalogVersion
	 */
	void createOrUpdateProduct(ProductModel productModel, CatalogVersionModel catalogVersion);

	/**
	 * @param catalogVersion
	 * @param removeHyphenfromProductCode
	 * @return
	 */
	List<ProductModel> getProductForActualCode(CatalogVersionModel catalogVersion, String removeHyphenfromProductCode);

	/**
	 * @param productsModel
	 */
	void importProducts(List<ProductModel> productsModel);
	
	void createProduct(ProductModel productModel,CatalogVersionModel catalogVersion);
	
	
}
