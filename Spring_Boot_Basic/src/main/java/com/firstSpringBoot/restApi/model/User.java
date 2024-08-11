package com.firstSpringBoot.restApi.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity( name = "user_details" )
//@JsonIgnoreProperties({"user_name","birthdate"})
//@JsonFilter("All_User_Filter")
public class User {

	@Id
	@GeneratedValue
	private Integer id;
	
	/**
	 *  Works after adding a tag of @Valid in the User Resource File
	 *  You can add n number of validations when checked in the documentations
	 *  Add a message so that when the message is returned it can show the error at receiver end
	 */
	
	
	/**	Static Filtering
	 * 
	 *  @JsonProperty("user_name") used to give a user defined property name for the variable
	 *  By default, property name used in the Class file is return in the response
	 *  
	 *  @JsonIgnore is used to remove the field from the json response
	 *  This type of filtering is referred to as Static Filtering
	 *  This tag works at entity level
	 *  
	 *  @JsonIgnoreProperties works same as @JsonIgnore but used at class level
	 *  Note that in case @JsonProperty is used to alter the entity name,
	 *  same name has to used with @JsonIgnoreProperties for the filter to work
	 *  Multiple entity can be configured using comma as a separator
	 *  Pass the entity names using {} brackets
	 *  
	 *  here e.g. name is the entity name but user_name has to be used with @JsonIgnoreProperties
	 *  for the filter to work as desired
	 *  
	 */
	
	/** Dynamic filtering - Different JSON structure for different APIs
	 * 	
	 * 	Check the controller code since the filters as to be at APIS level
	 */
	@Size(min = 2, message = "Name should have atleast 2 characters.")
	@JsonProperty("user_name")
	private String name;
	
	@Past(message = "Invalid birthdate : Here date has to be in past.")
//	@JsonIgnore
	private LocalDate birthdate;
	
	/**
	 * A user can have many posts, hence one to many mapping is used.
	 * This relation is mapped by the variable defined in the post i.e. user
	 */
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Post> posts;
	
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
	public LocalDate getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}
	public List<Post> getPosts() {
		return posts;
	}
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	public User(Integer id, String name, LocalDate birthdate) {
		super();
		this.id = id;
		this.name = name;
		this.birthdate = birthdate;
	}
	
	public User() {}
}
