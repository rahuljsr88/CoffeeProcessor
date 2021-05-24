package com.accenture.coffee.repository;

import com.accenture.coffee.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Order Repository for the orders
 *@author rahuljsr88@gmail.com
 */
@Repository
public interface OrderRepository extends JpaRepository <Order, Integer> {
}
