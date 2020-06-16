/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jun 15, 2020 12:43:10 PM                    ---
 * ----------------------------------------------------------------
 */
package au.com.rejectshop.core.jalo.components;

import au.com.rejectshop.core.constants.RejectshopCoreConstants;
import au.com.rejectshop.core.jalo.components.CMSMediaParagraphComponent;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.JaloInvalidParameterException;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.c2l.C2LManager;
import de.hybris.platform.jalo.c2l.Language;
import de.hybris.platform.jalo.enumeration.EnumerationValue;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type {@link au.com.rejectshop.core.jalo.components.CMSAnnouncementComponent CMSAnnouncementComponent}.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedCMSAnnouncementComponent extends CMSMediaParagraphComponent
{
	/** Qualifier of the <code>CMSAnnouncementComponent.category</code> attribute **/
	public static final String CATEGORY = "category";
	/** Qualifier of the <code>CMSAnnouncementComponent.backgroundColor</code> attribute **/
	public static final String BACKGROUNDCOLOR = "backgroundColor";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>(CMSMediaParagraphComponent.DEFAULT_INITIAL_ATTRIBUTES);
		tmp.put(CATEGORY, AttributeMode.INITIAL);
		tmp.put(BACKGROUNDCOLOR, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSAnnouncementComponent.backgroundColor</code> attribute.
	 * @return the backgroundColor - Background color for a category.
	 */
	public EnumerationValue getBackgroundColor(final SessionContext ctx)
	{
		return (EnumerationValue)getProperty( ctx, BACKGROUNDCOLOR);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSAnnouncementComponent.backgroundColor</code> attribute.
	 * @return the backgroundColor - Background color for a category.
	 */
	public EnumerationValue getBackgroundColor()
	{
		return getBackgroundColor( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CMSAnnouncementComponent.backgroundColor</code> attribute. 
	 * @param value the backgroundColor - Background color for a category.
	 */
	public void setBackgroundColor(final SessionContext ctx, final EnumerationValue value)
	{
		setProperty(ctx, BACKGROUNDCOLOR,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CMSAnnouncementComponent.backgroundColor</code> attribute. 
	 * @param value the backgroundColor - Background color for a category.
	 */
	public void setBackgroundColor(final EnumerationValue value)
	{
		setBackgroundColor( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSAnnouncementComponent.category</code> attribute.
	 * @return the category - Category of the component.
	 */
	public String getCategory(final SessionContext ctx)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedCMSAnnouncementComponent.getCategory requires a session language", 0 );
		}
		return (String)getLocalizedProperty( ctx, CATEGORY);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSAnnouncementComponent.category</code> attribute.
	 * @return the category - Category of the component.
	 */
	public String getCategory()
	{
		return getCategory( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSAnnouncementComponent.category</code> attribute. 
	 * @return the localized category - Category of the component.
	 */
	public Map<Language,String> getAllCategory(final SessionContext ctx)
	{
		return (Map<Language,String>)getAllLocalizedProperties(ctx,CATEGORY,C2LManager.getInstance().getAllLanguages());
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSAnnouncementComponent.category</code> attribute. 
	 * @return the localized category - Category of the component.
	 */
	public Map<Language,String> getAllCategory()
	{
		return getAllCategory( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CMSAnnouncementComponent.category</code> attribute. 
	 * @param value the category - Category of the component.
	 */
	public void setCategory(final SessionContext ctx, final String value)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedCMSAnnouncementComponent.setCategory requires a session language", 0 );
		}
		setLocalizedProperty(ctx, CATEGORY,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CMSAnnouncementComponent.category</code> attribute. 
	 * @param value the category - Category of the component.
	 */
	public void setCategory(final String value)
	{
		setCategory( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CMSAnnouncementComponent.category</code> attribute. 
	 * @param value the category - Category of the component.
	 */
	public void setAllCategory(final SessionContext ctx, final Map<Language,String> value)
	{
		setAllLocalizedProperties(ctx,CATEGORY,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CMSAnnouncementComponent.category</code> attribute. 
	 * @param value the category - Category of the component.
	 */
	public void setAllCategory(final Map<Language,String> value)
	{
		setAllCategory( getSession().getSessionContext(), value );
	}
	
}
