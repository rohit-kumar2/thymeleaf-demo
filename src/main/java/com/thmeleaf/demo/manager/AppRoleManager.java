package com.thmeleaf.demo.manager;

import java.security.Principal;

import javax.servlet.http.HttpSession;

public interface AppRoleManager {
	
	boolean isAdmin(String username);
	boolean isCustomer(String username);
	
	boolean isAdmin(String username, HttpSession session);
	boolean isCustomer(String username, HttpSession session);

	Boolean isAdmin(Principal principal, HttpSession session);
	Boolean isCustomer(Principal principal, HttpSession session);

}
