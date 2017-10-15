package com.niit.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="Supplier")
public class Supplier implements Serializable
{
	private static final long serialVersionUID = 5186013952828648626L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int SupId;
	private String SupName;
	
	public int getSupId() {
		return SupId;
	}
	public void setSupId(int supId) {
		SupId = supId;
	}
	public String getSupName() {
		return SupName;
	}
	public void setSupName(String supName) {
		SupName = supName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}	
}
