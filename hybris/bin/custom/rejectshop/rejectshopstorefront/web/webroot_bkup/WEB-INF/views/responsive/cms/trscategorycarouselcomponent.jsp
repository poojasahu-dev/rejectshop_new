<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="format" tagdir="/WEB-INF/tags/shared/format"%>
<%@ taglib prefix="product" tagdir="/WEB-INF/tags/responsive/product" %>

<%@ taglib prefix="component" tagdir="/WEB-INF/tags/shared/component"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>


<spring:htmlEscape defaultHtmlEscape="true" />
<div class="container">

	<c:choose>
		<c:when test="${not empty categoryData}">
			<div class="carousel-component"
				style="width: 100%; padding: 10px 30px;">
				<a class="btn prev"></a>
				<div class="carousel__component--headline">${fn:escapeXml(title)}</div>
				<c:choose>
					<c:when test="${component.popup}">
						<div id="owl-demo3"
							class="carousel js-owl-carousel js-owl-lazy-reference js-owl-carousel-reference four">
							<c:forEach items="${categoryData}" var="category">

								<c:url value="${category.url}" var="categoryQuickViewUrl" />
								<div class="carousel__item">
									<a href="${categoryQuickViewUrl}">
										<div class="carousel__item--thumb">
											 <img src="${category.image.url}" />
										</div>
										<div class="item-name">${fn:escapeXml(category.name)}</div>
									</a>
								</div>
							</c:forEach>
						</div>
					</c:when>
					<c:otherwise>
						<div
							class="carousel__component--carousel js-owl-carousel js-owl-default">
							<c:forEach items="${categoryData}" var="category">

								<c:url value="${category.url}" var="categoryUrl" />

								<div class="carousel__item">
									<a href="${categoryUrl}">
										<div class="carousel__item--thumb">
											<%-- <product:productPrimaryImage product="${product}"
												format="product" /> --%>
										</div>
										<div class="carousel__item--name">${fn:escapeXml(category.name)}</div>
										
									</a>
								</div>
							</c:forEach>
						</div>
					</c:otherwise>
				</c:choose>
				<a class="btn next"></a>
			</div>
		</c:when>

		<c:otherwise>
			<component:emptyComponent />
		</c:otherwise>
	</c:choose>

 </div>
