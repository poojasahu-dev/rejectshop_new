/**
 *
 */
package au.com.rejectshop.cronjob.service;

/**
 * @author Subrahmanyam.N
 *
 */
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.core.model.media.MediaContainerModel;
import de.hybris.platform.core.model.product.ProductModel;

import java.util.List;


public interface ProductToMediaService
{

	/**
	 * Assigns the converted media formats to the product and Returns ProductModel with Media
	 *
	 * @param imageFileName
	 * @param mediaContainer
	 * @param catalogVersion
	 * @return ProductModel
	 */
	List<ProductModel> setMediasToProduct(String imageFileName, MediaContainerModel mediaContainer,
			CatalogVersionModel catalogVersion);
}
