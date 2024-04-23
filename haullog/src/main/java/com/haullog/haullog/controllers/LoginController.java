package com.haullog.haullog.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.haullog.haullog.models.User;
import com.haullog.haullog.service.UserService;

@RestController
public class LoginController {
	
	private final UserService userService;
	
	public LoginController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/login")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        		
        return userService.getUserByUsername(username)
        		.map(searchedUser -> {
        			if(password.equals(searchedUser.getPassword())) {
        				System.out.println(searchedUser.getUsername() + " logged in");
        				return ResponseEntity.ok("Login successful");
        			} else {
        				throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid username or password");
        			}
        		})
        		.orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not found"));
    }
}
