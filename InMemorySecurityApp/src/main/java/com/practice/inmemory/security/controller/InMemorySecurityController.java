package com.practice.inmemory.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InMemorySecurityController {
	
	@RequestMapping({"/home","/"})
	public String showHome() {
		System.out.println("inside.....home");
		return "home";
	}
	
	@RequestMapping({"/inbox"})
	public String showInbox() {
		System.out.println("inside.....inbox");
		return "inbox";
	}

}
