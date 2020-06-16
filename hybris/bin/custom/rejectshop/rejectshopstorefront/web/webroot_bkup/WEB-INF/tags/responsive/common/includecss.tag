<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ attribute name="cssPath" required="true" type="java.lang.String" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><%@ taglib prefix="g" uri="http://granule.com/tags/accelerator"%>

<c:choose>
	<c:when test="${granuleEnabled}">
		
			<link rel="stylesheet" type="text/css" media="all" href="${cssPath}" />
		
	</c:when>
	<c:otherwise>
		<link rel="stylesheet" type="text/css" media="all" href="${cssPath}" />
	</c:otherwise>
</c:choose>

