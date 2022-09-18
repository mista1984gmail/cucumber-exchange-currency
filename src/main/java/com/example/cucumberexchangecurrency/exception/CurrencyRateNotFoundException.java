package com.example.cucumberexchangecurrency.exception;

import java.util.Map;

public class CurrencyRateNotFoundException extends ApplicationException{
    public CurrencyRateNotFoundException(ErrorResponse errorResponse, Map<String, Object> messageArguments) {
        super(errorResponse, messageArguments);
    }
}
