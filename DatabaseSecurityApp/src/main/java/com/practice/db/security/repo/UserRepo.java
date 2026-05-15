package com.practice.db.security.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.practice.db.security.model.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	
	User findByUserEmail(@Param("userEmail") String userEmail); 
}
