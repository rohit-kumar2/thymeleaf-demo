package com.thymeleaf.demo.conf;

import java.util.Arrays;

public class GroupsConfiguration {

	public static final String DEFAULT_GROUP_ADMIN = "admin";

	public static final String DEFAULT_GROUP_CUSTOMER = "customer";
	
	private String[] admin = {DEFAULT_GROUP_ADMIN};

	private String[] customer = {DEFAULT_GROUP_CUSTOMER};	
	
	public GroupsConfiguration() {
	}

	public String[] getAdmin() {
		return admin;
	}

	public void setAdmin(String[] admin) {
		this.admin = admin;
	}

	public String[] getCustomer() {
		return customer;
	}

	public void setCustomer(String[] customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "GroupsConfiguration [admin=" + Arrays.toString(admin) + ", customer=" + Arrays.toString(customer) + "]";
	}

}
