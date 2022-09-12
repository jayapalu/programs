package com.jay.ps.api.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jay.ps.api.controller.PaymentController;
import com.jay.ps.api.entity.Payment;
import com.jay.ps.api.repository.PaymentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    private Logger Log = LoggerFactory.getLogger(PaymentService.class);
    public Payment doPayment(Payment payment) throws JsonProcessingException {

        payment.setTransactionId(UUID.randomUUID().toString());
        payment.setPaymentStatus(paymentProcessing());
        Log.info("Payment service: payment {}", new ObjectMapper().writeValueAsString(payment));
        return paymentRepository.save(payment);
    }

    public String paymentProcessing() {

        return new Random().nextBoolean() ? "Success" : "false";

    }
}
