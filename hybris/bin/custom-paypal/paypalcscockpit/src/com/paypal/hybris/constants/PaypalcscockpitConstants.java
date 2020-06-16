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
package com.paypal.hybris.constants;

/**
 * Global class for all Paypalcscockpit constants. You can add global constants for your extension into this class.
 */
public final class PaypalcscockpitConstants extends GeneratedPaypalcscockpitConstants
{
	public static final String EXTENSIONNAME = "paypalcscockpit";

	public static final String TRANSACTION_SEARCH_DATE_FORMAT = "MM/dd/yy h:mm a";
	public static final String TRANSACTION_SEARCH_RESULT_DATE_FORMAT = "MMM dd, yyyy h:mm a";
	public static final String DEFAULT_SEARCH_START_DATE = "Feb 23, 2015";

	public static final String EMTY_INPUT_VALUE = "Please input amount";
	public static final String VALUE_SHOULD_BE_LESS = "Input value should be less than ";
	public static final String WRONG_FORMAT = "Wrong number format.";

	public static final String ZERO_NEGATIVE_AMOUNT = "Amount is zero or negative.";

	public static final String AMOUNT_MORE_THAN_AUTH = "Input amount more than capture transaction amount: ";

	public static final String INVALID_TRANSACTION = "Transaction id is invalid";

	public static final String TOO_BIG_AMOUNT = "Input amount more than authorized amount";

	public static final String ALREADY_CAPTURED = "You already captured all authorization amount.";

	public static final String TOO_BIG_AMOUNT_VALUE = "Input amount more than already captured. Available amount For capture is : ";

	public static final String STATUS_SHOULD_BE_COMPLETE = "Complete type should be COMPLETE.";

	private PaypalcscockpitConstants()
	{
		//empty to avoid instantiating this constant class
	}

	// implement here constants used by this extension
}
