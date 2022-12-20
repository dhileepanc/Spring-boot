package com.example.demo.User;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.location.Location;

@RestController
public class UserController {
	
	@Autowired
	private UserService uservice;
	
	@RequestMapping("users")
	public List<User> getAllUser()
	{
		return uservice.getAllUser();
	}
	
	@RequestMapping("/users/{id}")
	public User getUser(@PathVariable Integer id)
	{
		return uservice.getUser(id);
	}
	@RequestMapping( value="/users",method=RequestMethod.POST)
	public void addUser(@RequestBody User user) {
		 uservice.addUser(user);
	}
	@RequestMapping(value="/users/{id}", method = RequestMethod.PUT)
	public void updateUser(@PathVariable Integer id, @RequestBody User user) {

	    uservice.updateUser(id, user);

	}
	
	@RequestMapping(value="/users/{id}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable Integer id) {

	    uservice.deleteUser(id);

	}
	
	
}
