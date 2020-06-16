<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url value="${component.urlLink}" var="paypalExpressCheckoutUrl" />
<a href="${paypalExpressCheckoutUrl}">
    <img src="${component.media.url}" alt="${component.media.altText}" />
</a>
