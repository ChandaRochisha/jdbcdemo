package com.dnb.jdbcdemo.advice;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import com.dnb.jdbcdemo.exceptions.InvalidAccountIdException;

@ControllerAdvice
public class AppAdvice {//custom + predefined excpetions are handled
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
//	@ResponseStatus(value=HttpStatus.NOT_FOUND ,reason="invalid id provided")
	//@ExceptionHandler(InvalidAccountIdException.class)
	//it will act globally
	//public void invalidAccountIdExceptionHandler(InvalidAccountIdException e) {
//		Map<String, String> map = new HashMap<>();
//
//		map.put("message", "id not found");
//
//		map.put("Httpstatus", HttpStatus.NOT_FOUND + "");

	//}
	
//	@ExceptionHandler(InvalidAccountIdException.class)
//	public ResponseEntity<?> invalidAccountIdExceptionHandler(InvalidAccountIdException e) {
//		Map<String, String> map = new HashMap<>();
//
//		map.put("message", "id not found");
//
//		map.put("Httpstatus", HttpStatus.NOT_FOUND + "");
//
//		return new ResponseEntity(map, HttpStatus.NOT_FOUND);
//
//	}
	
	
	public ResponseEntity<Map<String,String>> handleException(HttpRequestMethodNotSupportedException e)
         throws IOException{
        	 String provided = e.getMethod();
        	 List<String> supported = List.of(e.getSupportedMethods());
        	 
        	 String error = provided
        			 +" is not one of the supported Http methods ("
        			 +String.join(",",supported)
        			 +")";
        	 Map<String,String> errorResponse = Map.of(//even index key, odd index values
        			"error",error,
        			"message",e.getLocalizedMessage(),
        			"status",HttpStatus.METHOD_NOT_ALLOWED.toString()        			 
        			 );
        	 return new ResponseEntity<>(errorResponse,HttpStatus.METHOD_NOT_ALLOWED);
        			       			 
         }
	
	
}

