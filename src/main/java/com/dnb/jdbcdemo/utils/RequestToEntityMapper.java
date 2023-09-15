package com.dnb.jdbcdemo.utils;

import org.springframework.stereotype.Component;

import com.dnb.jdbcdemo.dto.Account;
import com.dnb.jdbcdemo.payload.request.AccountRequest;

@Component
public class RequestToEntityMapper {

	public Account getAccountEntityObject (AccountRequest accountRequest) {
		Account account = new Account();
		account.setAccountHolderName(accountRequest.getAccountHolderName());
		return account;
		
	}
}
