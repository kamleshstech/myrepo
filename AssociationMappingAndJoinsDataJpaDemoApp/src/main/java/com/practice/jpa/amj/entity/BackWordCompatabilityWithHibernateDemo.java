package com.practice.jpa.amj.entity;

import java.util.Arrays;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@NamedQuery(
		name = "BackWordCompatabilityWithHibernateDemo.getDtls", 
		query = "SELECT name FROM BackWordCompatabilityWithHibernateDemo WHERE id=:b_id"
		)
public class BackWordCompatabilityWithHibernateDemo {

	@Id
	private int id;
	private String name;
//********************************	
	@Lob // BLOB
	private byte[] img;

	@Lob // CLOB
	private char[] data;

//*******************************
	@Temporal(TemporalType.DATE) //2025-04-24  
	private Date dtA;
	@Temporal(TemporalType.TIME) //16:53:11.220000  
	private Date dtB;
	@Temporal(TemporalType.TIMESTAMP) //2025-04-24 16:53:11.220000
	private Date dtC;
//******************************
	
	
	public BackWordCompatabilityWithHibernateDemo() {
		super();
	}


	public BackWordCompatabilityWithHibernateDemo(int id, String name, byte[] img, char[] data, Date dtA, Date dtB,
			Date dtC) {
		super();
		this.id = id;
		this.name = name;
		this.img = img;
		this.data = data;
		this.dtA = dtA;
		this.dtB = dtB;
		this.dtC = dtC;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}

	public char[] getData() {
		return data;
	}

	public void setData(char[] data) {
		this.data = data;
	}
	public Date getDtA() {
		return dtA;
	}

	public void setDtA(Date dtA) {
		this.dtA = dtA;
	}

	public Date getDtB() {
		return dtB;
	}

	public void setDtB(Date dtB) {
		this.dtB = dtB;
	}

	public Date getDtC() {
		return dtC;
	}

	public void setDtC(Date dtC) {
		this.dtC = dtC;
	}

	@Override
	public String toString() {
		return "BackWordCompatabilityWithHibernateDemo [id=" + id + ", name=" + name + ", img=" + Arrays.toString(img)
				+ ", data=" + Arrays.toString(data) + "]";
	}

}
