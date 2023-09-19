package com.dnb.jdbcdemo.advice;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	
	
@Override
protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
		HttpHeaders headers, HttpStatusCode status, WebRequest request) {
	// TODO Auto-generated method stub
	System.out.println("hello from hanlder");
	Map<String,Object> responseBody = new LinkedHashMap<>();
	responseBody.put("timestamp", LocalDateTime.now());
	responseBody.put("status", status.value());
//	
//	List<String> errors = ex.getBindingResult().getFieldErrors()
//			.stream()
//			.map(x->x.getRejectedValue())
//			.collect(Collectors.toList());
//	//array of fields or message
//	//should be stored into a map where k: fieldName ,V:value
//	responseBody.put("errors", errors);
	
	Stream<FieldError> errors = ex.getBindingResult().getFieldErrors().stream();


	Map<String,String> error = errors.collect(Collectors.toMap(a -> a.getField(), ex1->ex1.getDefaultMessage()));
	responseBody.put("errors", error);


	return new ResponseEntity<>(responseBody, headers, status);
}	


}
