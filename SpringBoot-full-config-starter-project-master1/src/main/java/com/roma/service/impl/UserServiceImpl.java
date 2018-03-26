package com.roma.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.roma.domain.mail.Mail;
import com.roma.entity.UserEntity;
import com.roma.repository.UserRepository;
import com.roma.service.EmailService;
import com.roma.service.UserService;
import com.roma.service.utils.CustomFileUtils;
import com.roma.service.utils.TokenGenerator;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired private UserRepository userRepository;
	@Autowired private PasswordEncoder passwordEncoder;
	@Autowired private EmailService emailService;
	
	
	@Override
	@Transactional
	public void saveUser(UserEntity entity) {
		String password = entity.getPassword();
		entity.setPassword(passwordEncoder.encode(password));
		
		String token = TokenGenerator.generate(100);
		entity.setToken(token);
		entity.setActivated(false);
		
		
		
		userRepository.save(entity);
		CustomFileUtils.createFolder("user_" + entity.getId());
		sendEmail(token , entity);
		
	}
	
	private void sendEmail(String token, UserEntity entity) {
		String domain = "http://localhost:8090";
		Mail mail = new Mail();
		mail.setTo(entity.getEmail());
		mail.setSubject("You are successfully registred");
		mail.setContent("Please verify your email by this link:"
				+ domain +"/verify?token=" + token
				+ "&userid=" + entity.getId());
		emailService.sendMessage(mail);
	}
	
	
	
	@Override
	public void updateUser(UserEntity entity) {
		
		userRepository.save(entity);
		
	}
	
	@Override
	public UserEntity findUserById(int id) {
		return userRepository.findOne(id);
	}

	@Override
	public UserEntity findUserByEmail(String email) {
		return userRepository.findUserByEmail(email);
	}

	@Override
	public List<UserEntity> findAllUsers() {

		return userRepository.findAll();
	}

	

}
