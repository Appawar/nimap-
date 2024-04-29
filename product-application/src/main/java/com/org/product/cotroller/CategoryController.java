package com.org.product.cotroller;

import java.util.List;
import java.util.Optional;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.product.model.Category;
import com.org.product.model.Product;
import com.org.product.repo.CategoryRepository;
import com.org.product.service.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
	CategoryRepository categoryRepository;
	
	
	

	@PostMapping
	public Category saveCategory(@RequestBody Category category) {
		return categoryService.saveCategory(category);
	}

	@GetMapping
	public Page<Category> getAllProduct(Pageable pageable) {
		//http://localhost:8080/api/product?page=0&size=10&sort=id,desc
		return categoryService.findAllCat1(pageable);
	}
    


	@GetMapping("/{id}")
	public Category findById(@PathVariable("id") Long id) {
		return categoryService.findById(id);
	}
	
	@PutMapping("/{id}")
	public String CategoryRecords(@RequestBody Category category, @PathVariable("id") long id) throws AttributeNotFoundException {

		   Category c = categoryService.findById(id);
	             
		      c.setCategory_id( category.getCategory_id());
		      c.setCatName( category.getCatName());
		      
		      categoryService.save(c);
			 return "Product Deatils against id "+id+" updated";
		
	}


	@DeleteMapping("/{id}")
	public String deleteById(@PathVariable("id") Long id) {
		return categoryService.deleteById(id);
	}

}
