package com.roma.service;

import java.util.List;

import com.roma.entity.UserEntity;

public interface UserService {

	void saveUser(UserEntity entity);
	
	void updateUser(UserEntity entity);
	
	UserEntity findUserById(int id);
	
	UserEntity findUserByEmail(String email);
	
	List<UserEntity> findAllUsers();
}
