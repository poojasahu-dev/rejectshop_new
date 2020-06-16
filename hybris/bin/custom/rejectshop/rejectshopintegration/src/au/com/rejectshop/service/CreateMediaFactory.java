/**
 * 
 */
package au.com.rejectshop.service;

import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.core.model.media.MediaContainerModel;

import java.io.File;

/**
 * @author shaiknajeer.b
 *
 */
public interface CreateMediaFactory
{
	MediaContainerModel createContainerAddMedia(final File imageFile,final File fileToConvert30,final File fileToConvert65,final File fileToConvert300,final File fileToConvert515,final File fileToConvert1200, CatalogVersionModel catalogVersion);
}
