<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/desktop/common" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="formElement" tagdir="/WEB-INF/tags/desktop/formElement" %>
<script type="text/javascript">
   var res = document.location.href.split("?");
	res=res[0].split("/");
	var pageFrom = res[res.length-1]=="" ? "homepage":res[res.length-1];
</script>
<title>Gift Cards T&C | The Reject shop</title>


<c:url value="/giftcards/acceptGiftCardsTermsAndConditions" var="acceptGiftCardsTermsAndConditionsUrl" />
<c:url value="/giftcards" var="giftCardsUrl" />

<div class="termsAndConditions">
	<div id="globalMessages">
		<common:globalMessages/>
	</div>
	<div id="mainSection">
		<div class = "mainContent">
			<cms:pageSlot position="MainSection" var="feature" element="div">
				<cms:component component="${feature}" element="div"/>
			</cms:pageSlot>
		</div>
		
	</div>
	<div class="links">
		<c:choose>
			<c:when test="${allowAccept}">
				<form:form method="GET" action="${acceptGiftCardsTermsAndConditionsUrl }" id="acceptTermsAndConditionsForm" commandName="termsAndConditionsForm">
					<form:checkbox id="termsCheck" path="termsCheck" onchange="termsCheckChanged();"/>
					<label for="termsCheck"><spring:theme code="termsAndConditions.toggle.accept"/></label>
					<br/>
					<br/>

					<a id = "acceptTermsAndconditionsLink" href = "javascript: void(0);" onclick="acceptGiftCardsTermsAndConditions();" class = "notaccepted" >

						<spring:theme code="termsAndConditions.link.accept"/></a>
				</form:form>
			</c:when>
			<c:otherwise>
				<br/>
				<a href="javascript:void(0)" onclick = "$.colorbox.close();"><spring:theme code="termsAndConditions.link.ok"/></a>
			</c:otherwise>
		</c:choose>
	</div>
</div>
