<%@ attribute name="cartData" required="true" type="de.hybris.platform.commercefacades.order.data.CartData" %>
<%@ attribute name="paymentInfo" required="true"
              type="de.hybris.platform.commercefacades.order.data.CCPaymentInfoData" %>
<%@ attribute name="showPaymentInfo" required="false" type="java.lang.Boolean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="format" tagdir="/WEB-INF/tags/shared/format" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:if test="${not empty paymentInfo && showPaymentInfo}">
    <ul class="checkout-order-summary-list">
        <li class="checkout-order-summary-list-heading">
            <div class="title">
                <spring:theme
                        code="checkout.summary.paymentMethod.securityCode.whatIsThis.description"
                        var="securityWhatText"/>
            </div>
            <div class="title"><spring:theme code="checkout.multi.payment" text="Payment:"></spring:theme></div>
            <div class="address">
                <c:choose>
                    <c:when test="${paymentInfo.cardType eq 'PAYPAL PAYMENT'}">
                        <img
                                src="https://www.paypalobjects.com/webstatic/en_US/i/buttons/pp-acceptance-small.png"
                                alt="PayPal icon"/>
                        <spring:theme code="paymentMethod.type"/>
                        <br>
                        <div class="pp-account-email">${fn:escapeXml(paymentInfo.subscriptionId)}</div>
                    </c:when>
                    <c:when test="${paymentInfo.cardType eq 'PAYPAL CREDIT PAYMENT'}">
                        <img
                                src="https://www.paypalobjects.com/webstatic/en_US/i/buttons/ppc-acceptance-small.png"
                                alt="PayPal icon"/>
                        <spring:theme code="paymentMethod.type"/>
                        <br>
                        <div class="pp-account-email credit">${fn:escapeXml(paymentInfo.subscriptionId)}</div>
                    </c:when>
                    <c:otherwise>
                        ${fn:escapeXml(paymentInfo.accountHolderName)},
                        ${fn:escapeXml(paymentInfo.cardTypeData.name)},
                        ${fn:escapeXml(paymentInfo.cardNumber)},
                        ${paymentInfo.expiryMonth}/${paymentInfo.expiryYear}
                    </c:otherwise>
                </c:choose>
                <div class="billing-address">
                    <c:if test="${not empty paymentInfo.billingAddress.line1}">, ${fn:escapeXml(paymentInfo.billingAddress.line1)},</c:if>
                    <c:if test="${not empty paymentInfo.billingAddress.line2}">${fn:escapeXml(paymentInfo.billingAddress.line2)},</c:if>
                    <c:if test="${not empty paymentInfo.billingAddress.town}">${fn:escapeXml(paymentInfo.billingAddress.town)},</c:if>
                    <c:if test="${not empty paymentInfo.billingAddress.region.name}"> ${fn:escapeXml(paymentInfo.billingAddress.region.name)}</c:if>
                    <c:if test="${not empty paymentInfo.billingAddress.postalCode}">${fn:escapeXml(paymentInfo.billingAddress.postalCode)},</c:if>
                    <c:if test="${not empty paymentInfo.billingAddress.country.name}">${fn:escapeXml(paymentInfo.billingAddress.country.name)}</c:if>
                </div>
            </div>
        </li>
    </ul>
</c:if>

