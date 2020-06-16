/**
 *
 */
package au.com.rejectshop.core.util;

/**
 * @author suryanarayana.d
 *
 */
public class RejectStringUtils
{

	public static String trimDoubleQuotes(final String input)
	{
		final int textLength = input.length();

		if (textLength >= 2 && input.charAt(0) == '"' && input.charAt(textLength - 1) == '"')
		{
			return input.substring(1, textLength - 1);
		}

		return input;
	}
}
