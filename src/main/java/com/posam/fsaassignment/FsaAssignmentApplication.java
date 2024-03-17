package com.posam.fsaassignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class FsaAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(FsaAssignmentApplication.class, args);
	}
}
