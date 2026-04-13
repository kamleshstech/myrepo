package com.practice.multiple.db.mysql.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.multiple.db.mysql.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
