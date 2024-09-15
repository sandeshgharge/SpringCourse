package com.example.rabbittmq.dto;

public class UserDetails {

	private int id;
	private String firstname;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public UserDetails(int id, String firstname) {
		super();
		this.id = id;
		this.firstname = firstname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	
	
	
}
