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
import de.hybris.platform.jalo.JaloInvalidParameterException;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.c2l.C2LManager;
import de.hybris.platform.jalo.c2l.Language;
import de.hybris.platform.jalo.media.Media;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type {@link au.com.rejectshop.core.jalo.components.ModuleCMSComponent ModuleCMSComponent}.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedModuleCMSComponent extends SimpleCMSComponent
{
	/** Qualifier of the <code>ModuleCMSComponent.title</code> attribute **/
	public static final String TITLE = "title";
	/** Qualifier of the <code>ModuleCMSComponent.content</code> attribute **/
	public static final String CONTENT = "content";
	/** Qualifier of the <code>ModuleCMSComponent.media</code> attribute **/
	public static final String MEDIA = "media";
	/** Qualifier of the <code>ModuleCMSComponent.url</code> attribute **/
	public static final String URL = "url";
	/** Qualifier of the <code>ModuleCMSComponent.buttonLabel</code> attribute **/
	public static final String BUTTONLABEL = "buttonLabel";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>(SimpleCMSComponent.DEFAULT_INITIAL_ATTRIBUTES);
		tmp.put(TITLE, AttributeMode.INITIAL);
		tmp.put(CONTENT, AttributeMode.INITIAL);
		tmp.put(MEDIA, AttributeMode.INITIAL);
		tmp.put(URL, AttributeMode.INITIAL);
		tmp.put(BUTTONLABEL, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ModuleCMSComponent.buttonLabel</code> attribute.
	 * @return the buttonLabel - Label for the button.
	 */
	public String getButtonLabel(final SessionContext ctx)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedModuleCMSComponent.getButtonLabel requires a session language", 0 );
		}
		return (String)getLocalizedProperty( ctx, BUTTONLABEL);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ModuleCMSComponent.buttonLabel</code> attribute.
	 * @return the buttonLabel - Label for the button.
	 */
	public String getButtonLabel()
	{
		return getButtonLabel( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ModuleCMSComponent.buttonLabel</code> attribute. 
	 * @return the localized buttonLabel - Label for the button.
	 */
	public Map<Language,String> getAllButtonLabel(final SessionContext ctx)
	{
		return (Map<Language,String>)getAllLocalizedProperties(ctx,BUTTONLABEL,C2LManager.getInstance().getAllLanguages());
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ModuleCMSComponent.buttonLabel</code> attribute. 
	 * @return the localized buttonLabel - Label for the button.
	 */
	public Map<Language,String> getAllButtonLabel()
	{
		return getAllButtonLabel( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ModuleCMSComponent.buttonLabel</code> attribute. 
	 * @param value the buttonLabel - Label for the button.
	 */
	public void setButtonLabel(final SessionContext ctx, final String value)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedModuleCMSComponent.setButtonLabel requires a session language", 0 );
		}
		setLocalizedProperty(ctx, BUTTONLABEL,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ModuleCMSComponent.buttonLabel</code> attribute. 
	 * @param value the buttonLabel - Label for the button.
	 */
	public void setButtonLabel(final String value)
	{
		setButtonLabel( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ModuleCMSComponent.buttonLabel</code> attribute. 
	 * @param value the buttonLabel - Label for the button.
	 */
	public void setAllButtonLabel(final SessionContext ctx, final Map<Language,String> value)
	{
		setAllLocalizedProperties(ctx,BUTTONLABEL,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ModuleCMSComponent.buttonLabel</code> attribute. 
	 * @param value the buttonLabel - Label for the button.
	 */
	public void setAllButtonLabel(final Map<Language,String> value)
	{
		setAllButtonLabel( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ModuleCMSComponent.content</code> attribute.
	 * @return the content - Catalog content to be displayed.
	 */
	public String getContent(final SessionContext ctx)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedModuleCMSComponent.getContent requires a session language", 0 );
		}
		return (String)getLocalizedProperty( ctx, CONTENT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ModuleCMSComponent.content</code> attribute.
	 * @return the content - Catalog content to be displayed.
	 */
	public String getContent()
	{
		return getContent( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ModuleCMSComponent.content</code> attribute. 
	 * @return the localized content - Catalog content to be displayed.
	 */
	public Map<Language,String> getAllContent(final SessionContext ctx)
	{
		return (Map<Language,String>)getAllLocalizedProperties(ctx,CONTENT,C2LManager.getInstance().getAllLanguages());
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ModuleCMSComponent.content</code> attribute. 
	 * @return the localized content - Catalog content to be displayed.
	 */
	public Map<Language,String> getAllContent()
	{
		return getAllContent( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ModuleCMSComponent.content</code> attribute. 
	 * @param value the content - Catalog content to be displayed.
	 */
	public void setContent(final SessionContext ctx, final String value)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedModuleCMSComponent.setContent requires a session language", 0 );
		}
		setLocalizedProperty(ctx, CONTENT,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ModuleCMSComponent.content</code> attribute. 
	 * @param value the content - Catalog content to be displayed.
	 */
	public void setContent(final String value)
	{
		setContent( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ModuleCMSComponent.content</code> attribute. 
	 * @param value the content - Catalog content to be displayed.
	 */
	public void setAllContent(final SessionContext ctx, final Map<Language,String> value)
	{
		setAllLocalizedProperties(ctx,CONTENT,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ModuleCMSComponent.content</code> attribute. 
	 * @param value the content - Catalog content to be displayed.
	 */
	public void setAllContent(final Map<Language,String> value)
	{
		setAllContent( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ModuleCMSComponent.media</code> attribute.
	 * @return the media - Media to be displayed.
	 */
	public Media getMedia(final SessionContext ctx)
	{
		return (Media)getProperty( ctx, MEDIA);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ModuleCMSComponent.media</code> attribute.
	 * @return the media - Media to be displayed.
	 */
	public Media getMedia()
	{
		return getMedia( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ModuleCMSComponent.media</code> attribute. 
	 * @param value the media - Media to be displayed.
	 */
	public void setMedia(final SessionContext ctx, final Media value)
	{
		setProperty(ctx, MEDIA,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ModuleCMSComponent.media</code> attribute. 
	 * @param value the media - Media to be displayed.
	 */
	public void setMedia(final Media value)
	{
		setMedia( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ModuleCMSComponent.title</code> attribute.
	 * @return the title - Catalog title to be displayed.
	 */
	public String getTitle(final SessionContext ctx)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedModuleCMSComponent.getTitle requires a session language", 0 );
		}
		return (String)getLocalizedProperty( ctx, TITLE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ModuleCMSComponent.title</code> attribute.
	 * @return the title - Catalog title to be displayed.
	 */
	public String getTitle()
	{
		return getTitle( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ModuleCMSComponent.title</code> attribute. 
	 * @return the localized title - Catalog title to be displayed.
	 */
	public Map<Language,String> getAllTitle(final SessionContext ctx)
	{
		return (Map<Language,String>)getAllLocalizedProperties(ctx,TITLE,C2LManager.getInstance().getAllLanguages());
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ModuleCMSComponent.title</code> attribute. 
	 * @return the localized title - Catalog title to be displayed.
	 */
	public Map<Language,String> getAllTitle()
	{
		return getAllTitle( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ModuleCMSComponent.title</code> attribute. 
	 * @param value the title - Catalog title to be displayed.
	 */
	public void setTitle(final SessionContext ctx, final String value)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedModuleCMSComponent.setTitle requires a session language", 0 );
		}
		setLocalizedProperty(ctx, TITLE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ModuleCMSComponent.title</code> attribute. 
	 * @param value the title - Catalog title to be displayed.
	 */
	public void setTitle(final String value)
	{
		setTitle( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ModuleCMSComponent.title</code> attribute. 
	 * @param value the title - Catalog title to be displayed.
	 */
	public void setAllTitle(final SessionContext ctx, final Map<Language,String> value)
	{
		setAllLocalizedProperties(ctx,TITLE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ModuleCMSComponent.title</code> attribute. 
	 * @param value the title - Catalog title to be displayed.
	 */
	public void setAllTitle(final Map<Language,String> value)
	{
		setAllTitle( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ModuleCMSComponent.url</code> attribute.
	 * @return the url - Catalogue URL.
	 */
	public String getUrl(final SessionContext ctx)
	{
		return (String)getProperty( ctx, URL);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ModuleCMSComponent.url</code> attribute.
	 * @return the url - Catalogue URL.
	 */
	public String getUrl()
	{
		return getUrl( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ModuleCMSComponent.url</code> attribute. 
	 * @param value the url - Catalogue URL.
	 */
	public void setUrl(final SessionContext ctx, final String value)
	{
		setProperty(ctx, URL,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ModuleCMSComponent.url</code> attribute. 
	 * @param value the url - Catalogue URL.
	 */
	public void setUrl(final String value)
	{
		setUrl( getSession().getSessionContext(), value );
	}
	
}
