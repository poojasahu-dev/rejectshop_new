<%-- <%@ page trimDirectiveWhitespaces="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags" %>
<%@ taglib prefix="cms" uri="/cms2lib/cmstags/cmstags.tld"%> --%>

 <%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="spaceName" value="${component.style} ${component.layout}">

</c:set>
<div id="${component.uid}" class="${spaceName}">
	<c:if test="${not empty component.title}">
		<h3><c:if test="${component.uid == 'emailClubNavigation'}"><img src="${commonResourcePath}/images/becomesavvyshopper.png"></c:if> ${component.title}</h3>
	</c:if>
	<c:if test="${external}"><h3> ${title}</h3></c:if>
	<c:if test="${not external}">
	<c:if test="${component.uid == 'footerNavigation'}"><div class="container"></c:if>
	<ul>
		<c:forEach var="comp" items="${cmsComponents}">
			<li><cms:component component="${comp}"/>
		</c:forEach>
	</ul>
	<c:if test="${component.uid == 'footerNavigation'}"></div></c:if>
	</c:if>
</div> 