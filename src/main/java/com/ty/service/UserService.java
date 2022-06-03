package com.ty.service;

import com.ty.dao.UserDao;
import com.ty.dto.UserDto;

public class UserService {
	UserDao userDao = new  UserDao();
	public UserDto saveUser(UserDto userDto) {
		return userDao.saveUser(userDto);
	}
	
	public UserDto validateUser(String email, String password) {
		return userDao.validateUser(email, password);
	}
}
