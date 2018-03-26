package com.roma.service;

import java.util.List;

import com.roma.entity.UserEntity;

public interface BooksService {

	void saveBook(UserEntity entity);
	
	UserEntity findBookByGenre(String genre);

	List<UserEntity> findAllBook();
}
