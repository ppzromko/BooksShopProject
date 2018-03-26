package com.roma.service;

import java.util.List;

import com.roma.entity.BooksEntity;


public interface BooksService {

	void saveBook(BooksEntity booksEntity);

	List<BooksEntity> findAllBook();
	
	BooksEntity findBooksById(int id);
}
