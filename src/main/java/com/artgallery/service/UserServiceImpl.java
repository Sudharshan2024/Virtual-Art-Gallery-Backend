package com.artgallery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.artgallery.entity.User;
import com.artgallery.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User register(User user) {
		return userRepository.save(user);
	}

	@Override
	public boolean login(String username, String password) {
		User storedUser = userRepository.findByUsername(username);
		return storedUser != null && storedUser.getPassword().equals(password);
	}
}