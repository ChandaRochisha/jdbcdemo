package com.dnb.jdbcdemo.controller;

import java.util.List;
import java.util.Optional;

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
import com.dnb.jdbcdemo.exceptions.InvalidNameException;
import com.dnb.jdbcdemo.service.AccountService;
import com.dnb.jdbcdemo.service.CustomerService;
import com.dnb.jdbcdemo.utils.RequestToEntityMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/Customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@Autowired
	RequestToEntityMapper mapper;
	@DeleteMapping("/{customerId}")

	public ResponseEntity<?> deleteCustomerById
	(@PathVariable("customerId")int customerId)throws IdNotFoundException{
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
	public ResponseEntity<?> createCustomer(@Valid @RequestBody Customer customer ) throws InvalidNameException { //method
	   Customer customer2= customerService.createCustomer(customer);
	return new ResponseEntity(customer2,HttpStatus.CREATED);
	}
	
	@GetMapping("/{customerId}")//It should help us to get the specific account details	
	public ResponseEntity<?> getCustomerByCustomerId
	(@PathVariable("customerId") int customerId)throws IdNotFoundException{
		Optional<Customer> optional = customerService.getCustomerById(customerId);
		if(optional.isPresent()) {
			return ResponseEntity.ok(optional.get());
		}
		else {
			//to form the json object in java best option is to work with map
//			Map<String,String> map=new HashMap<>();
//			map.put("message", "id not found");
//			map.put("HttpStatus", HttpStatus.NOT_FOUND+"");
//			ResponseEntity<?> responseEntity = new ResponseEntity
//					(map,HttpStatus.NOT_FOUND);
			//return responseEntity;
			//return ResponseEntity.notFound().build();
			//throw new InvalidAccountIdException("account id not available");
			throw new IdNotFoundException("enter customer id correctly");
		}
	}
}
