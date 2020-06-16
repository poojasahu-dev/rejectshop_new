<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags" %>

<script src="https://www.paypalobjects.com/api/checkout.js"></script>

<spring:url value="/paypal/b2b/replenishment/ec/payment" var="replenishmentUrl"/>
<spring:url value="/paypal/b2b/mark/ec/payment" var="markUrl"/>
<spring:url value="/paypal/b2b/checkout/payment/authorize/response" var="authorizeUrl"/>
<spring:url value="/" var="homeUrl"/>

<!-- Render the radio fields and button containers -->

<label>
    <input id="paymentMethodPayPal" type="radio" name="paymentMethodSelection" value="paypal" checked/>
    <img src="${media.url}" alt="${media.altText}" />
    <span id="whatIsPayPalLink" style="padding-left: 10px;"><cms:component component="${link}" /></span>
</label>

</p>
<label>
    <input id="paymentMethodCC" type="radio" name="paymentMethodSelection" value="cc"/>
    <label for="paymentMethodCC" id="creditCardLabelId" class="headline"><spring:theme code="checkout.multi.paymentMethod.addPaymentDetails.method.card"/></label>
</label>

<script>

    var SETEC_URL = "${markUrl}";
    function checkReplenishment(){
        var checkbox = document.getElementById('isPayPalReplenishment');
        if (checkbox.checked == true){
            SETEC_URL = "${replenishmentUrl}";
        } else{
            SETEC_URL = "${markUrl}";
        }
    }

    if (typeof paypal == "undefined") {
        var tag = document.createElement("script");
        tag.src = "https://www.paypalobjects.com/api/checkout.js";
        document.getElementsByTagName("body")[0].appendChild(tag)
    }

    var locale = "${locale}";
    var label = "${label.code}";
    var size = "${size.code}";
    var shape = "${shape.code}";
    var color = "${color.code}";
    var layout = "${layout.code}";
    var tagline = ${tagline};
    var branding = ${branding};
    var fundingIcons = ${fundingIcons};
    var fundingAllowed = "${fundingAllowed}".toLowerCase().slice(1, -1).split(", ");
    var fundingDisallowed = "${fundingDisallowed}".toLowerCase().slice(1, -1).split(", ");
    var style;

    if (fundingAllowed[0] === "") {
        fundingAllowed = [];
    }

    if (fundingDisallowed[0] === "") {
        fundingDisallowed = [];
    }

    style = {
        shape: shape,
        layout: layout
    }

    if ("${label.code}" != "credit") {
        style.color = color;
    }

    if ("${layout.code}" != "vertical") {
        style.size = size;
        style.label = label;
        style.tagline = tagline;
        style.fundingicons = fundingIcons;
    }

    if (label == "buynow" && branding == true){
        style.branding = true;
    }

    // Render the PayPal button

    var waitForSdk = setInterval(function () {

        if (typeof paypal !== "undefined") {
            clearInterval(waitForSdk);

            paypal.Button.render({

                locale: locale,

                commit: ${commit},

                // Specify the style of the button

                style: style,

                funding: {
                    allowed: fundingAllowed,
                    disallowed: fundingDisallowed
                },

                ${customJsConfig}

                // Set your environment

                env: "${env}", // sandbox | production

                // PayPal Client IDs - replace with your own
                // Create a PayPal app: https://developer.paypal.com/developer/applications/create

                client: {
                    sandbox: "${client}",
                    production: "${client}"
                },

                // Wait for the PayPal button to be clicked

                payment: function (data, actions) {

                    return $.post(SETEC_URL).then(function (res) {
                        if (res.responseStatus == "success") {
                            return res.token;
                        }
                        else {
                            var url = "${homeUrl}" + res.redirectUrl;
                            window.location.replace(url);
                        }

                        // original paypal request code
                        // return paypal.request.post(SETEC_URL).then(function(res) {
                        //     return res.token;

                    });

                },

                // Wait for the payment to be authorized by the customer

                onAuthorize: function (data, actions) {
                    actions.close();
                    return new paypal.Promise(function (resolve, reject) {
                        var DOEC_URL = "${authorizeUrl}";

                        var params = {
                            paymentToken: data.paymentToken,
                            payerID: data.payerID
                        };
                        return paypal.request.get(DOEC_URL, params)
                            .then(function (res) {
                                var url = "${homeUrl}" + res.redirectUrl;
                                window.location.replace(url);
                            })
                            .catch(function (err) {
                                reject(err);
                            });
                    });
                }

            }, "#mark-paypal-button-container");
        }
    }, 100);

</script>
