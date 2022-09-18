package com.example.cucumberexchangecurrency.steps;

import com.example.cucumberexchangecurrency.bootstrup.DataLoaderForTest;
import com.example.cucumberexchangecurrency.model.BankRate;
import com.example.cucumberexchangecurrency.service.InterestBankRateService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

public class FindInterestBankRateSteps {
    @Autowired
    InterestBankRateService interestBankRateService;

    @Autowired
    DataLoaderForTest dataLoaderForTest;

    BankRate bankRate;

    @Given("Load data for test")
    public void findInterestBanRate() {
        dataLoaderForTest.createDataForFindInterestBankRateSteps();
    }

    @When("I find best rate for pairCurrency {string} on tradeAction {string}")
    public void findInterestBankRate(String pairCurrency, String tradeAction) {
        bankRate = interestBankRateService.findInterestBankRate(pairCurrency, tradeAction);
    }

    @Then("I should find bankRate with best rate {double}")
    public void shouldFindAtLeastOneResult(Double rate) {
        Assertions.assertNotNull(bankRate);
        Assertions.assertEquals(rate, bankRate.getRate());
    }

}
