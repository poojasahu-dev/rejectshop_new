<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="socialcomponent">
    <h2><spring:theme code="storeFinder.followus" /></h2>
    <c:if test="${navigationNode.visible}">
        <div class = "${navigationNode.name}">
            <ul class="Fc left_col">
                <c:forEach items="${navigationNode.links}" var="childlink">
                    <%-- <cms:component component="${childlink}" evaluateRestriction="true" element="li" class="Fc left_col"/> --%>
                    <li><a href="${childlink.url}" target="${childlink.target=='NEWWINDOW'?'_blank':''}">${childlink.linkName}<img src="${childlink.media.url}"  title="${childlink.linkName}" alt="${childlink.linkName}"></a></li>
                </c:forEach>
            </ul>
        </div>
    </c:if>
</div>