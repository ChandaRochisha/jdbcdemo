package com.dnb.jdbcdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnb.jdbcdemo.dto.Account;
import com.dnb.jdbcdemo.dto.Customer;
import com.dnb.jdbcdemo.exceptions.IdNotFoundException;
//import com.dnb.jdbcdemo.exceptions.IdNotFoundException;
import com.dnb.jdbcdemo.repo.AccountRepository;

import com.dnb.jdbcdemo.repo.CustomerRepository;
@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;
	@Override
	public Account createAccount(Account account)  {
		// TODO Auto-generated method stub
	return	accountRepository.save(account);
		
	}
	

	@Override
	public Optional<Account> getAccountById(String accountId) {
		// TODO Auto-generated method stub
		return accountRepository.findById(accountId);
	}

	
	
	@Override
	public List<Account> getAllAccounts() {
		// TODO Auto-generated method stub
		
		return (List<Account>) accountRepository.findAll();
	}


	@Override
	public boolean deleteAccount(String accountId) throws IdNotFoundException {
		// TODO Auto-generated method stub
		if(accountRepository.existsById(accountId)==true)
		{
			accountRepository.deleteById(accountId);
			return true;
			
		}
		else {
			throw new IdNotFoundException(" id not found");
			
		}
		
		
			
	}


	



//	@Autowired
//	AccountRepository accountRepository;
//	@Autowired
//	CustomerRepository customerRepository;
//
//	@Override
//	public Account createAccount(Account account) throws IdNotFoundException {
//		// TODO Auto-generated method stub
//		Optional<Customer> optional = customerRepository.getCustomerById(account.getCustomer().getCustomerId());
//		if(optional.isPresent() )
//		{
//			return accountRepository.createAccount(account);
//		}else
//		{
//			throw new IdNotFoundException("Customerid not found");
//		}
//		
//	}
//
// 
//
//	@Override
//	public Optional<Account> getAccountById(String accountId) {
//		// TODO Auto-generated method stub
//		return accountRepository.getAccountById(accountId);
//	}
//
// 
//
// 
//
//	@Override
//	public Optional<Account> deleteAccountById(String accountId) {
//		// TODO Auto-generated method stub
//		return accountRepo2Impl.deleteAccountById(accountId);
//	}
//
// 
//
// 
//
//	@Override
//	public List<Account> getAllAccounts() {
//		// TODO Auto-generated method stub
//		return accountRepository.getAllAccounts();
//	}
//
// 

}