/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jun 15, 2020 12:43:10 PM                    ---
 * ----------------------------------------------------------------
 */
package au.com.rejectshop.core.jalo.components;

import au.com.rejectshop.core.constants.RejectshopCoreConstants;
import au.com.rejectshop.core.jalo.ReportMedia;
import de.hybris.platform.cms2.jalo.contents.components.SimpleCMSComponent;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Generated class for type {@link au.com.rejectshop.core.jalo.components.ReportMediasCMSComponent ReportMediasCMSComponent}.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedReportMediasCMSComponent extends SimpleCMSComponent
{
	/** Qualifier of the <code>ReportMediasCMSComponent.year</code> attribute **/
	public static final String YEAR = "year";
	/** Qualifier of the <code>ReportMediasCMSComponent.reportMedias</code> attribute **/
	public static final String REPORTMEDIAS = "reportMedias";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>(SimpleCMSComponent.DEFAULT_INITIAL_ATTRIBUTES);
		tmp.put(YEAR, AttributeMode.INITIAL);
		tmp.put(REPORTMEDIAS, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ReportMediasCMSComponent.reportMedias</code> attribute.
	 * @return the reportMedias - List of report media.
	 */
	public List<ReportMedia> getReportMedias(final SessionContext ctx)
	{
		List<ReportMedia> coll = (List<ReportMedia>)getProperty( ctx, REPORTMEDIAS);
		return coll != null ? coll : Collections.EMPTY_LIST;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ReportMediasCMSComponent.reportMedias</code> attribute.
	 * @return the reportMedias - List of report media.
	 */
	public List<ReportMedia> getReportMedias()
	{
		return getReportMedias( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ReportMediasCMSComponent.reportMedias</code> attribute. 
	 * @param value the reportMedias - List of report media.
	 */
	public void setReportMedias(final SessionContext ctx, final List<ReportMedia> value)
	{
		setProperty(ctx, REPORTMEDIAS,value == null || !value.isEmpty() ? value : null );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ReportMediasCMSComponent.reportMedias</code> attribute. 
	 * @param value the reportMedias - List of report media.
	 */
	public void setReportMedias(final List<ReportMedia> value)
	{
		setReportMedias( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ReportMediasCMSComponent.year</code> attribute.
	 * @return the year - Year for which report component is to be rendered.
	 */
	public Integer getYear(final SessionContext ctx)
	{
		return (Integer)getProperty( ctx, YEAR);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ReportMediasCMSComponent.year</code> attribute.
	 * @return the year - Year for which report component is to be rendered.
	 */
	public Integer getYear()
	{
		return getYear( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ReportMediasCMSComponent.year</code> attribute. 
	 * @return the year - Year for which report component is to be rendered.
	 */
	public int getYearAsPrimitive(final SessionContext ctx)
	{
		Integer value = getYear( ctx );
		return value != null ? value.intValue() : 0;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ReportMediasCMSComponent.year</code> attribute. 
	 * @return the year - Year for which report component is to be rendered.
	 */
	public int getYearAsPrimitive()
	{
		return getYearAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ReportMediasCMSComponent.year</code> attribute. 
	 * @param value the year - Year for which report component is to be rendered.
	 */
	public void setYear(final SessionContext ctx, final Integer value)
	{
		setProperty(ctx, YEAR,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ReportMediasCMSComponent.year</code> attribute. 
	 * @param value the year - Year for which report component is to be rendered.
	 */
	public void setYear(final Integer value)
	{
		setYear( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ReportMediasCMSComponent.year</code> attribute. 
	 * @param value the year - Year for which report component is to be rendered.
	 */
	public void setYear(final SessionContext ctx, final int value)
	{
		setYear( ctx,Integer.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ReportMediasCMSComponent.year</code> attribute. 
	 * @param value the year - Year for which report component is to be rendered.
	 */
	public void setYear(final int value)
	{
		setYear( getSession().getSessionContext(), value );
	}
	
}
