package com.luv2code.springboot.eventapp.dao;

import java.util.List;

import com.luv2code.springboot.eventapp.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> findAll();
	
	public Customer findById(int theId);
	
	public void save(Customer theCustomer);
	
	public void deleteById(int theId);

}
