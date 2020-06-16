/**
 * 
 */
package au.com.rejectshop.cronjob.service;

import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.category.model.CategoryModel;

import java.util.List;

/**
 * @author suryanarayana.d
 *
 */
public interface RejectshopCategoryImportService
{
	/**
	 * @param categoryModel
	 * @param catalogVersion
	 */
	public void createOrUpdateCategory(CategoryModel categoryModel, CatalogVersionModel catalogVersion);
}
