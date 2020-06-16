<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="product" tagdir="/WEB-INF/tags/responsive/product"%>
<script type="text/javascript">
	var account = '${tealiumAccount}';	
	var profile = '${tealiumProfile}';
	var env = '${tealiumEnvironment}';
    var pageType ='${pageType}';
    //console.log ("pageType "+pageType);
    	<c:choose>
		<c:when test="${pageType == 'HOMEPAGE'}">
			var utag_data = {
				"page_name" : "Homepage",
				"page_type" : "home",
				"site_Name" : "${siteName}",
				"country_code" : "AU",
				"currency_code" : "${currentCurrency.isocode}",
				"site_display_format" : "Responsive",
			};
			//Add utag related to homepage
		</c:when>
		<c:when test="${pageType == 'PRODUCT'}">
            var productCategory = ''
			var utag_data = {
				"page_name" : "ProductDetail",
				"page_type" : "product", 
				"product_name" : ["${product.name}"],
				"product_id" : ["${product.code}"],
				"product_price": ["${product.price.value}"],
				"site_display_format": "Responsive",
				"sub_category_name": "${productCategory.name}",
				"product_subcategory":["${productCategory.name}"],
				"product_category" : ["${superCategory.name}"],
				"category_name" : "${superCategory.name}",


	};
			//Add utag related to PDP page
		</c:when>
		<c:when test="${pageType == 'PRODUCTREVIEWSUBMIT'}">
				var utag_data = {
					"event_action" : "click",
					"event_category" : "Interactions",
					"event_label" : "review submit",
					"event_name" : "review_submit"
				};
		</c:when>
		<c:when test="${pageType == 'CUSTOMERFEEDBACKVIEW'}">
				var utag_data = {
					"event_action" : "click",
					"event_category" : "Interactions",
					"event_label" : "customer_support",
					"event_name" : "customer_feedback_form"
				};
		</c:when>
		<c:when test="${pageType == 'CUSTOMERFEEDBACKSUBMIT'}">
				var utag_data = {
					"event_action" : "click",
					"event_category" : "Interactions",
					"event_label" : "customer_support",
					"event_name" : "customer_feedback_submit",
					"site_display_format": "Responsive",
				};
		</c:when>
	<c:when test="${pageType == 'CATEGORYSORTBYNAMEDESC'}">
	var utag_data = {
		"event_action" : "click",
		"event_category" : "Interactions",
		"event_label" : "name desc",
		"event_name" : "sort_by",
		"site_display_format": "Responsive",
	};
	</c:when>
	<c:when test="${pageType == 'CATEGORYSORTBYNAMEASC'}">
	var utag_data = {
		"event_action" : "click",
		"event_category" : "Interactions",
		"event_label" : "name asc",
		"event_name" : "sort_by",
		"site_display_format": "Responsive",
	};
	</c:when>
	<c:when test="${pageType == 'CATEGORYSORTBYPRICELOWFIRST'}">
	var utag_data = {
		"event_action" : "click",
		"event_category" : "Interactions",
		"event_label" : "price asc",
		"event_name" : "sort_by",
		"site_display_format": "Responsive",
	};
	</c:when>
	<c:when test="${pageType == 'CATEGORYSORTBYPRICEHIGHFIRST'}">
	var utag_data = {
		"event_action" : "click",
		"event_category" : "Interactions",
		"event_label" : "price desc",
		"event_name" : "sort_by",
		"site_display_format": "Responsive",
	};
	</c:when>
	<c:when test="${pageType == 'CATEGORYSORTBYTOPRATED'}">
	var utag_data = {
		"event_action" : "click",
		"event_category" : "Interactions",
		"event_label" : "Top Rated",
		"event_name" : "sort_by",
		"site_display_format": "Responsive",
	};
	</c:when>
	<c:when test="${pageType == 'CATEGORYSORTBYRELEVANCE'}">
	var utag_data = {
		"event_action" : "click",
		"event_category" : "Interactions",
		"event_label" : "Relevance",
		"event_name" : "sort_by",
		"site_display_format": "Responsive",
	};
	</c:when>

	<c:when test="${pageType == 'STOREFINDER'}">
	var utag_data = {
		"page_name" : "Store Finder",
		"page_type" : "store_finder",
		"site_display_format" : "Responsive",
	};
	</c:when>
	<c:when test="${pageType == 'STOREDETAILPAGE'}">
	var storeName ='${store.displayName}';
	var storeTown ='${store.address.town}';
	var storePostCode ='${store.address.postalCode}';
	var utag_data = {
		"event_action" : "click",
		"event_category" : "Interactions",
		"event_label" : "store_click",
		"event_name" : "store_click",
		"town_or_city_name":storeTown,
		"store_name":storeName,
		"zip_code":storePostCode,
		"site_display_format": "Responsive",
	};
	</c:when>
	<c:when test="${pageType == 'GIFTCARDPAGE'}">
	var utag_data = {
		"page_name" : "Gift Card",
		"page_type" : "gift_card",
		"site_display_format" : "Responsive"
	};
	</c:when>

		
		
		<c:when test="${pageType == 'CART'}">
	var utag_data={
		"page_name" : "Cart: View Shopping Bag",
		"page_type" : "cart",
		"product_id" : [<c:forEach items="${cartData.entries}" var="entry" varStatus="index">"${entry.product.code}"<c:if test="${!index.last}">,</c:if></c:forEach>],
		"product_name" : [<c:forEach items="${cartData.entries}" var="entry" varStatus="index">"${entry.product.name}"<c:if test="${!index.last}">,</c:if></c:forEach>],
		"product_subcategory" : [<c:forEach items="${cartData.entries}" var="entry" varStatus="index">"${entry.product.categories[0].name}"<c:if test="${!index.last}">,</c:if></c:forEach>],
		"product_quantity" : [<c:forEach items="${cartData.entries}" var="entry" varStatus="index">"${entry.quantity}"<c:if test="${!index.last}">,</c:if></c:forEach>],
		"product_price" : [<c:forEach items="${cartData.entries}" var="entry" varStatus="index">"${entry.basePrice.value}"<c:if test="${!index.last}">,</c:if></c:forEach>],
		"cart_total_items" : "${cartData.entries.size()}",
		"cart_subtotal" : "${cartData.totalPrice.value}",
		"site_display_format" : "Responsive"
		//Add any other properties you feel required
	};
	utag.track(utag_data)
	</c:when>
		
		<c:when test="${pageType == 'CATEGORY'}">
	var superCategory='${superCategory}';
//	console.log("supper---"+superCategory);
	if (superCategory==''){
		var utag_data = {
		"page_name" : "Category",
		"page_type" : "category",
		"category_name" : "${categoryName}",
		"site_display_format" : "Responsive"
		};
	}else {
		var utag_data = {
			"page_name" : "Category",
			"page_type" : "sub_category",
			"sub_category_name" : "${categoryName}",
			"site_display_format" : "Responsive",
			"category_name":superCategory
		};
	}
		</c:when>
		
		<c:when test="${pageType == 'PRODUCTSEARCH'}">		
			var utag_data={
				"country_code" : "AU",
				"currency_code" : "${currentCurrency.isocode}",
				"page_name" : "Search Results",
				"page_type" : "search",
				"search_results" : "${searchPageData.pagination.totalNumberOfResults}",
				"search_keyword" : "${searchPageData.currentQuery.query.value}",
				"site_display_format" : "Responsive"
				//Add any other properties you feel required
			};
		</c:when>			
		
		<c:when test="${pageType == 'ORDERCONFIRMATION'}">	
			var utag_data={
				"country_code" : "US",
				"currency_code" : "${currentCurrency.isocode}",
				"page_name" : "Cart: View Shopping Bag",
				"page_type" : "cart",
				"order_id" : ${orderData.code},
				"order_total" :"" ,
				"order_subtotal": "" ,
				"order_discount_amount": "",
				"order_currency_code":"" ,
				"order_promo_code" :"" ,
				"order_shipping_amount" : "",
				"order_shipping_type" : "",
				"order_store" :""
				//Add any other properties you feel required
			};					
		</c:when>				
		<c:otherwise>
			var utag_data = {
				"page_name" : pageType,
				"page_type" : "content",
				"site_display_format" : "Responsive"
			};
		</c:otherwise>
	</c:choose>

	function tealiumTagEvent(eventType,var1,var2,var3){
		//console.log("eventType---"+eventType);

		if (eventType=='reviewSubmit'){
			utag.link({"event_action" : "click", "event_category" : "Interactions", "event_label" : "submit product review", "event_name" : "review_submit" });
		}
		if (eventType=='writeReview'){
			utag.link({"event_action" : "click", "event_category" : "Interactions", "event_label" : "Write product review", "event_name" : "write_a_review" });
		}
		if (eventType=='storeFinder'){
			utag.link({"event_action" : "click", "event_category" : "Interactions", "event_label" : "find_a_store", "event_name" : "find_a_store","town_or_city_name":ACC.storefinder.storeSearchData['q'] });
		}
		if(eventType=='shareTweet'){
			utag.link({"event_action" : "click", "event_category" : "Interactions", "event_label" : "social_media", "event_name" : "social_share", "social_network" : "Tweet" });
		}
		if (eventType=='shareFacebook'){
			utag.link({"event_action" : "click", "event_category" : "Interactions", "event_label" : "social_media", "event_name" : "social_share", "social_network" : "Facebook"});
		}
		if (eventType =='shareGoogle'){
			utag.link({"event_action" : "click", "event_category" : "Interactions", "event_label" : "social_media", "event_name" : "social_share", "social_network" : "Google" });
		}
		if (eventType=='sharePinit'){
			utag.link({"event_action" : "click", "event_category" : "Interactions", "event_label" : "social_media", "event_name" : "social_share", "social_network" : "Pinit"});
		}
		if(eventType=='addToCart'){
			utag.link({"event_action" : "click", "event_category" : "Interactions", "event_label" : "add_to_shopping_list", "event_name" : "add_to_shopping_list", "product_id":"["+var1+"]","product_name":"["+var2+"]" ,"product_price":"["+var3+"]"});
		}
		if(eventType=='printCart'){
			utag.link({"event_action" : "click", "event_category" : "Interactions", "event_label" : "print_page", "event_name" : "print_page" });
		}
		if(eventType=='followFacebook'){
			utag.link({"event_action" : "click", "event_category" : "Interactions", "event_label" : "customer_support", "event_name" : "social_follow.facebook" });
		}
		if(eventType=='followPinit'){
			utag.link({"event_action" : "click", "event_category" : "Interactions", "event_label" : "customer_support", "event_name" : "social_follow.pinit" });
		}
		if(eventType=='followinstagram'){
			utag.link({"event_action" : "click", "event_category" : "Interactions", "event_label" : "customer_support", "event_name" : "social_follow.instagram" });
		}
		if(eventType=='followtwitter'){
			utag.link({"event_action" : "click", "event_category" : "Interactions", "event_label" : "customer_support", "event_name" : "social_follow.twitter" });
		}
		if(eventType=='productView'){
			utag.link({"event_action" : "click", "event_category" : "Interactions", "event_label" : "prod_view", "event_name" : "product_quick_view" });
		}
		if(eventType=='storeDetail'){
			utag.link({"event_action" : "click", "event_category" : "Interactions", "event_label" : "customer_support", "event_name" : "store_click", "store_name":var1,"town_or_city_name":var2 ,"zip_code":var3});
		}









	}

	(function(a,b,c,d){
		a='//tags.tiqcdn.com/utag/'+account+'/'+profile+'/'+env+'/utag.js';
		b=document;c='script';d=b.createElement(c);d.src=a;
		d.type='text/java'+c;d.async=true;
		a=b.getElementsByTagName(c)[0];a.parentNode.insertBefore(d,a)
	})();

</script>