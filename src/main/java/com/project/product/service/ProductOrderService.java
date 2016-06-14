package com.project.product.service;

import java.util.List;

import com.project.product.domain.Product;

public interface ProductOrderService {

	public List<Product> getAllProductsOfCustomerOrderByCustomerOrderId(Long orderId);

}
