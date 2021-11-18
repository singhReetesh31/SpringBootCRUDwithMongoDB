package com.axis.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
	@ExceptionHandler(value=IDNotFoundException.class)
public ResponseEntity<Object> IdNotFoundExceptionHandler(IDNotFoundException e){
	return new ResponseEntity<Object>(e.getMessage(),HttpStatus.NOT_FOUND);
}
	
	@ExceptionHandler(value=IdMisMatchedException.class)
	public ResponseEntity<Object> IdMisMatchedExceptionHandler(IdMisMatchedException e){
		return new ResponseEntity<Object>(e.getMessage(),HttpStatus.BAD_REQUEST);
	}
}
