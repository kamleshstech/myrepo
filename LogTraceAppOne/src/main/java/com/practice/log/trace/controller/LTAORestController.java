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
@RequestMapping("/api/one")
public class LTAORestController {
	private final Logger log = LoggerFactory.getLogger(LTAORestController.class);
	@Autowired
	private RestTemplate rTemp;
	
	@GetMapping("/cfo")
	public String callOtherService() {
		log.info("Enter one-microservice!!!!");
		ResponseEntity<String> resp=rTemp.getForEntity("http://localhost:8082/api/two/cft", String.class);
		log.info("Exit one-microservice!!!!");
		return resp.toString(); 
 	}
}
//http://localhost:8081/api/one/cfo