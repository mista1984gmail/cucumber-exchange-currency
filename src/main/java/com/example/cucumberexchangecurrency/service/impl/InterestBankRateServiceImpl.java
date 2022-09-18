package com.example.cucumberexchangecurrency.service.impl;

import com.example.cucumberexchangecurrency.model.BankRate;
import com.example.cucumberexchangecurrency.model.TradeAction;
import com.example.cucumberexchangecurrency.service.InterestBankRateService;
import com.example.cucumberexchangecurrency.service.InterestCurrencyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class InterestBankRateServiceImpl implements InterestBankRateService {
    private final InterestCurrencyService interestCurrencyService;

    @Override
    public BankRate findInterestBankRate(String pairCurrency, String tradeAction) {
        log.info("Find bank rate for trade action {} for pair currency {}", tradeAction, pairCurrency);
        return tradeAction.equals(TradeAction.BUY.name()) ?
                interestCurrencyService.findBestCurrencyRateForBuy(pairCurrency)
                : interestCurrencyService.findBestCurrencyRateForSell(pairCurrency);
    }
}
