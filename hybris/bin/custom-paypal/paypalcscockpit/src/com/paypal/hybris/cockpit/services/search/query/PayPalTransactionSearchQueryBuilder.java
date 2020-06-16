/**
 *
 */
package com.paypal.hybris.cockpit.services.search.query;

import de.hybris.platform.cscockpit.services.search.generic.query.AbstractCsFlexibleSearchQueryBuilder;
import de.hybris.platform.cscockpit.services.search.impl.DefaultCsTextSearchCommand;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;


public class PayPalTransactionSearchQueryBuilder extends AbstractCsFlexibleSearchQueryBuilder<DefaultCsTextSearchCommand>
{
	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.platform.cscockpit.services.search.generic.query.AbstractCsFlexibleSearchQueryBuilder#
	 * buildFlexibleSearchQuery(de.hybris.platform.cscockpit.services.search.CsSearchCommand)
	 */
	@Override
	protected FlexibleSearchQuery buildFlexibleSearchQuery(final DefaultCsTextSearchCommand command)
	{
		final StringBuilder query = new StringBuilder(300);

		query.append("SELECT DISTINCT {o:pk}, {o:code} ");
		query.append("FROM {Order AS o }");

		final FlexibleSearchQuery searchQuery = new FlexibleSearchQuery(query.toString());

		return searchQuery;
	}

	public static enum TextField
	{
		StartDate, EndDate, TransactionId, Payer;
	}
}
