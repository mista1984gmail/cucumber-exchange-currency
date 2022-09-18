package com.example.cucumberexchangecurrency.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class OperationOrder {
    @NotNull
    private Long idCustomer;
    @NotNull
    private String pairCurrency;
    @NotNull
    private String tradeAction;
    @NotNull
    @Min(100)
    private Double amount;

}
