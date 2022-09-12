package com.jay.ps.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jay.ps.api.entity.Payment;
import com.jay.ps.api.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {


    @Autowired
    PaymentService paymentService;

    private Logger Log = LoggerFactory.getLogger(PaymentController.class);

    @PostMapping("/dopayment")
    public Payment doPayment(@RequestBody Payment payment) throws JsonProcessingException {

        Log.info("Payment service: controller POST dopayment  is called ");
        return paymentService.doPayment(payment);
    }
}
