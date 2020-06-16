/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Mar 27, 2020 3:40:16 PM                     ---
 * ----------------------------------------------------------------
 */
package com.paypal.hybris.addon.jalo;

import com.paypal.hybris.addon.constants.Paypalb2b66addonConstants;
import com.paypal.hybris.addon.jalo.PayPalB2bECButtonComponent;
import de.hybris.platform.cms2.jalo.contents.components.CMSLinkComponent;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type {@link de.hybris.platform.acceleratorcms.jalo.components.SimpleBannerComponent PayPalB2bECMarkComponent}.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedPayPalB2bECMarkComponent extends PayPalB2bECButtonComponent
{
	/** Qualifier of the <code>PayPalB2bECMarkComponent.link</code> attribute **/
	public static final String LINK = "link";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>(PayPalB2bECButtonComponent.DEFAULT_INITIAL_ATTRIBUTES);
		tmp.put(LINK, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PayPalB2bECMarkComponent.link</code> attribute.
	 * @return the link
	 */
	public CMSLinkComponent getLink(final SessionContext ctx)
	{
		return (CMSLinkComponent)getProperty( ctx, LINK);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PayPalB2bECMarkComponent.link</code> attribute.
	 * @return the link
	 */
	public CMSLinkComponent getLink()
	{
		return getLink( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PayPalB2bECMarkComponent.link</code> attribute. 
	 * @param value the link
	 */
	public void setLink(final SessionContext ctx, final CMSLinkComponent value)
	{
		setProperty(ctx, LINK,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PayPalB2bECMarkComponent.link</code> attribute. 
	 * @param value the link
	 */
	public void setLink(final CMSLinkComponent value)
	{
		setLink( getSession().getSessionContext(), value );
	}
	
}
