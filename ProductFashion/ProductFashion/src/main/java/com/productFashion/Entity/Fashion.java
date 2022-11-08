package com.productFashion.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Fashion {


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long productId;
	private String productname;
	private long sellerId;
	private int price;
	public Fashion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Fashion(long productId, String productname, long sellerId, int price) {
		super();
		this.productId = productId;
		this.productname = productname;
		this.sellerId = sellerId;
		this.price = price;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public long getSellerId() {
		return sellerId;
	}
	public void setSellerId(long sellerId) {
		this.sellerId = sellerId;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
