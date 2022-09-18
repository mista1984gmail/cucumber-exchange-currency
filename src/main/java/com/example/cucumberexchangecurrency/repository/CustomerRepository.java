package com.example.cucumberexchangecurrency.repository;


import com.example.cucumberexchangecurrency.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
