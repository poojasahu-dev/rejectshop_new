<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template" %>
<%@ taglib prefix="product" tagdir="/WEB-INF/tags/responsive/product" %>
<%@ taglib prefix="cart" tagdir="/WEB-INF/tags/responsive/cart" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/responsive/common" %>

<template:page pageTitle="${pageTitle}">
	
	<c:url value="/" var="homePageUrl" />


	<cms:pageSlot position="MiddleContent" var="comp" >
		<cms:component component="${comp}"/>
	</cms:pageSlot>
	
	<div class="error-page">
		<img src="${commonResourcePath}/images/errorBanner.jpg">
		<H1 align="center" style="font-family: 'AvantGardeGothicITCW01D 731075';">Did you just break the internet!?</H1>
		<H2 align="center" style="font-family: 'AvantGardeGothicITCW01D 731075';">Oh no, wait -  it's just a missing page</H2>
		<h2 align="center" style="padding-bottom: 10px;font-family: 'AvantGardeGothicITCW01D 731075';">Don't waste time hanging here, head back to our <a style="background: transparent;color: #e2001a;" href="${homePageUrl}">homepage</a> and try again</H2>
	</div>

</template:page>