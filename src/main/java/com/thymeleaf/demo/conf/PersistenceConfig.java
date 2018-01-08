package com.thymeleaf.demo.conf;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
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
import com.greenfence.common.repository.CommonRepositoryConfig;
import com.greenfence.document.client.DocumentsClientConfig;
import com.greenfence.notifications.client.NotificationsClientConfig;
import com.greenfence.notifications.client.StompWebSocketConfig;
import com.greenfence.payments.client.PaymentsClientConfig;
import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@Import({InfrastructureConfig.class, CommonRepositoryConfig.class})
@EnableJpaRepositories(basePackages="com.thymeleaf.demo.repository")
public class PersistenceConfig {
	
	@Value("${spring.datasource.url}")
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
	}
	
	@Bean
	@Primary
	public TaskExecutor taskExecutor() {
		TaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
		return taskExecutor;
	}

}
