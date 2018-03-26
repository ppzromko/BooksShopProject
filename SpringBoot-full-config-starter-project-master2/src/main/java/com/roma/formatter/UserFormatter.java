package com.roma.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import com.roma.entity.UserEntity;

@Component
public class UserFormatter implements Formatter<UserEntity> {

	@Override
	public UserEntity parse(String text, Locale locale) throws ParseException {
		UserEntity entity = new UserEntity();
		entity.setId(Integer.valueOf(text));
		return entity;
	}

	@Override
	public String print(UserEntity object, Locale locale) {
		return String.valueOf(object.getId());
	}

}
