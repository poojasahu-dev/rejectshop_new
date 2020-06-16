/**
 *
 */
package com.paypal.hybris.validation.utils;

import de.hybris.platform.cscockpit.exceptions.ResourceMessage;
import de.hybris.platform.cscockpit.exceptions.ValidationException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.commons.lang.StringUtils;

import com.paypal.hybris.constants.PaypalcscockpitConstants;


/**
 *
 */
public class PayPalDummyAmountUtils
{
	private static final int MAX_AMOUNT_LENGTH = 20;

	public static BigDecimal validateAmount(final String refundAmount) throws ValidationException
	{
		BigDecimal amount = null;

		if (StringUtils.isEmpty(refundAmount))
		{
			throwValidateException(PaypalcscockpitConstants.EMTY_INPUT_VALUE);
		}

		if (refundAmount.length() > MAX_AMOUNT_LENGTH)
		{
			throwValidateException(PaypalcscockpitConstants.VALUE_SHOULD_BE_LESS + MAX_AMOUNT_LENGTH);
		}

		try
		{
			amount = new BigDecimal(refundAmount);
		}
		catch (final NumberFormatException exception)
		{
			throwValidateException(PaypalcscockpitConstants.WRONG_FORMAT);
		}

		if (amount.compareTo(BigDecimal.ZERO) < 0 || amount.compareTo(BigDecimal.ZERO) == 0)
		{
			throwValidateException(PaypalcscockpitConstants.ZERO_NEGATIVE_AMOUNT);
		}

		return amount;
	}

	public static void throwValidateException(final String message) throws ValidationException
	{
		final ResourceMessage errorMessage = new ResourceMessage(message);
		throw new ValidationException(new ArrayList<ResourceMessage>(Arrays.asList(errorMessage)));
	}
}
