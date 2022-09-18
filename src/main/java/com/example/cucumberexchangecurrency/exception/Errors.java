package com.example.cucumberexchangecurrency.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum Errors implements ErrorResponse{
    CUSTOMER_NOT_FOUND( "CUSTOMER_NOT_FOUND", HttpStatus.NOT_FOUND , "Customer with id {id} not found"),
    CURRENCY_RATE_NOT_FOUND( "CURRENCY_RATE_NOT_FOUND", HttpStatus.NOT_FOUND , "Currency rate {currency} not found");

    String key;
    HttpStatus httpStatus;
    String message;

}
