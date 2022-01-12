package com.example.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.exception.UnableToLogin;
import com.example.exception.UserAlreadyPresent;
import com.example.exception.UserNotPresent;

@ControllerAdvice
public class MyControllerAdvice {

	private static final Logger LOGGER = LoggerFactory.getLogger(MyControllerAdvice.class);

	
	@ExceptionHandler(UnableToLogin.class)
	public ResponseEntity<String> UnabletoLogin(UnableToLogin unableToLogin) {
		
		
		LOGGER.error("User Credentials are Bad");

		return new ResponseEntity<String>("User Credentials are Bad", HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(UserNotPresent.class)
	public ResponseEntity<String> UsernotPresent(UserNotPresent userNotPresent) {
		
		
		LOGGER.error("User Not Present in Database");
		return new ResponseEntity<String>("User Not Present in Database", HttpStatus.NOT_ACCEPTABLE);
	}

	@ExceptionHandler(UserAlreadyPresent.class)
	public ResponseEntity<String> UserAlreadyPresent(UserAlreadyPresent useralreadypresent) {
		
		
		LOGGER.error("User Already Present in Database");
		return new ResponseEntity<String>("User Already Present in Database", HttpStatus.NOT_ACCEPTABLE);
	}

	
}
