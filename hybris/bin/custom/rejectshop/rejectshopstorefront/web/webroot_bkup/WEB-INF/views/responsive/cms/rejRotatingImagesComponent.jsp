<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>

<c:set var="styleSpace" value="${component.uid}"></c:set> 
 <div id="${component.uid}" class="${styleSpace}" style="position: relative;float:left;top: 10px; left: 0px; width: 1000px; height: 370px; overflow: hidden;">
	<div u="slides" style="cursor: move; position: absolute; left: 0px; top: 0px; width: 1000px; height: 440px; overflow: hidden;">
	
 <c:set var="now" value="<%=new java.util.Date()%>" />
 <c:forEach items="${rotatingBanners}" var="banner" varStatus="status">
  <c:url value="${banner.linkUrl}" var="encodedUrl" /> 
     <c:set var="timeR" value="0"/>
   
   
     <c:forEach items="${banner.restrictions}" var="restrictions" varStatus="i">
     
         <c:if test="${(restrictions.itemtype == 'CMSTimeRestriction') && !((not empty restrictions.activeFrom ? restrictions.activeFrom le now : now le now) && (not empty restrictions.activeUntil ? restrictions.activeUntil ge now : now ge now))}">
                 <c:set var="timeR" value="1"/>
           
         </c:if>
     </c:forEach>
     <c:if test="${(timeR == '0')}">
       <div class="myImage">
		<c:forEach var="entry" items="${banner.imageMap}">
  
					 <c:if test="${entry.key eq 'desktop'}">
						<span data-src="${entry.value.url}" class="${entry.key}"> </span>
						<a href="${encodedUrl}" target="_blank">
						<div><img alt="" src="${entry.value.url}"></div>
						</a>
					</c:if>
		</c:forEach>
			</div>
     </c:if>
 </c:forEach> 
  <%-- <c:forEach items="${rotatingBanners}" var="banner" varStatus="status">
 
 <c:url value="${banner.linkUrl}" var="encodedUrl" /> 
  
      <div class="myImage">
		<c:forEach var="entry" items="${banner.imageMap}">
  
					 <c:if test="${entry.key eq 'desktop'}">
					
						<span data-src="${entry.value.url}" class="${entry.key}"> </span>
				
						<a href="${encodedUrl}" target="_blank">
						<div><img alt="" src="${entry.value.url}"></div>
						</a>
					</c:if>
		</c:forEach>
			</div>
    
 </c:forEach>  --%>
    	
    	
 
    	
	
	</div>
	
  	<div u="navigator" class="jssorb21" style="bottom: 10px; right: 6px;">
        <div u="prototype"></div>
	</div>
	<span u="arrowleft" class="jssora21l" style="top: 123px; left: 8px;"></span><!-- Left Arrow -->      
    <span u="arrowright" class="jssora21r" style="top: 123px; right: 8px;"></span><!-- Right Arrow -->
</div>