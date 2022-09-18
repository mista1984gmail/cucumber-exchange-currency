package com.example.cucumberexchangecurrency.service.impl;

import com.example.cucumberexchangecurrency.model.Customer;
import com.example.cucumberexchangecurrency.model.OperationOrder;
import com.example.cucumberexchangecurrency.model.TradeAction;
import com.example.cucumberexchangecurrency.service.CustomerService;
import com.example.cucumberexchangecurrency.service.InterestBankRateService;
import com.example.cucumberexchangecurrency.service.InterestOrderService;
import com.example.cucumberexchangecurrency.service.OrderService;
import com.example.cucumberexchangecurrency.service.dto.OrderDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class InterestOrderServiceImpl implements InterestOrderService {
    private final OrderService orderService;
    private final CustomerService customerService;
    private final InterestBankRateService interestBankRateService;
    private final ModelMapper modelMapper;


    @Override
    @Transactional
    public OrderDto operationInterestOrder(OperationOrder operationOrder) {
        log.info("Find interest bank rate");
        var interestBankRate =
                interestBankRateService.findInterestBankRate(
                        operationOrder.getPairCurrency(),
                        operationOrder.getTradeAction());
        log.info("Find customer");
        var customer = modelMapper.map(customerService.findById(operationOrder.getIdCustomer()), Customer.class);
        log.info("Create order");
        var order = new OrderDto(
                interestBankRate,
                customer,
                operationOrder.getAmount(),
                UUID.randomUUID().toString(),
                TradeAction.valueOf(operationOrder.getTradeAction()));
        log.info("Save order");
        return orderService.save(order);
    }
}
