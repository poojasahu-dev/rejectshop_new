<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ attribute name="priceData" required="true" type="de.hybris.platform.commercefacades.product.data.PriceData" %>
<%--
 Tag to render a currency formatted price.
 Includes the currency symbol for the specific currency.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:choose>
	<c:when test="${priceData.priceType == 'FROM'}">
		<%--
		We pass the formatted currency amount into the message so that it can be used in the from message.
		Note: As the formatted currency may contain characters that <spring:theme> interprets as argument
		separators (e.g. comma) we change the separator to some random string sequence that will not appear
		in the formatted currency value.
		 --%>
		<spring:theme code="product.price.from" arguments="${priceData.formattedValue}" argumentSeparator="#~/@!�$%^"/>
	</c:when>

 <c:otherwise>
		<%-- <sup>$</sup>	
		<c:forTokens items="${priceData.formattedValue.substring(1)}" delims="." var="mySplit"><c:if test="${mySplit != 0}"><c:out value="${mySplit.trim()}"/><sup></c:if></c:forTokens> --%>
		 <c:choose>
		   <c:when test="${ fn:indexOf(priceData.value,'0.')==0}">
			   <sup></sup>
			  <sup >${priceData.formattedValue.substring(3)}</sup>
			   <sup>C</sup>
		   </c:when>
		   <c:otherwise>
			   <c:if test="${priceData.value ne null}"><sup>$</sup></c:if>
			   <c:forTokens items="${priceData.formattedValue.substring(1)}" delims="." var="mySplit" varStatus="theCount">
				   <sup data-value="${mySplit.trim()}" class="small_value_${cssClass}">${mySplit.trim()}</sup></c:forTokens>
		   </c:otherwise>
	   </c:choose>
	</c:otherwise>
</c:choose>
