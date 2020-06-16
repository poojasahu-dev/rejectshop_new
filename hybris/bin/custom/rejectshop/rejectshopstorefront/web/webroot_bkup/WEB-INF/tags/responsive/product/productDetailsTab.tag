<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ attribute name="product" required="true"
	type="de.hybris.platform.commercefacades.product.data.ProductData"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="product" tagdir="/WEB-INF/tags/responsive/product"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="tab-details">
	<ycommerce:testId code="productDetails_content_label">
		<p>
			${product.description}
		</p>
		<p id="productsku">
				SKU: ${product.code}
		</p>
		<c:if test="${not empty product.productIndicator}">
		<p style="display:none">
			<spring:theme code="product.indicator"/>:
			${product.productIndicator}
		</p>
		</c:if>
	</ycommerce:testId>
</div>