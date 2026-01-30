package com.practice.ecs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CustomerAppEcsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerAppEcsApplication.class, args);
	}

}
