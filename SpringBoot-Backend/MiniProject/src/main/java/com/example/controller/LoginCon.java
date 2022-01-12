package com.example.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.UnableToLogin;
import com.example.model.Register;
import com.example.service.LoginService;
import com.example.service.RegisterService;

@RestController
@CrossOrigin("*")
public class LoginCon {

	@Autowired
	private LoginService loginservice;

	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(LoginCon.class);

	@PostMapping("/login")
	public Register loginUser(@RequestBody Register register) throws Exception {

		return loginservice.findByEmailAndPassword(register);
	}
	
	
}
