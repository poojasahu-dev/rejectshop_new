package com.paypal.hybris.addon.model;

public class TokenResponse {

    String responseStatus;
    String token;
    String redirectUrl;

    public TokenResponse() {
        this.responseStatus = "error";
    }

    public TokenResponse(String token) {
        this.responseStatus = "success";
        this.token = token;
    }

    public TokenResponse(String responseStatus, String token) {
        this.responseStatus = responseStatus;
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(String responseStatus) {
        this.responseStatus = responseStatus;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }
}
