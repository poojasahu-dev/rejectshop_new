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
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type {@link au.com.rejectshop.core.jalo.components.AccordionItemCMSComponent AccordionItemCMSComponent}.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedAccordionItemCMSComponent extends SimpleCMSComponent
{
	/** Qualifier of the <code>AccordionItemCMSComponent.accordionheader</code> attribute **/
	public static final String ACCORDIONHEADER = "accordionheader";
	/** Qualifier of the <code>AccordionItemCMSComponent.content</code> attribute **/
	public static final String CONTENT = "content";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>(SimpleCMSComponent.DEFAULT_INITIAL_ATTRIBUTES);
		tmp.put(ACCORDIONHEADER, AttributeMode.INITIAL);
		tmp.put(CONTENT, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AccordionItemCMSComponent.accordionheader</code> attribute.
	 * @return the accordionheader - Header of the component.
	 */
	public String getAccordionheader(final SessionContext ctx)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedAccordionItemCMSComponent.getAccordionheader requires a session language", 0 );
		}
		return (String)getLocalizedProperty( ctx, ACCORDIONHEADER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AccordionItemCMSComponent.accordionheader</code> attribute.
	 * @return the accordionheader - Header of the component.
	 */
	public String getAccordionheader()
	{
		return getAccordionheader( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AccordionItemCMSComponent.accordionheader</code> attribute. 
	 * @return the localized accordionheader - Header of the component.
	 */
	public Map<Language,String> getAllAccordionheader(final SessionContext ctx)
	{
		return (Map<Language,String>)getAllLocalizedProperties(ctx,ACCORDIONHEADER,C2LManager.getInstance().getAllLanguages());
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AccordionItemCMSComponent.accordionheader</code> attribute. 
	 * @return the localized accordionheader - Header of the component.
	 */
	public Map<Language,String> getAllAccordionheader()
	{
		return getAllAccordionheader( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>AccordionItemCMSComponent.accordionheader</code> attribute. 
	 * @param value the accordionheader - Header of the component.
	 */
	public void setAccordionheader(final SessionContext ctx, final String value)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedAccordionItemCMSComponent.setAccordionheader requires a session language", 0 );
		}
		setLocalizedProperty(ctx, ACCORDIONHEADER,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>AccordionItemCMSComponent.accordionheader</code> attribute. 
	 * @param value the accordionheader - Header of the component.
	 */
	public void setAccordionheader(final String value)
	{
		setAccordionheader( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>AccordionItemCMSComponent.accordionheader</code> attribute. 
	 * @param value the accordionheader - Header of the component.
	 */
	public void setAllAccordionheader(final SessionContext ctx, final Map<Language,String> value)
	{
		setAllLocalizedProperties(ctx,ACCORDIONHEADER,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>AccordionItemCMSComponent.accordionheader</code> attribute. 
	 * @param value the accordionheader - Header of the component.
	 */
	public void setAllAccordionheader(final Map<Language,String> value)
	{
		setAllAccordionheader( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AccordionItemCMSComponent.content</code> attribute.
	 * @return the content - Content of the component.
	 */
	public String getContent(final SessionContext ctx)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedAccordionItemCMSComponent.getContent requires a session language", 0 );
		}
		return (String)getLocalizedProperty( ctx, CONTENT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AccordionItemCMSComponent.content</code> attribute.
	 * @return the content - Content of the component.
	 */
	public String getContent()
	{
		return getContent( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AccordionItemCMSComponent.content</code> attribute. 
	 * @return the localized content - Content of the component.
	 */
	public Map<Language,String> getAllContent(final SessionContext ctx)
	{
		return (Map<Language,String>)getAllLocalizedProperties(ctx,CONTENT,C2LManager.getInstance().getAllLanguages());
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AccordionItemCMSComponent.content</code> attribute. 
	 * @return the localized content - Content of the component.
	 */
	public Map<Language,String> getAllContent()
	{
		return getAllContent( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>AccordionItemCMSComponent.content</code> attribute. 
	 * @param value the content - Content of the component.
	 */
	public void setContent(final SessionContext ctx, final String value)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedAccordionItemCMSComponent.setContent requires a session language", 0 );
		}
		setLocalizedProperty(ctx, CONTENT,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>AccordionItemCMSComponent.content</code> attribute. 
	 * @param value the content - Content of the component.
	 */
	public void setContent(final String value)
	{
		setContent( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>AccordionItemCMSComponent.content</code> attribute. 
	 * @param value the content - Content of the component.
	 */
	public void setAllContent(final SessionContext ctx, final Map<Language,String> value)
	{
		setAllLocalizedProperties(ctx,CONTENT,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>AccordionItemCMSComponent.content</code> attribute. 
	 * @param value the content - Content of the component.
	 */
	public void setAllContent(final Map<Language,String> value)
	{
		setAllContent( getSession().getSessionContext(), value );
	}
	
}
