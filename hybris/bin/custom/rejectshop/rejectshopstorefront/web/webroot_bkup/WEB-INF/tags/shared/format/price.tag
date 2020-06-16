<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ attribute name="priceData" required="true" type="de.hybris.platform.commercefacades.product.data.PriceData" %>
<%@ attribute name="displayFreeForZero" required="false" type="java.lang.Boolean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%--
 Tag to render a currency formatted price.
 Includes the currency symbol for the specific currency.
--%>

<c:choose>

	<c:when test="${priceData.value > 0}">
		<c:choose>
			<c:when test="${ fn:indexOf(priceData.value,'0.') ==0 }">
				<sup></sup>
				<sup >${priceData.formattedValue.substring(3)}</sup>
				<sup>c</sup>
			</c:when>
		<c:otherwise>
			<c:if test="${priceData.value ne null}"><sup>$</sup></c:if>
			<c:forTokens items="${priceData.formattedValue.substring(1)}" delims="." var="mySplit" varStatus="theCount">
				<%-- <c:choose>
                    <c:when test="${mySplit == 00}">
                        <c:set var="cssClass" value="withZero"/>
                    </c:when>
                    <c:otherwise>
                        <c:set var="cssClass" value="noneZero"/>
                     </c:otherwise>
                </c:choose> --%>
				<sup data-value="${mySplit.trim()}" class="small_value_${cssClass}">${mySplit.trim()}</sup></c:forTokens>
		</c:otherwise>
		</c:choose>

		<%-- <sup>$</sup><c:forTokens items="${priceData.formattedValue}" delims="." var="mySplit"><c:if test="${mySplit !=0}"><c:out value="${mySplit.trim()}"/></c:if><sup></c:forTokens> --%>
		<%-- <sub>FROM</sub><sup>$</sup>999<sup>99</sup><sub>EA</sub>
		${priceData.formattedValue} --%>
	</c:when>
	<c:otherwise>
		<c:if test="${displayFreeForZero}">
			<spring:theme code="text.free" text="FREE"/>
		</c:if>
		<c:if test="${not displayFreeForZero}">
			${priceData.formattedValue}
		</c:if>
	</c:otherwise>
</c:choose>
