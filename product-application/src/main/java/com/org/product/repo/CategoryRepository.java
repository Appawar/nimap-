package com.org.product.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.product.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
