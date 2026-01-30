package com.practice.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerAppApplication.class, args);
	}

}
