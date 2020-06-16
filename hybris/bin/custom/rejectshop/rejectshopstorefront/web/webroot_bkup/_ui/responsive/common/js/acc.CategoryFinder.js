ACC.xmascalculator = {

	_autoload : [ "bindXmasCalculator", "bindXmasGiftFinder" ],
	spinner : $("<img src='" + ACC.config.commonResourcePath
			+ "/images/spinner.gif' />"),

	bindXmasCalculator : function() {
		$(document).on(
				"click",
				".priceButton",
				function(e) {
					e.preventDefault();
					var id = $(this).attr('id');
					var options = {
						'categoryCode' : $(this).val()
					};
					$.ajax(
							{
								url : ACC.config.encodedContextPath
										+ '/savvy-christmas-calculator',
								async : true,
								data : options,
								dataType : "html",
								beforeSend : function() {
									$("#savvycalculatorpage").html(
											ACC.xmascalculator.spinner);
								}
							}).done(
							function(data) {
								$("#savvycalculatorpage").html(
										$(data).find('#savvycalculatorpage')
												.html());
								$(".priceButton").removeClass("active");
								$("#" + id).addClass("active");
							});
				});
	},
	bindXmasGiftFinder : function() {
		$(document)
				.on(
						"click",
						".showMe",
						function(e) {
							e.preventDefault();
							$(this).addClass("showOff");
							var decorationPrice = $('#priceChosen').val();
							var giftedTo = $("#giftedToChosen").val();
							var q = ':relevance';
							if (giftedTo != '') {
								q += ':categoryFilter:' + giftedTo
							}
							var options = {
								'subCategory' : decorationPrice,
								'q' : q
							};
							var url = window.location.href.split('?')[0];
							$
									.ajax(
											{
												url : url,
												async : true,
												data : options,
												dataType : "html",
												beforeSend : function() {
													$(
															".category-filter-results")
															.html(
																	ACC.xmascalculator.spinner);
												}
											})
									.done(
											function(data) {
												$(".category-filter-results")
														.html(
																$(data)
																		.find(
																				'.category-filter-results')
																		.html());
												ACC.paginationsort
														.bindSortForm($('#sortForm1'));
												ACC.paginationsort
														.bindSortForm($('#sortForm2'));
											});
						});
	}
}