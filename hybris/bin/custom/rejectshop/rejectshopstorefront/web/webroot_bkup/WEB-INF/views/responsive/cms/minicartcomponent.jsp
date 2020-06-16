<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="format" tagdir="/WEB-INF/tags/shared/format"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<c:url value="/cart/miniCart/${totalDisplay}" var="refreshMiniCartUrl"/>
<c:url value="/cart/rollover/${component.uid}" var="rolloverPopupUrl"/>
<c:url value="/cart" var="cartUrl"/>

<a 	href="${cartUrl}" 
	${component.title}
	class="mini-cart-link js-mini-cart-link" 
	data-mini-cart-url="${rolloverPopupUrl}" 
	data-mini-cart-refresh-url="${refreshMiniCartUrl}" 
	data-mini-cart-name="<spring:theme code="text.cart"/>" 
	data-mini-cart-empty-name="<spring:theme code="popup.cart.empty"/>"	>
	
	
	<c:choose>
	<c:when test="${component.uid ne 'ShoppingList'}">
	<ycommerce:testId code="miniCart_items_label">
		<span class="hidden-sm hidden-xs">${component.title}</span>
		<div class="mini-cart-count js-mini-cart-count">${totalItems}</div>
		<div class="mini_cart_image"><img src="${commonResourcePath}/images/cart.png" ></img></div>
		<!-- <div class="minicart_shopping_list">SHOPPING LIST</div> -->
	</ycommerce:testId>	
	</c:when>
	<c:otherwise>
	<ycommerce:testId code="miniCart_items_label">
		<div class="newminicartLink">${component.title}</div>		
		<div class="mini-cart-count js-mini-cart-count hide">${totalItems}</div>		
	</ycommerce:testId>	
	</c:otherwise>
	</c:choose>
</a>
<div class="mini-cart-container js-mini-cart-container"></div>

	
