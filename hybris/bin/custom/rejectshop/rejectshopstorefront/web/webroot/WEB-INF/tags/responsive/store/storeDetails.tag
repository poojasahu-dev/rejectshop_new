<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ attribute name="store" required="true" type="de.hybris.platform.commercefacades.storelocator.data.PointOfServiceData" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="theme" tagdir="/WEB-INF/tags/shared/theme" %>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="store" tagdir="/WEB-INF/tags/responsive/store" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="formElement" tagdir="/WEB-INF/tags/desktop/formElement"%>


<div class="detailSection">
	<p>Find great bargains at your ${store.displayName} store. The Reject Shop has a great range of products for your everyday needs, ranging from toiletries, cosmetics, homewares, personal care products, hardware, basic furniture, household cleaning products, kitchenware, confectionery and snack food. We also have lifestyle and seasonal merchandise - including seasonal gifts, cards and wrap, toys, leisure items and home decorations.</p>
	<p><a target="_blank" href="https://savvy.rejectshop.com.au/forms/entryFull.php?utm_source=website&utm_medium=storefinder&utm_campaign=entryfull">Sign up to become a Savvy Shopper</a> and receive weekly emails - be the first to know about what's new at your ${store.address.town}&nbsp;${store.address.state} store, catalogues and competitions.
		Check out our <a target="_blank" href="https://savvy.rejectshop.com.au/?utm_source=website&utm_medium=storefinder&utm_campaign=savvyblog">Savvy Blog</a> and get savvy with clever money saving ideas, creative hacks and great tips.
	</p>
<div class="detailSectionHeadline">${store.displayName}</div>
	<c:if test="${not empty store.address.line1 || not empty store.address.line2 ||
				  not empty store.address.town || not empty store.address.country.name ||
				  not empty store.address.postalCode}">
	<ul>
		<%-- <li><b> ${store.address.town} </b> </li> --%>
		<li>${store.address.line1}</li>
		<li>${store.address.line2}</li>
		<li>${store.address.town}</li>
		<li>${store.address.state} &nbsp; ${store.address.postalCode}  </li>
		
		<%-- <li>${store.address.country.name}</li> --%>
		
	</ul>
	</c:if>
</div>


<c:if test="${not empty store.description}">
	<div class="storeMessageSection">
		<div class="detailSectionHeadlineDistance">${store.description}</div>
	</div>
</c:if>

<c:if test="${not empty store.formattedDistance}">
	<div class="detailSection">
		<div class="detailSectionHeadlineDistance"><spring:theme code="storeDetails.table.distance" /></div>
		<div class="distanceDetails">
		<c:choose>
			<c:when test="${not empty locationQuery}">
				<spring:theme code="storeDetails.table.distanceFromSource" argumentSeparator="^" arguments="${store.formattedDistance}^${store.displayName}"/> 
			</c:when>
			<c:otherwise>
				<spring:theme code="storeDetails.table.distanceFromCurrentLocation" argumentSeparator="^" arguments="${store.formattedDistance}"/>
			</c:otherwise>
		</c:choose>
		</div>
	</div>
</c:if>


<c:if test="${not empty store.address.phone}">
	<div class="detailSection">
		<div class="detailSectionHeadlineDistance"><spring:theme code="storeDetails.table.telephone" /></div>
		<div class="telephone">${store.address.phone}</div>
	</div>
</c:if>

<c:if test="${not empty store.address.email}">
	<div class="detailSection">
		<div class="detailSectionHeadlineDistance"><spring:theme code="storeDetails.table.email" /></div>
		<a href="mailto:${store.address.email}">${store.address.email}</a>
	</div>
</c:if>

 <c:if test="${not empty store.openingHours}">
	<div class="detailSection">
		<div class="detailSectionHeadlineDistance"><spring:theme code="storeDetails.table.opening" /></div>
		<store:openingSchedule openingSchedule="${store.openingHours}" />
	</div>
</c:if>
 
 
 

<%-- 
<c:if test="${not empty store.openingHours.specialDayOpeningList}">
	<div class="detailSection">
		<div class="detailSectionHeadline"><spring:theme code="storeDetails.table.openingSpecialDays" /></div>
		<store:openingSpecialDays openingSchedule="${store.openingHours}" />
	</div>
</c:if> --%>
<c:if test="${not empty store.openingHours.specialDayOpeningList}">
	<div class="detailSection">
		<div class="detailSectionHeadlineDistance">Special Trading Hours</div>
		<table class="store-openings weekday_openings">
		<tbody>
			<c:forEach items="${store.openingHours.specialDayOpeningList}" var="specialDay">
				<tr> <td class="weekday_openings_day"> Date :</td> <td>${specialDay.formattedDate}</td> </tr>
				<%--<tr> <td class="weekday_openings_day"> Special Day:</td> <td>${specialDay.name}</td></tr> --%>
				 <c:if test="${specialDay.closed==true}">
					 <tr> <td class="weekday_openings_day">Hours:</td><td>Closed</td></tr>
				</c:if>
				<c:if test="${specialDay.closed==false}">
					 <tr> <td class="weekday_openings_day">Hours:</td><td>${specialDay.openingTime.formattedHour} - ${specialDay.closingTime.formattedHour}</td></tr>
				</c:if>
		   </c:forEach>
		</tbody>
		</table>
	</div>

</c:if>



<c:if test="${not empty store.features}">
	<div class="detailSection">
		<div class="detailSectionHeadlineDistance"><spring:theme code="storeDetails.table.features" /></div>
		<ul>
			<c:forEach items="${store.features}" var="feature">
				<li>${feature.value}</li>
			</c:forEach>
		</ul>
	</div>
</c:if>




