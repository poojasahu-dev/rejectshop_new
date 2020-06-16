<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ attribute name="errorNoResults" required="true" type="java.lang.String"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="theme" tagdir="/WEB-INF/tags/shared/theme"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/responsive/common"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="formElement" tagdir="/WEB-INF/tags/responsive/formElement"%>

<c:url value="/store-finder" var="storeFinderFormAction" />

<div class="row">
	<div class="col-lg-8">
		<div class="headline"><spring:theme code="storeFinder.find.a.store" /></div>
		<span id="query" data-q="${q}"></span>
		<div class="store-finder-search row">
				<div class="col-sm-6">
					<form:form action="${storeFinderFormAction}" method="get" commandName="storeFinderForm">
						<ycommerce:testId code="storeFinder_search_box">
							<div class="input-group">
								<formElement:formInputBox idKey="storelocator-query" labelKey="storelocator.query" path="q" labelCSS="sr-only" inputCSS="form-control js-store-finder-search-input" mandatory="true"  placeholder="pickup.search.message" />
								<span class="input-group-btn">
									<button class="btn btn-new-store" type="submit" data-search-empty="<spring:theme code="storelocator.error.no.results.subtitle" text="Check that you entered a valid postcode or place name."/>">
										<span class="glyphicon glyphicon-search"></span>
									</button>
								</span>
							</div>
						</ycommerce:testId>
					</form:form>
				</div>
				<div class="col-sm-6">
					<ycommerce:testId code="storeFinder_nearMe_button">
						<button  onclick='utag.link({"event_action" : "click", "event_category" : "Interactions", "event_label" : "customer_support", "event_name" : "find_stores_near_me" })' id="findStoresNearMe" class="" type="button" disabled>
							<spring:theme code="storeFinder.findStoresNearMe"/>
						</button>
					</ycommerce:testId>
				</div>
		</div>
	</div>
</div>