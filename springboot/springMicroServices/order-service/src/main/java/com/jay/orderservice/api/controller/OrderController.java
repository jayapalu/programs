package com.jay.orderservice.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jay.orderservice.api.common.Payment;
import com.jay.orderservice.api.common.TransactionRequest;
import com.jay.orderservice.api.common.TransactionResponse;
import com.jay.orderservice.api.entity.Order;
import com.jay.orderservice.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @PostMapping("/bookorder")
    public TransactionResponse bookOrder(@RequestBody TransactionRequest transactionRequest) throws JsonProcessingException {
        return orderService.saveOrder(transactionRequest);
    }

}
