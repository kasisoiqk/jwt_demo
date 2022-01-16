package com.hocspringboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hocspringboot.model.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String name);
	Boolean existsByUsername(String username);
	Boolean existsByEmail(String email);
}