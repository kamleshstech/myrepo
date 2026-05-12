package com.practice.bcs.service;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;

import com.practice.bcs.dto.PaginatedResponse;
import com.practice.bcs.dto.ProductDTO;
import com.practice.bcs.entity.Product;

public interface IProduct {
	
	Product createProduct(Product product);
	
	//List<ProductDTO>getProducts();
	//Page<ProductDTO>getProducts(Pageable pageble);
	PaginatedResponse<ProductDTO> getProducts(Pageable pageble);
	
	//search
	PaginatedResponse<ProductDTO> searchProduct(String keyword, int pageNo, int size);
	
	//priceBetween
	PaginatedResponse<ProductDTO> filterProductByPriceRange(Double min, Double max, int pageNo, int size);
	
	//searchProductBetweenPriceRange
	PaginatedResponse<ProductDTO> searchProductBetweenPriceRange(String keyword, Double min, Double max, int pageNo, int size,
			String sortBy, String direction);
}
