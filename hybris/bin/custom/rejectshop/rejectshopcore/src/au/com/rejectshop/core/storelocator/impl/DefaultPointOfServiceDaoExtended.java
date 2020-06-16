/**
 * 
 */
package au.com.rejectshop.core.storelocator.impl;

import de.hybris.platform.basecommerce.constants.GeneratedBasecommerceConstants.TC;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.store.BaseStoreModel;
import de.hybris.platform.storelocator.GPS;
import de.hybris.platform.storelocator.exception.GeoLocatorException;
import de.hybris.platform.storelocator.exception.PointOfServiceDaoException;
import de.hybris.platform.storelocator.impl.DefaultPointOfServiceDao;
import de.hybris.platform.storelocator.impl.GeometryUtils;

import java.util.List;


/**
 * @author shaiknajeer.b
 * 
 */
public class DefaultPointOfServiceDaoExtended extends DefaultPointOfServiceDao
{


	@Override
	protected FlexibleSearchQuery buildQuery(final GPS center, final double radius, final BaseStoreModel baseStore)
			throws PointOfServiceDaoException
	{
		try
		{
			final List e = GeometryUtils.getSquareOfTolerance(center, radius);
			if (e != null && !e.isEmpty() && e.size() == 2)
			{
				final Double latMax = Double.valueOf(((GPS) e.get(1)).getDecimalLatitude());
				final Double lonMax = Double.valueOf(((GPS) e.get(1)).getDecimalLongitude());
				final Double latMin = Double.valueOf(((GPS) e.get(0)).getDecimalLatitude());
				final Double lonMin = Double.valueOf(((GPS) e.get(0)).getDecimalLongitude());
				final StringBuilder query = new StringBuilder();
				query.append("SELECT {PK} FROM {").append(TC.POINTOFSERVICE).append("} WHERE {").append("latitude")
						.append("} is not null AND {").append("longitude").append("} is not null AND {").append("latitude")
						.append("} >= ?latMin AND {").append("latitude").append("} <= ?latMax AND {").append("longitude")
						.append("} >= ?lonMin AND {").append("longitude").append("} <= ?lonMax").append(" AND {").append("isActive")
						.append("} = 1");
				if (baseStore != null)
				{
					query.append(" AND {").append("baseStore").append("} = ?baseStore");
				}

				final FlexibleSearchQuery fQuery = new FlexibleSearchQuery(query.toString());
				fQuery.addQueryParameter("latMax", latMax);
				fQuery.addQueryParameter("latMin", latMin);
				fQuery.addQueryParameter("lonMax", lonMax);
				fQuery.addQueryParameter("lonMin", lonMin);
				if (baseStore != null)
				{
					fQuery.addQueryParameter("baseStore", baseStore);
				}

				return fQuery;
			}
			else
			{
				throw new PointOfServiceDaoException("Could not fetch locations from database. Unexpected neighborhood");
			}
		}
		catch (final GeoLocatorException arg11)
		{
			throw new PointOfServiceDaoException("Could not fetch locations from database, due to :" + arg11.getMessage(), arg11);
		}
	}
}
