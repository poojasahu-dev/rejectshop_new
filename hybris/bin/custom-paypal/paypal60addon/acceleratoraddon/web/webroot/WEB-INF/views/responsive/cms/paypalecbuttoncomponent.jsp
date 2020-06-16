<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div id="paypal-button-container"></div>

<spring:url value="/paypal/ec/payment" var="ecPaymentUrl"/>
<spring:url value="/paypal/checkout/payment/authorize/response" var="authorizeUrl"/>
<spring:url value="/" var="homeUrl"/>

<script>

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

    document.getElementById("paypal-button-container").id = "${buttonDiv}";


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

                    var SETEC_URL = "${ecPaymentUrl}";

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

            }, "#" + "${buttonDiv}");
        }
    }, 100);

</script>
