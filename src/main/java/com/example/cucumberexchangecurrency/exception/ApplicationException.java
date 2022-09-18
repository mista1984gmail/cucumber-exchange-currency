package com.example.cucumberexchangecurrency.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.text.StringSubstitutor;

import java.util.Map;


@Slf4j
@Getter
@AllArgsConstructor
public class ApplicationException extends RuntimeException{
    private final ErrorResponse errorResponse;
    private final Map<String, Object> messageArguments;
    @Override
    public String getMessage() {
        return messageArguments.isEmpty() ? errorResponse.getMessage() :
                StringSubstitutor.replace(errorResponse.getMessage(), messageArguments, "{", "}");
    }

}
