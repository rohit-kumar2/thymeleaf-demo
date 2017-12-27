package com.thymeleaf.demo.entity;

import java.time.LocalDate;
import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String username;

	private String email;

	private byte[] password;

	private String firstName;

	private String lastName;

	private String title;
	
	private String gender;
	
	private LocalDate birthdate;
	
	private LocalDate customerSince;

	public Customer() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte[] getPassword() {
		return password;
	}

	public void setPassword(byte[] password) {
		this.password = password;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	public LocalDate getCustomerSince() {
		return customerSince;
	}

	public void setCustomerSince(LocalDate customerSince) {
		this.customerSince = customerSince;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", username=" + username + ", email=" + email + ", password="
				+ Arrays.toString(password) + ", firstName=" + firstName + ", lastName=" + lastName + ", title=" + title
				+ ", gender=" + gender + ", birthdate=" + birthdate + ", customerSince=" + customerSince + "]";
	}	

}
