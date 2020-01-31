package com.mealTracker.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table (name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	
	@NotBlank
	public String firstName;
	
	@NotBlank
	public String lastName;
	
	@NotBlank
	public String email;
	
	@NotBlank
	public String password;
	
	@NotBlank
	public String age;
	
	@NotBlank
	public double target;
	
	public Long getId() {
		return this.id;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAge() {
		return this.age;
	}
	
	public void setAge(String age) {
		this.age = age;
	}
	
	public double getTarget () {
		return this.target;
	}
	
	public void setTarget(double target) {
		this.target = target;
	}
	
}