/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2016 hybris AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 *
 *
 */
package au.com.rejectshop.storefront.controllers.pages;


import au.com.rejectshop.facades.promotion.price.PromotionDataPriceFacade;
import de.hybris.platform.acceleratorservices.controllers.page.PageType;
import de.hybris.platform.acceleratorservices.data.RequestContextData;
import de.hybris.platform.acceleratorstorefrontcommons.constants.WebConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.ThirdPartyConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractCategoryPageController;
import de.hybris.platform.acceleratorstorefrontcommons.util.MetaSanitizerUtil;
import de.hybris.platform.acceleratorstorefrontcommons.util.XSSFilterUtil;
import de.hybris.platform.category.model.CategoryModel;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.cms2.model.pages.CategoryPageModel;
import de.hybris.platform.cms2.servicelayer.services.CMSPageService;
import de.hybris.platform.commercefacades.product.data.CategoryData;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.commercefacades.search.data.SearchStateData;
import de.hybris.platform.commerceservices.search.facetdata.FacetData;
import de.hybris.platform.commerceservices.search.facetdata.FacetRefinement;
import de.hybris.platform.commerceservices.search.facetdata.ProductCategorySearchPageData;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.product.ProductService;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.servicelayer.i18n.CommonI18NService;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.List;


/**
 * Controller for a category page
 */
@Controller
@Scope("tenant")
@RequestMapping(value = "/**/cl")
public class CategoryListPageController extends AbstractCategoryPageController
{

	@Resource
	private ProductService productService;

	@Resource
	protected CommonI18NService commonI18NService;

	@Resource
	private PromotionDataPriceFacade promotionDataPriceFacade;

	@Resource(name = "cmsPageService")
	private CMSPageService cmsPageService;

	private static final Logger LOG = Logger.getLogger(CategoryListPageController.class);

	@RequestMapping(value = CATEGORY_CODE_PATH_VARIABLE_PATTERN, method = RequestMethod.GET)
	public String category(
			@PathVariable("categoryCode") final String categoryCode, // NOSONAR
			@RequestParam(value = "q", required = false) final String searchQuery,
			@RequestParam(value = "page", defaultValue = "0") final int page,
			@RequestParam(value = "show", defaultValue = "Page") final ShowMode showMode,
			@RequestParam(value = "sort", required = false) final String sortCode, final Model model,
			final HttpServletRequest request, final HttpServletResponse response) throws UnsupportedEncodingException
	{
		return performSearchAndGetResultsPage(categoryCode, searchQuery, page, showMode, sortCode, model, request, response);
	}



	@Override
	protected String performSearchAndGetResultsPage(final String categoryCode, final String searchQuery,
			final int page, // NOSONAR
			final ShowMode showMode, final String sortCode, final Model model, final HttpServletRequest request,
			final HttpServletResponse response) throws UnsupportedEncodingException
	{
		final CategoryModel category = getCommerceCategoryService().getCategoryForCode(categoryCode);

		LOG.info("rediret url "+getCategoryModelUrlResolver().resolve(category));
		final String redirection = checkRequestUrl(request, response, getCategoryModelUrlResolver().resolve(category));
		/*if (StringUtils.isNotEmpty(redirection))
		{
			return redirection;
		}*/

		CategoryPageModel categoryPage = getCategoryPage(category);
		try {
			categoryPage= (CategoryPageModel) cmsPageService.getPageById("categoryListPage");
		} catch (CMSItemNotFoundException e) {
			e.printStackTrace();
		}


		final CategorySearchEvaluator categorySearch = new CategorySearchEvaluator(categoryCode, XSSFilterUtil.filter(searchQuery),
				page, showMode, sortCode, categoryPage);

		LOG.info("query val---"+XSSFilterUtil.filter(searchQuery));

		ProductCategorySearchPageData<SearchStateData, ProductData, CategoryData> searchPageData = null;
		try
		{
			categorySearch.doSearch();
			searchPageData = categorySearch.getSearchPageData();
		}
		catch (final ConversionException e) // NOSONAR
		{
			searchPageData = createEmptySearchResult(categoryCode);
		}

		boolean showCategoriesOnly = categorySearch.isShowCategoriesOnly();


		LOG.info("Show categoryonly"+showCategoriesOnly);
		showCategoriesOnly=true;
		storeCmsPageInModel(model, categorySearch.getCategoryPage());
		storeContinueUrl(request);

		populateModel(model, searchPageData, showMode);
		model.addAttribute(WebConstants.BREADCRUMBS_KEY, getSearchBreadcrumbBuilder().getBreadcrumbs(categoryCode, searchPageData));
		LOG.debug("CategoryPageController... search---"+categoryCode+"---"+searchPageData.getSubCategories());
		model.addAttribute("showCategoriesOnly", Boolean.valueOf(showCategoriesOnly));
		model.addAttribute("categoryName", category.getName());
		model.addAttribute("categoryParent",category.getSupercategories());
		model.addAttribute("categoryDesc",category.getDescription());
		if (category.getCategoryBanner() != null && category.getCategoryBanner().getMedia() != null)
		{
			model.addAttribute("basecategorybanner", category.getCategoryBanner().getMedia().getURL());

		}

		for (CategoryModel ob : category.getAllSupercategories()) {
			LOG.debug("supper category name" + ob.getName());
			LOG.debug("supper category name" + ob.getCode());
			if (!ob.getCode().equalsIgnoreCase("TRS")){
				model.addAttribute("superCategory",ob.getName());
			}
		}


		model.addAttribute("userLocation", getCustomerLocationService().getUserLocation());

		updatePageTitle(category, searchPageData.getBreadcrumbs(), model);

		final RequestContextData requestContextData = getRequestContextData(request);
		requestContextData.setCategory(category);
		requestContextData.setSearch(searchPageData);

		if (searchQuery != null)
		{
			model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_FOLLOW);
		}

		final String metaKeywords = MetaSanitizerUtil.sanitizeKeywords(category.getKeywords());
		final String metaDescription = MetaSanitizerUtil.sanitizeDescription(category.getDescription());
		setUpMetaData(model, metaKeywords, metaDescription);
		setupPricePromoData(searchPageData);
		LOG.info("categoryPage.getDefaultPage()-----"+categorySearch.getCategoryPage().getDefaultPage());
		LOG.info("page name"+categorySearch.getCategoryPage().getName());
		LOG.info("page name"+categorySearch.getCategoryPage().getUid());
		LOG.info("page name"+categorySearch.getCategoryPage().getItemtype());

		categorySearch.getCategoryPage().setDefaultPage(false);
		LOG.info("categoryPage.getDefaultPage()-----"+categorySearch.getCategoryPage().getDefaultPage());
		return getViewPage(categorySearch.getCategoryPage());

	}

	protected String getViewPage(final CategoryPageModel categoryPage)
	{
		LOG.info("inside CategoryListPageController---------");

		if (categoryPage != null)
		{
			LOG.info(categoryPage.getMasterTemplate().getName());
			LOG.info(categoryPage.getMasterTemplate().getUid());
			LOG.info(categoryPage.getMasterTemplate().getUid());
			String page =cmsPageService.getFrontendTemplateName(categoryPage.getMasterTemplate());
			LOG.info("-----page ----"+page);
			final String targetPage = getViewForPage(categoryPage);
			LOG.info("inside CategoryListPageController---------"+targetPage);
			if (targetPage != null && !targetPage.isEmpty())
			{
				return targetPage;
			}
		}
		 String PRODUCT_GRID_PAGE = "category/categoryPage";
		LOG.info("inside CategoryListPageController---------"+PRODUCT_GRID_PAGE+"----"+PAGE_ROOT);
		return PAGE_ROOT + PRODUCT_GRID_PAGE;
	}

	protected void setupPricePromoData(
			final ProductCategorySearchPageData<SearchStateData, ProductData, CategoryData> searchPageData)
	{
		final List<ProductData> listProductData = searchPageData.getResults();
		for (final ProductData productData : listProductData)
		{
			final ProductModel productModel = productService.getProductForCode(productData.getCode());
			promotionDataPriceFacade.setPricePromotionData(productData, productModel);
		}
	}

}