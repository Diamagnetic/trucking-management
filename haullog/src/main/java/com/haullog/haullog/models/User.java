package com.haullog.haullog.models;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
	@Id
	@Column(name="email")
	private String username;

	@Column(name="password")
	private String password;
	
	public User() {
		
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
}
