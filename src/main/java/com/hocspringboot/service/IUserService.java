package com.hocspringboot.service;

import java.util.Optional;

import com.hocspringboot.model.User;

public interface IUserService {
	Optional<User> findByUsername(String name);
	Boolean existsByUsername(String username);
	Boolean existsByEmail(String email);
	User save(User user);
}
