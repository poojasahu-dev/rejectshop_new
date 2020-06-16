/**
 *
 */
package au.com.rejectshop.storefront.util;

import java.util.Comparator;

import au.com.rejectshop.core.model.components.ReportMediasCMSComponentModel;


/**
 * @author venkatapavani.t
 *
 */
public class FinancialReportYearComparator implements Comparator<ReportMediasCMSComponentModel>
{
	@SuppressWarnings("boxing")
	public int compare(final ReportMediasCMSComponentModel report1, final ReportMediasCMSComponentModel report2)
	{
		if (report2.getYear() != null && report1.getYear() != null)
		{
			return report2.getYear() - report1.getYear();
		}

		return 0;
	}
}
