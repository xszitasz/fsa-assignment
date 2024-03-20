package com.posam.fsaassignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;

// Remove SecurityAutoConfiguration when implementing security
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class FsaAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(FsaAssignmentApplication.class, args);
	}

	@Bean
	public ApplicationListener<ApplicationStartedEvent> initDatabaseData(DataSource dataSource) {
		return event -> {
			executeSqlScript("init.sql", dataSource);
		};
	}

	@Bean
	public ApplicationListener<ContextClosedEvent> cleanupDatabaseData(DataSource dataSource) {
		return event -> {
			executeSqlScript("cleanup.sql", dataSource);
		};
	}

	private void executeSqlScript(String scriptPath, DataSource dataSource) {
		ResourceDatabasePopulator populator = new ResourceDatabasePopulator(new ClassPathResource(scriptPath));
		populator.execute(dataSource);
	}
}