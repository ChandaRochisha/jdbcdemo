package com.dnb.jdbcdemo.exceptions;

public class InvalidPANException extends Exception {
		public InvalidPANException(String msg)
		{
			super(msg);
		}
		
		@Override
		public String toString() {
			return super.toString()+super.getMessage();
		}

}
