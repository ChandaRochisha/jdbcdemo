package com.dnb.jdbcdemo.payload.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CustomerRequest {

	@NotBlank(message = "customer name should not be blank")
	private String customerName;
	@NotBlank(message ="customer number must be entered ")
	private String customerNumber;
	@NotBlank(message ="customer address must be entered ")
	private String customerAddress;

	private String customerPAN;
	private String customerUUId;
	
}
