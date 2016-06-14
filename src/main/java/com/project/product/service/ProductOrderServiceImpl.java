package com.project.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.product.dao.ProductOrderDAO;
import com.project.product.domain.Product;

@Service("productOrderService")
@Transactional
public class ProductOrderServiceImpl implements ProductOrderService {

	@Autowired
	@Qualifier("productOrderDAO")
	private ProductOrderDAO productOrderDAO;
	
	@Override
	public List<Product> getAllProductsOfCustomerOrderByCustomerOrderId(Long orderId) {
		return productOrderDAO.getAllProductsOfCustomerOrderByCustomerOrderId(orderId);
	}

}
