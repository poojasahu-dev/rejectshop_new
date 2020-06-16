<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<%-- 
<div id="${component.uid}" class="${component.typeCode}">
	<c:if test="${not empty link}">
		<h3><cms:component component="${link}"/></h3>
	</c:if>
	<c:if test="${external}"><h3> ${title}</h3></c:if> 
			
	
	<c:if test="${not external}">
		<h3><a href="#" class="heading">${title}</a></h3>
	</c:if>
	<ul class="navNodes">
		<c:forEach items="${links}" var="link">
			<li class="${cmsPage.label eq link.url ? 'active' : ''}">
				<cms:component component="${link}"/>
			</li>
		</c:forEach>
	</ul>
	
	
</div>
 --%>


<div id="${component.uid}" class="${component.typeCode}">
	<c:if test="${not empty link}">
		<h3><cms:component component="${link}"/></h3>
	</c:if>
	<c:if test="${not empty title}">
		<h3><a class="heading">${title} <span class="glyphicon glyphicon-chevron-right hidden-lg hidden-md hidden-sm hidden-xs pull-right"></span></a></h3>
	</c:if>
	<ul class="navNodes">
		<c:forEach items="${links}" var="link">
			<li >
				<cms:component component="${link}"/>
			</li>
		</c:forEach>
	</ul>
		
</div> 

