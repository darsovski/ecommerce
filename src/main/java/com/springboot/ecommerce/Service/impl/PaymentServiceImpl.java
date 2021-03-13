package com.springboot.ecommerce.Service.impl;


import com.springboot.ecommerce.Service.PaymentService;
import com.springboot.ecommerce.model.dto.ChargeRequest;
import com.stripe.Stripe;
import com.stripe.exception.ApiConnectionException;
import com.stripe.exception.ApiException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.model.Charge;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentServiceImpl implements PaymentService {

    public String secretKey="sk_test_51I0d8CFAKR0jvX1M1vVJrPOtSU9ozuJyJjAZqoZ4uw0FdCr5ST7ZAw25GkEOBZZiiRkbCegzdgPYiQhOKHILqspU00r3VVSKrA";

    @PostConstruct
    public void init() {
        Stripe.apiKey = this.secretKey;
    }

    @Override
    public Charge pay(ChargeRequest chargeRequest) throws ApiException, InvalidRequestException, ApiConnectionException, AuthenticationException, com.stripe.exception.CardException {
       /* Map<String, Object> chargeMap = new HashMap<>();
        chargeMap.put("amount", chargeRequest.getAmount());
        chargeMap.put("currency", chargeRequest.getCurrency());
        chargeMap.put("source", chargeRequest.getStripeToken());
        chargeMap.put("description", chargeRequest.getDescription());
        return Charge.create(chargeMap);*/
       return null;
    }

}
