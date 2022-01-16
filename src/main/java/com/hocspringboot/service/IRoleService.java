package com.hocspringboot.service;

import java.util.Optional;

import com.hocspringboot.model.Role;
import com.hocspringboot.model.RoleName;

public interface IRoleService {
	Optional<Role> findByName(RoleName name);
}
