<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<title>The Reject Shop </title>
</head>

<c:url value="/" var="homePageUrl" />

	<div class="global-alerts">
		<div class="alert alert-info" role="alert">
			<spring:theme code="text.page.message.underconstruction" text="Click on link below to continue"/>
		</div>
	</div>
	<div class="error-page">
		<a class="btn btn-default js-shopping-button" href="${homePageUrl}">
			<spring:theme text="Continue Shopping" code="general.continue.shopping"/>
		</a>
	</div>


</html>
 