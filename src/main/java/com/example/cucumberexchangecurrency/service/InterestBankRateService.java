package com.example.cucumberexchangecurrency.service;

import com.example.cucumberexchangecurrency.model.BankRate;

public interface InterestBankRateService {

    BankRate findInterestBankRate(String pairCurrency, String tradeAction);
}
