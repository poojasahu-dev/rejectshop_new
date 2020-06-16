<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<%--  AddOn Common CSS files --%>
<c:forEach items="${addOnCommonCssPaths}" var="addOnCommonCss">
	<link rel="stylesheet" type="text/css" media="all" href="${addOnCommonCss}"/>
</c:forEach>
<link rel="stylesheet" type="text/css" media="all" href="//fast.fonts.net/cssapi/74890ad9-3b63-4d6c-b54e-c77ab3843aa4.css"/>
<link rel="stylesheet" type="text/css" media="all" href="${commonResourcePath}/css/lightbox.min.css"/>
<link rel="stylesheet" type="text/css" media="all" href="${commonResourcePath}/css/main.css"/>
<link rel="stylesheet" type="text/css" media="all" href="${commonResourcePath}/css/buttons.css"/>
<link rel="stylesheet" type="text/css" media="all" href="${commonResourcePath}/css/forms.css"/>
<link rel="stylesheet" type="text/css" media="all" href="${commonResourcePath}/css/header.css"/>
<link rel="stylesheet" type="text/css" media="all" href="${commonResourcePath}/css/miniCart.css"/>
<link rel="stylesheet" type="text/css" media="all" href="${commonResourcePath}/css/siteSearch.css"/>
<link rel="stylesheet" type="text/css" media="all" href="${commonResourcePath}/css/navigation.css"/>
<link rel="stylesheet" type="text/css" media="all" href="${commonResourcePath}/css/breadcrumb.css"/>


<%--  Category page --%>
<link rel="stylesheet" type="text/css" media="all" href="${commonResourcePath}/css/facetNav.css"/>

<link rel="stylesheet" type="text/css" media="all" href="${commonResourcePath}/css/paginationBar.css"/>


<link rel="stylesheet" type="text/css" media="all" href="${commonResourcePath}/css/productGrid.css"/>
<link rel="stylesheet" type="text/css" media="all" href="${commonResourcePath}/css/productList.css"/>
<%--  Product page --%>
<link rel="stylesheet" type="text/css" media="all" href="${commonResourcePath}/css/productDetails.css"/>

<link rel="stylesheet" type="text/css" media="all" href="${commonResourcePath}/css/bootstrap-datetimepicker.css"/>
<link rel="stylesheet" type="text/css" media="all" href="${commonResourcePath}/css/order.css"/>
<link rel="stylesheet" type="text/css" media="all" href="${commonResourcePath}/css/orderTotals.css"/>


<link rel="stylesheet" type="text/css" media="all" href="${commonResourcePath}/css/footer.css"/>


<link rel="stylesheet" type="text/css" media="all" href="${commonResourcePath}/css/colorBox.css"/>

<link rel="stylesheet" type="text/css" media="all" href="${commonResourcePath}/css/searchPOS.css"/>


<link rel="stylesheet" type="text/css" media="all" href="${commonResourcePath}/css/userRegister.css"/>
<link rel="stylesheet" type="text/css" media="all" href="${commonResourcePath}/css/userLogin.css"/>
<link rel="stylesheet" type="text/css" media="all" href="${commonResourcePath}/css/userGuest.css"/>


<link rel="stylesheet" type="text/css" media="all" href="${commonResourcePath}/css/account.css"/>


<link rel="stylesheet" type="text/css" media="all" href="${commonResourcePath}/css/cartItems.css"/>


<link rel="stylesheet" type="text/css" media="all" href="${commonResourcePath}/css/landingLayout2Page.css"/>
<link rel="stylesheet" type="text/css" media="all" href="${commonResourcePath}/css/storeDetail.css"/>
<link rel="stylesheet" type="text/css" media="all" href="${commonResourcePath}/css/storeFinder.css"/>
<link rel="stylesheet" type="text/css" media="all" href="${commonResourcePath}/css/jquery-ui.css"/>
<link rel="stylesheet" type="text/css" media="all" href="${commonResourcePath}/css/style.css"/>
<link rel="stylesheet" type="text/css" media="all" href="${commonResourcePath}/css/banner.css"/>
<link rel="stylesheet" type="text/css" media="all" href="${commonResourcePath}/css/helper.css"/>

<%-- Theme CSS files --%>
<link rel="stylesheet" type="text/css" media="all" href="${themeResourcePath}/css/style.css"/>
<link rel="stylesheet" type="text/css" media="all"  href="${themeResourcePath}/css/bootstrap.css"/>
<link rel="stylesheet" type="text/css" media="all"  href="${themeResourcePath}/css/home-page.css"/>
<link rel="stylesheet" type="text/css" media="all"  href="${themeResourcePath}/css/intlTelInput.css"/>
<%--  AddOn Theme CSS files --%>
<c:forEach items="${addOnThemeCssPaths}" var="addOnThemeCss">
	<link rel="stylesheet" type="text/css" media="all" href="${addOnThemeCss}"/>
</c:forEach>
<link rel="stylesheet" href="${commonResourcePath}/css/print.css" type="text/css" media="print" />

<link rel="stylesheet" type="text/css" media="all" href="${commonResourcePath}/css/tableDecorator.css"/>