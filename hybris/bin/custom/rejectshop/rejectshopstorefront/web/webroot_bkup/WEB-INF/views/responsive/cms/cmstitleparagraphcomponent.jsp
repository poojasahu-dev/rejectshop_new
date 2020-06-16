<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- work-masonry-thumb masonry-brick only take effect on home page -->
<div class="cmstitleprgrph work-masonry-thumb masonry-brick">
	<c:if test="${not empty title}">
		<c:choose>
			<c:when test="${not empty style}"><div class="${style} title"></c:when>
			<c:otherwise><div class="title"></c:otherwise>
		</c:choose>

			<h1>${title}</h1>
		</div>
	</c:if>
	<div class="contents">
		${content}
	</div>
</div>