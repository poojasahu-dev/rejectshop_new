/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2015 hybris AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 *
 *
 */
package au.com.rejectshop.storefront.controllers.misc;

import de.hybris.platform.acceleratorcms.model.components.MiniCartComponentModel;
import de.hybris.platform.acceleratorservices.controllers.page.PageType;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.AbstractController;
import de.hybris.platform.acceleratorstorefrontcommons.forms.UpdateQuantityForm;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.cms2.servicelayer.services.CMSComponentService;
import de.hybris.platform.commercefacades.order.CartFacade;
import de.hybris.platform.commercefacades.order.data.CartData;
import de.hybris.platform.commercefacades.order.data.OrderEntryData;
import de.hybris.platform.commercefacades.product.data.PriceData;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.product.ProductService;
import de.hybris.platform.servicelayer.i18n.CommonI18NService;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import au.com.rejectshop.facades.promotion.price.PromotionDataPriceFacade;
import au.com.rejectshop.storefront.controllers.ControllerConstants;


/**
 * Controller for MiniCart functionality which is not specific to a page.
 */
@Controller
@Scope("tenant")
public class MiniCartController extends AbstractController
{
	protected static final Logger LOG = Logger.getLogger(MiniCartController.class);
	/**
	 * We use this suffix pattern because of an issue with Spring 3.1 where a Uri value is incorrectly extracted if it
	 * contains on or more '.' characters. Please see https://jira.springsource.org/browse/SPR-6164 for a discussion on
	 * the issue and future resolution.
	 */
	private static final String TOTAL_DISPLAY_PATH_VARIABLE_PATTERN = "{totalDisplay:.*}";
	private static final String COMPONENT_UID_PATH_VARIABLE_PATTERN = "{componentUid:.*}";


	@Resource(name = "cartFacade")
	private CartFacade cartFacade;

	@Resource(name = "cmsComponentService")
	private CMSComponentService cmsComponentService;
	@Resource
	private PromotionDataPriceFacade promotionDataPriceFacade;

	@Resource
	private ProductService productService;

	@Resource
	private CommonI18NService commonI18NService;

	@RequestMapping(value = "/cart/miniCart/" + TOTAL_DISPLAY_PATH_VARIABLE_PATTERN, method = RequestMethod.GET)
	public String getMiniCart(@PathVariable final String totalDisplay, final Model model)
	{
		final CartData cartData = cartFacade.getMiniCart();
		if (null != cartData.getEntries())
		{
			final PriceData totalPriceCart = setPromoData(cartData);
			cartData.setTotalPrice(totalPriceCart);
		}
		model.addAttribute("totalPrice", cartData.getTotalPrice());
		model.addAttribute("subTotal", cartData.getSubTotal());
		if (cartData.getDeliveryCost() != null)
		{
			final PriceData withoutDelivery = cartData.getDeliveryCost();
			withoutDelivery.setValue(cartData.getTotalPrice().getValue().subtract(cartData.getDeliveryCost().getValue()));
			model.addAttribute("totalNoDelivery", withoutDelivery);
		}
		else
		{
			model.addAttribute("totalNoDelivery", cartData.getTotalPrice());
		}
		model.addAttribute("totalItems", cartData.getTotalUnitCount());
		model.addAttribute("totalDisplay", totalDisplay);
		LOG.debug("cart minicart ----");
		return ControllerConstants.Views.Fragments.Cart.MiniCartPanel;
	}

	@RequestMapping(value = "/cart/rollover/" + COMPONENT_UID_PATH_VARIABLE_PATTERN, method = RequestMethod.GET)
	public String rolloverMiniCartPopup(@PathVariable final String componentUid, final Model model)
			throws CMSItemNotFoundException
	{
		LOG.debug("cart rollover -- entry ----");
		final CartData cartData = cartFacade.getSessionCart();
		if (null != cartData.getEntries())
		{
			final PriceData totalPriceCart = setPromoData(cartData);
			cartData.setTotalPrice(totalPriceCart);
		}
		model.addAttribute("cartData", cartData);

		if (CollectionUtils.isNotEmpty(cartData.getEntries()))
		{
			//TODO add a call to group multidimensional products in cartFacade "cartFacade.groupMultiDimensionalProducts(cartData, variantSortStrategy);"
			for (final OrderEntryData entry : cartData.getEntries())
			{
				final UpdateQuantityForm uqf = new UpdateQuantityForm();
				uqf.setQuantity(entry.getQuantity());
				model.addAttribute("updateQuantityForm" + entry.getEntryNumber(), uqf);
			}
		}

		final MiniCartComponentModel component = (MiniCartComponentModel) cmsComponentService.getSimpleCMSComponent(componentUid);

		final List entries = cartData.getEntries();
		if (entries != null)
		{
			Collections.reverse(entries);
			model.addAttribute("entries", entries);

			model.addAttribute("numberItemsInCart", Integer.valueOf(entries.size()));
			if (entries.size() < component.getShownProductCount())
			{
				model.addAttribute("numberShowing", Integer.valueOf(entries.size()));
			}
			else
			{
				model.addAttribute("numberShowing", Integer.valueOf(component.getShownProductCount()));
			}

		}

		LOG.debug(entries);
		model.addAttribute("pageType", PageType.CART.name());
		model.addAttribute("lightboxBannerComponent", component.getLightboxBannerComponent());

		return ControllerConstants.Views.Fragments.Cart.CartPopup;
	}


	public PriceData setPromoData(final CartData cartData)
	{
		final PriceData totalPrice = new PriceData();
		totalPrice.setValue(new BigDecimal(0));
		for (final OrderEntryData orderEntryData : cartData.getEntries())
		{
			final ProductModel productModel = productService.getProductForCode(orderEntryData.getProduct().getCode());
			promotionDataPriceFacade.setPricePromotionData(orderEntryData.getProduct(), productModel);
			if (null != orderEntryData.getProduct().getPrice())
			{
				totalPrice.setValue(BigDecimal.valueOf(Double.sum(totalPrice.getValue().doubleValue(), orderEntryData.getProduct()
						.getPrice().getValue().doubleValue()
						* orderEntryData.getQuantity().doubleValue())));
			}
			else
			{
				totalPrice.setValue(BigDecimal.valueOf(Double.sum(totalPrice.getValue().doubleValue(), orderEntryData.getBasePrice()
						.getValue().doubleValue()
						* orderEntryData.getQuantity().doubleValue())));
			}
		}
		totalPrice.setFormattedValue(commonI18NService.getCurrentCurrency().getSymbol() + ""
				+ totalPrice.getValue().setScale(2, RoundingMode.HALF_EVEN).toString());


		return totalPrice;
	}
}
