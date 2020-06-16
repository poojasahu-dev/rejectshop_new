package au.com.rejectshop.storefront.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;




/**
 * Form for taking customer feedback
 *
 * @author hina1460
 * @version $Rev$
 */
public class CustomerFeedbackForm
{
	private String titleCode;
	private String firstName;
	private String surName;
	private String emailAddress;
	private String phoneNumber;
	private String storeVisited;
	private String dateVisited;
	private String feedbackType;
	private String message;
	private String dayofReminder;
	private String feedbackSubType;


	public String getFeedbackSubType() {
		return feedbackSubType;
	}

	public void setFeedbackSubType(String feedbackSubType) {
		this.feedbackSubType = feedbackSubType;
	}

	/**
	 * Accesses the titleCode
	 *
	 * @return the titleCode
	 */
	public String getTitleCode()
	{
		return titleCode;
	}

	/**
	 * Sets the titleCode
	 *
	 * @param titleCode
	 *           the titleCode to set
	 */
	public void setTitleCode(final String titleCode)
	{
		this.titleCode = titleCode;
	}

	/**
	 * Accesses the firstName
	 *
	 * @return the firstName
	 */
	@NotNull(message = "{customerfeedback.firstname.invalid}")
	@Size(min = 1, max = 255, message = "{customerfeedback.firstname.invalid}")
	public String getFirstName()
	{
		return firstName;
	}

	/**
	 * Sets the firstName
	 *
	 * @param firstName
	 *           the firstName to set
	 */
	public void setFirstName(final String firstName)
	{
		this.firstName = firstName;
	}

	/**
	 * Accesses the surName
	 *
	 * @return the surName
	 */
	@NotNull(message = "{customerfeedback.surname.invalid}")
	@Size(min = 1, max = 255, message = "{customerfeedback.surname.invalid}")
	public String getSurName()
	{
		return surName;
	}

	/**
	 * Sets the surName
	 *
	 * @param surName
	 *           the surName to set
	 */
	public void setSurName(final String surName)
	{
		this.surName = surName;
	}

	/**
	 * Accesses the emailAddress
	 *
	 * @return the emailAddress
	 */
	@NotNull(message = "{customerfeedback.emailaddress.invalid}")
	@Size(min = 1, max = 255, message = "{customerfeedback.emailaddress.invalid}")
	public String getEmailAddress()
	{
		return emailAddress;
	}

	/**
	 * Sets the emailAddress
	 *
	 * @param emailAddress
	 *           the emailAddress to set
	 */
	public void setEmailAddress(final String emailAddress)
	{
		this.emailAddress = emailAddress;
	}

	/**
	 * Accesses the phoneNumber
	 *
	 * @return the phoneNumber
	 */
	public String getPhoneNumber()
	{
		return phoneNumber;
	}

	/**
	 * Sets the phoneNumber
	 *
	 * @param phoneNumber
	 *           the phoneNumber to set
	 */
	public void setPhoneNumber(final String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Accesses the storeVisited
	 *
	 * @return the storeVisited
	 */
	public String getStoreVisited()
	{
		return storeVisited;
	}

	/**
	 * Sets the storeVisited
	 *
	 * @param storeVisited
	 *           the storeVisited to set
	 */
	public void setStoreVisited(final String storeVisited)
	{
		this.storeVisited = storeVisited;
	}

	/**
	 * Accesses the dateVisited
	 *
	 * @return the dateVisited
	 */
	public String getDateVisited()
	{
		return dateVisited;
	}

	/**
	 * Sets the dateVisited
	 *
	 * @param dateVisited
	 *           the dateVisited to set
	 */
	public void setDateVisited(final String dateVisited)
	{
		this.dateVisited = dateVisited;
	}

	/**
	 * Accesses the feedbackType
	 *
	 * @return the feedbackType
	 */
	@NotNull(message = "{customerfeedback.feedbacktype.invalid}")
	@Size(min = 1, max = 255, message = "{customerfeedback.feedbacktype.invalid}")
	public String getFeedbackType()
	{
		return feedbackType;
	}

	/**
	 * Sets the feedbackType
	 *
	 * @param feedbackType
	 *           the feedbackType to set
	 */
	public void setFeedbackType(final String feedbackType)
	{
		this.feedbackType = feedbackType;
	}

	/**
	 * Accesses the message
	 *
	 * @return the message
	 */
	@NotNull(message = "{customerfeedback.message.invalid}")
	@Size(min = 1, max = 10000, message = "{customerfeedback.message.invalid}")
	public String getMessage()
	{
		return message;
	}

	/**
	 * Sets the message
	 *
	 * @param message
	 *           the message to set
	 */
	public void setMessage(final String message)
	{
		this.message = message;
	}

	/**
	 * @return the dayofReminder
	 */
	public String getDayofReminder()
	{
		return dayofReminder;
	}

	/**
	 * @param dayofReminder
	 *           the dayofReminder to set
	 */
	public void setDayofReminder(final String dayofReminder)
	{
		this.dayofReminder = dayofReminder;
	}

}
