package com.accenture.coffee.service;

import com.accenture.coffee.domain.Payment;
import com.accenture.coffee.domain.Product;
import com.accenture.coffee.dto.UserDto;
import com.accenture.coffee.exception.CoffeeProcessorException;
import com.accenture.coffee.repository.OrderRepository;
import com.accenture.coffee.repository.PaymentRepository;
import com.accenture.coffee.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import static com.accenture.coffee.exception.CoffeeProcessorErrorDetails.COFFEE_PROCESSOR_INVALID_PRODUCT_EXCEPTION;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingDouble;

/**
 * Implementation of Business logic Service defined in this class
 * Fetches the payment summary per user
 * @author rahuljsr88@gmail.com
 */

@Service
@Slf4j
public class CoffeeProcessorServiceImpl implements CoffeeProcessorService{
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final PaymentRepository paymentRepository;
    private List<UserDto> userPaymentSummaryList;

    public CoffeeProcessorServiceImpl(ProductRepository productRepository, OrderRepository orderRepository, PaymentRepository paymentRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
    }

    public List<UserDto> getUserPaymentSummary() {
        userPaymentSummaryList = new ArrayList<>();
        orderRepository.findAll().stream()
                .forEach(
                        order -> {
                            Double orderBill = productRepository.findAll().stream()
                                    .filter(product -> product.getDrink_name().equalsIgnoreCase(order.getDrink()))
                                    .filter(Objects::nonNull)
                                    .map(Product::getPrices)
                                    .mapToDouble(product -> product.get(order.getSize())).findFirst()
                                    .orElseThrow(
                                            () -> new CoffeeProcessorException(
                                                    COFFEE_PROCESSOR_INVALID_PRODUCT_EXCEPTION.getCode(),
                                                    COFFEE_PROCESSOR_INVALID_PRODUCT_EXCEPTION.getSeverity(),
                                                    COFFEE_PROCESSOR_INVALID_PRODUCT_EXCEPTION.getStatus(),
                                                    "Product matching size in order"+order.getSize()+" not found"
                                            )
                                    );
                            addUserToPaymentSummary(order.getUser(), orderBill);
        });
        calculatePaymentPerUser();
        calculateAmountOwedPerUser();
        return userPaymentSummaryList;
    }

    private void addUserToPaymentSummary(String userName, Double orderBill) {
        UserDto user = userPaymentSummaryList.stream()
                .filter(userDto -> userDto.getName().equalsIgnoreCase(userName))
                .findFirst().orElse(null);
        if(user != null){
            user.setBillAmount(user.getBillAmount() + orderBill);
        }else {
            UserDto newUser = new UserDto();
            newUser.setName(userName);
            newUser.setBillAmount(orderBill);
            userPaymentSummaryList.add(newUser);
        }
    }

    private void calculatePaymentPerUser(){
        HashMap<String, Double> paymentAmountByUser = new HashMap<>(paymentRepository.findAll().stream()
                .collect(groupingBy(Payment::getUser, summingDouble(Payment::getAmount))));
        userPaymentSummaryList.stream().forEach(user -> {
            user.setAmountPaid((paymentAmountByUser.get(user.getName())));
        });
    }

    private void calculateAmountOwedPerUser(){
        userPaymentSummaryList.stream().forEach(user -> {
            user.setAmountOwed(user.getBillAmount() - user.getAmountPaid());
        });
    }
}
