package com.practice.jpa.amj.entity.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.practice.jpa.amj.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{
	
	@Query("SELECT c.cname, co.OffDesc, co.vendorDtls FROM Customer c INNER JOIN c.offers co WHERE c.cid=:c_id") //like sql joins "ON" is not required in HQL   
	public List<Object []> getCustomerById(Integer c_id);
}
