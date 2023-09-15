package com.dnb.jdbcdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dnb.jdbcdemo.dto.Account;
import com.dnb.jdbcdemo.dto.Customer;
import com.dnb.jdbcdemo.exceptions.IdNotFoundException;
import com.dnb.jdbcdemo.exceptions.InvalidAccountIdException;
import com.dnb.jdbcdemo.service.AccountService;
import com.dnb.jdbcdemo.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/Customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@DeleteMapping("/{customerId}")

	public ResponseEntity<?> deleteCustomerById
	(@PathVariable("customerId")String customerId)throws IdNotFoundException{
		boolean b = customerService.checkExistenceBy(customerId);
		if(b)
		{
			customerService.deleteCustomer(customerId);
			return ResponseEntity.noContent().build();
		}else
		{
			throw new IdNotFoundException("provide correct account id to delete it");
		}
		
	}
	
	
	@GetMapping("/allCustomers")

	public ResponseEntity<?> getAllCustomers() throws IdNotFoundException {

 

		List<Customer> list = (List<Customer>) customerService.getAllCustomers();

		if (list.size() > 0)

			return ResponseEntity.ok(list);

		else

			throw new IdNotFoundException("No details");

	}		
	
	
	@PostMapping("/create")//url in HM
	//it is combination of 2 things @requestmapping + post metho---> spriing 4.3.x
	//http protocol ka post method
	public ResponseEntity<?> createCustomer(@Valid @RequestBody Customer customer ) { //method
	   try {
		Customer customer2= customerService.createCustomer(customer);
		return new ResponseEntity(customer2,HttpStatus.CREATED);
		
	} catch (IdNotFoundException e) {
		// TODO Auto-generated catch block
	  return ResponseEntity.badRequest().body(e.getMessage());
	}
	}
	
}
