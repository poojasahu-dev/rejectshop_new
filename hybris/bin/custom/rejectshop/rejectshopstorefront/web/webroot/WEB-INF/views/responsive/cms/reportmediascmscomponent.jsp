<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>

<div class="reportmedias">
	<c:set var="datePattern" value="dd MMM yyyy"></c:set>
	<div class="title">
		<h2>${year}</h2>
	</div>
	<c:forEach items="${reportMedias}" var="reportMedia">
		<div class="reportdetails">
			<h3>${reportMedia.name}</h3>
			<c:set value="${ycommerce:formatFileSize(reportMedia.size)}" var="fileSize" />
				<div class="downloadlink"><a href="${reportMedia.URL }">${(reportMedia.mime == 'video/mpeg')?"MP3":"PDF"}</a> (${fileSize})</div>
				<div class="uploaddate"><fmt:formatDate value="${reportMedia.uploadDate}" pattern="${datePattern }" /></div>
		</div>
	</c:forEach>
</div>


