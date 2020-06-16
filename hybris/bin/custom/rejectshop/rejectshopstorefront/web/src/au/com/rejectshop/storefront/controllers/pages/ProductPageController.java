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

import de.hybris.platform.acceleratorfacades.futurestock.FutureStockFacade;
import de.hybris.platform.acceleratorservices.controllers.page.PageType;
import de.hybris.platform.acceleratorstorefrontcommons.breadcrumb.impl.ProductBreadcrumbBuilder;
import de.hybris.platform.acceleratorstorefrontcommons.constants.WebConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.acceleratorstorefrontcommons.forms.FutureStockForm;
import de.hybris.platform.acceleratorstorefrontcommons.forms.ReviewForm;
import de.hybris.platform.acceleratorstorefrontcommons.forms.validation.ReviewValidator;
import de.hybris.platform.acceleratorstorefrontcommons.util.MetaSanitizerUtil;
import de.hybris.platform.acceleratorstorefrontcommons.util.XSSFilterUtil;
import de.hybris.platform.acceleratorstorefrontcommons.variants.VariantSortStrategy;
import de.hybris.platform.catalog.model.KeywordModel;
import de.hybris.platform.category.model.CategoryModel;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.cms2.model.pages.AbstractPageModel;
import de.hybris.platform.cms2.servicelayer.services.CMSPageService;
import de.hybris.platform.commercefacades.product.ProductFacade;
import de.hybris.platform.commercefacades.product.ProductOption;
import de.hybris.platform.commercefacades.product.data.BaseOptionData;
import de.hybris.platform.commercefacades.product.data.CategoryData;
import de.hybris.platform.commercefacades.product.data.FutureStockData;
import de.hybris.platform.commercefacades.product.data.ImageData;
import de.hybris.platform.commercefacades.product.data.ImageDataType;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.commercefacades.product.data.ReviewData;
import de.hybris.platform.commerceservices.url.UrlResolver;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.product.ProductService;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;
import de.hybris.platform.servicelayer.i18n.CommonI18NService;
import de.hybris.platform.servicelayer.session.SessionService;
import de.hybris.platform.util.Config;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.common.collect.Maps;

import au.com.rejectshop.facades.promotion.price.PromotionDataPriceFacade;
import au.com.rejectshop.storefront.controllers.ControllerConstants;
import au.com.rejectshop.storefront.forms.SendAFriendForm;
import au.com.rejectshop.storefront.forms.SendReminderForm;
import au.com.rejectshop.storefront.util.BrontoTokenManager;


/**
 * Controller for product details page
 */
@Controller
@Scope("tenant")
@RequestMapping(value = "/**/p")
public class ProductPageController extends AbstractPageController
{
	/**
	 *
	 */
	private static final String FROM = "FROM";

	/**
	 *
	 */
	private static final String PRODUCT = "product";

	@SuppressWarnings("unused")
	private static final Logger LOG = Logger.getLogger(ProductPageController.class);

	/**
	 * We use this suffix pattern because of an issue with Spring 3.1 where a Uri value is incorrectly extracted if it
	 * contains on or more '.' characters. Please see https://jira.springsource.org/browse/SPR-6164 for a discussion on
	 * the issue and future resolution.
	 */
	private static final String PRODUCT_CODE_PATH_VARIABLE_PATTERN = "/{productCode:.*}";
	private static final String REVIEWS_PATH_VARIABLE_PATTERN = "{numberOfReviews:.*}";

	private static final String FUTURE_STOCK_ENABLED = "storefront.products.futurestock.enabled";
	private static final String STOCK_SERVICE_UNAVAILABLE = "basket.page.viewFuture.unavailable";
	private static final String NOT_MULTISKU_ITEM_ERROR = "basket.page.viewFuture.not.multisku";

	@Resource(name = "productDataUrlResolver")
	private UrlResolver<ProductData> productDataUrlResolver;

	@Resource(name = "accProductFacade")
	private ProductFacade productFacade;

	@Resource(name = "productService")
	private ProductService productService;

	@Resource(name = "productBreadcrumbBuilder")
	private ProductBreadcrumbBuilder productBreadcrumbBuilder;

	@Resource(name = "cmsPageService")
	private CMSPageService cmsPageService;

	@Resource(name = "variantSortStrategy")
	private VariantSortStrategy variantSortStrategy;

	@Resource(name = "reviewValidator")
	private ReviewValidator reviewValidator;

	@Resource(name = "futureStockFacade")
	private FutureStockFacade futureStockFacade;

	@Resource(name = "sessionService")
	private SessionService sessionService;

	@Resource
	protected CommonI18NService commonI18NService;

	@Resource
	private PromotionDataPriceFacade promotionDataPriceFacade;


	@RequestMapping(value = PRODUCT_CODE_PATH_VARIABLE_PATTERN, method = RequestMethod.GET)
	public String productDetail(@PathVariable("productCode") final String productCode, final Model model,
			final HttpServletRequest request, final HttpServletResponse response)
			throws CMSItemNotFoundException, UnsupportedEncodingException
	{
		final List<ProductOption> extraOptions = Arrays.asList(ProductOption.VARIANT_MATRIX_BASE, ProductOption.VARIANT_MATRIX_URL,
				ProductOption.VARIANT_MATRIX_MEDIA, ProductOption.DESCRIPTION, ProductOption.KEYWORDS, ProductOption.METADESCRIPTION,ProductOption.PRODUCTINDICATOR);

		final ProductData productData = productFacade.getProductForCodeAndOptions(productCode, extraOptions);

		final String redirection = checkRequestUrl(request, response, productDataUrlResolver.resolve(productData));
		if (StringUtils.isNotEmpty(redirection))
		{
			return redirection;
		}

		updatePageTitle(productCode, model);

		LOG.debug("Product Indicator vlaue ---"+productData.getProductIndicator());
		populateProductDetailForDisplay(productCode, model, request, extraOptions);
		final SendAFriendForm formWitProduct = new SendAFriendForm();
		final SendReminderForm formWitProductrem = new SendReminderForm();
		formWitProductrem.setProductUrl(request.getRequestURL().toString());
		formWitProductrem.setProductName(productData.getName());
		formWitProductrem.setProductCode(productData.getCode());
		formWitProductrem.setBrontoToken(BrontoTokenManager.getTokenForSession(request.getSession()));
		final Collection<ImageData> productreminderImages = productData.getImages();
		if (productreminderImages != null)
		{
			for (final Iterator iterator = productreminderImages.iterator(); iterator.hasNext();)
			{
				final ImageData imageData = (ImageData) iterator.next();
				if (PRODUCT.equalsIgnoreCase(imageData.getFormat()))
				{
					formWitProductrem.setProductImageUrl(imageData.getUrl());
				}
			}
		}
		if (productData.getPrice() != null)
		{
			if (FROM.equals(productData.getPrice().getPriceType().name()))
			{
				formWitProductrem.setProductPrice(productData.getPrice().getFormattedValue());
			}
		}
		formWitProduct.setProductUrl(request.getRequestURL().toString());
		formWitProduct.setProductName(productData.getName());
		formWitProduct.setProductCode(productData.getCode());
		formWitProduct.setBrontoToken(BrontoTokenManager.getTokenForSession(request.getSession()));
		final Collection<ImageData> productImages = productData.getImages();
		if (productImages != null)
		{
			for (final Iterator iterator = productImages.iterator(); iterator.hasNext();)
			{
				final ImageData imageData = (ImageData) iterator.next();
				if (PRODUCT.equalsIgnoreCase(imageData.getFormat()))
				{
					formWitProduct.setProductImageUrl(imageData.getUrl());
				}
			}
		}
		if (productData.getPrice() != null)
		{
			if (FROM.equals(productData.getPrice().getPriceType().name()))
			{
				formWitProduct.setProductPrice(productData.getPrice().getFormattedValue());
			}
		}
		model.addAttribute(new ReviewForm());
		model.addAttribute("pageType", PageType.PRODUCT.name());
		model.addAttribute("categories", productData.getCategories());
		LOG.debug("product categories------" + productData.getCategories());
		model.addAttribute("futureStockEnabled", Boolean.valueOf(Config.getBoolean(FUTURE_STOCK_ENABLED, false)));
		/* model.addAttribute("CSRFToken", CSRFTokenManager.getTokenForSession(request.getSession())); */
		getSessionService().setAttribute("productUrlPPC", request.getRequestURL());
		model.addAttribute("sendAFriendForm", formWitProduct);
		model.addAttribute("sendReminderForm", formWitProductrem);

		if (productData.getCategories() != null)
		{
			for (final CategoryData ob : productData.getCategories())
			{
				LOG.debug("supper category name" + ob.getName());
				LOG.debug("supper category name" + ob.getCode());
				if (!ob.getCode().equalsIgnoreCase("TRS"))
				{
					model.addAttribute("superCategory", ob.getName());
				}
			}
		}
		LOG.debug("proeuct keywords----" + productData.getDescription());
		LOG.debug("proeuct keywords----" + productData.getName());
		LOG.debug("product desc-----" + productData.getSummary());

		String metaKeywords = MetaSanitizerUtil.sanitizeKeywords(productData.getKeywords());
		String metaDescription = MetaSanitizerUtil.sanitizeDescription(productData.getMetaDescription());
		if (metaDescription == null || metaDescription.equalsIgnoreCase(""))
		{
			metaDescription = productData.getName();
		}
		if (metaKeywords == null || metaKeywords.equalsIgnoreCase(""))
		{
			metaKeywords = productData.getName();
		}
		LOG.debug("metaKeywords-------" + metaKeywords);

		LOG.debug("metaDesc----" + metaDescription);
		setUpMetaData(model, metaKeywords, metaDescription);
		return getViewForPage(model);
	}

	@RequestMapping(value = PRODUCT_CODE_PATH_VARIABLE_PATTERN + "/orderForm", method = RequestMethod.GET)
	public String productOrderForm(@PathVariable("productCode") final String productCode, final Model model,
			final HttpServletRequest request, final HttpServletResponse response) throws CMSItemNotFoundException
	{
		final List<ProductOption> extraOptions = Arrays.asList(ProductOption.VARIANT_MATRIX_BASE,
				ProductOption.VARIANT_MATRIX_PRICE, ProductOption.VARIANT_MATRIX_MEDIA, ProductOption.VARIANT_MATRIX_STOCK,
				ProductOption.URL);

		final ProductData productData = productFacade.getProductForCodeAndOptions(productCode, extraOptions);
		updatePageTitle(productCode, model);

		populateProductDetailForDisplay(productCode, model, request, extraOptions);

		if (!model.containsAttribute(WebConstants.MULTI_DIMENSIONAL_PRODUCT))
		{
			return REDIRECT_PREFIX + productDataUrlResolver.resolve(productData);
		}

		return ControllerConstants.Views.Pages.Product.OrderForm;
	}

	@RequestMapping(value = PRODUCT_CODE_PATH_VARIABLE_PATTERN + "/zoomImages", method = RequestMethod.GET)
	public String showZoomImages(@PathVariable("productCode") final String productCode,
			@RequestParam(value = "galleryPosition", required = false) final String galleryPosition, final Model model)
	{
		final ProductData productData = productFacade.getProductForCodeAndOptions(productCode,
				Collections.singleton(ProductOption.GALLERY));
		final List<Map<String, ImageData>> images = getGalleryImages(productData);
		populateProductData(productData, model);
		if (galleryPosition != null)
		{
			try
			{
				model.addAttribute("zoomImageUrl", images.get(Integer.parseInt(galleryPosition)).get("zoom").getUrl());
			}
			catch (final IndexOutOfBoundsException | NumberFormatException ex)
			{
				if (LOG.isDebugEnabled())
				{
					LOG.debug(ex);
				}
				model.addAttribute("zoomImageUrl", "");
			}
		}
		return ControllerConstants.Views.Fragments.Product.ZoomImagesPopup;
	}

	@RequestMapping(value = PRODUCT_CODE_PATH_VARIABLE_PATTERN + "/quickView", method = RequestMethod.GET)
	public String showQuickView(@PathVariable("productCode") final String productCode, final Model model,
			final HttpServletRequest request)
	{
		final ProductModel productModel = productService.getProductForCode(productCode);
		final ProductData productData = productFacade.getProductForCodeAndOptions(productCode,
				Arrays.asList(ProductOption.BASIC, ProductOption.PRICE, ProductOption.SUMMARY, ProductOption.DESCRIPTION,
						ProductOption.CATEGORIES, ProductOption.PROMOTIONS, ProductOption.STOCK, ProductOption.REVIEW,
						ProductOption.VARIANT_FULL, ProductOption.DELIVERY_MODE_AVAILABILITY));

		sortVariantOptionData(productData);
		populateProductData(productData, model);
		getRequestContextData(request).setProduct(productModel);

		return ControllerConstants.Views.Fragments.Product.QuickViewPopup;
	}

	@RequestMapping(value = PRODUCT_CODE_PATH_VARIABLE_PATTERN + "/review", method =
	{ RequestMethod.GET, RequestMethod.POST })
	public String postReview(@PathVariable final String productCode, final ReviewForm form, final BindingResult result,
			final Model model, final HttpServletRequest request, final RedirectAttributes redirectAttrs)
			throws CMSItemNotFoundException
	{
		getReviewValidator().validate(form, result);

		final ProductData productData = productFacade.getProductForCodeAndOptions(productCode, null);
		if (result.hasErrors())
		{
			updatePageTitle(productCode, model);
			GlobalMessages.addErrorMessage(model, "review.general.error");
			model.addAttribute("showReviewForm", Boolean.TRUE);
			model.addAttribute("sendAFriendForm", new SendAFriendForm());
			model.addAttribute("sendReminderForm", new SendReminderForm());
			populateProductDetailForDisplay(productCode, model, request, Collections.emptyList());
			storeCmsPageInModel(model, getPageForProduct(productCode));
			model.addAttribute("pageType", PageType.PRODUCTREVIEWVALIDATE.name());
			return getViewForPage(model);
		}

		final ReviewData review = new ReviewData();
		review.setHeadline(XSSFilterUtil.filter(form.getHeadline()));
		review.setComment(XSSFilterUtil.filter(form.getComment()));
		review.setRating(form.getRating());
		review.setAlias(XSSFilterUtil.filter(form.getAlias()));
		productFacade.postReview(productCode, review);
		GlobalMessages.addFlashMessage(redirectAttrs, GlobalMessages.CONF_MESSAGES_HOLDER, "review.confirmation.thank.you.title");
		model.addAttribute("pageType", PageType.PRODUCTREVIEWSUBMIT.name());
		return REDIRECT_PREFIX + productDataUrlResolver.resolve(productData);
	}


	@RequestMapping(value = PRODUCT_CODE_PATH_VARIABLE_PATTERN + "/image", method = RequestMethod.GET)
	public String productImage(@PathVariable("productCode") final String productCode, final HttpServletRequest request,
			final HttpServletResponse response) throws IOException
	{

		final List<ProductOption> options = new ArrayList<ProductOption>(Arrays.asList(ProductOption.BASIC, ProductOption.GALLERY));

		final ProductData productData = productFacade.getProductForCodeAndOptions(productCode, options);

		String imagePath = StringUtils.EMPTY;

		for (final ImageData imageData : productData.getImages())
		{
			if (PRODUCT.equalsIgnoreCase(imageData.getFormat()))
			{
				imagePath = imageData.getUrl();
			}
		}

		LOG.info("Image Path" + imagePath);
		/*
		 * if (StringUtils.isNotEmpty(imagePath)) { response.setContentType("image/jpeg"); final File file = new
		 * File(Config.getParameter("rejectshop.website.host") + imagePath); final BufferedImage bi = ImageIO.read(file);
		 * final OutputStream out = response.getOutputStream(); ImageIO.write(bi, "jpg", out); }
		 */
		return REDIRECT_PREFIX + imagePath;
	}



	@RequestMapping(value = PRODUCT_CODE_PATH_VARIABLE_PATTERN + "/reviewhtml/"
			+ REVIEWS_PATH_VARIABLE_PATTERN, method = RequestMethod.GET)
	public String reviewHtml(@PathVariable("productCode") final String productCode,
			@PathVariable("numberOfReviews") final String numberOfReviews, final Model model, final HttpServletRequest request)
	{
		final ProductModel productModel = productService.getProductForCode(productCode);
		final List<ReviewData> reviews;
		final ProductData productData = productFacade.getProductForCodeAndOptions(productCode,
				Arrays.asList(ProductOption.BASIC, ProductOption.REVIEW));

		if ("all".equals(numberOfReviews))
		{
			reviews = productFacade.getReviews(productCode);
		}
		else
		{
			final int reviewCount = Math.min(Integer.parseInt(numberOfReviews),
					productData.getNumberOfReviews() == null ? 0 : productData.getNumberOfReviews().intValue());
			reviews = productFacade.getReviews(productCode, Integer.valueOf(reviewCount));
		}

		getRequestContextData(request).setProduct(productModel);
		model.addAttribute("reviews", reviews);
		model.addAttribute("reviewsTotal", productData.getNumberOfReviews());
		model.addAttribute(new ReviewForm());

		return ControllerConstants.Views.Fragments.Product.ReviewsTab;
	}

	@RequestMapping(value = PRODUCT_CODE_PATH_VARIABLE_PATTERN + "/writeReview", method = RequestMethod.GET)
	public String writeReview(@PathVariable final String productCode, final Model model) throws CMSItemNotFoundException
	{
		model.addAttribute(new ReviewForm());
		setUpReviewPage(model, productCode);
		return ControllerConstants.Views.Pages.Product.WriteReview;
	}

	protected void setUpReviewPage(final Model model, final String productCode) throws CMSItemNotFoundException
	{
		final ProductData productData = productFacade.getProductForCodeAndOptions(productCode, null);
		final String metaKeywords = MetaSanitizerUtil.sanitizeKeywords(productData.getKeywords());
		final String metaDescription = MetaSanitizerUtil.sanitizeDescription(productData.getDescription());
		setUpMetaData(model, metaKeywords, metaDescription);
		storeCmsPageInModel(model, getPageForProduct(productCode));
		model.addAttribute(PRODUCT, productFacade.getProductForCodeAndOptions(productCode, Arrays.asList(ProductOption.BASIC)));
		updatePageTitle(productCode, model);
	}

	@RequestMapping(value = PRODUCT_CODE_PATH_VARIABLE_PATTERN + "/writeReview", method = RequestMethod.POST)
	public String writeReview(@PathVariable final String productCode, final ReviewForm form, final BindingResult result,
			final Model model, final HttpServletRequest request, final RedirectAttributes redirectAttrs)
			throws CMSItemNotFoundException
	{
		getReviewValidator().validate(form, result);

		final ProductData productData = productFacade.getProductForCodeAndOptions(productCode, null);

		if (result.hasErrors())
		{
			GlobalMessages.addErrorMessage(model, "review.general.error");
			populateProductDetailForDisplay(productCode, model, request, Collections.emptyList());
			setUpReviewPage(model, productCode);
			return ControllerConstants.Views.Pages.Product.WriteReview;
		}

		final ReviewData review = new ReviewData();
		review.setHeadline(XSSFilterUtil.filter(form.getHeadline()));
		review.setComment(XSSFilterUtil.filter(form.getComment()));
		review.setRating(form.getRating());
		review.setAlias(XSSFilterUtil.filter(form.getAlias()));
		productFacade.postReview(productCode, review);
		GlobalMessages.addFlashMessage(redirectAttrs, GlobalMessages.CONF_MESSAGES_HOLDER, "review.confirmation.thank.you.title");

		return REDIRECT_PREFIX + productDataUrlResolver.resolve(productData);
	}

	@RequestMapping(value = PRODUCT_CODE_PATH_VARIABLE_PATTERN + "/futureStock", method = RequestMethod.GET)
	public String productFutureStock(@PathVariable("productCode") final String productCode, final Model model,
			final HttpServletRequest request, final HttpServletResponse response) throws CMSItemNotFoundException
	{
		final boolean futureStockEnabled = Config.getBoolean(FUTURE_STOCK_ENABLED, false);
		if (futureStockEnabled)
		{
			final List<FutureStockData> futureStockList = futureStockFacade.getFutureAvailability(productCode);
			if (futureStockList == null)
			{
				GlobalMessages.addErrorMessage(model, STOCK_SERVICE_UNAVAILABLE);
			}
			else if (futureStockList.isEmpty())
			{
				GlobalMessages.addInfoMessage(model, "product.product.details.future.nostock");
			}

			populateProductDetailForDisplay(productCode, model, request, Collections.emptyList());
			model.addAttribute("futureStocks", futureStockList);

			return ControllerConstants.Views.Fragments.Product.FutureStockPopup;
		}
		else
		{
			return ControllerConstants.Views.Pages.Error.ErrorNotFoundPage;
		}
	}

	@ResponseBody
	@RequestMapping(value = PRODUCT_CODE_PATH_VARIABLE_PATTERN + "/grid/skusFutureStock", method =
	{ RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_VALUE)
	public final Map<String, Object> productSkusFutureStock(final FutureStockForm form, final Model model)
	{
		final String productCode = form.getProductCode();
		final List<String> skus = form.getSkus();
		final boolean futureStockEnabled = Config.getBoolean(FUTURE_STOCK_ENABLED, false);

		Map<String, Object> result = new HashMap<>();
		if (futureStockEnabled && CollectionUtils.isNotEmpty(skus) && StringUtils.isNotBlank(productCode))
		{
			final Map<String, List<FutureStockData>> futureStockData = futureStockFacade
					.getFutureAvailabilityForSelectedVariants(productCode, skus);

			if (futureStockData == null)
			{
				// future availability service is down, we show this to the user
				result = Maps.newHashMap();
				final String errorMessage = getMessageSource().getMessage(NOT_MULTISKU_ITEM_ERROR, null,
						getI18nService().getCurrentLocale());
				result.put(NOT_MULTISKU_ITEM_ERROR, errorMessage);
			}
			else
			{
				for (final Map.Entry<String, List<FutureStockData>> entry : futureStockData.entrySet())
				{
					result.put(entry.getKey(), entry.getValue());
				}
			}
		}
		return result;
	}

	@ExceptionHandler(UnknownIdentifierException.class)
	public String handleUnknownIdentifierException(final UnknownIdentifierException exception, final HttpServletRequest request)
	{
		request.setAttribute("message", exception.getMessage());
		return FORWARD_PREFIX + "/404";
	}

	protected void updatePageTitle(final String productCode, final Model model)
	{
		storeContentPageTitleInModel(model, getPageTitleResolver().resolveProductPageTitle(productCode));
	}

	protected void populateProductDetailForDisplay(final String productCode, final Model model, final HttpServletRequest request,
			final List<ProductOption> extraOptions) throws CMSItemNotFoundException
	{
		final ProductModel productModel = productService.getProductForCode(productCode);

		for (final CategoryModel obj : productModel.getSupercategories()) {
			LOG.debug("Product category ---" + obj.getCode() + "---" + obj.getName());
			if (!obj.getCode().toLowerCase().contains("landed")) {
				model.addAttribute("productCategory", obj);
				for (final CategoryModel sup : obj.getAllSupercategories()) {
					LOG.debug("Super category--" + sup.getCode());
					LOG.debug("Super category--" + sup.getName());
					if (!sup.getCode().equalsIgnoreCase("TRS")) {
						model.addAttribute("superCategory", sup);
					}
				}
			}
		}
		String metaKeywords = "";
		final String metaDescription = productModel.getMetaDescription();
		LOG.debug(productModel.getKeywords());
		LOG.debug(productModel.getMetaDescription());
		for (final KeywordModel keywordModel : productModel.getKeywords())
		{
			metaKeywords += keywordModel.getKeyword();
		}

		getRequestContextData(request).setProduct(productModel);

		final List<ProductOption> options = new ArrayList<>(Arrays.asList(ProductOption.VARIANT_FIRST_VARIANT, ProductOption.BASIC,
				ProductOption.URL, ProductOption.PRICE, ProductOption.SUMMARY, ProductOption.DESCRIPTION, ProductOption.GALLERY,
				ProductOption.CATEGORIES, ProductOption.REVIEW, ProductOption.PROMOTIONS, ProductOption.CLASSIFICATION,
				ProductOption.VARIANT_FULL, ProductOption.STOCK, ProductOption.VOLUME_PRICES, ProductOption.PRICE_RANGE,
				ProductOption.DELIVERY_MODE_AVAILABILITY, ProductOption.METADESCRIPTION,ProductOption.PRODUCTINDICATOR));

		options.addAll(extraOptions);

		final ProductData productData = productFacade.getProductForCodeAndOptions(productCode, options);
		LOG.debug("productdate.productindicator---"+productData.getProductIndicator());
		promotionDataPriceFacade.setPricePromotionData(productData, productModel);
		sortVariantOptionData(productData);
		storeCmsPageInModel(model, getPageForProduct(productCode));
		populateProductData(productData, model);

		model.addAttribute(WebConstants.BREADCRUMBS_KEY, productBreadcrumbBuilder.getBreadcrumbs(productCode));
		setUpMetaData(model, metaKeywords, metaDescription);

		if (CollectionUtils.isNotEmpty(productData.getVariantMatrix()))
		{
			model.addAttribute(WebConstants.MULTI_DIMENSIONAL_PRODUCT,
					Boolean.valueOf(CollectionUtils.isNotEmpty(productData.getVariantMatrix())));
		}
	}

	/**
	 * @param productData
	 * @param productModel
	 */

	protected void populateProductData(final ProductData productData, final Model model)
	{
		model.addAttribute("galleryImages", getGalleryImages(productData));
		model.addAttribute(PRODUCT, productData);
	}

	protected void sortVariantOptionData(final ProductData productData)
	{
		if (CollectionUtils.isNotEmpty(productData.getBaseOptions()))
		{
			for (final BaseOptionData baseOptionData : productData.getBaseOptions())
			{
				if (CollectionUtils.isNotEmpty(baseOptionData.getOptions()))
				{
					Collections.sort(baseOptionData.getOptions(), variantSortStrategy);
				}
			}
		}

		if (CollectionUtils.isNotEmpty(productData.getVariantOptions()))
		{
			Collections.sort(productData.getVariantOptions(), variantSortStrategy);
		}
	}

	protected List<Map<String, ImageData>> getGalleryImages(final ProductData productData)
	{
		final List<Map<String, ImageData>> galleryImages = new ArrayList<>();
		if (CollectionUtils.isNotEmpty(productData.getImages()))
		{
			final List<ImageData> images = new ArrayList<>();
			for (final ImageData image : productData.getImages())
			{
				if (ImageDataType.GALLERY.equals(image.getImageType()))
				{
					images.add(image);
				}
			}
			Collections.sort(images, new Comparator<ImageData>()
			{
				@Override
				public int compare(final ImageData image1, final ImageData image2)
				{
					return image1.getGalleryIndex().compareTo(image2.getGalleryIndex());
				}
			});

			if (CollectionUtils.isNotEmpty(images))
			{
				addFormatsToGalleryImages(galleryImages, images);
			}
		}
		return galleryImages;
	}

	protected void addFormatsToGalleryImages(final List<Map<String, ImageData>> galleryImages, final List<ImageData> images)
	{
		int currentIndex = images.get(0).getGalleryIndex().intValue();
		Map<String, ImageData> formats = new HashMap<String, ImageData>();
		for (final ImageData image : images)
		{
			if (currentIndex != image.getGalleryIndex().intValue())
			{
				galleryImages.add(formats);
				formats = new HashMap<>();
				currentIndex = image.getGalleryIndex().intValue();
			}
			formats.put(image.getFormat(), image);
		}
		if (!formats.isEmpty())
		{
			galleryImages.add(formats);
		}
	}

	protected ReviewValidator getReviewValidator()
	{
		return reviewValidator;
	}



	protected AbstractPageModel getPageForProduct(final String productCode) throws CMSItemNotFoundException
	{
		final ProductModel productModel = productService.getProductForCode(productCode);
		return cmsPageService.getPageForProduct(productModel);
	}

	/**
	 * @return the sessionService
	 */
	@Override
	public SessionService getSessionService()
	{
		return sessionService;
	}

	/**
	 * @param sessionService
	 *           the sessionService to set
	 */
	public void setSessionService(final SessionService sessionService)
	{
		this.sessionService = sessionService;
	}



}
