/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jun 15, 2020 12:43:10 PM                    ---
 * ----------------------------------------------------------------
 */
package au.com.rejectshop.core.jalo.components;

import au.com.rejectshop.core.constants.RejectshopCoreConstants;
import au.com.rejectshop.core.jalo.components.AccordionItemCMSComponent;
import de.hybris.platform.cms2.jalo.contents.components.SimpleCMSComponent;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.JaloInvalidParameterException;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.c2l.C2LManager;
import de.hybris.platform.jalo.c2l.Language;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Generated class for type {@link au.com.rejectshop.core.jalo.components.CMSAccordionListComponent CMSAccordionListComponent}.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedCMSAccordionListComponent extends SimpleCMSComponent
{
	/** Qualifier of the <code>CMSAccordionListComponent.title</code> attribute **/
	public static final String TITLE = "title";
	/** Qualifier of the <code>CMSAccordionListComponent.accordionItems</code> attribute **/
	public static final String ACCORDIONITEMS = "accordionItems";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>(SimpleCMSComponent.DEFAULT_INITIAL_ATTRIBUTES);
		tmp.put(TITLE, AttributeMode.INITIAL);
		tmp.put(ACCORDIONITEMS, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSAccordionListComponent.accordionItems</code> attribute.
	 * @return the accordionItems - List of Accordion Item components to be rendered in this component.
	 */
	public List<AccordionItemCMSComponent> getAccordionItems(final SessionContext ctx)
	{
		List<AccordionItemCMSComponent> coll = (List<AccordionItemCMSComponent>)getProperty( ctx, ACCORDIONITEMS);
		return coll != null ? coll : Collections.EMPTY_LIST;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSAccordionListComponent.accordionItems</code> attribute.
	 * @return the accordionItems - List of Accordion Item components to be rendered in this component.
	 */
	public List<AccordionItemCMSComponent> getAccordionItems()
	{
		return getAccordionItems( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CMSAccordionListComponent.accordionItems</code> attribute. 
	 * @param value the accordionItems - List of Accordion Item components to be rendered in this component.
	 */
	public void setAccordionItems(final SessionContext ctx, final List<AccordionItemCMSComponent> value)
	{
		setProperty(ctx, ACCORDIONITEMS,value == null || !value.isEmpty() ? value : null );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CMSAccordionListComponent.accordionItems</code> attribute. 
	 * @param value the accordionItems - List of Accordion Item components to be rendered in this component.
	 */
	public void setAccordionItems(final List<AccordionItemCMSComponent> value)
	{
		setAccordionItems( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSAccordionListComponent.title</code> attribute.
	 * @return the title - Title of the component to be rendered.
	 */
	public String getTitle(final SessionContext ctx)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedCMSAccordionListComponent.getTitle requires a session language", 0 );
		}
		return (String)getLocalizedProperty( ctx, TITLE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSAccordionListComponent.title</code> attribute.
	 * @return the title - Title of the component to be rendered.
	 */
	public String getTitle()
	{
		return getTitle( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSAccordionListComponent.title</code> attribute. 
	 * @return the localized title - Title of the component to be rendered.
	 */
	public Map<Language,String> getAllTitle(final SessionContext ctx)
	{
		return (Map<Language,String>)getAllLocalizedProperties(ctx,TITLE,C2LManager.getInstance().getAllLanguages());
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSAccordionListComponent.title</code> attribute. 
	 * @return the localized title - Title of the component to be rendered.
	 */
	public Map<Language,String> getAllTitle()
	{
		return getAllTitle( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CMSAccordionListComponent.title</code> attribute. 
	 * @param value the title - Title of the component to be rendered.
	 */
	public void setTitle(final SessionContext ctx, final String value)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedCMSAccordionListComponent.setTitle requires a session language", 0 );
		}
		setLocalizedProperty(ctx, TITLE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CMSAccordionListComponent.title</code> attribute. 
	 * @param value the title - Title of the component to be rendered.
	 */
	public void setTitle(final String value)
	{
		setTitle( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CMSAccordionListComponent.title</code> attribute. 
	 * @param value the title - Title of the component to be rendered.
	 */
	public void setAllTitle(final SessionContext ctx, final Map<Language,String> value)
	{
		setAllLocalizedProperties(ctx,TITLE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CMSAccordionListComponent.title</code> attribute. 
	 * @param value the title - Title of the component to be rendered.
	 */
	public void setAllTitle(final Map<Language,String> value)
	{
		setAllTitle( getSession().getSessionContext(), value );
	}
	
}
