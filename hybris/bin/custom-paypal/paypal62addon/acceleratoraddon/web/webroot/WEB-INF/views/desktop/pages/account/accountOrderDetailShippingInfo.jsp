<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="order" tagdir="/WEB-INF/tags/desktop/order" %>
<%@ taglib prefix="order-payment-method" tagdir="/WEB-INF/tags/addons/paypal62addon/desktop/order" %>

<div class="orderBoxes clearfix">
	<order:deliveryAddressItem order="${orderData}"/>
	<order:deliveryMethodItem order="${orderData}"/>
	<c:choose>
		<c:when
			test="${orderData.paymentInfo.cardType eq 'PAYPAL PAYMENT' or orderData.paymentInfo.cardType eq 'PAYPAL CREDIT PAYMENT'}">
			<c:if
				test="${(not empty orderData.paymentInfo.billingAddress) && (orderData.paymentInfo.isBillingAddressRequired)}">
				<div class="col-sm-6 col-md-4 order-billing-address">
					<order:billingAddressItem order="${orderData}"/>
				</div>
			</c:if>
		</c:when>
		<c:otherwise>
			<c:if test="${(not empty orderData.paymentInfo.billingAddress)}">
				<div class="col-sm-6 col-md-4 order-billing-address">
					<order:billingAddressItem order="${orderData}"/>
				</div>
			</c:if>
		</c:otherwise>
	</c:choose>
	<c:if test="${not empty orderData.paymentInfo}">
		<div class="orderBox payment">
			<order-payment-method:paymentDetailsItem order="${orderData}"/>
		</div>
	</c:if>
</div>