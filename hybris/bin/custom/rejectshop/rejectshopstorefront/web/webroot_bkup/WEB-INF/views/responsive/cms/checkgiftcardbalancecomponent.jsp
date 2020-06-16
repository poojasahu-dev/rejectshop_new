<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="theme" tagdir="/WEB-INF/tags/shared/theme"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/responsive/common" %>


<a class="termsAndConditionsPopup giftcardlink" href="${component.url}" target="_blank">
	<div class="giftcard">
		<h1>
			${component.title}
		</h1>
		<c:if test="${not empty component.media}">
			<img title="${component.title}" alt="${component.title}" src="${component.media.url}" />
		</c:if>
		<p>${component.content}</p>
		<span class="checkbalance">
			${component.buttonLabel}
		</span>
		<span class="clear">&nbsp;</span>
	</div>
</a>