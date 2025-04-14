package com.ihomziak.bankingapp.transactionms.security;


import static com.ihomziak.bankingapp.transactionms.utils.constants.Endpoints.Profiles.PROFILE_DEV;
import static com.ihomziak.bankingapp.transactionms.utils.constants.Endpoints.SwaggerEndpoints.*;

import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;

@Profile(PROFILE_DEV)
public class AuthorizationFilterDev extends AuthorizationFilterBase {

	public AuthorizationFilterDev(AuthenticationManager authManager, Environment environment) {
		super(authManager, environment);
	}

	@Override
	protected boolean isPublicEndpoint(String path) {
		return path.startsWith(SWAGGER_UI) ||
			path.startsWith(SWAGGER_UI_HTML) ||
			path.startsWith(SWAGGER_UI_INDEX) ||
			path.startsWith(SWAGGER_API_DOCS_V2) ||
			path.startsWith(SWAGGER_API_DOCS_V3) ||
			path.startsWith(SWAGGER_RESOURCES) ||
			path.startsWith(SWAGGER_WEBJARS);
	}
}