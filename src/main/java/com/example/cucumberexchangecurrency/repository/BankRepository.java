package com.example.cucumberexchangecurrency.repository;

import com.example.cucumberexchangecurrency.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank, Long> {
}
