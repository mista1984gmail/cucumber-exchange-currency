package com.example.cucumberexchangecurrency.repository;

import com.example.cucumberexchangecurrency.model.BankRate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRateRepository extends JpaRepository<BankRate, Long> {
}
