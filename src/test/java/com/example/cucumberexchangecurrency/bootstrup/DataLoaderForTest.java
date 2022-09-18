package com.example.cucumberexchangecurrency.bootstrup;

import com.example.cucumberexchangecurrency.model.Bank;
import com.example.cucumberexchangecurrency.model.BankRate;
import com.example.cucumberexchangecurrency.model.Customer;
import com.example.cucumberexchangecurrency.model.PairCurrency;
import com.example.cucumberexchangecurrency.repository.BankRateRepository;
import com.example.cucumberexchangecurrency.repository.BankRepository;
import com.example.cucumberexchangecurrency.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
@Component
public class DataLoaderForTest {
    @Autowired
    BankRepository bankRepository;

    @Autowired
    BankRateRepository bankRateRepository;

    @Autowired
    CustomerRepository customerRepository;

    public void createDataForOrderCreateSteps() {
        Set<BankRate> bankRates1 = new HashSet<>();
        BankRate bankRate1 = bankRateRepository.save(new BankRate(LocalDateTime.of(2022, 8, 31, 12, 30), PairCurrency.EURUSD, 1.0007));
        BankRate bankRate2 = bankRateRepository.save(new BankRate(LocalDateTime.of(2022, 8, 31, 12, 30), PairCurrency.AUDUSD, 0.6821));
        BankRate bankRate3 = bankRateRepository.save(new BankRate(LocalDateTime.of(2022, 8, 31, 12, 30), PairCurrency.USDCHF, 0.9832));

        bankRates1.add(bankRate1);
        bankRates1.add(bankRate2);
        bankRates1.add(bankRate3);

        bankRepository.save(new Bank(1L, "PriorBank", bankRates1));

        Customer customer = new Customer();
        customer.setId(1L);
        customer.setFullName("Stas Mitskevich");
        customerRepository.save(customer);
    }

    public void createDataForFindInterestBankRateSteps() {
        Set<BankRate> bankRates1 = new HashSet<>();
        BankRate bankRate1 = bankRateRepository.save(new BankRate( LocalDateTime.of(2022, 8, 31, 12, 30), PairCurrency.EURUSD, 1.0007));
        BankRate bankRate2 = bankRateRepository.save(new BankRate( LocalDateTime.of(2022, 8, 31, 12, 30), PairCurrency.AUDUSD, 0.6821));
        BankRate bankRate3 = bankRateRepository.save(new BankRate( LocalDateTime.of(2022, 8, 31, 12, 30), PairCurrency.USDCHF, 0.9832));

        bankRates1.add(bankRate1);
        bankRates1.add(bankRate2);
        bankRates1.add(bankRate3);

        bankRepository.save(new Bank(1L, "PriorBank", bankRates1));



        Set<BankRate> bankRates2 = new HashSet<>();
        BankRate bankRate4 = bankRateRepository.save(new BankRate(LocalDateTime.of(2022, 8, 31, 12, 30), PairCurrency.EURUSD, 1.0018));
        BankRate bankRate5 = bankRateRepository.save(new BankRate(LocalDateTime.of(2022, 8, 31, 12, 30), PairCurrency.AUDUSD, 0.6800));
        BankRate bankRate6 = bankRateRepository.save(new BankRate(LocalDateTime.of(2022, 8, 31, 12, 30), PairCurrency.USDCHF, 0.9932));

        bankRates2.add(bankRate4);
        bankRates2.add(bankRate5);
        bankRates2.add(bankRate6);

         bankRepository.save(new Bank( 2L, "Belarusbank", bankRates2));


        Set<BankRate> bankRates3 = new HashSet<>();
        BankRate bankRate7 = bankRateRepository.save(new BankRate(LocalDateTime.of(2022, 8, 31, 12, 30), PairCurrency.EURUSD, 1.0058));
        BankRate bankRate8 = bankRateRepository.save(new BankRate(LocalDateTime.of(2022, 8, 31, 12, 30), PairCurrency.AUDUSD, 0.6921));
        BankRate bankRate9 = bankRateRepository.save(new BankRate(LocalDateTime.of(2022, 8, 31, 12, 30), PairCurrency.USDCHF, 0.9872));

        bankRates3.add(bankRate7);
        bankRates3.add(bankRate8);
        bankRates3.add(bankRate9);

        bankRepository.save(new Bank(3L, "Agroprombank", bankRates3));
    }
}
