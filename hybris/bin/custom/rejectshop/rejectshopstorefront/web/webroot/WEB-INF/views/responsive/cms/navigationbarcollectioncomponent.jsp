<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<div class="a">
<c:if test="${component.visible}">
	<div class="navigationbarcollectioncomponent">
 
			<button type="button" class="drop navbar-toggle" data-toggle="collapse" data-target="#menudropdown">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
 
	<div   id="menudropdown">
		<nav class="main-navigation js-enquire-offcanvas-navigation>
			role="navigation">
			<ul class="nav nav-pills">
				<!-- <li class="hidden-sm hidden-md hidden-lg">
					<a class="sm-back js-toggle-sm-navigation" href="#">Back</a>
				</li> -->
				<c:forEach items="${components}" var="component">
					<c:if test="${component.navigationNode.visible}">
						<cms:component component="${component}" evaluateRestriction="true"
							navigationType="offcanvas" />
					</c:if>
				</c:forEach>
			</ul>
		</nav>
	</div>	
	</div>
</c:if>
</div>