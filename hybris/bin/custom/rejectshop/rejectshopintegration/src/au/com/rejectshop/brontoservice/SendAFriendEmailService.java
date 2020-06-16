/**
 * 
 */
package au.com.rejectshop.brontoservice;

import au.com.rejectshop.facades.product.data.EmailProductData;

/**
 * @author soda.raveendra
 *
 */
public interface SendAFriendEmailService
{
	public void sendMailFriend(final EmailProductData emailProductData);
	public void sendEmailRemainder(final EmailProductData emailProductData);
}
