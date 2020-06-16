/**
 *
 */
package au.com.rejectshop.storefront.forms.validation;

import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import au.com.rejectshop.storefront.constants.WebConstants;
import au.com.rejectshop.storefront.forms.SendAFriendForm;


/**
 * @author venkatapavani.t
 *
 */
@Component("sendAFriendFormValidator")
public class SendAFriendFormValidator implements Validator
{
	private static final int MESSAGE_MAX_FIELD_LENGTH = 10000;
	private static final int MAX_FIELD_LENGTH = 255;

	private static final String NAME = "name";
	private static final String EMAIL = "email";
	private static final String RECIPIENTEMAIL = "RecipientEmail";
	private static final String MESSAGE = "message";
	private static final String PRODUCTNAME = "productName";
	private static final String PRODUCTURL = "productUrl";
	private static final String PRODUCTCODE = "productCode";
	private static final String YOURNAME="yourName";

	private static final String NAME_INVALID_KEY = "sendafriend.name.invalid";
	private static final String EMAIL_INVALID_KEY = "sendafriend.email.invalid";
	private static final String RECIPIENTEMAIL_INVALID_KEY = "sendafriend.recipientemail.invalid";
	private static final String YOUR_NAME_INVALID_KEY="sendafriend.yourname.invalid";
	/*
	 * private static final String PRODUCTNAME_INVALID_KEY = "sendafriend.productnmae.invalid"; private static final
	 * String PRODUCTURL_INVALID_KEY = "sendafriend.feedbacktype.invalid"; private static final String
	 * PRODUCTCODE_INVALID_KEY = "sendafriend.feedbacktype.invalid";
	 */
	private static final String MESSAGE_REQUIRED_KEY = "sendafriend.message.required";
	private static final String MESSAGE_LIMIT_EXCEEDED_KEY = "sendafriend.message.limit.exceeded";

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	@Override
	public boolean supports(final Class<?> arg0)
	{
		return SendAFriendForm.class.equals(arg0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.validation.Validator#validate(java.lang.Object, org.springframework.validation.Errors)
	 */
	@Override
	public void validate(final Object object, final Errors errors)
	{
		final SendAFriendForm form = (SendAFriendForm) object;
		final String RecipientEmail = form.getRecipientEmail();
		//final String message = form.getMessage();
		final String email = form.getEmail();
		final String name = form.getName();
		final String yourname= form.getYourName();
		/*
		 * final String productUrl = form.getProductUrl(); final String productCode = form.getProductCode(); final String
		 * productName = form.getProductName();
		 */
		System.out.println("SEND A Friend From Validator yourname = " + yourname);
		validateStringField(name, NAME, NAME_INVALID_KEY, MAX_FIELD_LENGTH, errors);

		validateStringField(yourname, YOURNAME, YOUR_NAME_INVALID_KEY, MAX_FIELD_LENGTH, errors);
		/*
		 * validateStringField(productUrl, PRODUCTURL, PRODUCTURL_INVALID_KEY, MAX_FIELD_LENGTH, errors);
		 * validateStringField(productCode, PRODUCTCODE, PRODUCTCODE_INVALID_KEY, MAX_FIELD_LENGTH, errors);
		 * validateStringField(productName, PRODUCTNAME, PRODUCTNAME_INVALID_KEY, MAX_FIELD_LENGTH, errors);
		 */
		validateStringField(email, EMAIL, EMAIL_INVALID_KEY, MAX_FIELD_LENGTH, errors);
		if (!StringUtils.isEmpty(email))
		{
			if (!Pattern.matches(WebConstants.EMAIL_REGEX, form.getEmail()))
			{
				errors.rejectValue(EMAIL, EMAIL_INVALID_KEY);
			}
		}
		validateStringField(RecipientEmail, RECIPIENTEMAIL, RECIPIENTEMAIL_INVALID_KEY, MAX_FIELD_LENGTH, errors);
		if (!StringUtils.isEmpty(email))
		{
			if (!Pattern.matches(WebConstants.EMAIL_REGEX, form.getRecipientEmail()))
			{
				errors.rejectValue(RECIPIENTEMAIL, RECIPIENTEMAIL_INVALID_KEY);
			}
		}
		ValidationUtils.rejectIfEmpty(errors, MESSAGE, MESSAGE_REQUIRED_KEY, "Please provide details.");
		/*if (!StringUtils.isEmpty(message))
		{
			validateStringField(message, MESSAGE, MESSAGE_LIMIT_EXCEEDED_KEY, MESSAGE_MAX_FIELD_LENGTH, errors);
		}*/

	}

	/**
	 * Validate string field for empty and length
	 *
	 * @param field
	 * @param fieldKey
	 * @param fieldErrorMessage
	 * @param maxFieldLength
	 * @param errors
	 */
	protected static void validateStringField(final String field, final String fieldKey, final String fieldErrorMessage,
			final int maxFieldLength, final Errors errors)
	{
		if (StringUtils.isEmpty(field) || (StringUtils.length(field) > maxFieldLength))
		{
			errors.rejectValue(fieldKey, fieldErrorMessage);
		}
	}



}
