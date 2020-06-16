<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/desktop/template" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="theme" tagdir="/WEB-INF/tags/shared/theme" %>
<%@ taglib prefix="format" tagdir="/WEB-INF/tags/shared/format" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/desktop/common" %>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:url value="/newsletter" var="news"></c:url>

<div id="${component.uid}" class="${component.style}">
	<h3>
		<label for="email">EMAIL CLUB</label> <!-- <span>"Send me news, sales &amp; notices"</span><em class="clear_0"></em> -->
	</h3>
	<input type="email" id="newsletterEmail" name="newsletterEmail"  placeholder="Enter Email Address" />
	<a href="${news}" id="emailButton" class="emailButton">Submit</a>
	<div class="clear_0"></div>
</div>

<div class="newsletterresponse" style="display:none">
	<a class="newsFormClose" id="newsFormClose"><img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAA4AAAANCAMAAACuAq9NAAABg1BMVEXQ0NDV1NLY19PZ2dnb2tjd3Nrh4Nzh4N7n5uTr6ujt7evy8vDz8vDz8/H08/H09PL29vT39/X39/f49vf49/X4+Pb4+Pj5+Pb5+ff5+fn6+ff6+vj6+vr6+vz6+/b7+vj7+/n7+/v8+/n9/Pr9/fv9/f3+/fv+/vz+/v7//f7//vr//vz//v////v///3///+/v8HDwLu7u7utraumpqSko6FWVVNXV1dYV1NYWFZZWFZaWVVaWVdaWlhbVlNbWlhcW1lcXFpdXFpdXVteXVtfWldfW1hfW1pfXV5fXlpgXVhgX11hXVphYF5hYV9iYV9iYmBiYmJjYWJjYl5jYmBjY2FkY2FkZGJnZmRoY2BoZ2NpaWdqaWdtaWhtamVvbmxvb21wa2hwb21xcXF0c3F3dnR3d3V5d3h5eHR5eHZ5eXl7e3l8fXh+fnx+foCAgH6AgICCgX+CgoCDg4GFhYOJiYeLi4uSkY2TkpCXlZaXl5WYlJOcm5menZuenpyenp6gn50GDE8vAAAANnRSTlMAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAARLDqn1+tMeuzdAAAAy0lEQVQI12MwyCrgVtCT0JdX4wgpZWbICzQvFpAW1RBnDQsLN2KQTQ71yxHQE2TPtAqrE2LQFyqx9iyX4oww863Q02cQ0ufKCLaojrXxr1VS0GBQVdFji/Jxc/dv0BPR02CQUZDTMvRJtIvhk9fj12dQVddlivNyjXRJ5dHWk2RQ0mNJcvCvKPQLyJdWEGTQY4m3965R5su1dE5T0GNgTHFwMlWWkhLNdoyukmBI9wiq1NQR1lHhLbINNWFgKKtX1BcSU+XV408wlgAAthYo/kRLZzAAAAAASUVORK5CYII="></a>
	<div class="success"><span>Thanks for subscribing. Check your inbox soon!</span></div>
</div>