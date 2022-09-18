package com.example.cucumberexchangecurrency.steps;

import com.example.cucumberexchangecurrency.bootstrup.DataLoaderForTest;
import com.example.cucumberexchangecurrency.model.*;
import com.example.cucumberexchangecurrency.service.InterestOrderService;
import com.example.cucumberexchangecurrency.service.OrderService;
import com.example.cucumberexchangecurrency.service.dto.OrderDto;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderStepsCreate {
    @Autowired
    InterestOrderService interestOrderService;
    @Autowired
    OrderService orderService;

    @Autowired
    DataLoaderForTest dataLoaderForTest;

    OperationOrder operationOrder;
    List<OrderDto> orders;
    OrderDto order;

    @Given("I create order with idCustomer {long}, pairCurrency {string}, tradeAction {string}, amount {double} and store to database")
    public void createOrderAndStoreToDatabase(Long id, String pairCurrency, String tradeAction, Double amount) {
        dataLoaderForTest.createDataForOrderCreateSteps();

        operationOrder = new OperationOrder(id, pairCurrency, tradeAction, amount);
        interestOrderService.operationInterestOrder(operationOrder);

    }

    @When("I search that orders")
    public void searchOrders() {
        orders = orderService.findAll();
        order = orders.get(0);
    }

    @Then("I should find result order")
    public void shouldFindAtLeastOneResult() {
        Assertions.assertEquals(1, orders.size());
        Assertions.assertEquals(1000.0, order.getAmount());
        Assertions.assertEquals(1.0007, order.getBankRate().getRate());
    }

}
