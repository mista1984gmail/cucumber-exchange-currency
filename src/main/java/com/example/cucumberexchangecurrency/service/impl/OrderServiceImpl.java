package com.example.cucumberexchangecurrency.service.impl;

import com.example.cucumberexchangecurrency.model.Order;
import com.example.cucumberexchangecurrency.repository.OrderRepository;
import com.example.cucumberexchangecurrency.service.OrderService;
import com.example.cucumberexchangecurrency.service.dto.OrderDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;
    @Override
    @Transactional
    public OrderDto save(OrderDto orderDto) {
        log.info("Save order with code {}", orderDto.getCode());
        return modelMapper.map(
                orderRepository.save(modelMapper.map(orderDto, Order.class)), OrderDto.class);
    }

    @Override
    public OrderDto findByCode(String code) {
        log.info("Find order with code: {}", code);
        return modelMapper.map(orderRepository.findByCode(code), OrderDto.class);
    }

    @Override
    public List<OrderDto> findAll() {
        log.info("Find all orders");
        return orderRepository.findAll().stream()
                .map(order -> modelMapper.map(order, OrderDto.class))
                .collect(toList());
    }
}
