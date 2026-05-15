package com.practice.jms.amq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class ProducerAppJmsActiveMqApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProducerAppJmsActiveMqApplication.class, args);
	}

}
