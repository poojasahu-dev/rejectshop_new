/**
 *
 */
package au.com.rejectshop.storefront.controllers.pages;

import au.com.rejectshop.storefront.controllers.ControllerConstants;
import de.hybris.platform.acceleratorstorefrontcommons.breadcrumb.impl.ContentPageBreadcrumbBuilder;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.cms2.model.pages.ContentPageModel;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;


/**
 * Controler for catalogue page
 * @author hkhurana
 *
 */
@Controller
@Scope("tenant")
public class CatalogueController extends AbstractPageController
{
	protected static final Logger LOG = Logger.getLogger(CatalogueController.class);

	private static final String FINANCIAL_REPORT_PAGE_LABEL = "/aboutus/investorinformation/financialreport";


//	@Resource(name = "contentPageBreadcrumbBuilder")
//	private ContentPageBreadcrumbBuilder contentPageBreadcrumbBuilder;

	@RequestMapping(value = "/catalogue",method = RequestMethod.GET)
	public String getCatalogue(final Model model) throws CMSItemNotFoundException
	{
		final ContentPageModel page = getContentPageForLabelOrId(FINANCIAL_REPORT_PAGE_LABEL);
		storeCmsPageInModel(model, page);
		return ControllerConstants.Views.Pages.Catalogue.catalogue;
	}


}
