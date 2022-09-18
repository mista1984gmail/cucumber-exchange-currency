package com.example.cucumberexchangecurrency.service.dto;

import com.example.cucumberexchangecurrency.model.BankRate;
import com.example.cucumberexchangecurrency.model.Customer;
import com.example.cucumberexchangecurrency.model.TradeAction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    private BankRate bankRate;
    private Customer customer;
    private Double amount;
    private String code;
    private TradeAction tradeAction;



}
