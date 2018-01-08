package com.thymeleaf.demo.controller;


import java.security.Principal;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.greenfence.common.web.CommonControllerAdvise;
import com.greenfence.sso.client.SsoClient;
import com.thymeleaf.demo.manager.AppRoleManager;
import com.thymeleaf.demo.conf.DemoConfiguration;

@ControllerAdvice
public class AppControllerAdvise extends CommonControllerAdvise {
	
	@Autowired
	private DemoConfiguration config;
	
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
	

	@ModelAttribute("links")
	public Map<String, String> links(Principal principal, HttpSession session) {
		return config.getUi().getLinks();
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
