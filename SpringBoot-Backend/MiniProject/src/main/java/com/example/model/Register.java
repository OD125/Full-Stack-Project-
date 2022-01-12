package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Registration_Details")
public class Register {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "City")
	private String City;
	@Column(name = "email")
	private String email;
	@Column(name = "Contact")
	private long Contact;
	@Column(name = "Date_Of_Birth")
	private String Dob;
	@Column(name = "password")
	private String password;
	
	
	
	
	public Register() {
		super();
	}




	public Register(int id, String name, String city, String email, long contact, String dob, String password) {
		super();
		this.id = id;
		this.name = name;
		City = city;
		this.email = email;
		Contact = contact;
		Dob = dob;
		this.password = password;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getCity() {
		return City;
	}




	public void setCity(String city) {
		City = city;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public long getContact() {
		return Contact;
	}




	public void setContact(long contact) {
		Contact = contact;
	}




	public String getDob() {
		return Dob;
	}




	public void setDob(String dob) {
		Dob = dob;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	@Override
	public String toString() {
		return "Register [id=" + id + ", name=" + name + ", City=" + City + ", email=" + email + ", Contact=" + Contact
				+ ", Dob=" + Dob + ", password=" + password + "]";
	}

	
	
		
		
}
