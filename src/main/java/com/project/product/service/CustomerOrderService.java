package com.project.product.service;

import java.util.List;

import com.project.product.domain.CustomerOrder;

public interface CustomerOrderService {

	public List<CustomerOrder> getCustomerOrdersByCustomerId(Long customerId);
}
