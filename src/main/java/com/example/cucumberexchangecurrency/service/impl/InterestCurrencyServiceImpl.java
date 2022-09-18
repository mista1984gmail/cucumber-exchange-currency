package com.example.cucumberexchangecurrency.service.impl;

import com.example.cucumberexchangecurrency.exception.ApplicationException;
import com.example.cucumberexchangecurrency.exception.CurrencyRateNotFoundException;
import com.example.cucumberexchangecurrency.exception.Errors;
import com.example.cucumberexchangecurrency.model.BankRate;
import com.example.cucumberexchangecurrency.service.BankService;
import com.example.cucumberexchangecurrency.service.InterestCurrencyService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.Map;

@Slf4j
@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class InterestCurrencyServiceImpl implements InterestCurrencyService {

    private final BankService bankService;

    @Override
    public BankRate findBestCurrencyRateForSell(String currency) {
        log.info("Find best currency rate for sell for pair currency {}", currency);
        return bankService.findAll()
                .stream()
                .flatMap(bank -> bank.getBankRates().stream())
                .filter(bankRate -> bankRate.getPairCurrency().name().equals(currency))
                .max(Comparator.comparing(BankRate::getRate))
                .orElseThrow(() -> new CurrencyRateNotFoundException(Errors.CURRENCY_RATE_NOT_FOUND, Map.of("currency", currency)));

    }

    @Override
    public BankRate findBestCurrencyRateForBuy(String currency) {
        log.info("Find best currency rate for buy for pair currency {}", currency);
        return bankService.findAll()
                .stream()
                .flatMap(bank -> bank.getBankRates().stream())
                .filter(bankRate -> bankRate.getPairCurrency().name().equals(currency))
                .min(Comparator.comparing(BankRate::getRate))
                .orElseThrow(() -> new CurrencyRateNotFoundException(Errors.CURRENCY_RATE_NOT_FOUND, Map.of("currency", currency)));
    }

}
