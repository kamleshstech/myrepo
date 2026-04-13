package com.practice.multiple.db.h2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practice.multiple.db.h2.entity.Order;
import com.practice.multiple.db.h2.repo.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository orderRepo;
	
	@Transactional("h2TxManager")
	public String placeOrder(Order order) {
		Order savedOrder = orderRepo.save(order);
		return "Your Order Placed Successfully !! Order ID : "+savedOrder.getId();
	}

}
