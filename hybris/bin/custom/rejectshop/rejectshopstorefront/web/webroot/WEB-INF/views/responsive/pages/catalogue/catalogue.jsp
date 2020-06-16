<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags" %>
<%@ taglib prefix="breadcrumb" tagdir="/WEB-INF/tags/desktop/nav/breadcrumb" %>
<%@ taglib prefix="savvyshopper" tagdir="/WEB-INF/tags/responsive/savvyshopper" %>

<template:page pageTitle="Catalogue | The Reject Shop">
    <div class="row">
            <div class="col-xs-12 col-sm-12 col-md-12">
                <div id="lzCatalogueArea" style="height:800px"></div>
                <script src="https://viewer-whitelabel.shopfully.cloud/scripts/v1/init.min.js "></script>
<script>
container_height = '450px';
window.SFviewer({
        country: 'en_au' ,
        id: '5b4226f9-ca60-4cdf-98c7-5037ac1f3e5c' ,
        container_id: 'lzCatalogueArea',
        //sf_onsectionchange: event => {
        sf_onsectionchange: function(event) {
        switch (event.section.name) {
                        case 'flyers':
                        container_height = '700px';
                        break;
                        case 'flyer':
                        container_height = '800px';
                        break;
                        case 'stores':
                        container_height = '800px';
                        break;
                        case 'tags':
                        container_height = '800px';
                        break;
                        case 'tag':
                        container_height = '800px';
                        break;
                }
                document.getElementById( 'lzCatalogueArea' ).style.height =container_height;
        }
});
</script>
                <!--<script type="text/javascript" src="https://www.dynamiccatalogue.com.au/dc/site/embedviewer/js/uvviewer.js?retailer=rejectshop.dynamiccatalogue.com.au"></script>-->

        </div>
    </div>
</template:page>
