<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ attribute name="searchPageData" required="true" type="de.hybris.platform.commerceservices.search.pagedata.SearchPageData" %>
<%@ attribute name="locationQuery" required="false" type="java.lang.String" %>
<%@ attribute name="geoPoint" required="false" type="de.hybris.platform.commerceservices.store.data.GeoPoint" %>
<%@ attribute name="numberPagesShown" required="true" type="java.lang.Integer" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="theme" tagdir="/WEB-INF/tags/shared/theme" %>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>
<%@ taglib prefix="store" tagdir="/WEB-INF/tags/responsive/store" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="nav" tagdir="/WEB-INF/tags/responsive/nav" %>
<%@ taglib prefix="action" tagdir="/WEB-INF/tags/responsive/action" %>

<c:url value="/store-finder" var="storeFinderFormAction" />

<div class="store-finder js-store-finder" data-url="${storeFinderFormAction}"	>
	<ycommerce:testId code="storeFinder">
		<div class="row">
				<%-- <div class="store-finder-pagination">
					<div class="col-xs-12 col-md-6">
						<div class="row">
							<div class="col-xs-7">
								<span class="js-store-finder-pager-item-from"></span>-
								<span class="js-store-finder-pager-item-to"></span>
								<spring:theme code="storeFinder.pagination.from" text="from"></spring:theme>
								<span class="js-store-finder-pager-item-all"></span>
								<spring:theme code="storeFinder.pagination.stores" text="stores found"></spring:theme>	
							</div>
							<div class="col-xs-5 pagination-btns">	
								<button class="pagiButton js-store-finder-pager-next pull-right" type="button"><spring:theme code="storeFinder.pagination.next" text="Next"></spring:theme><span class="glyphicon glyphicon-menu-right"></span></button>					 
								<button class="pagiButton js-store-finder-pager-prev pull-right" type="button"><span class="glyphicon glyphicon-menu-left"></span><spring:theme code="storeFinder.pagination.previous" text="Prev"></spring:theme></button>
							</div>
						</div>
					</div>
				</div> --%>

				<div class="store-finder-panel">
					<div class="store-finder-navigation col-md-6 col-sm-12">
						<ul class="store-finder-navigation-list js-store-finder-navigation-list">
							<li class="loading"><span class="glyphicon glyphicon-repeat"></span></li>
						</ul>
					</div>
				
					<div class="store-finder-details js-store-finder-details col-md-6 col-sm-12">
						<div><button class="btn btn-default store-finder-details-back js-store-finder-details-back"><span class="glyphicon glyphicon-chevron-left"></span> <spring:theme code="pickup.in.store.back.to.results" text="Back"></spring:theme></button></div>
						<div class="store-finder-details-image js-store-image"></div>
						<div class="store-finder-details-info mapbutton">
							<div class="store-finder-details-info-displayName js-store-displayName"></div>
							
							<!-- <div class="store-finder-details-info-closed js-store-closed"></div> -->
							<div class="store-finder-details-info-address">
								<div class="js-store-line1"></div>
								<div class="js-store-line2"></div>
								<div><span class="js-store-town"></span> <span class="js-store-state"></span> <span class="js-store-postalCode"></span></div>
						<span class="phonetitle">Phone:</span>		<div class="js-store-phone"></div>
								
							</div>
						</div>
						<hr>
						<div id="maphide">
						<div class="store-finder-map js-store-finder-map"></div>
						</div>
						<hr>
						<div class="timing">
					
						<div class="store-finder-details-openings mapbutton">
							<dl class="dl-horizontal js-store-openings"></dl>
							<dl class="dl-horizontal js-store-specialOpenings"></dl>
							<%-- <div class="store-finder-details-openings-title"><spring:theme code="storeDetails.table.features" /></div> --%>
							<ul class="js-store-features"></ul>
						</div>
						</div>
					</div>
					
				</div>
		</div>

		<div class="store-finder-pagination row">
				<div class="col-xs-12 col-md-6">
					<div class="row">
						<div class="col-xs-7">
							<span class="js-store-finder-pager-item-from"></span>-
							<span class="js-store-finder-pager-item-to"></span>
							<spring:theme code="storeFinder.pagination.from" text="from"></spring:theme>
							<span class="js-store-finder-pager-item-all"></span>
							<spring:theme code="storeFinder.pagination.stores" text="stores found"></spring:theme>	
						</div>
						<div class="col-xs-5 pagination-btns">	
							<button class="pagiButton js-store-finder-pager-next pull-right" type="button"><spring:theme code="storeFinder.pagination.next" text="Next"></spring:theme><span class="glyphicon glyphicon-menu-right"></span></button>					 
							<button class="pagiButton js-store-finder-pager-prev pull-right" type="button"><span class="glyphicon glyphicon-menu-left"></span><spring:theme code="storeFinder.pagination.previous" text="Prev"></spring:theme></button>
						</div>
					</div>
				</div>
		</div>
	</ycommerce:testId>
</div>


