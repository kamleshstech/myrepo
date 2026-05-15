package com.practice.db.security.service;

import com.practice.db.security.model.User;

public interface IUserService {
	
	Integer saveUser(User user) throws Exception;
}
