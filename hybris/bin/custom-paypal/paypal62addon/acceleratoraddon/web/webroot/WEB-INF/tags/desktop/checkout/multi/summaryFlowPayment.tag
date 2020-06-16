<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ attribute name="paymentInfo" required="true" type="de.hybris.platform.commercefacades.order.data.CCPaymentInfoData" %>
<%@ attribute name="requestSecurityCode" required="true" type="java.lang.Boolean" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="format" tagdir="/WEB-INF/tags/shared/format" %>


<c:set value="${not empty paymentInfo and not empty paymentInfo.billingAddress}" var="billingAddressOk"/>
<spring:theme code="checkout.summary.paymentMethod.securityCode.whatIsThis.description" var="securityWhatText"/>

<div class="summaryPayment clearfix"  data-security-what-text="${securityWhatText}">
    <ycommerce:testId code="checkout_paymentDetails_text">
            <div class="column append-1">
				 <strong><spring:theme code="checkout.summary.paymentMethod.header" htmlEscape="false"/></strong>
                 <ul>
					<c:choose>
						<c:when test="${paymentInfo.cardType eq 'PAYPAL PAYMENT'}">
							<li class="paymentMethodLeft"><img src="https://www.paypalobjects.com/webstatic/en_US/i/buttons/pp-acceptance-small.png" alt="PayPal icon" /></li>
							<li class="paymentMethodRight"><spring:theme code="paymentMethod.type" />
								<br>${fn:escapeXml(paymentInfo.subscriptionId)}
							</li>
						</c:when>
						<c:when test="${paymentInfo.cardType eq 'PAYPAL CREDIT PAYMENT'}">
							<li class="paymentMethodLeft"><img src="https://www.paypalobjects.com/webstatic/en_US/i/buttons/ppc-acceptance-small.png" alt="PayPal icon" /></li>
							<li class="paymentMethodRight"><spring:theme code="paymentMethod.type" />
								<br>${fn:escapeXml(paymentInfo.subscriptionId)}
							</li>
						</c:when>
						<c:otherwise>
							<li>${fn:escapeXml(paymentInfo.accountHolderName)}</li>
		                    <li>${fn:escapeXml(paymentInfo.cardNumber)}</li>
		                    <li>${fn:escapeXml(paymentInfo.cardTypeData.name)}</li>
		                    <li><spring:theme code="checkout.summary.paymentMethod.paymentDetails.expires" arguments="${paymentInfo.expiryMonth},${paymentInfo.expiryYear}"/></li>
						</c:otherwise>
					</c:choose>
			     </ul>

			<c:if test="${requestSecurityCode}">
					<form>
						<div class="control-group security">
							<label for="SecurityCode"><spring:theme
									code="checkout.summary.paymentMethod.securityCode" />*</label>
							<div class="controls">
								<input type="text" class="text security" id="SecurityCode" /> <a
									href="#" class="security_code_what"><spring:theme
										code="checkout.summary.paymentMethod.securityCode.whatIsThis" /></a>
							</div>
						</div>
					</form>
				</c:if>
		</div>
		
            <div class="column">
                <ul>
                    <c:if test="${billingAddressOk}">
                        <li><strong><spring:theme code="checkout.summary.paymentMethod.billingAddress.header"/></strong></li>
                        <li>
                            <c:if test="${not empty paymentInfo.billingAddress.title}">${fn:escapeXml(paymentInfo.billingAddress.title)}&nbsp;</c:if>
                                ${fn:escapeXml(paymentInfo.billingAddress.firstName)}&nbsp;${fn:escapeXml(paymentInfo.billingAddress.lastName)}
                        </li>
                        <li>${fn:escapeXml(paymentInfo.billingAddress.line1)}</li>
                        <li>${fn:escapeXml(paymentInfo.billingAddress.line2)}</li>
                        <li>${fn:escapeXml(paymentInfo.billingAddress.region.name)}&nbsp;${fn:escapeXml(paymentInfo.billingAddress.town)}</li>
                        <li>${fn:escapeXml(paymentInfo.billingAddress.postalCode)}</li>
                        <li>${fn:escapeXml(paymentInfo.billingAddress.country.name)}</li>
                        <li>${fn:escapeXml(paymentInfo.billingAddress.phone)}</li>
                    </c:if>
                </ul>
            </div>
                             <c:if test="${paymentInfo.isFinancing}">
                                   <div class="column">
                                        <table>
                                             <tbody>
                                                       <tr>
                                                           	   <td><strong><spring:theme code="text.easyPayments.header" text="Payment Plan:"/></strong></td>
                                                       </tr>
                                                       <tr>
                                                                <td><spring:theme code="text.easyPayments.financingTerm" text="Financing Term:"/>  </td><td class="easyPaymentsValue"> ${fn:escapeXml(paymentInfo.financingTerm)}&nbsp;<spring:theme code="text.easyPayments.months" text=" Months"/> </td>
                                                       </tr>
                                                       <tr>
                                                                <td><spring:theme code="text.easyPayments.monthlyPayment" text="Monthly Payment:"/> </td><td class="easyPaymentsValue"> <format:price priceData="${paymentInfo.financingMonthlyPayment}"/></td>
                                                       </tr>
                                                       <tr>
                                                                <td><spring:theme code="text.easyPayments.totalCost" text="Payments Total:"/> </td><td class="easyPaymentsValue"> <format:price priceData="${paymentInfo.financingTotalCost}"/></td>
                                                       </tr>
                                             </tbody>
                                        </table>
                                    </div>
                             </c:if>
    </ycommerce:testId>
    <ycommerce:testId code="checkout_changePayment_element">
	    <c:url value="/checkout/multi/payment-method/add" var="addPaymentMethodUrl"/>
        <a href="${addPaymentMethodUrl}" class="button positive editButton"><spring:theme code="checkout.summary.edit"/></a>
    </ycommerce:testId>
</div>
