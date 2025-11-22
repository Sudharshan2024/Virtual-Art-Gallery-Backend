package com.artgallery.service;

import com.artgallery.entity.User;

public interface UserService {
	User register(User user);
	boolean login(String username, String password);
}

