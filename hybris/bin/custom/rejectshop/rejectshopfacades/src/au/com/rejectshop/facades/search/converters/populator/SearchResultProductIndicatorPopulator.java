/**
 *
 */
package au.com.rejectshop.facades.search.converters.populator;

import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.commerceservices.search.resultdata.SearchResultValueData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.Assert;


/**
 * @author Soda.raveendra
 *
 */
public class SearchResultProductIndicatorPopulator implements Populator<SearchResultValueData, ProductData>
{


	public void populate(final SearchResultValueData source, final ProductData target) throws ConversionException
	{
		Assert.notNull(source, "Parameter source cannot be null.");
		Assert.notNull(target, "Parameter target cannot be null.");
		final String productIndicator = (String) source.getValues().get("productIndicator");
		target.setProductIndicator(StringUtils.isNotEmpty(productIndicator) ? productIndicator : StringUtils.EMPTY);
	}
}
