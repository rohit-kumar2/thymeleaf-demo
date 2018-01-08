package com.thymeleaf.demo.conf;

import java.util.HashMap;
import java.util.Map;

public class UIConfiguration {

	public static final String[] DEFAULT_LANGUAGES = {"English", "Spanish", "French"};
	
	private Map<String, String> links = new HashMap<>();

	private String[] languages = DEFAULT_LANGUAGES;
	
	public UIConfiguration() {
	}

	public Map<String, String> getLinks() {
		return links;
	}

	public void setLinks(Map<String, String> links) {
		this.links = links;
	}

	public String[] getLanguages() {
		return languages;
	}

	public void setLanguages(String[] languages) {
		this.languages = languages;
	}

	@Override
	public String toString() {
		return "UIConfiguration [" 
				+ (links != null ? "links=" + links : "") 
				+ (languages != null ? "languages=" + languages : "") 
				+ "]";
	}
	
}
