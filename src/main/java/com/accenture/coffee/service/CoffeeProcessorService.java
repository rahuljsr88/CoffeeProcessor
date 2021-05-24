package com.accenture.coffee.service;

import com.accenture.coffee.dto.UserDto;

import java.util.List;

/**
 * Business logic service interface of the application
 *@author rahuljsr88@gmail.com
 */

public interface CoffeeProcessorService {
    List<UserDto> getUserPaymentSummary();
}

