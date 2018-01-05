package com.thymeleaf.demo.controller;


import java.security.Principal;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.greenfence.common.web.CommonControllerAdvise;
import com.greenfence.sso.client.SsoClient;
import com.thmeleaf.demo.manager.AppRoleManager;

@ControllerAdvice
public class AppControllerAdvise extends CommonControllerAdvise {
	
	@ModelAttribute("principal")
	public Principal principal(Principal principal) {
		return principal;
    }


	@Override
	protected Object makePrincipalInfo(Principal principal) {
		if (principal!=null) {
			return SsoClient.getProfile(principal);
		}
		return null;
    }
	
	@Autowired
	private AppRoleManager roleManager;
	

	@ModelAttribute("admin")
	public Boolean admin(Principal principal, HttpSession session) {
		return roleManager.isAdmin(principal, session);
    }
	

	@ModelAttribute("customer")
	public Boolean isCustomer(Principal principal, HttpSession session) {
		return roleManager.isCustomer(principal, session);
    }
	
	
}
