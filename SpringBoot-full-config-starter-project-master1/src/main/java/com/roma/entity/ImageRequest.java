package com.roma.entity;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
@Data
public class ImageRequest {
	
	private MultipartFile file;
	
	

	public ImageRequest() {
		
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
}
