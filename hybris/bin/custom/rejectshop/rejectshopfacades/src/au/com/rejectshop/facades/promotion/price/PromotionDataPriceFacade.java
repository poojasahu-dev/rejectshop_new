/**
 *
 */
package au.com.rejectshop.facades.promotion.price;

import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.core.model.product.ProductModel;


/**
 * @author saisravan.k
 *
 */
public interface PromotionDataPriceFacade
{
	public void setPricePromotionData(ProductData productData, ProductModel productModel);
}
