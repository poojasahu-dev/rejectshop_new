<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ attribute name="locationQuery" required="false" type="java.lang.String" %>
<%@ attribute name="errorNoResults" required="true" type="java.lang.String"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="theme" tagdir="/WEB-INF/tags/shared/theme"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/desktop/common"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="formElement" tagdir="/WEB-INF/tags/desktop/formElement"%>

<c:set var="width_style" value="locator_width" scope="request"/>
<c:if test ="${!displayTitle}">
	<c:set var="width_style" value="" scope="request"/>
</c:if>
<div class="span-16 ${width_style}">
		<c:if test="${displayTitle}">
        <div class="storelocator_logo">
            <h1><spring:theme code="storeFinder.find.a.store" /></h1>
        </div>
	     </c:if>
        <!--logo-->
        <div class="search_area">
            <c:url value="/store-finder/locator" var="storeFinderFormAction" />
            <form:form action="${storeFinderFormAction}" method="get" id="storeFinder">
              <span><spring:theme code="storeFinder.store.locator" /></span>
              <span><input type="text" id="stores" name="q" placeholder="<spring:theme code="storelocator.query" />" value="${locationQuery}"></span>
              <span><input type="submit" value="<spring:theme code="storeFinder.findStore" />"></span>
            </form:form>
        </div>
</div>