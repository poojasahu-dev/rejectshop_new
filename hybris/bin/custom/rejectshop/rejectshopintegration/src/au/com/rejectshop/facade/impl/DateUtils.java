package au.com.rejectshop.facade.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.apache.log4j.Logger;


/**
 * DateUtils is the an utility class perform operations on date and time.
 */
public class DateUtils
{
	private static final Logger LOG = Logger.getLogger(DateUtils.class);


	/**
	 * Returns the Current Date in specified string format
	 * 
	 * @param format
	 * @return String
	 */
	public static String getDateInString(final String format)
	{

		final SimpleDateFormat dateFormat = new SimpleDateFormat(format, Locale.ENGLISH);
		final Date date = new Date();
		String dateInStr = null;
		try
		{
			dateInStr = dateFormat.format(date);
		}
		catch (final Exception e)
		{
			LOG.error("Error while formatting the Date to String " + e.getMessage(),e);
		}
		return dateInStr;
	}

	/**
	 * This method converts the given date to required format
	 * 
	 * @param date
	 * @param format
	 * @return String
	 */
	public static String getDateInString(final Date date, final String format)
	{
		final SimpleDateFormat dateFormat = new SimpleDateFormat(format, Locale.ENGLISH);
		String dateInStr = null;
		try
		{
			if (date != null)
			{
				dateInStr = dateFormat.format(date);
			}
		}
		catch (final Exception e)
		{
			LOG.error("Error while formatting the Date to String " + e.getMessage(),e);
		}
		return dateInStr;
	}

	/**
	 * Gets the Date in UTC Format
	 * 
	 * @param date
	 * @param format
	 * @return String
	 */
	public static String getDateInUTC(final Date date, final String format)
	{
		final TimeZone utc = TimeZone.getTimeZone("UTC");
		final SimpleDateFormat sdf = new SimpleDateFormat(format);
		sdf.setTimeZone(utc);
		return sdf.format(date);
	}


	/**
	 * Get time difference as string.
	 * 
	 * @param date1
	 *           Date
	 * @param date2
	 *           Date
	 * @return time difference as string.
	 */
	public static String getTimeDifferenceAsString(final Date date1, final Date date2)
	{

		final Calendar calendar1 = Calendar.getInstance();
		final Calendar calendar2 = Calendar.getInstance();
		calendar1.setTime(date1);
		calendar2.setTime(date2);

		final long diff = calendar2.getTimeInMillis() - calendar1.getTimeInMillis();
		final long diffSeconds = diff / 1000 % 60;
		final long diffMinutes = diff / (60 * 1000) % 60;
		final long diffHours = diff / (60 * 60 * 1000) % 24;
		final long diffDays = diff / (24 * 60 * 60 * 1000);

		final StringBuilder timeDifference = new StringBuilder();

		if (diffDays > 0)
		{
			timeDifference.append(diffDays + " days, ");
		}
		if (diffHours > 0)
		{
			timeDifference.append(diffHours + " hours, ");
		}
		if (diffMinutes > 0)
		{
			timeDifference.append(diffMinutes + " minutes, ");
		}
		if (diffSeconds > 0)
		{
			timeDifference.append(diffSeconds + " seconds, ");
		}

		if (diff > 0)
		{
			timeDifference.append(diff + " milliseconds.");
		}


		return timeDifference.toString();
	}

	/**
	 * Convert String as Date Object.
	 * 
	 * @param dateString
	 * @return Date
	 */
	public static Date getMMddyyDateFormat(final String dateString)
	{
		Date date = null;
		final String format = "MM/dd/yy";
		try
		{
			final SimpleDateFormat sdf = new SimpleDateFormat(format);
			date = sdf.parse(dateString);
		}
		catch (final ParseException e)
		{
			LOG.error(e.getMessage(),e);
		}

		return date;

	}

	public static Date getddMMyyDateFormat(final String dateString)
	{
		Date date = null;
		final String format = "dd/MM/yy";
		try
		{
			final SimpleDateFormat sdf = new SimpleDateFormat(format);
			date = sdf.parse(dateString);
		}
		catch (final ParseException e)
		{
			LOG.error(e.getMessage(),e);
		}

		return date;

	}

	/**
	 * @return current system Date in dd/MM/yyyy format
	 */
	public static Date getCurrentDateInddMMyyyyFormat()
	{
		Date date = new Date();
		final String format = "dd/MM/yyyy";

		try
		{
			final SimpleDateFormat sdf = new SimpleDateFormat(format);
			date = sdf.parse(DateUtils.getDateInString(date, "dd/MM/yyyy"));
		}
		catch (final ParseException e)
		{
			LOG.error("Error in getting the current date in dd/MM/yyyy format ", e);
		}
		return date;
	}



	/**
	 * @param date
	 * @return Date
	 */
	public static Date getDateOnlyFromDate(final Date date)
	{
		Date dateWithoutTime = date;
		try
		{
			final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dateWithoutTime = sdf.parse(sdf.format(date));
		}
		catch (final Exception ex)
		{
			LOG.error("Error in getDateOnlyFromDate  ", ex);
		}
		return dateWithoutTime;
	}

	public static Date getDateFromLocalDate(final LocalDate date)
	{
		final DateTimeFormatter sdf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Date dateWithoutTime = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());

		return dateWithoutTime;
	}

	public static String getDateFormatForSpecificMonth(final String period, final String year)
	{

		int value;

		if (Integer.parseInt(period) > 6)
		{
			value = Integer.parseInt(year) - 1;
			return value + year.substring(2, 4);
		}
		else
		{
			value = Integer.parseInt(year.substring(2, 4)) + 1;
			return year + value;
		}
	}

	/**
	 * Convert string to date.
	 *
	 * @param dateInString the date in string
	 * @param format the format
	 * @return the date
	 */
	public static Date convertStringToDate(final String dateInString, final String format)
	{
		final SimpleDateFormat formatter = new SimpleDateFormat(format);
		Date date = null;
		try
		{
			date = formatter.parse(dateInString);
		}
		catch (final ParseException e)
		{
			e.printStackTrace();
		}
		return date;
	}
}
