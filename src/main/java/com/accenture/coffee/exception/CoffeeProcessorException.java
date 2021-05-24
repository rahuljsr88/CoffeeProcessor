package com.accenture.coffee.exception;

import com.accenture.coffee.domain.ExceptionSeverityType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * Custom exceptions class of the application
 *@author rahuljsr88@gmail.com
 */

@AllArgsConstructor
@Getter
@Setter
public class CoffeeProcessorException extends RuntimeException{
    String code;
    ExceptionSeverityType severity;
    HttpStatus status;
    String message;
}
