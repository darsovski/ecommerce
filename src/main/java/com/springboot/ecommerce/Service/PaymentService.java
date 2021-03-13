package com.springboot.ecommerce.Service;

import com.springboot.ecommerce.model.dto.ChargeRequest;
import com.stripe.exception.ApiConnectionException;
import com.stripe.exception.ApiException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.model.Charge;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;

@Service
public interface PaymentService {
    Charge pay(ChargeRequest chargeRequest) throws CardException, ApiException, AuthenticationException, InvalidRequestException, ApiConnectionException, com.stripe.exception.AuthenticationException, com.stripe.exception.CardException;
}
