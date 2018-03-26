package com.roma.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="books" )
public class BooksEntity extends BaseEntity {
	
	@Column(name="detective")
	private String detective;
	@Column(name="adventure")
	private String adventure;
	@Column(name="romance")
	private String romance;
	@Column(name="fantasy")
	private String fantasy;
	@Column(name="history")
	private String history;
	
	public BooksEntity() {
		
	}

	public String getDetective() {
		return detective;
	}

	public void setDetective(String detective) {
		this.detective = detective;
	}

	public String getAdventure() {
		return adventure;
	}

	public void setAdventure(String adventure) {
		this.adventure = adventure;
	}

	public String getRomance() {
		return romance;
	}

	public void setRomance(String romance) {
		this.romance = romance;
	}

	public String getFantasy() {
		return fantasy;
	}

	public void setFantasy(String fantasy) {
		this.fantasy = fantasy;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}
	
	
	
}
