package com.practice.jpa.oc.runner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.practice.jpa.oc.entity.Product;
import com.practice.jpa.oc.repo.OthConceptRepo;
import com.practice.jpa.oc.repo.OthConceptRepo.A;
import com.practice.jpa.oc.repo.OthConceptRepo.B;

@Component
public class OtherConRunner implements CommandLineRunner{
	
	@Autowired
	OthConceptRepo conceptRepo;
	
	public void otherCon() {
		/*****
		 * findBy() 
		 */
		//conceptRepo.findByCode("TV").forEach(System.out::println);
		//conceptRepo.findByPriceLessThan(new BigDecimal("200.00")).forEach(System.out::println); 
		//conceptRepo.findByShortDescContaining("o").forEach(System.out::println);
		//conceptRepo.findByShortDescIgnoreCase("samsung").forEach(System.out::println);
		//conceptRepo.findByCodeAndPrice("TV",new BigDecimal("123.10")).forEach(System.out::println);
		
		/******
		 * Projection 
		 */
		//*****************static projection*****************************
		//conceptRepo.findByPrice(new BigDecimal("123.10")).forEach(a -> System.out.println(a.getString()));
		//*****************dynamic projection****************************
		//conceptRepo.findByCode("TV",B.class).forEach(product -> System.out.println(product.getString()));
		
		/*****
		 * @Query
		 */
		Product productDtls = conceptRepo.getProductDtls(5);
		//System.out.println("Product DTLS : " +productDtls);
		System.out.println("******************************************************************************************");
		String oneFieldDetailOfProduct = conceptRepo.getOneFieldDetailOfProduct(3);
		//System.out.println("oneFieldDetailOfProduct : " +oneFieldDetailOfProduct);
		System.out.println("******************************************************************************************");
		Object moreThanOneFieldDtlsOfSameProduct = conceptRepo.getMoreThanOneFieldDtlsOfProduct(1); 

			Object [] arr =  (Object[]) moreThanOneFieldDtlsOfSameProduct;
			System.out.println(arr[0]+"::::::"+arr[1]);
		
		System.out.println("******************************************************************************************");
	}
	
	@Override
	public void run(String... args) throws Exception {
		Product tv 		= new Product(1, "TV",     "samsung", "SMG 52 inch",   new BigDecimal("123.10"));
		Product laptop  = new Product(2, "MOBILE", "samsung",  "LEN 12.5 inch", new BigDecimal("103.01"));
		Product ac 		= new Product(3, "TV",     "okai",    "OKAI 52 inch",  new BigDecimal("123.10"));
		Product mobile  = new Product(4, "MOBILE", "APPLE",   "APPL 6.2 inch", new BigDecimal("653.11"));
		Product fridge  = new Product(5, "fridge", "LG",      "LG 102 inch",   new BigDecimal("113.00"));
		
		ArrayList<Product> productList = new ArrayList<>();
		productList.add(tv);productList.add(laptop);productList.add(ac);productList.add(mobile);productList.add(fridge);
		
		conceptRepo.saveAll(productList);
		otherCon();
	}
	
}
