package com.practice.jpa.amj.entity.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.practice.jpa.amj.entity.BackWordCompatabilityWithHibernateDemo;

public interface BackWordCompatabilityWHibernateRepo extends JpaRepository<BackWordCompatabilityWithHibernateDemo, Integer>{
	
	public List<String> getDtls(@Param("b_id") Integer iid);
}
