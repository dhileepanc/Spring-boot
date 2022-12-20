package com.example.demo.User;

import com.example.demo.location.Location;

public class User {
	  private Integer id;
	    private String firstname;
	    private String lastname;
	    private Location location;
	    private String email;
		public User(Integer string, String string2, String string3, Location location2, String string4) {
			id=string;
			firstname=string2;
			lastname=string3;
			location=location2;
			email=string4;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getFirstname() {
			return firstname;
		}
		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}
		public String getLastname() {
			return lastname;
		}
		public void setLastname(String lastname) {
			this.lastname = lastname;
		}
		public Location getLocation() {
			return location;
		}
		public void setLocation(Location location) {
			this.location = location;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}

}
