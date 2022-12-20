package com.example.demo.post;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.User.User;
import com.example.demo.location.Location;

@RestController
public class PostController {
	@Autowired
	private PostService posts;
	
		@RequestMapping("posts")
		   public List<Post> getAllPosts() {
			
			   return posts.getAllPosts();
		

		}
		@RequestMapping(value = "/posts/{id}")
		public Post getPost(@PathVariable Integer id) {
		    return posts.getPost( id);
		}
		
		@RequestMapping( value="/posts",method=RequestMethod.POST)
		public void addPosts(@RequestBody Post post) {
			posts.addLocation(post);
		}
		@RequestMapping(value="/posts/{id}", method = RequestMethod.PUT)
		public void updatePost(@PathVariable Integer id, @RequestBody Post post) {

		      posts.updatePost(id, post);

		}
		
		@RequestMapping(value="/posts/{id}", method = RequestMethod.DELETE)
		public void deletePost(@PathVariable Integer id) {

		      posts.deletePost(id);

		}
	 }
