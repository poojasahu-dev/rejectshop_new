<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="product" tagdir="/WEB-INF/tags/responsive/product"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="product" tagdir="/WEB-INF/tags/responsive/product"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="product-details">
	<ycommerce:testId
		code="productDetails_productNamePrice_label_${product.code}">
		<div class="name">${product.name}<%--  <span class="sku">ID ${product.code}</span> --%>
		</div>
	</ycommerce:testId>
	<%-- <product:productReviewSummary product="${product}" showLinks="true"/> --%>

</div>
<div class="row">
	<div class="col-sm-6">
		<product:productImagePanel galleryImages="${galleryImages}"
			product="${product}" />
		<div class="product-details">
			<product:productPromotionSection product="${product}" />
			<ycommerce:testId code="productDetails_productNamePrice_label_${product.code}">
				<product:productPricePanel product="${product}" />
			</ycommerce:testId>
			<div class="product_summary summary">
				${product.summary}
			</div>
		</div>
	</div>
	<div class="col-sm-6">
		<div class="product-details-rightnav">
			<cms:pageSlot position="VariantSelector" var="component">
				<cms:component component="${component}" />
			</cms:pageSlot>

			<cms:pageSlot position="AddToCart" var="component">
				<cms:component component="${component}" />
			</cms:pageSlot>
			<%-- <ycommerce:testId code="addToCartButton">
				<div id="shoppingListButton" type="${buttonType}" class="shoppingListClassButton">
					<img src="${commonResourcePath}/images/carticon.png"></img>
					<div class="minicart_shopping_list">
						<cms:pageSlot position="ShoppingList" var="component" limit="1">
							<cms:component component="${component}" class="miniCart" />
						</cms:pageSlot>
					</div>
				</div>
			</ycommerce:testId> --%>
			<div>
				<button id="emailListButton" type="${buttonType}" class="shoppingListClassButton emailReminderListButton">
					<img src="${commonResourcePath}/images/reminder.png"></img>
					<div class="minicart_shopping_list">
						<a class="js-open-modal btn" href="#" data-modal-id="popup2">Email reminder</a>
					</div>
				</button>
			</div>
			 <div>
				<button id="shoppingListButton" type="${buttonType}" class="shoppingListClassButton emailFriendListButton">
					<img src="${commonResourcePath}/images/send_email.png"></img>
					<div class="minicart_shopping_list">
						<a class="js-open-modal btn" href="#" data-modal-id="popup1">Send to a friend</a>
					</div>
				</button>
			</div>	
			<product:productPageTabs />
			<div class="productDisclaimer">*Availability and photos of stock shown are only a representation of styles and sizes which may vary from store to store and/or state</div>

		</div>
	</div>
</div>
<product:sendReminder />
<product:sendAFriend />