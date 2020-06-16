<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="theme" tagdir="/WEB-INF/tags/shared/theme"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/responsive/common" %>
 
  
 


<div class="giftCards">
	<div class="title">
		<h1>${component.title}</h1>
	</div>
	<c:if test="${not empty component.media}">
		<img class= "giftCardImage" title="${component.title}" alt="${component.title}" src="${component.media.url}" />
	</c:if>
		<div class="gift-wrapper">
			${component.content}
		</div>
			<div  id="giftCardsLink" class="gift-right-content">
			<p>${component.buttonText }</p> 

		</div>
</div>