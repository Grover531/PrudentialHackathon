package com.luv2code.springboot.eventapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.eventapp.entity.Customer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Repository
public class CustomerDAOJpaImpl implements CustomerDAO {

	private EntityManager entityManager;
	
	@Autowired
	public CustomerDAOJpaImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public List<Customer> findAll() {
		
		// create a query
		Query theQuery =
				entityManager.createQuery("from Customer");
		
		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();
		
		// return the results
		return customers;
	}

	@Override
	public Customer findById(int theId) {
		
		// get customer
		Customer theCustomer = 
				entityManager.find(Customer.class, theId);
		
		// return customer
		return theCustomer;
	}

	@Override
	public void save(Customer theCustomer) {
		
	// save or update the customer
	Customer dbCustomer = entityManager.merge(theCustomer);	
	
	// update with id from db ... so we can get generated id for save/insert
	theCustomer.setId(dbCustomer.getId());

	}

	@Override
	public void deleteById(int theId) {
		
		// delete object with primary key
		Query theQuery = entityManager.createQuery(
				"delete from Customer where id=:customerId");
		
		theQuery.setParameter("customerId", theId);
		
		theQuery.executeUpdate();

	}
}
