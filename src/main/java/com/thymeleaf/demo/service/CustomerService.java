package com.thymeleaf.demo.service;

import java.util.List;

import com.thymeleaf.demo.entity.Customer;

public interface CustomerService {
	
	List<Customer> getAllCustomers();
	
	Customer insertCustomer(Customer customer);
	
	Customer updateCustomer(Customer customer);

	Customer getCustomer(Long id);

}
