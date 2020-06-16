/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2016 hybris AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 *
 *
 */
package au.com.rejectshop.storefront.url;

import de.hybris.platform.acceleratorservices.urlresolver.impl.DefaultSiteBaseUrlResolutionService;
import de.hybris.platform.basecommerce.model.site.BaseSiteModel;

/**
 * Responsible for generating correct URL for given page.
 */
public class DefaultTRSSiteBaseUrlResolutionService extends DefaultSiteBaseUrlResolutionService
{

	@Override
	protected String getDefaultWebsiteUrlForSite(final BaseSiteModel site, final boolean secure, final String path)
	{


			final String schemeHostAndPort;
			if (secure)
			{
				schemeHostAndPort = "https://localhost:" + lookupConfig("tomcat.ssl.port");
			}
			else
			{
				schemeHostAndPort = "http://localhost:" + lookupConfig("tomcat.http.port");
			}

			final String url = schemeHostAndPort + path;
			final String queryParams = "clear=true&site=" + site.getUid();
			return appendQueryParams(url, queryParams);


	}
}
