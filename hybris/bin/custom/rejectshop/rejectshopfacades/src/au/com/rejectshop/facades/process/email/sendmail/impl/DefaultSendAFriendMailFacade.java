/**
 *
 */
package au.com.rejectshop.facades.process.email.sendmail.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Required;

import au.com.rejectshop.brontoservice.SendAFriendEmailService;
import au.com.rejectshop.facades.process.email.sendmail.SendAFriendMailFacade;
import au.com.rejectshop.facades.product.data.EmailProductData;


/**
 * @author soda.raveendra
 *
 */
public class DefaultSendAFriendMailFacade implements SendAFriendMailFacade
{

	@Resource
	private SendAFriendEmailService sendAFriendEmailService;

	/**
	 * @return the sendAFriendEmailService
	 */
	public SendAFriendEmailService getSendAFriendEmailService()
	{
		return sendAFriendEmailService;
	}

	/**
	 * @param sendAFriendEmailService
	 *           the sendAFriendEmailService to set
	 */
	@Required
	public void setSendAFriendEmailService(final SendAFriendEmailService sendAFriendEmailService)
	{
		this.sendAFriendEmailService = sendAFriendEmailService;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * au.com.rejectshop.facades.process.email.sendmail.SendAFriendMailFacade#sendMailFriend(au.com.rejectshop.facades.
	 * product.data.EmailProductData)
	 */
	public void sendMailFriend(final EmailProductData emailProductData)
	{
		sendAFriendEmailService.sendMailFriend(emailProductData);

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see au.com.rejectshop.facades.process.email.sendmail.SendAFriendMailFacade#sendEmailRemainder(au.com.rejectshop.
	 * facades.product.data.EmailProductData)
	 */
	public void sendEmailRemainder(final EmailProductData emailProductData)
	{

		sendAFriendEmailService.sendEmailRemainder(emailProductData);
	}

}
