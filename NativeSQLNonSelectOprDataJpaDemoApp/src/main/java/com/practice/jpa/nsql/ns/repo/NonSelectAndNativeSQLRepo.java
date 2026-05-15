package com.practice.jpa.nsql.ns.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.practice.jpa.nsql.ns.entity.Order;

public interface NonSelectAndNativeSQLRepo extends JpaRepository<Order, Integer>{
	
	//native query ex
	
	@Query(value = "SELECT * from ordertab WHERE order_by=:orderBy",nativeQuery = true)//slect from tha DB table 
	Order getOrderDtls(String orderBy);
	
	// non select operations
	
	@Transactional
	@Modifying
	@Query("UPDATE com.practice.jpa.nsql.ns.entity.Order SET orderNumber=:oNum WHERE id=:oId")
	int updateOrderNum(String oNum, int oId);
	
	@Transactional
	@Modifying
	@Query("DELETE com.practice.jpa.nsql.ns.entity.Order WHERE id=:oId")
	int deleteOrder(int oId);

//*********************************************************************************************************************************************
	//**************Working With Collections In JPA******************************
	
}
