/**
 *
 */
package au.com.rejectshop.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.log4j.Logger;


/**
 * @author subrahmanyam.n
 *
 */
public class DateUtility
{
	private static final Logger LOG = Logger.getLogger(DateUtility.class);

	/**
	 * Return Date in specified string format
	 *
	 * @param format
	 * @return String
	 */
	public static String getDateInString(final String format) {
		final SimpleDateFormat dateFormat = new SimpleDateFormat(format, Locale.ENGLISH);
		final Date date = new Date();
		String dateInStr = null;
		try
		{
			dateInStr = dateFormat.format(date);
		}
		catch (final Exception exception)
		{
			LOG.error("Error while formatting the Date to String ", exception);
		}
		return dateInStr;
	}
}
