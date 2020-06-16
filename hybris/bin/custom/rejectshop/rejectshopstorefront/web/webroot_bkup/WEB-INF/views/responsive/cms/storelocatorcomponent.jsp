<%@ taglib prefix="store" tagdir="/WEB-INF/tags/responsive/store" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
    <c:when test="${isMenu}">
        <div class="socialcomponent">
            <h2><spring:theme code="storeFinder.link" /></h2>
            <c:url value="/store-finder" var="storeFinderFormAction" />
            <form:form action="${storeFinderFormAction}" method="get" commandName="storeFinderForm">
                <span><spring:theme code="storeFinder.use.this.form" /></span>
                <span><input type="text" id="socialstores" name="q" placeholder="<spring:theme code="storelocator.query" />" value="${locationQuery}"/></span>
                <div class="findStoreBtn">
					<input type="submit" value="<spring:theme code="storeFinder.findStore" />">
				</div>
            </form:form>
        </div>
    </c:when>

    <c:otherwise>
        <div class="span-16 store_finder  work-masonry-thumb">
            <store:storelocator errorNoResults="${errorNoResults}" locationQuery="${locationQuery}"/>
        </div>
    </c:otherwise>
</c:choose>
