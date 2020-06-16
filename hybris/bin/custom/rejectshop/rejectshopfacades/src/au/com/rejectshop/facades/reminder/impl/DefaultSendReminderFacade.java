/**
 *
 */
package au.com.rejectshop.facades.reminder.impl;

import de.hybris.platform.core.model.product.ProductModel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import au.com.rejectshop.core.model.SendEmailReminderModel;
import au.com.rejectshop.core.reminder.SendReminderService;
import au.com.rejectshop.facades.reminder.SendReminderFacade;


/**
 * @author saisravan.k
 *
 */
public class DefaultSendReminderFacade implements SendReminderFacade
{
	private SendReminderService sendReminderService;
	/** The email. */
	private String email;
	private String dayofReminder;
	private String time;
	/** The name. */
	private String name;
	/** Product Url */
	private String productUrl;
	/** Product Name */
	private String productName;

	private String productCode;
	private String productImageUrl;

	private String productPrice;

	/*
	 * (non-Javadoc)
	 * 
	 * @see au.com.rejectshop.facades.reminder.SendReminderFacade#findTheListByDate(java.lang.String)
	 */
	public List<SendEmailReminderModel> findTheListByDateandTime()
	{
		final Date date = new Date();
		final SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
		final String formattedDate = dateFormat.format(date);
		final SimpleDateFormat timeFormat = new SimpleDateFormat("HH");
		final String time = timeFormat.format(date);
		return getSendReminderService().findTheListByDateandTime(formattedDate, time);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see au.com.rejectshop.facades.reminder.SendReminderFacade#findTheListByFlag(boolean)
	 */
	public List<SendEmailReminderModel> findTheListByFlag(final boolean status)
	{
		// YTODO Auto-generated method stub
		return getSendReminderService().findTheListByFlag(status);
	}

	public ProductModel findProductsByCode(final String productCode)
	{
		return getSendReminderService().findProductsByCode(productCode);
	}

	/**
	 * @return the sendReminderService
	 */
	public SendReminderService getSendReminderService()
	{
		return sendReminderService;
	}

	/**
	 * @param sendReminderService
	 *           the sendReminderService to set
	 */
	public void setSendReminderService(final SendReminderService sendReminderService)
	{
		this.sendReminderService = sendReminderService;
	}

	/**
	 * @return the email
	 */
	public String getEmail()
	{
		return email;
	}

	/**
	 * @param email
	 *           the email to set
	 */
	public void setEmail(final String email)
	{
		this.email = email;
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

	/**
	 * @return the time
	 */
	public String getTime()
	{
		return time;
	}

	/**
	 * @param time
	 *           the time to set
	 */
	public void setTime(final String time)
	{
		this.time = time;
	}

	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @param name
	 *           the name to set
	 */
	public void setName(final String name)
	{
		this.name = name;
	}

	/**
	 * @return the productUrl
	 */
	public String getProductUrl()
	{
		return productUrl;
	}

	/**
	 * @param productUrl
	 *           the productUrl to set
	 */
	public void setProductUrl(final String productUrl)
	{
		this.productUrl = productUrl;
	}

	/**
	 * @return the productName
	 */
	public String getProductName()
	{
		return productName;
	}

	/**
	 * @param productName
	 *           the productName to set
	 */
	public void setProductName(final String productName)
	{
		this.productName = productName;
	}

	/**
	 * @return the productCode
	 */
	public String getProductCode()
	{
		return productCode;
	}

	/**
	 * @param productCode
	 *           the productCode to set
	 */
	public void setProductCode(final String productCode)
	{
		this.productCode = productCode;
	}

	/**
	 * @return the productImageUrl
	 */
	public String getProductImageUrl()
	{
		return productImageUrl;
	}

	/**
	 * @param productImageUrl
	 *           the productImageUrl to set
	 */
	public void setProductImageUrl(final String productImageUrl)
	{
		this.productImageUrl = productImageUrl;
	}

	/**
	 * @return the productPrice
	 */
	public String getProductPrice()
	{
		return productPrice;
	}

	/**
	 * @param productPrice
	 *           the productPrice to set
	 */
	public void setProductPrice(final String productPrice)
	{
		this.productPrice = productPrice;
	}




}
