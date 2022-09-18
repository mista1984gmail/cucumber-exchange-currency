package com.example.cucumberexchangecurrency.exception;

import java.util.Map;

public class CustomerNotFoundException extends ApplicationException{
    public CustomerNotFoundException(ErrorResponse errorResponse, Map<String, Object> messageArguments) {
        super(errorResponse, messageArguments);
    }
}
