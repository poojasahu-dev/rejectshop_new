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
package au.com.rejectshop.storefront.controllers;

import de.hybris.platform.acceleratorcms.model.components.CartSuggestionComponentModel;
import de.hybris.platform.acceleratorcms.model.components.CategoryFeatureComponentModel;
import de.hybris.platform.acceleratorcms.model.components.DynamicBannerComponentModel;
import de.hybris.platform.acceleratorcms.model.components.MiniCartComponentModel;
import de.hybris.platform.acceleratorcms.model.components.NavigationBarComponentModel;
import de.hybris.platform.acceleratorcms.model.components.ProductFeatureComponentModel;
import de.hybris.platform.acceleratorcms.model.components.ProductReferencesComponentModel;
import de.hybris.platform.acceleratorcms.model.components.PurchasedCategorySuggestionComponentModel;
import de.hybris.platform.acceleratorcms.model.components.SimpleResponsiveBannerComponentModel;
import de.hybris.platform.acceleratorcms.model.components.SubCategoryListComponentModel;
import de.hybris.platform.cms2.model.contents.components.CMSLinkComponentModel;
import de.hybris.platform.cms2lib.model.components.ProductCarouselComponentModel;

import au.com.rejectshop.core.model.REJRotatingImagesComponentModel;
import au.com.rejectshop.core.model.REJSimpleResponsiveBannerComponentModel;
import au.com.rejectshop.core.model.components.TRSCategoryCarouselComponentModel;
import au.com.rejectshop.core.model.components.TRSDynamicCategoryCarouselComponentModel;
import au.com.rejectshop.core.model.components.TRSTableTreeCategoryCarouselComponentModel;


/**
 */
public interface ControllerConstants
{
	// Constant names cannot be changed due to their usage in dependant extensions, thus nosonar

	/**
	 * Class with action name constants
	 */
	interface Actions
	{
		interface Cms // NOSONAR
		{
			String _Prefix = "/view/"; // NOSONAR
			String _Suffix = "Controller"; // NOSONAR

			/**
			 * Default CMS component controller
			 */
			String DefaultCMSComponent = _Prefix + "DefaultCMSComponentController"; // NOSONAR

			/**
			 * CMS components that have specific handlers
			 */
			String PurchasedCategorySuggestionComponent = _Prefix + PurchasedCategorySuggestionComponentModel._TYPECODE + _Suffix; // NOSONAR
			String CartSuggestionComponent = _Prefix + CartSuggestionComponentModel._TYPECODE + _Suffix; // NOSONAR
			String ProductReferencesComponent = _Prefix + ProductReferencesComponentModel._TYPECODE + _Suffix; // NOSONAR
			String ProductCarouselComponent = _Prefix + ProductCarouselComponentModel._TYPECODE + _Suffix; // NOSONAR
			String MiniCartComponent = _Prefix + MiniCartComponentModel._TYPECODE + _Suffix; // NOSONAR
			String ProductFeatureComponent = _Prefix + ProductFeatureComponentModel._TYPECODE + _Suffix; // NOSONAR
			String CategoryFeatureComponent = _Prefix + CategoryFeatureComponentModel._TYPECODE + _Suffix; // NOSONAR
			String NavigationBarComponent = _Prefix + NavigationBarComponentModel._TYPECODE + _Suffix; // NOSONAR
			String CMSLinkComponent = _Prefix + CMSLinkComponentModel._TYPECODE + _Suffix; // NOSONAR
			String DynamicBannerComponent = _Prefix + DynamicBannerComponentModel._TYPECODE + _Suffix; // NOSONAR
			String SubCategoryListComponent = _Prefix + SubCategoryListComponentModel._TYPECODE + _Suffix; // NOSONAR
			String REJSimpleResponsiveBannerComponent = _Prefix + REJSimpleResponsiveBannerComponentModel._TYPECODE + _Suffix;
			String REJRotatingImagesComponent = _Prefix + REJRotatingImagesComponentModel._TYPECODE + _Suffix;
			String SimpleResponsiveBannerComponent = _Prefix + SimpleResponsiveBannerComponentModel._TYPECODE + _Suffix; // NOSONAR
			String TRSCategoryCarouselComponent = _Prefix + TRSCategoryCarouselComponentModel._TYPECODE + _Suffix; // NOSONAR
			String TRSDynamicCategoryCarouselComponent = _Prefix + TRSDynamicCategoryCarouselComponentModel._TYPECODE + _Suffix; // NOSONAR
			String TRSTableTreeCategoryCarouselComponent = _Prefix + TRSTableTreeCategoryCarouselComponentModel._TYPECODE + _Suffix; // NOSONAR
		}
	}

	/**
	 * Class with view name constants
	 */
	interface Views
	{
		interface Cms // NOSONAR
		{
			String ComponentPrefix = "cms/"; // NOSONAR
			String RejRotatingImagesComponent = "rejRotatingImagesComponent";
			String RejSimpleResponsiveBannerComponent = "rejSimpleResponsiveBannerComponent";
		}

		interface Pages
		{
			interface Account // NOSONAR
			{
				String AccountLoginPage = "pages/account/accountLoginPage"; // NOSONAR
				String AccountHomePage = "pages/account/accountHomePage"; // NOSONAR
				String AccountOrderHistoryPage = "pages/account/accountOrderHistoryPage"; // NOSONAR
				String AccountOrderPage = "pages/account/accountOrderPage"; // NOSONAR
				String AccountProfilePage = "pages/account/accountProfilePage"; // NOSONAR
				String AccountProfileEditPage = "pages/account/accountProfileEditPage"; // NOSONAR
				String AccountProfileEmailEditPage = "pages/account/accountProfileEmailEditPage"; // NOSONAR
				String AccountChangePasswordPage = "pages/account/accountChangePasswordPage"; // NOSONAR
				String AccountAddressBookPage = "pages/account/accountAddressBookPage"; // NOSONAR
				String AccountEditAddressPage = "pages/account/accountEditAddressPage"; // NOSONAR
				String AccountPaymentInfoPage = "pages/account/accountPaymentInfoPage"; // NOSONAR
				String AccountRegisterPage = "pages/account/accountRegisterPage"; // NOSONAR
			}

			interface Checkout // NOSONAR
			{
				String CheckoutRegisterPage = "pages/checkout/checkoutRegisterPage"; // NOSONAR
				String CheckoutConfirmationPage = "pages/checkout/checkoutConfirmationPage"; // NOSONAR
				String CheckoutLoginPage = "pages/checkout/checkoutLoginPage"; // NOSONAR
			}

			interface MultiStepCheckout // NOSONAR
			{
				String AddEditDeliveryAddressPage = "pages/checkout/multi/addEditDeliveryAddressPage"; // NOSONAR
				String ChooseDeliveryMethodPage = "pages/checkout/multi/chooseDeliveryMethodPage"; // NOSONAR
				String ChoosePickupLocationPage = "pages/checkout/multi/choosePickupLocationPage"; // NOSONAR
				String AddPaymentMethodPage = "pages/checkout/multi/addPaymentMethodPage"; // NOSONAR
				String CheckoutSummaryPage = "pages/checkout/multi/checkoutSummaryPage"; // NOSONAR
				String HostedOrderPageErrorPage = "pages/checkout/multi/hostedOrderPageErrorPage"; // NOSONAR
				String HostedOrderPostPage = "pages/checkout/multi/hostedOrderPostPage"; // NOSONAR
				String SilentOrderPostPage = "pages/checkout/multi/silentOrderPostPage"; // NOSONAR
				String GiftWrapPage = "pages/checkout/multi/giftWrapPage"; // NOSONAR
			}

			interface Password // NOSONAR
			{
				String PasswordResetChangePage = "pages/password/passwordResetChangePage"; // NOSONAR
				String PasswordResetRequest = "pages/password/passwordResetRequestPage"; // NOSONAR
				String PasswordResetRequestConfirmation = "pages/password/passwordResetRequestConfirmationPage"; // NOSONAR
			}

			interface Error // NOSONAR
			{
				String ErrorNotFoundPage = "pages/error/errorNotFoundPage"; // NOSONAR
			}

			interface Cart // NOSONAR
			{
				String CartPage = "pages/cart/cartPage"; // NOSONAR

				/* String SendAFriendFaliureEmail = "pages/cart/sendAFriendFaliureEmail"; */
			}

			interface StoreFinder // NOSONAR
			{
				String StoreFinderSearchPage = "pages/storeFinder/storeFinderSearchPage"; // NOSONAR
				String StoreFinderSearchResultsPage = "pages/storeFinder/storeFinderSearchResultsPage"; // NOSONAR
				String StoreFinderDetailsPage = "pages/storeFinder/storeFinderDetailsPage"; // NOSONAR
				String StoreFinderViewMapPage = "pages/storeFinder/storeFinderViewMapPage"; // NOSONAR
			}

			interface Misc // NOSONAR
			{
				String MiscRobotsPage = "pages/misc/miscRobotsPage"; // NOSONAR
				String MiscSiteMapPage = "pages/misc/miscSiteMapPage"; // NOSONAR
			}

			interface Guest // NOSONAR
			{ // NOSONAR
				String GuestOrderPage = "pages/guest/guestOrderPage"; // NOSONAR
				String GuestOrderErrorPage = "pages/guest/guestOrderErrorPage"; // NOSONAR
			}

			interface GiftCards
			{
				String CheckGiftCardBalancePage = "pages/giftcards/checkGiftCardBalancePage";
			}

			interface Product // NOSONAR
			{
				String WriteReview = "pages/product/writeReview"; // NOSONAR
				String OrderForm = "pages/product/productOrderFormPage"; // NOSONAR

			}

			interface HeaderFooter
			{
				String header = "pages/template/header";
				String footer = "pages/template/footer";
			}

			interface Catalogue
			{
				String catalogue = "pages/catalogue/catalogue";

			}

		}

		interface Fragments
		{
			interface Cart // NOSONAR
			{
				String AddToCartPopup = "fragments/cart/addToCartPopup"; // NOSONAR
				String MiniCartPanel = "fragments/cart/miniCartPanel"; // NOSONAR
				String MiniCartErrorPanel = "fragments/cart/miniCartErrorPanel"; // NOSONAR
				String CartPopup = "fragments/cart/cartPopup"; // NOSONAR
				String ExpandGridInCart = "fragments/cart/expandGridInCart"; // NOSONAR
			}

			interface Account // NOSONAR
			{
				String CountryAddressForm = "fragments/address/countryAddressForm"; // NOSONAR
			}

			interface Checkout // NOSONAR
			{
				String TermsAndConditionsPopup = "fragments/checkout/termsAndConditionsPopup"; // NOSONAR
				String BillingAddressForm = "fragments/checkout/billingAddressForm"; // NOSONAR
				String ReadOnlyExpandedOrderForm = "fragments/checkout/readOnlyExpandedOrderForm"; // NOSONAR
			}

			interface Password // NOSONAR
			{
				String PasswordResetRequestPopup = "fragments/password/passwordResetRequestPopup"; // NOSONAR
				String ForgotPasswordValidationMessage = "fragments/password/forgotPasswordValidationMessage"; // NOSONAR
			}

			interface Product // NOSONAR
			{
				String FutureStockPopup = "fragments/product/futureStockPopup"; // NOSONAR
				String QuickViewPopup = "fragments/product/quickViewPopup"; // NOSONAR
				String ZoomImagesPopup = "fragments/product/zoomImagesPopup"; // NOSONAR
				String ReviewsTab = "fragments/product/reviewsTab"; // NOSONAR
				String StorePickupSearchResults = "fragments/product/storePickupSearchResults"; // NOSONAR
				String SendReminderRedirectionEmail = "fragments/product/sendReminderRedirectionEmail";
				String SendAFriendRedirectionEmail = "fragments/product/sendAFriendRedirectionEmail";
			}
		}
	}
}