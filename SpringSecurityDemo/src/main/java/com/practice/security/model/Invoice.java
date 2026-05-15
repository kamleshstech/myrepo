package com.practice.security.model;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Invoice {
	@Id
	private Integer id;
	private String invNum;
	private String details;
	private Double totalCost;
}
