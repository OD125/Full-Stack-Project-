package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.UnableToLogin;
import com.example.model.Register;
import com.example.repository.Loginrepo;
import com.example.repository.Registrepo;

@Service
public class LoginService {

	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(LoginService.class);

	@Autowired
	public Loginrepo loginrepo;

	public Register findByEmailAndPassword(Register register) throws Exception {

		String email = register.getEmail();
		String password = register.getPassword();

		Register reg = null;

		if (email != null && password != null) {

			reg = loginrepo.findByEmailAndPassword(email, password);

		}

		if (reg == null) {
			
			LOGGER.error("User Credentials are Bad");

			throw new UnableToLogin("User Cant Login");

		}

		LOGGER.info("Log in Sucessfully !");

		return reg;

	}

}
