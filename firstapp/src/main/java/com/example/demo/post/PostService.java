package com.example.demo.post;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.User.User;
import com.example.demo.location.Location;

@Service
public class PostService {
	
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
				new Location(2, "Asaba"),
				"Jadon@gmail.com");
				
			   Post post1 = new Post(
				1,
				"01-Jan-19",
				user1,
				"Its good to love and be loved");
				
			   Post post2 = new Post(
				2,
				"02-Jan-19",
				user2,
				"We all need someone");

			   List<Post> posts=new ArrayList<>(Arrays.asList(post1, post2));
	
			   public List<Post> getAllPosts() {
		
		   return posts;
	

	}
			   public Post getPost(Integer id) {
			    	Post post = posts.stream()
					.filter(t -> id.equals(t.getId()))
					.findFirst()
					.orElse(null);
					
				return post;
			}
			public void addLocation(Post post) {

				posts.add(post);
			}
			public void updatePost(Integer id, Post post) {
				

				    for(int i = 0; i < posts.size(); i++) {

					Post p = posts.get(i);

					if(p.getId().equals(id)) {
						posts.set(i, post);
					     return;
					}
				    }
				

				
			}
			public void deletePost(Integer id) {
				
				posts.removeIf(p -> p.getId().equals(id));
			}

}
