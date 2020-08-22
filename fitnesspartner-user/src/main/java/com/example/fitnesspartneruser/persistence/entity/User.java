package com.example.fitnesspartneruser.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

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
	
	private Integer age;
	
	private String gender;
	
	private Integer bmi;
	
	@JsonProperty(access = Access.WRITE_ONLY)
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

	public Integer getBmi() {
		return bmi;
	}

	public void setBmi(Integer bmi) {
		this.bmi = bmi;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	

}
