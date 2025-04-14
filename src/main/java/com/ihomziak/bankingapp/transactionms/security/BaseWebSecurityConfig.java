package com.ihomziak.bankingapp.transactionms.security;

import static com.ihomziak.bankingapp.transactionms.utils.constants.Endpoints.*;
import static com.ihomziak.bankingapp.transactionms.utils.constants.Endpoints.Profiles.*;
import static com.ihomziak.bankingapp.transactionms.utils.constants.Endpoints.SwaggerEndpoints.*;


import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

public abstract class BaseWebSecurityConfig {

	protected final Environment environment;

	protected BaseWebSecurityConfig(Environment environment) {
		this.environment = environment;
	}

	protected SecurityFilterChain configure(HttpSecurity http, boolean permitSwagger) throws Exception {
		AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
		AuthenticationManager authenticationManager = authenticationManagerBuilder.build();

		http
			.csrf(AbstractHttpConfigurer::disable)
			.authorizeHttpRequests((auth) -> {
				if (permitSwagger) {
					auth.requestMatchers(SWAGGER_UI, SWAGGER_UI_HTML, SWAGGER_UI_INDEX,
							SWAGGER_API_DOCS_V2, SWAGGER_API_DOCS_V3,
							SWAGGER_RESOURCES, SWAGGER_WEBJARS).permitAll()
						.requestMatchers(HttpMethod.GET, GET_TRANSACTION).permitAll()
						.requestMatchers(HttpMethod.POST, API_PREFIX).permitAll()
                        .requestMatchers(HttpMethod.GET, CANSEL_TRANSACTION).permitAll();

                } else {
					auth.requestMatchers(SWAGGER_UI, SWAGGER_UI_HTML, SWAGGER_UI_INDEX,
							SWAGGER_API_DOCS_V2, SWAGGER_API_DOCS_V3,
							SWAGGER_RESOURCES, SWAGGER_WEBJARS).authenticated()
						.requestMatchers(HttpMethod.GET, GET_TRANSACTION).authenticated()
						.requestMatchers(HttpMethod.POST, API_PREFIX).authenticated()
						.requestMatchers(HttpMethod.GET, CANSEL_TRANSACTION).authenticated();

				}
			})
			.addFilter(getAuthorizationFilter(authenticationManager))
			.authenticationManager(authenticationManager)
			.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

		return http.build();
	}

	private BasicAuthenticationFilter getAuthorizationFilter(AuthenticationManager authManager) {
		if (environment.acceptsProfiles(Profiles.of(PROFILE_DEV))) {
			return new AuthorizationFilterDev(authManager, environment);
		} else {
			return new AuthorizationFilterProd(authManager, environment);
		}
	}

}