package com.practice.bcs.service.impl;

import java.time.Instant;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.practice.bcs.dto.PaginatedResponse;
import com.practice.bcs.dto.ProductDTO;
import com.practice.bcs.dto.ProductSpecification;
import com.practice.bcs.entity.MetaData;
import com.practice.bcs.entity.Product;
import com.practice.bcs.repository.ProductRepository;
import com.practice.bcs.service.IProduct;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements IProduct{

	private final ProductRepository productRepository;
	private final ModelMapper modelMapper;
	
/*	@Override
	public List<ProductDTO> getProducts() {
		List<Product> products = productRepository.findAll();
		
		return products
				.stream()
				.map(product -> modelMapper.map(product, ProductDTO.class))
				.toList();
	}
*/
	
/*	@Override
	public Page<ProductDTO> getProducts(Pageable pageble) {
		Page<Product> pageOfProduct = productRepository.findAll(pageble);
		
		return pageOfProduct.map(product -> modelMapper.map(product, ProductDTO.class));
	}
*/	
	
	@Override
	public PaginatedResponse<ProductDTO> getProducts(Pageable pageble) {
		Page<Product> productPage = productRepository.findAll(pageble);
		
/*		List<ProductDTO> productDtoList = productPage.getContent().stream()
				.map(product -> modelMapper.map(product, ProductDTO.class)).toList();
		
		PaginatedResponse<ProductDTO> paginatedResponse = PaginatedResponse.<ProductDTO>builder()
				.totalElements(productPage.getTotalElements())
				.totalPages(productPage.getTotalPages())
				.currentPage(productPage.getNumber())
				.pageSize(productPage.getSize())
				.isFirst(productPage.isFirst())
				.isLast(productPage.isLast())
				.items(productDtoList) 
				.build();
	*/
		//PaginatedResponse<ProductDTO> paginatedResponse = convertToPaginateResp(productPage);
		
			return convertToPaginateResp(productPage);
	}
	
	
	@Override
	public PaginatedResponse<ProductDTO> searchProduct(String keyword, int pageNo, int size) {
		Specification<Product> searchSpec = Specification.where(ProductSpecification.searchProduct(keyword));
		Pageable pageable = PageRequest.of(pageNo, size);
		Page<Product> productPage = productRepository.findAll(searchSpec, pageable);
		
		return convertToPaginateResp(productPage); 
	}

	@Override
	public PaginatedResponse<ProductDTO> filterProductByPriceRange(Double min, Double max, int pageNo, int size) {
		Specification<Product> priceBetweenSpec = Specification.where(ProductSpecification.productByPriceBetween(min, max));
		Pageable pageable = PageRequest.of(pageNo, size);
		Page<Product> productPage = productRepository.findAll(priceBetweenSpec, pageable);
		
		return convertToPaginateResp(productPage);
	}

	@Override
	public PaginatedResponse<ProductDTO> searchProductBetweenPriceRange(String keyword, Double min, Double max,
			int pageNo, int size, String sortBy, String direction) {
		Specification<Product> searchPriceBetweenSpec = 
				Specification.where(ProductSpecification.searchProduct(keyword)).and(ProductSpecification.productByPriceBetween(min, max));
		
		Sort sort = direction.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
		
		Pageable pageable = PageRequest.of(pageNo, size, sort);
		
		Page<Product> productPage = productRepository.findAll(searchPriceBetweenSpec, pageable);
		
		return convertToPaginateResp(productPage); 
	}
	
	@Override
	public Product createProduct(Product product) {
		
		//To insert bulk data to test 
		for(int i=1;i<200;i++) {
			MetaData image = new MetaData();
			image.setDescription("Front and back view image "+i);
			image.setVendor("Apple Inc.");
			image.setUploadDt(Instant.now());
			
			Product p = new Product();
			p.setTitle("iPhone 15 - "+i);
			p.setDescription("Latest Apple smartphone");
			p.setShort_description("Premium Phone");
			p.setPrice(79999 + i);
			p.setLive("yes");
			p.setOutOfStock(i % 2 == 0);
			p.setImage(image);
			
			productRepository.save(p);
		}
		//testing 
		
		return productRepository.save(product);
		
	}	
	private PaginatedResponse<ProductDTO> convertToPaginateResp(Page<Product> productPage){
		List<ProductDTO> prodDtoList 
			= productPage.getContent().stream().map(product -> modelMapper.map(product, ProductDTO.class)).toList();
		
		PaginatedResponse<ProductDTO> paginatedResponse = PaginatedResponse.<ProductDTO>builder()
				.totalElements(productPage.getTotalElements())
				.totalPages(productPage.getTotalPages())
				.currentPage(productPage.getNumber())
				.pageSize(productPage.getSize())
				.isFirst(productPage.isFirst())
				.isLast(productPage.isLast())
				.items(prodDtoList)
				.build();
				
		return paginatedResponse; 
	}
}
