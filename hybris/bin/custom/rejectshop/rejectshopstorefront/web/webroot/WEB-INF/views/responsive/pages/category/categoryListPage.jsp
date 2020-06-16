<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template" %>
<%@ taglib prefix="nav" tagdir="/WEB-INF/tags/responsive/nav" %>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/responsive/common" %>
<%@ taglib prefix="storepickup" tagdir="/WEB-INF/tags/responsive/storepickup" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>

<template:page pageTitle="${pageTitle}">
<script type="text/javascript">
var x = document.getElementsByTagName("META");
for(i=0;i<x.length;i++){
        if(x[i].name=='keywords'){
                if(x[i].content=='Test'){
                        console.log('Found Tag, expanding');
                        var css = '@media (min-width:992px){\n'+
                        '       .categorybanner{width:calc(100% - 20px);}\n'+
                        '       .product-listing.product-list .product-item{width:calc(50% - 15px);padding-left:5px;margin-left:10px;}\n'+
                        '       .product-listing.product-list .product-item:nth-child(2n){margin-right:0;}\n'+
                        '}\n'+
                        '@media (min-width:768px) and (max-width:991px){\n'+
                        '       .categorybanner{width:calc(100% - 20px);}\n'+
                        '       .product-listing.product-list .product-item{width:calc(50% - 13.33px);padding-left:5px;margin-left:10px;}\n'+
                        '       .product-listing.product-list .product-item:nth-child(2n){margin-right:0;}\n'+
                        '}\n'+
                        '@media (min-width:480px) and (max-width:767px){\n'+
                        '       .categorybanner{width:calc(100% - 20px);}\n'+
                        '       .product-listing.product-list .product-item{width:calc(100% - 10px);margin:0 0 4px 0;}\n'+
                        '}\n'+
                        '@media (min-width:320px) and (max-width:479px){\n'+
                        '       .categorybanner{width:calc(100% - 20px);}\n'+
                        '       .product-listing.product-list .product-item{width:calc(100% - 10px);margin:0 0 4px 30px;}\n'+
                        '}',
                            head = document.head || document.getElementsByTagName('head')[0],
                            style = document.createElement('style');

                        style.type = 'text/css';
                        if (style.styleSheet){
                                // This is required for IE8 and below.
                                style.styleSheet.cssText = css;
                        } else {
                                style.appendChild(document.createTextNode(css));
                        }

                        head.appendChild(style);
                        var imgGroup = document.getElementsByTagName('img')
                        var SecBan = null;
                        var entry=-1;
                        for(i=0;i<imgGroup.length;i++){
                                console.log(imgGroup[i].alt)
                                if(imgGroup[i].alt=='Pack the perfect summer picnic'){
                                        SecBan = imgGroup[i];
                                        //imgGroup.id='SecondaryBanner';
                                        entry=i;
                                }
                        }
                        SecBan.id='NewSecBan'
                        document.getElementById('SecondaryBannerPlaceholderLocation').appendChild(SecBan);
                }
                if(x[i].content=='HomeMini'){
                        console.log('Found HomeMini Tag, expanding');
                        var css = '@media (min-width:992px){\n'+
                        '       .product-listing.product-list .product-item{width:calc(33% - 30px);padding-left:30px}\n'+
                        '       .categorybanner{width:calc(100% - 20px);}\n'+
                        '       .product-listing.product-list .product-item:nth-child(4n){margin-right:20px;}\n'+
                        '}\n'+
                        '@media (min-width:768px) and (max-width:991px){\n'+
                        '       .categorybanner{width:calc(100% - 20px);}\n'+
                        '       .product-listing.product-list .product-item{width:calc(33% - 13.33px);}\n'+
                        '       .product-listing.product-list .product-item:nth-child(4n){margin-right:20px;}\n'+
			'}\n'+
                        '@media (min-width:480px) and (max-width:767px){\n'+
                        '       .categorybanner{width:calc(100% - 20px);}\n'+
                        '       .product-listing.product-list .product-item{width:calc(100% - 10px);margin:0 0 4px 0;}\n'+
                        '}\n'+
                        '@media (min-width:320px) and (max-width:479px){\n'+
                        '       .categorybanner{width:calc(100% - 20px);}\n'+
                        '       .product-listing.product-list .product-item{width:calc(100% - 10px);margin:0 0 4px 0;}\n'+
                        '}',
                            head = document.head || document.getElementsByTagName('head')[0],
                            style = document.createElement('style');

                        style.type = 'text/css';
                        if (style.styleSheet){
                                // This is required for IE8 and below.
                                style.styleSheet.cssText = css;
                        } else {
                                style.appendChild(document.createTextNode(css));
                        }

                        head.appendChild(style);
                }
        }
}
</script>

	<div class="row">		
		<cms:pageSlot position="Section1" var="feature">
			<cms:component component="${feature}" element="div" class="col-xs-12 yComponentWrapper"/>
		</cms:pageSlot>		
	</div>
	<div class="row">
		<cms:pageSlot position="ProductLeftRefinements" var="feature">
			<div class="col-xs-3">
				<div class="row">
					<cms:component component="${feature}" element="div" class="col-xs-12 yComponentWrapper"/>
				</div>
			</div>
		</cms:pageSlot>
	
			<div class="HeroBanner page-title">
				<div class="details">
					<h1 class="title">${categoryName}</h1>
					<c:if test="${ not empty basecategorybanner}"> <img class="categorybanner hidden-xs hidden-sm " src="${basecategorybanner}"> </c:if>
					<p class="content hidden-xs hidden-sm">${categoryDesc}</p>
				</div>
			</div>
	
			<div class="row">
				<cms:pageSlot position="SectionCarousel" var="feature">
					<cms:component component="${feature}" />
				</cms:pageSlot>
			</div>
				<div class="product-list-wrapper" style="padding-top: 30px;">
					<ul class="product-listing product-list col-xs-12">
						<c:forEach items="${searchPageData.subCategories}" var="category">
							<li class="product-item" style="margin-right: 4px;">
								<c:url value="${category.url}" var="categoryUrl"/>
                                	<a class="thumb" href="${categoryUrl}">   <img src="${category.picture.url}"/></a>
								<%--	<a class="name item-desc" href="${categoryUrl}">${category.name}</a>&nbsp; -->
                                	<%-- <c:out value="${category.picture.url}"/>--%>
							</li>
						</c:forEach>
					</ul>
				</div>

  <span id='SecondaryBannerPlaceholderLocation'></span>
<script type="text/javascript">
var x = document.getElementsByTagName("META");
for(i=0;i<x.length;i++){
        if(x[i].name=='keywords'){
                if(x[i].content=='Test'){
                        var SecBan = document.getElementsByName('blog');
                        for(o=0;o<SecBan.length;o++){
                                document.getElementById('SecondaryBannerPlaceholderLocation').appendChild(SecBan[0]);
                        }
                        var Carousel = document.getElementsByClassName('carousel-component')[0];
                        document.getElementById('SecondaryBannerPlaceholderLocation').appendChild(Carousel);
                }
                if(x[i].content=='HomeMini'){
                        var SecBan = document.getElementsByName('blog');
                        for(o=0;o<SecBan.length;o++){
                                document.getElementById('SecondaryBannerPlaceholderLocation').appendChild(SecBan[0]);
                        }
                }
	}
}
</script>

	</div>

	<div class="row">
		<div class=" col-xs-10 col-lg-10 backToLink_class"><a href="#" class="links" id="back_to_top">Back to Top<span class="top_up_arrow"></span></a></div>
	</div>

</template:page>
