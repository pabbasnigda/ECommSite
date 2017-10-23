package com.niit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Cart 
{	
	@Column(name="cart_id")
	@Id
	@GeneratedValue
	private int id;
	private int productid;
	private String productName;
	private double ProductPrice;
	private int productQuantity;
	private double subTotal;
	private String status;
	private int userId;
	public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getProductid() {
	return productid;
}
public void setProductid(int productid) {
	this.productid = productid;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public double getProductPrice() {
	return ProductPrice;
}
public void setProductPrice(double productPrice) {
	ProductPrice = productPrice;
}
public int getProductQuantity() {
	return productQuantity;
}
public void setProductQuantity(int productQuantity) {
	this.productQuantity = productQuantity;
}
public double getSubTotal() {
	return subTotal;
}
public void setSubTotal(double subTotal) {
	this.subTotal = subTotal;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}

}