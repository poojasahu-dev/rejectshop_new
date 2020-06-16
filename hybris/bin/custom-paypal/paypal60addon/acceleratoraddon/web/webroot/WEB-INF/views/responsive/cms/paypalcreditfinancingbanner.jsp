<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="useEasyPayment" value='<%=session.getAttribute("paypal.useEasyPayment")%>'/>
<c:choose>
	<c:when test="${useEasyPayment}">
		<!-- Place here the banner specific for Easy Payments  -->
		<div class="payPalBanner">
        	<script type="text/javascript" data-pp-pubid="44f6bbb99d" data-pp-placementtype="800x66"> (function (d, t) {
        	    "use strict";
        	    var s = d.getElementsByTagName(t)[0], n = d.createElement(t);
        	    n.src = "//paypal.adtag.where.com/merchant.js";
        	    s.parentNode.insertBefore(n, s);
        	    }(document, "script"));
        	</script>
        </div>
	</c:when>
	<c:otherwise>
		<!-- Place here the banner not related to Easy Payments  -->
		<div class="payPalBanner">
            	<script type="text/javascript" data-pp-pubid="44f6bbb99d" data-pp-placementtype="800x66"> (function (d, t) {
               	    "use strict";
               	    var s = d.getElementsByTagName(t)[0], n = d.createElement(t);
               	    n.src = "//paypal.adtag.where.com/merchant.js";
               	    s.parentNode.insertBefore(n, s);
               	    }(document, "script"));
               	</script>
         </div>
	</c:otherwise>
</c:choose>