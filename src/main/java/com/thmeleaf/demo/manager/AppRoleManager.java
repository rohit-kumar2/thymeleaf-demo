package com.thmeleaf.demo.manager;

import java.security.Principal;

import javax.servlet.http.HttpSession;

public interface AppRoleManager {

	Boolean isAdmin(Principal principal, HttpSession session);

	Boolean isCustomer(Principal principal, HttpSession session);

}
