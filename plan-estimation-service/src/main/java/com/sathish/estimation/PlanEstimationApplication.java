package com.sathish.estimation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.sathish")
@EnableDiscoveryClient
public class PlanEstimationApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlanEstimationApplication.class, args);
	}
}
