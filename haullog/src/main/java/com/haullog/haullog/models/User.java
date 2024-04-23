package com.haullog.haullog.models;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
	@Id()
	private long Id;
	
	private String email;

	private String password;
	

	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}
}
