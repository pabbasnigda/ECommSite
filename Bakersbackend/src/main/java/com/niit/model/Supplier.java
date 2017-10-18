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
	private static final long serialVersionUID = 3216823736209703953L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int supplier_id;
	private String supplier_Name;
	public int getSupplier_id() {
		return supplier_id;
	}
	public void setSupplier_id(int supplier_id) {
		this.supplier_id = supplier_id;
	}
	public String getSupplier_Name() {
		return supplier_Name;
	}
	public void setSupplier_Name(String supplier_Name) {
		this.supplier_Name = supplier_Name;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}

