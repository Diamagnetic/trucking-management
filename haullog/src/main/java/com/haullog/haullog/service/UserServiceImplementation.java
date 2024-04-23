package com.haullog.haullog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haullog.haullog.repository.UserRepository;
import com.haullog.haullog.models.User;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService {
	

	@Autowired
    private final UserRepository userRepository;
	
	public UserServiceImplementation(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public Optional<User> getUserByUsername(String username) {
		return userRepository.findById(username);
	}
	
	@Override
	public List<User> getAllUsers() {
		return (List<User>) userRepository.findAll();
	}
}
