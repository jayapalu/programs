package com.jay.ps.api.repository;

import com.jay.ps.api.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  PaymentRepository extends JpaRepository<Payment, Integer> {

}
