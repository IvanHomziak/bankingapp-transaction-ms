package com.ihomziak.bankingapp.transactionms.security;

import static com.ihomziak.bankingapp.transactionms.utils.constants.Endpoints.Profiles.PROFILE_DEV;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Profile(PROFILE_DEV)
@Configuration
@EnableWebSecurity
public class WebSecurityDev extends BaseWebSecurityConfig {

	public WebSecurityDev(Environment environment) {
		super(environment);
	}

	@Bean
	public SecurityFilterChain devSecurityFilterChain(HttpSecurity http) throws Exception {
		return configure(http, true);
	}
}
