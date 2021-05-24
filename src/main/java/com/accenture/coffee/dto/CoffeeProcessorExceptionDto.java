package com.accenture.coffee.dto;

import com.accenture.coffee.domain.ExceptionSeverityType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * Exception DTO class for the custom Exception of the application
 * @author rahuljsr88@gmail.com
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CoffeeProcessorExceptionDto {
    private String code;
    private ExceptionSeverityType severity;
    private HttpStatus status;
    private String message;

}
