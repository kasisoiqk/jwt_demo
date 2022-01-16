package com.hocspringboot.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hocspringboot.model.Role;
import com.hocspringboot.model.RoleName;
import com.hocspringboot.repository.IRoleRepository;
import com.hocspringboot.service.IRoleService;

@Service
public class RoleServiceImpl implements IRoleService {
	
	@Autowired
	IRoleRepository roleRepository;

	@Override
	public Optional<Role> findByName(RoleName admin) {
		return roleRepository.findByName(admin);
	}

}
