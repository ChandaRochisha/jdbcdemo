package com.dnb.jdbcdemo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dnb.jdbcdemo.dto.Account;

@RestController
@RequestMapping("/api/account")//common one
public class AccountController {

	//insert/ create account :post:@PostMapping
	@PostMapping("/create")//url in HM
	//it is combination of 2 things @requestmapping + post metho---> spriing 4.3.x
	//http protocol ka post method
	public Account createAccount(@RequestBody Account account ) { //method
		return account;
	}
}
