/**
 * 
 */
package au.com.rejectshop.storefront.controllers.cms;

import de.hybris.platform.acceleratorcms.model.components.SimpleResponsiveBannerComponentModel;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import au.com.rejectshop.storefront.controllers.ControllerConstants;


/**
 * @author venkatapavani.t
 * 
 */
@Controller("REJSimpleResponsiveBannerComponentController")
@RequestMapping(value = ControllerConstants.Actions.Cms.REJSimpleResponsiveBannerComponent)
public class REJSimpleResponsiveComponentController extends SimpleResponsiveBannerComponentController
{


	@Override
	protected void fillModel(final HttpServletRequest request, final Model model,
			final SimpleResponsiveBannerComponentModel component)
	{
		super.fillModel(request, model, component);
	}

	@Override
	public String getView(final SimpleResponsiveBannerComponentModel component)
	{

		return ControllerConstants.Views.Cms.ComponentPrefix + ControllerConstants.Views.Cms.RejSimpleResponsiveBannerComponent;
	}

}
