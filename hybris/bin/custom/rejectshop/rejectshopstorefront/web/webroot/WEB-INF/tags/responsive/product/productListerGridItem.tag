<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ attribute name="product" required="true" type="de.hybris.platform.commercefacades.product.data.ProductData" %>
<%@ taglib prefix="product" tagdir="/WEB-INF/tags/responsive/product" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="format" tagdir="/WEB-INF/tags/shared/format" %>
<%@ taglib prefix="action" tagdir="/WEB-INF/tags/responsive/action" %>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>


<spring:theme code="text.addToCart" var="addToCartText"/>
<c:url value="${product.url}" var="productUrl"/>
<c:set value="${not empty product.potentialPromotions}" var="hasPromotion"/>

<li class="product-item">
	<ycommerce:testId code="product_wholeProduct">
		<a class="thumb" href="${productUrl}" title="${product.name}">
			<product:productPrimaryImage product="${product}" format="product"/>
			<c:if test="${not empty product.potentialPromotions}">
				<div class="CallOutDiv CallOutListDiv CO_${product.productIndicator}">
					<c:choose>
						<c:when test="${product.productIndicator=='EVERYDAY'}">
							HERE EVERY DAY
						</c:when>
						<c:when test="${product.productIndicator=='PRICECHOP'}">
							PRICE CHOP
						</c:when>
						<c:when test="${product.productIndicator=='CATALOGUEDEAL'}">
							CATALOGUE DEAL
						</c:when>
						<c:when test="${product.productIndicator=='TVDEAL'}">
							TV DEAL
						</c:when>
						<c:when test="${product.productIndicator=='SAVVYDEAL'}">
							SAVVY DEAL
						</c:when>
						<c:when test="${product.productIndicator=='MULTIBUY'}">
							MULTI BUY
						</c:when>
						<c:when test="${product.productIndicator=='JOBLOT'}">
							JOB LOT
						</c:when>
						<c:otherwise>
							${product.productIndicator}
						</c:otherwise>
					</c:choose>
				</div>
			</c:if>		</a>
		<div class="details">

			<ycommerce:testId code="product_productName"><a class="name" href="${productUrl}">${product.name}</a></ycommerce:testId>
		
			<ycommerce:testId code="product_productPrice">
				<div class="price"><format:price priceData="${product.price}"/></div>
			</ycommerce:testId>
		</div>


		<c:set var="product" value="${product}" scope="request"/>
		<c:set var="addToCartText" value="${addToCartText}" scope="request"/>
		<c:set var="addToCartUrl" value="${addToCartUrl}" scope="request"/>
		<c:set var="isGrid" value="true" scope="request"/>
		<div class="addtocart">
			<div class="actions-container-for-${component.uid}">
				<action:actions element="div" parentComponent="${component}"/>
			</div>
		</div>
	</ycommerce:testId>
</li>

