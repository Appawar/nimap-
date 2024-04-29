package com.org.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.org.product.model.Product;
import com.org.product.repo.ProductRepo;

@Service
public class ProductService {

	@Autowired
	ProductRepo productRepo;

	public Product saveProduct(Product product) {
		return productRepo.save(product);
	}

	public Page<Product> findAllProduct(Pageable pageable) {
		return productRepo.findAll(pageable);
	}

	public Product findById(Long id) {
		Optional<Product> optional = productRepo.findById(id);
		return optional.get();
	}

	public String deleteById(Long id) {

		productRepo.delete(this.findById(id));
		return "Deleted ....";
	}

}
