package com.practice.email;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class RestControllerDemo {
	
	@GetMapping("/")
	public String hello() {
		return "hello.....";
	}
}
