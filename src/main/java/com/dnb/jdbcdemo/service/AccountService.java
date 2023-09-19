package com.dnb.jdbcdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dnb.jdbcdemo.dto.Account;
import com.dnb.jdbcdemo.exceptions.IdNotFoundException;
import com.dnb.jdbcdemo.exceptions.InvalidAccountIdException;
@Service
public interface AccountService {
	public Account createAccount(Account account)throws IdNotFoundException;
  
   
    public List<Account> getAccountByContactNumber(String contactNumber);
   
    // public Optional<Account> getAccountByContactNum(String contactNumber);
    
    public List<Account> getAllAccounts();


	public boolean checkExistenceBy(String accountId) throws InvalidAccountIdException;
	public Optional<Account> getAccountById(String accountId);


	boolean deleteAccount(String accountId) throws IdNotFoundException;
}
