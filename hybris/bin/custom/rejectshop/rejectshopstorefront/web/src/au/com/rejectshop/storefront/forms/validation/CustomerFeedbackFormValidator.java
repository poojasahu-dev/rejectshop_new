package au.com.rejectshop.storefront.forms.validation;

import java.util.regex.Pattern;

import au.com.rejectshop.storefront.controllers.pages.CustomerFeedbackPageController;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import au.com.rejectshop.storefront.constants.WebConstants;
import au.com.rejectshop.storefront.forms.CustomerFeedbackForm;




/**
 * @author hina1460
 * @version $Rev$
 */
@Component("customerFeedbackFormValidator")
public class CustomerFeedbackFormValidator implements Validator
{

	private static final int MESSAGE_MAX_FIELD_LENGTH = 10000;
	private static final int MAX_FIELD_LENGTH = 255;

	private static final String FIRSTNAME = "firstName";
	private static final String SURNAME = "surName";
	private static final String EMAILADDRESS = "emailAddress";
	private static final String FEEDBACK_TYPE = "feedbackType";
	private static final String PHONENUMER = "phoneNumber";
	private static final String MESSAGE = "message";
	private static final String FEEDBACK_SUB_TYPE = "feedbackSubType";
	private static final String STORE_VISITED="storeVisited";

	private static final String FIRSTNAME_INVALID_KEY = "customerfeedback.firstname.invalid";
	private static final String SURNAME_INVALID_KEY = "customerfeedback.surname.invalid";
	private static final String EMAILADDRESS_INVALID_KEY = "customerfeedback.emailAddress.invalid";
	private static final String PHONENUMER_INVALID_KEY = "customerfeedback.phonenumber.invalid";
	private static final String FEEDBACK_TYPE_INVALID_KEY = "customerfeedback.feedbacktype.invalid";
	private static final String MESSAGE_REQUIRED_KEY = "customerfeedback.message.required";
	private static final String MESSAGE_LIMIT_EXCEEDED_KEY = "customerfeedback.message.limit.exceeded";
	private static final String FEEDBACK_SUB_TYPE_INVALID_KEY="customerfeedback.feedbackSubType.invalid";
	private static final String STORE_VISITED_INVALID_KEY="customerfeedback.storeVisited.invalid";

	/**
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	@Override
	public boolean supports(final Class<?> arg0)
	{
		return CustomerFeedbackForm.class.equals(arg0);
	}

	/**
	 * Validate form inputs
	 *
	 * @see org.springframework.validation.Validator#validate(java.lang.Object, org.springframework.validation.Errors)
	 */
	@Override
	public void validate(final Object object, final Errors errors)
	{
		final CustomerFeedbackForm form = (CustomerFeedbackForm) object;
		final String phoneNumber = form.getPhoneNumber();
		final String message = form.getMessage();
		final String email = form.getEmailAddress();
		final String feedbackSubType=form.getFeedbackSubType();
		final String feedbackType=form.getFeedbackType();
		validateStringField(form.getFirstName(), FIRSTNAME, FIRSTNAME_INVALID_KEY, MAX_FIELD_LENGTH, errors);
		validateStringField(form.getSurName(), SURNAME, SURNAME_INVALID_KEY, MAX_FIELD_LENGTH, errors);
		validateStringField(email, EMAILADDRESS, EMAILADDRESS_INVALID_KEY, MAX_FIELD_LENGTH, errors);
		if (!StringUtils.isEmpty(email))
		{
			if (!Pattern.matches(WebConstants.EMAIL_REGEX, form.getEmailAddress()))
			{
				errors.rejectValue(EMAILADDRESS, EMAILADDRESS_INVALID_KEY);
			}
		}
		if (!StringUtils.isEmpty(phoneNumber))
		{
			if (!Pattern.matches(WebConstants.PHONENUMBER_REGEX, phoneNumber))
			{
				errors.rejectValue(PHONENUMER, PHONENUMER_INVALID_KEY);
			}
		}
		ValidationUtils.rejectIfEmpty(errors, FEEDBACK_TYPE, FEEDBACK_TYPE_INVALID_KEY, "Please select from drop down list.");
		ValidationUtils.rejectIfEmpty(errors, MESSAGE, MESSAGE_REQUIRED_KEY, "Please provide details.");
		if (!StringUtils.isEmpty(message))
		{
			validateStringField(message, MESSAGE, MESSAGE_LIMIT_EXCEEDED_KEY, MESSAGE_MAX_FIELD_LENGTH, errors);
		}
		if (!StringUtils.isEmpty(feedbackType) && (feedbackType.equalsIgnoreCase(CustomerFeedbackPageController.STAFF_COURTESY)|| feedbackType.equalsIgnoreCase(CustomerFeedbackPageController.STORE_EXPERIENCE))){
			ValidationUtils.rejectIfEmpty(errors, FEEDBACK_SUB_TYPE, FEEDBACK_SUB_TYPE_INVALID_KEY);
			ValidationUtils.rejectIfEmpty(errors, STORE_VISITED, STORE_VISITED_INVALID_KEY);
		}

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
