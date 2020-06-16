/**
 * 
 */
package au.com.rejectshop.cronjob.service.impl;

import de.hybris.platform.core.model.media.MediaContainerModel;

import java.util.Comparator;

import org.apache.commons.lang.StringUtils;


/**
 * @author shaiknajeer.b
 * 
 */
public class MediaContainerComparator implements Comparator<MediaContainerModel>
{

	@Override
	public int compare(final MediaContainerModel mc1, final MediaContainerModel mc2)
	{
		return mc2.getQualifier().replace("-", StringUtils.EMPTY).compareTo(mc1.getQualifier().replace("-", StringUtils.EMPTY));
	}

}
