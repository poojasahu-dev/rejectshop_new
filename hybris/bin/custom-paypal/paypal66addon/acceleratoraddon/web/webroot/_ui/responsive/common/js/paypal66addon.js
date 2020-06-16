/*
 * [y] hybris Platform
 *
 * Copyright (c) 2017 SAP SE or an SAP affiliate company.  All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */

$(function() {
    if (window.opener != null && window.opener.PAYPAL != undefined){
        window.opener.location = window.location;
        window.opener.PAYPAL.apps.Checkout.closeFlow();
    }
    paymentMethod();
    $('[name=paymentMethodSelection]').change(function() {
        paymentMethod();
    });
    if ($('#whatIsPayPalLink>a').length > 0){
        $('#whatIsPayPalLink>a').on('click', function(){
            newwindow=window.open($(this).attr('href'),'','height=768,width=1280,menubar=no,status=no');
            if (window.focus) {newwindow.focus()}
            return false;
        });
    }
});

function paymentMethod() {
    if ($('input[name=paymentMethodSelection]:radio:checked').val() == ''
        || $('input[name=paymentMethodSelection]:radio:checked').val() == undefined) {
        $('.submit_silentOrderPostForm').removeAttr('href');
        $('.payWithCardSection').show();
        $('#creditCardLabelId').removeClass('headline');
        $('.submit_silentOrderPostForm').show();

    } else if ($('input[name=paymentMethodSelection]:radio:checked').val() == 'paypal') {
        // $('.submit_silentOrderPostForm').attr('href', $('#expressCheckoutUrl').text());
        $('.submit_silentOrderPostForm').hide();
        $('#mark-paypal-button-container').show();
        $('.payWithCardSection').hide();
        $('#creditCardLabelId').addClass('headline');

    } else {
        $('#mark-paypal-button-container').hide();
        $('.payWithCardSection').show();
        $('#creditCardLabelId').removeClass('headline');
        $('.submit_silentOrderPostForm').show();
    }
}
