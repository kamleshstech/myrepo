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
@RequestMapping("/api/two")
public class LTATRestController {
	private final Logger log = LoggerFactory.getLogger(LTATRestController.class);
	@Autowired
	private RestTemplate rTemp;
	
	@GetMapping("/cft")
	public String callOtherService() {
		log.info("Enter two-microservice!!!!");
		ResponseEntity<String> resp=rTemp.getForEntity("http://localhost:8083/api/three/cfthree", String.class);
		log.info("Exit two-microservice!!!!");
		return resp.toString(); 
 	}
}
