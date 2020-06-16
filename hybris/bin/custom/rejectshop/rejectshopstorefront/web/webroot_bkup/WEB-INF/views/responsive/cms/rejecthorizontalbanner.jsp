<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="${urlLink}" var="encodedUrl" />
<a class="heroimage" href="${encodedUrl}"
	<c:if test="${external}"> target="_blank"</c:if> ${target} >
	<img class="heroimage" src="${media.url}" alt="${not empty headline ? headline : media.altText}" title="${not empty headline ? headline : media.altText}" />
</a>