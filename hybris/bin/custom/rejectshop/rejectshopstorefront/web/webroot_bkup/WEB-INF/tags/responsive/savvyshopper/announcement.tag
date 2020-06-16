<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="theme" tagdir="/WEB-INF/tags/shared/theme" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ attribute name="announcement" required="false" type="au.com.rejectshop.core.model.components.CMSAnnouncementComponentModel" %>
<div>
	<c:if test="${announcement ne null}">
	<div class="cmstitleprgrph">
		<div class="title">
			<h1>${announcement.category}</h1>
		</div>
		<div class="content">
			<h2>${announcement.title}</h2>
			<c:if test="${announcement.media ne null}" >
				<%-- <a href="${announcement.link.url }"> --%>
					<img src="${announcement.media.url}" class="textWrap">
				<!-- </a> -->
			</c:if>
			${announcement.content}
		
		</div>
	</div>
	<div class="fb-like" data-href="http://www.rejectshop.com.au/savvyshoppers/news?id=${announcement.uid }" data-layout="standard" data-action="like" data-show-faces="false" data-share="true"></div>
	</c:if>

	
</div>

