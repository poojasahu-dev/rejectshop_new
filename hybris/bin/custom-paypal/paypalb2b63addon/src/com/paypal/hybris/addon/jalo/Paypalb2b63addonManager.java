package com.paypal.hybris.addon.jalo;

import com.paypal.hybris.addon.constants.Paypalb2b63addonConstants;
import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.extension.ExtensionManager;
import org.apache.log4j.Logger;

@SuppressWarnings("PMD")
public class Paypalb2b63addonManager extends GeneratedPaypalb2b63addonManager
{
	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger( Paypalb2b63addonManager.class.getName() );
	
	public static final Paypalb2b63addonManager getInstance()
	{
		ExtensionManager em = JaloSession.getCurrentSession().getExtensionManager();
		return (Paypalb2b63addonManager) em.getExtension(Paypalb2b63addonConstants.EXTENSIONNAME);
	}
	
}
