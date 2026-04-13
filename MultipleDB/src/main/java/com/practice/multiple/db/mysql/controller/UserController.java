package com.practice.multiple.db.mysql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.multiple.db.mysql.entity.User;
import com.practice.multiple.db.mysql.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/create")
	public ResponseEntity<String> createUser(@RequestBody User user){
		return new ResponseEntity<String>(userService.createUser(user), HttpStatus.CREATED);
	}
}
//http://localhost:8080/user/create