package com.example.cucumberexchangecurrency.service.impl;

import com.example.cucumberexchangecurrency.exception.ApplicationException;
import com.example.cucumberexchangecurrency.exception.CustomerNotFoundException;
import com.example.cucumberexchangecurrency.exception.Errors;
import com.example.cucumberexchangecurrency.repository.CustomerRepository;
import com.example.cucumberexchangecurrency.service.CustomerService;
import com.example.cucumberexchangecurrency.service.dto.CustomerDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;
    @Override
    public CustomerDto findById(Long id) {
        log.info("Find customer by id: {}", id);
        return customerRepository.findById(id)
                .map(customer -> modelMapper.map(customer, CustomerDto.class))
                .orElseThrow(() -> new CustomerNotFoundException(Errors.CUSTOMER_NOT_FOUND, Map.of("id", id)));
    }


}
