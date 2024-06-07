package com.voting.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.voting.application.model.Candidate;
import com.voting.application.model.UserRegistration;


@Configuration
public class AppConfig {

	@Bean
	public UserRegistration userRegistration() {
		return new UserRegistration(); // Initialize as needed
	}

	@Bean
	public Candidate candidate() {
		return new Candidate();

	}

	

}
