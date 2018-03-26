package com.roma.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roma.entity.BooksEntity;

public interface BooksRepository extends JpaRepository<BooksEntity, Integer> {
	
	
	
}
