<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="theme" tagdir="/WEB-INF/tags/shared/theme"%>
<%@ taglib prefix="product" tagdir="/WEB-INF/tags/responsive/product"%>
<%@ taglib prefix="format" tagdir="/WEB-INF/tags/shared/format"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="cart" tagdir="/WEB-INF/tags/responsive/cart"%>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags/shared/util" %>
<c:set var="now" value="<%=new java.util.Date()%>" />
<spring:theme code="text.addToCart" var="addToCartText" />
<spring:theme code="text.popupCartTitle" var="popupCartTitleText" />
<c:url value="/cart" var="cartUrl" />
<c:url value="/cart/checkout" var="checkoutUrl" />
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- <div class="print_div">
<a href="#"  class="printButton">Print Page</a>
</div> -->
<util:tealiumUTag/>
<c:set var="miniCartProceed" value="checkout.checkout"/>
<c:if test="${empty numberItemsInCart or numberItemsInCart eq 0}">
	<div class="cart_modal_popup empty-popup-cart">
		<spring:theme code="popup.cart.empty" />
	</div>
</c:if>
<div class="mini-cart js-mini-cart" id="printablediv">
	<ycommerce:testId code="mini-cart-popup">
		<div class="mini-cart-body">
			<c:choose>
				<c:when test="${numberShowing > 0 }">
					<div class="legend">
						<%-- 	<spring:theme code="popup.cart.showing"
							arguments="${numberShowing},${numberItemsInCart}" /> --%>
						<%-- 	<c:if test="${numberItemsInCart > numberShowing}">
							<a href="${cartUrl}"><spring:theme code="popup.cart.showall" /></a>
						</c:if> --%>
					</div>
					<p></p>
					<ol class="mini-cart-list">
						<li class="printlogo"><img
							src="${commonResourcePath}/images/logo-print.png" /></li>
							<div class="heading">
						<span>Shopping List</span>
						</div>
						<div class="date">
							<span><c:set var="date" value="<%=new java.util.Date()%>" />
                                   <fmt:formatDate pattern="dd-MM-yyyy" value="${date}" />
                            
                            </span>
						</div> 
						
						<c:forEach items="${entries}" var="entry">
							<c:url value="${entry.product.url}" var="entryProductUrl" />
							
							<li class="mini-cart-item">
								<div class="thumb">
									<a href="${entryProductUrl}"> <product:productPrimaryImage
											product="${entry.product}" format="product" />
									</a>
								</div>
								<div class="details">
									<a class="name" href="${entryProductUrl}">Name: ${entry.product.name}</a>
									<a class="sku" href="${entryProductUrl}">SKU: ${entry.product.code} </a>
									<div class="qty entryQuantity"
										data-quantity="${entry.quantity}">
										<spring:theme code="popup.cart.quantity" />
										: ${entry.quantity}
									</div>
									<div class="del-button"><a href="#" id="RemoveProduct_${entry.entryNumber}"
											class="submitRemoveProduct"></a></div>
									
									
									<div class="price">
										<c:choose>
											<c:when test="${entry.product.price != null}">
												<format:price priceData="${entry.product.price}" />
											</c:when>
											<c:otherwise>
												<format:price priceData="${entry.basePrice}" />
											</c:otherwise>
										</c:choose>
									</div>
									<c:forEach items="${entry.product.baseOptions}"
										var="baseOptions">
										<c:forEach
											items="${baseOptions.selected.variantOptionQualifiers}"
											var="baseOptionQualifier">
											<c:if
												test="${baseOptionQualifier.qualifier eq 'style' and not empty baseOptionQualifier.image.url}">
												<div class="itemColor">
													<span class="label"><spring:theme
															code="product.variants.colour" /></span> <img
														src="${baseOptionQualifier.image.url}"
														alt="${baseOptionQualifier.value}"
														title="${baseOptionQualifier.value}" />
												</div>
											</c:if>
											<c:if test="${baseOptionQualifier.qualifier eq 'size'}">
												<div class="itemSize">
													<span class="label"><spring:theme
															code="product.variants.size" /></span>
													${baseOptionQualifier.value}
												</div>
											</c:if>
										</c:forEach>
									</c:forEach>
									<c:if test="${not empty entry.deliveryPointOfService.name}">
										<div class="itemPickup">
											<span class="itemPickupLabel"><spring:theme
													code="popup.cart.pickup" /></span>&nbsp;${entry.deliveryPointOfService.name}
										</div>
									</c:if>
								</div> <c:url value="/cart/update" var="cartUpdateFormAction" /> <form:form
									id="updateCartForm${entry.entryNumber}"
									action="${cartUpdateFormAction}" method="post"
									class="updateCartFormSubmit"
									commandName="updateQuantityForm${entry.entryNumber}">
									<input type="hidden" name="entryNumber"
										value="${entry.entryNumber}" />
									<input type="hidden" name="productCode"
										value="${entry.product.code}" />
									<input type="hidden" name="initialQuantity"
										value="${entry.quantity}" />
									<%-- 	<ycommerce:testId code="cart_product_quantity">
											<form:label cssClass="skip" path="quantity"
												for="quantity${entry.entryNumber}">
												<spring:theme code="basket.page.quantity" />
											</form:label>
											<form:input disabled="${not entry.updateable}" type="hidden" size="1" id="quantity${entry.entryNumber}" class="qty"
												path="quantity" />
										</ycommerce:testId> --%>
								</form:form> <c:if test="${entry.updateable}">
									<ycommerce:testId code="cart_product_removeProduct">
										
									</ycommerce:testId>
								</c:if>
							</li>

						</c:forEach>
					</ol>

					<%-- <c:if test="${not empty lightboxBannerComponent && lightboxBannerComponent.visible}">
							<cms:component component="${lightboxBannerComponent}" evaluateRestriction="true"  />
						</c:if> --%>

					<div class="mini-cart-totals">
						<%-- <div class="key">
							<spring:theme code="basket.page.totals.subtotal" />
						</div>
						<div class="value">
							<ycommerce:testId code="Order_Totals_Subtotal">
								<format:price priceData="${cartData.subTotal}" />
							</ycommerce:testId>
						</div>
 --%>
						<div class="key">
							<spring:theme code="basket.page.totals.total" />
						</div>
						<div class="price">
							<ycommerce:testId code="cart_totalPrice_label">
								<c:choose>
									<c:when test="${showTax}">
										<format:price priceData="${cartData.totalPriceWithTax}" />
									</c:when>
									<c:otherwise>
										<format:price priceData="${cartData.totalPrice}" />
									</c:otherwise>
								</c:choose>
							</ycommerce:testId>
						</div>

					</div>
					

					<%-- 	<a href="${cartUrl}"
						class="btn btn-primary btn-block mini-cart-checkout-button"> <spring:theme
							code="checkout.checkout" />
					</a>  --%>
					<%-- <a href="" class="btn btn-default btn-block js-mini-cart-close-button">
							<spring:theme text="Continue Shopping" code="cart.page.continue"/>
						</a>  --%>
				</c:when>

				<c:otherwise>
					<c:if
						test="${not empty lightboxBannerComponent && lightboxBannerComponent.visible}">
						<cms:component component="${lightboxBannerComponent}"
							evaluateRestriction="true" />
					</c:if>

					<%-- <button class="btn btn-block" disabled="disabled">
						<spring:theme code="checkout.checkout" />
					</button>
					<a href="" class="btn btn-default btn-block js-mini-cart-close-button">
						<spring:theme text="Continue Shopping" code="cart.page.continue"/>
					</a> --%>
				</c:otherwise>
			</c:choose>
		</div>
	</ycommerce:testId>
</div>
<div class="border-div"></div>

<!-- <div class="print_div">
	<a href="#" onclick="tealiumTagEvent('printCart')" class="printButton">Print Text Only</a>
	<a href="#" onclick="tealiumTagEvent('printCart')" class="printWithImageButton">Print Page</a>
	<a href="#" class="emailButton">Send Email</a>
</div> -->

<div class="print_div">
	<a href="${fn:escapeXml(cartUrl)}" class="btn btn-primary btn-block mini-cart-checkout-button">
							<spring:theme code="${miniCartProceed }" />
						</a>
						<a href="" class="btn btn-default btn-block js-mini-cart-close-button">
							<spring:theme code="cart.page.continue"/>
						</a>
</div>

<!-- 
<script language="javascript" type="text/javascript">
	function printDiv(divID) {
		//Get the HTML of div
		var divElements = document.getElementById(divID).innerHTML;
		//Get the HTML of whole page
		var oldPage = document.body.innerHTML;
		
		//Reset the page's HTML with div's HTML only
		document.body.innerHTML = "<html><head><title></title></head><body>"
				+ divElements + "</body>";

		//Print Page
		window.print();

		//Restore orignal HTML
		document.body.innerHTML = oldPage;

	}
</script> -->
