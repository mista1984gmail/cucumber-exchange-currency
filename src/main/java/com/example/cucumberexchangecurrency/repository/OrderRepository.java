package com.example.cucumberexchangecurrency.repository;

import com.example.cucumberexchangecurrency.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findByCode (String code);
}
