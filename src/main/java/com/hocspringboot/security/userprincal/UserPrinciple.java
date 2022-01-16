package com.hocspringboot.security.userprincal;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hocspringboot.model.User;

public class UserPrinciple implements UserDetails {
	
	private Long id;
	private String name;
	private String username;
	@JsonIgnore
	private String password;
	private String email;
	private String avatar;
	private Collection<? extends GrantedAuthority> roles;

	public UserPrinciple() {
		super();
	}

	public UserPrinciple(Long id, String name, String username, String password, String email, String avatar,
			Collection<? extends GrantedAuthority> roles) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.avatar = avatar;
		this.roles = roles;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public static UserPrinciple build(User user) {
		List<GrantedAuthority> authorities = user.getRoles().stream().map(role->
					new SimpleGrantedAuthority(role.getName().name())).collect(Collectors.toList());
		return new UserPrinciple(
				user.getId(),
				user.getName(),
				user.getUsername(),
				user.getPassword(),
				user.getEmail(),
				user.getAvatar(),
				authorities
		);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
