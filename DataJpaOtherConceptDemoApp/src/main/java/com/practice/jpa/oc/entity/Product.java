package com.practice.jpa.oc.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PRODUCT")
public class Product {
	@Id
	private int id;
	private String code;
	private String shortDesc;
	private String longDesc;
	private BigDecimal price;

	public Product() {
		super();
	}

	public Product(int id, String code, String shortDesc, String longDesc, BigDecimal price) {
		super();
		this.id = id;
		this.code = code;
		this.shortDesc = shortDesc;
		this.longDesc = longDesc;
		this.price = price;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getShortDesc() {
		return shortDesc;
	}
	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}
	public String getLongDesc() {
		return longDesc;
	}
	public void setLongDesc(String longDesc) {
		this.longDesc = longDesc;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", code=" + code + ", shortDesc=" + shortDesc + ", longDesc=" + longDesc
				+ ", price=" + price + "]";
	}
	
}
