package com.project.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.product.dao.CustomerOrderDAO;
import com.project.product.domain.CustomerOrder;

@Service("customerOrderService")
@Transactional
public class CustomerOrderServiceImpl implements CustomerOrderService{

	@Autowired
	@Qualifier("customerOrderDAO")
	private CustomerOrderDAO customerOrderDAO;
	
	@Override
	public List<CustomerOrder> getCustomerOrdersByCustomerId(Long customerId) {
		return customerOrderDAO.getCustomerOrdersByCustomerId(customerId);
	}

}
