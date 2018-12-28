package com.e2e.userManagement.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Aprimit Garg
 *
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.headers().httpStrictTransportSecurity().includeSubDomains(true).maxAgeInSeconds(31536000);
		/*
		 * CSRF and frameOptions are disabled to access h2 in memory database.
		 * 
		 * */
		http.csrf().disable();
		http.headers().frameOptions().disable();
	}
}
