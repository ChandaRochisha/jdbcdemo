package com.dnb.jdbcdemo.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dnb.jdbcdemo.dto.Account;
import com.dnb.jdbcdemo.dto.Customer;
@Repository
public interface AccountRepository extends CrudRepository<Account, String>{

	  public List<Account> findAccountByContactNumber(String contactNumber);
	  
	   // public Optional<Account> getAccountByContactNum(String contactNumber);
    
   
}
