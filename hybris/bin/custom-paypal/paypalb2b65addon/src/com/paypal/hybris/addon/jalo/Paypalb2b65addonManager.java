package com.paypal.hybris.addon.jalo;

import com.paypal.hybris.addon.constants.Paypalb2b65addonConstants;
import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.extension.ExtensionManager;
import org.apache.log4j.Logger;

@SuppressWarnings("PMD")
public class Paypalb2b65addonManager extends GeneratedPaypalb2b65addonManager
{
	@SuppressWarnings("unused")
	private static final Logger log = Logger.getLogger( Paypalb2b65addonManager.class.getName() );

	public static final Paypalb2b65addonManager getInstance()
	{
		ExtensionManager em = JaloSession.getCurrentSession().getExtensionManager();
		return (Paypalb2b65addonManager) em.getExtension(Paypalb2b65addonConstants.EXTENSIONNAME);
	}

}
