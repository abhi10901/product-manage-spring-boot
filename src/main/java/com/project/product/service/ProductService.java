package com.project.product.service;

import java.util.List;

import com.project.product.domain.Product;


public interface ProductService {
	
	public List<Product> findByNameContains(String name);
	public Product storeProduct(Product product);
	public boolean deleteProductById(Long id);

}
