package com.thymeleaf.demo.entity;

import java.util.Arrays;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Customer {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="customer_id")
	private Long id;
	
	private String username;

	private String email;

	private byte[] password;

	private String firstName;

	private String lastName;

	private String title;
	
	private String gender;
	
	@Temporal(TemporalType.DATE)
	private Date birthdate;
	
	@Temporal(TemporalType.DATE)
	private Date customerSince;
    
    @Embedded 
    private Address address;

	public Customer() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public Date getCustomerSince() {
		return customerSince;
	}

	public void setCustomerSince(Date customerSince) {
		this.customerSince = customerSince;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", username=" + username + ", email=" + email + ", password="
				+ Arrays.toString(password) + ", firstName=" + firstName + ", lastName=" + lastName + ", title=" + title
				+ ", gender=" + gender + ", birthdate=" + birthdate + ", customerSince=" + customerSince + ", address="
				+ address + "]";
	}	

}
