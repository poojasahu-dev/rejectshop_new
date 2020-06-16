package au.com.rejectshop.facades.banners.impl;

import de.hybris.platform.acceleratorfacades.device.ResponsiveMediaFacade;
import de.hybris.platform.cms2.model.restrictions.CMSTimeRestrictionModel;
import de.hybris.platform.commercefacades.product.data.ImageData;
import de.hybris.platform.commerceservices.i18n.CommerceCommonI18NService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;

import au.com.rejectshop.core.model.REJRotatingImagesComponentModel;
import au.com.rejectshop.core.model.REJSimpleResponsiveBannerComponentModel;
import au.com.rejectshop.facades.banners.REJResponsiveBannerComponentFacade;
import au.com.rejectshop.facades.component.data.REJRotatingComponentData;




/**
 * The Class DefaultREJResponsiveBannerComponentFacade.
 */
public class DefaultREJResponsiveBannerComponentFacade implements REJResponsiveBannerComponentFacade
{
	private static final Logger LOG = Logger.getLogger(DefaultREJResponsiveBannerComponentFacade.class);
	/** The responsive media facade. */
	@Resource(name = "responsiveMediaFacade")
	private ResponsiveMediaFacade responsiveMediaFacade;

	/** The commerce common I 18 N service. */
	@Resource(name = "commerceCommonI18NService")
	private CommerceCommonI18NService commerceCommonI18NService;

	CMSTimeRestrictionModel cMSTimeRestrictionModel;

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * au.com.rejectshop.facades.banners.REJResponsiveBannerComponentFacade#createRotatingBannerComponentData(au.com.
	 * rejectshop.core.model.REJRotatingImagesComponentModel)
	 */
	public List<REJRotatingComponentData> createRotatingBannerComponentData(final REJRotatingImagesComponentModel component)
	{
		List<REJSimpleResponsiveBannerComponentModel> rejSimpleResComModelList = new ArrayList<REJSimpleResponsiveBannerComponentModel>();
		final List<REJRotatingComponentData> response = new ArrayList<REJRotatingComponentData>();
		rejSimpleResComModelList = component.getResponsiveBanners();

		if (rejSimpleResComModelList != null && CollectionUtils.isNotEmpty(rejSimpleResComModelList))
		{
			for (final REJSimpleResponsiveBannerComponentModel comp : rejSimpleResComModelList)
			{
				if (comp.getVisible() != null && comp.getVisible().booleanValue())
				{
					final REJRotatingComponentData rejRotatingComponentData = new REJRotatingComponentData();
					final Map<String, ImageData> imageMap = new HashMap<String, ImageData>();
					final List<ImageData> imageDataList = responsiveMediaFacade
							.getImagesFromMediaContainer(comp.getMedia(commerceCommonI18NService.getCurrentLocale()));

					for (final ImageData imageData : imageDataList)
					{
						imageMap.put(imageData.getFormat(), imageData);

					}
					rejRotatingComponentData.setRestrictions(comp.getRestrictions());
					rejRotatingComponentData.setLinkUrl(comp.getUrlLink());
					rejRotatingComponentData.setImageMap(imageMap);
					rejRotatingComponentData.setOrder(comp.getOrder());

					response.add(rejRotatingComponentData);
				}
			}
		}
		return response;
	}

}
