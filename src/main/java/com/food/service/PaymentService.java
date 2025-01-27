package com.food.service;

import com.food.model.Order;
import com.food.response.PaymentResponse;
import com.stripe.exception.StripeException;
import lombok.Data;

public interface PaymentService{
    public PaymentResponse createPaymentLink(Order order) throws StripeException;
}
