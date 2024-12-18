package com.Hibernate.HibernateValidation.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class ExceptionHandler  extends ResponseEntityExceptionHandler{
   
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status,WebRequest request){  
		
		Map<String, String> errors = new HashMap<String, String>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String field =((FieldError)error).getDefaultMessage();
			String message =error.getDefaultMessage();
			
			errors.put(field, message);
			
		});		
		
		return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
	}
	
}