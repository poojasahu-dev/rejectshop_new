<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ attribute name="hideHeaderLinks" required="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="nav" tagdir="/WEB-INF/tags/responsive/nav"%>
<%@ taglib prefix="breadcrumb"
	tagdir="/WEB-INF/tags/responsive/nav/breadcrumb"%>

<cms:pageSlot position="TopHeaderSlot" var="component" element="div" class="container">
	<cms:component component="${component}" />
</cms:pageSlot>

<header class="main-header main-header-md">
<div class="header_main">
	<div class="container">
		<div class="row">
				<div class="site-logo col-sm-6 col-xs-12">
				<!-- 	<button
						class="btn btn-default btn-large pull-right toggle-header-links js-toggle-header-links">
						<span class="glyphicon glyphicon-user"></span>
					</button> -->

	
					<%-- 	<div class="col-xs-6 col-sm-4 col-md-4 col-sm-push-6 col-md-push-8" id="miniCartSlot">
							<cms:pageSlot position="MiniCart" var="cart" limit="1">
								<cms:component component="${cart}" />
							</cms:pageSlot>
							<button	class="btn btn-default btn-large pull-right toggle-header-links js-toggle-header-links">
								<span class="glyphicon glyphicon-user"></span>
							</button>
						</div> --%>
					<cms:pageSlot position="SiteLogo" var="logo" limit="1">
						<cms:component component="${logo}" />
					</cms:pageSlot>
				</div>
				<div class="col-sm-6 col-xs-12 right-topmenu">
						<div class="search_before_content"></div>
						<div class="search_box">
							<cms:pageSlot position="SearchBox" var="component">
								<cms:component component="${component}" />
							</cms:pageSlot>
						</div>
						<div class="left_header_links">
							<ul class="storeFinder">
								<li><a href="<c:url value="/store-finder"/>"><span class="hidden-xs hidden-sm"><spring:theme code="general.find.a.store" /></span></a></li>
								<li> <cms:pageSlot position="MiniCart" var="cart" limit="1">
											<cms:component component="${cart}"/>
										</cms:pageSlot> </li>
									
							</ul>
						</div>
				</div>
		</div>
	</div>
	<a id="skiptonavigation"></a>
	<div class="navigation_links container">
		<nav:topNavigation />
	</div>
	

	
	
</div>


</header>

<c:if test="${fn:length(breadcrumbs) > 0}">
	<div class="breadcrumb-section">
		<div class="container">
			<breadcrumb:breadcrumb breadcrumbs="${breadcrumbs}" />
		</div>
	</div>
</c:if>


<cms:pageSlot position="BottomHeaderSlot" var="component" element="div"	class="container">
	<cms:component component="${component}" />
</cms:pageSlot>
<div id="my-welcome-message">
          <h1><spring:theme code="signup.savvy" /></h1>
          <p><spring:theme code="signup.savvy.text" /></p>
          <form action="">
          		<div>
          		<iframe class="iframeClass" src="https://savvy.rejectshop.com.au/forms/popup.php" target="_blank" height="90px" frameborder="0"scrolling="no"></iframe>
          			   <!--  <input type="email" required name="sarvyEmail" placeholder="Enter your email address" class="sarvyEmial" />  <button class="sarvySignMe">Sign me up</button> -->
          			<!-- <input type="email" required name="sarvyEmail" placeholder="Enter your email address" class="sarvyEmial" /> <button class="sarvySignMe">Sign me up</button> -->
          		</div>
          </form>
 </div>

 
 
