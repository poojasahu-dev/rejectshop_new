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
		$('.payWithCardSection').hide();
		$('#headlineDiv').removeClass('headline');
		$('#creditCardLabelId').addClass('headline');
		$('#silentOrderSubmitButton').removeAttr('href');
		$('#silentOrderSubmitButton').removeAttr('data-paypal-button');
		$('#silentOrderSubmitButton').removeAttr('data-paypal-id');
		$('.submit_silentOrderPostForm').click(function() {
			$("#silentOrderPostForm").submit();
		})		
	} else if ($('input[name=paymentMethodSelection]:radio:checked').val() == 'paypal') {
		$('#silentOrderSubmitButton').attr('href', $('#expressCheckoutUrl').text());
		$('.payWithCardSection').hide();
		$('#silentOrderSubmitButton').removeClass('submit_silentOrderPostForm');
		$('#headlineDiv').removeClass('headline');
		$('#creditCardLabelId').addClass('headline');
		$('#silentOrderSubmitButton').unbind('click');
	} else {
		$('#silentOrderSubmitButton').removeAttr('href');
		$('.payWithCardSection').show();
		$('#silentOrderSubmitButton').addClass('submit_silentOrderPostForm');
		$('#headlineDiv').addClass('headline');
		$('#creditCardLabelId').removeClass('headline');
		$('.submit_silentOrderPostForm').click(function() {
			$("#silentOrderPostForm").submit();
		})
	}
}
