package com.org.product.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.product.model.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {

}
