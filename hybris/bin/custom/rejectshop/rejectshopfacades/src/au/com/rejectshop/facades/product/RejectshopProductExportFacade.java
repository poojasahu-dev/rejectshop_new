/**
 *
 */
package au.com.rejectshop.facades.product;

import de.hybris.platform.commercefacades.product.ProductOption;

import java.util.List;


/**
 * @author soda.raveendra
 *
 */
public interface RejectshopProductExportFacade
{
	/***
	 *
	 * @param catalogId
	 * @param catalogVersion
	 * @param options
	 * @param start
	 * @param count
	 * @param exportToFolderPath
	 */
	public void exportProductsForLasoo(final String catalogId, final String catalogVersion, final List<ProductOption> options,
			final int start, final int count);
}
