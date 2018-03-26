package com.roma.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class BooksEntity extends BaseEntity {

	@Column(name = "name")
	private String name;
	
	@Column(name = "genre")
	private String genre;
	
	@Column(name = "price")
	private int price;
	
	@Column(name = "description")
	private String description;

	public BooksEntity() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
