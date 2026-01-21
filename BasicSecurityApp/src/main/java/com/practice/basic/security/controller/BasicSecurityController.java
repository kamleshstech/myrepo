package com.practice.basic.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BasicSecurityController {
	
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
