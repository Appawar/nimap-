package com.org.product.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity

public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long category_id;
	private String catName;
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Product> productList;

	public long getCategory_id() {
		return category_id;
	}

	public void setCategory_id(long category_id) {
		this.category_id = category_id;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public boolean isPresent() {
		// TODO Auto-generated method stub
		return false;
	}

}
