package com.firstSpringBoot.restApi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

// @Entity (name = "Table_Name")
@Entity
public class Course {
	
	@Id
	private long id;
	
	@Column(name = "Name")
	private String name;
	
	private String author;
	
	public Course() {
		// TODO Auto-generated constructor stub
	}
	public Course(long id, String name, String author) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	@Override
	public String toString() {
		return "Course : [id = " + id + ", Name = " + name + ", Author = " + author + "]";
	}

}
