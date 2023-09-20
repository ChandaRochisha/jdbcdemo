package com.dnb.jdbcdemo.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import com.dnb.jdbcdemo.exceptions.InvalidAccountIdException;
import com.dnb.jdbcdemo.exceptions.InvalidPANException;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {

	
//	   public void setCustomerPAN(String customerPAN) throws InvalidPANException {
//		   String regEx= "^(?=.*[0-9].*[0-9])(?=.*[a-zA-Z].*[a-zA-Z].*[a-zA-Z]).{5,}$";
//			if(Pattern.compile(regEx).matcher(customerPAN).find()){
//				this.customerPAN=customerPAN;
//			}else
//					throw new InvalidPANException("Enter Correct PAN number");	
//		
//		}	
	 
	@Id
	private int customerId;
	private String customerName;
	private String customerContactNumber;
	private String CustomerAddress;
	private String customerPAN;
	private String customerUUID;
	
	
	//one customer can have multiple accounts.
	//@OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="customer")
	//mapped by -->child
	//@JsonIgnoreProperties("customer")
	//@JsonIgnore
	//private List<Account> accountList = new ArrayList<>();
	
	

	}

