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
 * Generated class for type {@link au.com.rejectshop.core.jalo.components.GiftVouchersCMSComponent GiftVouchersCMSComponent}.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedGiftVouchersCMSComponent extends SimpleCMSComponent
{
	/** Qualifier of the <code>GiftVouchersCMSComponent.title</code> attribute **/
	public static final String TITLE = "title";
	/** Qualifier of the <code>GiftVouchersCMSComponent.media</code> attribute **/
	public static final String MEDIA = "media";
	/** Qualifier of the <code>GiftVouchersCMSComponent.buttonLabel</code> attribute **/
	public static final String BUTTONLABEL = "buttonLabel";
	/** Qualifier of the <code>GiftVouchersCMSComponent.buttonText</code> attribute **/
	public static final String BUTTONTEXT = "buttonText";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>(SimpleCMSComponent.DEFAULT_INITIAL_ATTRIBUTES);
		tmp.put(TITLE, AttributeMode.INITIAL);
		tmp.put(MEDIA, AttributeMode.INITIAL);
		tmp.put(BUTTONLABEL, AttributeMode.INITIAL);
		tmp.put(BUTTONTEXT, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>GiftVouchersCMSComponent.buttonLabel</code> attribute.
	 * @return the buttonLabel - Label for the button.
	 */
	public String getButtonLabel(final SessionContext ctx)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedGiftVouchersCMSComponent.getButtonLabel requires a session language", 0 );
		}
		return (String)getLocalizedProperty( ctx, BUTTONLABEL);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>GiftVouchersCMSComponent.buttonLabel</code> attribute.
	 * @return the buttonLabel - Label for the button.
	 */
	public String getButtonLabel()
	{
		return getButtonLabel( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>GiftVouchersCMSComponent.buttonLabel</code> attribute. 
	 * @return the localized buttonLabel - Label for the button.
	 */
	public Map<Language,String> getAllButtonLabel(final SessionContext ctx)
	{
		return (Map<Language,String>)getAllLocalizedProperties(ctx,BUTTONLABEL,C2LManager.getInstance().getAllLanguages());
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>GiftVouchersCMSComponent.buttonLabel</code> attribute. 
	 * @return the localized buttonLabel - Label for the button.
	 */
	public Map<Language,String> getAllButtonLabel()
	{
		return getAllButtonLabel( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>GiftVouchersCMSComponent.buttonLabel</code> attribute. 
	 * @param value the buttonLabel - Label for the button.
	 */
	public void setButtonLabel(final SessionContext ctx, final String value)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedGiftVouchersCMSComponent.setButtonLabel requires a session language", 0 );
		}
		setLocalizedProperty(ctx, BUTTONLABEL,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>GiftVouchersCMSComponent.buttonLabel</code> attribute. 
	 * @param value the buttonLabel - Label for the button.
	 */
	public void setButtonLabel(final String value)
	{
		setButtonLabel( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>GiftVouchersCMSComponent.buttonLabel</code> attribute. 
	 * @param value the buttonLabel - Label for the button.
	 */
	public void setAllButtonLabel(final SessionContext ctx, final Map<Language,String> value)
	{
		setAllLocalizedProperties(ctx,BUTTONLABEL,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>GiftVouchersCMSComponent.buttonLabel</code> attribute. 
	 * @param value the buttonLabel - Label for the button.
	 */
	public void setAllButtonLabel(final Map<Language,String> value)
	{
		setAllButtonLabel( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>GiftVouchersCMSComponent.buttonText</code> attribute.
	 * @return the buttonText - Text to be displayed for the button.
	 */
	public String getButtonText(final SessionContext ctx)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedGiftVouchersCMSComponent.getButtonText requires a session language", 0 );
		}
		return (String)getLocalizedProperty( ctx, BUTTONTEXT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>GiftVouchersCMSComponent.buttonText</code> attribute.
	 * @return the buttonText - Text to be displayed for the button.
	 */
	public String getButtonText()
	{
		return getButtonText( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>GiftVouchersCMSComponent.buttonText</code> attribute. 
	 * @return the localized buttonText - Text to be displayed for the button.
	 */
	public Map<Language,String> getAllButtonText(final SessionContext ctx)
	{
		return (Map<Language,String>)getAllLocalizedProperties(ctx,BUTTONTEXT,C2LManager.getInstance().getAllLanguages());
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>GiftVouchersCMSComponent.buttonText</code> attribute. 
	 * @return the localized buttonText - Text to be displayed for the button.
	 */
	public Map<Language,String> getAllButtonText()
	{
		return getAllButtonText( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>GiftVouchersCMSComponent.buttonText</code> attribute. 
	 * @param value the buttonText - Text to be displayed for the button.
	 */
	public void setButtonText(final SessionContext ctx, final String value)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedGiftVouchersCMSComponent.setButtonText requires a session language", 0 );
		}
		setLocalizedProperty(ctx, BUTTONTEXT,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>GiftVouchersCMSComponent.buttonText</code> attribute. 
	 * @param value the buttonText - Text to be displayed for the button.
	 */
	public void setButtonText(final String value)
	{
		setButtonText( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>GiftVouchersCMSComponent.buttonText</code> attribute. 
	 * @param value the buttonText - Text to be displayed for the button.
	 */
	public void setAllButtonText(final SessionContext ctx, final Map<Language,String> value)
	{
		setAllLocalizedProperties(ctx,BUTTONTEXT,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>GiftVouchersCMSComponent.buttonText</code> attribute. 
	 * @param value the buttonText - Text to be displayed for the button.
	 */
	public void setAllButtonText(final Map<Language,String> value)
	{
		setAllButtonText( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>GiftVouchersCMSComponent.media</code> attribute.
	 * @return the media - Stores media for the component.
	 */
	public Media getMedia(final SessionContext ctx)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedGiftVouchersCMSComponent.getMedia requires a session language", 0 );
		}
		return (Media)getLocalizedProperty( ctx, MEDIA);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>GiftVouchersCMSComponent.media</code> attribute.
	 * @return the media - Stores media for the component.
	 */
	public Media getMedia()
	{
		return getMedia( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>GiftVouchersCMSComponent.media</code> attribute. 
	 * @return the localized media - Stores media for the component.
	 */
	public Map<Language,Media> getAllMedia(final SessionContext ctx)
	{
		return (Map<Language,Media>)getAllLocalizedProperties(ctx,MEDIA,C2LManager.getInstance().getAllLanguages());
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>GiftVouchersCMSComponent.media</code> attribute. 
	 * @return the localized media - Stores media for the component.
	 */
	public Map<Language,Media> getAllMedia()
	{
		return getAllMedia( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>GiftVouchersCMSComponent.media</code> attribute. 
	 * @param value the media - Stores media for the component.
	 */
	public void setMedia(final SessionContext ctx, final Media value)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedGiftVouchersCMSComponent.setMedia requires a session language", 0 );
		}
		setLocalizedProperty(ctx, MEDIA,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>GiftVouchersCMSComponent.media</code> attribute. 
	 * @param value the media - Stores media for the component.
	 */
	public void setMedia(final Media value)
	{
		setMedia( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>GiftVouchersCMSComponent.media</code> attribute. 
	 * @param value the media - Stores media for the component.
	 */
	public void setAllMedia(final SessionContext ctx, final Map<Language,Media> value)
	{
		setAllLocalizedProperties(ctx,MEDIA,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>GiftVouchersCMSComponent.media</code> attribute. 
	 * @param value the media - Stores media for the component.
	 */
	public void setAllMedia(final Map<Language,Media> value)
	{
		setAllMedia( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>GiftVouchersCMSComponent.title</code> attribute.
	 * @return the title - Title for the component.
	 */
	public String getTitle(final SessionContext ctx)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedGiftVouchersCMSComponent.getTitle requires a session language", 0 );
		}
		return (String)getLocalizedProperty( ctx, TITLE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>GiftVouchersCMSComponent.title</code> attribute.
	 * @return the title - Title for the component.
	 */
	public String getTitle()
	{
		return getTitle( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>GiftVouchersCMSComponent.title</code> attribute. 
	 * @return the localized title - Title for the component.
	 */
	public Map<Language,String> getAllTitle(final SessionContext ctx)
	{
		return (Map<Language,String>)getAllLocalizedProperties(ctx,TITLE,C2LManager.getInstance().getAllLanguages());
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>GiftVouchersCMSComponent.title</code> attribute. 
	 * @return the localized title - Title for the component.
	 */
	public Map<Language,String> getAllTitle()
	{
		return getAllTitle( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>GiftVouchersCMSComponent.title</code> attribute. 
	 * @param value the title - Title for the component.
	 */
	public void setTitle(final SessionContext ctx, final String value)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedGiftVouchersCMSComponent.setTitle requires a session language", 0 );
		}
		setLocalizedProperty(ctx, TITLE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>GiftVouchersCMSComponent.title</code> attribute. 
	 * @param value the title - Title for the component.
	 */
	public void setTitle(final String value)
	{
		setTitle( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>GiftVouchersCMSComponent.title</code> attribute. 
	 * @param value the title - Title for the component.
	 */
	public void setAllTitle(final SessionContext ctx, final Map<Language,String> value)
	{
		setAllLocalizedProperties(ctx,TITLE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>GiftVouchersCMSComponent.title</code> attribute. 
	 * @param value the title - Title for the component.
	 */
	public void setAllTitle(final Map<Language,String> value)
	{
		setAllTitle( getSession().getSessionContext(), value );
	}
	
}
