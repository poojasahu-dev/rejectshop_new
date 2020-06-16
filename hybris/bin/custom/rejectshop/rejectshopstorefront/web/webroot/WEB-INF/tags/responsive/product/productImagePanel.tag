<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ attribute name="product" required="true" type="de.hybris.platform.commercefacades.product.data.ProductData" %>
<%@ attribute name="galleryImages" required="true" type="java.util.List" %>
<%@ taglib prefix="product" tagdir="/WEB-INF/tags/responsive/product" %>


<div class="image-gallery searchicon js-gallery">
<a class="example-image newUrl anchorZoom" href="#" data-lightbox="example-set" ><img class="icon-zoom" src="${commonResourcePath}/images/zoomicon.png" id="zoom-image"/></a>

    <div class="imageZoom">


        <div class="carousel gallery-image js-gallery-image newImage">
        <c:forEach items="${galleryImages}" var="container" varStatus="varStatus">
            <div class="item">
                <%--<span class="productIndicatorSale"></span>--%>
                 <a class="example-image newUrl" href="${container.miniZoom.url}" data-lightbox="example-set" width="100%" height="100%" onclick="tealiumTagEvent('productView')" >
                     <c:if test="${not empty product.productIndicator}">
                         <div class="CallOutDiv CallOutProdDiv CO_${product.productIndicator}">
                             <c:choose>
                                 <c:when test="${product.productIndicator=='EVERYDAY'}">
                                     HERE EVERY DAY
                                 </c:when>
                                 <c:when test="${product.productIndicator=='PRICECHOP'}">
                                     PRICE CHOP
                                 </c:when>
                                 <c:when test="${product.productIndicator=='CATALOGUEDEAL'}">
                                     CATALOGUE DEAL
                                 </c:when>
                                 <c:when test="${product.productIndicator=='TVDEAL'}">
                                     TV DEAL
                                 </c:when>
                                 <c:when test="${product.productIndicator=='SAVVYDEAL'}">
                                     SAVVY DEAL
                                 </c:when>
                                 <c:when test="${product.productIndicator=='MULTIBUY'}">
                                     MULTI BUY
                                 </c:when>
                                 <c:when test="${product.productIndicator=='JOBLOT'}">
                                     JOB LOT
                                 </c:when>
                                 <c:otherwise>
                                     ${product.productIndicator}
                                 </c:otherwise>
                             </c:choose>
                         </div>
                     </c:if>
                     <img class="lazyOwl" data-src="${container.product.url}"
                          data-zoom-image="${container.superZoom.url}"
                          alt="${container.thumbnail.altText}" >
                 </a>
		 			
            </div>
        </c:forEach>
       
    </div>
     <product:productGalleryThumbnail galleryImages="${galleryImages}" />
</div>
</div>

