package com.ebay.utils;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.paypal.hybris.constants.PaypalConstants;

import urn.ebay.apis.eBLBaseComponents.ErrorType;


public class PaypalStringUtils
{

	private static final Logger LOG = Logger.getLogger(PaypalStringUtils.class);

	public static final Locale LOCALE = Locale.US;
	public static final int DEFAULT_ROUND_DIGITS = 2;
	public static final boolean ROUND_UP = true;
	public static final String NUM_FORMAT = "%1$,." + DEFAULT_ROUND_DIGITS + "f";
	private static final double DELTA = 0.00001;
	private static final String ISO_8601_FORMATTER = "yyyy-MM-dd'T'HH:mm:ssX";

	/**
	 * Returns the parameter value, optionally in lower case.
	 *
	 * @param params
	 *           Parameters map
	 * @param key
	 *           Parameter key
	 * @param fToLower
	 *           Convert to lover case flag
	 * @return Parameter value or null if it's empty.
	 */
	public static String getParameterValue(final Map<String, String[]> params, final String key, final String defaultValue,
			final boolean fToLower)
	{
		if (params == null || params.size() <= 0 || key == null)
		{
			return defaultValue;
		}

		final String[] values = params.get(key);

		if (values == null || values.length < 1)
		{
			return defaultValue;
		}

		final String value = values[0];
		if (value == null)
		{
			return defaultValue;
		}

		if (fToLower)
		{
			return value.toLowerCase();
		}
		else
		{
			return value;
		}

	}

	public static Date getDateFromResponse(final String timeStamp)
	{
		final DateFormat formatter = new SimpleDateFormat(ISO_8601_FORMATTER);
		Date date = new Date();
		try
		{
			date = formatter.parse(timeStamp);
		}
		catch (final ParseException e)
		{
			LOG.error("[DATE PARSE ERROR](set current time) " + e.getMessage(), e);
		}
		return date;
	}

	public static Calendar getCalendarFromResponse(final String timeStamp)
	{
		final Calendar calendar = Calendar.getInstance();
		final Date date = getDateFromResponse(timeStamp);
		calendar.setTime(date);
		return calendar;
	}

	public static String getStringFromCalendar(final Calendar calendar)
	{
		final SimpleDateFormat sdf = new SimpleDateFormat(ISO_8601_FORMATTER);
		final String date = sdf.format(calendar.getTime());
		return date;
	}

	public static String getParameterValue(final Map<String, String[]> params, final String key, final boolean fToLower)
	{
		return getParameterValue(params, key, null, fToLower);
	}

	public static String getParameterValue(final Map<String, String[]> params, final String key, final String defaultValue)
	{
		return getParameterValue(params, key, defaultValue, false);
	}

	public static String getParameterValue(final Map<String, String[]> params, final String key)
	{
		return getParameterValue(params, key, false);
	}

	public static Map<String, String[]> mapKeysToLowerCase(final Map<String, String[]> parameterMap)
	{
		if (parameterMap == null)
		{
			return null;
		}

		final Map<String, String[]> params = new HashMap<String, String[]>();
		parameterMap.entrySet();
		for (final Entry<?, ?> param : parameterMap.entrySet())
		{
			final String key = ((String) param.getKey()).toLowerCase();
			params.put(key, (String[]) param.getValue());
		}

		return params;
	}

	/**
	 * Converts string value to double value.
	 *
	 * @param value
	 * @param defaultValue
	 * @return double value converted from sting, defaultValue in case of any exceptions.
	 */
	public static double toDouble(final String value, final double defaultValue)
	{
		double res;

		try
		{
			final DecimalFormat decimalFormat = new DecimalFormat();
			decimalFormat.setParseBigDecimal(true);
			res = ((BigDecimal) decimalFormat.parse(value)).doubleValue();
		}
		catch (final Exception e)
		{
		    LOG.error("Parsing to BigDecimal error, message: " + e.getMessage(), e);
			res = defaultValue;
		}

		return res;
	}

	/**
	 * Converts string value to double value.
	 *
	 * @param value
	 * @return double value converted from sting, Double.NaN in case of any exceptions.
	 */
	public static double toDouble(final String value)
	{
		return toDouble(value, Double.NaN);
	}

	/**
	 * Checks if value is any kind of "true".
	 *
	 * @param value
	 *           A value that should be checked.
	 * @return true if value can be treated as true, false othervise.
	 */
	public static boolean isTrue(String value)
	{
		value = value.toLowerCase();
		if (value == null || value.length() == 0 || "0".equals(value) || "false".equals(value) || "off".equals(value)
				|| "no".equals(value) || "n".equals(value))
		{
			return false;
		}
		else
		{
			return true;
		}
	}


	/**
	 * Format numeric parameter.
	 *
	 * @param params
	 * @param paramName
	 * @param defaultValue
	 * @return formatted double value as a String
	 */
	public static String formatNumParam(final Map<String, String[]> params, final String paramName, final double defaultValue)
	{
		final String strValue = PaypalStringUtils.getParameterValue(params, paramName);
		final double doubleValue = PaypalStringUtils.toDouble(strValue, defaultValue);

		return formatNumber(doubleValue);
	}

	public static String formatNumber(final BigDecimal totalAmount)
	{
		return formatNumber(totalAmount, DEFAULT_ROUND_DIGITS, ROUND_UP, DELTA);
	}


	/**
	 * @param totalAmount
	 * @return formatted BigDecimal number as String
	 */
	public static String formatNumber(final BigDecimal totalAmount, final int decDigits, final boolean roundUp, final double delta)
	{
		BigDecimal h = null;

		if (roundUp)
		{
			final BigDecimal hs = totalAmount.setScale(decDigits, RoundingMode.HALF_UP);
			final BigDecimal del = totalAmount.subtract(hs).abs();
			h = (del.compareTo(new BigDecimal(delta)) < 0) ? totalAmount.setScale(decDigits, RoundingMode.HALF_UP)
					: totalAmount.setScale(decDigits, RoundingMode.CEILING);
		}

		final String result = String.format(LOCALE, NUM_FORMAT, h);
		return result;
	}

	public static String formatNumber(final double number, final int decDigits, final boolean roundUp, final double delta)
	{
		if (Double.isNaN(number))
		{
			return null;
		}
		double h = number;
		if (roundUp)
		{
			final double shift = Math.pow(10, decDigits);
			h = number * shift;
			final double hs = Math.floor(h) / shift;
			final double del = Math.abs(number - hs);
			h = (del < delta) ? Math.floor(h) : Math.ceil(h);
			h = h / shift;
		}

		final String result = String.format(LOCALE, NUM_FORMAT, Double.valueOf(h));
		return result;
	}

	public static String formatNumber(final double number)
	{
		return formatNumber(number, DEFAULT_ROUND_DIGITS, ROUND_UP, DELTA);
	}

	/**
	 * Converts java object to JSON string. Uses Jackson internally, because this library is already in hybris.
	 *
	 * @param object
	 *           Object that need to be serialized
	 * @return Serialized JSON string or null if any errors occured
	 */
	public static String toJson(final Object object)
	{
		String jsonString = null;
		final ObjectMapper mapper = new ObjectMapper(new JsonFactory());
		try
		{
			jsonString = mapper.writeValueAsString(object);
		}
		catch (final JsonGenerationException e)
		{
		    LOG.error("Exception occurred, message: " + e.getMessage(), e);
		}
		catch (final JsonMappingException e)
		{
		    LOG.error("Exception occurred, message: " + e.getMessage(), e);
		}
		catch (final IOException e)
		{
		    LOG.error("Exception occurred, message: " + e.getMessage(), e);
		}

		return jsonString;
	}

	/**
	 * Creates new BigDecimal object from given string. Cleans thouthands separator before.
	 *
	 * @param stringValue
	 *           represents a value for new BigDecimal object
	 * @return new BigDecimal object from given String or null on any errors.
	 */
	public static BigDecimal toBigDecimal(final String stringValue)
	{
		BigDecimal newBigValue = null;

		try
		{
			final DecimalFormat decimalFormat = new DecimalFormat();
			decimalFormat.setParseBigDecimal(true);
			newBigValue = (BigDecimal) decimalFormat.parse(stringValue);
			if (LOG.isDebugEnabled())
			{
				LOG.debug("Converting to BigDecimal: " + stringValue + ", result: " + newBigValue);
			}
		}
		catch (final Exception e)
		{
			LOG.error("Parsing to BigDecimal error. Value was: " + stringValue, e);
		}

		return newBigValue;
	}

	public static List<String> getErrorMessagesList(final List<ErrorType> errorList)
	{
		final List<String> messagesList = new ArrayList<>();
		if (CollectionUtils.isNotEmpty(errorList))
		{
			for (final ErrorType error : errorList)
			{
				final StringBuilder errorMessageBuilder = new StringBuilder();
				errorMessageBuilder.append(error.getErrorCode()).append(PaypalConstants.ERROR_MESSAGE_CODE_SEPARATOR);
				errorMessageBuilder.append(error.getShortMessage()).append(PaypalConstants.ERROR_MESSAGE_SHORT_MESSAGE_SEPARATOR);
				errorMessageBuilder.append(error.getLongMessage());
				messagesList.add(errorMessageBuilder.toString());
			}
		}
		return messagesList;
	}

}
