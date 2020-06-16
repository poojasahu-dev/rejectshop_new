<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>

<template:page pageTitle="${pageTitle}">
		
		<div id="gallery" class="carousel slide" data-ride="carousel">
			<cms:pageSlot position="Section1" var="feature">
				<c:set var="trscarousel" value="homepc" scope="session"/>
					<cms:component component="${feature}" class="col-xs-4 col-sm-4 span-6 section1 cms_disp-img_slot"/>
				<c:set var="trscarousel" value="" scope="session"/>
			</cms:pageSlot>
	</div>
			<div class="row">
				<cms:pageSlot position="Section2A" var="feature">
					<cms:component component="${feature}" element="div" class="span-17 zone_a thumbnail_detail first_top_banner" />
				</cms:pageSlot>
				<cms:pageSlot position="Section2B" var="feature">
					<cms:component component="${feature}"  element="div" class="span-6 zone_b thumbnail_detail second_top_banner" />
				</cms:pageSlot>
			</div>
	

		<cms:pageSlot position="Section3" var="feature">
			<cms:component component="${feature}" class="span-24 section3 cms_disp-img_slot" />
		</cms:pageSlot>


		<div class="no-space">
		
			<div class="row">
				<cms:pageSlot position="Section4" var="feature" >
					<cms:component component="${feature}"  element="div" class="col-xs-6 col-sm-3"/>
				</cms:pageSlot>
			</div>
			
			<cms:pageSlot position="Section5" var="feature">
			<c:set var="trscarousel" value="homepc" scope="session"/>
				<cms:component component="${feature}" />
			<c:set var="trscarousel" value="" scope="session"/>
			</cms:pageSlot>
		</div>
		
</template:page>
