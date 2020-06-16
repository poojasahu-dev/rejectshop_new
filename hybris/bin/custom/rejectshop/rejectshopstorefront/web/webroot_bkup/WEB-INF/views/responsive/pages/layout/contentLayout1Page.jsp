<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags" %>
<%@ taglib prefix="breadcrumb" tagdir="/WEB-INF/tags/desktop/nav/breadcrumb" %>
<%@ taglib prefix="savvyshopper" tagdir="/WEB-INF/tags/responsive/savvyshopper" %>
<template:page pageTitle="${pageTitle}">

	<cms:pageSlot position="Section1" var="feature">
		<cms:component component="${feature}" element="div" class=""/>
	</cms:pageSlot>

	 <div class="row">
		<cms:pageSlot position="Section2A" var="feature" element="div" class="col-md-3">
			<cms:component component="${feature}"/>
		</cms:pageSlot>

		<cms:pageSlot position="Section2B" var="feature" element="div" class="col-md-9">
			<cms:component component="${feature}"/>
		</cms:pageSlot>
	</div>

 

	<cms:pageSlot position="Section3" var="feature" element="div" class="">
		<cms:component component="${feature}"/>
	</cms:pageSlot>
</template:page>
