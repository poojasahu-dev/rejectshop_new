/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jun 15, 2020 12:43:10 PM                    ---
 * ----------------------------------------------------------------
 */
package com.paypal.hybris.addon.jalo;

import com.paypal.hybris.addon.constants.Paypal60addonConstants;
import com.paypal.hybris.addon.jalo.PayPalECButtonComponent;
import de.hybris.platform.acceleratorcms.jalo.components.MiniCartComponent;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type {@link de.hybris.platform.acceleratorcms.jalo.components.MiniCartComponent PayPalMiniCartJSComponent}.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedPayPalMiniCartJSComponent extends MiniCartComponent
{
	/** Qualifier of the <code>PayPalMiniCartJSComponent.payPalECButtonComponent</code> attribute **/
	public static final String PAYPALECBUTTONCOMPONENT = "payPalECButtonComponent";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>(MiniCartComponent.DEFAULT_INITIAL_ATTRIBUTES);
		tmp.put(PAYPALECBUTTONCOMPONENT, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PayPalMiniCartJSComponent.payPalECButtonComponent</code> attribute.
	 * @return the payPalECButtonComponent
	 */
	public PayPalECButtonComponent getPayPalECButtonComponent(final SessionContext ctx)
	{
		return (PayPalECButtonComponent)getProperty( ctx, PAYPALECBUTTONCOMPONENT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PayPalMiniCartJSComponent.payPalECButtonComponent</code> attribute.
	 * @return the payPalECButtonComponent
	 */
	public PayPalECButtonComponent getPayPalECButtonComponent()
	{
		return getPayPalECButtonComponent( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PayPalMiniCartJSComponent.payPalECButtonComponent</code> attribute. 
	 * @param value the payPalECButtonComponent
	 */
	public void setPayPalECButtonComponent(final SessionContext ctx, final PayPalECButtonComponent value)
	{
		setProperty(ctx, PAYPALECBUTTONCOMPONENT,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PayPalMiniCartJSComponent.payPalECButtonComponent</code> attribute. 
	 * @param value the payPalECButtonComponent
	 */
	public void setPayPalECButtonComponent(final PayPalECButtonComponent value)
	{
		setPayPalECButtonComponent( getSession().getSessionContext(), value );
	}
	
}
