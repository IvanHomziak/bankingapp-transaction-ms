package com.ihomziak.bankingapp.transactionms.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CacheConfig {

	/**
	 * CacheManager bean for managing caches.
	 * This example uses a simple in-memory cache manager.
	 * In a production application, you might want to use a more robust solution like Redis or Ehcache.
	 *
	 * @return CacheManager instance
	 */
	@Bean
	public CacheManager cacheManager() {
		return new ConcurrentMapCacheManager("transactions");
	}
}
