package com.ihomziak.bankingapp.transactionms.security;


import static com.ihomziak.bankingapp.transactionms.utils.constants.Endpoints.Profiles.PROFILE_PROD;

import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;

@Profile(PROFILE_PROD)
public class AuthorizationFilterProd extends AuthorizationFilterBase {

	public AuthorizationFilterProd(AuthenticationManager authManager, Environment environment) {
		super(authManager, environment);
	}

	@Override
	protected boolean isPublicEndpoint(String path) {
		return false;
	}
}
