/**
 *
 */
package au.com.rejectshop.cronjob.dao;

import de.hybris.platform.mediaconversion.model.ConversionGroupModel;


/**
 * @author Venkatapavani.t
 *
 */
public interface ConversionGroupDAO
{
	/**
	 * Returns the media conversion group.
	 *
	 * @param code
	 * @return ConversionGroupModel
	 */
	ConversionGroupModel getDefaultConversionGroup(String code);

}
