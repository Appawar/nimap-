package com.org.product.cotroller;

import java.util.List;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.product.model.Category;
import com.org.product.model.Product;
import com.org.product.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	ProductService productService;

	@PostMapping
	public Product saveProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
	}

	@GetMapping
	public Page<Product> getAllProduct(Pageable pageable) {
		//http://localhost:8080/api/product?page=0&size=10&sort=id,desc
		return productService.findAllProduct(pageable);
	}

	@GetMapping("/{id}")
	public Product findById(@PathVariable("id") Long id) {
		return productService.findById(id);
	}
	
	@PutMapping("/{id}")
	public String CategoryRecords(@RequestBody Product product, @PathVariable("id") long id) throws AttributeNotFoundException {

		   Product c = productService.findById(id);
	             
		       c.setId(product.getId() );
		       c.setProductName(product.getProductName());
		       c.setProductPrice(product.getProductPrice());
		      
		      productService.saveProduct(product);
			 return "Product Deatils against id "+id+" updated";
			 
	}
			 

	@DeleteMapping("/{id}")
	public String deleteById(@PathVariable("id") Long id) {
		return productService.deleteById(id);
		
		
	

	}

}
