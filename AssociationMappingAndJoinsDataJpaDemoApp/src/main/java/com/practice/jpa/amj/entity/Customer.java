package com.practice.jpa.amj.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Customer {
	@Id
	private int cid;
	private String cname;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "cust_id")
	private List<Offer> offers;

	public Customer() {
		super();
	}

	public Customer(int cid, String cname, List<Offer> offers) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.offers = offers;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public List<Offer> getOffers() {
		return offers;
	}

	public void setOffers(List<Offer> offers) {
		this.offers = offers;
	}
	
}
