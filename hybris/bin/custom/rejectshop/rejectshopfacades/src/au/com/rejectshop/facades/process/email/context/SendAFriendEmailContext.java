/**
 *
 */
package au.com.rejectshop.facades.process.email.context;

import de.hybris.platform.acceleratorservices.model.cms2.pages.EmailPageModel;
import de.hybris.platform.acceleratorservices.process.email.context.AbstractEmailContext;
import de.hybris.platform.basecommerce.model.site.BaseSiteModel;
import de.hybris.platform.commercefacades.order.CartFacade;
import de.hybris.platform.commercefacades.order.data.CartData;
import de.hybris.platform.core.GenericSearchConstants;
import de.hybris.platform.core.model.c2l.LanguageModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.processengine.model.BusinessProcessModel;
import de.hybris.platform.servicelayer.session.SessionService;
import de.hybris.platform.servicelayer.user.UserService;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import au.com.rejectshop.core.model.process.SendAFriendEmailProcessModel;



/**
 * @author venkatapavani.t
 *
 */
public class SendAFriendEmailContext extends AbstractEmailContext
{

	public static final String MESSAGE = "message";
	public static final String RECEPIENTEMAIL = "recipientEmail";
	public static final String CART = "cart";
	public static final String PRODUCT_URL = "productUrl";
	public static final String PRODUCT_NAME = "productName";
	public static final String PRODUCT_IMAGEURL = "productImageUrl";
	public static final String PRODUCT_PRICE = "productPrice";
	public static final String YOUR_EMAIL="yourEmail";


	@Autowired
	private UserService userService;

	@Resource
	private SessionService sessionService;

	@Autowired
	private CartFacade cartFacade;

	@Override
	public void init(final BusinessProcessModel businessProcessModel, final EmailPageModel emailPageModel)
	{
		super.init(businessProcessModel, emailPageModel);
		if (businessProcessModel instanceof SendAFriendEmailProcessModel)
		{
			final CartData cartData = cartFacade.getSessionCart();
			put(CART, cartData);
			put(PRODUCT_NAME, ((SendAFriendEmailProcessModel) businessProcessModel).getProductName());
			put(PRODUCT_URL, ((SendAFriendEmailProcessModel) businessProcessModel).getProductUrl());
			put(PRODUCT_IMAGEURL, ((SendAFriendEmailProcessModel) businessProcessModel).getProductImageUrl());
			put(PRODUCT_PRICE, ((SendAFriendEmailProcessModel) businessProcessModel).getProductPrice());
			put(EMAIL, ((SendAFriendEmailProcessModel) businessProcessModel).getEmail());
			put(RECEPIENTEMAIL, ((SendAFriendEmailProcessModel) businessProcessModel).getRecipientEmail());
			put(MESSAGE, ((SendAFriendEmailProcessModel) businessProcessModel).getMessage());
			put(DISPLAY_NAME, ((SendAFriendEmailProcessModel) businessProcessModel).getName());
			put(YOUR_EMAIL, ((SendAFriendEmailProcessModel) businessProcessModel).getYourName());


		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.hybris.platform.acceleratorservices.process.email.context.AbstractEmailContext#getSite(de.hybris.platform.
	 * processengine.model.BusinessProcessModel)
	 */
	@Override
	protected BaseSiteModel getSite(final BusinessProcessModel businessProcessModel)
	{
		return ((SendAFriendEmailProcessModel) businessProcessModel).getSite();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.hybris.platform.acceleratorservices.process.email.context.AbstractEmailContext#getCustomer(de.hybris.platform
	 * .processengine.model.BusinessProcessModel)
	 */
	@Override
	protected CustomerModel getCustomer(final BusinessProcessModel businessProcessModel)
	{
		// YTODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.hybris.platform.acceleratorservices.process.email.context.AbstractEmailContext#getEmailLanguage(de.hybris.platform
	 * .processengine.model.BusinessProcessModel)
	 */
	@Override
	protected LanguageModel getEmailLanguage(final BusinessProcessModel businessProcessModel)
	{
		// YTODO Auto-generated method stub
		return null;
	}



	/**
	 * @return the sessionService
	 */
	public SessionService getSessionService()
	{
		return sessionService;
	}

	/**
	 * @param sessionService
	 *           the sessionService to set
	 */
	public void setSessionService(final SessionService sessionService)
	{
		this.sessionService = sessionService;
	}
}
