<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags" %>
<%@ taglib prefix="product" tagdir="/WEB-INF/tags/responsive/product" %>
<%@ taglib prefix="nav" tagdir="/WEB-INF/tags/responsive/nav" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="/_ui/responsive/common/js/giftFinder.js"></script>


<template:page pageTitle="${pageTitle}">
<div class="row">		
</div>
<div class="row bannerContainer">
	<div class="bannerOverlay">
		<div class="row overlayContent">

			<div class="col-md-12 text-center">
				<img src="/_ui/responsive/common/images/savvy-gift-finder.png">
			</div>
			<div class="col-md-12">
				<div class="col-md-8 dropdownText">
					<spring:theme code="category.filter.overlay.filter1.text" />
				</div>
				<div class="col-md-4">
					<div class="custom-select">
						<div class="option" id="option">
							<div class="hiddenPlaceholder">
								<c:if test="${ not empty selectedPriceName }">
								<c:set var = "selPriceWDollar" value = "${fn:replace(selectedPriceName, '$', '')}" />
								<sup>$</sup>${selPriceWDollar}
								</c:if>
							</div>
							<span>Select</span>
						</div>
						<p>Select</p>
						<ul class="select">
							<c:forEach var="price" items="${decorationPrices }">
								<c:set var = "priceWDollar" value = "${fn:replace(price.name, '$', '')}" />
								<li data-val="${priceWDollar}" data-code="${price.code }"
									data-type="decorPrice"><a href="#"><sup>$</sup>${priceWDollar}</a></li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
			<input type="hidden" id="priceChosen" value="${subCategory }" /> 
			<input type="hidden" id="giftedToChosen" value="${selectedCategoryFilter }" />
			<div class="col-md-12">
				<div class="col-md-8 dropdownText">
					<spring:theme code="category.filter.overlay.filter2.text" />
				</div>
				<div class="col-md-4">
					<div class="custom-select">
						<div class="option">
							<div class="hiddenPlaceholder">${selectedCategoryFilter }</div>
							 <span>Select</span>
						</div>
						<p>Select</p>
						<ul class="select">
							<c:forEach var="enumValue" items="${categoryFilterEnumValues }">
								<li data-val="${enumValue.code }" data-type="giftedTo"><a
									href="#">${enumValue.code }</a></li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
			<div class="col-md-12 text-center" id="giftFinder">
				<div class="row">
					<div class="col-md-8 showMe">
						<spring:theme code="category.filter.overlay.button.text" />
					</div>
				</div>
			</div>
		</div>
	</div>

	<cms:pageSlot position="BannerSection" var="feature" element="div"
		class="giftFinderBanner">
		<cms:component component="${feature}" />
	</cms:pageSlot>
</div>
<div class="category-filter-results">
	<div class="product-list-wrapper">
		<c:choose>
			<c:when test="${searchPageData.pagination.totalNumberOfResults > 0}">
				<div  class="categoryFilterText"><spring:theme code="category.filter.text"/> </div>
				<nav:pagination top="false" supportShowPaged="${isShowPageAllowed}" supportShowAll="${isShowAllAllowed}" searchPageData="${searchPageData}" searchUrl="${currentPageURL}"  numberPagesShown="${numberPagesShown}"/>
				<ul class="product-listing product-list col-xs-12">
					<c:forEach items="${searchPageData.results}" var="product" varStatus="status">
					<product:productListerItem product="${product}"/>
					</c:forEach>
				</ul>
				<nav:pagination top="false" supportShowPaged="${isShowPageAllowed}" supportShowAll="${isShowAllAllowed}" searchPageData="${searchPageData}" searchUrl="${currentPageURL}"  numberPagesShown="${numberPagesShown}"/>
			</c:when>
			<c:otherwise>
				<div class="col-xs-12">
					<div class="paginationBar top clearfix">
						<ycommerce:testId code="searchResults_productsFound_label">
							<div class="totalResults"><spring:theme code="search.page.totalResults" arguments="${searchPageData.pagination.totalNumberOfResults}"/></div>
						</ycommerce:testId>
					</div>
				</div>
			</c:otherwise>	
		</c:choose>
	</div>
</div>
</template:page>