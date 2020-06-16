<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags" %>
<%@ taglib prefix="breadcrumb" tagdir="/WEB-INF/tags/desktop/nav/breadcrumb" %>
<%@ taglib prefix="savvyshopper" tagdir="/WEB-INF/tags/responsive/savvyshopper" %>

<template:page pageTitle="${pageTitle}">
<div class="row">
<div class="giftcardpage">
	<div class="col-xs-12 col-sm-12 col-md-12">
		 
			<cms:pageSlot position="Section1" var="feature">
		 
				<cms:component component="${feature}" element="div"/>
			</cms:pageSlot>
		 <c:if test="${not empty announcement}">
					<div class="span-16">
						<savvyshopper:announcement announcement="${announcement}"/>
					</div>
				</c:if>
		  
	</div>
	<div class="hidden-xs hidden-sm col-md-4">	
 
			<cms:pageSlot position="Section3" var="feature" element="div" class="">
				<cms:component component="${feature}"/>
			</cms:pageSlot>
		 
	</div>		
</div>
</div>
</template:page>
