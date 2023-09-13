package com.dnb.jdbcdemo;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.dnb.jdbcdemo.dto.Account;
import com.dnb.jdbcdemo.exceptions.IdNotFoundException;
import com.dnb.jdbcdemo.exceptions.InvalidAccountIdException;
import com.dnb.jdbcdemo.exceptions.InvalidAccountTypeException;
import com.dnb.jdbcdemo.exceptions.InvalidBalanceException;
import com.dnb.jdbcdemo.exceptions.InvalidContactNumberException;
import com.dnb.jdbcdemo.exceptions.InvalidNameException;
import com.dnb.jdbcdemo.exceptions.InvalidPANException;
import com.dnb.jdbcdemo.service.AccountService;

import ch.qos.logback.core.net.SyslogOutputStream;

@SpringBootApplication
public class JdbcdemoApplication 
{

	public static void main(String[] args) throws IdNotFoundException {
	
		
		ApplicationContext applicationContext=SpringApplication.run(JdbcdemoApplication.class, args);
     			
//		//DataSource datasource=applicationContext.getBean(DataSource.class);
		AccountService accountService = applicationContext.getBean(AccountService.class);

		Account account =new Account();
		//account.setAccountId("12345");

  account.setAccountHolderName("Abhi");
//
       account.setAccountType("current");
//
     account.setAccountStatus(true);
//
      account.setAddress(" hyd");
//

		account.setBalance(3456);
//
   account.setContactNumber("5768789989");

     // account.setAccountCreatedDate("89-09-09");

    account.setDob(LocalDate.of(2019,04,01));
		//account.setContactNumber("722782");
		accountService.createAccount(account);
	}
}

//		try {
//
//					account= new Account("134","kavya","Saving",104,"1234567891","abc",LocalDate.now(),LocalDate.of(2001, 12, 20),true,new Customer(1, "pooja", "hh", "Hyderab", "FXAAS12345", "FSVWR12123"));
//
//					
//
//				} catch (InvalidNameException e) {
//
//					e.printStackTrace();
//
//				} catch (InvalidAccountTypeException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (InvalidContactNumberException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (InvalidAccountIdException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//		
//		Scanner sc = new Scanner(System.in);
//		while(true) 
//		{
//			System.out.println(" 1.Create Account  2.Delete account By id  3. Get accoun by id 4.Get all accounts  5.exit ");
//			System.out.println(" Enter your Choice: ");
//			
//			int c = sc.nextInt();
//			
//		
//			switch(c){
//			case 1 :
//            
//				try {
//					     		
//        	   break;
//			case 2:
//				String accountId = sc.next();
//				try {
//					accountService.deleteAccount(accountId);
//				} catch (IdNotFoundException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				break;
//			case 3:
//				 String accountId2 =sc.next();
//				Optional<Account> account2=accountService.getAccountById(accountId2);
//				System.out.println(account2);
//				 break;
//			case 4:
//			    
//				applicationContext.getBean(AccountService.class).getAllAccounts().forEach(e -> System.out.println(e));
//				break;
//			case 5:
//				
//				System.exit(0);
//				sc.close();
//				break;
//			default:
//				System.out.println("Wrong Choice");
//				
//        	   
                
			

	


//System.out.println("Enter your accountId: ");
//
//String accountId = sc.next();
//
//System.out.println("Enter your accountHolderName: ");
//
//String accountHolderName = sc.next();
//
//System.out.println("Enter your accountType: ");
//
//String accountType = sc.next();
//
//System.out.println("Enter your accountStatus: ");
//
//account.setAccountStatus(true);
//
//System.out.println("Enter your address: ");
//
//String address = sc.next();
//
//System.out.println("Enter your balance: ");
//
//float balance = sc.nextFloat();
//
//System.out.println("Enter your mobile number: ");
//
//String contactNumber = sc.next();
//
//System.out.println("Enter your dob: ");
//
//String dob = sc.next();
//
//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd");
//
//LocalDate formattedString = LocalDate.parse(dob,formatter);
//
//System.out.println("Enter your account created date: ");
//
//String accountCreatedDate = sc.next();
//
//DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yy-MM-dd");
//
//LocalDate formattedString1 = LocalDate.parse(accountCreatedDate,formatter);
//
//
//account.setAccountCreatedDate(formattedString);
//account.setDob(formattedString1);
//

