package com.thymeleaf.demo.manager;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.greenfence.sso.client.manager.RoleManager;
import com.thymeleaf.demo.conf.DemoConfiguration;

@Service
@Configuration
public class AppRoleManagerImpl implements AppRoleManager {
	
	@Autowired
	private DemoConfiguration config;
	
	@Autowired
	private RoleManager roleManager;


	private boolean isMember(String username, String[] groups) {
		return roleManager.isMember(username, groups);
	}

	private boolean isMember(String username, String[] groups, HttpSession session) {
		return roleManager.isMember(username, groups, session);
	}
	
	private boolean isMember(Principal principal, String[] groups, HttpSession session) {
		return roleManager.isMember(principal, groups, session);
	}

	@Override
	public boolean isAdmin(String username) {
		String[] admin = config.getGroups().getAdmin();
		return isMember(username, admin);
	}

	@Override
	public boolean isCustomer(String username) {
		String[] customer = config.getGroups().getCustomer();
		return isMember(username, customer);
	}

	@Override
	public boolean isAdmin(String username, HttpSession session) {
		String[] admin = config.getGroups().getAdmin();
		return isMember(username, admin, session);
	}

	@Override
	public boolean isCustomer(String username, HttpSession session) {
		String[] customer = config.getGroups().getCustomer();
		return isMember(username, customer, session);
	}

	@Override
	public Boolean isAdmin(Principal principal, HttpSession session) {
		String[] admin = config.getGroups().getAdmin();
		return isMember(principal, admin, session);
	}

	@Override
	public Boolean isCustomer(Principal principal, HttpSession session) {
		String[] customer = config.getGroups().getCustomer();
		return isMember(principal, customer, session);
	}

}
