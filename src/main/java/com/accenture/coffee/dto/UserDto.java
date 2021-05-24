package com.accenture.coffee.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO class for the User Payments Summary response wrapper
 *@author rahuljsr88@gmail.com
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String name;
    private Double amountPaid;
    @JsonIgnore
    private Double billAmount;
    private Double amountOwed;
}
