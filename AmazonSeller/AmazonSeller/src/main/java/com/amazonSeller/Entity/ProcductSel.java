package com.amazonSeller.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ProcductSel {

	private long productId;
	private String productname;
	private long sellerId;
	private int price;
	private String type;
	public ProcductSel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProcductSel(long productId, String productname, long sellerId, int price, String type) {
		super();
		this.productId = productId;
		this.productname = productname;
		this.sellerId = sellerId;
		this.price = price;
		this.type = type;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	

}
