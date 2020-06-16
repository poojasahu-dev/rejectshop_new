<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="small_baner_content">
	<c:url value="${urlLink}" var="encodedUrl" />
	<a class="small_banner_link" href="${encodedUrl}"<c:if test="${external}"> target="_blank"</c:if> ${target} >
		<img class="small_banner" src="${media.url}" alt="${not empty headline ? headline : media.altText}" title="${not empty headline ? headline : media.altText}" />
		<div class="text-left">	
			<div class="label">
				<span><c:out value="${productName}"/></span>
				<c:choose> <c:when test="${fn:length(unit)>2 }"><span ><c:out value="${unit}"/> </span></c:when>
					<c:otherwise><span style="padding:0px!important"></span></c:otherwise>
				</c:choose>
			<span class="featureProduct" style="width: 69px;">
				<c:choose>
					<c:when test="${ fn:indexOf(price,'$0.') ==0 }">
						<sup></sup>
						<sup data-value="${price.substring(3)}" class="small_value_${cssClass}">${price.substring(3)}</sup>
						<sup class="small_value_${cssClass}" >c</sup>
					</c:when>
					<c:otherwise>
						<c:if test="${price ne null}"><sup >$</sup></c:if>
						<c:forTokens items="${price.substring(1)}" delims="." var="mySplit" varStatus="theCount">
							<sup data-value="${mySplit.trim()}" class="small_value_${cssClass}">${mySplit.trim()}</sup></c:forTokens>
					</c:otherwise>
				</c:choose>
			</span>

			</div>
				<div class="desc">
				<c:out value="${productDesc}" />
			</div>
			<c:if test="${not empty amountSaved}">
				<div>
					<spring:theme code="product.amount.saved" />: 
					<c:out value="${amountSaved}" />
				</div>
			</c:if>
		</div>
	</a>	
</div>