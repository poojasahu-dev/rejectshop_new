/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jun 15, 2020 12:43:10 PM                    ---
 * ----------------------------------------------------------------
 */
package com.paypal.hybris.addon.jalo;

import com.paypal.hybris.addon.constants.Paypal60addonConstants;
import de.hybris.platform.acceleratorcms.jalo.components.SimpleBannerComponent;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.enumeration.EnumerationValue;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Generated class for type {@link de.hybris.platform.acceleratorcms.jalo.components.SimpleBannerComponent PayPalECButtonComponent}.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedPayPalECButtonComponent extends SimpleBannerComponent
{
	/** Qualifier of the <code>PayPalECButtonComponent.locale</code> attribute **/
	public static final String LOCALE = "locale";
	/** Qualifier of the <code>PayPalECButtonComponent.color</code> attribute **/
	public static final String COLOR = "color";
	/** Qualifier of the <code>PayPalECButtonComponent.shape</code> attribute **/
	public static final String SHAPE = "shape";
	/** Qualifier of the <code>PayPalECButtonComponent.size</code> attribute **/
	public static final String SIZE = "size";
	/** Qualifier of the <code>PayPalECButtonComponent.label</code> attribute **/
	public static final String LABEL = "label";
	/** Qualifier of the <code>PayPalECButtonComponent.layout</code> attribute **/
	public static final String LAYOUT = "layout";
	/** Qualifier of the <code>PayPalECButtonComponent.tagline</code> attribute **/
	public static final String TAGLINE = "tagline";
	/** Qualifier of the <code>PayPalECButtonComponent.branding</code> attribute **/
	public static final String BRANDING = "branding";
	/** Qualifier of the <code>PayPalECButtonComponent.fundingAllowed</code> attribute **/
	public static final String FUNDINGALLOWED = "fundingAllowed";
	/** Qualifier of the <code>PayPalECButtonComponent.fundingDisallowed</code> attribute **/
	public static final String FUNDINGDISALLOWED = "fundingDisallowed";
	/** Qualifier of the <code>PayPalECButtonComponent.fundingIcons</code> attribute **/
	public static final String FUNDINGICONS = "fundingIcons";
	/** Qualifier of the <code>PayPalECButtonComponent.buttonDiv</code> attribute **/
	public static final String BUTTONDIV = "buttonDiv";
	/** Qualifier of the <code>PayPalECButtonComponent.commit</code> attribute **/
	public static final String COMMIT = "commit";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>(SimpleBannerComponent.DEFAULT_INITIAL_ATTRIBUTES);
		tmp.put(LOCALE, AttributeMode.INITIAL);
		tmp.put(COLOR, AttributeMode.INITIAL);
		tmp.put(SHAPE, AttributeMode.INITIAL);
		tmp.put(SIZE, AttributeMode.INITIAL);
		tmp.put(LABEL, AttributeMode.INITIAL);
		tmp.put(LAYOUT, AttributeMode.INITIAL);
		tmp.put(TAGLINE, AttributeMode.INITIAL);
		tmp.put(BRANDING, AttributeMode.INITIAL);
		tmp.put(FUNDINGALLOWED, AttributeMode.INITIAL);
		tmp.put(FUNDINGDISALLOWED, AttributeMode.INITIAL);
		tmp.put(FUNDINGICONS, AttributeMode.INITIAL);
		tmp.put(BUTTONDIV, AttributeMode.INITIAL);
		tmp.put(COMMIT, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PayPalECButtonComponent.branding</code> attribute.
	 * @return the branding
	 */
	public Boolean isBranding(final SessionContext ctx)
	{
		return (Boolean)getProperty( ctx, BRANDING);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PayPalECButtonComponent.branding</code> attribute.
	 * @return the branding
	 */
	public Boolean isBranding()
	{
		return isBranding( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PayPalECButtonComponent.branding</code> attribute. 
	 * @return the branding
	 */
	public boolean isBrandingAsPrimitive(final SessionContext ctx)
	{
		Boolean value = isBranding( ctx );
		return value != null ? value.booleanValue() : false;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PayPalECButtonComponent.branding</code> attribute. 
	 * @return the branding
	 */
	public boolean isBrandingAsPrimitive()
	{
		return isBrandingAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PayPalECButtonComponent.branding</code> attribute. 
	 * @param value the branding
	 */
	public void setBranding(final SessionContext ctx, final Boolean value)
	{
		setProperty(ctx, BRANDING,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PayPalECButtonComponent.branding</code> attribute. 
	 * @param value the branding
	 */
	public void setBranding(final Boolean value)
	{
		setBranding( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PayPalECButtonComponent.branding</code> attribute. 
	 * @param value the branding
	 */
	public void setBranding(final SessionContext ctx, final boolean value)
	{
		setBranding( ctx,Boolean.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PayPalECButtonComponent.branding</code> attribute. 
	 * @param value the branding
	 */
	public void setBranding(final boolean value)
	{
		setBranding( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PayPalECButtonComponent.buttonDiv</code> attribute.
	 * @return the buttonDiv
	 */
	public String getButtonDiv(final SessionContext ctx)
	{
		return (String)getProperty( ctx, BUTTONDIV);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PayPalECButtonComponent.buttonDiv</code> attribute.
	 * @return the buttonDiv
	 */
	public String getButtonDiv()
	{
		return getButtonDiv( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PayPalECButtonComponent.buttonDiv</code> attribute. 
	 * @param value the buttonDiv
	 */
	public void setButtonDiv(final SessionContext ctx, final String value)
	{
		setProperty(ctx, BUTTONDIV,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PayPalECButtonComponent.buttonDiv</code> attribute. 
	 * @param value the buttonDiv
	 */
	public void setButtonDiv(final String value)
	{
		setButtonDiv( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PayPalECButtonComponent.color</code> attribute.
	 * @return the color
	 */
	public EnumerationValue getColor(final SessionContext ctx)
	{
		return (EnumerationValue)getProperty( ctx, COLOR);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PayPalECButtonComponent.color</code> attribute.
	 * @return the color
	 */
	public EnumerationValue getColor()
	{
		return getColor( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PayPalECButtonComponent.color</code> attribute. 
	 * @param value the color
	 */
	public void setColor(final SessionContext ctx, final EnumerationValue value)
	{
		setProperty(ctx, COLOR,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PayPalECButtonComponent.color</code> attribute. 
	 * @param value the color
	 */
	public void setColor(final EnumerationValue value)
	{
		setColor( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PayPalECButtonComponent.commit</code> attribute.
	 * @return the commit
	 */
	public Boolean isCommit(final SessionContext ctx)
	{
		return (Boolean)getProperty( ctx, COMMIT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PayPalECButtonComponent.commit</code> attribute.
	 * @return the commit
	 */
	public Boolean isCommit()
	{
		return isCommit( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PayPalECButtonComponent.commit</code> attribute. 
	 * @return the commit
	 */
	public boolean isCommitAsPrimitive(final SessionContext ctx)
	{
		Boolean value = isCommit( ctx );
		return value != null ? value.booleanValue() : false;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PayPalECButtonComponent.commit</code> attribute. 
	 * @return the commit
	 */
	public boolean isCommitAsPrimitive()
	{
		return isCommitAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PayPalECButtonComponent.commit</code> attribute. 
	 * @param value the commit
	 */
	public void setCommit(final SessionContext ctx, final Boolean value)
	{
		setProperty(ctx, COMMIT,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PayPalECButtonComponent.commit</code> attribute. 
	 * @param value the commit
	 */
	public void setCommit(final Boolean value)
	{
		setCommit( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PayPalECButtonComponent.commit</code> attribute. 
	 * @param value the commit
	 */
	public void setCommit(final SessionContext ctx, final boolean value)
	{
		setCommit( ctx,Boolean.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PayPalECButtonComponent.commit</code> attribute. 
	 * @param value the commit
	 */
	public void setCommit(final boolean value)
	{
		setCommit( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PayPalECButtonComponent.fundingAllowed</code> attribute.
	 * @return the fundingAllowed
	 */
	public List<EnumerationValue> getFundingAllowed(final SessionContext ctx)
	{
		List<EnumerationValue> coll = (List<EnumerationValue>)getProperty( ctx, FUNDINGALLOWED);
		return coll != null ? coll : Collections.EMPTY_LIST;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PayPalECButtonComponent.fundingAllowed</code> attribute.
	 * @return the fundingAllowed
	 */
	public List<EnumerationValue> getFundingAllowed()
	{
		return getFundingAllowed( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PayPalECButtonComponent.fundingAllowed</code> attribute. 
	 * @param value the fundingAllowed
	 */
	public void setFundingAllowed(final SessionContext ctx, final List<EnumerationValue> value)
	{
		setProperty(ctx, FUNDINGALLOWED,value == null || !value.isEmpty() ? value : null );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PayPalECButtonComponent.fundingAllowed</code> attribute. 
	 * @param value the fundingAllowed
	 */
	public void setFundingAllowed(final List<EnumerationValue> value)
	{
		setFundingAllowed( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PayPalECButtonComponent.fundingDisallowed</code> attribute.
	 * @return the fundingDisallowed
	 */
	public List<EnumerationValue> getFundingDisallowed(final SessionContext ctx)
	{
		List<EnumerationValue> coll = (List<EnumerationValue>)getProperty( ctx, FUNDINGDISALLOWED);
		return coll != null ? coll : Collections.EMPTY_LIST;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PayPalECButtonComponent.fundingDisallowed</code> attribute.
	 * @return the fundingDisallowed
	 */
	public List<EnumerationValue> getFundingDisallowed()
	{
		return getFundingDisallowed( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PayPalECButtonComponent.fundingDisallowed</code> attribute. 
	 * @param value the fundingDisallowed
	 */
	public void setFundingDisallowed(final SessionContext ctx, final List<EnumerationValue> value)
	{
		setProperty(ctx, FUNDINGDISALLOWED,value == null || !value.isEmpty() ? value : null );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PayPalECButtonComponent.fundingDisallowed</code> attribute. 
	 * @param value the fundingDisallowed
	 */
	public void setFundingDisallowed(final List<EnumerationValue> value)
	{
		setFundingDisallowed( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PayPalECButtonComponent.fundingIcons</code> attribute.
	 * @return the fundingIcons
	 */
	public Boolean isFundingIcons(final SessionContext ctx)
	{
		return (Boolean)getProperty( ctx, FUNDINGICONS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PayPalECButtonComponent.fundingIcons</code> attribute.
	 * @return the fundingIcons
	 */
	public Boolean isFundingIcons()
	{
		return isFundingIcons( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PayPalECButtonComponent.fundingIcons</code> attribute. 
	 * @return the fundingIcons
	 */
	public boolean isFundingIconsAsPrimitive(final SessionContext ctx)
	{
		Boolean value = isFundingIcons( ctx );
		return value != null ? value.booleanValue() : false;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PayPalECButtonComponent.fundingIcons</code> attribute. 
	 * @return the fundingIcons
	 */
	public boolean isFundingIconsAsPrimitive()
	{
		return isFundingIconsAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PayPalECButtonComponent.fundingIcons</code> attribute. 
	 * @param value the fundingIcons
	 */
	public void setFundingIcons(final SessionContext ctx, final Boolean value)
	{
		setProperty(ctx, FUNDINGICONS,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PayPalECButtonComponent.fundingIcons</code> attribute. 
	 * @param value the fundingIcons
	 */
	public void setFundingIcons(final Boolean value)
	{
		setFundingIcons( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PayPalECButtonComponent.fundingIcons</code> attribute. 
	 * @param value the fundingIcons
	 */
	public void setFundingIcons(final SessionContext ctx, final boolean value)
	{
		setFundingIcons( ctx,Boolean.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PayPalECButtonComponent.fundingIcons</code> attribute. 
	 * @param value the fundingIcons
	 */
	public void setFundingIcons(final boolean value)
	{
		setFundingIcons( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PayPalECButtonComponent.label</code> attribute.
	 * @return the label
	 */
	public EnumerationValue getLabel(final SessionContext ctx)
	{
		return (EnumerationValue)getProperty( ctx, LABEL);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PayPalECButtonComponent.label</code> attribute.
	 * @return the label
	 */
	public EnumerationValue getLabel()
	{
		return getLabel( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PayPalECButtonComponent.label</code> attribute. 
	 * @param value the label
	 */
	public void setLabel(final SessionContext ctx, final EnumerationValue value)
	{
		setProperty(ctx, LABEL,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PayPalECButtonComponent.label</code> attribute. 
	 * @param value the label
	 */
	public void setLabel(final EnumerationValue value)
	{
		setLabel( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PayPalECButtonComponent.layout</code> attribute.
	 * @return the layout
	 */
	public EnumerationValue getLayout(final SessionContext ctx)
	{
		return (EnumerationValue)getProperty( ctx, LAYOUT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PayPalECButtonComponent.layout</code> attribute.
	 * @return the layout
	 */
	public EnumerationValue getLayout()
	{
		return getLayout( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PayPalECButtonComponent.layout</code> attribute. 
	 * @param value the layout
	 */
	public void setLayout(final SessionContext ctx, final EnumerationValue value)
	{
		setProperty(ctx, LAYOUT,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PayPalECButtonComponent.layout</code> attribute. 
	 * @param value the layout
	 */
	public void setLayout(final EnumerationValue value)
	{
		setLayout( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PayPalECButtonComponent.locale</code> attribute.
	 * @return the locale
	 */
	public String getLocale(final SessionContext ctx)
	{
		return (String)getProperty( ctx, LOCALE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PayPalECButtonComponent.locale</code> attribute.
	 * @return the locale
	 */
	public String getLocale()
	{
		return getLocale( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PayPalECButtonComponent.locale</code> attribute. 
	 * @param value the locale
	 */
	public void setLocale(final SessionContext ctx, final String value)
	{
		setProperty(ctx, LOCALE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PayPalECButtonComponent.locale</code> attribute. 
	 * @param value the locale
	 */
	public void setLocale(final String value)
	{
		setLocale( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PayPalECButtonComponent.shape</code> attribute.
	 * @return the shape
	 */
	public EnumerationValue getShape(final SessionContext ctx)
	{
		return (EnumerationValue)getProperty( ctx, SHAPE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PayPalECButtonComponent.shape</code> attribute.
	 * @return the shape
	 */
	public EnumerationValue getShape()
	{
		return getShape( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PayPalECButtonComponent.shape</code> attribute. 
	 * @param value the shape
	 */
	public void setShape(final SessionContext ctx, final EnumerationValue value)
	{
		setProperty(ctx, SHAPE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PayPalECButtonComponent.shape</code> attribute. 
	 * @param value the shape
	 */
	public void setShape(final EnumerationValue value)
	{
		setShape( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PayPalECButtonComponent.size</code> attribute.
	 * @return the size
	 */
	public EnumerationValue getSize(final SessionContext ctx)
	{
		return (EnumerationValue)getProperty( ctx, SIZE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PayPalECButtonComponent.size</code> attribute.
	 * @return the size
	 */
	public EnumerationValue getSize()
	{
		return getSize( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PayPalECButtonComponent.size</code> attribute. 
	 * @param value the size
	 */
	public void setSize(final SessionContext ctx, final EnumerationValue value)
	{
		setProperty(ctx, SIZE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PayPalECButtonComponent.size</code> attribute. 
	 * @param value the size
	 */
	public void setSize(final EnumerationValue value)
	{
		setSize( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PayPalECButtonComponent.tagline</code> attribute.
	 * @return the tagline
	 */
	public Boolean isTagline(final SessionContext ctx)
	{
		return (Boolean)getProperty( ctx, TAGLINE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PayPalECButtonComponent.tagline</code> attribute.
	 * @return the tagline
	 */
	public Boolean isTagline()
	{
		return isTagline( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PayPalECButtonComponent.tagline</code> attribute. 
	 * @return the tagline
	 */
	public boolean isTaglineAsPrimitive(final SessionContext ctx)
	{
		Boolean value = isTagline( ctx );
		return value != null ? value.booleanValue() : false;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PayPalECButtonComponent.tagline</code> attribute. 
	 * @return the tagline
	 */
	public boolean isTaglineAsPrimitive()
	{
		return isTaglineAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PayPalECButtonComponent.tagline</code> attribute. 
	 * @param value the tagline
	 */
	public void setTagline(final SessionContext ctx, final Boolean value)
	{
		setProperty(ctx, TAGLINE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PayPalECButtonComponent.tagline</code> attribute. 
	 * @param value the tagline
	 */
	public void setTagline(final Boolean value)
	{
		setTagline( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PayPalECButtonComponent.tagline</code> attribute. 
	 * @param value the tagline
	 */
	public void setTagline(final SessionContext ctx, final boolean value)
	{
		setTagline( ctx,Boolean.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PayPalECButtonComponent.tagline</code> attribute. 
	 * @param value the tagline
	 */
	public void setTagline(final boolean value)
	{
		setTagline( getSession().getSessionContext(), value );
	}
	
}
