package com.yintai.entity;

public class Customer {
	private int id;
	private String customerName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	@Override
	public int hashCode() {
		return customerName.hashCode()+id;
	}
	
}
