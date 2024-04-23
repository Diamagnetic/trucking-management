package com.haullog.haullog.models;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	private long id;
	
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String userType;
	

	public User(long id, String firstName, String lastName, String email, String password, String userType) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.userType = userType;
	}
	
	public String getPassword() {
		return password;
	}
}
