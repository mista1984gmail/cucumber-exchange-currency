package com.example.cucumberexchangecurrency.service;

import com.example.cucumberexchangecurrency.model.OperationOrder;
import com.example.cucumberexchangecurrency.service.dto.OrderDto;

public interface InterestOrderService {
    OrderDto operationInterestOrder(OperationOrder operationOrder);
}
