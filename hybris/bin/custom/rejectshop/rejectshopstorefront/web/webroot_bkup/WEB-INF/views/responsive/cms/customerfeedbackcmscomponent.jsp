<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<script type="text/javascript">
	var msgs = [];
	msgs['customerfeedback.message.limit.exceeded']= '<spring:theme code="customerfeedback.message.limit.exceeded"/>';
	msgs['customerfeedback.message.charactersleft']= '<spring:theme code="customerfeedback.message.charactersleft"/>';
</script>

<c:url var="addCustomerFeedbackURL" value="/contactus/customerfeedback/addcustomerfeedback"/>

<spring:theme code="customerfeedback.firstname" var="firstname" />
<div class="customerfeedback">
	<c:if test="${not empty title }">
		<div class="title">
			<h1>${title}</h1>
		</div>
	</c:if>
	<div class="customerfeedbackform">
		<h3><spring:theme code="customerfeedback.send"/></h3>
		<p class="required"><spring:theme code="form.required"/></p>
		<form:form method="POST" action="${addCustomerFeedbackURL }"
			id="customerFeedbackForm" commandName="customerFeedbackForm">
				<form:errors path="titleCode" element="div" cssClass="fielderror"></form:errors>
				<div>
					<div class="formlabel"><spring:theme code="customerfeedback.title"/> </div>
					<div class="formelement">
						<form:select path="titleCode" >
							<option value="" selected="selected"><spring:theme code="customerfeedback.form.select.empty"/></option>
							<form:options items="${titles }"/>
						</form:select>
					</div>
				</div>
			
				<div>
					<div class="formlabel"><spring:theme code="customerfeedback.firstname"/> * </div>
					<div class="formelement">
						<form:input path="firstName"  />
						<form:errors path="firstName" element="div" cssClass="fielderror"></form:errors>
					</div>
				</div>
				<div>
					<div class="formlabel"><spring:theme code="customerfeedback.surname"/> * </div>
					<div class="formelement">
						<form:input path="surName" />
						<form:errors path="surName" element="div" cssClass="fielderror"></form:errors>
					</div>
				</div>
				<div>
					<div class="formlabel"><spring:theme code="customerfeedback.emailAddress"/> * </div>
					<div class="formelement">
						<form:input path="emailAddress" />
						<form:errors path="emailAddress" element="div" cssClass="fielderror"></form:errors>
					</div>
				</div>
				<div>
					<div class="formlabel"><spring:theme code="customerfeedback.phonenumber"/> </div>
					<div class="formelement">
						<form:input path="phoneNumber" />
						<form:errors path="phoneNumber" element="div" cssClass="fielderror"></form:errors>
					</div>
				</div>
				<div>
					<div class="formlabel"><spring:theme code="customerfeedback.storevisited"/>  </div>
					<div class="formelement">
						<form:select path="storeVisited">
							<option value="" selected="selected"><spring:theme code="customerfeedback.form.select.empty"/></option>
							<form:options items="${storesAvailableForCustomerFeedback}"/>
						</form:select>
						<form:errors path="storeVisited" element="div" cssClass="fielderror"></form:errors>
					</div>
				</div> 
				
				<div id="customerFeedbackDate">
					<div class="formlabel"><spring:theme code="customerfeedback.datevisited"/> </div>
					<div id="dayofReminderSR" class="formelement">
						<input data-format="dd/MM/yyyy" type="text" name="dayofReminder" path="dayofReminder">
						<span class="add-on glyphicon glyphicon-calendar" id="customerFeedBackDateImage"></span>
						<form:errors path="dateVisited" element="div" cssClass="fielderror"></form:errors>
					</div>
				</div>
				<div>
					<div class="formlabel"><spring:theme code="customerfeedback.feedbackabout"/> * </div>
					<div class="formelement">
						<form:select path="feedbackType">
 						  <option value="" selected="selected"><spring:theme code="customerfeedback.form.select.empty"/></option>
						  <form:options items="${feedbackTypes }" />
					   </form:select>
					   <form:errors path="feedbackType" element="div" cssClass="fielderror"></form:errors>
					</div>
				</div>
			<div id="customerFeedbackSubType" >
				<div class="formlabel"><spring:theme code="customerfeedback.feedbacktype"/> * </div>
				<div class="formelement">
					<form:select path="feedbackSubType">
						<option value="" selected="selected"><spring:theme code="customerfeedback.form.select.empty"/></option>
						<form:options items="${feedbackSubTypes }" />
					</form:select>
					<form:errors path="feedbackSubType" element="div" cssClass="fielderror"></form:errors>
				</div>
			</div>
				
				<div id="message">
					<div class="formlabel">
						<spring:theme code="customerfeedback.message"/> * 
					</div>
					<div class="formelement">
						<form:textarea path="message" id="messageText" />
						<form:errors path="message" cssClass="fielderror"></form:errors>
					</div>
					<p id="messageCharacters"></p>
				</div>
				<div class ="submitButton">
				<button onclick='utag.link({"event_action" : "click", "event_category" : "Interactions", "event_label" : "customer_support", "event_name" : "Submit" })'  value="Submit" type="submit" class="customerfeedback">SUBMIT</button>
				<!--  <input type="submit" value="Submit"/> -->
				 </div>
		</form:form>
	</div>
</div>