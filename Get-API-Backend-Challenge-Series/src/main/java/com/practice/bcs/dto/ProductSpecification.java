package com.practice.bcs.dto;

import org.springframework.data.jpa.domain.Specification;

import com.practice.bcs.entity.Product;

public class ProductSpecification {
	
	public static Specification<Product> searchProduct(String keyword){
		//Predicate toPredicate(Root<T> root, @Nullable CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder);
		
		return (root, query, criteriaBuilder) -> {
			
			if(keyword == null || keyword.isBlank()){
				return null;
			}
			
			String pattern = "%" + keyword.toLowerCase() + "%";
			
			return criteriaBuilder.or(
					criteriaBuilder.like(criteriaBuilder.lower(root.get("title")),pattern),
					criteriaBuilder.like(criteriaBuilder.lower(root.get("description")), pattern),
					criteriaBuilder.like(criteriaBuilder.lower(root.get("short_description")), pattern) 
					);
		}; 
	}
	
	public static Specification<Product> productByPriceBetween(Double minPrice, Double maxPrice){
		return (root, query, criteriaBuilder) -> {
			
			if(minPrice == null && maxPrice == null) {
				return null;
			}
			
			if(minPrice != null && maxPrice != null) {
				return criteriaBuilder.between(root.get("price"), minPrice, maxPrice);
			}
			else if(minPrice != null) {
				return criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice);
			}
			else {
				return criteriaBuilder.lessThanOrEqualTo(root.get("price"), maxPrice);
			}
			
		};  

	}
	
}
