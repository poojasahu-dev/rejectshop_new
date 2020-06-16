<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template" %>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="theme" tagdir="/WEB-INF/tags/shared/theme" %>
<%@ taglib prefix="nav" tagdir="/WEB-INF/tags/responsive/nav" %>
<%@ taglib prefix="savvyCategorySlider" tagdir="/WEB-INF/tags/responsive/savvyCategorySlider" %>
<%@ taglib prefix="component" tagdir="/WEB-INF/tags/shared/component" %>
<%@ taglib prefix="format" tagdir="/WEB-INF/tags/shared/format" %>
<%@ taglib prefix="product" tagdir="/WEB-INF/tags/responsive/product" %>

<script type="text/javascript" src="${commonResourcePath}/js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="/_ui/responsive/common/js/acc.savvyCategorySlider.js"></script>
<link rel="stylesheet" type="text/css" media="all" href="${commonResourcePath}/css/categorySlider.css"/>
<script type="text/javascript" src="/_ui/responsive/common/js/jquery.mobile.custom.min.js"></script>
<script type="text/javascript" src="/_ui/responsive/common/js/modernizr.js"></script>

<template:page pageTitle="${pageTitle}">
<div class="container">	
	
	<savvyCategorySlider:sliderImage/>
	
	<div class="row m-y-3">
	    <p class="col-lg-12 themeText"><spring:theme code="savvyTableDecorator.display.fullRange.text"></spring:theme></p>
	</div>
	
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
	
		
	
		<cms:pageSlot position="ProductListSlot" var="feature">
			<cms:component component="${feature}" element="div" class="product-list-wrapper"/>
		</cms:pageSlot>
	</div>

	<div class="row">
		<div class=" col-xs-10 col-lg-10 backToLink_class"><a href="#" class="links" id="back_to_top">Back to Top<span class="top_up_arrow"></span></a></div>
	</div>
</div>
</template:page>