package com.practice.bcs.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.practice.bcs.dto.PaginatedResponse;
import com.practice.bcs.dto.ProductDTO;
import com.practice.bcs.entity.Product;

public interface IProduct {
	
	Product createProduct(Product product);
	
	//List<ProductDTO>getProducts();
	//Page<ProductDTO>getProducts(Pageable pageble);
	PaginatedResponse<ProductDTO> getProducts(Pageable pageble);
}
