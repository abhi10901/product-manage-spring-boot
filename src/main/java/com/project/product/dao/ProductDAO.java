package com.project.product.dao;

import java.util.List;

import com.project.product.domain.Product;

public interface ProductDAO {

	public List<Product> findByNameContains(String name);
	public Product storeProduct(Product product);
	public boolean deleteProductById(Long id);
	public List<Product> getAllProducts();
	public Product getProductById(long id);
}
