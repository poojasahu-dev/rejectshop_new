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

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import au.com.rejectshop.facades.promotion.price.PromotionDataPriceFacade;


/**
 * Controller for a category page
 */
@Controller
@Scope("tenant")
@RequestMapping(value = "/**/c")
public class CategoryPageController extends AbstractCategoryPageController
{

	@Resource
	private ProductService productService;

	@Resource
	protected CommonI18NService commonI18NService;

	@Resource
	private PromotionDataPriceFacade promotionDataPriceFacade;

	@Resource(name = "cmsPageService")
	private CMSPageService cmsPageService;

	private static final Logger LOG = Logger.getLogger(CategoryPageController.class);

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

	@ResponseBody
	@RequestMapping(value = CATEGORY_CODE_PATH_VARIABLE_PATTERN + "/facets", method = RequestMethod.GET)
	public FacetRefinement<SearchStateData> getFacets(@PathVariable("categoryCode") final String categoryCode,
			@RequestParam(value = "q", required = false) final String searchQuery,
			@RequestParam(value = "page", defaultValue = "0") final int page,
			@RequestParam(value = "show", defaultValue = "Page") final ShowMode showMode,
			@RequestParam(value = "sort", required = false) final String sortCode) throws UnsupportedEncodingException
	{
		return performSearchAndGetFacets(categoryCode, searchQuery, page, showMode, sortCode);
	}

	@ResponseBody
	@RequestMapping(value = CATEGORY_CODE_PATH_VARIABLE_PATTERN + "/results", method = RequestMethod.GET)
	public SearchResultsData<ProductData> getResults(@PathVariable("categoryCode") final String categoryCode,
			@RequestParam(value = "q", required = false) final String searchQuery,
			@RequestParam(value = "page", defaultValue = "0") final int page,
			@RequestParam(value = "show", defaultValue = "Page") final ShowMode showMode,
			@RequestParam(value = "sort", required = false) final String sortCode) throws UnsupportedEncodingException
	{

		return performSearchAndGetResultsData(categoryCode, searchQuery, page, showMode, sortCode);
	}



	@Override
	protected String performSearchAndGetResultsPage(final String categoryCode, final String searchQuery,
			final int page, // NOSONAR
			final ShowMode showMode, final String sortCode, final Model model, final HttpServletRequest request,
			final HttpServletResponse response) throws UnsupportedEncodingException
	{
		final CategoryModel category = getCommerceCategoryService().getCategoryForCode(categoryCode);


		final String redirection = checkRequestUrl(request, response, getCategoryModelUrlResolver().resolve(category));
		if (StringUtils.isNotEmpty(redirection))
		{
			return redirection;
		}

		CategoryPageModel categoryPage = getCategoryPage(category);
		/*try {
			categoryPage= (CategoryPageModel) cmsPageService.getPageById("category");
		} catch (CMSItemNotFoundException e) {
			e.printStackTrace();
		}*/


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

		final boolean showCategoriesOnly = categorySearch.isShowCategoriesOnly();


		LOG.info("Show categoryonly"+showCategoriesOnly);
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
		if (StringUtils.isNotEmpty(sortCode)){
				if (sortCode.equalsIgnoreCase("name-desc")){
					model.addAttribute("pageType",PageType.CATEGORYSORTBYNAMEDESC.name());
				}

			if (sortCode.equalsIgnoreCase("name-asc")){
				model.addAttribute("pageType",PageType.CATEGORYSORTBYNAMEASC.name());
			}
			if (sortCode.equalsIgnoreCase("price-asc")){
				model.addAttribute("pageType",PageType.CATEGORYSORTBYPRICELOWFIRST.name());
			}
			if (sortCode.equalsIgnoreCase("price-desc")){
				model.addAttribute("pageType",PageType.CATEGORYSORTBYPRICEHIGHFIRST.name());
			}
			if (sortCode.equalsIgnoreCase("topRated")){
				model.addAttribute("pageType",PageType.CATEGORYSORTBYTOPRATED.name());
			}
			if (sortCode.equalsIgnoreCase("relevance")){
				model.addAttribute("pageType",PageType.CATEGORYSORTBYRELEVANCE.name());
			}

		}else {
			model.addAttribute("pageType", PageType.CATEGORY.name());
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

	@Override
	protected FacetRefinement<SearchStateData> performSearchAndGetFacets(final String categoryCode, final String searchQuery,
			final int page, final ShowMode showMode, final String sortCode)
	{
		final ProductCategorySearchPageData<SearchStateData, ProductData, CategoryData> searchPageData = populateSearchPageData(
				categoryCode, searchQuery, page, showMode, sortCode);
		final List<FacetData<SearchStateData>> facets = refineFacets(searchPageData.getFacets(),
				convertBreadcrumbsToFacets(searchPageData.getBreadcrumbs()));
		final FacetRefinement<SearchStateData> refinement = new FacetRefinement<>();
		refinement.setFacets(facets);
		refinement.setCount(searchPageData.getPagination().getTotalNumberOfResults());
		refinement.setBreadcrumbs(searchPageData.getBreadcrumbs());
		setupPricePromoData(searchPageData);
		return refinement;
	}

	@Override
	protected SearchResultsData<ProductData> performSearchAndGetResultsData(final String categoryCode, final String searchQuery,
			final int page, final ShowMode showMode, final String sortCode)
	{
		final ProductCategorySearchPageData<SearchStateData, ProductData, CategoryData> searchPageData = populateSearchPageData(
				categoryCode, searchQuery, page, showMode, sortCode);
		final SearchResultsData<ProductData> searchResultsData = new SearchResultsData<>();
		searchResultsData.setResults(searchPageData.getResults());
		searchResultsData.setPagination(searchPageData.getPagination());
		setupPricePromoData(searchPageData);
		return searchResultsData;
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