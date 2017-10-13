package com.niit.model;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import org.springframework.stereotype.Component;

@Entity
@Component
public class Product1 implements Serializable
{	
	
	private static final long serialVersionUID = 5186013952828648626L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private int quantity;
	private double price;
	private String p_category;
	
	public String getName() {
		return name;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getName(String name) {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getP_category() {
		return p_category;
	}
	public void setP_category(String p_category) {
		this.p_category = p_category;
	}
	
	
	
	
	/*public Product1(int id,String name,int quantity,double price)
	{
		super();
		this.id=id;
		this.name=name;
		this.quantity=quantity;
		this.price=price;
	}*/
}
