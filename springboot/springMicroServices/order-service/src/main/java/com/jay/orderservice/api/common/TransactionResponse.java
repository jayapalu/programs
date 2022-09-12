package com.jay.orderservice.api.common;

import com.jay.orderservice.api.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionResponse {

    Order order;
    double amount;
    String transactionId;
    String message;

}
