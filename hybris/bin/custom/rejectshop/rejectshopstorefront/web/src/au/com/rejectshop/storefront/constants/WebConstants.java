/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2013 hybris AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 *
 *
 */
package au.com.rejectshop.storefront.constants;

/**
 * Constants used in the Web tier
 */
public final class WebConstants
{
	private WebConstants()
	{
		//empty
	}

	public static final String MODEL_KEY_ADDITIONAL_BREADCRUMB = "additionalBreadcrumb";

	public static final String BREADCRUMBS_KEY = "breadcrumbs";

	public static final String CONTINUE_URL = "session_continue_url";

	public static final String CART_RESTORATION = "cart_restoration";

	public static final String ANONYMOUS_CHECKOUT = "anonymous_checkout";

	public static final String URL_ENCODING_ATTRIBUTES = "encodingAttributes";

	public static final String LANGUAGE_ENCODING = "languageEncoding";

	public static final String CURRENCY_ENCODING = "currencyEncoding";

	public static final String PAGE_LABEL = "pageLabel";

	public static final String EMAIL_REGEX = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}\\b";

	public static final String PHONENUMBER_REGEX = "[0-9 ]*";

	public static final String BREADCRUMBS_ADDITIONAL_LINK_KEY = "breadcrumbsAdditionalLinkKey";

	public static final String BREADCRUMBS_ADDITIONAL_LINK_URL = "breadcrumbsAdditionalLinkURL";

	public static final String CUSTOMER_FEEDBACK_MAIL_TO = "feedback@rejectshop.com.au";
	public static final String TEALIUM_UTAG_ACCOUNT = "tealium.utag.account";
	public static final String TEALIUM_UTAG_PROFILE = "tealium.utag.profile";
	public static final String TEALIUM_UTAG_ENV = "tealium.utag.env";

}
