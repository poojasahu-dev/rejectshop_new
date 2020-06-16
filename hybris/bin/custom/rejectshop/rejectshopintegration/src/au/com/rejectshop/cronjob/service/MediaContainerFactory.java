/**
 *
 */
package au.com.rejectshop.cronjob.service;

/**
 * @author Subrahmanyam.n.t
 *
 */
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.core.model.media.MediaContainerModel;
import de.hybris.platform.mediaconversion.model.ConversionGroupModel;

import java.io.File;


/**
 * @spring.bean mediaContainerFactory
 */
public interface MediaContainerFactory
{

	/**
	 * Returns the media container with master media and remaining hybris supported format medias.
	 *
	 * @param imageFile
	 * @param conversionGroup
	 * @param catalogVersion
	 * @return MediaContainerModel
	 */
	MediaContainerModel createContainerAndConvertMedia(File imageFile, ConversionGroupModel conversionGroup,
			CatalogVersionModel catalogVersion);

}
