/**
 * 
 */
package au.com.rejectshop.facades.banners;

import java.util.List;

import au.com.rejectshop.core.model.REJRotatingImagesComponentModel;
import au.com.rejectshop.facades.component.data.REJRotatingComponentData;






/**
 * @author venkatapavani.t
 * 
 */
public interface REJResponsiveBannerComponentFacade
{
	List<REJRotatingComponentData> createRotatingBannerComponentData(REJRotatingImagesComponentModel component);
}
