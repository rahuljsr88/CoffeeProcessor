package com.accenture.coffee.controller;

import com.accenture.coffee.dto.UserDto;
import com.accenture.coffee.service.CoffeeProcessorDbService;
import com.accenture.coffee.service.CoffeeProcessorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author rahuljsr88@gmail.com
 */

@RunWith(SpringRunner.class)
@WebMvcTest(CoffeeController.class)
public class CoffeeControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @MockBean
    private CoffeeProcessorService coffeeProcessorService;
    @MockBean
    private CoffeeProcessorDbService coffeeProcessorDbService;


    @Test
    public void test_whenInvokeGet_thenReturnPaymentSummary() throws Exception {
        List<UserDto> paymentSummaryResponse = new ArrayList<>();
        given(coffeeProcessorService.getUserPaymentSummary()).willReturn(paymentSummaryResponse);

        mockMvc.perform(get("/coffee/paymentsummary"))
                .andExpect(status().isOk());
    }

    @Test
    public void test_whenInvokePOST_thenReturnInvalidMethodException() throws Exception {
        List<UserDto> paymentSummaryResponse = new ArrayList<>();
        given(coffeeProcessorService.getUserPaymentSummary()).willReturn(paymentSummaryResponse);

        mockMvc.perform(post("/coffee/paymentsummary"))
                .andExpect(status().isMethodNotAllowed());
    }


}
