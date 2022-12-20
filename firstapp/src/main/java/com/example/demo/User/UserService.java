package com.example.demo.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.location.Location;

@Service
public class UserService {
	
	User user1 = new User(
			1, 
			"Jany", 
			"Lawrence",
			new Location(1,"Lagos"),
			"Jany@gmail.com");
			
		User user2 = new User(
			2, 
			"Jadon", 
			"Mills",
			new Location(2,"Asaba"),
			"Jadon@gmail.com");
		List<User> users=new ArrayList<>(Arrays.asList(user1, user2)) ;
	
	public List<User> getAllUser()
	{
		return users;
	}
	public User getUser(Integer id)
	{
		User user=users.stream()
				.filter(t ->id.equals(t.getId()))
				.findFirst()
				.orElse(null);
		return user;
		
	}
	public void addUser(User user) {

		users.add(user);
	}
	public void updateUser(Integer id, User user) {

		 for(int i = 0; i < users.size(); i++) {

				User u = users.get(i);

				if(u.getId().equals(id)) {

				     users.set(i, user);

				     return;
				}
			    }
	}
	public void deleteUser(Integer id) {

		users.removeIf(u ->u.getId().equals(id));
	}


}
