package com.luv2code.springboot.eventapp.service;

import java.util.List;

import com.luv2code.springboot.eventapp.entity.Customer;

public interface CustomerService {
	
	public List<Customer> findAll();
	
	public Customer findById(int theId);
	
	public void save(Customer theCustomer);
	
	public void deleteById(int theId);

}
