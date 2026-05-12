package com.practice.bcs.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.bcs.dto.PaginatedResponse;
import com.practice.bcs.dto.ProductDTO;
import com.practice.bcs.entity.Product;
import com.practice.bcs.service.IProduct;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/products")
@RequiredArgsConstructor
public class ProductController {
	
	private final IProduct productService;
	
	@GetMapping("/allProduct")
	public ResponseEntity<PaginatedResponse<ProductDTO>> getAll(
			//@PageableDefault(size = 10, sort = "productId", direction = Direction.DESC) Pageable pageable
			@PageableDefault(size = 10, direction = Direction.DESC) Pageable pageable,//if we not pass any sort key then it dynamically sort means we can sort others fields as well 
			@RequestParam(name = "keyword", required = false) String keyword,
			@RequestParam(name = "minPrice", required = false) Double minPrice,
			@RequestParam(name = "maxPrice", required = false) Double maxPrice,
			@RequestParam(name = "sortBy", required = false) String sortBy,
			@RequestParam(name = "direction", required = false) String direction
			){
		//return ResponseEntity.ok(productService.getProducts()); Basic GET API No pagination
		
		//pagination
		//Page<ProductDTO> pageOfProduct = productService.getProducts(pageable);

		//customized response
		//PaginatedResponse<ProductDTO> customizedResp = productService.getProducts(pageable);
		
		//searchProduct
		/*PaginatedResponse<ProductDTO> searchProduct = 
				productService.searchProduct(keyword, pageable.getPageNumber(), pageable.getPageSize()); */
		
		//filterProductByPriceRange
		/*PaginatedResponse<ProductDTO> filterProductByPriceRange = 
			productService.filterProductByPriceRange(minPrice, maxPrice, pageable.getPageNumber(), pageable.getPageSize());*/
		
		//searchProductBetweenPriceRange
		PaginatedResponse<ProductDTO> searchProductBetweenPriceRange = 
				productService.searchProductBetweenPriceRange(keyword, minPrice, maxPrice, pageable.getPageNumber(), 
						pageable.getPageSize(), sortBy, direction);
		
		return new ResponseEntity<>(searchProductBetweenPriceRange, HttpStatus.OK); 
	}
	
	@PostMapping("/createProduct")
	public ResponseEntity<String> createProduct(@RequestBody Product product){
		Product savedProduct = productService.createProduct(product);
		return new ResponseEntity<String>("product created with ID : "+savedProduct.getProductId(), HttpStatus.CREATED);
				//ResponseEntity.ok("product created with ID : "+savedProduct.getProductId());
	} 
}
