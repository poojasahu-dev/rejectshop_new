/*
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company.  All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package com.paypal.hybris.addon.controllers;

import com.paypal.hybris.addon.model.PayPalECButtonComponentModel;
import com.paypal.hybris.addon.model.PayPalECMiniCartComponentModel;

/**
 */
public interface Paypal67addonControllerConstants {
    String ADDON_PREFIX = "addon:/paypal67addon/";

    final String CHECKOUT_PAGE_VIEW_NAME_FRAGMENT = "pages/checkout/";

    final String PAY_PAL_EXPRESS_CHECKOUT_SHORTCUT_PARAM = "shortcut";

    final String PAY_PAL_HOP_URL_ATTR = "payPalHopRequestUrl";
    final String PAY_PAL_ERRORS_DETAILS = "errorsDetails";
    final String PAY_PAL_HOP_EXPRESS_CHECKOUT_SHORTCUT_URL = "/paypal/checkout/hop/expressCheckoutShortcut";

    interface Actions {
        interface Cms {
            String _Prefix = "/view/";
            String _Suffix = "Controller";

            String PayPalMiniCartComponent = _Prefix + PayPalECMiniCartComponentModel._TYPECODE + _Suffix;

            String PayPalECButtonComponent = _Prefix + PayPalECButtonComponentModel._TYPECODE + _Suffix;
        }
    }

    interface Views {
        interface Pages {
            interface MultiStepCheckout {
                String SilentOrderPostPage = ADDON_PREFIX + "pages/checkout/multi/silentOrderPostPage";
                String CheckoutSummaryPage = ADDON_PREFIX + "pages/checkout/multi/checkoutSummaryPage";
                String PayPalHostedOrderPageErrorPage = ADDON_PREFIX + "pages/checkout/multi/payPalErrorPage";
            }

            interface Checkout {
                String CheckoutConfirmationPage = ADDON_PREFIX + "pages/checkout/checkoutConfirmationPage";
                String CheckoutLoginPage = "pages/checkout/checkoutLoginPage";
            }
        }

        interface Fragments {
            interface Cart {
                String CartPopup = ADDON_PREFIX + "fragments/cart/cartPopup";
                String AddToCartPopup = ADDON_PREFIX + "fragments/cart/addToCartPopup";
            }
        }
    }
}
