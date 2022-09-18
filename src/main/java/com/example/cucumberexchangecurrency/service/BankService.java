package com.example.cucumberexchangecurrency.service;

import com.example.cucumberexchangecurrency.service.dto.BankDto;

import java.util.List;

public interface BankService {
        List<BankDto> findAll();
}
