package com.practice.bcs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.practice.bcs.entity.Product;

//public interface ProductRepository extends JpaRepository<Product, Long>{}

public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product>{

}
