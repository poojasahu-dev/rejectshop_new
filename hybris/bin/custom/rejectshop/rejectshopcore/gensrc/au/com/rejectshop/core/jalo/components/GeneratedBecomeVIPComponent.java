/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jun 15, 2020 12:43:10 PM                    ---
 * ----------------------------------------------------------------
 */
package au.com.rejectshop.core.jalo.components;

import au.com.rejectshop.core.constants.RejectshopCoreConstants;
import de.hybris.platform.cms2.jalo.contents.components.SimpleCMSComponent;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type {@link au.com.rejectshop.core.jalo.components.BecomeVIPComponent BecomeVIPComponent}.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedBecomeVIPComponent extends SimpleCMSComponent
{
	/** Qualifier of the <code>BecomeVIPComponent.heading</code> attribute **/
	public static final String HEADING = "heading";
	/** Qualifier of the <code>BecomeVIPComponent.subHeading</code> attribute **/
	public static final String SUBHEADING = "subHeading";
	/** Qualifier of the <code>BecomeVIPComponent.signUpButtonLabel</code> attribute **/
	public static final String SIGNUPBUTTONLABEL = "signUpButtonLabel";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>(SimpleCMSComponent.DEFAULT_INITIAL_ATTRIBUTES);
		tmp.put(HEADING, AttributeMode.INITIAL);
		tmp.put(SUBHEADING, AttributeMode.INITIAL);
		tmp.put(SIGNUPBUTTONLABEL, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BecomeVIPComponent.heading</code> attribute.
	 * @return the heading
	 */
	public String getHeading(final SessionContext ctx)
	{
		return (String)getProperty( ctx, HEADING);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BecomeVIPComponent.heading</code> attribute.
	 * @return the heading
	 */
	public String getHeading()
	{
		return getHeading( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>BecomeVIPComponent.heading</code> attribute. 
	 * @param value the heading
	 */
	public void setHeading(final SessionContext ctx, final String value)
	{
		setProperty(ctx, HEADING,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>BecomeVIPComponent.heading</code> attribute. 
	 * @param value the heading
	 */
	public void setHeading(final String value)
	{
		setHeading( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BecomeVIPComponent.signUpButtonLabel</code> attribute.
	 * @return the signUpButtonLabel
	 */
	public String getSignUpButtonLabel(final SessionContext ctx)
	{
		return (String)getProperty( ctx, SIGNUPBUTTONLABEL);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BecomeVIPComponent.signUpButtonLabel</code> attribute.
	 * @return the signUpButtonLabel
	 */
	public String getSignUpButtonLabel()
	{
		return getSignUpButtonLabel( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>BecomeVIPComponent.signUpButtonLabel</code> attribute. 
	 * @param value the signUpButtonLabel
	 */
	public void setSignUpButtonLabel(final SessionContext ctx, final String value)
	{
		setProperty(ctx, SIGNUPBUTTONLABEL,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>BecomeVIPComponent.signUpButtonLabel</code> attribute. 
	 * @param value the signUpButtonLabel
	 */
	public void setSignUpButtonLabel(final String value)
	{
		setSignUpButtonLabel( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BecomeVIPComponent.subHeading</code> attribute.
	 * @return the subHeading
	 */
	public String getSubHeading(final SessionContext ctx)
	{
		return (String)getProperty( ctx, SUBHEADING);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BecomeVIPComponent.subHeading</code> attribute.
	 * @return the subHeading
	 */
	public String getSubHeading()
	{
		return getSubHeading( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>BecomeVIPComponent.subHeading</code> attribute. 
	 * @param value the subHeading
	 */
	public void setSubHeading(final SessionContext ctx, final String value)
	{
		setProperty(ctx, SUBHEADING,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>BecomeVIPComponent.subHeading</code> attribute. 
	 * @param value the subHeading
	 */
	public void setSubHeading(final String value)
	{
		setSubHeading( getSession().getSessionContext(), value );
	}
	
}
