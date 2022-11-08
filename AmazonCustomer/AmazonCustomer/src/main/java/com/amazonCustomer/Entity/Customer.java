package com.amazonCustomer.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long cusId;
	private String cusName;
	private String cusPass;
	private String Address;
	private String ph;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(Long cusId, String cusName, String cusPass, String address, String ph) {
		super();
		this.cusId = cusId;
		this.cusName = cusName;
		this.cusPass = cusPass;
		Address = address;
		this.ph = ph;
	}
	public Long getCusId() {
		return cusId;
	}
	public void setCusId(Long cusId) {
		this.cusId = cusId;
	}
	public String getCusName() {
		return cusName;
	}
	public void setCusName(String cusName) {
		this.cusName = cusName;
	}
	public String getCusPass() {
		return cusPass;
	}
	public void setCusPass(String cusPass) {
		this.cusPass = cusPass;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getPh() {
		return ph;
	}
	public void setPh(String ph) {
		this.ph = ph;
	}
	
}
