package com.practice.multiple.db.h2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "order_tbl")
public class Order {
	@Id
	private Long id;
	private String product;

}
