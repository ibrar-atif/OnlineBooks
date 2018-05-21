package com.book.controller;


import java.text.ParseException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.book.exception.ApplicationException;



/**
 * 
 * @author ibrara
 *
 */

@ControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(ApplicationException.class)
	public ResponseEntity <Object>  applicationExceptionHandler(ApplicationException exp) {
		
		return new ResponseEntity<>(exp.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity <Object>  genericExceptionHandler(Exception exp) {
		
		return new ResponseEntity<>("Exception Occured",HttpStatus.INTERNAL_SERVER_ERROR);
	}

	
	@ExceptionHandler(ParseException.class)
	public ResponseEntity <Object>  parseExceptionExceptionHandler(ParseException exp) {
		
		return new ResponseEntity<>("Invalid date format",HttpStatus.BAD_REQUEST);
	}
}
