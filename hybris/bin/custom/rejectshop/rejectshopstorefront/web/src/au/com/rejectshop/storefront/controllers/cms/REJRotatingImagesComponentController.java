/**
 * 
 */
package au.com.rejectshop.storefront.controllers.cms;

import de.hybris.platform.acceleratorstorefrontcommons.controllers.cms.AbstractCMSComponentController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import au.com.rejectshop.core.model.REJRotatingImagesComponentModel;
import au.com.rejectshop.facades.banners.REJResponsiveBannerComponentFacade;
import au.com.rejectshop.storefront.controllers.ControllerConstants;


/**
 * @author venkatapavani.t
 * 
 */
@Controller("REJRotatingImagesComponentController")
@RequestMapping(value = ControllerConstants.Actions.Cms.REJRotatingImagesComponent)
public class REJRotatingImagesComponentController extends AbstractCMSComponentController<REJRotatingImagesComponentModel>
{
	@Resource(name = "rejResponsiveBannerComponentFacade")
	private REJResponsiveBannerComponentFacade rejResponsiveBannerComponentFacade;

	/*
	 * Overridden method to fill the model for rotating banner.
	 * 
	 * @param request, model, component
	 */
	@Override
	protected void fillModel(final HttpServletRequest request, final Model model, final REJRotatingImagesComponentModel component)
	{
		model.addAttribute("rotatingBanners", rejResponsiveBannerComponentFacade.createRotatingBannerComponentData(component));
	}

	@Override
	protected String getView(final REJRotatingImagesComponentModel component)
	{

		return ControllerConstants.Views.Cms.ComponentPrefix + ControllerConstants.Views.Cms.RejRotatingImagesComponent;
	}
}
