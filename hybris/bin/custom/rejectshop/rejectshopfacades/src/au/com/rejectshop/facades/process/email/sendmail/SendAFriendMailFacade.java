/**
 *
 */
package au.com.rejectshop.facades.process.email.sendmail;

import au.com.rejectshop.facades.product.data.EmailProductData;


/**
 * @author soda.raveendra
 *
 */
public interface SendAFriendMailFacade
{
	public void sendMailFriend(EmailProductData emailProductData);

	public void sendEmailRemainder(final EmailProductData emailProductData);
}
