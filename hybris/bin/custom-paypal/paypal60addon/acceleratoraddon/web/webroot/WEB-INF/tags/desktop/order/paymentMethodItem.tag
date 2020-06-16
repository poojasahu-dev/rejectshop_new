<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ attribute name="order" required="true" type="de.hybris.platform.commercefacades.order.data.OrderData" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="product" tagdir="/WEB-INF/tags/desktop/product"%>
<%@ taglib prefix="theme" tagdir="/WEB-INF/tags/shared/theme"%>
<%@ taglib prefix="format" tagdir="/WEB-INF/tags/shared/format"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="order" tagdir="/WEB-INF/tags/desktop/order"%>
<%@ taglib prefix="order-payment-method"
	tagdir="/WEB-INF/tags/addons/paypal60addon/desktop/order"%>

<div class="orderBox payment">
	<c:choose>
		<c:when test="${not empty orderData.paymentInfo.billingAddress}">
			<div class="left">
				<order-payment-method:paymentDetailsItem order="${orderData}" />
			</div>
			<div class="left">
				<order:billingAddressItem order="${orderData}" />
			</div>
		</c:when>
		<c:otherwise>
			<order-payment-method:paymentDetailsItem order="${orderData}" />
		</c:otherwise>
	</c:choose>
</div>
