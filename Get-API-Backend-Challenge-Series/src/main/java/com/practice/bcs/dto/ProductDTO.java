package com.practice.bcs.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {
	
	private Long productId;
	private String title;
	private String description;
	private String short_description;
	private double price;
	private String live;
	private boolean outOfStock;

}
