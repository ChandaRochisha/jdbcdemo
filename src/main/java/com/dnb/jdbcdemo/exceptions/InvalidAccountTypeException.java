package com.dnb.jdbcdemo.exceptions;

public class InvalidAccountTypeException extends Exception {
	public InvalidAccountTypeException(String msg) {
		  super(msg);
	  }
	  @Override
	  public String toString() {
		  return super.toString()+super.getMessage();
	  }
}
