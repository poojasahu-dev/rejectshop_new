/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Mar 27, 2020 3:40:16 PM                     ---
 * ----------------------------------------------------------------
 */
package com.paypal.hybris.addon.jalo;

import com.paypal.hybris.addon.constants.Paypalb2b66addonConstants;
import com.paypal.hybris.addon.jalo.PayPalB2bCreditFinancingBanner;
import com.paypal.hybris.addon.jalo.PayPalB2bECButtonComponent;
import com.paypal.hybris.addon.jalo.PayPalB2bECComponent;
import com.paypal.hybris.addon.jalo.PayPalB2bECMarkComponent;
import com.paypal.hybris.addon.jalo.PayPalB2bECMiniCartComponent;
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
 * Generated class for type <code>Paypalb2b66addonManager</code>.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedPaypalb2b66addonManager extends Extension
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
	
	public PayPalB2bCreditFinancingBanner createPayPalB2bCreditFinancingBanner(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( Paypalb2b66addonConstants.TC.PAYPALB2BCREDITFINANCINGBANNER );
			return (PayPalB2bCreditFinancingBanner)type.newInstance( ctx, attributeValues );
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
			throw new JaloSystemException( e ,"error creating PayPalB2bCreditFinancingBanner : "+e.getMessage(), 0 );
		}
	}
	
	public PayPalB2bCreditFinancingBanner createPayPalB2bCreditFinancingBanner(final Map attributeValues)
	{
		return createPayPalB2bCreditFinancingBanner( getSession().getSessionContext(), attributeValues );
	}
	
	public PayPalB2bECButtonComponent createPayPalB2bECButtonComponent(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( Paypalb2b66addonConstants.TC.PAYPALB2BECBUTTONCOMPONENT );
			return (PayPalB2bECButtonComponent)type.newInstance( ctx, attributeValues );
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
			throw new JaloSystemException( e ,"error creating PayPalB2bECButtonComponent : "+e.getMessage(), 0 );
		}
	}
	
	public PayPalB2bECButtonComponent createPayPalB2bECButtonComponent(final Map attributeValues)
	{
		return createPayPalB2bECButtonComponent( getSession().getSessionContext(), attributeValues );
	}
	
	public PayPalB2bECComponent createPayPalB2bECComponent(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( Paypalb2b66addonConstants.TC.PAYPALB2BECCOMPONENT );
			return (PayPalB2bECComponent)type.newInstance( ctx, attributeValues );
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
			throw new JaloSystemException( e ,"error creating PayPalB2bECComponent : "+e.getMessage(), 0 );
		}
	}
	
	public PayPalB2bECComponent createPayPalB2bECComponent(final Map attributeValues)
	{
		return createPayPalB2bECComponent( getSession().getSessionContext(), attributeValues );
	}
	
	public PayPalB2bECMarkComponent createPayPalB2bECMarkComponent(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( Paypalb2b66addonConstants.TC.PAYPALB2BECMARKCOMPONENT );
			return (PayPalB2bECMarkComponent)type.newInstance( ctx, attributeValues );
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
			throw new JaloSystemException( e ,"error creating PayPalB2bECMarkComponent : "+e.getMessage(), 0 );
		}
	}
	
	public PayPalB2bECMarkComponent createPayPalB2bECMarkComponent(final Map attributeValues)
	{
		return createPayPalB2bECMarkComponent( getSession().getSessionContext(), attributeValues );
	}
	
	public PayPalB2bECMiniCartComponent createPayPalB2bECMiniCartComponent(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( Paypalb2b66addonConstants.TC.PAYPALB2BECMINICARTCOMPONENT );
			return (PayPalB2bECMiniCartComponent)type.newInstance( ctx, attributeValues );
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
			throw new JaloSystemException( e ,"error creating PayPalB2bECMiniCartComponent : "+e.getMessage(), 0 );
		}
	}
	
	public PayPalB2bECMiniCartComponent createPayPalB2bECMiniCartComponent(final Map attributeValues)
	{
		return createPayPalB2bECMiniCartComponent( getSession().getSessionContext(), attributeValues );
	}
	
	@Override
	public String getName()
	{
		return Paypalb2b66addonConstants.EXTENSIONNAME;
	}
	
}
