<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>
<%@ taglib prefix="store" tagdir="/WEB-INF/tags/responsive/store" %>

<c:if test="${searchPageData ne null and !empty searchPageData.results}">
	{"total":${searchPageData.pagination.totalNumberOfResults},"data":[
	<c:forEach items="${searchPageData.results}" var="pos" varStatus="loopStatus">
		<c:set value="${ycommerce:storeImage(pos, 'cartIcon')}" var="storeImage"/>
		<c:url value="${pos.url}" var="storeUrl" scope="request"/>
		{
			"displayName" : "${pos.displayName}",
			"name" : "${pos.name}",
			"url" : "${pos.url}",
			"closed" : "${pos.closed}",
			"phone" : "${pos.address.phone}",
			"formattedDistance" : "${pos.formattedDistance}",
			"line1" : "${pos.address.line1}",
			"line2" : "${pos.address.line2}",
			"town" : "${pos.address.town}",
			"state" : "${pos.address.state}",
			"postalCode" : "${pos.address.postalCode}",
			"latitude" : "${pos.geoPoint.latitude}",
			"longitude" : "${pos.geoPoint.longitude}",
		<%-- 	 <c:if test="${not empty pos.openingHours}">
				"openings":<store:openingSchedule openingSchedule="${pos.openingHours}" />
			</c:if> --%>
			
			<%-- <c:if test="${not empty pos.openingHours.specialDayOpeningList}">
				"specialOpenings":<store:openingSpecialDays openingSchedule="${pos.openingHours}" />
			</c:if>  --%>
			<c:if test="${not empty pos.features}">
				"features" :[
						<c:forEach items="${pos.features}" var="feature" varStatus="featureNumber">
							"${feature.value}"<c:if test="${!featureNumber.last}">,</c:if>
						</c:forEach>
						],
					
			</c:if>
			"image" : "${storeImage.url}"
		}<c:if test="${!loopStatus.last}">,</c:if>
	</c:forEach>
	]}
</c:if>


