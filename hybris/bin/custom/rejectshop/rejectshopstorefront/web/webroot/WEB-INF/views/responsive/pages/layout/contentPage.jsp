<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags" %>
<%@ taglib prefix="breadcrumb" tagdir="/WEB-INF/tags/desktop/nav/breadcrumb" %>
  
<template:page pageTitle="${pageTitle}">
<div class="managementpage">
	<div class="row">
	  
		<div class="col-md-3 col-sm-4 col-xs-12">
		<cms:pageSlot position="Section1" var="feature">
			<cms:component component="${feature}" element="div" class="managementTeamPagesection1"/>
		</cms:pageSlot>
		</div>
		<div class="col-md-9 col-sm-8 col-xs-12">
		<cms:pageSlot position="Section3" var="feature" element="div" class="managementTeamPagesection2">
			<cms:component component="${feature}"/>
		</cms:pageSlot>
		</div>
	</div>	 
</div>
</template:page>
