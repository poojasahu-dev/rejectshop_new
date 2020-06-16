<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags" %>


		<c:forEach items="${navigationNodes}" var="node">
				<c:if test="${node.visible}">
					<div class="links">
						<div class="title">${node.title}</div>
						<c:forEach items="${node.links}" step="${component.wrapAfter}" varStatus="i">
							<ul>
								<c:forEach items="${node.links}" var="childlink" begin="${i.index}" end="${i.index + component.wrapAfter - 1}">
									<cms:component component="${childlink}" evaluateRestriction="true" element="li" />
								</c:forEach>
							</ul>
						</c:forEach>
					</div>
					 <div class="components">	
						<ul class="Fc ${i.count < 2 ? 'left_col' : 'right_col'}">	
			
							<c:forEach items="${node.components}" step="${component.wrapAfter}" varStatus="i">
				
				
								<c:forEach items="${node.components}" var="childComponent" begin="${i.index}" end="${i.index + component.wrapAfter - 1}">
									<cms:component component="${childComponent}" evaluateRestriction="true" element="li" class="Fc ${i.count < 2 ? 'left_col' : 'right_col'}"/>
							    </c:forEach>
				
				
	                       </c:forEach>
            			</ul>
					</div>
				</c:if>
		</c:forEach>


<div class="copyright">${notice}</div>
