package com.practice.multiple.db.h2.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.multiple.db.h2.entity.Order;


public interface OrderRepository extends JpaRepository<Order, Long>{

}
