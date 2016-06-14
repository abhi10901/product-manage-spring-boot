package com.project.product.dao;

import java.util.List;

import com.project.product.domain.Product;

public interface ProductOrderDAO {

	List<Product> getAllProductsOfCustomerOrderByCustomerOrderId(Long orderId);

}
