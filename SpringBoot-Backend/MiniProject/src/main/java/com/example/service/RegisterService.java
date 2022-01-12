package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.UserAlreadyPresent;
import com.example.exception.UserNotPresent;
import com.example.model.Register;
import com.example.repository.Registrepo;

@Service
public class RegisterService {

	private static final Logger LOGGER = LoggerFactory.getLogger(RegisterService.class);

	@Autowired
	public Registrepo registrepo;

	public List<Register> getAllUsers() throws Exception {

		List<Register> users = new ArrayList<Register>();
		registrepo.findAll().forEach(users::add);

		if (users.isEmpty()) {
			LOGGER.error("Users are Not Present !");
			throw new UserNotPresent("User is Not Present");

		}

		return users;
	}

	public Register SaveUser(Register register) throws Exception {

		String email = register.getEmail();
		Register reg = null;

		Register alreadyRegisterUser = registrepo.findByEmail(email);
		if (alreadyRegisterUser != null) {
			LOGGER.error("Bad Request !");
			throw new UserAlreadyPresent("User Already Present");
		} else {
			reg = registrepo.save(register);
			LOGGER.info("User Added Sucessfully!");
		}

		return reg;
	}

	public Register getUserbyId(int id) throws Exception {

		Register reg = registrepo.findById(id).orElse(null);

		if (reg == null) {

			LOGGER.error("User is Not Present !");
			throw new UserNotPresent("User is Not Present");

		}

		return reg;
	}

	public void deleteregisteruser(int id) {

		registrepo.deleteById(id);

		LOGGER.info("User Deleted Sucessfully !");

	}

	public Register UpdateUser(Register register, int id) throws Exception {
		Register reg = registrepo.findById(id).orElse(null);

		reg.setCity(register.getCity());
		reg.setContact(register.getContact());
		reg.setDob(register.getDob());
		reg.setEmail(register.getEmail());
		reg.setName(register.getName());

		Register updatereg = registrepo.save(reg);
		LOGGER.info("User Updated !");
		return updatereg;
	}

	public List<Register> getUserbyEmail(String email) throws Exception {

		Register reg1 = null;

		List<Register> users = new ArrayList<Register>();
		reg1 = registrepo.findByEmail(email);

		users.add(reg1);

		if (reg1 == null || users.isEmpty()) {

			LOGGER.error("User is Not Present !");
			throw new UserNotPresent("User is Not Present");

		}
		return users;
	}

}
