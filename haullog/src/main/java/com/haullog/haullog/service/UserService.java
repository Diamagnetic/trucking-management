package com.haullog.haullog.service;

import java.util.List;
import java.util.Optional;

import com.haullog.haullog.models.User;

public interface UserService {
	
	Optional<User> getUserByUsername(String name);
	
	List<User> getAllUsers();
}
