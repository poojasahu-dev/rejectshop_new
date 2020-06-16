<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>

<div class="accordion">
	<c:if test="${not empty title}">
		<div class="title">
			<h1>${title}</h1>
		</div>
	</c:if>
	<div>
		<div id="accordionitems">
			<c:forEach items="${accordionItems}" var="component">
				<cms:component component="${component}" />
			</c:forEach>
		</div>
	</div>
</div>







