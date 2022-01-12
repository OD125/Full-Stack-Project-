package com.example.exception;

public class UnableToLogin extends RuntimeException {
	public UnableToLogin(String message) {
		super(message);
	}
}
