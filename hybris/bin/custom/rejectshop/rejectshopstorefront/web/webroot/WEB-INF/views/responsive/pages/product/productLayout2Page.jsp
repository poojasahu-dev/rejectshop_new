<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="product" tagdir="/WEB-INF/tags/responsive/product"%>

<template:page pageTitle="${pageTitle}">
	<product:productDetailsPanel />
<%-- 	<product:productPageTabs /> --%>
	<div class="productSocialMedia" style="float:left;">
				<cms:pageSlot var="component" position="LeftContent">
					<cms:component component="${component}" />
				</cms:pageSlot>
				<div class="clear"></div>
			</div>
	<cms:pageSlot position="CrossSelling" var="comp" element="div" class="span-24">
		<cms:component component="${comp}"/>
	</cms:pageSlot>
	<cms:pageSlot position="UpSelling" var="comp">
		<cms:component component="${comp}"/>
	</cms:pageSlot>
</template:page>