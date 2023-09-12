package com.prog.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



@Entity
public class Property implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

private int id;
	
	private String name;
	private String picture;
	private Long price;
	private String landmark;
	private String description;
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
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Property(int id, String name, String picture, String location, Long price, String description) {
		super();
		this.id = id;
		this.name = name;
		this.picture = picture;
	
		this.price = price;
		this.description = description;
	}
	public Property() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Property [id=" + id + ", name=" + name + ", picture=" + picture + ",  price="
				+ price + ", landmark=" + landmark + ", description=" + description + "]";
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	
}
