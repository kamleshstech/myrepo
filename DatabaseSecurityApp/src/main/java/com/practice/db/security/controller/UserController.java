package com.practice.db.security.controller;

import java.security.Principal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.practice.db.security.model.User;
import com.practice.db.security.service.IUserService;

@Controller
@SessionAttributes({"mydt"})
public class UserController {
	@Autowired
	private IUserService userSvc;
	
	@GetMapping("/register")
	public String showRegister() {
		return "userRegistration"; 
	}
	@PostMapping("/save")
	public String saveUser(@ModelAttribute User user,
			Model model) throws Exception {
		Integer uId = userSvc.saveUser(user);
		String msg = "user '"+uId+"' saved";
		model.addAttribute("message", msg);
		return "userRegistration";
	}
	@GetMapping("/common")
	public String showCommon(Model m) {
		m.addAttribute("mydt", new Date());
		return "common"; 
	}
	@GetMapping("/admin")
	public String showAdmin(Principal p, Model m) {
		String uName = p.getName();
		System.out.println(p.getClass().getName());
		m.addAttribute("userName", uName);
		m.addAttribute("mydt", new Date());
		return "admin"; 
	}
	@GetMapping("/employee")
	public String showEmployee(Model m) {
		m.addAttribute("mydt", new Date());
		return "employee"; 
	}
	@GetMapping("/denied")
	public String showDenied(Model m) {
		m.addAttribute("mydt", new Date());
		return "denied"; 
	}
	@GetMapping("/home")
	public String showHome(Model m) {
		m.addAttribute("mydt", new Date());
		return "home"; 
	}	
	@GetMapping("/login")
	public String showLogin(Principal p,Model m) {
//		m.addAttribute("un", p.getName());
//		m.addAttribute("mydt", new Date());
		return "login"; 
	}	
}
