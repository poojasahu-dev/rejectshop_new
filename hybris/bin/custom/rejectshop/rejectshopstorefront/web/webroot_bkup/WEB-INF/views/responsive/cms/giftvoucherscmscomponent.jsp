<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="theme" tagdir="/WEB-INF/tags/shared/theme"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/responsive/common" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>



<div class="container">
<div class="giftVouchers row">


		<div class="col-xs-6 col-sm-6 col-md-4 ">
			<c:if test="${not empty component.media}">
				<img title="${component.title}" alt="${component.title}" src="${component.media.url}" />
			</c:if>
		</div>
		<div id="giftVouchersLink" class="col-xs-6 col-sm-6 col-md-8 ">
			<div class="title">
				<h2>${component.title}</h2>
			</div>
			<p>${component.buttonText}</p> <br/>
			<c:choose>
				<c:when test="${fn:containsIgnoreCase(  component.buttonLabel, 'Balance')}">
					<a  class="termsAndConditionsvoucherPopup" href="giftcards/giftCardsTermsAndConditions">${component.buttonLabel}</a>
				</c:when>
				<c:otherwise>
					<a  class="termsAndConditionsvoucherPopup" href="giftcards/giftVouchersTermsAndConditions">${component.buttonLabel}</a>
				</c:otherwise>
			</c:choose>


		</div>

</div>
</div>