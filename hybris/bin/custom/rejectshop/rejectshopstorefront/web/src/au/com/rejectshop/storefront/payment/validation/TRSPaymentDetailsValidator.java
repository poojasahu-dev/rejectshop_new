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
package au.com.rejectshop.storefront.payment.validation;


import de.hybris.platform.acceleratorservices.util.CalendarHelper;

import java.util.Calendar;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import au.com.rejectshop.storefront.payment.forms.TRSPaymentDetailsForm;


@Component("trsPaymentDetailsValidator")
public class TRSPaymentDetailsValidator implements Validator
{
	@Override
	public boolean supports(final Class<?> aClass)
	{
		return TRSPaymentDetailsForm.class.equals(aClass);
	}

	@Override
	public void validate(final Object object, final Errors errors)
	{
		final TRSPaymentDetailsForm form = (TRSPaymentDetailsForm) object;

		final Calendar start = CalendarHelper.parseDate(form.getStartMonth(), form.getStartYear());
		final Calendar expiration = CalendarHelper.parseDate(form.getExpiryMonth(), form.getExpiryYear());
		final Calendar current = Calendar.getInstance();

		if (start.after(current))
		{
			errors.rejectValue("startMonth", "payment.startDate.past.invalid");
		}

		if (expiration.before(current))
		{
			errors.rejectValue("expiryMonth", "payment.expiryDate.future.invalid");
		}

		if (start.after(expiration))
		{
			errors.rejectValue("startMonth", "payment.startDate.invalid");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "billingAddress.firstName", "address.firstName.invalid");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "billingAddress.lastName", "address.lastName.invalid");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "billingAddress.line1", "address.line1.invalid");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "billingAddress.townCity", "address.city.invalid");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "billingAddress.postcode", "address.postcode.invalid");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "billingAddress.countryIso", "address.country.invalid");
	}
}
