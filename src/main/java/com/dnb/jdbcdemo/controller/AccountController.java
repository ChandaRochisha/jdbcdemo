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
import com.dnb.jdbcdemo.exceptions.IdNotFoundException;
import com.dnb.jdbcdemo.exceptions.InvalidAccountIdException;
import com.dnb.jdbcdemo.exceptions.InvalidContactNumberException;
import com.dnb.jdbcdemo.payload.request.AccountRequest;
import com.dnb.jdbcdemo.service.AccountService;
import com.dnb.jdbcdemo.utils.RequestToEntityMapper;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/account")//common one
public class AccountController {
  
	@Autowired
	AccountService accountService;
	@Autowired
	RequestToEntityMapper mapper;
	
	@DeleteMapping("/{accountId}")

	public ResponseEntity<?> deleteAccountById
	(@PathVariable("accountId")String accountId)throws InvalidAccountIdException, IdNotFoundException{
		boolean b = accountService.checkExistenceBy(accountId);
		if(b)
		{
			accountService.deleteAccount(accountId);
			return ResponseEntity.noContent().build();
		}else
		{
			throw new InvalidAccountIdException("provide correct account id to delete it");
		}
		
	}
	//fetch details based on contact number
	///api/account/cn/{contactNumber}
	
	//@GetMapping("/{contactNumber:^[0-9]{10}$}")//It should help us to get the specific account details	
//  @GetMapping("/cn/{contactNumber}")
//	public ResponseEntity<?> getAccountByContactNumber
//	(@PathVariable("contactNumber") String contactNumber)throws InvalidContactNumberException{
//		Optional<Account> optional = accountService.getAccountByContactNumber(contactNumber);
//		if(optional.isPresent()) {
//			return ResponseEntity.ok(optional.get());
//		}
//		else {
//			throw new InvalidContactNumberException("provide correct contact number");
//		}
//	}
	@GetMapping("/allAccounts/{contactNumber:^[0-9]{10}$}")
	public ResponseEntity<?>  getAllAccountsByContactNumber
	(@PathVariable("contactNumber") String contactNumber) throws InvalidContactNumberException{
		List<Account> list = accountService.getAccountByContactNumber(contactNumber);
		if(list.size()>0)
			return ResponseEntity.ok(list);
		else
		  throw new InvalidContactNumberException("provide correct contact number");
		
	}
	
	@GetMapping("/{accountId}")//It should help us to get the specific account details	
	public ResponseEntity<?> getAccountById
	(@PathVariable("accountId") String accountId)throws InvalidAccountIdException{
		Optional<Account> optional = accountService.getAccountById(accountId);
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
			throw new InvalidAccountIdException("acc");
		}
	}
			
	
	
	
	//insert/ create account :post:@PostMapping
	@PostMapping("/create")//url in HM
	//it is combination of 2 things @requestmapping + post metho---> spriing 4.3.x
	//http protocol ka post method
	public ResponseEntity<?> createAccount(@Valid @RequestBody AccountRequest account ) { 
		Account account1= mapper.getAccountEntityObject(account);//method
	   try {
		Account account2= accountService.createAccount(account1);
		return new ResponseEntity(account2,HttpStatus.CREATED);
		
	} catch (IdNotFoundException e) {
		// TODO Auto-generated catch block
	  return ResponseEntity.badRequest().body(e.getMessage());
	}
	}
}
	

