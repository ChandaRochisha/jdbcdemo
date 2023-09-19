package com.dnb.jdbcdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnb.jdbcdemo.dto.Account;
import com.dnb.jdbcdemo.dto.Customer;
import com.dnb.jdbcdemo.exceptions.IdNotFoundException;
import com.dnb.jdbcdemo.repo.AccountRepository;
import com.dnb.jdbcdemo.repo.CustomerRepository;
@Service
public class CustomerServiceImpl implements CustomerService {

	
	@Autowired
 CustomerRepository customerRepository;
	
	@Override
	public Customer createCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return	customerRepository.save(customer);
		
	}

	@Override
	public Optional<Customer> getCustomerById(int customerId) {
		// TODO Auto-generated method stub
		return customerRepository.findById(customerId);
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return  (List<Customer>) customerRepository.findAll();
	}


	@Override
	public boolean deleteCustomer(int customerId) throws IdNotFoundException {
		// TODO Auto-generated method stub
		if(customerRepository.existsById(customerId)==true)
		{
			customerRepository.deleteById(customerId);
			return true;
			
		}
		else {
			throw new IdNotFoundException(" id not found");
			
		}

	}

	@Override
	public boolean checkExistenceBy(int customerId) {
		// TODO Auto-generated method stub
		if(customerRepository.existsById(customerId))
		{
			return true;
			
		}
		else {
		
			
		
		
		return false;
		}
	}



}