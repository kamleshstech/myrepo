package com.practice.jms.amc.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class ConsumerAppJmsActiveMqApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerAppJmsActiveMqApplication.class, args);
	}

}
