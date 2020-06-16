<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="product" tagdir="/WEB-INF/tags/responsive/product"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="product" tagdir="/WEB-INF/tags/responsive/product"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div id="popup2" class="modal-box">
  <header> <a href="#" onclick="return resetSRCss();" class="js-modal-close close"></a>
    <h3>SET A REMINDER</h3>
  </header>
  <div class="email_details">
	  <strong>NEVER MISS A SAVVY BARGAIN</strong>
 <p>Found something you love but can't get into The Reject Shop right now? Simply click on the 'remind me via email' below to select a date and time that suits you and we'll send you a reminder. </p>
<p>Please note stocks are limited and will vary between stores. We apologise if items sell out due to unexpected high demand. The Reject Shop reserves the right to limit purchases to reasonable quantities.</p>

  </div>
  <div class="productDetailsEmail">
  		<!-- <img class="send_image_tag"> -->
  					<ol class="mini-cart-list">

							<c:url value="${entry.product.url}" var="entryProductUrl" />
							<li class="mini-cart-item">
								<div class="thumb">
									<a href="${entryProductUrl}"> <product:productPrimaryImage
											product="${entry.product}" format="product" />
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

	<div id="sendReminderFormDiv" class="modal-body">
		<h2><spring:theme code="send.reminder.formHeader"/></h2>
		<form:form commandName="sendReminderForm" action="${contextPath}/sendReminder/email" method="POST">
			<fieldset>
			 	<form:hidden path="brontoToken" id="brontoTokenID" name="brontoToken"  class="form-control"/>
				<div class="form-group">
					<spring:theme code="send.reminders.email" var="email" />
					<div class="col-sm-5 col-xs-9 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
							<form:input path="email" id="emailReminderSR" name="email" class="form-control" placeholder="${email}"/>
						</div>
						<div class="emailSRError display-error-SR" ><spring:theme code="send.reminder.email.invalid" /></div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-5 col-xs-9 inputGroupContainer">
						<div class="input-group" id="dayofReminderSR">
							<span class="input-group-addon" id="sendaReminberDate"><i class="add-on glyphicon glyphicon-calendar"></i></span>
							<input data-format="dd/MM/yyyy" type="text" name="dayofReminder" path="dayofReminder" id="dateReminderSR" class="form-control" placeholder='<spring:theme code="send.reminder.date"/>'/>
						</div>
						<div class="dateSRError display-error-SR" ><spring:theme code="send.reminder.date.invalid" /></div>
					</div>
				</div>

				<form:input type="hidden" path="name" id="nameSR" name="name" />
			</fieldset>
			<form:input type="hidden" path="productUrl" id="productUrlSR" name="productUrl" />
			<form:input type="hidden" path="productName" id="productNameSR"	name="productName" />
			<form:input type="hidden" path="productCode" id="productCodeSR"	name="productCode" />
			<form:input type="hidden" path="productImageUrl" id="productImageUrlSF" name="productCode" />
				<form:input type="hidden" path="productPrice" id="productPriceSF"  value= "${product.price.formattedValue}"/>
			<div class="submitButton col-sm-5 col-xs-12">
<!-- 			<button type="submit" class="btn btn-default pull-right" name="submit" onclick='return validateEmailFieldsSF(event),utag.link({"event_action" : "click", "event_category" : "Interactions", "event_label" : "customer_support", "event_name" : "review_submit"});'>Send Message</button> -->
				<button type="submit" class="btn btn-default" name="submit" onclick='return validateEmailFieldsSR(event),utag.link({"event_action" : "click", "event_category" : "Interactions", "event_label" : "customer_support", "event_name" : "submit"});'>REMIND ME VIA EMAIL</button>
			</div>
			<div class="email_details" style="float:left"><p>* Denotes mandatory field. Please note you will receive your email reminder by 9am on the date specified.</p></div>
		</form:form>
		<div class="send-Reminder">${redirectionMessage}</div>
	</div>
</div>