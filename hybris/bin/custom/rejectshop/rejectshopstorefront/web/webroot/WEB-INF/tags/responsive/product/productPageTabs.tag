<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="product" tagdir="/WEB-INF/tags/responsive/product"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>

<div class="tabs js-tabs tabs-responsive new_tab_responsive">

	<div class="tabhead">
		<a href=""><spring:theme code="product.product.details" /></a>
	</div>	
	<div class="tabbody">
		<product:productDetailsTab product="${product}" />
		
		<%--<span class="tab-title"><spring:theme code="product.product.spec" /></span>
		<product:productDetailsClassifications product="${product}" />
		--%>
		<span class="tab-title"><spring:theme code="review.reviews" /></span>
		<product:productPageReviewsTab product="${product}" />
	</div>
	
	<%-- <div id="tabreview" class="tabhead">
		<a href=""><spring:theme code="review.reviews" /></a>
	</div> --%>	

	<cms:pageSlot position="Tabs" var="tabs">
		<cms:component component="${tabs}" />
	</cms:pageSlot>

</div>
