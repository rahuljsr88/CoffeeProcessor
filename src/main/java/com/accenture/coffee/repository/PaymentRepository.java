package com.accenture.coffee.repository;

import com.accenture.coffee.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Payment Repository for the payments
 *@author rahuljsr88@gmail.com
 */

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
