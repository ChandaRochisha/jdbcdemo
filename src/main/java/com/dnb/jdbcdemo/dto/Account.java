package com.dnb.jdbcdemo.dto;

import java.time.LocalDate;
import java.util.regex.Pattern;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import com.dnb.jdbcdemo.exceptions.InvalidAccountIdException;
import com.dnb.jdbcdemo.exceptions.InvalidAccountTypeException;
import com.dnb.jdbcdemo.exceptions.InvalidBalanceException;
import com.dnb.jdbcdemo.exceptions.InvalidContactNumberException;
import com.dnb.jdbcdemo.exceptions.InvalidNameException;
import com.dnb.jdbcdemo.utils.CustomAccountIdGenerator;
import com.dnb.jdbcdemo.utils.DatePrefixedSequenceIdGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data

@AllArgsConstructor
@NoArgsConstructor
@ToString//(exclude ="customer")
@Entity

public class Account {
	@Id
	//@NotBlank(message= "account id should not be blank")//"" should not be empty as well
	//these annotations work when we interact with the database
//	@GeneratedValue(strategy=GenerationType.UUID)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="account_seq")
	
	@GenericGenerator(name = "account_seq",strategy = "com.dnb.jdbcdemo.utils.DatePrefixedSequenceIdGenerator",
			parameters = {@Parameter(name = DatePrefixedSequenceIdGenerator.INCREMENT_PARAM, value ="50"),
					@Parameter(name= DatePrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value="%05d")
			
					}
					)
	private String accountId;
	//@Column(nullable =false)

	private String accountHolderName;
	
	private String accountType;
	//@Min(value=0,message="Value should not be negative")
	private float balance;
	//@Length(min = 10,max=10)
	//@NotBlank( message=" enter correct contact number")
	//@jakarta.validation.constraints.Pattern(regexp="^\\d{10}$")
	//@jakarta.validation.Constraints.pattern(regexp ="^\\d{10}$")
	private String contactNumber;
	//@NotBlank(message= "address should not be blank")
	private String address;
	//@NotNull(message =" date should not be null")
	
	private LocalDate accountCreatedDate = LocalDate.now();
	//@NotNull(message =" date must be provided")
	//@jakarta.validation.constraints.Pattern(regexp="^\\d{4}-\\d{2}-\\d{2}$")
    
	private LocalDate dob;
	
	private boolean accountStatus;

	private int customerId;

}

	
//	public Account(String accountId, String accountHoldername, String accountType,float balance,String contactNumber,
//	String address, LocalDate accountCreatedDate, LocalDate dob, boolean accountStatus,int customerId )throws InvalidNameException,  InvalidAccountTypeException, InvalidContactNumberException, InvalidAccountIdException  {
//		super();
//		this.setAccountId(accountId);
//		this.setAccountHolderName(accountHoldername);
//		this.setAccountType(accountType);
//		this.setContactNumber(contactNumber);
//		this.setBalance(balance);
//		this.setAccountCreatedDate(accountCreatedDate);
//		this.setAccountStatus(accountStatus);
//		this.setDob(dob);
//		this.setCustomer(customerId);
//		this.setAddress(address);
//	}
	
	
	
//   public void setAccountId(String accountId) //throws InvalidAccountIdException 
//   {
//	  //String regEx= "^[0-9]{3,10}$";
//	
//	//	if(Pattern.compile(regEx).matcher(accountId).matches()){
//			this.accountId=accountId;
//		//}else
//			//	throw new InvalidAccountIdException("Accountid need to contain min 5 digits");	
//	   
//	}
//
//
//	public void setAccountHolderName(String accountHolderName) throws InvalidNameException {
//		//length should be min 2 chars. & it should include only chars no numbers
//		String regEx= "[a-zA-Z]{2,}$";
//		if(Pattern.compile(regEx).matcher(accountHolderName).find()){
//			this.accountHolderName=accountHolderName;
//		}else
//				throw new InvalidNameException("Name is not valid");			
//	}
//
//	
//	
//	public void setAccountType(String accountType) throws InvalidAccountTypeException {
//		String regEx= "^[a-zA-Z]{2,}$";
//		if(Pattern.compile(regEx).matcher(accountType).find()){
//			this.accountType = accountType;
//		}else
//				throw new InvalidAccountTypeException("AccountType is not valid");	
//	}
//
//	
//	
//	public void setBalance(float balance)  {
//	
//			this.balance = balance;
//		
//	}
//
//	
//	public void setContactNumber(String contactNumber) throws InvalidContactNumberException {
//		String regEx= "^[0-9]{10}$";
//		if(Pattern.compile(regEx).matcher(contactNumber).find()){
//			this.contactNumber = contactNumber;
//		}else
//				throw new InvalidContactNumberException("Contact number is not valid");	
//	}
//	
//
//	public void setAddress(String address) {		
//		this.address = address;
//	}
//
//	public void setAccountCreatedDate(LocalDate accountCreatedDate) {
//		this.accountCreatedDate = accountCreatedDate;
//	}
//
//	public void setDob(LocalDate dob) {
//		this.dob = dob;
//	}
//
//	public void setAccountStatus(boolean accountStatus) {
//		this.accountStatus = accountStatus;
//	}
//
//	public void setCustomer(int customer) {
//		this.customerId = customer;
//	}


