<%@ tag trimDirectiveWhitespaces="true"%>
<%@ attribute name="contentId" required="false" rtexprvalue="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/desktop/template"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<template:page pageTitle="${pageTitle}">
	<!--  pageTitle="${contentId}" -->
	<div class="centerWide span-24" id="centerWide">
	
		<cms:pageSlot var="component" position="Breadcrumbs">
			<cms:component component="${component}" />
		</cms:pageSlot>
		<div class="leftNavLinks">
			<cms:pageSlot var="component" position="LeftNavigationSection">
				<cms:component component="${component}" />
			</cms:pageSlot>
			<div class="clear"></div>
		</div>
		
		<div class="center left">
			<cms:pageSlot var="component" position="CenterContent">
				<cms:component component="${component}" />
				
			</cms:pageSlot>
			
			
			<div class="leftcenter">
		<jsp:doBody/>
			<div class="clear"></div>
		</div>
		<div class="right">
			<cms:pageSlot var="component" position="RightContent">
				<cms:component component="${component}" />
			</cms:pageSlot>
			<div class="clear"></div>
		</div>
	</div>
</div>
	
</template:page>