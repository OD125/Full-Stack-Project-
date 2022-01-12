package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.model.Register;

@Repository
public interface Registrepo extends JpaRepository<Register, Integer> {


	//public Register findByName(String name);
	
	public Register findByEmail(String email);
}
