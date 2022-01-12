package com.example.exception;

public class UserAlreadyPresent extends RuntimeException {
	
	public UserAlreadyPresent(String message)
	{
		super(message);
	}

}
