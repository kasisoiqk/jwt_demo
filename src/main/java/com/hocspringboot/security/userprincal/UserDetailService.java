package com.hocspringboot.security.userprincal;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hocspringboot.model.User;
import com.hocspringboot.repository.IUserRepository;

@Service
public class UserDetailService implements UserDetailsService {
	
	@Autowired
	IUserRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username).orElseThrow(()-> 
					new UsernameNotFoundException("User not found -> username or password" + username));
		return UserPrinciple.build(user);
	}

}
