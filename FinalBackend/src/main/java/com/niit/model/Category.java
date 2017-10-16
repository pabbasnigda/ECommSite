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
	private static final long serialVersionUID = 4218574769663755268L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int category_id;
	private String category_Name,category_Description;


public int getCategory_id() {
	return category_id;
}
public void setCategory_id(int category_id) {
	this.category_id = category_id;
}
public String getCategory_Name() {
	return category_Name;
}
public void setCategory_Name(String category_Name) {
	this.category_Name = category_Name;
}
public String getCategory_Description() {
	return category_Description;
}
public void setCategory_Description(String category_Description) {
	this.category_Description = category_Description;
}

}
