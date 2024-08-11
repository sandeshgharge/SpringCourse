package com.firstSpringBoot.restApi.model;

import java.time.LocalDate;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Post {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	
	private String description;
	
	/**
	 * Here multiple posts can belong to a user, hence the usage of Many to one
	 * 
	 * FetchType.Eager -> Along with post details, user details are also fetched.
	 * FetchType.Lazy -> Along with post details, user details are not fetched.
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnore
	private User user;

	public Post() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	
	
	
}
