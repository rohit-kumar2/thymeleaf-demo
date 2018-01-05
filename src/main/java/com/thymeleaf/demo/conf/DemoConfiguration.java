package com.thymeleaf.demo.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("demo")
public class DemoConfiguration {

	@NestedConfigurationProperty
	private GroupsConfiguration groups = new GroupsConfiguration();

}
