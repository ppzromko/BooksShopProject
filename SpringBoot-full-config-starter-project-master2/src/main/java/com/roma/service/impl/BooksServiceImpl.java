package com.roma.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roma.entity.BooksEntity;
import com.roma.repository.BooksRepository;
import com.roma.service.BooksService;
@Service
public class BooksServiceImpl implements BooksService{
	
	@Autowired private BooksRepository booksRepository;
	
	@Override
	public void saveBook(BooksEntity booksEntity) {
		booksRepository.save(booksEntity);
		
	}

	@Override
	public List<BooksEntity> findAllBook() {
	
		return booksRepository.findAll();
	}
	

	@Override
	public BooksEntity findBooksById(int id) {
		
		return booksRepository.findOne(id);
	}

	

	

}
