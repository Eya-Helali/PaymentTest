package com.example.PaymentGateway.Order;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PaymentResponse {
    @JsonProperty("payUrl")
    private String payUrl;
    @JsonProperty("paymentRef")
    private String paymentRef;
}
