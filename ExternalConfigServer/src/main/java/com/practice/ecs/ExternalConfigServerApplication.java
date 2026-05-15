package com.practice.ecs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ExternalConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExternalConfigServerApplication.class, args);
	}

}
