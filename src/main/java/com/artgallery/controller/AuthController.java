package com.artgallery.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.artgallery.entity.User;
import com.artgallery.service.UserService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@RequestBody User user) {
		return ResponseEntity.ok(userService.register(user));
	}

	@PostMapping("/login")
	public ResponseEntity<Map<String, String>> login(@RequestBody User user) {
	    boolean isValid = userService.login(user.getUsername(), user.getPassword());

	    Map<String, String> response = new HashMap<>();

	    if (isValid) {
	        response.put("token", "dummy-token-" + user.getUsername()); // No actual JWT needed
	        return ResponseEntity.ok().body(response);
	    } else {
	        response.put("error", "Invalid user");
	        return ResponseEntity.status(401).body(response);
	    }
	}

}

