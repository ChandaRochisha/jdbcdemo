package com.dnb.jdbcdemo.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dnb.jdbcdemo.dto.Customer;
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {


	 public Optional<Customer> findById(int customerId);

	public boolean existsById(int customerId);

	public void deleteById(int customerId);

		
}
