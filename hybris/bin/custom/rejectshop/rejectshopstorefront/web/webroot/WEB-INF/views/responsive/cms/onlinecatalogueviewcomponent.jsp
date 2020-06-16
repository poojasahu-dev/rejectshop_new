<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="theme" tagdir="/WEB-INF/tags/shared/theme"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<div class="catlog" onclick="location.href='${component.url}';">
			<h1>
				${component.title}
			</h1>
			<c:if test="${not empty component.media}">
				<img title="${component.title}" alt="${component.title}" src="${component.media.url}" />
			</c:if>
			<p>${component.content}</p>
			<div class="cataloglink">
				<a href="${component.url}">${component.buttonLabel}</a>
			</div>
			<span class="clear">&nbsp;</span>
	</div>
