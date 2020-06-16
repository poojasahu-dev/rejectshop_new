/**
 * 
 */
package au.com.rejectshop.cronjob.dao.impl;

import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.storelocator.model.OpeningScheduleModel;
import de.hybris.platform.storelocator.model.PointOfServiceModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;

import au.com.rejectshop.cronjob.dao.RejectshopPOSDao;

/**
 * @author suryanarayana.d
 *
 */
public class RejectshopPOSDaoImpl implements RejectshopPOSDao
{	
	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger(RejectshopPOSDaoImpl.class);
	
	private FlexibleSearchService flexibleSearchService;

	/* (non-Javadoc)
	 * @see au.com.rejectshop.cronjob.dao.RejectshopPOSDao#findCategoriesByCode(de.hybris.platform.catalog.model.CatalogVersionModel, java.lang.String)
	 */
	@Override
	public PointOfServiceModel findPointOfServiceByName(CatalogVersionModel catalogVersion, String name)
	{
		final StringBuilder query = new StringBuilder("SELECT {pos." + PointOfServiceModel.PK + "} ");
		query.append("FROM {" + PointOfServiceModel._TYPECODE + " AS pos} ");
		query.append("WHERE {pos." + PointOfServiceModel.NAME + "} = ?" + PointOfServiceModel.NAME);
		//query.append(" AND {pos." + PointOfServiceModel.CATALOGVERSION + "} = (?" + PointOfServiceModel.CATALOGVERSION + ")");

		final Map<String, Object> params = new HashMap<String, Object>(2);
		//params.put(PointOfServiceModel.CATALOGVERSION, catalogVersion);
		params.put(PointOfServiceModel.NAME, name);
		final List<PointOfServiceModel> pointOfServices = flexibleSearchService.<PointOfServiceModel> search(query.toString(), params).getResult();
		return CollectionUtils.isNotEmpty(pointOfServices) ? pointOfServices.get(0) : null;
	}
	
	

	/* (non-Javadoc)
	 * @see au.com.rejectshop.cronjob.dao.RejectshopPOSDao#findOpeningScheduleByCode(java.lang.String)
	 */
	@Override
	public OpeningScheduleModel findOpeningScheduleByCode(String code)
	{
		
		final StringBuilder query = new StringBuilder("SELECT {os." + OpeningScheduleModel.PK + "} ");
		query.append("FROM {" + OpeningScheduleModel._TYPECODE + " AS os} ");
		query.append("WHERE {os." + OpeningScheduleModel.CODE + "} = ?" + OpeningScheduleModel.CODE);
		
		final Map<String, Object> params = new HashMap<String, Object>(1);
		params.put(OpeningScheduleModel.CODE, code);
			
		final List<OpeningScheduleModel> openingSchedules = flexibleSearchService.<OpeningScheduleModel> search(query.toString(), params).getResult();
		return CollectionUtils.isNotEmpty(openingSchedules) ? openingSchedules.get(0) : null;
	}

	/**
	 * @return the flexibleSearchService
	 */
	public FlexibleSearchService getFlexibleSearchService()
	{
		return flexibleSearchService;
	}

	/**
	 * @param flexibleSearchService the flexibleSearchService to set
	 */
	public void setFlexibleSearchService(FlexibleSearchService flexibleSearchService)
	{
		this.flexibleSearchService = flexibleSearchService;
	}


}
