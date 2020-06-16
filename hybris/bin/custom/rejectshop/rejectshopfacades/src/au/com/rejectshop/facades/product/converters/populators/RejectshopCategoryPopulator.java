/**
 * 
 */
package au.com.rejectshop.facades.product.converters.populators;

import de.hybris.platform.category.model.CategoryModel;
import de.hybris.platform.commercefacades.product.converters.populator.CategoryPopulator;
import de.hybris.platform.commercefacades.product.data.CategoryData;


/**
 * @author venkatapavani.t
 * 
 */
public class RejectshopCategoryPopulator extends CategoryPopulator
{

	@Override
	public void populate(final CategoryModel source, final CategoryData target)
	{
		target.setPicture(source.getPicture());
		target.setPriority(source.getPriority());
		target.setCategoryBanner(source.getCategoryBanner());
		super.populate(source, target);
	}
}
