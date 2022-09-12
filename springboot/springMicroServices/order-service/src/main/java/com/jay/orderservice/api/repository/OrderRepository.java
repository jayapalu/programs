package com.jay.orderservice.api.repository;

import com.jay.orderservice.api.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    //JPARepository <Model class, Primary key type>

}
