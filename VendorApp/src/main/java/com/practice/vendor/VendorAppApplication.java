package com.practice.vendor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class VendorAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(VendorAppApplication.class, args);
	}

}
