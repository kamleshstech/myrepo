package com.practice.multiple.db.mysql.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practice.multiple.db.mysql.entity.User;
import com.practice.multiple.db.mysql.repo.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Transactional("mysqlTxManager")
	public String createUser(User user) {
		User createdUser = userRepo.save(user);
		return "User created with Id : "+createdUser.getId();
	}
}
