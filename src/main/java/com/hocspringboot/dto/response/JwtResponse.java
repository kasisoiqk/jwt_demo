package com.hocspringboot.dto.response;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class JwtResponse {
	private Long id;
	private String token;
	private String type = "Bearer";
	private String name;
	private Collection<? extends GrantedAuthority> roles;
	public JwtResponse(String token, String name, Collection<? extends GrantedAuthority> collection) {
		this.token = token;
		this.name = name;
		this.roles = collection;
	}
	public JwtResponse(Long id, String token, String type, String name, Collection<? extends GrantedAuthority> roles) {
		super();
		this.id = id;
		this.token = token;
		this.type = type;
		this.name = name;
		this.roles = roles;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Collection<? extends GrantedAuthority> getRoles() {
		return roles;
	}
	public void setRoles(Collection<? extends GrantedAuthority> roles) {
		this.roles = roles;
	}
}
