package com.backend.project.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// entity file
@Entity
public class Product {
	@Id
	private int id;
	private String name;
	private String descc;
	private int price;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescc() {
		return descc;
	}
	public void setDescc(String descc) {
		this.descc = descc;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Product(int id, String name, String descc, int price) {
		super();
		this.id = id;
		this.name = name;
		this.descc = descc;
		this.price = price;
	}
	public Product() {
	}
	

}
