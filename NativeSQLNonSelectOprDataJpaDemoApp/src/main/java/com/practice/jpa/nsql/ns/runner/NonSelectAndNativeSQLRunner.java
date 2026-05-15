package com.practice.jpa.nsql.ns.runner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.practice.jpa.nsql.ns.entity.Order;
import com.practice.jpa.nsql.ns.repo.NonSelectAndNativeSQLRepo;

@Component
public class NonSelectAndNativeSQLRunner implements CommandLineRunner{

	@Autowired
	NonSelectAndNativeSQLRepo repo;
	
	//Native Query Ex
	public void nativeQueryEx() {
		Order orderDtls = repo.getOrderDtls("6267115588"); 
		System.out.println(orderDtls);
	}

	//Non Select Operations
	public void nonSelectOperEx() {
		int count = repo.updateOrderNum("ABC#123", 1); 
		//System.out.println(count);
		
		int deleteOrder = repo.deleteOrder(5);
		System.out.println("deleted : "+deleteOrder); 
	}
	
//*****************Collection*****************************************
	public void collectionDemo() {
		List<Order> findAll = repo.findAll();
		//findAll.forEach(order -> System.out.println(order)); 
		System.out.println("==="+findAll);
	}
	
	@Override
	public void run(String... args) throws Exception {
		Order order1 = new Order(1, "ORD#12", "12/01/2025", "6267115588",List.of("A1","B1","C1"),Set.of("D1","E1","F1"),Map.of("G-1-key","H-1-Val","I-1-key","J-1-Val"));
		Order order2 = new Order(2, "ORD#102", "22/10/2024", "9424488661",List.of("A2","B2","C2"),Set.of("D2","E2","F2"),Map.of("G-2-key","H-2-Val","I-2-key","J-2-Val"));		
		Order order3 = new Order(3, "ORD#2542", "19/02/2025", "7972238142",List.of("A3","B3","C3"),Set.of("D3","E3","F3"),Map.of("G-3-key","H-3-Val","I-3-key","J-3-Val"));		
		Order order4 = new Order(4, "ORD#9687", "12/03/2025", "7000406661",List.of("A4","B4","C4"),Set.of("D4","E4","F4"),Map.of("G-4-key","H-4-Val","I-4-key","J-4-Val"));		
		Order order5 = new Order(5, "ORD#001222", "18/01/2025", "9052494164",List.of("A5","B5","C5"),Set.of("D5","E5","F5"),Map.of("G-5-key","H-5-Val","I-5-key","J-5-Val"));
		
		ArrayList<Order> orderList = new ArrayList<>();
		orderList.add(order1);orderList.add(order2);orderList.add(order3);orderList.add(order4);orderList.add(order5);
		
		repo.saveAll(orderList);
		
		//nativeQueryEx();
		//nonSelectOperEx(); 
		collectionDemo();
		
	}

}
