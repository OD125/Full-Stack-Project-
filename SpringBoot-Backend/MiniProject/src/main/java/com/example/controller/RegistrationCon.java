package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.UserNotPresent;
import com.example.model.Register;
import com.example.service.RegisterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@CrossOrigin(origins = "*")
public class RegistrationCon {

	@Autowired
	public RegisterService registerservice;

	@GetMapping("/users")
	public List<Register> getAllUsers() throws Exception {

		return registerservice.getAllUsers();

	}

	@PostMapping("/users")
	public Register addUser(@RequestBody Register register) throws Exception {

		return registerservice.SaveUser(register);

	}

	@GetMapping("/users/{id}")
	public Register getUserbyID(@PathVariable int id) throws Exception {

		return registerservice.getUserbyId(id);

	}

	@GetMapping("/user/{email}")
	public List<Register> getUserbyEmail(@PathVariable String email) throws Exception {

		return registerservice.getUserbyEmail(email);

	}

	@DeleteMapping("/users/{id}")
	public void deleteregisterUser(@PathVariable int id) {

		registerservice.deleteregisteruser(id);

	}

	@PutMapping("/users/{id}")
	public Register updateUser(@RequestBody Register register, @PathVariable int id) throws Exception {

		return registerservice.UpdateUser(register, id);
	}

}
