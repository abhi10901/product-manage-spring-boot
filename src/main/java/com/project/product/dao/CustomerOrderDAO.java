package com.project.product.dao;

import java.util.List;

import com.project.product.domain.CustomerOrder;

public interface CustomerOrderDAO {
	public List<CustomerOrder> getCustomerOrdersByCustomerId(Long customerId);
}
