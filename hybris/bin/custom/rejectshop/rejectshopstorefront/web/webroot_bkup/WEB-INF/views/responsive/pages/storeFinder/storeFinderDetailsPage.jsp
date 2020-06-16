<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/responsive/common" %>
<%@ taglib prefix="store" tagdir="/WEB-INF/tags/responsive/store" %>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<template:page pageTitle="${store.displayName} | ${siteName}">
	<div id="globalMessages">
		<common:globalMessages/>
	</div>
	<div id="storeDetail" class="row">
		<div class="detailPane col-sm-6 col-md-6 col-xs-12">
			<div class="headline">
			<spring:theme code="storeDetails.title" />
			</div>
			<ycommerce:testId code="storeFinder_storeDetails_label">
				<store:storeDetails store="${store}"/>
				<%-- <store:storeImage store="${store}" format="store"/> --%>
			</ycommerce:testId>
		
			<a class="backtosearch"  href='${request.contextPath}/store-finder' onclick="localStorage.setItem('lastPin',location.search.split('q=').slice(1,2));localStorage.setItem('back',true) || localStorage.setItem('lastPin','${store.displayName}');localStorage.setItem('back',true) "> Find Other Stores Near Me </a>
		</div>
		<!--<a class="backtosearch"  href='${request.contextPath}/store-finder' onclick="localStorage.setItem('lastPin',location.search.split('q=').slice(1,2));localStorage.setItem('back',true) || localStorage.setItem('lastPin',location.pathname.split('/').reverse()[0]);localStorage.setItem('back',true) "> Find Other Stores Near Me </a>  -->
		
		<div class="storedetailmap col-sm-6 col-md-6 col-xs-12">
		<store:storeMap store="${store}"/>
	</div>
	
	</div>
</template:page>