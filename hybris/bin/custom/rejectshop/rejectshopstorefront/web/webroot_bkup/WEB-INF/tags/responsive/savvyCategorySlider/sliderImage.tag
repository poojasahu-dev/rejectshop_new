<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="component" tagdir="/WEB-INF/tags/shared/component"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="product" tagdir="/WEB-INF/tags/responsive/product"%>
<%@ taglib prefix="format" tagdir="/WEB-INF/tags/shared/format"%>
<%@ taglib prefix="theme" tagdir="/WEB-INF/tags/shared/theme"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="row">
	<div class="row m-t-2">
		<p class="col-lg-12 tableWearText"><spring:theme code="savvyTableDecorator.display.heading.text"></spring:theme></p>
	</div>

	<c:forEach var="subCatList" items="${subCatList}" varStatus="category">

		<figure
			class="col-xs-12 col-sm-12 col-md-12 col-lg-12 cd-image-container"
			${category.first ? '' : 'style = "display:none"'}
			id="imageID${subCatList.code}">
			<c:set var="mediaLegth" value="${fn:length(subCatList.medias)}" />
			<c:forEach var="media" items="${subCatList.medias}" varStatus="image">
				<c:if test="${image.first eq true}">
					<c:set var="first" value="${media.url}" />
				</c:if>
				<c:if test="${image.last eq true}">
					<c:set var="last" value="${media.url}" />
				</c:if>

			</c:forEach>

			<c:choose>
				<c:when test="${mediaLegth > 1}">
					<img class="slider-container" src="${first}" alt="Original Image">

					<span class="cd-image-label" data-type="original"></span>

					<div class="cd-resize-img">
						<!-- the resizable image on top -->

						<img class="slider-container" src="${last}" alt="Modified Image">


						<span class="cd-image-label" data-type="modified"></span>
					</div>

					<span class="cd-handle"></span>
					<!-- slider handle -->
				</c:when>
				<c:otherwise>


					<img class="slider-container" src="${last}" alt="Original Image">

					<span class="cd-image-label" data-type="original"></span>

				</c:otherwise>
			</c:choose>
		</figure>
		<!-- cd-image-container -->

		<c:set var="first" value="" />
		<c:set var="last" value="" />

	</c:forEach>
</div>
<div class="row m-y-2">
	<p class="col-lg-12 themeText">
		<spring:theme code="savvyTableDecorator.display.theme.text"></spring:theme>
	</p>
</div>
<div class="row buttons-center-align button-wrapper">
	<c:forEach var="subCatList" items="${subCatList}" varStatus="category">
		<button id="decoratingStyleButtonID${subCatList.code}"
			${category.first ? 'class = "decoratingStyle active"' : 'class = "decoratingStyle"'}
			onclick="decoratingStyleClickfunction('${subCatList.code}')">${subCatList.name}</button>


	</c:forEach>
</div>
<%-- 
<div class="row m-y-3">
	<p class="col-lg-12 paragraph-text">
		<spring:theme code="savvyTableDecorator.display.message" />
	</p>
</div> --%>

<div class="row">
				<cms:pageSlot position="savvyCategorySliderCarouselSlot" var="feature">
					<cms:component component="${feature}" />
				</cms:pageSlot>
			</div>



