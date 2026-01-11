package com.agroexpress.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agroexpress.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	public User findByEmail(String username);
}


