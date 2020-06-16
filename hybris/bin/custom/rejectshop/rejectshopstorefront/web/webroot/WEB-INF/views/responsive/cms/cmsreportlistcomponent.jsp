<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>

<c:set var="showAll"
	value="${(empty numberOfLatestReports or numberOfLatestReports lt 1 or empty showArchived)? true : false }" />
<c:choose>
	<c:when test="${showAll }">
		<c:set var="reportsTitle" value="${title }"></c:set>
	</c:when>
	<c:otherwise>
		<c:choose>
			<c:when test="${!showArchived }">
				<c:url var="reportsLinkURL" value="${pageLabel}/archives"></c:url>
				<c:set var="reportsLinkLabel" value="reports.archives.link"></c:set>
				<c:set var="reportsTitle" value="${title }"></c:set>
			</c:when>
			<c:otherwise>
				<c:url var="reportsLinkURL" value="${pageLabel}"></c:url>
				<c:set var="reportsLinkLabel" value="reports.recent.link"></c:set>
				<c:set var="reportsTitle" value="${archivesTitle }"></c:set>
			</c:otherwise>
		</c:choose>
	</c:otherwise>
</c:choose>

<div class="reportlist">
	<c:if test="${reportsTitle ne null}">
	<div class="title">
		<h1>${reportsTitle}</h1>
	</div>
	</c:if>
	<div>
		<c:if test="${not showAll }">
			<div class="reportslink">
				<a href="${reportsLinkURL }"><spring:theme
						code="${reportsLinkLabel }" /></a>
			</div>
		</c:if>
		<div>
			<c:if test="${not empty reportComponents }">
				<c:set value="${ycommerce:sortListByFinancialYear(reportComponents)}" var="sortedList" />
				<c:choose>
					<c:when test="${showAll }">
						<c:forEach items="${sortedList}" var="component">
							<cms:component component="${component}" element="li"
								evaluateRestriction="true" />
						</c:forEach>
					</c:when>
					<c:otherwise>
						<c:choose>
							<c:when test="${!showArchived }">
								<c:forEach items="${sortedList}" var="component"
									varStatus="status" begin="0"
									end="${numberOfLatestReports - 1 }">
									<cms:component component="${component}" element="ul"
										evaluateRestriction="true" />
								</c:forEach>
							</c:when>
							<c:otherwise>
								<c:forEach items="${sortedList}" var="component"
									varStatus="status" begin="${numberOfLatestReports }">
									<cms:component component="${component}" element="ul"
										evaluateRestriction="true" />
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</c:otherwise>
				</c:choose>
			</c:if>
		</div>
	</div>
</div>



