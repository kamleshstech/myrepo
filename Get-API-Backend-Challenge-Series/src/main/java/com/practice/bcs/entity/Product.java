package com.practice.bcs.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(
		name = "product_bcs_tbl",
		indexes = {
				@Index(name="idx_product_price",columnList = "price"),
				@Index(name="idx_product_tittle",columnList = "tittle")
		}
)
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;
	private String title;
	private String description;
	private String short_description;
	private double price;
	private String live;
	private boolean outOfStock;
	@OneToOne(
			fetch = FetchType.LAZY,
			cascade = CascadeType.ALL,//Controls what happens to child when parent changes
			orphanRemoval = true//If the child is no longer referenced → delete it from DB
			)
	@JoinColumn
	private MetaData image;
}
