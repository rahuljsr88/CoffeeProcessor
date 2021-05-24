package com.accenture.coffee.service;

import com.accenture.coffee.domain.Order;
import com.accenture.coffee.domain.Payment;
import com.accenture.coffee.domain.Product;
import com.accenture.coffee.repository.OrderRepository;
import com.accenture.coffee.repository.PaymentRepository;
import com.accenture.coffee.repository.ProductRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.io.InputStream;
import java.util.List;

/**
 * Implementation of Database Service defined in this class
 * Populates data from the json files into the database at application startup
 * @author rahuljsr88@gmail.com
 */

@Service
@Slf4j
public class CoffeeProcessorDbServiceImpl implements CoffeeProcessorDbService{
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final PaymentRepository paymentRepository;
    private final ObjectMapper objectMapper;

    @Value("${path.json.products}")
    private String productsJsonPath;
    @Value("${path.json.orders}")
    private String ordersJsonPath;
    @Value("${path.json.payments}")
    private String paymentsJsonPath;

    public CoffeeProcessorDbServiceImpl(ProductRepository productRepository, OrderRepository orderRepository, PaymentRepository paymentRepository, ObjectMapper objectMapper) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    @Transactional
    public void loadData() {
        TypeReference<List<Product>> typeReferenceProducts = new TypeReference<List<Product>>(){};
        TypeReference<List<Order>> typeReferenceOrders = new TypeReference<List<Order>>(){};
        TypeReference<List<Payment>> typeReferencePayments = new TypeReference<List<Payment>>(){};
        InputStream inputStreamProducts = TypeReference.class.getResourceAsStream(productsJsonPath);
        InputStream inputStreamOrders = TypeReference.class.getResourceAsStream(ordersJsonPath);
        InputStream inputStreamPayments = TypeReference.class.getResourceAsStream(paymentsJsonPath);
        try {
            List<Product> products = objectMapper.readValue(inputStreamProducts,typeReferenceProducts);
            if(products != null && !products.isEmpty()){productRepository.saveAll(products);}

            List<Order> orders = objectMapper.readValue(inputStreamOrders,typeReferenceOrders);
            if(orders != null && !orders.isEmpty()){orderRepository.saveAll(orders);}

            List<Payment> payments = objectMapper.readValue(inputStreamPayments,typeReferencePayments);
            if(payments != null && !payments.isEmpty()){paymentRepository.saveAll(payments);}

        } catch (Exception e){
            log.error("Exception occured while saving data into DB from JSON files");
        }
    }

}
