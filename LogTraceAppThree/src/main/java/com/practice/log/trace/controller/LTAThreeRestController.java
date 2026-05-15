package com.practice.log.trace.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/three")
public class LTAThreeRestController {
	private final Logger log = LoggerFactory.getLogger(LTAThreeRestController.class);
	
	@GetMapping("/cfthree")
	public String callOtherService() {
		log.info("Enter three-microservice!!!!");
		log.info("Exit three-microservice!!!!");
		return "Done with Three Microservice..."; 
 	}
}
