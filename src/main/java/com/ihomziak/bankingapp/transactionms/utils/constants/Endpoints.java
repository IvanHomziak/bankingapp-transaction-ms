package com.ihomziak.bankingapp.transactionms.utils.constants;

public class Endpoints {

	public static final String API_PREFIX = "/api/v1/transaction";

	public static final String REGEX = "/**";
	public static final String UUID_PREF = "/{uuid}";
	public static final String GET_TRANSACTION = API_PREFIX + UUID_PREF;
	public static final String CANSEL_TRANSACTION = API_PREFIX + "/cansel" + UUID_PREF;

	public static class SwaggerEndpoints {

		public static final String SWAGGER_UI = "/swagger-ui/**";
		public static final String SWAGGER_UI_HTML = "/swagger-ui.html";
		public static final String SWAGGER_UI_INDEX = "/swagger-ui/index.html";
		public static final String SWAGGER_API_DOCS_V2 = "/v2/api-docs";
		public static final String SWAGGER_API_DOCS_V3 = "/v3/api-docs/**";
		public static final String SWAGGER_RESOURCES = "/swagger-resources/**";
		public static final String SWAGGER_WEBJARS = "/webjars/**";
	}

	public static class Profiles {

		public static final String PROFILE_DEV = "dev";
		public static final String PROFILE_PROD = "prod";
	}
}