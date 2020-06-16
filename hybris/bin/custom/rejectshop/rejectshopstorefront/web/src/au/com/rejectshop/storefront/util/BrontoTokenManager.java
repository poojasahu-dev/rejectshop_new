/**
 *
 */
package au.com.rejectshop.storefront.util;


import java.util.UUID;

import javax.servlet.http.HttpSession;


/**
 * A manager for the Bronto token for a given session. The {@link #getTokenForSession(HttpSession)} should used to
 * obtain the token value for the current session (and this should be the only way to obtain the token value).
 *
 */
public final class BrontoTokenManager
{



	/**
	 * The location on the session which stores the token
	 */
	private static final String BRONTO_TOKEN_FOR_SESSION_ATTR_NAME = BrontoTokenManager.class.getName() + ".tokenval";

	private BrontoTokenManager()
	{
	}

	public static String getTokenForSession(final HttpSession session)
	{
		String token = null;
		// I cannot allow more than one token on a request - in the case of two requests trying to
		// init the token concurrently
		synchronized (session)
		{
			token = (String) session.getAttribute(BRONTO_TOKEN_FOR_SESSION_ATTR_NAME);
			if (null == token)
			{
				token = UUID.randomUUID().toString();
				session.setAttribute(BRONTO_TOKEN_FOR_SESSION_ATTR_NAME, token);
			}
		}
		return token;
	}

	public static void removeTokenForSession(final HttpSession session)
	{
		String token = null;
		// I cannot allow more than one token on a request - in the case of two requests trying to
		// init the token concurrently
		synchronized (session)
		{
			token = (String) session.getAttribute(BRONTO_TOKEN_FOR_SESSION_ATTR_NAME);
			if (null != token)
			{
				session.removeAttribute(BRONTO_TOKEN_FOR_SESSION_ATTR_NAME);
			}
		}
	}
}