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


import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractCategoryPageController;
import de.hybris.platform.acceleratorstorefrontcommons.util.XSSFilterUtil;
import de.hybris.platform.category.model.CategoryModel;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.cms2.model.pages.CategoryPageModel;
import de.hybris.platform.cms2.servicelayer.services.CMSPageService;
import de.hybris.platform.commercefacades.product.data.CategoryData;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.commercefacades.search.data.SearchStateData;
import de.hybris.platform.commerceservices.search.facetdata.ProductCategorySearchPageData;
import de.hybris.platform.converters.Converters;
import de.hybris.platform.core.HybrisEnumValue;
import de.hybris.platform.enumeration.EnumerationService;
import de.hybris.platform.product.ProductService;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.servicelayer.dto.converter.Converter;

import java.io.UnsupportedEncodingException;
import java.util.Comparator;
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

import au.com.rejectshop.core.enums.CategoryFilterEnum;
import au.com.rejectshop.storefront.controllers.ControllerConstants;



/**
 * Controller for a Category Filter page
 */
@Controller
@Scope("tenant")
@RequestMapping(value = "/**/savvyCategoryFilter")
public class CategoryFilterPageController extends AbstractCategoryPageController
{

	@Resource
	private ProductService productService;

	@Resource(name = "cmsPageService")
	private CMSPageService cmsPageService;

	@Resource(name = "enumerationService")
	private EnumerationService enumerationService;

	@Resource(name = "categoryConverter")
	private Converter<CategoryModel, CategoryData> categoryConverter;

	private static final Logger LOG = Logger.getLogger(CategoryFilterPageController.class);
	private static final String CATEGORY_FILTER_PAGE = "categoryFilterPage";
	private static final String DISPLAY_GIFT_FINDER_PAGE = "display.savvy.categoryFilter.flag";

	@RequestMapping(value = CATEGORY_CODE_PATH_VARIABLE_PATTERN, method = RequestMethod.GET)
	public String categoryFilter(@PathVariable("categoryCode")
	final String categoryCode, // NOSONAR
			@RequestParam(value = "q", required = false)
			final String searchQuery, @RequestParam(value = "subCategory", required = false, defaultValue = "")
			final String subCategory, @RequestParam(value = "page", defaultValue = "0")
			final int page, @RequestParam(value = "show", defaultValue = "Page")
			final ShowMode showMode, @RequestParam(value = "sort", required = false)
			final String sortCode, final HttpServletRequest request, final Model model, final HttpServletResponse response)
			throws UnsupportedEncodingException, CMSItemNotFoundException
	{

		final boolean display = getSiteConfigService().getBoolean(DISPLAY_GIFT_FINDER_PAGE, true);
		if (!display)
		{
			prepareNotFoundPage(model, response);
			return ControllerConstants.Views.Pages.Error.ErrorNotFoundPage;
		}
		return categoryFilterResults(categoryCode, subCategory, searchQuery, page, showMode, sortCode, model, request);
	}


	protected String categoryFilterResults(final String categoryCode, final String subCategory, final String searchQuery,
			final int page, // NOSONAR
			final ShowMode showMode, final String sortCode, final Model model, final HttpServletRequest request)
			throws UnsupportedEncodingException, CMSItemNotFoundException
	{
		String filterCategory = categoryCode;
		if (subCategory != null && !subCategory.equals(""))
		{
			filterCategory = subCategory;
		}
		final CategoryModel category = getCommerceCategoryService().getCategoryForCode(filterCategory);
		final String filterCategoryName = category.getName();

		final CategoryPageModel categoryPage = getCategoryPage(category);

		final CategorySearchEvaluator categorySearch = new CategorySearchEvaluator(filterCategory,
				XSSFilterUtil.filter(searchQuery), page, showMode, sortCode, categoryPage);

		LOG.info("query val---" + XSSFilterUtil.filter(searchQuery));

		ProductCategorySearchPageData<SearchStateData, ProductData, CategoryData> searchPageData = null;
		try
		{
			categorySearch.doSearch();
			searchPageData = categorySearch.getSearchPageData();
		}
		catch (final ConversionException e) // NOSONAR
		{
			searchPageData = createEmptySearchResult(filterCategory);
		}
		model.addAttribute("searchPageData", searchPageData);
		final List<HybrisEnumValue> categoryFilterEnumValues = enumerationService
				.getEnumerationValues(CategoryFilterEnum._TYPECODE);
		final CategoryModel parentCategory = getCommerceCategoryService().getCategoryForCode(categoryCode);
		if (parentCategory != null)
		{
			final List<CategoryData> decorationPrices = Converters.convertAll(parentCategory.getAllSubcategories(),
					categoryConverter);
			if (decorationPrices != null && decorationPrices.size() > 0)
			{
				decorationPrices.sort(Comparator.comparing(CategoryData::getCode));
			}
			model.addAttribute("decorationPrices", decorationPrices);
		}
		final String[] array = searchPageData.getCurrentQuery().getQuery().getValue().split("categoryFilter:");
		if (array.length > 1)
		{
			model.addAttribute("selectedCategoryFilter", array[1].split(":")[0]);
		}


		populateModel(model, searchPageData, showMode);
		model.addAttribute("categoryFilterEnumValues", categoryFilterEnumValues);
		model.addAttribute("selectedPrice", filterCategory);
		if (subCategory != null && !subCategory.equals(""))
		{
			model.addAttribute("selectedPriceName", filterCategoryName);
		}
		model.addAttribute("subCategory", subCategory);
		model.addAttribute("currentPageURL",
				getCurrentPageURL(request, searchPageData.getCurrentQuery().getQuery().getValue(), subCategory));
		storeCmsPageInModel(model, getContentPageForLabelOrId(CATEGORY_FILTER_PAGE));
		return getViewForPage(model);

	}


	/**
	 * @return
	 */
	private String getCurrentPageURL(final HttpServletRequest request, final String searchQuery, final String subCategory)
	{
		String url = request.getRequestURI() + "?";
		//		url += searchQuery;
		if (!StringUtils.isEmpty(subCategory))
		{
			url += "subCategory=" + subCategory + "&";
		}
		if (!StringUtils.isEmpty(searchQuery))
		{
			url += "q=" + searchQuery;
		}
		else
		{
			url += "q=%3Arelevance";
		}
		return url;
	}


}