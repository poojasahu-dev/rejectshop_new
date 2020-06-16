<%@ page trimDirectiveWhitespaces="true"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="theme" tagdir="/WEB-INF/tags/shared/theme"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="format" tagdir="/WEB-INF/tags/shared/format"%>
<%@ taglib prefix="product" tagdir="/WEB-INF/tags/responsive/product"%>
<%@ taglib prefix="component" tagdir="/WEB-INF/tags/shared/component"%>


<c:choose>
	<c:when
		test="${not empty productReferencesRandom and component.maximumNumberProducts > 0}">
		<c:if test="${component.name eq 'Cross Selling'}"> 
		<div class="carousel-component">
			<div class="headline">${component.title}</div>
<!--   <a class="btn prev"></a> -->
			<div id="owl-demo" class="carousel js-owl-carousel js-owl-lazy-reference js-owl-carousel-reference">
				<%-- 
				<div id="quickViewTitle" class="quickView-header" style="display:none">
					<div class="headline">		
						<span class="headline-text"><spring:theme code="popup.quick.view.select"/></span>
					</div>
				</div> --%>
				
				<c:forEach end="${component.maximumNumberProducts}"
					items="${productReferencesRandom}" var="productReference">
					<c:url value="${productReference.url}" var="productUrl"/>
					<div class="item">
						<a href="${productUrl}">
                         <!--    <div class="thumb"> -->
                                <product:productPrimaryReferenceImage product="${productReference}" format="product" />
                           <!--  </div> -->
						 

						<c:if test="${component.displayProductTitles}">
                                <div class="item-name">${productReference.name}</div>
						</c:if>
						<c:if test="${component.displayProductPrices}">
                                <div class="price">
                                    <format:fromPrice priceData="${productReference.price}" />
							</div>
						</c:if>
						</a>

					</div>
				</c:forEach>
				
			</div>
			<!-- <a class="btn next"></a> -->

		</div>
		<div class="customNavigation">



</div>
		</c:if>
	</c:when>
	<c:when
		test="${not empty productReferences and component.maximumNumberProducts > 0}">
		<c:if test="${component.name eq 'Cross Selling'}">
		<div class="carousel-component">

			<div class="headline">${component.title}</div>

			<div  id="owl-demo" class="carousel js-owl-carousel js-owl-lazy-reference js-owl-carousel-reference">


				<c:forEach end="${component.maximumNumberProducts}"
					items="${productReferences}" var="productReference">
					<c:url value="${productReference.target.url}" var="productUrl"/>
					<div class="item">
						<a href="${productUrl}">
                                <product:productPrimaryReferenceImage product="${productReference.target}" format="product" />
                            <c:if test="${component.displayProductTitles}">
                                <div class="item-name">${productReference.target.name}</div>
                            </c:if>
                            <c:if test="${component.displayProductPrices}">
                                <div class="price">
                                    <format:fromPrice priceData="${productReference.target.price}" />
                                </div>
                            </c:if>
						</a>
					</div>
				</c:forEach>
			</div>
		</div>
		</c:if>
	</c:when>


	<c:otherwise>
		<component:emptyComponent />
	</c:otherwise>
</c:choose>