package com.accenture.coffee.service;

import com.accenture.coffee.domain.Order;
import com.accenture.coffee.domain.Payment;
import com.accenture.coffee.domain.Product;
import com.accenture.coffee.dto.UserDto;
import com.accenture.coffee.repository.OrderRepository;
import com.accenture.coffee.repository.PaymentRepository;
import com.accenture.coffee.repository.ProductRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

/**
 * @author rahuljsr88@gmail.com
 */

@RunWith(MockitoJUnitRunner.class)
public class CoffeeProcessorServiceTest {

    private CoffeeProcessorService coffeeProcessorService;
    @Mock
    private ProductRepository productRepository;
    @Mock
    private OrderRepository orderRepository;
    @Mock
    private PaymentRepository paymentRepository;
    @Mock
    private List<UserDto> userPaymentSummaryList;

    @Before
    public void init() {
        coffeeProcessorService = new CoffeeProcessorServiceImpl(productRepository, orderRepository, paymentRepository);
    }

    @Test
    public void test(){
        List<Order> orders = new ArrayList<>();
        Order order1 = new Order();
        order1.setUser("coach");
        order1.setDrink("supermochacrapucaramelcream");
        order1.setSize("large");
        orders.add(order1);
        Order order2 = new Order();
        order2.setUser("coach");
        order2.setDrink("latte");
        order2.setSize("medium");
        orders.add(order2);
        Order order3 = new Order();
        order3.setUser("nick");
        order3.setDrink("flat white");
        order3.setSize("small");
        orders.add(order3);
        Order order4 = new Order();
        order4.setUser("louis");
        order4.setDrink("mocha");
        order4.setSize("medium");
        orders.add(order4);

        List<Product> products = new ArrayList<>();
        Product product1 = new Product();
        product1.setDrink_name("supermochacrapucaramelcream");
        Map<String, Double> prices1 = new HashMap();
        prices1.put("large", 5.0);
        prices1.put("huge", 5.5);
        prices1.put("mega", 6.0);
        prices1.put("ultra", 7.0);
        product1.setPrices(prices1);
        products.add(product1);

        Product product2 = new Product();
        product2.setDrink_name("latte");
        Map<String, Double> prices2 = new HashMap();
        prices2.put("small", 3.5);
        prices2.put("medium", 4.0);
        prices2.put("large", 4.5);
        product2.setPrices(prices2);
        products.add(product2);

        Product product3 = new Product();
        product3.setDrink_name("flat white");
        Map<String, Double> prices3 = new HashMap();
        prices3.put("small", 3.5);
        prices3.put("medium", 4.0);
        prices3.put("large", 4.5);
        product3.setPrices(prices3);
        products.add(product3);

        Product product4 = new Product();
        product4.setDrink_name("mocha");
        Map<String, Double> prices4 = new HashMap();
        prices4.put("small", 4.0);
        prices4.put("medium", 4.5);
        prices4.put("large", 5.0);
        product4.setPrices(prices4);
        products.add(product4);


        List<Payment> payments = new ArrayList<>();
        Payment payment1 = new Payment();
        payment1.setUser("coach");
        payment1.setAmount(1.2);
        payments.add(payment1);

        Payment payment2 = new Payment();
        payment2.setUser("louis");
        payment2.setAmount(2.2);
        payments.add(payment2);

        Payment payment3 = new Payment();
        payment3.setUser("nick");
        payment3.setAmount(3.3);
        payments.add(payment3);

        Payment payment4 = new Payment();
        payment4.setUser("nick");
        payment4.setAmount(4.4);
        payments.add(payment4);

        when(orderRepository.findAll()).thenReturn(orders);
        when(productRepository.findAll()).thenReturn(products);
        when(paymentRepository.findAll()).thenReturn(payments);

      List<UserDto> resultPaymentSummaryList =  coffeeProcessorService.getUserPaymentSummary();
      assertEquals(resultPaymentSummaryList.size(), 3);
      UserDto userDto1 = resultPaymentSummaryList.stream().filter(s->s.getName().equalsIgnoreCase("coach")).findAny().orElse(null);
      assertTrue(userDto1.getAmountPaid() == 1.2);
      assertTrue(userDto1.getAmountOwed() == 7.8);
      UserDto userDto2 = resultPaymentSummaryList.stream().filter(s->s.getName().equalsIgnoreCase("louis")).findAny().orElse(null);
      assertTrue(userDto2.getAmountPaid() == 2.2);
      assertTrue(userDto2.getAmountOwed() == 2.3);
      UserDto userDto3 = resultPaymentSummaryList.stream().filter(s->s.getName().equalsIgnoreCase("nick")).findAny().orElse(null);
      assertTrue(userDto3.getAmountPaid() == 7.7);
      assertTrue(userDto3.getAmountOwed() == -4.2);

    }

}
