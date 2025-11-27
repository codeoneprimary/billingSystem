package com.billing.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.billing.system.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);
}