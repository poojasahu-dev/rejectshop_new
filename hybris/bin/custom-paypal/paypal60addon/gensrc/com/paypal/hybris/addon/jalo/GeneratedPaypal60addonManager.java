/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jun 15, 2020 12:43:10 PM                    ---
 * ----------------------------------------------------------------
 */
package com.paypal.hybris.addon.jalo;

import com.paypal.hybris.addon.constants.Paypal60addonConstants;
import com.paypal.hybris.addon.jalo.PayPalCheckoutJSComponent;
import com.paypal.hybris.addon.jalo.PayPalCreditFinancingBanner;
import com.paypal.hybris.addon.jalo.PayPalECButtonComponent;
import com.paypal.hybris.addon.jalo.PayPalExpressCheckoutMark;
import com.paypal.hybris.addon.jalo.PayPalMiniCartJSComponent;
import de.hybris.platform.jalo.Item;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.JaloBusinessException;
import de.hybris.platform.jalo.JaloSystemException;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.extension.Extension;
import de.hybris.platform.jalo.type.ComposedType;
import de.hybris.platform.jalo.type.JaloGenericCreationException;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type <code>Paypal60addonManager</code>.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedPaypal60addonManager extends Extension
{
	protected static final Map<String, Map<String, AttributeMode>> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, Map<String, AttributeMode>> ttmp = new HashMap();
		DEFAULT_INITIAL_ATTRIBUTES = ttmp;
	}
	@Override
	public Map<String, AttributeMode> getDefaultAttributeModes(final Class<? extends Item> itemClass)
	{
		Map<String, AttributeMode> ret = new HashMap<>();
		final Map<String, AttributeMode> attr = DEFAULT_INITIAL_ATTRIBUTES.get(itemClass.getName());
		if (attr != null)
		{
			ret.putAll(attr);
		}
		return ret;
	}
	
	public PayPalCheckoutJSComponent createPayPalCheckoutJSComponent(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( Paypal60addonConstants.TC.PAYPALCHECKOUTJSCOMPONENT );
			return (PayPalCheckoutJSComponent)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating PayPalCheckoutJSComponent : "+e.getMessage(), 0 );
		}
	}
	
	public PayPalCheckoutJSComponent createPayPalCheckoutJSComponent(final Map attributeValues)
	{
		return createPayPalCheckoutJSComponent( getSession().getSessionContext(), attributeValues );
	}
	
	public PayPalCreditFinancingBanner createPayPalCreditFinancingBanner(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( Paypal60addonConstants.TC.PAYPALCREDITFINANCINGBANNER );
			return (PayPalCreditFinancingBanner)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating PayPalCreditFinancingBanner : "+e.getMessage(), 0 );
		}
	}
	
	public PayPalCreditFinancingBanner createPayPalCreditFinancingBanner(final Map attributeValues)
	{
		return createPayPalCreditFinancingBanner( getSession().getSessionContext(), attributeValues );
	}
	
	public PayPalECButtonComponent createPayPalECButtonComponent(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( Paypal60addonConstants.TC.PAYPALECBUTTONCOMPONENT );
			return (PayPalECButtonComponent)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating PayPalECButtonComponent : "+e.getMessage(), 0 );
		}
	}
	
	public PayPalECButtonComponent createPayPalECButtonComponent(final Map attributeValues)
	{
		return createPayPalECButtonComponent( getSession().getSessionContext(), attributeValues );
	}
	
	public PayPalExpressCheckoutMark createPayPalExpressCheckoutMark(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( Paypal60addonConstants.TC.PAYPALEXPRESSCHECKOUTMARK );
			return (PayPalExpressCheckoutMark)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating PayPalExpressCheckoutMark : "+e.getMessage(), 0 );
		}
	}
	
	public PayPalExpressCheckoutMark createPayPalExpressCheckoutMark(final Map attributeValues)
	{
		return createPayPalExpressCheckoutMark( getSession().getSessionContext(), attributeValues );
	}
	
	public PayPalMiniCartJSComponent createPayPalMiniCartJSComponent(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( Paypal60addonConstants.TC.PAYPALMINICARTJSCOMPONENT );
			return (PayPalMiniCartJSComponent)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating PayPalMiniCartJSComponent : "+e.getMessage(), 0 );
		}
	}
	
	public PayPalMiniCartJSComponent createPayPalMiniCartJSComponent(final Map attributeValues)
	{
		return createPayPalMiniCartJSComponent( getSession().getSessionContext(), attributeValues );
	}
	
	@Override
	public String getName()
	{
		return Paypal60addonConstants.EXTENSIONNAME;
	}
	
}
