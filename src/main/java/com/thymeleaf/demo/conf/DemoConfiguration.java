package com.thymeleaf.demo.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("demo")
public class DemoConfiguration {

	@NestedConfigurationProperty
	private GroupsConfiguration groups = new GroupsConfiguration();
	
	@NestedConfigurationProperty
	private UIConfiguration ui = new UIConfiguration();

	public GroupsConfiguration getGroups() {
		return groups;
	}

	public void setGroups(GroupsConfiguration groups) {
		this.groups = groups;
	}

	public UIConfiguration getUi() {
		return ui;
	}

	public void setUi(UIConfiguration ui) {
		this.ui = ui;
	}

	@Override
	public String toString() {
		return "DemoConfiguration [groups=" + groups + ", ui=" + ui + "]";
	}

}
