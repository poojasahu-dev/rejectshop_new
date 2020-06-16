/**
 *
 */
package au.com.rejectshop.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.breadcrumb.impl.ContentPageBreadcrumbBuilder;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.cms2.model.pages.ContentPageModel;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import au.com.rejectshop.storefront.constants.WebConstants;



/**
 * @author hina1460
 *
 */
@Controller
@Scope("tenant")
@RequestMapping(value = "/aboutus/investorinformation/financialreport")
public class FinancialReportController extends AbstractPageController
{
	protected static final Logger LOG = Logger.getLogger(FinancialReportController.class);

	private static final String FINANCIAL_REPORT_PAGE_LABEL = "/aboutus/investorinformation/financialreport";

	private static final String SHOW_ARCHIVED = "showArchived";

	@Resource(name = "contentPageBreadcrumbBuilder")
	private ContentPageBreadcrumbBuilder contentPageBreadcrumbBuilder;

	@RequestMapping(method = RequestMethod.GET)
	public String getRecentFinancialReports(final Model model) throws CMSItemNotFoundException
	{
		final ContentPageModel page = getContentPageForLabelOrId(FINANCIAL_REPORT_PAGE_LABEL);
		storeCmsPageInModel(model, page);
		setUpMetaDataForContentPage(model, page);
		model.addAttribute(WebConstants.BREADCRUMBS_KEY, contentPageBreadcrumbBuilder.getBreadcrumbs(page));
		model.addAttribute(WebConstants.PAGE_LABEL, page.getLabel());
		model.addAttribute(SHOW_ARCHIVED, Boolean.FALSE);
		return getViewForPage(model);
	}

	@RequestMapping(value = "/archives", method = RequestMethod.GET)
	public String getArchivedFinancialReports(final Model model) throws CMSItemNotFoundException
	{
		final ContentPageModel page = getContentPageForLabelOrId(FINANCIAL_REPORT_PAGE_LABEL);
		storeCmsPageInModel(model, page);
		setUpMetaDataForContentPage(model, page);
		model.addAttribute(WebConstants.BREADCRUMBS_KEY, contentPageBreadcrumbBuilder.getBreadcrumbs(page));
		model.addAttribute(WebConstants.PAGE_LABEL, page.getLabel());
		model.addAttribute(SHOW_ARCHIVED, Boolean.TRUE);
		model.addAttribute(WebConstants.BREADCRUMBS_ADDITIONAL_LINK_KEY, "breadcrumb.financialreport.archives");
		model.addAttribute(WebConstants.BREADCRUMBS_ADDITIONAL_LINK_URL, FINANCIAL_REPORT_PAGE_LABEL + "/archives");
		return getViewForPage(model);
	}
}
