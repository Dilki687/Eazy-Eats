package com.food.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PaymentResponse {
    public void setPayment_url(String payment_url) {
        this.payment_url = payment_url;
    }

    @JsonProperty("payment_url")
    private String payment_url;
}
