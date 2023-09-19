package com.dnb.jdbcdemo.utils;

import org.springframework.stereotype.Component;

import com.dnb.jdbcdemo.dto.Account;
import com.dnb.jdbcdemo.dto.Customer;
import com.dnb.jdbcdemo.payload.request.AccountRequest;

@Component

public class RequestToEntityMapper {

	public Account getAccountEntityObject (AccountRequest accountRequest) {
		Account account = new Account();
		//account.setAccountCreatedDate(accountRequest.g());
		account.setAccountType(accountRequest.getAccountType());
		account.setAddress(accountRequest.getAddress());;
		account.setContactNumber(accountRequest.getContactNumber());
		account.setBalance(accountRequest.getBalance());
		account.setDob(accountRequest.getDob());
		
		account.setAccountHolderName(accountRequest.getAccountHolderName());
		
		
		//can we chwck customer id is existing or not?
		Customer customer2 = new Customer();
		customer2.setCustomerId(accountRequest.getCustomerId());
		account.setCustomer(customer2);
		
		return account;
		
	}
}
