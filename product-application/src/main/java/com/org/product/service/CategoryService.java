package com.org.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.org.product.model.Category;
import com.org.product.repo.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepository;

	public Category saveCategory(Category category) {
		return categoryRepository.save(category);
	}

	public List<Category> findAllCat() {

		return categoryRepository.findAll();
	}

	public Category findById(Long id) {
		Optional<Category> optional = categoryRepository.findById(id);
		return optional.get();
	}
	

	public String deleteById(@PathVariable("id") Long Id)
	{
		categoryRepository.delete(this.findById(Id));
		return "Deleted ....!";
		
	}

	public void save(Category c) {
		categoryRepository.save(c);
		 
	}

	public Page<Category> findAllCat1( org.springframework.data.domain.Pageable pageable) {
		 
		return  categoryRepository.findAll(pageable );
	}
	
	
	 

	 
	 
	 
}
