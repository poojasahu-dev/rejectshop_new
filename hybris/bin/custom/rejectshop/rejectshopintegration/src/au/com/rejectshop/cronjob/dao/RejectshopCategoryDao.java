/**
 * 
 */
package au.com.rejectshop.cronjob.dao;

import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.category.model.CategoryModel;

import java.util.Collection;
import java.util.List;

/**
 * @author suryanarayana.d
 *
 */
public interface RejectshopCategoryDao
{
	
	List<CategoryModel> getSuperCategories(final String categoryCodes);
	Collection<CategoryModel> findCategoriesByCode(CatalogVersionModel catalogVersion, String code);
}
