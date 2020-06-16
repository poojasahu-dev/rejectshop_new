/*
 * [y] hybris Platform
 *
 * Copyright (c) 2014 BGW GROUP
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 *
 *
 */
package au.com.rejectshop.core.util;

import de.hybris.platform.util.Config;

import javax.annotation.concurrent.ThreadSafe;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import au.com.rejectshop.core.constants.RejectshopCoreConstants;



/**
 * EmailUtility This class is implemented to implement the Utility operations for an Email Service
 */
@ThreadSafe
public class EmailUtility
{

	private final String host;
	private final int port;
	private final String user;
	private final String password;
	private final String sendFrom;
	private final String sendTo;


	private static EmailUtility emailUtil = null;

	/**
	 * @return EmailUtil
	 */
	public static EmailUtility getInstance()
	{
		if (emailUtil == null)
		{
			emailUtil = new EmailUtility();
		}
		return emailUtil;
	}

	/**
	 * Constructor
	 */
	public EmailUtility()
	{
		host = Config.getString(RejectshopCoreConstants.SMTP_HOST, StringUtils.EMPTY);
		port = Config.getInt(RejectshopCoreConstants.SMTP_PORT, 25);
		user = Config.getString(RejectshopCoreConstants.SMTP_USER, StringUtils.EMPTY);
		password = Config.getString(RejectshopCoreConstants.SMTP_PASSWORD, StringUtils.EMPTY);
		sendFrom = Config.getString(RejectshopCoreConstants.SMTP_FROM, StringUtils.EMPTY);
		sendTo = Config.getString(RejectshopCoreConstants.SMTP_TO, StringUtils.EMPTY);

	}

	/**
	 * This method is used to send an Email
	 * 
	 * @param attchmentPath
	 * @param sendTo
	 * @throws EmailException
	 */
	@SuppressWarnings("javadoc")
	public void sendEmail(final String setSubject, final String setHtmlMsg) throws EmailException
	{
		final HtmlEmail htmlEmail = new HtmlEmail();
		htmlEmail.setHostName(host);
		htmlEmail.setSmtpPort(port);
		htmlEmail.setAuthentication(user, password);
		htmlEmail.addTo(sendTo);
		htmlEmail.setFrom(sendFrom);
		htmlEmail.setSubject(setSubject);
		htmlEmail.setHtmlMsg(setHtmlMsg);

		htmlEmail.send();
	}


	@SuppressWarnings("javadoc")
	public void sendEmail(final String attchmentPath, final String sendTo, final String setSubject, final String setHtmlMsg)
			throws EmailException
	{
		final HtmlEmail htmlEmail = new HtmlEmail();
		htmlEmail.setHostName(host);
		htmlEmail.setSmtpPort(port);
		htmlEmail.setAuthentication(user, password);
		htmlEmail.addTo(sendTo);
		htmlEmail.setFrom(sendFrom);
		htmlEmail.setSubject(setSubject);
		htmlEmail.setHtmlMsg(setHtmlMsg);

		htmlEmail.send();
	}


	/**
	 * @param toAddress
	 * @return String
	 */
	public String getToAddressEmail(String toAddresses)
	{
		if (Config.getBoolean(RejectshopCoreConstants.TEST_USER_EMAILS_ENABLED, false))
		{
			toAddresses = Config.getString(RejectshopCoreConstants.TEST_USER_EMAIL_TOADDRESS, StringUtils.EMPTY);
		}
		return toAddresses;
	}

}
