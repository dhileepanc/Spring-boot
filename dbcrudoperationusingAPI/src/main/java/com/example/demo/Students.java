package com.example.demo;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

@Entity
public class Students {
	
	@jakarta.persistence.Id
	@GeneratedValue
	private Integer id;
	private String name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Students(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Students() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
