<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ attribute name="store" required="false" type="de.hybris.platform.commercefacades.storelocator.data.PointOfServiceData"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:url value="${store.name}+ ${store.address.line1},${store.address.town} , ${store.address.state} , ${store.address.postalCode} , ${store.address.country.name}" var="mapsQuerys" />
<div class="storeMap">	
<c:if test="${store ne null and store.geoPoint.latitude ne null and store.geoPoint.longitude ne null}">

<div class="store_map_details" id="map_canvas"
			data-latitude = '${store.geoPoint.latitude}'
			data-longitude = '${store.geoPoint.longitude}'
			data-name='${store.address.town}'
			data-stores= '{"id":"0","latitude":"${fn:escapeXml(store.geoPoint.latitude)}","longitude":"${fn:escapeXml(store.geoPoint.longitude)}","name":"${fn:escapeXml(store.name)}","addressLine1":"${fn:escapeXml(store.address.line1)}","addressLine2":"${fn:escapeXml(store.address.line2)}","town":"${fn:escapeXml(store.address.town)}","state":"${fn:escapeXml(store.address.state)}","postalCode":"${fn:escapeXml(store.address.postalCode)}","country":"${fn:escapeXml(store.address.country.name)}"}'></div>
	<div class="storeGetDirection"><a class="getdirection"href='https://www.google.com.au/maps/dir//${mapsQuerys}' target='_blank'">Get Directions </a></div>

	</c:if>

	<c:if test="${not empty store.storeContent}">
		<div class="storeMessageSection">
			<div class="storeSpecificMessage" >${store.storeContent}</div>
		</div>
	</c:if>
</div>

 <%-- 
 <div id="store_detail" class="js-store-finder-map-next" data-latitude = '${store.geoPoint.latitude}' data-longitude = '${store.geoPoint.longitude}'>

</div> --%>