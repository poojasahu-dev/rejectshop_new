<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!-- AddThis jQuery CDN -->
<script src="//s7.addthis.com/js/300/addthis_widget.js#pub=ra-51878dc954715de0" ></script>

<c:if test="${not empty addThisTitle}">
	<c:set var="addTitle" value="${addThisTitle}" />
	<c:if test="${appendProductName}">
        <c:choose>
            <c:when test="${empty product.name}">
                <c:set var="addTitle" value="${addTitle} ${product.baseProductName}" />
            </c:when>
            <c:otherwise>
                <c:set var="addTitle" value="${addTitle} ${product.name}" />
            </c:otherwise>
        </c:choose>
	</c:if>
</c:if>

<c:choose>
	<c:when test="${ serviceType=='addthis_button_facebook'}" >
		<div class="fb_btn">
			<div class="addthis_toolbox addthis_default_style addthis_16x16_style" >		
				<a onclick="tealiumTagEvent('shareFacebook')" href="${urlLink }" target="_blank" <c:if test="${not empty addTitle }">addthis:title="${addTitle}"</c:if> class="${serviceType}" title="${media.altText}">
					<img src="${media.url}" alt="${media.altText}" border="0" />
					<span class="like_txt">Like</span>
				</a>
			</div>
		</div>	
		<a class="addthis_counter addthis_bubble_style"></a>	
	</c:when>

	<c:when test="${ serviceType=='addthis_button_twitter'}" >
		<div class="twitter_btn">
			<div class="addthis_toolbox addthis_default_style addthis_16x16_style" >
				<a onclick="tealiumTagEvent('shareTweet')" href="${urlLink}" target="_blank" <c:if test="${not empty addTitle }">addthis:title="${addTitle}"</c:if> class="${serviceType}" title="${media.altText}">
					<img src="${media.url}" alt="${media.altText}" border="0" />
					<span class="like_txt">Tweet</span>
				</a>
			</div>
		</div>
	</c:when>
		 <c:when test="${ serviceType=='addthis_button_preferred_10'}" >
		<div class="addthis_toolbox addthis_default_style addthis_16x16_style" >
			<a onclick="tealiumTagEvent('sharePinit')" href="${urlLink }" target="_blank"
				<c:if test="${not empty addTitle }">addthis:title="${addTitle}"</c:if>
				title="${media.altText}">
				<img src="${media.url}" alt="${media.altText}" border="0" />
			</a>
		</div>
	</c:when> 
	<c:otherwise>
		<div class="addthis_toolbox addthis_default_style addthis_16x16_style">
			<a onclick="tealiumTagEvent('shareGoogle')" href="${urlLink }" target="_blank" <c:if test="${not empty addTitle }">addthis:title="${addTitle}"</c:if> class="${serviceType}" title="${media.altText}">
				<img src="${media.url}" alt="${media.altText}" border="0" />
			</a>
		</div>
	</c:otherwise>
</c:choose>