package com.example.cucumberexchangecurrency.service;

import com.example.cucumberexchangecurrency.service.dto.CustomerDto;

public interface CustomerService {
    CustomerDto findById(Long id);
}
