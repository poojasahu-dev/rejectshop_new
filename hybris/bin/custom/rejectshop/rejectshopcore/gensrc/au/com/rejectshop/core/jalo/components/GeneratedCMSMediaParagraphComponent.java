/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jun 15, 2020 12:43:10 PM                    ---
 * ----------------------------------------------------------------
 */
package au.com.rejectshop.core.jalo.components;

import au.com.rejectshop.core.constants.RejectshopCoreConstants;
import de.hybris.platform.cms2.jalo.contents.components.CMSLinkComponent;
import de.hybris.platform.cms2.jalo.contents.components.CMSParagraphComponent;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.JaloInvalidParameterException;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.c2l.C2LManager;
import de.hybris.platform.jalo.c2l.Language;
import de.hybris.platform.jalo.media.Media;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type {@link au.com.rejectshop.core.jalo.components.CMSMediaParagraphComponent CMSMediaParagraphComponent}.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedCMSMediaParagraphComponent extends CMSParagraphComponent
{
	/** Qualifier of the <code>CMSMediaParagraphComponent.title</code> attribute **/
	public static final String TITLE = "title";
	/** Qualifier of the <code>CMSMediaParagraphComponent.media</code> attribute **/
	public static final String MEDIA = "media";
	/** Qualifier of the <code>CMSMediaParagraphComponent.link</code> attribute **/
	public static final String LINK = "link";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>(CMSParagraphComponent.DEFAULT_INITIAL_ATTRIBUTES);
		tmp.put(TITLE, AttributeMode.INITIAL);
		tmp.put(MEDIA, AttributeMode.INITIAL);
		tmp.put(LINK, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSMediaParagraphComponent.link</code> attribute.
	 * @return the link - Link to be rendered in the component.
	 */
	public CMSLinkComponent getLink(final SessionContext ctx)
	{
		return (CMSLinkComponent)getProperty( ctx, LINK);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSMediaParagraphComponent.link</code> attribute.
	 * @return the link - Link to be rendered in the component.
	 */
	public CMSLinkComponent getLink()
	{
		return getLink( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CMSMediaParagraphComponent.link</code> attribute. 
	 * @param value the link - Link to be rendered in the component.
	 */
	public void setLink(final SessionContext ctx, final CMSLinkComponent value)
	{
		setProperty(ctx, LINK,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CMSMediaParagraphComponent.link</code> attribute. 
	 * @param value the link - Link to be rendered in the component.
	 */
	public void setLink(final CMSLinkComponent value)
	{
		setLink( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSMediaParagraphComponent.media</code> attribute.
	 * @return the media - Stores media for the component.
	 */
	public Media getMedia(final SessionContext ctx)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedCMSMediaParagraphComponent.getMedia requires a session language", 0 );
		}
		return (Media)getLocalizedProperty( ctx, MEDIA);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSMediaParagraphComponent.media</code> attribute.
	 * @return the media - Stores media for the component.
	 */
	public Media getMedia()
	{
		return getMedia( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSMediaParagraphComponent.media</code> attribute. 
	 * @return the localized media - Stores media for the component.
	 */
	public Map<Language,Media> getAllMedia(final SessionContext ctx)
	{
		return (Map<Language,Media>)getAllLocalizedProperties(ctx,MEDIA,C2LManager.getInstance().getAllLanguages());
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSMediaParagraphComponent.media</code> attribute. 
	 * @return the localized media - Stores media for the component.
	 */
	public Map<Language,Media> getAllMedia()
	{
		return getAllMedia( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CMSMediaParagraphComponent.media</code> attribute. 
	 * @param value the media - Stores media for the component.
	 */
	public void setMedia(final SessionContext ctx, final Media value)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedCMSMediaParagraphComponent.setMedia requires a session language", 0 );
		}
		setLocalizedProperty(ctx, MEDIA,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CMSMediaParagraphComponent.media</code> attribute. 
	 * @param value the media - Stores media for the component.
	 */
	public void setMedia(final Media value)
	{
		setMedia( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CMSMediaParagraphComponent.media</code> attribute. 
	 * @param value the media - Stores media for the component.
	 */
	public void setAllMedia(final SessionContext ctx, final Map<Language,Media> value)
	{
		setAllLocalizedProperties(ctx,MEDIA,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CMSMediaParagraphComponent.media</code> attribute. 
	 * @param value the media - Stores media for the component.
	 */
	public void setAllMedia(final Map<Language,Media> value)
	{
		setAllMedia( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSMediaParagraphComponent.title</code> attribute.
	 * @return the title - Title for the paragraph component.
	 */
	public String getTitle(final SessionContext ctx)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedCMSMediaParagraphComponent.getTitle requires a session language", 0 );
		}
		return (String)getLocalizedProperty( ctx, TITLE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSMediaParagraphComponent.title</code> attribute.
	 * @return the title - Title for the paragraph component.
	 */
	public String getTitle()
	{
		return getTitle( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSMediaParagraphComponent.title</code> attribute. 
	 * @return the localized title - Title for the paragraph component.
	 */
	public Map<Language,String> getAllTitle(final SessionContext ctx)
	{
		return (Map<Language,String>)getAllLocalizedProperties(ctx,TITLE,C2LManager.getInstance().getAllLanguages());
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSMediaParagraphComponent.title</code> attribute. 
	 * @return the localized title - Title for the paragraph component.
	 */
	public Map<Language,String> getAllTitle()
	{
		return getAllTitle( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CMSMediaParagraphComponent.title</code> attribute. 
	 * @param value the title - Title for the paragraph component.
	 */
	public void setTitle(final SessionContext ctx, final String value)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedCMSMediaParagraphComponent.setTitle requires a session language", 0 );
		}
		setLocalizedProperty(ctx, TITLE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CMSMediaParagraphComponent.title</code> attribute. 
	 * @param value the title - Title for the paragraph component.
	 */
	public void setTitle(final String value)
	{
		setTitle( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CMSMediaParagraphComponent.title</code> attribute. 
	 * @param value the title - Title for the paragraph component.
	 */
	public void setAllTitle(final SessionContext ctx, final Map<Language,String> value)
	{
		setAllLocalizedProperties(ctx,TITLE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CMSMediaParagraphComponent.title</code> attribute. 
	 * @param value the title - Title for the paragraph component.
	 */
	public void setAllTitle(final Map<Language,String> value)
	{
		setAllTitle( getSession().getSessionContext(), value );
	}
	
}
