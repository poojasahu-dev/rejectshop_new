/**
 * 
 */
package au.com.rejectshop.core.commerceservices.storefinder.impl;

import de.hybris.platform.basecommerce.enums.PointOfServiceTypeEnum;
import de.hybris.platform.commerceservices.search.pagedata.PageableData;
import de.hybris.platform.commerceservices.search.pagedata.PaginationData;
import de.hybris.platform.commerceservices.store.data.GeoPoint;
import de.hybris.platform.commerceservices.storefinder.data.PointOfServiceDistanceData;
import de.hybris.platform.commerceservices.storefinder.data.StoreFinderSearchPageData;
import de.hybris.platform.commerceservices.storefinder.impl.DefaultStoreFinderService;
import de.hybris.platform.store.BaseStoreModel;
import de.hybris.platform.storelocator.model.PointOfServiceModel;
import org.apache.log4j.Logger;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author shaiknajeer.b
 * 
 */
public class DefaultStoreFinderServiceExtended<ITEM extends PointOfServiceDistanceData> extends DefaultStoreFinderService
{

	private static final Logger LOG = Logger.getLogger(DefaultStoreFinderServiceExtended.class);

	@Override
	protected StoreFinderSearchPageData<ITEM> doSearch(final BaseStoreModel baseStore, final String locationText,
			final GeoPoint centerPoint, final PageableData pageableData, final Double maxRadiusKm)
	{
		final Collection<PointOfServiceModel> posResults;
		LOG.info("inside DefaultStoreFinderServiceExtended----"+baseStore +"---locaitonText"+locationText);
		final int resultRangeStart = pageableData.getCurrentPage() * pageableData.getPageSize();
		final int resultRangeEnd = (pageableData.getCurrentPage() + 1) * pageableData.getPageSize();

		if (maxRadiusKm != null)
		{
			posResults = getPointsOfServiceNear(centerPoint, maxRadiusKm.doubleValue(), baseStore);
		}
		else
		{
			final Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("baseStore", baseStore);
			paramMap.put("type", PointOfServiceTypeEnum.STORE);
			paramMap.put("isActive", true);
			posResults = getPointOfServiceGenericDao().find(paramMap);
		}

		if (posResults != null)
		{
			// Sort all the POS
			final List<ITEM> orderedResults = calculateDistances(centerPoint, posResults);
			final PaginationData paginationData = createPagination(pageableData, posResults.size());
			// Slice the required range window out of the results
			final List<ITEM> orderedResultsWindow = orderedResults.subList(Math.min(orderedResults.size(), resultRangeStart),
					Math.min(orderedResults.size(), resultRangeEnd));

			return createSearchResult(locationText, centerPoint, orderedResultsWindow, paginationData);
		}

		// Return no results
		return createSearchResult(locationText, centerPoint, Collections.<ITEM> emptyList(), createPagination(pageableData, 0));
	}

}
