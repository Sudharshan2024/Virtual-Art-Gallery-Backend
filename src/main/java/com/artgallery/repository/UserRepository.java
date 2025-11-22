package com.artgallery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.artgallery.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}

