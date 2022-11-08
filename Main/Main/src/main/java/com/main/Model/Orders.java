package com.main.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class Orders {
	
	
	private long orderId;
	private long cusId;
	private long sellerId;
	private long productId;
	private String status;
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Orders(long orderId, long cusId, long sellerId, long productId, String status) {
		super();
		this.orderId = orderId;
		this.cusId = cusId;
		this.sellerId = sellerId;
		this.productId = productId;
		this.status = status;
	}
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public long getCusId() {
		return cusId;
	}
	public void setCusId(long cusId) {
		this.cusId = cusId;
	}
	public long getSellerId() {
		return sellerId;
	}
	public void setSellerId(long sellerId) {
		this.sellerId = sellerId;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", cusId=" + cusId + ", sellerId=" + sellerId + ", productId=" + productId
				+ ", status=" + status + "]";
	}
	
	

}
