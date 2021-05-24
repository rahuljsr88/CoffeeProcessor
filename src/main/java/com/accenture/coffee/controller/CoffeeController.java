package com.accenture.coffee.controller;

import com.accenture.coffee.dto.UserDto;
import com.accenture.coffee.service.CoffeeProcessorService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

import static com.accenture.coffee.config.ApplicationEndpoints.ENDPOINT_PREFIX;
import static com.accenture.coffee.config.ApplicationEndpoints.GET_PAYMENT_SUMMARY_ENDPOINT;

/**
 * The main controller for the application which defines the endpoints and redirects requests.
 * @author rahuljsr88@gmail.com
 *
 */



@RestController
@RequestMapping(ENDPOINT_PREFIX)
public class CoffeeController {
    private final CoffeeProcessorService service;
    public CoffeeController(CoffeeProcessorService service) {
        this.service = service;
    }

    @ApiOperation(value = "Fetch the payment summary",
            notes = "Fetches the payment summary per user for the amount paid and the amount owed")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Payment summary has been fetched Successfully"),
    })
    @GetMapping(value = GET_PAYMENT_SUMMARY_ENDPOINT, produces = MediaType.APPLICATION_JSON)
    public List<UserDto> fetchSummary() {
        return service.getUserPaymentSummary();
    }
}
