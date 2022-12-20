package com.example.demo.location;

public class Location {
	 private Integer id;
	   private String name;
	public Location(Integer string, String string2) {
		id=string;
		name=string2;
	}
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
}
