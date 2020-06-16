package au.com.rejectshop.storefront.util;

import de.hybris.platform.acceleratorservices.storefront.util.PageTitleResolver;
import de.hybris.platform.category.model.CategoryModel;
import de.hybris.platform.cms2.model.site.CMSSiteModel;
import de.hybris.platform.core.model.product.ProductModel;

import java.util.List;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;


/**
 * Created by hkhurana on 13/11/2017.
 */

public class RejectShopPageTitleResolver extends PageTitleResolver {

	@Override
    public String resolveProductPageTitle(final ProductModel product)
    {
        // Lookup categories
        final List<CategoryModel> path = getCategoryPath(product);
        // Lookup site (or store)
        final CMSSiteModel currentSite = getCmsSiteService().getCurrentSite();

        // Construct page title
        final String identifier = product.getName();
        final String articleNumber = product.getCode();
        final String productName = StringUtils.isEmpty(identifier) ? articleNumber : identifier;

		final StringBuilder builder = new StringBuilder();
		if (StringUtils.isEmpty(product.getPageTitle()))
		{
			builder.append(productName);

        for (final CategoryModel pathElement : path)
        {

            if (! pathElement.getCode().equalsIgnoreCase("TRS"))
				{
            builder.append(TITLE_WORD_SEPARATOR.trim()).append(pathElement.getName());
        }
			}

        if (currentSite != null)
        {
            builder.append(TITLE_WORD_SEPARATOR.trim()).append(currentSite.getName());
        }

		}
		else
		{
			builder.append(product.getPageTitle());
		}


        return StringEscapeUtils.escapeHtml(builder.toString());
    }

}
