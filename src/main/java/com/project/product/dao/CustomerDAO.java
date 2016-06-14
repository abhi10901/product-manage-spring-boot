package com.project.product.dao;

import com.project.product.domain.Customer;

public interface CustomerDAO {

	public Customer findCustomerById(Long id);
	public Customer storeCustomer(Customer customer);
	public boolean removeCustomerById(Long id);
}
