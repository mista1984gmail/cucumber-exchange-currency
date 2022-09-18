package com.example.cucumberexchangecurrency.web;

import com.example.cucumberexchangecurrency.model.BankRate;
import com.example.cucumberexchangecurrency.model.OperationOrder;
import com.example.cucumberexchangecurrency.model.Order;
import com.example.cucumberexchangecurrency.service.InterestCurrencyService;
import com.example.cucumberexchangecurrency.service.InterestOrderService;
import com.example.cucumberexchangecurrency.service.dto.OrderDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/interest-currency")
public class TestController {
    private final InterestCurrencyService interestCurrencyService;
    private final InterestOrderService interestOrderService;

    @GetMapping("/{tradeAction}/{pairCurrency}")
    @ResponseStatus(HttpStatus.OK)
    public BankRate findBestCurrencyRate(@PathVariable String tradeAction, @PathVariable String pairCurrency) {
        return tradeAction.equals("BUY") ?
                interestCurrencyService.findBestCurrencyRateForBuy(pairCurrency)
                : interestCurrencyService.findBestCurrencyRateForSell(pairCurrency);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public OrderDto save(@Valid @RequestBody OperationOrder operationOrder) {
        return interestOrderService.operationInterestOrder(operationOrder);
    }


}
