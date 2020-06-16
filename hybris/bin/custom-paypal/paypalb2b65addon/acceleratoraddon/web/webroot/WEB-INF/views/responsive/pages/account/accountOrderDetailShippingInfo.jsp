<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="order" tagdir="/WEB-INF/tags/responsive/order" %>
<%@ taglib prefix="b2b-order" tagdir="/WEB-INF/tags/addons/b2bacceleratoraddon/responsive/order" %>
<%@ taglib prefix="order-payment-method" tagdir="/WEB-INF/tags/addons/paypalb2b65addon/responsive/order" %>

<spring:htmlEscape defaultHtmlEscape="true" />

<c:if test="${not empty orderData}">
    <div class="account-orderdetail well well-tertiary">
        <div class="well-headline">
            <spring:theme code="text.account.order.orderDetails.billingInformtion" />
        </div>
        <ycommerce:testId code="orderDetails_paymentDetails_section">
            <div class="well-content">
                <c:if test="${orderData.paymentType.code eq 'CARD'}">
                    <div class="row">
						<c:choose>
							<c:when
								test="${orderData.paymentInfo.cardType eq 'PAYPAL PAYMENT' or orderData.paymentInfo.cardType eq 'PAYPAL CREDIT PAYMENT'}">
								<c:if
									test="${(not empty orderData.paymentInfo.billingAddress) && (orderData.paymentInfo.isBillingAddressRequired)}">
									<div class="col-sm-6 col-md-4 order-billing-address">
										<order:billingAddressItem order="${orderData}" />
									</div>
								</c:if>
							</c:when>
							<c:otherwise>
								<c:if test="${(not empty orderData.paymentInfo.billingAddress)}">
									<div class="col-sm-6 col-md-4 order-billing-address">
										<order:billingAddressItem order="${orderData}" />
									</div>
								</c:if>
							</c:otherwise>
						</c:choose>
						<c:if test="${not empty orderData.paymentInfo}">
                            <div class="col-sm-6 order-payment-data">
                                <order-payment-method:paymentDetailsItem order="${orderData}"/>
                            </div>
                        </c:if>
                    </div>
                </c:if>
                <c:if test="${orderData.paymentType.code eq 'ACCOUNT'}">
                    <div class="row">
                        <div class="col-sm-6 order-billing-address">
                            <b2b-order:paymentDetailsAccountItem order="${orderData}"/>
                        </div>
                    </div>
                </c:if>
            </div>
        </ycommerce:testId>
    </div>
</c:if>
