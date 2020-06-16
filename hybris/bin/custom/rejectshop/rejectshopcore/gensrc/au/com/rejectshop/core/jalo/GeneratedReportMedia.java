/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jun 15, 2020 12:43:10 PM                    ---
 * ----------------------------------------------------------------
 */
package au.com.rejectshop.core.jalo;

import au.com.rejectshop.core.constants.RejectshopCoreConstants;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.JaloInvalidParameterException;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.c2l.C2LManager;
import de.hybris.platform.jalo.c2l.Language;
import de.hybris.platform.jalo.media.Media;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type {@link au.com.rejectshop.core.jalo.ReportMedia ReportMedia}.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedReportMedia extends Media
{
	/** Qualifier of the <code>ReportMedia.name</code> attribute **/
	public static final String NAME = "name";
	/** Qualifier of the <code>ReportMedia.uploadDate</code> attribute **/
	public static final String UPLOADDATE = "uploadDate";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>(Media.DEFAULT_INITIAL_ATTRIBUTES);
		tmp.put(NAME, AttributeMode.INITIAL);
		tmp.put(UPLOADDATE, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ReportMedia.name</code> attribute.
	 * @return the name - Localized name of the report
	 */
	public String getName(final SessionContext ctx)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedReportMedia.getName requires a session language", 0 );
		}
		return (String)getLocalizedProperty( ctx, NAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ReportMedia.name</code> attribute.
	 * @return the name - Localized name of the report
	 */
	public String getName()
	{
		return getName( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ReportMedia.name</code> attribute. 
	 * @return the localized name - Localized name of the report
	 */
	public Map<Language,String> getAllName(final SessionContext ctx)
	{
		return (Map<Language,String>)getAllLocalizedProperties(ctx,NAME,C2LManager.getInstance().getAllLanguages());
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ReportMedia.name</code> attribute. 
	 * @return the localized name - Localized name of the report
	 */
	public Map<Language,String> getAllName()
	{
		return getAllName( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ReportMedia.name</code> attribute. 
	 * @param value the name - Localized name of the report
	 */
	public void setName(final SessionContext ctx, final String value)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedReportMedia.setName requires a session language", 0 );
		}
		setLocalizedProperty(ctx, NAME,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ReportMedia.name</code> attribute. 
	 * @param value the name - Localized name of the report
	 */
	public void setName(final String value)
	{
		setName( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ReportMedia.name</code> attribute. 
	 * @param value the name - Localized name of the report
	 */
	public void setAllName(final SessionContext ctx, final Map<Language,String> value)
	{
		setAllLocalizedProperties(ctx,NAME,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ReportMedia.name</code> attribute. 
	 * @param value the name - Localized name of the report
	 */
	public void setAllName(final Map<Language,String> value)
	{
		setAllName( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ReportMedia.uploadDate</code> attribute.
	 * @return the uploadDate - Report Upload Date
	 */
	public Date getUploadDate(final SessionContext ctx)
	{
		return (Date)getProperty( ctx, UPLOADDATE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ReportMedia.uploadDate</code> attribute.
	 * @return the uploadDate - Report Upload Date
	 */
	public Date getUploadDate()
	{
		return getUploadDate( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ReportMedia.uploadDate</code> attribute. 
	 * @param value the uploadDate - Report Upload Date
	 */
	public void setUploadDate(final SessionContext ctx, final Date value)
	{
		setProperty(ctx, UPLOADDATE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ReportMedia.uploadDate</code> attribute. 
	 * @param value the uploadDate - Report Upload Date
	 */
	public void setUploadDate(final Date value)
	{
		setUploadDate( getSession().getSessionContext(), value );
	}
	
}
