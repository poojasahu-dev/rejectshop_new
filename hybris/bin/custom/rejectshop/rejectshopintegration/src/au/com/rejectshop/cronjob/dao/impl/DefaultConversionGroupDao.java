/**
 *
 */
package au.com.rejectshop.cronjob.dao.impl;

import de.hybris.platform.mediaconversion.model.ConversionGroupModel;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;

import au.com.rejectshop.cronjob.dao.ConversionGroupDAO;


/**
 * @author Subrahmanyam.n
 *
 */
public class DefaultConversionGroupDao implements ConversionGroupDAO
{
	private FlexibleSearchService searchService;

	/*
	 * Get the media conversion group by the code.
	 */

	@Override
	public ConversionGroupModel getDefaultConversionGroup(final String code)
	{

		final StringBuilder queryString = new StringBuilder("SELECT {").append(ConversionGroupModel.PK).append("}");
		queryString.append("FROM{").append(ConversionGroupModel._TYPECODE);
		queryString.append("} WHERE {").append(ConversionGroupModel.CODE).append("}=?code");

		final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString.toString());

		query.addQueryParameter("code", code);

		return  (ConversionGroupModel) getSearchService().searchUnique(query);
	}

	/**
	 * @return searchService
	 */
	public FlexibleSearchService getSearchService()
	{
		return searchService;
	}

	/**
	 * @param searchService
	 */

	public void setSearchService(final FlexibleSearchService searchService)
	{
		this.searchService = searchService;
	}
}
