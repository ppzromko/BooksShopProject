package com.roma.mapper;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import com.roma.domain.RegisterRequest;
import com.roma.entity.UserEntity;
import com.roma.entity.enumeration.Role;

public interface UserMapper {

	public static User toSecurityUser(UserEntity entity) {
		return new User(entity.getEmail(), entity.getPassword(), AuthorityUtils.createAuthorityList(String.valueOf(entity.getRole())));
	}
	
	public static UserEntity registertoEntity(RegisterRequest request) {
		
		UserEntity entity = new UserEntity();
		entity.setEmail(request.getEmail());
		entity.setPassword(request.getPassword());
		entity.setRole(Role.ROLE_USER);
		return entity;
	}
	
}
