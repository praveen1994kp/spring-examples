package com.example.fitnesspartneruser.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	private String email;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "weight_in_kg")
	private String weightInKg;
	
	@Column(name = "height_in_cm")
	private String heightInCm;
	
	private int bmi;
	
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getWeightInKg() {
		return weightInKg;
	}

	public void setWeightInKg(String weightInKg) {
		this.weightInKg = weightInKg;
	}

	public String getHeightInCm() {
		return heightInCm;
	}

	public void setHeightInCm(String heightInCm) {
		this.heightInCm = heightInCm;
	}

	public int getBmi() {
		return bmi;
	}

	public void setBmi(int bmi) {
		this.bmi = bmi;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}
