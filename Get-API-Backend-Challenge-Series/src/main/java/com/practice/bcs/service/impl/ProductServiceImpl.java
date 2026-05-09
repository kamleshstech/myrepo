package com.practice.bcs.service.impl;

import java.time.Instant;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.practice.bcs.dto.PaginatedResponse;
import com.practice.bcs.dto.ProductDTO;
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
		
		List<ProductDTO> productDtoList = productPage.getContent().stream()
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
				
			return paginatedResponse;
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
	
}
