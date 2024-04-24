package com.haullog.haullog.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.haullog.haullog.models.User;
import com.haullog.haullog.service.UserService;

@RestController
public class LoginSignUpController {
	
	private final UserService userService;
	
	public LoginSignUpController(UserService userService) {
		this.userService = userService;
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
	
	@PostMapping("/signup")
	public ResponseEntity<String> signUp(@RequestBody User newUser) {
		if(userService.createNewUser(newUser)) {
			System.out.println("User " + newUser.getFirstName() + ", " + newUser.getLastName() + " from company " + newUser.getCompanyName() + " created");
			return ResponseEntity.ok("User created successfully");
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error occurred during user creation");
		}
    }
}
