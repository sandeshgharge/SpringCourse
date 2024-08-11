package com.firstSpringBoot.restApi.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.firstSpringBoot.restApi.DAO.SpringDataJPA.PostSpringDataJPARepository;
import com.firstSpringBoot.restApi.DAO.SpringDataJPA.UserSpringDataJPARepository;
import com.firstSpringBoot.restApi.DAO.jpa.UserJPARepository;
import com.firstSpringBoot.restApi.exception.UserNotFoundException;
import com.firstSpringBoot.restApi.model.Post;
import com.firstSpringBoot.restApi.model.User;

import jakarta.validation.Valid;

@RestController
@RequestMapping("jpa")
public class UserJPAResource {
	
	private UserJPARepository userJpaRepo;
	private UserSpringDataJPARepository userSpringDataRepo;
	private PostSpringDataJPARepository postRepo;
	

	public UserJPAResource(UserJPARepository userJpaRepo, UserSpringDataJPARepository userSpringDataRepo, PostSpringDataJPARepository postRepo) {
		this.userSpringDataRepo = userSpringDataRepo;
		this.userJpaRepo = userJpaRepo;
		this.postRepo = postRepo;
	}
	
	@GetMapping("users")
	public List<User> findAll() {
		return this.userSpringDataRepo.findAll();
	}

	@RequestMapping(method = RequestMethod.POST, path = "adduser")
	public User addUser(@Valid @RequestBody User user) {
		return this.userJpaRepo.insert(user);
	}
	
	@GetMapping("user/{id}")
	public EntityModel<User> findById(@PathVariable int id) {
		Optional<User> u = this.userSpringDataRepo.findById((long) id);
		
		EntityModel<User> em = EntityModel.of(u.get());
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).findAll());
		em.add(link.withRel("all-users"));
		return em;
	}
	
	@DeleteMapping("user/{id}")
	public void deleteById(@PathVariable int id) {
		this.userJpaRepo.deleteById(id);
	}
	
	@GetMapping("user/{id}/posts")
	public List<Post> getUserPosts(@PathVariable int id) {
		
		Optional<User> u = this.userSpringDataRepo.findById((long) id); // ??
		
		EntityModel<User> em = EntityModel.of(u.get());
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).findAll());
		em.add(link.withRel("all-users"));
		
		return u.get().getPosts();
	}
	
	@PostMapping("user/{id}/post")
	public ResponseEntity<Object> saveUserPosts(@PathVariable int id, @Valid @RequestBody Post p) {
		
		User u = this.userJpaRepo.findById(id);
		
		if(u == null) {
			throw new UserNotFoundException("User does not exist with id : "+id);
		}
		p.setUser(u);
		Post newPost = this.postRepo.save(p);
		
		URI location = ServletUriComponentsBuilder
				.fromPath("/user")
				.path("/{i}/post")
				.buildAndExpand(newPost.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping("post/{id}")
	public List<Post> getPostsByUser(@PathVariable int id) {
		User u = this.userJpaRepo.findById(id);
		List<Post> p = this.postRepo.findByUser(u); // ??
		
		return p;
	}
	
	
}
