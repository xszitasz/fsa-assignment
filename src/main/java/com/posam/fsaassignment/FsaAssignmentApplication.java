package com.posam.fsaassignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

// Remove SecurityAutoConfiguration when implementing security
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class FsaAssignmentApplication {
	public static void main(String[] args) {
		SpringApplication.run(FsaAssignmentApplication.class, args);
	}
}
