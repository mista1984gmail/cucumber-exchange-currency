package com.example.cucumberexchangecurrency.service;

import com.example.cucumberexchangecurrency.service.dto.OrderDto;

import java.util.List;

public interface OrderService {
    OrderDto save(OrderDto orderDto);
    OrderDto findByCode(String code);
    List<OrderDto> findAll();
}
