<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="format" tagdir="/WEB-INF/tags/shared/format" %>
<%@ taglib prefix="theme" tagdir="/WEB-INF/tags/shared/theme" %>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags" %>

<div class="featuredProds work-masonry-thumb">
	<div class="title">
		<h2 class="title_head"><c:out value="${title}"></c:out></h2>
	</div>
	<div class="contents">
		<c:forEach items="${featuredProducts}" var="productComponent" varStatus="status">
			<div class="span-17 ${(status.count == 2) ? 'last' : ''}">
				<cms:component component="${productComponent}"/>
			</div>
		</c:forEach>
	</div>
</div>
