<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template" %>
<%@ taglib prefix="nav" tagdir="/WEB-INF/tags/responsive/nav" %>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/responsive/common" %>
<%@ taglib prefix="storepickup" tagdir="/WEB-INF/tags/responsive/storepickup" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<template:page pageTitle="${pageTitle}">
	<div class="row">		
		<cms:pageSlot position="Section1" var="feature">
			<cms:component component="${feature}" element="div" class="col-xs-12 yComponentWrapper"/>
		</cms:pageSlot>		
	</div>
	<div class="row">
		<cms:pageSlot position="ProductLeftRefinements" var="feature">
			<div class="col-xs-3">
				<div class="row">
					<cms:component component="${feature}" element="div" class="col-xs-12 yComponentWrapper"/>
				</div>
			</div>
		</cms:pageSlot>
	
			<div class="HeroBanner page-title">
				<div class="details">
					<h1 class="title">${categoryName}</h1>
					<c:if test="${ not empty basecategorybanner}"> <img class="categorybanner hidden-xs hidden-sm " src="${basecategorybanner}"> </c:if>
					<p class="content hidden-xs hidden-sm">${categoryDesc}</p>
				</div>
			</div>
	
		<cms:pageSlot position="ProductListSlot" var="feature">
			<cms:component component="${feature}" element="div" class="product-list-wrapper"/>
		</cms:pageSlot>
	</div>

			<div class="row">
				<cms:pageSlot position="SectionCarousel" var="feature">
					<cms:component component="${feature}" />
				</cms:pageSlot>
			</div>
	<div class="row">
		<div class=" col-xs-10 col-lg-10 backToLink_class"><a href="#" class="links" id="back_to_top">Back to Top<span class="top_up_arrow"></span></a></div>
	</div>

</template:page>
