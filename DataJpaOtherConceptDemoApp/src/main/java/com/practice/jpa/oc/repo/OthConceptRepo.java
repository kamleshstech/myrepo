package com.practice.jpa.oc.repo;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.practice.jpa.oc.entity.Product;

public interface OthConceptRepo extends JpaRepository<Product, Integer>{
	//******************************************************************************************************
	//customerquery using findBy => note :: findBy only used for SELECT Query not used for Non Select Query 
	//******************************************************************************************************
	//SELECT * FROM Product WHERE code = ?
	List<Product> findByCode(String productCode);
	//SELECT * FROM Product WHERE price < ?
	List<Product> findByPriceLessThan(BigDecimal inputPrice);
	//SELECT * FROM Product WHERE shortDesc LIKE %?%
	List<Product> findByShortDescContaining(String instr);
	//SELECT * FROM Product WHERE LOWER(shortDesc) = LOWER(?) =>here based on the search it will generate to UPPER OR LOWER
	List<Product> findByShortDescIgnoreCase(String instr);
	//SELECT * FROM Product WHERE code = ? AND price = ?
	List<Product> findByCodeAndPrice(String pCode, BigDecimal inPrice);
	//******************************************************************************************************
	/*******
	 * 
	 *  projection concept -> instead of fetching all coloums only fetch required coloums
	 *  two types of projections -> [1] static projection  [2] dynamic projection   
	 */
	//******************************************************************************************************
	
	interface A {
		String getCode();
		String getShortDesc();
		
		default String getString(){
			return getCode()+"-"+getShortDesc();
		}
	}
	interface B {
		String getShortDesc();
		String getLongDesc();
		default String getString(){
			return getShortDesc()+"-"+getLongDesc();
		}
	}

	/****
	 * SELECT code, shortDesc FROM Product WHERE price = ?
	 * static projection
	 */
	List<A> findByPrice(BigDecimal inputPrice);
	
	/****
	 * SELECT code, shortDesc FROM Product WHERE price = ?
	 * dynamic projection
	 */
	<T> List<T> findByCode(String inCode, Class<T> cls);

	//******************************************************************************************************************
	// CustomQuery using Query
	//******************************************************************************************************************
	// single row return 
	@Query("SELECT p from Product p WHERE p.id=:pid")
	Product getProductDtls(int pid);
	
	@Query("SELECT p.shortDesc from Product p WHERE p.id=:pid")
	String getOneFieldDetailOfProduct(int pid);
	
	//Internally Object[] but upcasted to Object to return as one value
	@Query("SELECT p.id, p.price from Product p WHERE p.id=:pid")
	Object getMoreThanOneFieldDtlsOfProduct(int pid); 
	
	
	
}
