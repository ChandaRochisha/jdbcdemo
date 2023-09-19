package com.dnb.jdbcdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dnb.jdbcdemo.dto.Account;
import com.dnb.jdbcdemo.dto.Customer;
import com.dnb.jdbcdemo.exceptions.IdNotFoundException;
@Service
public interface CustomerService {

	 public Customer createCustomer(Customer customer);
	    public Optional<Customer> getCustomerById(int customerId);
	    public List<Customer> getAllCustomers();
	    public boolean deleteCustomer(int customerId) throws IdNotFoundException;
		public boolean checkExistenceBy(int customerId);
		

}
