/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jun 15, 2020 12:43:10 PM                    ---
 * ----------------------------------------------------------------
 */
package au.com.rejectshop.core.jalo.components;

import au.com.rejectshop.core.constants.RejectshopCoreConstants;
import au.com.rejectshop.core.jalo.components.ReportMediasCMSComponent;
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
 * Generated class for type {@link au.com.rejectshop.core.jalo.components.CMSReportListComponent CMSReportListComponent}.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedCMSReportListComponent extends SimpleCMSComponent
{
	/** Qualifier of the <code>CMSReportListComponent.title</code> attribute **/
	public static final String TITLE = "title";
	/** Qualifier of the <code>CMSReportListComponent.archivesTitle</code> attribute **/
	public static final String ARCHIVESTITLE = "archivesTitle";
	/** Qualifier of the <code>CMSReportListComponent.numberOfLatestReports</code> attribute **/
	public static final String NUMBEROFLATESTREPORTS = "numberOfLatestReports";
	/** Qualifier of the <code>CMSReportListComponent.reportComponents</code> attribute **/
	public static final String REPORTCOMPONENTS = "reportComponents";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>(SimpleCMSComponent.DEFAULT_INITIAL_ATTRIBUTES);
		tmp.put(TITLE, AttributeMode.INITIAL);
		tmp.put(ARCHIVESTITLE, AttributeMode.INITIAL);
		tmp.put(NUMBEROFLATESTREPORTS, AttributeMode.INITIAL);
		tmp.put(REPORTCOMPONENTS, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSReportListComponent.archivesTitle</code> attribute.
	 * @return the archivesTitle - Archives title for the component.
	 */
	public String getArchivesTitle(final SessionContext ctx)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedCMSReportListComponent.getArchivesTitle requires a session language", 0 );
		}
		return (String)getLocalizedProperty( ctx, ARCHIVESTITLE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSReportListComponent.archivesTitle</code> attribute.
	 * @return the archivesTitle - Archives title for the component.
	 */
	public String getArchivesTitle()
	{
		return getArchivesTitle( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSReportListComponent.archivesTitle</code> attribute. 
	 * @return the localized archivesTitle - Archives title for the component.
	 */
	public Map<Language,String> getAllArchivesTitle(final SessionContext ctx)
	{
		return (Map<Language,String>)getAllLocalizedProperties(ctx,ARCHIVESTITLE,C2LManager.getInstance().getAllLanguages());
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSReportListComponent.archivesTitle</code> attribute. 
	 * @return the localized archivesTitle - Archives title for the component.
	 */
	public Map<Language,String> getAllArchivesTitle()
	{
		return getAllArchivesTitle( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CMSReportListComponent.archivesTitle</code> attribute. 
	 * @param value the archivesTitle - Archives title for the component.
	 */
	public void setArchivesTitle(final SessionContext ctx, final String value)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedCMSReportListComponent.setArchivesTitle requires a session language", 0 );
		}
		setLocalizedProperty(ctx, ARCHIVESTITLE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CMSReportListComponent.archivesTitle</code> attribute. 
	 * @param value the archivesTitle - Archives title for the component.
	 */
	public void setArchivesTitle(final String value)
	{
		setArchivesTitle( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CMSReportListComponent.archivesTitle</code> attribute. 
	 * @param value the archivesTitle - Archives title for the component.
	 */
	public void setAllArchivesTitle(final SessionContext ctx, final Map<Language,String> value)
	{
		setAllLocalizedProperties(ctx,ARCHIVESTITLE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CMSReportListComponent.archivesTitle</code> attribute. 
	 * @param value the archivesTitle - Archives title for the component.
	 */
	public void setAllArchivesTitle(final Map<Language,String> value)
	{
		setAllArchivesTitle( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSReportListComponent.numberOfLatestReports</code> attribute.
	 * @return the numberOfLatestReports - Number of reports that should be displayed as latest in the component.
	 */
	public Integer getNumberOfLatestReports(final SessionContext ctx)
	{
		return (Integer)getProperty( ctx, NUMBEROFLATESTREPORTS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSReportListComponent.numberOfLatestReports</code> attribute.
	 * @return the numberOfLatestReports - Number of reports that should be displayed as latest in the component.
	 */
	public Integer getNumberOfLatestReports()
	{
		return getNumberOfLatestReports( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSReportListComponent.numberOfLatestReports</code> attribute. 
	 * @return the numberOfLatestReports - Number of reports that should be displayed as latest in the component.
	 */
	public int getNumberOfLatestReportsAsPrimitive(final SessionContext ctx)
	{
		Integer value = getNumberOfLatestReports( ctx );
		return value != null ? value.intValue() : 0;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSReportListComponent.numberOfLatestReports</code> attribute. 
	 * @return the numberOfLatestReports - Number of reports that should be displayed as latest in the component.
	 */
	public int getNumberOfLatestReportsAsPrimitive()
	{
		return getNumberOfLatestReportsAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CMSReportListComponent.numberOfLatestReports</code> attribute. 
	 * @param value the numberOfLatestReports - Number of reports that should be displayed as latest in the component.
	 */
	public void setNumberOfLatestReports(final SessionContext ctx, final Integer value)
	{
		setProperty(ctx, NUMBEROFLATESTREPORTS,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CMSReportListComponent.numberOfLatestReports</code> attribute. 
	 * @param value the numberOfLatestReports - Number of reports that should be displayed as latest in the component.
	 */
	public void setNumberOfLatestReports(final Integer value)
	{
		setNumberOfLatestReports( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CMSReportListComponent.numberOfLatestReports</code> attribute. 
	 * @param value the numberOfLatestReports - Number of reports that should be displayed as latest in the component.
	 */
	public void setNumberOfLatestReports(final SessionContext ctx, final int value)
	{
		setNumberOfLatestReports( ctx,Integer.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CMSReportListComponent.numberOfLatestReports</code> attribute. 
	 * @param value the numberOfLatestReports - Number of reports that should be displayed as latest in the component.
	 */
	public void setNumberOfLatestReports(final int value)
	{
		setNumberOfLatestReports( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSReportListComponent.reportComponents</code> attribute.
	 * @return the reportComponents - List of reports to be rendered in this component.
	 */
	public List<ReportMediasCMSComponent> getReportComponents(final SessionContext ctx)
	{
		List<ReportMediasCMSComponent> coll = (List<ReportMediasCMSComponent>)getProperty( ctx, REPORTCOMPONENTS);
		return coll != null ? coll : Collections.EMPTY_LIST;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSReportListComponent.reportComponents</code> attribute.
	 * @return the reportComponents - List of reports to be rendered in this component.
	 */
	public List<ReportMediasCMSComponent> getReportComponents()
	{
		return getReportComponents( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CMSReportListComponent.reportComponents</code> attribute. 
	 * @param value the reportComponents - List of reports to be rendered in this component.
	 */
	public void setReportComponents(final SessionContext ctx, final List<ReportMediasCMSComponent> value)
	{
		setProperty(ctx, REPORTCOMPONENTS,value == null || !value.isEmpty() ? value : null );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CMSReportListComponent.reportComponents</code> attribute. 
	 * @param value the reportComponents - List of reports to be rendered in this component.
	 */
	public void setReportComponents(final List<ReportMediasCMSComponent> value)
	{
		setReportComponents( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSReportListComponent.title</code> attribute.
	 * @return the title - Title for the component.
	 */
	public String getTitle(final SessionContext ctx)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedCMSReportListComponent.getTitle requires a session language", 0 );
		}
		return (String)getLocalizedProperty( ctx, TITLE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSReportListComponent.title</code> attribute.
	 * @return the title - Title for the component.
	 */
	public String getTitle()
	{
		return getTitle( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSReportListComponent.title</code> attribute. 
	 * @return the localized title - Title for the component.
	 */
	public Map<Language,String> getAllTitle(final SessionContext ctx)
	{
		return (Map<Language,String>)getAllLocalizedProperties(ctx,TITLE,C2LManager.getInstance().getAllLanguages());
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CMSReportListComponent.title</code> attribute. 
	 * @return the localized title - Title for the component.
	 */
	public Map<Language,String> getAllTitle()
	{
		return getAllTitle( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CMSReportListComponent.title</code> attribute. 
	 * @param value the title - Title for the component.
	 */
	public void setTitle(final SessionContext ctx, final String value)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedCMSReportListComponent.setTitle requires a session language", 0 );
		}
		setLocalizedProperty(ctx, TITLE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CMSReportListComponent.title</code> attribute. 
	 * @param value the title - Title for the component.
	 */
	public void setTitle(final String value)
	{
		setTitle( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CMSReportListComponent.title</code> attribute. 
	 * @param value the title - Title for the component.
	 */
	public void setAllTitle(final SessionContext ctx, final Map<Language,String> value)
	{
		setAllLocalizedProperties(ctx,TITLE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CMSReportListComponent.title</code> attribute. 
	 * @param value the title - Title for the component.
	 */
	public void setAllTitle(final Map<Language,String> value)
	{
		setAllTitle( getSession().getSessionContext(), value );
	}
	
}
