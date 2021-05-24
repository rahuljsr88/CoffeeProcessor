package com.accenture.coffee.exception;

import com.accenture.coffee.domain.ExceptionSeverityType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * Enum to initialize and define the different custom exceptions of the application
 *@author rahuljsr88@gmail.com
 */

@AllArgsConstructor
@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum CoffeeProcessorErrorDetails {
    COFFEE_PROCESSOR_INVALID_PRODUCT_EXCEPTION("CPA-0001", ExceptionSeverityType.ERROR, HttpStatus.BAD_REQUEST, "Invalid request exception"),
    COFFEE_PROCESSOR_NOT_FOUND_EXCEPTION("CPA-0002", ExceptionSeverityType.ERROR, HttpStatus.NOT_FOUND, "Invalid request exception"),
    COFFEE_PROCESSOR_TERMINATED_EXCEPTION("CPA-0003", ExceptionSeverityType.ERROR, HttpStatus.BAD_REQUEST, "Invalid request exception"),
    COFFEE_PROCESSOR_INVALID_REQUEST_METHOD_EXCEPTION("CPA-0004", ExceptionSeverityType.ERROR, HttpStatus.METHOD_NOT_ALLOWED, "Invalid request exception");

    private final String code;
    private final ExceptionSeverityType severity;
    private final HttpStatus status;
    private final String message;

}
