<%@page
	import="de.hybris.platform.cms2.model.contents.components.CMSLinkComponentModel"%>
<%@page
	import="de.hybris.platform.cms2.model.navigation.CMSNavigationNodeModel"%>
<%@page import="java.util.List"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="format" tagdir="/WEB-INF/tags/shared/format"%>
<%@ taglib prefix="theme" tagdir="/WEB-INF/tags/shared/theme"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<c:set value="${cmsPage.label}" var="pageURL" />
<c:set value="${fn:split(pageURL,'/')}" var="splittedURIS" />

<div id="${splittedURIS[1]}" class="cmslinkinfonavigation">
	<div class="inner-left">
	    <h1 class="left-nav-title">${title}</h1>
		<ul class="inner-nav">
			<c:forEach items="${navigationNodes}"  varStatus="status"
				var="child">			
				<c:set  value="${child.links[0]}" var="nodeLink"></c:set>
				<c:set  value="${fn:length(child.links) > 1}" var="hasSubLinks"></c:set>
				<c:set  value="false" var="openSubLinks"></c:set>
				<c:set  value="false" var="selectedSubLink"></c:set>
				<c:if test="${hasSubLinks}">
					<c:forEach items="${child.links}" var="tempLink" varStatus="index">		
						<c:if test="${fn:contains(pageLabel, tempLink.url)}">	
							<c:set  value="true" var="openSubLinks"></c:set>
							<c:if test="${index.count gt 1}">
								<c:set value="true" var="selectedSubLink"></c:set>
							</c:if>
						</c:if>
					</c:forEach>
				</c:if>
				<div class = "childnode">
					<c:if test="${hasSubLinks}">
						<c:if test="${openSubLinks and !selectedSubLink}">
							<cms:component component="${nodeLink}" evaluateRestriction="true" element="li" class="selected active"/>
						</c:if>
						<c:if test="${openSubLinks and selectedSubLink}">
							<cms:component component="${nodeLink}" evaluateRestriction="true" element="li" class="selected"/>
						</c:if>
						<c:if test="${!openSubLinks}">
							<cms:component component="${nodeLink}" evaluateRestriction="true" element="li" class="selected"/>
						</c:if>
					</c:if>
					<c:if test="${!hasSubLinks}">
						<c:choose>
							<c:when test="${fn:contains(pageLabel, nodeLink.url)}">
								<cms:component component="${nodeLink}" evaluateRestriction="true" element="li" class="selected active"/>
							</c:when>
							<c:otherwise>
								<cms:component component="${nodeLink}" evaluateRestriction="true" element="li"/>
							</c:otherwise>
						</c:choose>
					</c:if>
				</div>
				<%-- <c:if test="${openSubLinks}">	
					<ul> --%>
						 <div id="drpdowm" class="status${status.index}">
						 			 <c:forEach items="${child.links}" var="link" begin="1">		
										<div class = "sublink">	
											<c:if test="${fn:endsWith(link.url, pageLabel)}">			
												<cms:component component="${link}" evaluateRestriction="true" element="li" class="active"/>
											</c:if>	
											<c:if test="${!(fn:endsWith(link.url, pageLabel))}">			
												<cms:component component="${link}" evaluateRestriction="true" element="li"/>
											</c:if>				
										</div>
									 </c:forEach>
						 </div>		
					<%-- </ul>
				</c:if>	 --%>
			</c:forEach>
		</ul>
	</div>
</div>
