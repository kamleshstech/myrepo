package com.practice.jpa.nsql.ns.entity;

import java.util.List;
import java.util.Map;
import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.OrderColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "ORDERTAB")
public class Order {
	@Id
	private int id;
	private String orderNumber;
	private String orderDate;
	private String orderBy;
	//****************************
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "MODES_TAB")//optional
	@Column(name = "mode")//optional
	@OrderColumn(name = "pos")//optional
	private List<String> modes;
	
	@ElementCollection(fetch = FetchType.EAGER)
	private Set<String> formats;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@MapKeyColumn(name = "demmo")
	private Map<String, String> data;
	//********************************

	public Order() {
		super();
	}
	
	public Order(int id, String orderNumber, String orderDate, String orderBy, List<String> modes, Set<String> formats,
			Map<String, String> data) {
		super();
		this.id = id;
		this.orderNumber = orderNumber;
		this.orderDate = orderDate;
		this.orderBy = orderBy;
		this.modes = modes;
		this.formats = formats;
		this.data = data;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
//***********************************************Collections**********************************
	public List<String> getModes() {
		return modes;
	}

	public void setModes(List<String> modes) {
		this.modes = modes;
	}

	public Set<String> getFormats() {
		return formats;
	}

	public void setFormats(Set<String> formats) {
		this.formats = formats;
	}

	public Map<String, String> getData() {
		return data;
	}

	public void setData(Map<String, String> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderNumber=" + orderNumber + ", orderDate=" + orderDate + ", orderBy=" + orderBy
				+ ", modes=" + modes + ", formats=" + formats + ", data=" + data + "]";
	}
	
}
