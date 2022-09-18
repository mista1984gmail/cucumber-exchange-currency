package com.example.cucumberexchangecurrency.service;

import com.example.cucumberexchangecurrency.model.BankRate;
import com.example.cucumberexchangecurrency.model.PairCurrency;

import java.util.Currency;
import java.util.Map;
import java.util.Optional;

public interface InterestCurrencyService {
    BankRate findBestCurrencyRateForSell(String currency);
    BankRate findBestCurrencyRateForBuy(String currency);
}
