/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Mar 27, 2020 3:40:16 PM                     ---
 * ----------------------------------------------------------------
 */
package com.paypal.hybris.addon.jalo;

import com.paypal.hybris.addon.constants.Paypalb2b66addonConstants;
import com.paypal.hybris.addon.jalo.PayPalB2bECButtonComponent;
import de.hybris.platform.acceleratorcms.jalo.components.MiniCartComponent;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type {@link de.hybris.platform.acceleratorcms.jalo.components.MiniCartComponent PayPalB2bECMiniCartComponent}.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedPayPalB2bECMiniCartComponent extends MiniCartComponent
{
	/** Qualifier of the <code>PayPalB2bECMiniCartComponent.payPalB2bECButtonComponent</code> attribute **/
	public static final String PAYPALB2BECBUTTONCOMPONENT = "payPalB2bECButtonComponent";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>(MiniCartComponent.DEFAULT_INITIAL_ATTRIBUTES);
		tmp.put(PAYPALB2BECBUTTONCOMPONENT, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PayPalB2bECMiniCartComponent.payPalB2bECButtonComponent</code> attribute.
	 * @return the payPalB2bECButtonComponent
	 */
	public PayPalB2bECButtonComponent getPayPalB2bECButtonComponent(final SessionContext ctx)
	{
		return (PayPalB2bECButtonComponent)getProperty( ctx, PAYPALB2BECBUTTONCOMPONENT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PayPalB2bECMiniCartComponent.payPalB2bECButtonComponent</code> attribute.
	 * @return the payPalB2bECButtonComponent
	 */
	public PayPalB2bECButtonComponent getPayPalB2bECButtonComponent()
	{
		return getPayPalB2bECButtonComponent( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PayPalB2bECMiniCartComponent.payPalB2bECButtonComponent</code> attribute. 
	 * @param value the payPalB2bECButtonComponent
	 */
	public void setPayPalB2bECButtonComponent(final SessionContext ctx, final PayPalB2bECButtonComponent value)
	{
		setProperty(ctx, PAYPALB2BECBUTTONCOMPONENT,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PayPalB2bECMiniCartComponent.payPalB2bECButtonComponent</code> attribute. 
	 * @param value the payPalB2bECButtonComponent
	 */
	public void setPayPalB2bECButtonComponent(final PayPalB2bECButtonComponent value)
	{
		setPayPalB2bECButtonComponent( getSession().getSessionContext(), value );
	}
	
}
