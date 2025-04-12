package com.ihomziak.bankingapp.transactionms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import java.util.concurrent.Executor;

@Configuration
public class AsyncConfig {

	@Bean(name = "transactionEventExecutor")
	public Executor transactionEventExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(5);    // Основний розмір пулу потоків
		executor.setMaxPoolSize(10);    // Максимальний розмір пулу потоків
		executor.setQueueCapacity(25);  // Ємність черги для завдань
		executor.setThreadNamePrefix("TransactionEvent-"); // Префікс імен потоків
		executor.initialize();          // Ініціалізація пулу потоків
		return executor;
	}
}
