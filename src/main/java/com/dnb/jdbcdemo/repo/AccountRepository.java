package com.dnb.jdbcdemo.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dnb.jdbcdemo.dto.Account;
import com.dnb.jdbcdemo.dto.Customer;
@Repository
public interface AccountRepository extends CrudRepository<Account, String>{


	

    
   
}