package com.accenture.coffee.exception;

import com.accenture.coffee.dto.CoffeeProcessorExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Custom exception handler class of the application
 *@author rahuljsr88@gmail.com
 */
@RestControllerAdvice
public class CoffeeProcessorExceptionHandler {

    @ExceptionHandler(CoffeeProcessorException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public CoffeeProcessorExceptionDto handleCoffeeProcessorException(CoffeeProcessorException ex) {
        return new CoffeeProcessorExceptionDto(ex.code, ex.severity, ex.status, ex.getMessage());
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ResponseBody
    public CoffeeProcessorExceptionDto handleInvalidRequestMethodException(HttpRequestMethodNotSupportedException ex) {
        return new CoffeeProcessorExceptionDto(CoffeeProcessorErrorDetails.COFFEE_PROCESSOR_INVALID_REQUEST_METHOD_EXCEPTION.getCode(),
                CoffeeProcessorErrorDetails.COFFEE_PROCESSOR_INVALID_REQUEST_METHOD_EXCEPTION.getSeverity(),
                CoffeeProcessorErrorDetails.COFFEE_PROCESSOR_INVALID_REQUEST_METHOD_EXCEPTION.getStatus(),
                CoffeeProcessorErrorDetails.COFFEE_PROCESSOR_INVALID_REQUEST_METHOD_EXCEPTION.getMessage());
    }
}
