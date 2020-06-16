/**
 * 
 */
package au.com.rejectshop.cronjob.dao;

import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.storelocator.model.OpeningScheduleModel;
import de.hybris.platform.storelocator.model.PointOfServiceModel;


// TODO: Auto-generated Javadoc
/**
 * The Interface RejectshopPOSDao.
 */
public interface RejectshopPOSDao
{
	
	/**
	 * Find point of service by name.
	 *
	 * @param catalogVersion the catalog version
	 * @param name the name
	 * @return the point of service model
	 */
	public PointOfServiceModel findPointOfServiceByName(final CatalogVersionModel catalogVersion, final String name);
	
	/**
	 * Find opening schedule by code.
	 *
	 * @param code the code
	 * @return the opening schedule model
	 */
	public OpeningScheduleModel findOpeningScheduleByCode(final String code);
}
