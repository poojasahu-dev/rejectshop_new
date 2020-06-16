<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ attribute name="pageTitle" required="false" rtexprvalue="true"%>
<%@ attribute name="pageCss" required="false" fragment="true"%>
<%@ attribute name="pageScripts" required="false" fragment="true"%>
<%@ attribute name="hideHeaderLinks" required="false"%>

<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="header"
	tagdir="/WEB-INF/tags/responsive/common/header"%>
<%@ taglib prefix="footer"
	tagdir="/WEB-INF/tags/responsive/common/footer"%>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/responsive/common"%>
<%@ taglib prefix="cart" tagdir="/WEB-INF/tags/responsive/cart" %>

<template:master pageTitle="${pageTitle}">

	<jsp:attribute name="pageCss">
		<jsp:invoke fragment="pageCss" />
	</jsp:attribute>

	<jsp:attribute name="pageScripts">
		<jsp:invoke fragment="pageScripts" />
	</jsp:attribute>

	<jsp:body>
		<div class="branding-mobile hidden-md hidden-lg">
			<div class="container">
				<div class="row">
					<div class="col-xs-12 js-mobile-logo">
						<%--populated by JS acc.navigation--%>
					</div>
				</div>
			</div>
		</div>
		<main data-currency-iso-code="${currentCurrency.isocode}">
			<spring:theme code="text.skipToContent" var="skipToContent" />
			<a href="#skip-to-content" class="skiptocontent" data-role="none">${skipToContent}</a>
			<spring:theme code="text.skipToNavigation" var="skipToNavigation" />
			<a href="#skiptonavigation" class="skiptonavigation" data-role="none">${skipToNavigation}</a>


			<header:header hideHeaderLinks="${hideHeaderLinks}" />


			
			
			<a id="skip-to-content"></a>
		
			<div class="container">
				<common:globalMessages />
				<cart:cartRestoration />
				<jsp:doBody />
			</div>

			<footer:footer />
		</main>

	</jsp:body>

</template:master>
<script type="application/javascript">
	$('#socialComponent').find('a').bind('click', function () {
		if ((this.href).indexOf("facebook")>0){
			tealiumTagEvent('followFacebook');
		}
		if ((this.href).indexOf("pin")>0){
			tealiumTagEvent('followPinit');
		}
		if ((this.href).indexOf("instagram")>0){
			tealiumTagEvent('followinstagram');
		}
		if ((this.href).indexOf("twitter")>0){
			tealiumTagEvent('followtwitter');
		}
	});

</script>
