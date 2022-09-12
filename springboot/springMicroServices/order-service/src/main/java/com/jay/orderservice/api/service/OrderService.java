package com.jay.orderservice.api.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jay.orderservice.api.common.Payment;
import com.jay.orderservice.api.common.TransactionRequest;
import com.jay.orderservice.api.common.TransactionResponse;
import com.jay.orderservice.api.entity.Order;
import com.jay.orderservice.api.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestTemplate resttemplate;

    private Logger Log = LoggerFactory.getLogger(OrderService.class);

    public TransactionResponse saveOrder(TransactionRequest transactionRequest) throws JsonProcessingException {

        //Log.info("Orderservice: transaction request : {}", transactionRequest);
        //convert the transactionrequest into the json format
        Log.info("Orderservice: transaction request : {}", new ObjectMapper().writeValueAsString(transactionRequest));

        Order order = transactionRequest.getOrder();
        Payment payment = transactionRequest.getPayment();

        String paymentResponse;

        payment.setOrderId(order.getId());
        payment.setAmount(order.getPrice());

        //Make rest call to payment service

       Payment response = resttemplate.postForObject("http://PAYMENT-SERVICE/payment/dopayment", payment, Payment.class);

       Log.info("Orderservice: response from payment service response : {}", new ObjectMapper().writeValueAsString(response ));
       paymentResponse  = response.getPaymentStatus().equals("Success") ? "Payment is success order place" : "Payment is failed, order is placed in cart";


        orderRepository.save(order);
        return new TransactionResponse(order,  order.getPrice(),payment.getTransactionId(), paymentResponse);

    }
}
