package com.project.product.service;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.product.dao.CustomerDAO;
import com.project.product.domain.Customer;

@Service("customerService")
@Transactional(readOnly = true)
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	@Qualifier("customerDAO")
	private CustomerDAO customerDAO;
	
	@Override
	public Customer findCustomerById(Long id) {
		return customerDAO.findCustomerById(id);
	}

}
