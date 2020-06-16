
<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="product" tagdir="/WEB-INF/tags/responsive/product"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="product" tagdir="/WEB-INF/tags/responsive/product"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="theme" tagdir="/WEB-INF/tags/shared/theme" %>

<div id="popup1" class="modal-box">
	<header>
		<a href="#" onclick="return resetSFCss();" class="js-modal-close close"></a>
		<h3>SEND A SAVVY BARGAIN</h3>
	</header>
	<div class="email_details">
		<strong>MAKE SOMEONE'S DAY</strong>
		<p>So, you've found a savvy bargain your friends or family will appreciate, just click the 'send a savvy recommendation' below to let them know.</p>
		<p>Please note stocks are limited and will vary between stores. We apologise if items sell out due to unexpected high demand.</p>
	</div>
	<div class="productDetailsEmail">
		<!-- <img class="send_image_tag"> -->
		<ol class="mini-cart-list">
			<%-- 	<c:forEach items="${entries}" var="entry"> --%>
			<%-- <c:url value="${entry.product.url}" var="entryProductUrl" /> --%>
			<li class="mini-cart-item">
				<div class="thumb">
					<a href="${entryProductUrl}"> <product:productPrimaryImage product="${entry.product}" format="product" />
					</a>
				</div>

			</li>
			
		
		</ol>




		<!-- </img> -->
		<div class="productPrice">
			<div class="summary">${product.name}</div>
			<ycommerce:testId
					code="productDetails_productNamePrice_label_${product.code}">
				<product:productPricePanel product="${product}" />
			</ycommerce:testId>

		</div>


	</div>



	<div id="emailForm" class="modal-body">
		<h2><spring:theme code="sendafriend.formHeader"/></h2>
		<form:form action="${contextPath}/sendemail" modelAttribute="sendAFriendForm" method="POST">
			<fieldset>
			 		<form:hidden path="brontoToken" id="brontoTokenID" name="brontoToken"  class="form-control"/>
					<div class="form-group">
					<spring:theme code="sendafriend.name" var="name"/>
					<div class="col-sm-5 col-xs-9 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
							<form:input path="name" id="nameSF" name="name" class="form-control" placeholder="${name}"/>
						</div>
						<div class="nameError display-error-SR"><spring:theme code="sendafriend.name.invalid"/></div>
					</div>
				</div>
				<div class="form-group">
					<spring:theme code="sendafriend.RecipientEmail" var ="email"/>
					<div class="col-sm-5 col-xs-9 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
							<form:input path="RecipientEmail" class="form-control" id="recipientEmailSF" name="RecipientEmail" placeholder="${email}"/>
						</div>
						<div class="recipientMailError display-error-SR"><spring:theme code="sendafriend.recipientemail.invalid"/></div>
					</div>
				</div>

				
				<div class="form-group">
					<spring:theme code="sendafriend.yourname" var ="yourName"/>
					<div class="col-sm-5 col-xs-9 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
							<form:input path="yourName" class="form-control" id="yourNameSF" name="yourName" placeholder="${yourName}"/>
						</div>
						<div class="recipientError display-error-SR"><spring:theme code="sendafriend.yourname.invalid"/></div>
					</div>
				</div>

				<div class="form-group">
					<spring:theme code="sendafriend.email" var="yourEmail"/>
					<div class="col-sm-5 col-xs-9 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
							<form:input path="email" id="emailSF" class="form-control" name="email" placeholder="${yourEmail}"/>
						</div>
						<div class="emailError display-error-SR"><spring:theme code="sendafriend.email.invalid"/></div>
					</div>
				</div>
				<%--<div class="form-group">
					<label class="col-xs-3 control-label"><spring:theme code="sendafriend.message"/>: *</label>
					<div class="col-sm-5 col-xs-9 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-pencil"></i></span>
							<form:textarea path="message" id="messageSF" name="message" placeholder="I recommend the following:" class="form-control"/>
						</div>
						<div class="messageError display-error-SR"><spring:theme code="sendafriend.message.invalid"/></div>
					</div>
				</div>--%>
			</fieldset>
			<form:input type="hidden" path="productUrl" id="productUrlSF"
				name="productUrl" />
			<form:input type="hidden" path="productName" id="productNameSF"
				name="productName" />
			<form:input type="hidden" path="productCode" id="productCodeSF"
				name="productCode" />
				<form:input type="hidden" path="productImageUrl" id="productImageUrlSF" name="productCode" />
				<form:input type="hidden" path="productPrice" id="productPriceSF"  value= "${product.price.formattedValue}"/>
			<div class="submitButton col-sm-5 col-xs-12">
				<!-- <input type="submit" class="btn btn-default pull-right" name="submit" onclick="return validateEmailFieldsSF();" value="Send Message" /> -->
<button type="submit" class="btn btn-default" name="submit" onclick='return validateEmailFieldsSF(event),utag.link({"event_action" : "click", "event_category" : "Interactions", "event_label" : "customer_support", "event_name" : "review_submit"});'>SEND A SAVVY RECOMMENDATION</button>
			</div>
			<div class="email_details col-sm-12 col-xs-12" style="padding-left:0px"><p>* Denotes mandatory field</p></div>
		</form:form>
		<div class="send-a-friend">${redirectionMessage}</div>
	</div>

</div>

