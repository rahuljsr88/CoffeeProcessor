package com.accenture.coffee.repository;

import com.accenture.coffee.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Product Repository for the products
 *@author rahuljsr88@gmail.com
 */

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
}
