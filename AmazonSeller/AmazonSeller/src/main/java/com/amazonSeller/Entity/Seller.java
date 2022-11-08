package com.amazonSeller.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Seller {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long sellerId;
	private String sellerName;
	private String sellerAddress;
	private String sellerph;
	private String pass;
	public Seller() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Seller(Long sellerId, String sellerName, String sellerAddress, String sellerph, String pass) {
		super();
		this.sellerId = sellerId;
		this.sellerName = sellerName;
		this.sellerAddress = sellerAddress;
		this.sellerph = sellerph;
		this.pass = pass;
	}
	public Long getSellerId() {
		return sellerId;
	}
	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	public String getSellerAddress() {
		return sellerAddress;
	}
	public void setSellerAddress(String sellerAddress) {
		this.sellerAddress = sellerAddress;
	}
	public String getSellerph() {
		return sellerph;
	}
	public void setSellerph(String sellerph) {
		this.sellerph = sellerph;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
		
}
