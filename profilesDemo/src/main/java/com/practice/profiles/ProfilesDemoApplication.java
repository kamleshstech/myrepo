package com.practice.profiles;

import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ProfilesDemoApplication {

	public static void main(String[] args) {
		//ConfigurableApplicationContext ctx = SpringApplication.run(ProfilesDemoApplication.class, args);
		SpringApplication app = new SpringApplication(ProfilesDemoApplication.class);
		//app.setBannerMode(Mode.OFF);
		app.run(args);
		
	}

}
