package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Register;

@Repository
public interface Loginrepo extends JpaRepository<Register, Integer> {

	public Register findByEmailAndPassword(String email, String password);


	
}
