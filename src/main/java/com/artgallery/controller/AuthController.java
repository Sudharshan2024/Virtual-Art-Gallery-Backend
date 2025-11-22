package com.artgallery.controller;

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
	public ResponseEntity<String> login(@RequestBody User user) {
		boolean isValid = userService.login(user.getUsername(), user.getPassword());
		return isValid ? ResponseEntity.ok("SUCCESS") : ResponseEntity.status(401).body("INVALID");
	}
}

