package com.practice.gateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Value("${server.port}")//${server.port}
	String port;
	
	@Autowired
	HttpServletRequest req;
	
	@GetMapping("/getUser")
	public String getUsers() {
		String url = req.getRequestURL().toString();
		return "user list from user service...."+port+" "+url;
	}
		
}
