<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="cms" uri="/cms2lib/cmstags/cmstags.tld"%> --%>
  <%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div id="${component.uid}" class="${component.style}">
	<c:if test="${not empty component.title}">
		<h3>${component.title}</h3>
	</c:if>
	<c:if test="${not empty cmsComponents}">
	<div class="container">
		<ul>
			<c:forEach var="comp" items="${cmsComponents}">
				<li><cms:component component="${comp}" /></li>
			</c:forEach>
		</ul>
	</div>
	</c:if>
</div>  