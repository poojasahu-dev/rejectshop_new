<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>

<div id="${component.uid}" class="${component.uid}" style="position: relative; margin: 0 auto; top: 20px; left: 0px; width: 1000px; height: 400px; overflow: hidden;">
	<div u="slides" style="cursor: move; position: absolute; left: 0px; top: 0px; width: 1000px; height: 440px; overflow: hidden;">
    	<c:forEach items="${banners}" var="banner" varStatus="status">
			<c:if test="${ycommerce:evaluateRestrictions(banner)}">
				<c:url value="${banner.urlLink}" var="encodedUrl" />
				<div><a class="slide" tabindex="-1" href="${encodedUrl}"<c:if test="${banner.external}"> target="_blank"</c:if>><img class ="banner_image" src="${banner.media.url}" alt="${not empty banner.headline ? banner.headline : banner.media.altText}" title="${not empty banner.headline ? banner.headline : banner.media.altText}"/></a></div>
			</c:if>
		</c:forEach>
	</div>
	
  	<div u="navigator" class="jssorb21" style="bottom: 40px; right: 6px;">
        <div u="prototype"></div>
	</div>
	<span u="arrowleft" class="jssora21l" style="top: 123px; left: 8px;"></span><!-- Left Arrow -->      
    <span u="arrowright" class="jssora21r" style="top: 123px; right: 8px;"></span><!-- Right Arrow -->
</div>
