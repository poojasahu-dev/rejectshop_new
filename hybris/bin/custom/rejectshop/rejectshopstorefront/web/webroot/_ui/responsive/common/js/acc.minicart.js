ACC.minicart = {

	_autoload : [ "bindMiniCart" ],

	bindMiniCart : function() {

		$(document)
				.on(
						"click",
						".js-mini-cart-link",
						function(e) {
							e.preventDefault();
							var url = $(this).data("miniCartUrl");
							// alert(url);
							var cartName = ($(this).find(".js-mini-cart-count")
									.html() != 0) ? $(this)
									.data("miniCartName") : $(this).data(
									"miniCartEmptyName");
							ACC.colorbox.open(cartName, {
								href : url,
								width : "80%",
								height : "80%"
							});
						})
		$(document).on("click", ".js-mini-cart-close-button", function(e) {
			e.preventDefault();
			ACC.colorbox.close();
		})
		$(document)
				.on(
						'click',
						".submitRemoveProduct",
						function(e) {

							var url = $(".js-mini-cart-link").data(
									"miniCartUrl");

							var totalitemsUrl = $(".js-mini-cart-link").data(
									"mini-cart-refresh-url");

							var prodid = $(this).attr('id').split("_");
							var form = $('#updateCartForm' + prodid[1]);
							var productCode = form.find(
									'input[name=productCode]').val();
							var entryNumber = form.find(
									'input[name=entryNumber]').val();
							var initialCartQuantity = form
									.find('input[name=initialQuantity]');
							var cartQuantity = form
									.find('input[name=quantity]');
							var quantity = 0;
							var cartName = ($(this).find(".js-mini-cart-count")
									.html() != 0) ? $(this)
									.data("miniCartName") : $(this).data(
									"miniCartEmptyName");

							ACC.track.trackRemoveFromCart(productCode,
									initialCartQuantity);
							cartQuantity.val(0);
							initialCartQuantity.val(0);
						
							
							$.ajax({
								type : "GET",
								url : ACC.config.contextPath + "/cart/remove",
								data : {
									entryNumber : entryNumber,
									quantity : quantity
								}, // parameters
								dataType : 'json',
								contentType : 'application/json',
								success : function(response) {
									console.log(response);
									ACC.colorbox.open(cartName, {
										href : url,
										width : "70%",
										height : "80%"
									});
									
									var Quantityvalue = $("#"+e.target.id).parents(".mini-cart-item").find(".entryQuantity").data("quantity");
									var minicartCount = $(".mini-cart-count").text();
									$(".mini-cart-count").text(minicartCount - Quantityvalue);
									
								/*	$.getJSON(totalitemsUrl, function(jd) {
										console.log(jd);
										$(".js-mini-cart-count").text(jd.miniCartCount);
									});*/
									
								},
								error : function(response) {

									alert("product not removed");
								}
							});

						});
	},

	updateMiniCartDisplay : function() {
		var miniCartRefreshUrl = $(".js-mini-cart-link").data(
				"miniCartRefreshUrl");
		$.get(miniCartRefreshUrl, function(data) {
			var data = $.parseJSON(data);
			$(".js-mini-cart-link .js-mini-cart-count")
					.html(data.miniCartCount)
			$(".js-mini-cart-link .js-mini-cart-price")
					.html(data.miniCartPrice)
		})
	}

};