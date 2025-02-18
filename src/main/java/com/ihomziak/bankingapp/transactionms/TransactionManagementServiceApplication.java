package com.ihomziak.bankingapp.transactionms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableDiscoveryClient
@EnableAspectJAutoProxy
public class TransactionManagementServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransactionManagementServiceApplication.class, args);
    }
}
