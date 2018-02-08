package com.thymeleaf.demo.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.core.task.TaskExecutor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.greenfence.bpm.common.BpmSsoClientSecurityConfigurer;
import com.greenfence.bpm.common.activity.ActivitiConfig;
import com.greenfence.common.infrastructure.InfrastructureConfig;

@Configuration
@Import({BpmSsoClientSecurityConfigurer.class, InfrastructureConfig.class, ActivitiConfig.class})
@EnableJpaRepositories(basePackages="com.thymeleaf.demo.repository")
public class PersistenceConfig {
	
	/*@Value("${spring.datasource.url}")
	private String url;
	
	@Value("${spring.datasource.username}")
	private String username;
	
	@Value("${spring.datasource.password}")
	private String password;
	
	@Value("${spring.datasource.driver-class-name}")
	private String driverClass;
	
	@Bean
    public DataSource createDataSource() throws Exception {
        ComboPooledDataSource ds = new ComboPooledDataSource();
        ds.setJdbcUrl(url+"&user="+username+"&password="+password);
        ds.setDriverClass(driverClass);
        return ds;
	}*/
	
	@Bean
	@Primary
	public TaskExecutor taskExecutor() {
		TaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
		return taskExecutor;
	}

}
