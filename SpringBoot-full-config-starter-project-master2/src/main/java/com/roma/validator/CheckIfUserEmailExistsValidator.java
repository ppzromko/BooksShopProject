package com.roma.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.roma.entity.UserEntity;
import com.roma.service.UserService;

@Component
public class CheckIfUserEmailExistsValidator implements ConstraintValidator<CheckIfUserEmailExists, String> {

	@Autowired private UserService userService;
	
	
	
	@Override
	public void initialize(CheckIfUserEmailExists constraintAnnotation) {
		
		
	}

	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		UserEntity user = userService.findUserByEmail(email);

		if(user == null) {
			return true;
		}else {
			return false;
		}
		
	}
	
	
	
}
