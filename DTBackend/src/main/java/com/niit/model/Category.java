package com.niit.model;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import org.springframework.stereotype.Component;

@Entity
@Component

public class Category implements Serializable
{
	private static final long serialVersionUID = 1882722053275760553L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Cid;
	private String CatName, CatDescription;
	public int getCid() {
		return Cid;
	}
	public void setCid(int cid) {
		Cid = cid;
	}
	public String getCatName() {
		return CatName;
	}
	public void setCatName(String catName) {
		CatName = catName;
	}
	public String getCatDescription() {
		return CatDescription;
	}
	public void setCatDescription(String catDescription) {
		CatDescription = catDescription;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}	
}
