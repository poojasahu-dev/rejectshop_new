<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ attribute name="order" required="true" type="de.hybris.platform.commercefacades.order.data.OrderData" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<spring:htmlEscape defaultHtmlEscape="true"/>
<div class="label-order">
    <spring:theme code="text.account.paymentType"/>
</div>
<div class="value-order">
	<c:choose>
		<c:when test="${order.paymentInfo.cardType eq 'PAYPAL PAYMENT'}">
		    <img src="https://www.paypalobjects.com/webstatic/en_US/i/buttons/pp-acceptance-small.png" alt="PayPal icon"/>
		    <spring:theme code="paymentMethod.type"/>
		    <br/>
		    ${fn:escapeXml(order.paymentInfo.subscriptionId)}
		</c:when>
		<c:when test="${order.paymentInfo.cardType eq 'PAYPAL CREDIT PAYMENT'}">
		    <img src="https://www.paypalobjects.com/webstatic/en_US/i/buttons/ppc-acceptance-small.png" alt="PayPal icon"/>
		    <spring:theme code="paymentMethod.type"/>
		    <br/>
		    ${fn:escapeXml(order.paymentInfo.subscriptionId)}
		</c:when>
		<c:otherwise>
		    ${fn:escapeXml(order.paymentInfo.cardTypeData.name)}
		    ${fn:escapeXml(order.paymentInfo.cardNumber)}
		</c:otherwise>
	</c:choose>
</div>

