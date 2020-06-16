/**
 *
 */
package au.com.rejectshop.facades.populators;

import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;


/**
 * @author soda.raveendra
 *
 */
public class ProductMetaDescriptionPopulator implements Populator<ProductModel, ProductData>
{

	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.platform.converters.Populator#populate(java.lang.Object, java.lang.Object)
	 */
	public void populate(final ProductModel source, final ProductData target) throws ConversionException
	{

		target.setMetaDescription(source.getMetaDescription());
		if (source.getProductIndicator() != null)
		{
			target.setProductIndicator(source.getProductIndicator().toString());
		}

	}

}
