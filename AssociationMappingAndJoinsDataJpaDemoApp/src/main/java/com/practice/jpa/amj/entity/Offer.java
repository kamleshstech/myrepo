package com.practice.jpa.amj.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Offer {
	
	@Id
	private int offId;
	private String OffDesc;
	private String vendorDtls;
	
	public Offer() {
		super();
	}
	
	public Offer(int offId, String offDesc, String vendorDtls) {
		super();
		this.offId = offId;
		OffDesc = offDesc;
		this.vendorDtls = vendorDtls;
	}

	public int getOffId() {
		return offId;
	}

	public void setOffId(int offId) {
		this.offId = offId;
	}

	public String getOffDesc() {
		return OffDesc;
	}

	public void setOffDesc(String offDesc) {
		OffDesc = offDesc;
	}

	public String getVendorDtls() {
		return vendorDtls;
	}

	public void setVendorDtls(String vendorDtls) {
		this.vendorDtls = vendorDtls;
	}

}
